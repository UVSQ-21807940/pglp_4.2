package uvsq21807940;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;



public class junit_4 {
  
	
	
	@Test
	public void testAdition() throws Exception {
		Map<String, CommandSpecial> operation = new HashMap<String, CommandSpecial>();
		operation.put("+",new Addit());
		double res = operation.get("+").apply(1,2);
		assertTrue(res == 3.);
	}
	
	@Test
	public void testMoteurRpn() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(7.);
		m.addOperande(5.);
		m.executeCommand("-");
		
		Stack<Double> res = new Stack<Double>();
		res.push(2.);
		
		assertEquals(pile, res);
	}
  
	
	
	@Test (expected=Exception.class)
	public void testCommandeInconnu() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.executeCommand("erreur");
	}
	
	@Test
	public void testCalculUndo() throws Exception {
		String e = "7\n9\n*\nundo\nquit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		
		Stack<Double> res = new Stack<Double>();
		res.push(7.);
		res.push(9.);
		
		assertEquals(s.calcul(), res);
	}
	
	
	@Test
	public void testMultiplication() throws Exception {
		Stack<Double> pile = new Stack<Double>();
		Undo u = new Undo(pile);
		MoteurRPN m = MoteurRPN.init(pile, u);
		m.addOperande(5.);
		m.addOperande(4.);
		m.executeCommand("*");
		
		Stack<Double> res = new Stack<Double>();
		res.push(20.);
		
		assertEquals(pile, res);
	}
}
