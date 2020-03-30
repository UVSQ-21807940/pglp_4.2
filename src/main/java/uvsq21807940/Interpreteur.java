package uvsq21807940;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {
    
    public Map<String, CommandGeneral> commands;
    
    private Interpreteur() {
        this.commands = new HashMap<String, CommandGeneral>();
    }
    
    public void addCommand(final String nom, final CommandGeneral com) {
        this.commands.put(nom, com);
    }
   
    public void executeCommand(final String nom) throws Exception {
        if (commands.containsKey(nom)) {
            commands.get(nom).apply();
        } else {
            throw new Exception();
        }
    }
   
    public static Interpreteur init(final Undo undo) {
        Interpreteur i = new Interpreteur();
        i.addCommand("undo", undo);
        i.addCommand("quit", new Quit());
        return i;
    }
}
