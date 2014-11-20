package Model;
import java.util.ArrayList;

/**
 * Class for the Component
 * @author Simone
 *
 */
public class Component {
	
	private ArrayList<Mode> modes;
	private ArrayList<Component> children;
	private static Integer classID = 0;
	private Integer ID;
	
	/**
	 * Standard Constructor: it creates a component with a deactivated mode, without children
	 */
	public Component(){
		this.setID();
		this.setModes(new ArrayList<Mode>());
		this.setChildren(new ArrayList<Component>());
		this.getModes().add(new Mode(this.getID()));
	}

	/**
	 * Specialized Constructor: it creates a component with a specific mode, without children
	 * @param String mValues: Mode Value
	 */
	public Component(String mValues){
		this.setID();
		this.setModes(new ArrayList<Mode>());
		this.setChildren(new ArrayList<Component>());
		this.getModes().add(new Mode(this.getID(),mValues));
	}
	
	/**
	 * Get for the list of the mode
	 * @return ArrayList<Mode>
	 */
	public ArrayList<Mode> getModes() {
		return modes;
	}

	/**
	 * Set for the list of the mode
	 * @param ArrayList<Mode> modes
	 */
	public void setModes(ArrayList<Mode> modes) {
		this.modes = modes;
	}
	
	/**
	 * Function for add a new mode to the list of modes of the component
	 * @param Mode m
	 */
	public void addModes(Mode m){
		this.modes.add(m);
	}

	/**
	 * Get for the list of the children
	 * @return ArrayList<Component>
	 */
	public ArrayList<Component> getChildren() {
		return children;
	}

	/**
	 * Set for the list of the children
	 * @param ArrayList<Component> children
	 */
	public void setChildren(ArrayList<Component> children) {
		this.children = children;
	}

	/**
	 * Get for the Component ID
	 * @return String
	 */
	public Integer getID() {
		return this.ID;
	}

	/**
	 * Set for the Component ID
	 */
	private void setID() {
		if(this.ID == null)
			this.ID = Component.classID += 1;
	}
	
	/**
	 * Method for adding a new child to the component. It check if this child already exist
	 * @param Component child
	 * @throws Exception
	 */
	public void addChild(Component child) throws Exception{
		if(getChild(child) == null)
			this.getChildren().add(child);
		else
			throw new Exception("The child with ID " + child.getID() + " already exist!");
	}
	
	/**
	 * Method that search and retrieve the child passed as attribute
	 * @param Component child
	 * @return Component
	 */
	public Component getChild(Component child){
		for(Component c: this.getChildren()){
			if(c.equals(child))
				return c;
		}
		return null;
	}

	/**
	 * Method that search if the child is in the list of the children
	 * @param Component child
	 * @return boolean
	 *
	public boolean searchChild(Component child){
		for(Component c: this.getChildren())
			if(c.equals(child))
				return true;
		return false;
	}*/
	
	/**
	 * Method that check if the component have or not children
	 * @return boolean
	 */
	public boolean hasChildren(){
		return this.getChildren().size() > 0;
	}
	
	/**
	 * Override of the "equals" method, it checks the ID of two components
	 * @param Component c
	 * @return boolean
	 */
	@Override
	public boolean equals(Object c){
		return this.getID() == ((Component) c).getID();
	}
	
	/**
	 * Override of the "toString" method, it prints the ID of the component and its modes
	 * @return String
	 */
	@Override
	public String toString(){
		String print = "Component ID: " + this.getID();
		//for(Mode m: this.getModes())
			//print += m.toString();
		return print;
	}
}
