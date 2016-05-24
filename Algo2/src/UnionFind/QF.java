package UnionFind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QF {
	
	
	
	public static  int root(int i[], int s){
		while(i[s] != s ){
			s = i[s];
		}
		
		return s;
	}
	
	
	
	public static void main(String args[]) throws FileNotFoundException{
		
		//file input
		Scanner sc = new Scanner(new File("src/UF2.txt"));
		
		int arr[] = new int[10];
		
		//initialize array 
		for(int i = 0; i< 10;i++){
			arr[i] = i;
		}
		
		
		while(sc.hasNextInt() == true){
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int unit = arr[i];
			
			for(int k = 0; k<10;k++){
				if(arr[k] == unit){
					arr[k] = arr[j];
				}
			}
			
			for(int ii = 0; ii< 10;ii++){
				System.out.print(arr[ii] + " ");
				
			}
			System.out.println();
		}
		
		for(int i = 0; i< 10;i++){
			System.out.println(arr[i]);
		}
	}
}
