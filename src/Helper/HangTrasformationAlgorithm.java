package Helper;

import Exception.AlgorithmException;

public class HangTrasformationAlgorithm implements ModeTrasformationAlgorithmStrategy {

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
	
}
