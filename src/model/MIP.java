package model;
/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MIP.
 * 
 * @author francesco
 */
public class MIP extends Property {
	/**
	 * Description of the property supportedModess.
	 */
	public SupportedModes supportedModess = null;

	// Start of user code (user defined attributes for MIP)

	// End of user code

	/**
	 * The constructor.
	 */
	public MIP() {
		// Start of user code constructor for MIP)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for MIP)

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
