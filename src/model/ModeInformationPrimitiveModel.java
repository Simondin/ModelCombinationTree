package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ModeInformationPrimitiveModel.
 * 
 * @author francesco
 */
public class ModeInformationPrimitiveModel extends ModeInformation {
	/**
	 * Description of the property supportedModess.
	 */
	public ArrayList<SupportedModes> supportedModess = new ArrayList<SupportedModes>();

	// Start of user code (user defined attributes for ModeInformationPrimitiveModel)

	// End of user code

	/**
	 * The constructor.
	 */
	public ModeInformationPrimitiveModel() {
		// Start of user code constructor for ModeInformationPrimitiveModel)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ModeInformationPrimitiveModel)

	// End of user code
	/**
	 * Returns supportedModess.
	 * @return supportedModess 
	 */
	public ArrayList<SupportedModes> getSupportedModess() {
		return this.supportedModess;
	}

}
