package Structures;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Model.Component;
import Model.Mode;

public class MSLTable {

	private LinkedHashMap<Component, ArrayList<ArrayList<Mode>>> linked_modes;

	public MSLTable() {
		this.linked_modes = new LinkedHashMap<Component, ArrayList<ArrayList<Mode>>>();
	}

	public LinkedHashMap<Component, ArrayList<ArrayList<Mode>>> getLinked_modes() {
		return this.linked_modes;
	}

	public void setLinked_modes(
			LinkedHashMap<Component, ArrayList<ArrayList<Mode>>> linked_modes) {
		this.linked_modes = linked_modes;
	}

	public void addModes(ArrayList<Component> components, ArrayList<Mode> modes) {
		ArrayList<ArrayList<Mode>> mode_a = new ArrayList<ArrayList<Mode>>();
		ArrayList<Mode> tree_a1 = new ArrayList<Mode>();
		tree_a1.add(modes.get(0));
		tree_a1.add(modes.get(1));
		tree_a1.add(modes.get(2));
		tree_a1.add(modes.get(3));

		ArrayList<Mode> tree_a2 = new ArrayList<Mode>();
		tree_a2.add(modes.get(4));
		tree_a2.add(modes.get(5));
		tree_a2.add(modes.get(6));
		tree_a2.add(modes.get(7));

		ArrayList<Mode> tree_a3 = new ArrayList<Mode>();
		tree_a3.add(modes.get(8));
		tree_a3.add(modes.get(9));
		tree_a3.add(modes.get(10));
		tree_a3.add(modes.get(11));

		mode_a.add(tree_a1);
		mode_a.add(tree_a2);
		mode_a.add(tree_a3);

		/*******************************/
		ArrayList<ArrayList<Mode>> mode_c = new ArrayList<ArrayList<Mode>>();

		ArrayList<Mode> tree_c1 = new ArrayList<Mode>();
		tree_c1.add(modes.get(12));
		tree_c1.add(modes.get(13));
		tree_c1.add(modes.get(14));

		ArrayList<Mode> tree_c2 = new ArrayList<Mode>();
		tree_c2.add(modes.get(15));
		tree_c2.add(modes.get(16));
		tree_c2.add(modes.get(17));

		ArrayList<Mode> tree_c3 = new ArrayList<Mode>();
		tree_c3.add(modes.get(18));
		tree_c3.add(modes.get(19));
		tree_c3.add(modes.get(20));

		ArrayList<Mode> tree_c4 = new ArrayList<Mode>();
		tree_c4.add(modes.get(21));
		tree_c4.add(modes.get(22));
		tree_c4.add(modes.get(23));

		mode_c.add(tree_c1);
		mode_c.add(tree_c2);
		mode_c.add(tree_c3);
		mode_c.add(tree_c4);

		/*******************************/
		ArrayList<ArrayList<Mode>> mode_d = new ArrayList<ArrayList<Mode>>();

		ArrayList<Mode> tree_d1 = new ArrayList<Mode>();
		tree_d1.add(modes.get(24));
		tree_d1.add(modes.get(25));
		tree_d1.add(modes.get(26));

		ArrayList<Mode> tree_d2 = new ArrayList<Mode>();
		tree_d2.add(modes.get(27));
		tree_d2.add(modes.get(28));
		tree_d2.add(modes.get(29));

		mode_d.add(tree_d1);
		mode_d.add(tree_d2);

		/*******************************/
		this.linked_modes.put(components.get(0), mode_a);
		this.linked_modes.put(components.get(1), mode_c);
		this.linked_modes.put(components.get(2), mode_d);
	}

	public String toString() {
		String string = "";
		for (Component c : this.getLinked_modes().keySet()) {
			string += c.toString() + "\n";
			for (ArrayList<Mode> t : this.getLinked_modes().get(c))
				string += t.toString() + "\n";
		}
		return string;
	}

	public ArrayList<ArrayList<Mode>> getModes(Component c) {
		for (Component comp : this.getLinked_modes().keySet()) {
			if (c.equals(comp))
				return this.getLinked_modes().get(comp);
		}
		return null;
	}

	public ArrayList<ArrayList<Mode>> getChildrenModes(Component father) {
		ArrayList<ArrayList<Mode>> result = new ArrayList<ArrayList<Mode>>();
		for (Component comp : this.getLinked_modes().keySet()) {
			if (father.equals(comp))
				for (ArrayList<Mode> modes : this.getLinked_modes().get(comp)) {
					result.add(new ArrayList<Mode>(modes.subList(0, modes.size())));
				}
		}
		return result;
	}
	
	public ArrayList<ArrayList<Mode>> getChildrenMode(Component father){
		ArrayList<ArrayList<Mode>> result = new ArrayList<ArrayList<Mode>>();
		for(ArrayList<Mode> modes : this.getChildrenModes(father)){
			//System.out.println(modes);
			if(modes.get(0).equals(father.getModes().get(0)))
				result.add(new ArrayList<Mode>(modes.subList(1, modes.size())));
			else if(father.getModes().get(0).isDeactivated()){
				result.add(new ArrayList<Mode>(modes.subList(1, modes.size())));
			}
		}	
		return result;
	}

}
