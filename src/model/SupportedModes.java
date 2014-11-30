package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of SupportedModes.
 * 
 * @author francesco
 */
public class SupportedModes {
	/**
	 * Description of the property subComponents.
	 */
	public ArrayList<SubComponent> subComponents = new ArrayList<SubComponent>();

	/**
	 * Description of the property connections.
	 */
	public ArrayList<Connection> connections = new ArrayList<Connection>();

	// Start of user code (user defined attributes for SupportedModes)

	// End of user code

	/**
	 * The constructor.
	 */
	public SupportedModes() {
		// Start of user code constructor for SupportedModes)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for SupportedModes)

	// End of user code
	/**
	 * Returns subComponents.
	 * @return subComponents 
	 */
	public ArrayList<SubComponent> getSubComponents() {
		return this.subComponents;
	}

	/**
	 * Returns connections.
	 * @return connections 
	 */
	public ArrayList<Connection> getConnections() {
		return this.connections;
	}

}
