package PE;

public class Q1 {
	public static boolean checkprime(double i){
		for(int j = 2; j<= Math.sqrt(i);j++){
			if(i%j == 0 ) return false;
		}
		return true;
	}

	public static double cp(double i){
		for(int j = (int) Math.sqrt(i); j>1 ;j--){
			if(i%j == 0 ) return j;
		}
		return 0;
	}


	public static void main(String args[]){
		
		
		
	}
	
}
