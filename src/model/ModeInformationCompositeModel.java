package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ModeInformationCompositeModel.
 * 
 * @author francesco
 */
public class ModeInformationCompositeModel extends ModeInformation {
	/**
	 * Description of the property modeMappings.
	 */
	public ModeMapping modeMappings = null;

	/**
	 * Description of the property supportedModess.
	 */
	public ArrayList<SupportedModes> supportedModess = new ArrayList<SupportedModes>();

	// Start of user code (user defined attributes for ModeInformationCompositeModel)

	// End of user code

	/**
	 * The constructor.
	 */
	public ModeInformationCompositeModel() {
		// Start of user code constructor for ModeInformationCompositeModel)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ModeInformationCompositeModel)

	// End of user code
	/**
	 * Returns modeMappings.
	 * @return modeMappings 
	 */
	public ModeMapping getModeMappings() {
		return this.modeMappings;
	}

	/**
	 * Sets a value to attribute modeMappings. 
	 * @param newModeMappings 
	 */
	public void setModeMappings(ModeMapping newModeMappings) {
		this.modeMappings = newModeMappings;
	}

	/**
	 * Returns supportedModess.
	 * @return supportedModess 
	 */
	public ArrayList<SupportedModes> getSupportedModess() {
		return this.supportedModess;
	}

}
