package structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * 
 * @param <T>
 *            Object's type in the tree.
 */
public class Tree<T> {

	private static final int indent = 2;
	private T head;
	private ArrayList<Tree<T>> leafs = new ArrayList<Tree<T>>();
	private Tree<T> parent = null;
	private HashMap<T, Tree<T>> locate = new HashMap<T, Tree<T>>();
	private ArrayList<ArrayList<T>> comp_paths = new ArrayList<ArrayList<T>>();

	/**
	 * Constructor that set as root the node give in input
	 * @param head Root for the tree
	 */
	public Tree(T head) {
		this.setRoot(head);
	}

	/**
	 * Empty Constructor
	 */
	public Tree() {
	}

	/**
	 * Set as root the given node
	 * @param root Root for the tree
	 */
	public void setRoot(T root) {
		this.head = root;
		locate.put(root, this);
	}

	/**
	 * Add the leaf as a child of the root node given in input
	 * @param root Root for the tree
	 * @param leaf Leaf for the Root
	 */
	public void addLeaf(T root, T leaf) {
		if (locate.containsKey(root)) {
			locate.get(root).addLeaf(leaf);
		} else {
			addLeaf(root).addLeaf(leaf);
		}
	}

	public void addLeafs(T root, ArrayList<T> collection) {
		for (T leaf : collection)
			this.addLeaf(root, leaf);
	}

	public ArrayList<T> getChildrenRoot() {
		ArrayList<T> successors = new ArrayList<T>();
		Tree<T> tree = getTree(this.head);
		if (null != tree) {
			for (Tree<T> leaf : tree.leafs) {
				successors.add(leaf.head);
			}
		}
		return successors;
	}

	public Tree<T> addLeaf(T leaf) {
		if (!locate.containsKey(leaf)) {
			Tree<T> t = new Tree<T>(leaf);
			leafs.add(t);
			t.parent = this;
			t.locate = this.locate;
			locate.put(leaf, t);
			return t;
		}
		return null;
	}

	public Tree<T> setAsParent(T parentRoot) {
		Tree<T> t = new Tree<T>(parentRoot);
		t.leafs.add(this);
		this.parent = t;
		t.locate = this.locate;
		t.locate.put(head, this);
		t.locate.put(parentRoot, t);
		return t;
	}

	public T getHead() {
		return head;
	}

	public Tree<T> getTree(T element) {
		return locate.get(element);
	}

	public Tree<T> getParent() {
		return parent;
	}

	public Collection<T> getSuccessors(T root) {
		Collection<T> successors = new ArrayList<T>();
		Tree<T> tree = getTree(root);
		if (null != tree) {
			for (Tree<T> leaf : tree.leafs) {
				successors.add(leaf.head);
			}
		}
		return successors;
	}

	public int getNumOfChildren(T root) {
		return this.getSuccessors(root).size();
	}

	public Collection<Tree<T>> getSubTrees() {
		return leafs;
	}

	public static <T> Collection<T> getSuccessors(T of, Collection<Tree<T>> in) {
		for (Tree<T> tree : in) {
			if (tree.locate.containsKey(of)) {
				return tree.getSuccessors(of);
			}
		}
		return new ArrayList<T>();
	}

	public ArrayList<ArrayList<T>> getComp_paths() {
		return comp_paths;
	}

	public void setComp_paths(ArrayList<ArrayList<T>> comp_paths) {
		this.comp_paths = comp_paths;
	}

	@Override
	public String toString() {
		return printTree(0);
	}

	private String printTree(int increment) {
		String s = "";
		String inc = "";
		for (int i = 0; i < increment; ++i) {
			inc = inc + " ";
		}
		s = inc + head;
		for (Tree<T> child : leafs) {
			s += "\n" + child.printTree(increment + indent);
		}
		return s;
	}



	public void DFS(T root, String path, ArrayList<T> comp_path) {
		if (root == null)
			root = this.getHead();
		comp_path.add(root);
		ArrayList<T> children = new ArrayList<T>(this.getSuccessors(root));
		if (children.isEmpty()) {
			this.comp_paths.add(comp_path);
		} else {
			for (T child : children) {
				DFS(child, path, new ArrayList<T>(comp_path.subList(0, comp_path.size())));
			}
		}
	}
	
}