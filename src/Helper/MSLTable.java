package Helper;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Component;
import Model.Mode;

public class MSLTable {
	
	private HashMap<Component, ArrayList<Mode>> table;
	
	public MSLTable(){
		this.table = new HashMap<Component, ArrayList<Mode>>();
	}
	
	public ArrayList<Component> getComponents(){
		return new ArrayList<Component>(this.table.keySet());
	}
	
	public ArrayList<Mode> getModes(Component component){
		return this.table.get(component);
	}
	
	public void addComponent(Component component){
		if(!this.table.containsKey(component))
			this.table.put(component, component.getModes());
	}
	
	public void addComponents(ArrayList<Component> components){
		for(Component c:components)
			this.addComponent(c);
	}
	
	@Override
	public String toString(){
		String print = "";
		for(Component c: this.getComponents()){
			print += c.toString();
			for(Mode m: c.getModes())
				print += "    " + m.toString(); 
		}
		return print;
	}

}
