package uvsq21807940;
import java.util.Stack;

public class Undo implements CommandGeneral {
    
    private Stack<Double> pileInstant;
    
    private Stack<Stack<Double>> undo;
    
    public Undo(final Stack<Double> p) {
        this.pileInstant = p;
        undo = new Stack<Stack<Double>>();
    }
    
    @SuppressWarnings("unchecked")
    public void ajoutUndo() {
        Stack<Double> clone = (Stack<Double>) pileInstant.clone();
        undo.push(clone);
    }
   
    private void copieUndo() {
        for (double d : undo.lastElement()) {
        	pileInstant.push(d);
        }
    }
    
    public void apply() {
        if (!pileInstant.isEmpty()) {
            while (!pileInstant.isEmpty()) {
            	pileInstant.pop();
            }
            undo.pop();
            copieUndo();
        }
    }
}
