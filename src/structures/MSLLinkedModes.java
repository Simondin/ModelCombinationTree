package structures;

import java.util.ArrayList;

import model.Mode;

public class MSLLinkedModes {

	private ArrayList<Mode> modes;
	
	public MSLLinkedModes(){
		this.modes = new ArrayList<Mode>();
	}
	
	public MSLLinkedModes(ArrayList<Mode> m){
		this.modes = new ArrayList<Mode>(m);
	}
	
	public void addLinkedMode(Mode m){
		this.modes.add(m);
	}
	
	public ArrayList<Mode> getModes(){
		return this.modes;
	}
	
	public Mode getMode(int position){
		return this.modes.get(position);
	}
	
	public String toString(){
		String string = "";
		for(Mode m : this.modes)
			string += m.toString() + " ";
		return string;
	}
	
	public MSLLinkedModes copyOf(){
		return new MSLLinkedModes(this.modes);
		
	}
}
