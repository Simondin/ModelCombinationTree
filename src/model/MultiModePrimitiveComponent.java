package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MultiModePrimitiveComponent.
 * 
 * @author francesco
 */
public class MultiModePrimitiveComponent extends MultiModeComponent {
	/**
	 * Description of the property behaviors.
	 */
	public ArrayList<Behavior> behaviors = new ArrayList<Behavior>();

	/**
	 * Description of the property modeInformations.
	 */
	public ArrayList<ModeInformationPrimitiveModel> modeInformations = new ArrayList<ModeInformationPrimitiveModel>();

	// Start of user code (user defined attributes for MultiModePrimitiveComponent)

	// End of user code

	/**
	 * The constructor.
	 */
	public MultiModePrimitiveComponent() {
		// Start of user code constructor for MultiModePrimitiveComponent)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for MultiModePrimitiveComponent)

	// End of user code
	/**
	 * Returns behaviors.
	 * @return behaviors 
	 */
	public ArrayList<Behavior> getBehaviors() {
		return this.behaviors;
	}

	/**
	 * Returns modeInformations.
	 * @return modeInformations 
	 */
	public ArrayList<ModeInformationPrimitiveModel> getModeInformations() {
		return this.modeInformations;
	}

}
