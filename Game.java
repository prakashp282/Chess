import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	
	
	void positionPlacement(int [][]possiblePosition){

		for(int i=0;i<8;i++){
			if(possiblePosition[i][0]>=0 && possiblePosition[i][0]<8 && possiblePosition[i][1]>=0 && possiblePosition[i][1]<8){
				print(possiblePosition[i][0],possiblePosition[i][1]);
			}
		}
	}
	
	void print(int i, int j){
		int rowValue=i+65;	
		int coloumnValue=j+49;
		System.out.print((char)rowValue);
		System.out.print((char)coloumnValue);
	}
	
	void starFormation(int position[]){
		int row=position[0];
		int coloumn=position[1];
	/*	//first possible logic
		int i=row==0?row:row-1;
		for(;i<8 && i<= row+1 ;i++)
		{
			int j=coloumn==0?coloumn:coloumn-1; 
		
			for(;j<8 && j <= coloumn+1 ;j++){
				if(i==row && j==coloumn)
					continue;
				print(i,j);
			}
			
		}
	*/	
		//Another logic
		int [][]possiblePosition={{row-1,coloumn-1},{row-1,coloumn+1},{row+1,coloumn-1},{row+1,coloumn+1},{row,coloumn+1},{row,coloumn-1},{row-1,coloumn},{row+1,coloumn}};
		positionPlacement(possiblePosition);
	}
	
	void plusFormation(int position[]){
		int row=position[0];
		int coloumn=position[1];
		
		for (int i=0;i<8;i++){
				
			if(i!=row)
			{
			print(i,position[1]);
			}
			
			if(i!=coloumn){
			print(position[0],i);
			}
			
		}
		
	}
	
	void knightFormation(int position[]){				//different logic store all possible position
		int row=position[0];
		int coloumn=position[1];
	
		int [][]possiblePosition={{row-2,coloumn-1},{row-2,coloumn+1},{row+2,coloumn-1},{row+2,coloumn+1},{row+1,coloumn+2},{row-1,coloumn+2},{row+1,coloumn-2},{row-1,coloumn-2}};

		positionPlacement(possiblePosition);
		
	}
	
	void crossFormation(int position[]){
		int row=position[0];
		int coloumn=position[1];
		
		if(row>0)
		for(int i=(row-1),count=1;i>=0 ;i--,count++){
			
			int j=coloumn-count;
			if(j>=0){
				print(i,j);
			}
			
			j=coloumn+count;
			if(j<8){
			print(i,j);
			}
		}
		if(row<7)
		for(int i=row+1,count=1;i<=8 && count < 8-row ;i++,count++){
			
			int j=coloumn-count;
			if(j>=0){print(i,j);}
			
			j=coloumn+count;
			if(j<8){
			print(i,j);}
		}

	}
	
	
	void getKing(String pos){
		int position[]=getPostion(pos);
		starFormation(position);
		
	}
	
	void getRook(String pos){
		
		int position[]=getPostion(pos);
		plusFormation(position);
		
	}
	
	void getBishop(String pos){
		
		int position[]=getPostion(pos);
		crossFormation(position);
	}



	void getQueen(String pos){
	
		int position[]=getPostion(pos);
		plusFormation(position);
		crossFormation(position);
		
	}

		
	void getKnight(String pos){
	
		int position[]=getPostion(pos);
		knightFormation(position);
		
		
	}
	
	
	void getPawn(String pos){

		int position[]=getPostion(pos);
		if(position[0]!=7)
		print(position[0]+1,position[1]);
		else
		System.out.println("no more posible move");
	}


	
	void piecePosition() throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		
		String subInput[]=input.split(" ");
		
		//try to use map later
		
		if(subInput[0].contains("rook")){
			getRook(subInput[1]);
		}
		else if(subInput[0].contains("king")){
			getKing(subInput[1]);
		}
		else if(subInput[0].contains("bishop")){
			getBishop(subInput[1]);
		}
		else if(subInput[0].contains("pawn")){
			getPawn(subInput[1]);
		}
		else if(subInput[0].contains("knight")){
			getKnight(subInput[1]);
		}
		else if(subInput[0].contains("queen")){
			getQueen(subInput[1]);
		}
		else
			System.out.println("INCORRECT ENTRY");
		
	}
	
	
	int[] getPostion(String pos){
		int position[]=new int[2];
		if(pos.length()!=2)
		{System.out.println("ERROR");
		}
		
		char charRow=pos.charAt(0);
		char charColoumn=pos.charAt(1);
		
		
		int row=((int)charRow-65);
		int coloumn=((int)charColoumn-49);
		
		position[0]=row;
		position[1]=coloumn;
		return position;
	}
	
	
	public static void main(String [] args) throws IOException{
		
		Game G=new Game();
		G.piecePosition();
		
		
	}
	
}
