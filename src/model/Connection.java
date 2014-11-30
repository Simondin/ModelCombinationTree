package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Connection.
 * 
 * @author francesco
 */
public class Connection {
	/**
	 * Description of the property functionalPorts.
	 */
	public ArrayList<FunctionalPort> functionalPorts = new ArrayList<FunctionalPort>();

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor.
	 */
	public Connection() {
		// Start of user code constructor for Connection)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Connection)

	// End of user code
	/**
	 * Returns functionalPorts.
	 * @return functionalPorts 
	 */
	public ArrayList<FunctionalPort> getFunctionalPorts() {
		return this.functionalPorts;
	}

}
