package Helper;

import java.util.ArrayList;

import Exception.AlgorithmException;
import Model.Component;
import Model.Mode;

/**
 * Implementation of the Strategy Interface with the Hang algorithm
 * 
 * @author francesco
 *
 */
public class HangTransformationAlgorithm implements ModeTransformationAlgorithmStrategy {
	
	private int lampdaN;
	private Component TOP;
	private ArrayList<Component> mtc_nodes;
	
	@Override
	public void execute() {
		try{
			int x=100;
			do{
				if(x>100)
					throw new AlgorithmException();
				x--;
			}while(x==0);
		}catch(AlgorithmException ex){
			ex.printStackTrace();
		}
	}
	
	public HangTransformationAlgorithm(){
		this.mtc_nodes = new ArrayList<Component>();
	}
	
	
	public void constructMCT(Component n, int depthN){
		Component mct_node = null;
		if(depthN == 0){
			this.TOP = new Component();
			this.mtc_nodes.add(this.TOP);
			for(Mode modes: n.getModes()){
				mct_node = n;
				mct_node.setModes(modes);
				//mct_node = new Component(modes.getModeValue());
				//mct_node.setChildren(n.getChildren());
				try {
					//this.getTOP().addChild(mct_node);
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.mtc_nodes.add(mct_node);
				this.constructMCT(mct_node, 1);
			}
		} else if(depthN == 1){
			this.TOP = n;
			for(Component children : n.getChildren()){
				for(Mode modes: children.getModes()){
					mct_node = children;
					mct_node.setModes(modes);
					try {
						//this.getTOP().addChild(mct_node);
					} catch (Exception e) {
						e.printStackTrace();
					}
					this.mtc_nodes.add(mct_node);
					this.constructMCT(mct_node, 2);
				}
			}
			
		} else if(depthN >= 2){
			
		}
	}

	public int getLampdaN() {
		return lampdaN;
	}

	public void setLampdaN(int lampdaN) {
		this.lampdaN = lampdaN;
	}

	public Component getTOP() {
		return TOP;
	}

	public void setTOP(Component tOP) {
		TOP = tOP;
	}

	public ArrayList<Component> getMtc_nodes() {
		return mtc_nodes;
	}

	public void setMtc_nodes(ArrayList<Component> mtc_nodes) {
		this.mtc_nodes = mtc_nodes;
	}
	
}
