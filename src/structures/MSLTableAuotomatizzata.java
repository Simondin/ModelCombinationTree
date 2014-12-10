package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import model.Component;
import model.Mode;

public class MSLTableAuotomatizzata {

	private Component root;
	
	private LinkedHashMap<Component, ArrayList<Tuple<Mode, Integer>>> table;
	private LinkedHashMap<Mode,ArrayList<MSLLinkedModes>> linked_modes;

	public MSLTableAuotomatizzata() {
		this.table = new LinkedHashMap<Component, ArrayList<Tuple<Mode, Integer>>>();
		this.linked_modes = new LinkedHashMap<Mode,ArrayList<MSLLinkedModes>>();
	}

	public Component getRoot() {
		return root;
	}

	public void setRoot(Component root) {
		this.root = root;
	}

	public void addTableElement(Component component, ArrayList<Integer> span)
			throws Exception {
		ArrayList<Mode> modes = component.getModes();
		ArrayList<Tuple<Mode, Integer>> tuple = new ArrayList<Tuple<Mode, Integer>>();
		if (modes.size() == span.size()) {
			for (int i = 0; i < modes.size(); ++i) {
				tuple.add(new Tuple<Mode, Integer>(modes.get(i), span.get(i)));
			}
			this.getTable().put(component, tuple);
		} else {
			throw new Exception("The Arrays must have the same size!");
		}
	}

	public void addRootComponent(Component component, ArrayList<Integer> span) {
		this.setRoot(component);
		try {
			this.addTableElement(component, span);
			for (Mode m : component.getModes()){
				ArrayList<MSLLinkedModes> list = new ArrayList<MSLLinkedModes>();
				MSLLinkedModes modes = new MSLLinkedModes();
				modes.addLinkedMode(m);
				list.add(modes);
				this.linked_modes.put(m,list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HashMap<Component, ArrayList<Tuple<Mode, Integer>>> getTable() {
		return this.table;
	}

	public void addLinkedMode(ArrayList<Tuple<Mode, Integer>> tuples) {
		
		
		//Array contenente tutte le tuple già aggiunte e che non devo riconsiderare
		ArrayList<Tuple<Mode,Integer>> tuple_added;
		
		//Ciclo su tutte le mode del root
		for(Tuple<Mode,Integer> rootMode : this.table.get(this.root)){
			tuple_added = new ArrayList<Tuple<Mode,Integer>>();
			//Variabile di appoggio per salvare la dimensione della mode root
			int dim_root = rootMode.getY();
			//Indice che mi serve se devo ho elementi con dimensione inferiore a quella della mode root
			int i = 0;
			//Finchè la dimensione della mode root è maggiore di zero o ci sono ancora tuple da analizzare nell'array
			//aggiungo tuple
			for(Tuple<Mode,Integer> t : tuples){
				//Scorro tutte le tuple che ho passato in input
				while(dim_root > 0){
					//Mi creo un'Array di appoggio per salvare tutte le modalità della mode root
					ArrayList<MSLLinkedModes> linked_list = this.linked_modes.get(rootMode.getX());
					//Faccio vari controlli
					//Se la dimensione della mode root è maggiore della nuova mode allora nella 
					if(dim_root > t.getY()){
						MSLLinkedModes mslLinkedModes = linked_list.get(i);
						linked_list.add(i+1, mslLinkedModes.copyOf());
						mslLinkedModes.addLinkedMode(t.getX());
						dim_root -= t.getY();
						tuple_added.add(t);
						++i;
						break;
					} else if(dim_root == t.getY()){
						MSLLinkedModes mslLinkedModes = linked_list.get(i);
						mslLinkedModes.addLinkedMode(t.getX());
						dim_root -= t.getY();
						tuple_added.add(t);
						break;
					} else break;
				}
			}
			//i=0;
			for(Tuple<Mode,Integer> t: tuple_added){
				tuples.remove(t);
			}
		}
	}
	
	public void addListLinkedMode(ArrayList<ArrayList<Tuple<Mode, Integer>>> modes){
		for(ArrayList<Tuple<Mode, Integer>> tuples: modes)
			this.addLinkedMode(tuples);
	}
	
	public void addElementToLinkedModes(Mode root, Mode new_mode){
		for(MSLLinkedModes modes: this.linked_modes.get(root) )
			modes.addLinkedMode(new_mode);
	}
	
	@Override
	public String toString() {
		String string = "****Linked Modes****\n";
		for (ArrayList<MSLLinkedModes> trees : this.linked_modes.values())
			for(MSLLinkedModes m : trees)
				string += m.toString() + "\n";
		string += "\n****MSL Table****\n";
		for (Component c : this.table.keySet())
			string += c.toString() + "\n" + this.table.get(c).toString() + "\n";
		return string;
	}
}
