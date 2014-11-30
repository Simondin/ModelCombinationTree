import java.util.ArrayList;

import Helper.HangTransformationAlgorithm;
import Helper.MSLTable;
import Helper.MSLTree;
import Model.Component;


public class Main {

	public static void main(String[] args) {
		Component a = new Component("A","m1");
		a.addMode("m2");
		Component b = new Component("B","m1");
		Component c = new Component("C","m1");
		Component d = new Component("D","m1");
		Component e = new Component("E","m1");
		Component f = new Component("F","m1");
		Component g = new Component("G","m1");
		Component h = new Component("H","m1");
		try {
			a.addChild(b);
			a.addChild(c);
			a.addChild(d);
			c.addChild(e);
			c.addChild(f);
			d.addChild(g);
			d.addChild(h);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
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
		MSLTree msl = new MSLTree();
		//msl.addNodes(nodes);
		//System.out.print(msl.toString());
		
		HangTransformationAlgorithm alg = new HangTransformationAlgorithm();
		alg.constructMCT(a, 0);
		msl.addNodes(alg.getMtc_nodes());
		System.out.print(msl.toString());
		
		
		
		//MSLTable mslTable = new MSLTable();
		//mslTable.addComponents(nodes);
		//System.out.println(mslTable.toString());
	}

}
