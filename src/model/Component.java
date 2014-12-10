package model;
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
	private String Name;
	private static Integer topID = 0;
	public static String top = "TOP";
	
	/**
	 * Standard Constructor: it creates a TOP component with a deactivated mode, without children
	 */
	public Component(){
		this.setID(Component.top);
		this.setName(Component.top);
		this.setModes(new ArrayList<Mode>());
		this.setChildren(new ArrayList<Component>());
		this.getModes().add(new Mode(this.getID()));
	}
	
	/**
	 * Standard Constructor: it creates a component with a deactivated mode, without children
	 */
	public Component(String name){
		this.setID();
		this.setName(name);
		this.setModes(new ArrayList<Mode>());
		this.setChildren(new ArrayList<Component>());
		this.getModes().add(new Mode(this.getID(),Mode.deactivated+name));
	}

	/**
	 * Specialized Constructor: it creates a component with a specific mode, without children
	 * @param String mValues: Mode Value
	 */
	public Component(String name, String mValues){
		this.setID();
		this.setName(name);
		this.setModes(new ArrayList<Mode>());
		this.setChildren(new ArrayList<Component>());
		this.getModes().add(new Mode(this.getID(),mValues+name));
	}
	
	public Component(String name, Mode mode){
		this.setID();
		this.setName(name);
		this.setModes(new ArrayList<Mode>());
		this.setChildren(new ArrayList<Component>());
		this.getModes().add(mode);
	}
	
	public Component(Component c, Mode mode){
		this.fullCopy(c);
		this.setMode(mode);
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
	 * Set only one mode in the list
	 * @param Mode mode
	 */
	public void setMode(Mode mode){
		if(!this.modes.isEmpty())
			this.modes.clear();
		this.modes.add(mode);
	}
	
	/**
	 * Function for add a new mode to the modes list of the component
	 * @param Mode m
	 */
	public void addMode(Mode m){
		if(m == null)
			this.modes.add(new Mode(this.getID(),Mode.deactivated+this.getName()));
		else {
			m.setComponentID(this.getID());
			this.modes.add(m);
		}
	}
	
	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	
	/**
	 * Function for add a new mode to the modes list of the component
	 * @param String mValue
	 */
	public void addMode(String mValue){
		this.getModes().add(new Mode(this.getID(),mValue+this.getName()));
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
	 * Used only for the copies
	 * @param ID integer
	 */
	private void setID(int ID){
		this.ID = ID;
	}
	
	
	private void setID(String top){
		this.ID = Component.topID;
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
		String print = "";
		if(this.getID().equals(Component.topID))
			print = "( " + this.getName();
		else{
			print = "( " + this.getName()+" | ";
			for(Mode m: this.getModes())
				print += m.toString()+" |";
		}
		return print+" )";
	}
	
	/**
	 * Method that copy a Component 
	 * @param Component c
	 */
	public void copyOf(Component c){
		this.setName(c.getName());
		this.setChildren(c.getChildren());
		this.setModes(c.getModes());
	}
	
	public void fullCopy(Component c){
		this.setName(c.getName());
		this.setChildren(c.getChildren());
		this.setID(c.getID());
		this.setModes(new ArrayList<Mode>());
	}
	
	public void deactivateModes(){
		for(Mode m : this.getModes())
			m.deactivateMode(this.Name);
	}
	
	public boolean hasDeactivatedModes(){
		for(Mode m : this.getModes())
			if(m.isDeactivated())
				return true;
		return false;
	}
	
	
}
