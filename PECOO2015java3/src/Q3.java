import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Q3 {

	public static int solver(Scanner sc, int i, int j){

		boolean positions [][][] = new boolean[j][i][j];

		int roadie = (int) Math.ceil((j/2));

		for (int x = 0; x<i; x++){
			String c = sc.next();
			for(int y = 0; y < j; y++){
				if(c.charAt(y) == '-'){
					positions[0][x][y] = true;
				}

				else if(c.charAt(y) == '*'){
					positions[0][x][y] = false;
				}
			}
		}


		for(int n = 1; n<j; n++){
			positions[n] = move(positions[n-1]);

		}
		int smallest = Integer.MAX_VALUE; 

		for(int n = 1; n < j; n++){
			
			if(positions[n][positions[0].length -1][roadie] == true){

				int sol = dfs(positions,n,0,roadie,1);

				if (sol < smallest){
					smallest = sol; 
				}
			}
		}

		return smallest;		
	}

	static int dfs(boolean positions[][][], int position, int depth, int roadie, int time){
		//System.out.println(depth);
		//System.out.println(time);
		//print(positions[position]);

		
		
		if(depth == positions[0].length){
			return time;
		}
		else if(positions [position][positions[0].length - depth-1][roadie] == false){
			//System.out.println(roadie);
			//

			return Integer.MAX_VALUE;
		}



		else {
			int smallest = Integer.MAX_VALUE; 

			for(int n = 1; n < positions.length+1; n++){


				int sol = dfs(positions,(position +n)%positions.length,depth+1,roadie,time+n);

				if (sol < smallest){
					smallest = sol; 
				}

				if(positions [(position +n)%positions.length][positions[0].length - depth-1][roadie] == false){
					//print(positions[position]);
					return smallest;
				}

			}

			if (smallest == Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}

			else {
				return smallest;
			}
		}


	}

	static void print(boolean [][] sta){

		for(int i = 0 ; i < sta.length; i++){
			for(int j =0 ; j < sta[0].length; j++){
				if (sta[i][j]){
					System.out.print("-");
				}
				else{
					System.out.print("*");
				}

			}
			System.out.println();
		}
		System.out.println();
	}


	static boolean[][]  move(boolean ori[][]){

		boolean solution[][] = new boolean[ori.length][ori[0].length];
		for(int i = 0; i < ori.length; i++){
			if (i%2 == 0){
				solution[i][ori[0].length-1] = ori[i][0];  

				for(int j = 0; j < ori[0].length-1 ; j++){
					solution[i][j] = ori[i][j+1]; 
				}

			}
			else if (i%2 == 1){
				solution[i][0] = ori[i][ori[0].length-1];  

				for(int j = 1; j < ori[0].length ; j++){
					solution[i][j] = ori[i][j-1]; 
				}

			}
		}



		return solution;
	}
	public static void main(String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("src/DATA31.txt"));

		for (int i = 0;  i< 10;i++){
			int sol =solver(sc, sc.nextInt(),sc.nextInt());
			if (sol == Integer.MAX_VALUE){
				System.out.println("Not Possible");
			}
			else{
				System.out.println(sol);
			}

		}
	}
}
