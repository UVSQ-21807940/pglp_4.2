package uvsq21807940;

import java.util.Scanner;
import java.util.Stack;

public class SaisieRPN {
    
    private Stack<Double> pile;
    
    private MoteurRPN oper;
    
    private Interpreteur interpreteur;
   
    private Scanner s;
    
    public SaisieRPN() {
        this.pile = new Stack<Double>();
        Undo undo = new Undo(pile);
        this.oper = MoteurRPN.init(pile, undo);
        this.interpreteur = Interpreteur.init(undo);
    }
   
    public Stack<Double> calcul() throws Exception {
        s = new Scanner(System.in);
        double d;
        boolean continuer = true;
        String entrer = "";
        while (continuer) {
            try {
                d = s.nextDouble();
                oper.addOperande(d);
            } catch (java.util.InputMismatchException e) {
                entrer = s.nextLine();
                try {
                    oper.executeCommand(entrer);
                } catch (Exception m) {
                    try {
                        interpreteur.executeCommand(
                                entrer);
                    } catch (Exception i) {
                        System.err.println(
                                "Commande impossible");
                    }
                }
            }
            if (entrer.equalsIgnoreCase("quit")) {
                continuer = false;
            } else {
                System.out.print("Expression : "
                        + pile.toString() + "\n");
            }
        }
        s.close();
        System.out.println("Resultat : " + pile.toString());
        return pile;
    }
}

