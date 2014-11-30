package model;
/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MDP.
 * 
 * @author francesco
 */
public class MDP extends Property {
	/**
	 * Description of the property supportedModess.
	 */
	public SupportedModes supportedModess = null;

	// Start of user code (user defined attributes for MDP)

	// End of user code

	/**
	 * The constructor.
	 */
	public MDP() {
		// Start of user code constructor for MDP)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for MDP)

	// End of user code
	/**
	 * Returns supportedModess.
	 * @return supportedModess 
	 */
	public SupportedModes getSupportedModess() {
		return this.supportedModess;
	}

	/**
	 * Sets a value to attribute supportedModess. 
	 * @param newSupportedModess 
	 */
	public void setSupportedModess(SupportedModes newSupportedModess) {
		this.supportedModess = newSupportedModess;
	}

}
