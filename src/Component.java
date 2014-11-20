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
			this.ID = Component.classID + 1;
	}
	
	/**
	 * Method for adding a new child to the component. It check if this child already exist
	 * @param Component child
	 * @throws Exception
	 */
	public void addChild(Component child) throws Exception{
		if(!searchChild(child))
			this.getChildren().add(child);
		else
			throw new Exception("The child with ID " + child.getID() + " already exist!");
	}
	
	/**
	 * Method that search and retrive 
	 * @param child
	 * @return
	 */
	public Component getChild(Component child){
		for(Component c: this.getChildren())
			if(c.equals(this))
				return c;
		return null;
	}

	public boolean searchChild(Component child){
		boolean found = false;
		for(Component c: this.getChildren()){
			if(c.equals(this))
				found = true;
		}
		return found;
	}
	
	@Override
	public boolean equals(Object c){
		return this.getID() == ((Component) c).getID();
	}
}
