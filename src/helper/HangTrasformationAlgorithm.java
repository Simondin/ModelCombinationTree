package helper;

import java.util.ArrayList;

import controller.ComponentManager;
import structures.MSLTable;
import structures.Tree;
import model.Component;
import model.Mode;

public class HangTrasformationAlgorithm implements
		ModeTransformationAlgorithmStrategy {

	private Component TOP;
	private Tree<ArrayList<Component>> tree;
	private MSLTable mslTable;
	
	public HangTrasformationAlgorithm(MSLTable table) {
		this.tree = new Tree<ArrayList<Component>>();
		this.mslTable = table;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(Object components, Object depthN) {
//		try {
//			int x = 100;
//			do {
//				if (x > 100)
//					throw new AlgorithmException();
//				x--;
//			} while (x == 0);
//		} catch (AlgorithmException ex) {
//			ex.printStackTrace();
//		}
		long startTime = System.nanoTime();
		this.constructMCT((ArrayList<Component>) components,(int) depthN);
		long endTime = System.nanoTime();
		System.out.println("Execution Time: " + ((endTime - startTime) / 1000) + " micro s" );
	}
	
	public Component getTOP() {
		return this.TOP;
	}

	public void setTOP(Component tOP) {
		this.TOP = tOP;
	}

	public Tree<ArrayList<Component>> getTree() {
		return this.tree;
	}

	public void setTree(Tree<ArrayList<Component>> tree) {
		this.tree = tree;
	}

	public String toString() {
		String string = "";
		return string;
	}

	
	public void constructMCT(ArrayList<Component> components, int depthN) {
		ComponentManager componentManager = ComponentManager.getInstance();
		Component mct_node = null;
		ArrayList<Component> top_array = null;
		ArrayList<Component> mct_array = null;
		
		if (depthN == 0) {
			this.TOP = new Component();
			top_array = new ArrayList<Component>();
			top_array.add(this.TOP);
			this.tree.setRoot(top_array);
			for (Component component : components)
				for (Mode mode : component.getModes()) {
					mct_node = componentManager
							.getCopyOfComponentByID(mode.getComponentID());
					mct_node.setMode(mode);
					mct_array = new ArrayList<Component>();
					mct_array.add(mct_node);
					this.tree.addLeaf(top_array, mct_array);
				}
			//For all the successors of the root explore the list of the components with depthN increased
			for (ArrayList<Component> nodes : this.tree.getSuccessors(top_array))
				this.constructMCT(nodes, 1);

		} else if (depthN == 1) {
			this.TOP = components.get(0);
			top_array = new ArrayList<Component>();
			top_array.add(this.TOP);
			ArrayList<ArrayList<Mode>> msl_table = null;
			for (Component n : components)
				msl_table = this.mslTable.getChildrenMode(n);
			for(ArrayList<Mode> modes : msl_table){
				mct_array = new ArrayList<Component>();
				for(Mode mode : modes){
					mct_node = componentManager
							.getCopyOfComponentByID(mode.getComponentID());
					mct_node.setMode(mode);
					mct_array.add(mct_node);
				}
				this.tree.addLeaf(top_array, mct_array);
			}
						
			for (ArrayList<Component> nodi : this.tree.getSuccessors(top_array))
				this.constructMCT(nodi, 2);
			
			
		} else if (depthN >= 2) {
			this.TOP = components.get(0);
			top_array = new ArrayList<Component>();
			top_array.addAll(components);
			mct_array = new ArrayList<Component>();
			ArrayList<Component> derive_components = new ArrayList<Component>();
			for (Component n : components)
				if (n.hasChildren())
					derive_components.add(n);
			if (!derive_components.isEmpty()) {
				for (ArrayList<Component> c : this.Derive(derive_components)) {
					this.tree.addLeaf(top_array, c);
				}
				for (ArrayList<Component> nodi : this.tree
						.getSuccessors(top_array))
					this.constructMCT(nodi, 2);
			}
		}
	}

	
	public ArrayList<ArrayList<Component>> Derive(
			ArrayList<Component> components) {
		boolean test = false;
		for (Component c : components)
			if (c.hasDeactivatedModes()) {
				test = true;
				break;
			}
		if (test)
			return this.DeriveWithDeactivatedModes(components);
		else {
			return this.DeriveWithoutDeactivatedModes(components);
		}
	}

	public ArrayList<ArrayList<Component>> DeriveWithDeactivatedModes(
			ArrayList<Component> components) {
		ArrayList<ArrayList<Component>> result = new ArrayList<ArrayList<Component>>();
		ArrayList<Component> deriveComponents = new ArrayList<Component>();
		ComponentManager componentManager = ComponentManager.getInstance();
		for (Component c : components) {
			ArrayList<ArrayList<Mode>> msl_table_modes = mslTable
					.getChildrenMode(c);
			if (c.getModes().get(0).isDeactivated()) {
				for (Mode mode : msl_table_modes.get(0)) {
					Component component = componentManager
							.getCopyOfComponentByID(mode.getComponentID());
					Mode derive_mode = new Mode(mode);
					derive_mode.deactivateMode(component.getName());
					component.setMode(derive_mode);
					deriveComponents.add(component);
				}
			} else {
				for (ArrayList<Mode> modes : msl_table_modes)
					for (Mode mode : modes) {
						Component component = componentManager
								.getCopyOfComponentByID(mode.getComponentID());
						Mode derive_mode = new Mode(mode);
						component.setMode(derive_mode);
						deriveComponents.add(component);
					}
			}
			result.add(deriveComponents);
		}
		return result;
	}

	public ArrayList<ArrayList<Component>> DeriveWithoutDeactivatedModes(
			ArrayList<Component> components) {
		ArrayList<ArrayList<Component>> result = new ArrayList<ArrayList<Component>>();
		ArrayList<Component> deriveComponents;
		ComponentManager componentManager = ComponentManager.getInstance();
		ArrayList<ArrayList<ArrayList<Mode>>> modalita = new ArrayList<ArrayList<ArrayList<Mode>>>();
		for (Component c : components) {
			ArrayList<ArrayList<Mode>> msl_table_modes = mslTable
					.getChildrenMode(c);
			modalita.add(msl_table_modes);
		}
		ArrayList<ArrayList<Mode>> deriveModes = VectorialProduct(0, modalita,
				null);
		for (ArrayList<Mode> modes : deriveModes) {
			deriveComponents = new ArrayList<Component>();
			for (Mode mode : modes) {
				Component component = componentManager
						.getCopyOfComponentByID(mode.getComponentID());
				Mode derive_mode = new Mode(mode);
				component.setMode(derive_mode);
				deriveComponents.add(component);
			}
			result.add(deriveComponents);
		}
		return result;
	}

	public ArrayList<ArrayList<Mode>> VectorialProduct(Integer index,
			ArrayList<ArrayList<ArrayList<Mode>>> modes,
			ArrayList<ArrayList<Mode>> partialProduct) {
		if (index >= modes.size())
			return partialProduct;
		if (partialProduct == null)
			partialProduct = modes.get(index);
		else {
			ArrayList<ArrayList<Mode>> result = new ArrayList<ArrayList<Mode>>();
			result = ArraysMolti(modes.get(index), partialProduct);
			partialProduct = result;
		}
		return VectorialProduct(index + 1, modes, partialProduct);

	}

	public ArrayList<ArrayList<Mode>> ArraysMolti(ArrayList<ArrayList<Mode>> A,
			ArrayList<ArrayList<Mode>> B) {
		ArrayList<ArrayList<Mode>> result = new ArrayList<ArrayList<Mode>>();
		for (ArrayList<Mode> modeA : A)
			for (ArrayList<Mode> modeB : B) {
				ArrayList<Mode> temp = new ArrayList<Mode>();
				temp.addAll(modeB);
				temp.addAll(modeA);
				result.add(temp);
			}
		return result;
	}
	
	private void constructPaths(){
		this.getTree().DFS(null, "", new ArrayList<ArrayList<Component>>());
	}
	
	public String getPaths(){
		if(this.getTree().getComp_paths().isEmpty())
			this.constructPaths();
		String string = "";
		String increment = "";
		for(ArrayList<ArrayList<Component>> paths: this.getTree().getComp_paths()){
			increment = "";
			for(ArrayList<Component> components : paths){
				string += increment + "{ ";
				for(Component component : components)
				string += component;
				increment += " ";
				string += " }\n";
			}
		}
		return string;
	}
	
	@Override
	public String printPaths(){
		return this.getPaths().toString();
	}
	
	@Override
	public String printTree(){
		return this.getTree().toString();
	}
}
