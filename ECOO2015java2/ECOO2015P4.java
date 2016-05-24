import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Solver4{
	int n,area;
	int rec[][];
	boolean taken[];
	boolean map[][];
	int r,c;
	int nSum;
	boolean solved;
	int ans;
	boolean check(int pi,int pj,int wp,int lp){
		//System.out.println("Check i: " +pi+" j: "+pj+ " w "+wp+" l: "+lp +" r "+r+ " c "+c);
		if( pi+wp-1>=r || pj+lp-1>=c){return false;}
		//System.out.print("?? ");
		for(int i=pi;i<pi+wp;i++){
			for(int j=pj;j<pj+lp;j++){
				if(map[i][j]==true){
					return false;
				}
			}
		}
		return true;
	}
	void fill(int pi,int pj,int wp,int lp, boolean fillFlag){
		
		for(int i=pi;i<pi+wp;i++){
			for(int j=pj;j<pj+lp;j++){
				map[i][j]=fillFlag;
			}
		}
	}
	void output(){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(map[i][j]){
					System.out.print(1);
				}
				else{
					System.out.print(0);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	void dfs(){
		//output();
		if(nSum>=area){
			solved=true;
			return;
		}
		if(solved){
			return;
		}
		///find point
		int px=-1,py=-1;
		for(int j=0;j<c;j++){
			for(int i=0;i<r;i++){
				if(map[i][j]==false){
					px=i;py=j;
					break;
				}
			}
			if(px!=-1 && py!=-1){
				break;
			}
		}
		//System.out.println("x: " +px+" y: "+py);
		for(int i=0;i<n;i++){
			if(!taken[i]){
				if(check(px,py,rec[i][0],rec[i][1])){
					//System.out.println("TRUE!");
					fill(px,py,rec[i][0],rec[i][1],true);
					nSum+=rec[i][0]*rec[i][1];
					taken[i]=true;
					dfs();
					taken[i]=false;
					nSum-=rec[i][0]*rec[i][1];
					fill(px,py,rec[i][0],rec[i][1],false);
				}
				if(check(px,py,rec[i][1],rec[i][0])){
					//System.out.println("TRUE!");
					fill(px,py,rec[i][1],rec[i][0],true);
					nSum+=rec[i][0]*rec[i][1];
					taken[i]=true;
					dfs();
					taken[i]=false;
					nSum-=rec[i][0]*rec[i][1];
					fill(px,py,rec[i][1],rec[i][0],false);
				}
			}
			
		}
		
	}
	void solve(Scanner scan){
		n=scan.nextInt();
		area=0;
		ans=-1;
		rec=new int[n][2];
		taken=new boolean[n];
		for(int i=0;i<n;i++){
			rec[i][0]=scan.nextInt();
			rec[i][1]=scan.nextInt();
			area+=rec[i][0]*rec[i][1];
		}
		for(int ri=1;ri<=Math.sqrt(area*1.00)+0.00001;ri++){
			if(area%ri==0){
				r=ri;
				c=area/ri;
				map=new boolean[r][c];
				solved=false;
				for (int i=0; i<n; i++) {
					taken[i]=false;
				}
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						map[i][j]=false;
					}
				}

				nSum=0;
				dfs();
				if(solved){
					ans=Math.max(ans,(r+c)*2);
				}
			}
		}
		if(ans==-1){
			System.out.println("Not Possible");
		}else{
			System.out.println(ans);
		}
	}
}
public class ECOO2015P4 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("DATA41.txt"));
		while(scan.hasNext()){
			Solver4 solve=new Solver4();
			solve.solve(scan);
		}
	}
}
