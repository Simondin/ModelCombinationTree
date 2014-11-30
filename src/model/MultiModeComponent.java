package model;
import java.util.ArrayList;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MultiModeComponent.
 * 
 * @author francesco
 */
public abstract class MultiModeComponent {
	/**
	 * Description of the property ports.
	 */
	public ArrayList<Port> ports = new ArrayList<Port>();

	/**
	 * Description of the property mSRMs.
	 */
	public MSRM mSRMs = null;

	/**
	 * Description of the property propertys.
	 */
	public ArrayList<Property> propertys = new ArrayList<Property>();

	// Start of user code (user defined attributes for MultiModeComponent)

	// End of user code

	/**
	 * The constructor.
	 */
	public MultiModeComponent() {
		// Start of user code constructor for MultiModeComponent)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for MultiModeComponent)

	// End of user code
	/**
	 * Returns ports.
	 * @return ports 
	 */
	public ArrayList<Port> getPorts() {
		return this.ports;
	}

	/**
	 * Returns mSRMs.
	 * @return mSRMs 
	 */
	public MSRM getMSRMs() {
		return this.mSRMs;
	}

	/**
	 * Sets a value to attribute mSRMs. 
	 * @param newMSRMs 
	 */
	public void setMSRMs(MSRM newMSRMs) {
		this.mSRMs = newMSRMs;
	}

	/**
	 * Returns propertys.
	 * @return propertys 
	 */
	public ArrayList<Property> getPropertys() {
		return this.propertys;
	}

}
