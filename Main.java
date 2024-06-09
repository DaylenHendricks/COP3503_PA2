/* COP 3503C Assignment 2
This program is written by: Daylen Hendricks */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public char[] targetWord;
    public char[] foundWord;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();//rows
        int n = scan.nextInt();//columns
        int s = scan.nextInt();//# words to find
        String input;//current scanner line
        Element[][] matrix = new Element[m][n];//letter matrix
        char[][] solutionMatrix = new char[m][n];
        ArrayList<String>[] searchWords = new ArrayList[s];//words to find

        for (int i = 0; i < s; i++) {//initializing arraylist
            searchWords[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){//build matrix
            input = scan.nextLine();
            for(int j = 0; j < n; j++){
                matrix[i][j] = new Element(input.charAt(j));
            }
        }

        for(int i = 0; i < s; i++){//get target words
            String str = scan.nextLine();//I want to read in a line or string, and store it in the solution matrix for retrieval later
                searchWords[i].add(str);
        }


        for(int i = 0; i < s; i++){//begin recursion "findWord()""
            String targetWord = searchWords[i].get(0);
            findWord(matrix, targetWord, solutionMatrix);
        }


    scan.close();//close scanner
    }

    public static boolean findWord(Element[][] matrix, String targetWord, char[][] solutionMatrix){
            if (findAlg(matrix, 0, 0, targetWord, 0, solutionMatrix) == false) {//begin recursion
                System.out.print("Solution doesn't exist");//if no sol found
                return false;
            }
            else{
                // printSolution(char[][] solutionMatrix, int rows, int columns;
            return true;
            }
    }

    public static boolean findAlg(Element[][] matrix, int x, int y, String targetWord, int targetIndex, char[][] solutionMatrix){
        // String target = searchWords.get(0);

            if(targetIndex == targetWord.length() && matrix[x][y].getLetter() == targetWord.charAt(targetWord.length())){//best case, solution
                return true;
            }
            else{//if not solution

                if (x < 0 || x > matrix[0].length || y < 0 || y > matrix.length || matrix[x][y].isMarked() == false)
                    return false;

                if(matrix[x][y].isMatch(targetWord.charAt(targetIndex))){//isSafe
                    if(matrix[x][y].isMarked())
                        return false;
                    else
                        matrix[x][y].mark();


                    if(findAlg(matrix, x+1, y, targetWord, targetIndex, solutionMatrix)){//right

                    }

                    if(findAlg(matrix, x+1, y-1, targetWord, targetIndex, solutionMatrix)){//down right
                        
                    }

                    if(findAlg(matrix, x, y-1, targetWord, targetIndex, solutionMatrix)){//down
                        
                    }

                    if(findAlg(matrix, x-1, y-1, targetWord, targetIndex, solutionMatrix)){//down left
                        
                    }

                    if(findAlg(matrix, x-1, y, targetWord, targetIndex, solutionMatrix)){//left
                        
                    }

                    if(findAlg(matrix, x-1, y+1, targetWord, targetIndex, solutionMatrix)){//up left
                        
                    }

                    if(findAlg(matrix, x, y+1, targetWord, targetIndex, solutionMatrix)){//up
                        
                    }

                    if(findAlg(matrix, x+1, y+1, targetWord, targetIndex, solutionMatrix)){//up right
                        
                    }
                }
                    return false;
            }
        
    
        }
    public static void printSolution(char[][] solutionMatrix, int rows, int columns){
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

class Element {//the elements of the matrix
    private char letter;
    private boolean used;//already in found word
    private boolean marked;//isn't in target word

    public Element(char letter){
        this.letter = letter;
        this.used = false;
        this.marked = false;
    }
    public char getLetter(){
        return this.letter;
    }
    public boolean isMatch(char letter){
        if(this.letter == letter)
            return true;
        else
            return false;
    }
    public boolean isMarked(){
        if(this.marked = true)
            return true;
        else
            return false;
    }
    public void mark(){
        this.marked = true;
    }
    public void use(){
        this.used = true;
    }
}
