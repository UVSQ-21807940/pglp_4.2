package uvsq21807940;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Classe MoteurRPN.
 */
public final class MoteurRPN  {
    
    public Map<String, CommandSpecial> operation;
    
    public Stack<Double> pile;
    
    private Undo undo;
    
    MoteurRPN(final Stack<Double> p, final Undo u) {
        this.operation = new HashMap<String, CommandSpecial>();
        this.pile = p;
        this.undo = u;
    }
    
    public void addCommand(final String nom, final CommandSpecial command) {
        this.operation.put(nom, command);
    }
    
    public void addOperande(final double op) {
        pile.push(op);
        undo.ajoutUndo();
    }
    
    public void executeCommand(final String nom) throws Exception {
        if (operation.containsKey(nom)) {
            if (pile.size() >= 2) {
                double op2 = pile.pop();
                double op1 = pile.pop();
                try {
                    pile.push(operation.get(nom).apply(op1, op2));
                    undo.ajoutUndo();
                } catch (Exception e) {
                    pile.push(op1);
                    pile.push(op2);
                    throw e;
                }
            } else {
                System.err.println("ajouter des operandes");
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }
    
    public static MoteurRPN init(final Stack<Double> pile, final Undo undo) {
        MoteurRPN m = new MoteurRPN(pile, undo);
        m.addCommand("+", new Addit());
        m.addCommand("-", new Soustra());
        m.addCommand("*", new Multi());
        m.addCommand("/", new Div());
        return m;
    }
}


