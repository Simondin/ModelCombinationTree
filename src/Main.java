import helper.HangTrasformationAlgorithm;

import java.util.ArrayList;

import controller.ComponentManager;
import structures.MSLTable;
import structures.MSLTree;
import model.Component;
import model.Mode;


public class Main {

	public static void main(String[] args) {
		Component a = new Component("A","m1");
		a.addMode("m2");
		Component b = new Component("B","m1");
		b.addMode("m2");
		Component c = new Component("C","m1");
		c.addMode("m2");
		c.addMode("m3");
		Component d = new Component("D");
		d.addMode("m1");
		Component e = new Component("E","m1");
		e.addMode("m2");
		e.addMode("m3");
		e.addMode((Mode) null);
		Component f = new Component("F","m1");
		Component g = new Component("G","m1");
		g.addMode("m2");
		Component h = new Component("H","m1");
		h.addMode("m2");
		try {
			a.addChild(b);
			a.addChild(c);
			a.addChild(d);
			c.addChild(e);
			c.addChild(f);
			d.addChild(g);
			d.addChild(h);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		ArrayList<Component> nodes = new ArrayList<Component>();
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		nodes.add(f);
		nodes.add(g);
		nodes.add(h);
		ComponentManager componentManager = ComponentManager.getInstance();
		componentManager.addComponents(nodes);
		MSLTree msl = new MSLTree();
		msl.addNodes(nodes);
		//System.out.print(msl.toString());
		
		
		ArrayList<Component> components = new ArrayList<Component>();
		components.add(a);
		components.add(c);
		components.add(d);
		
		ArrayList<Mode> modes = new ArrayList<Mode>();
		//Componente A
		modes.add(a.getModes().get(0));
		modes.add(b.getModes().get(0));
		modes.add(c.getModes().get(0));
		modes.add(d.getModes().get(0));
		
		modes.add(a.getModes().get(0));
		modes.add(b.getModes().get(0));
		modes.add(c.getModes().get(2));
		modes.add(d.getModes().get(0));
		
		modes.add(a.getModes().get(1));
		modes.add(b.getModes().get(1));
		modes.add(c.getModes().get(1));
		modes.add(d.getModes().get(1));
		
		//Componente C
		modes.add(c.getModes().get(0));
		modes.add(e.getModes().get(0));
		modes.add(f.getModes().get(0));
		
		modes.add(c.getModes().get(1));
		modes.add(e.getModes().get(1));
		modes.add(f.getModes().get(0));
		
		modes.add(c.getModes().get(1));
		modes.add(e.getModes().get(2));
		modes.add(f.getModes().get(0));
		
		modes.add(c.getModes().get(2));
		modes.add(e.getModes().get(3));
		modes.add(f.getModes().get(0));
		
		//Componente D
		modes.add(d.getModes().get(1));
		modes.add(g.getModes().get(0));
		modes.add(h.getModes().get(0));
		
		modes.add(d.getModes().get(1));
		modes.add(g.getModes().get(1));
		modes.add(h.getModes().get(1));
		
		MSLTable mslTable = new MSLTable();
		//System.out.println(modes.subList(0, 12));
		//System.out.println(modes.subList(12, 24));
		//System.out.println(modes.subList(24, 30));
		mslTable.addModes(components, modes);
		
		HangTrasformationAlgorithm alg = new HangTrasformationAlgorithm(mslTable);
		ArrayList<Component> A = new ArrayList<Component>();
		A.add(a);
		//alg.constructMCT(A, 0);
		alg.execute(A, 0);
		
		alg.printTree();
		//alg.printPaths();
		
	}

}
