package Helper;

public class ModeTranformationStrategyContext {
	
	private ModeTrasformationAlgorithmStrategy _algorithm;
	
	public ModeTranformationStrategyContext(ModeTrasformationAlgorithmStrategy algo){
		this._algorithm = algo;
	}
	
	public void executeAlgorithm(){
		this._algorithm.execute();
	}
}
