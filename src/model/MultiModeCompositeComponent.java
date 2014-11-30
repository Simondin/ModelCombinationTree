package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MultiModeCompositeComponent.
 * 
 * @author francesco
 */
public class MultiModeCompositeComponent extends MultiModeComponent {
	/**
	 * Description of the property connections.
	 */
	public ArrayList<Connection> connections = new ArrayList<Connection>();

	/**
	 * Description of the property modeInformationCompositeModels.
	 */
	public ModeInformationCompositeModel modeInformationCompositeModels = null;

	/**
	 * Description of the property subComponents.
	 */
	public ArrayList<SubComponent> subComponents = new ArrayList<SubComponent>();

	// Start of user code (user defined attributes for MultiModeCompositeComponent)

	// End of user code

	/**
	 * The constructor.
	 */
	public MultiModeCompositeComponent() {
		// Start of user code constructor for MultiModeCompositeComponent)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for MultiModeCompositeComponent)

	// End of user code
	/**
	 * Returns connections.
	 * @return connections 
	 */
	public ArrayList<Connection> getConnections() {
		return this.connections;
	}

	/**
	 * Returns modeInformationCompositeModels.
	 * @return modeInformationCompositeModels 
	 */
	public ModeInformationCompositeModel getModeInformationCompositeModels() {
		return this.modeInformationCompositeModels;
	}

	/**
	 * Sets a value to attribute modeInformationCompositeModels. 
	 * @param newModeInformationCompositeModels 
	 */
	public void setModeInformationCompositeModels(
			ModeInformationCompositeModel newModeInformationCompositeModels) {
		this.modeInformationCompositeModels = newModeInformationCompositeModels;
	}

	/**
	 * Returns subComponents.
	 * @return subComponents 
	 */
	public ArrayList<SubComponent> getSubComponents() {
		return this.subComponents;
	}

}
