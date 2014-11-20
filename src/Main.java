import java.util.ArrayList;

import Helper.MSLTree;
import Model.Component;


public class Main {

	public static void main(String[] args) {
		Component a = new Component("m1a");
		Component b = new Component("m1b");
		Component c = new Component("m1c");
		Component d = new Component("m1d");
		Component e = new Component("m1e");
		Component f = new Component("m1f");
		Component g = new Component("m1g");
		Component h = new Component("m1h");
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
		msl.addNodes(nodes);
		System.out.print(msl.toString());
	}

}
