/**
 * Class for the mapping of the modes of a component
 * @author Simone
 *
 */
public class Mode {

	private static Integer classID = 0;
	private Integer ID;
	private Integer componentID;
	private final static String deactivated = "D";
	private String modeValue;
	
	/**
	 * Standard constructor with deactivated status
	 * @param Integer cID: Component ID 
	 */
	public Mode(Integer cID){
		this.setID();
		this.setComponentID(cID);
		this.setModeValue(Mode.deactivated);
	}

	/**
	 * Specialized Constructor with mode value
	 * @param Integer cID: Component ID
	 * @param String mValue: Mode Value
	 */
	public Mode(Integer cID, String mValue){
		this.setID();
		this.setComponentID(cID);
		this.setModeValue(mValue);
	}
	
	/**
	 * Get for the ComponentID
	 * @return Integer
	 */
	public Integer getComponentID() {
		return componentID;
	}

	/**
	 * Set for the Component ID
	 * @param componentID
	 */
	public void setComponentID(Integer componentID) {
		this.componentID = componentID;
	}

	/**
	 * Get for the mode value
	 * @return String
	 */
	public String getModeValue() {
		return modeValue;
	}

	/**
	 * Set for mode value
	 * @param modeValue
	 */
	public void setModeValue(String modeValue) {
		this.modeValue = modeValue;
	}
	
	/**
	 * Get for the Mode ID
	 * @return Integer
	 */
	public Integer getID(){
		return this.ID;
	}
	
	
	/**
	 * Set for the Mode ID
	 */
	private void setID(){
		if(this.ID == null)
			this.ID = Mode.classID + 1;
	}
	
	/**
	 * Override of the "equals" method, it checks the ID of two modes
	 * @param Component c
	 * @return boolean
	 */
	@Override
	public boolean equals(Object c){
		return this.getID() == ((Mode) c).getID();
	}
	
	/**
	 * Override of the "toString" method, it prints the ID of the mode and its mode value
	 * @return String
	 */
	@Override
	public String toString(){
		return "\nMode ID: " + this.getID() + "\nMode Value: " + this.getModeValue();
	}
	
}
