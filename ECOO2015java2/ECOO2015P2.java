import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solver{
	static int[] vi={0,1,0,-1};
	static int[] vj={1,0,-1,0};
	
	int r,c;
	int[][] grid;
	boolean solvable=false;
	boolean check(int[][] g){
		for(int i=0;i<r;i++){
			int l=1;
			for(int j=1;j<c;j++){
				if(g[i][j]==g[i][j-1] && g[i][j]!=-1){
					l++;
				}
				else{
					l=1;
				}
				if(l>=3){
					return true;
				}
			}
		}
		for(int j=0;j<c;j++){
			int l=1;
			for(int i=1;i<r;i++){
				if(g[i][j]==g[i-1][j] && g[i][j]!=-1){
					l++;
				}
				else{
					l=1;
				}
				if(l>=3){
					return true;
				}
			}
		}
		return false;
	}
	int[][] copyArray(int[][] grid){
		int[][] copy=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				copy[i][j]=grid[i][j];
			}
		}
		return copy;
	}
	int[][] remove(int[][] go){
		int[][] g=copyArray(go);
		for(int i=0;i<r;i++){
			int l=1;
			for(int j=1;j<c;j++){
				if(go[i][j]==go[i][j-1] && go[i][j]!=-1){
					l++;
					/*if(j==c-1 && l>=3){
						for(int k=j-l+1; k<=j;k++){
							g[i][k]=-1;
						}
					}*/
				}
				else{
					/*if(l>=3){
						for(int k=j-l+1; k<=j;k++){
							g[i][k]=-1;
						}
					}*/
					l=1;
				}
				if(l>=3){
					for(int k=j-l+1; k<=j;k++){
						g[i][k]=-1;
					}
				}
			}
			
		}
		for(int j=0;j<c;j++){
			int l=1;
			for(int i=1;i<r;i++){
				if(go[i][j]==go[i-1][j] && go[i][j]!=-1){
					l++;
					/*if(i==r-1 && l>=3){
						for(int k=i-l+1; k<=i;k++){
							g[k][j]=-1;
						}
					}*/
				}
				else{
					/*if(l>=3){
						for(int k=i-l+1; k<=i;k++){
							g[k][j]=-1;
						}
					}*/
					l=1;
				}
				if(l>=3){
					for(int k=i-l+1; k<=i;k++){
						g[k][j]=-1;
					}
				}
			}
		}
		return g;
	}
	int num(int[][] g){
		int numTmp=0;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(g[i][j]!=-1){
					numTmp++;
				}
			}
		}
		return numTmp;
	}
	void output(int[][] g){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(g[i][j]==-1){
					System.out.print(" ");
				}
				else{
					System.out.print(g[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	void dfs(int[][] g){
		//output(g);
		if(num(g)<=0){
			solvable=true;
			return;
		}
		if(solvable){
			return;
		}
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				for(int k=0;k<4;k++){
					int pi=i+vi[k];
					int pj=j+vj[k];
					if(pi>=r || pi<0 || pj>=c || pj<0){
						continue;
					}
					int tmp=g[pi][pj];
					g[pi][pj]=g[i][j];
					g[i][j]=tmp;
					if(check(g)){
						int[][] gp=remove(g);
						//System.out.println("REMOVED");
						//output(gp);
						dfs(gp);
						
					}
					tmp=g[pi][pj];
					g[pi][pj]=g[i][j];
					g[i][j]=tmp;
				}
			}
		}
	}
	
	void solve(Scanner scan){
		r=scan.nextInt();
		c=scan.nextInt();
		scan.nextLine();
		grid=new int[r][c];
		for (int k=0;k<5;k++){
			for(int i=0;i<r;i++){
				String tmp=scan.nextLine();
				for(int j=0;j<c;j++){
					if(tmp.charAt(j)=='X'){
						grid[i][j]=1;
					}
					else{
						grid[i][j]=0;
					}
				}
			}
			solvable=false;
			int[][] g=copyArray(grid);
			dfs(g);
			//System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			if(solvable){
				System.out.print("S");
			}else{
				System.out.print("N");
			}
		}
		System.out.println();
	}
	
	
}
public class ECOO2015P2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("DATA21.txt"));
		while(scan.hasNext()){
			Solver s=new Solver();
			s.solve(scan);
		}
	}
}
