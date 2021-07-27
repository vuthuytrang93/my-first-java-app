/** 
This class works as  a codebreaker
@author Trang Vu
*/

import java.util.*;


public class Decryption{
	public static void main ( String [] args){
		Scanner sc=new Scanner(System.in);
		int	col = 1;
		String inputCode= "";
		while (col != 0) {
			//scan no of column
			Scanner line = new Scanner (sc.nextLine());
			if (line.hasNextInt()) {
				col = line.nextInt();
//				System.out.println(col);
			}
			else {
				inputCode= line.next();
//				System.out.println(inputCode);
				//set variables
				int length = inputCode.length();
				int row = (length/col);
				boolean evenCol = true;
				boolean evenRow = true;
				int currentChar = 0;
				
				//create array
				char [][] matrix = new char [row][col];
				
				
				//assign value column by comlumn
				for(int j = 0;j<col; j++){
					//if it's even column, assign from bottom up
					if (evenCol){
						for(int i=(row-1); i>-1; i--){
						matrix[i][j]= inputCode.charAt(currentChar);
						currentChar++;
						}
					}
					//if it's odd column, assign from top down
					else{
						for(int i=0;i<row;i++){
						matrix[i][j]= inputCode.charAt(currentChar);
						currentChar++;
						 }
					}
					evenCol=!evenCol;
				}
				
				//print out row by row
				
				for (int i = 0; i<row; i++){
					//if it's even row, print left to right
					if(evenRow){
						for (int j = 0; j<col; j++){
						System.out.print(matrix[i][j]);
						}
					} 
					//if it's odd row, print right to left 
					else{
						for(int j=(col-1); j>-1; j--){
						System.out.print(matrix[i][j]);
						}
					}
					evenRow = !evenRow;
				}
				System.out.println("");
			}
			
		}	
	}
}

