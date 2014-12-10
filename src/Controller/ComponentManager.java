package Controller;

import java.util.ArrayList;

import Model.Component;

public class ComponentManager {

	private ArrayList<Component> components;
	private static ComponentManager instance = null;

	public static ComponentManager getInstance() {
		if (ComponentManager.instance == null)
			ComponentManager.instance = new ComponentManager();
		return ComponentManager.instance;
	}

	private ComponentManager() {
		this.components = new ArrayList<Component>();
	}

//	public ComponentManager(ArrayList<Component> c) {
//		this.components = new ArrayList<Component>(c);
//	}

	public void addComponent(Component c) {
		this.components.add(c);
	}

	public void addComponents(ArrayList<Component> c) {
		this.components = new ArrayList<Component>(c);
	}

	public ArrayList<Component> getComponents() {
		return this.components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public Component getComponent(Component c) {
		for (Component comp : this.getComponents())
			if (comp.equals(c))
				return comp;
		return null;
	}

	public Component getComponentByID(Integer id) {
		for (Component comp : this.getComponents())
			if (comp.getID().equals(id))
				return comp;
		return null;
	}

	public Component getCopyOfComponent(Component c) {
		if (this.getComponent(c) != null) {
			Component comp = new Component();
			comp.fullCopy(c);
			return comp;
		}
		return null;
	}

	public Component getCopyOfComponentByID(Integer id) {
		Component c = this.getComponentByID(id);
		if (c != null) {
			Component comp = new Component();
			comp.fullCopy(c);
			return comp;
		}
		return null;
	}

}
