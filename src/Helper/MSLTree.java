/**
 * 
 */
package Helper;

import java.util.ArrayList;

import Model.Component;

/**
 * Class to map the component in the tree structure
 * 
 * @author Simone
 *
 */
public class MSLTree {

	private Tree<Component> tree;

	public MSLTree() {
		this.setTree(new Tree<Component>(null));
	}

	/**
	 * Get the tree
	 * 
	 * @return Tree<Component>
	 */
	public Tree<Component> getTree() {
		return tree;
	}

	/**
	 * Set the tree
	 * 
	 * @param Tree
	 *            <Component>
	 */
	public void setTree(Tree<Component> tree) {
		this.tree = tree;
	}

	public void addNodes(ArrayList<Component> nodes) {
		nodes = this.trimCopies(nodes);
		if (this.tree.getHead() == null) {
			this.tree.setRoot(nodes.get(0));
			nodes.remove(0);
		}
		for (Component component : nodes) {
			this.addNode(nodes, this.tree.getHead(), component);
		}
	}

	public void addNode(ArrayList<Component> nodes, Component parent,
			Component node) {
		this.getTree().addLeaf(parent, node);
		if (node.hasChildren())
			for (Component child : node.getChildren()) {
				this.addNode(nodes, node, child);
			}
	}

	@Override
	public String toString() {
		return this.getTree().toString();
	}

	public ArrayList<Component> trimCopies(ArrayList<Component> nodes) {
		ArrayList<Component> new_list = new ArrayList<Component>();
		for (Component component : nodes) {
			if (!new_list.contains(component))
				new_list.add(component);
			if (component.hasChildren())
				for (Component child : component.getChildren())
					if (!new_list.contains(child))
						new_list.add(child);
		}
		return new_list;
	}

}
