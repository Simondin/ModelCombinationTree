package Helper;

/**
 * Context of the Algorithm Strategy Pattern.
 * This class has the resposability to execute the requested algorithm
 * @author francesco
 *
 */
public class ModeTranformationStrategyContext {
	
	private ModeTransformationAlgorithmStrategy _algorithm;
	
	public ModeTranformationStrategyContext(ModeTransformationAlgorithmStrategy algo){
		this._algorithm = algo;
	}
	
	public void executeAlgorithm(){
		this._algorithm.execute();
	}
}
