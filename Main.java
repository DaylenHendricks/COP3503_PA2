/* COP 3503C Assignment 2
This program is written by: Daylen Hendricks */

import java.util.Scanner;
import java.util.ArrayList;;

public class Main {
    public char[] targetWord;
    public char[] foundWord;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();//rows
        int n = scan.nextInt();//columns
        int s = scan.nextInt();//# words to find
        char[][] matrix = new char[m][n];//letter matrix
        char[][] searchWords;//words to find

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scan.next().charAt(j);
            }
        }

    }

    public static void printSol(char[][] solutionMatrix, int rows, int columns){
        for(int i = 0; i < rows; i++){
            System.out.println("[");

            for(int j = 0; j < columns - 1; j++){
                System.out.print(solutionMatrix[i][j] + ",");
                if(j + 1 == columns)
                    System.out.print(solutionMatrix[i][j+1]);
            }
            System.out.print("]");
        }
    }
}

class element {//the elements of the matrix
    private int letter;
    private boolean used;//already in found word
    private boolean marked;//isn't in target word

    public element(char letter){
        this.letter = letter;
    }

    public boolean checkMatch(char letter){
        if(this.letter == letter)
            return true;
        else
            return false;
    }

    public boolean markUsed(){
        if(this.marked = true;)
            return true;
        else
            return false;
    }

}
