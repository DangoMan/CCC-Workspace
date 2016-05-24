package Week1;
/**
*
*                #####################################################
*                #                                                   #
*                #                       _oo0oo_                     #
*                #                      o8888888o                    #
*                #                      88" . "88                    #
*                #                      (| -_- |)                    #
*                #                      0\  =  /0                    #
*                #                    ___/`---'\___                  #
*                #                  .' \\|     |# '.                 #
*                #                 / \\|||  :  |||# \                #
*                #                / _||||| -:- |||||- \              #
*                #               |   | \\\  -  #/ |   |              #
*                #               | \_|  ''\---/''  |_/ |             #
*                #               \  .-\__  '-'  ___/-. /             #
*                #             ___'. .'  /--.--\  `. .'___           #
*                #          ."" '<  `.___\_<|>_/___.' >' "".         #
*                #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
*                #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
*                #     =====`-.____`.___ \_____/___.-`___.-'=====    #
*                #                       `=---='                     #
*                #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
*                #                                                   #
*                #               ·ð×æ±£ÓÓ         ÓÀÎÞBUG                       #
*                #                                                   #
*                #####################################################
*                                                                       Orz - Randy Lin
*                                 Documentation :DD
*                        Author: Randy Lin
*                        Description: Percolation Algorithm, Using weighted Quick Union
*                        Created date: Sometimes in July,2015
*                        Last modify: July 14,2015
*                
*/
public class Percolation {
	
	public boolean[][] grid;
	public int N;
	
	boolean isUnion = false;
	
	//sorted Union
	public int UF[];
	public int weight[];
	
	
	
	
	public Percolation(int J){
		// create N-by-N grid, with all sites blocked
		
		grid = new boolean[N][N];
		N = J;
		
		//Unionfind structure
		UF = new int[N*N];
		weight = new int[N*N+2];
		
		
		//initialize the grid
		for(int i = 0; i<N ; i++){
			for(int j = 0; j<N;j++){
				grid[i][j] = false;
			}
		}
		
		//init the Union find
		for(int i = 0; i<UF.length;i++){
			UF[i] = i;
			weight[i] = 1;
		}
		
		//setting up the abt varible
		for(int i = 0; i< N; i++){
			UF[i] = -1;
			weight[i] = N;
			
			UF[N*(N-1) + i] = -2;
			weight[N*(N-1) + i]=N;
		}
	}
	
	//find the root of the stuff and things 
	public static  int root(int i[], int s){
		while(i[s] != s ){
			//exit if it reach the dummy node
			if(i[s] == -1){
				return -1;
			}
			
			if(i[s] == -2){
				return -2;
			}
			
			s = i[s];
		}
		
		return s;
	}
	
	
	
	public int getindex(int i, int j){
		return i*N + j;
	}
	
	//union the two variable
	public void Union(int i, int j){
		//This is simple
		int ri = root(UF,i);
		int rj = root(UF,j);
		
		if((ri == -1&& rj == -2)||(ri == -2&& rj == -1)){
			isUnion = true;
		}
		
		else if(ri == -1 ||ri == -2){
			
		}
		
		else if(weight [ri] < weight [rj]){
			UF[ri] = rj; 
			
			weight [rj] += weight[ri];
		}
		
		else {
			UF[rj] = ri; 
			
			weight [ri] += weight[rj];
		}
		
		
	}
	
	public void open(int i, int j){
		if(grid[i][j] = false){
			grid[i][j] = true;
			
			//to the future me, I hate this too dw :D
			if(!(i ==0)){
				if(grid[i-1][j] == false){
					
				}
			}
			
		}
	}
	
	
	public boolean isOpen(int i, int j){
		return grid[i][j];
	}
	
	
	public boolean isFull(int i, int j){
		return !grid[i][j];
		// is site (row i, column j) full?
	}
	public boolean percolates(){ 
		return isUnion;
		
	}

	public static void main(String[] args){
		// test client (optional)
	}
}