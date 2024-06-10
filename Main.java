/* COP 3503C Assignment 2
This program is written by: Daylen Hendricks */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt(); // Rows
        int n = scan.nextInt(); // Columns
        int s = scan.nextInt(); // # words to find
        scan.nextLine(); // Consume the newline character after the integers

        Element[][] matrix = new Element[m][n]; // Letter matrix
        ArrayList<String>[] searchWords = new ArrayList[s]; // Words to find

        for (int i = 0; i < s; i++) { // Initializing arraylist
            searchWords[i] = new ArrayList<>();
        }

        // Build the matrix
        for (int i = 0; i < m; i++) {
            String input = scan.nextLine();
            String[] chars = input.split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Element(chars[j].charAt(0));
            }
        }

        // Get target words
        for (int i = 0; i < s; i++) {
            String str = scan.nextLine(); // Read in a line or string, and store it in the solution matrix for retrieval later
            searchWords[i].add(str);
        }

        // Find each target word
        for (int i = 0; i < s; i++) {
            String targetWord = searchWords[i].get(0);
            System.out.println("Looking for " + targetWord);
            char[][] solutionMatrix = new char[m][n]; // Reset solution matrix
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    solutionMatrix[row][col] = ' ';
                }
            }
            if (!findWord(matrix, targetWord, solutionMatrix, m, n)) {
                System.out.println(targetWord + " not found!");
            } else {
                printSolution(solutionMatrix, m, n);
            }
            System.out.println();
        }

        scan.close(); // Close scanner
    }

    public static boolean findWord(Element[][] matrix, String targetWord, char[][] solutionMatrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (findAlg(matrix, i, j, targetWord, 0, solutionMatrix)) { // Begin recursion
                    return true;
                }
            }
        }
        return false; // Default if something goes wrong
    }

    public static boolean findAlg(Element[][] matrix, int x, int y, String targetWord, int targetIndex, char[][] solutionMatrix) {
        if (targetIndex == targetWord.length()) {
            return true;
        }

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y].isMarked() || matrix[x][y].isUsed()) {
            return false;
        }

        if (matrix[x][y].isMatch(targetWord.charAt(targetIndex))) {
            matrix[x][y].mark();
            matrix[x][y].use();
            solutionMatrix[x][y] = targetWord.charAt(targetIndex);

            int[] rowDir = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] colDir = {1, 1, 0, -1, -1, -1, 0, 1};

            for (int dir = 0; dir < 8; dir++) {
                int newRow = x + rowDir[dir];
                int newCol = y + colDir[dir];
                if (findAlg(matrix, newRow, newCol, targetWord, targetIndex + 1, solutionMatrix)) {
                    return true;
                }
            }

            // If none of the directions work, backtrack
            matrix[x][y].unMark();
            matrix[x][y].unUse();
            solutionMatrix[x][y] = ' ';
        }
        return false;
    }

    public static void printSolution(char[][] solutionMatrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < columns; j++) {
                System.out.print(solutionMatrix[i][j]);
                if (j < columns - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

class Element { // The elements of the matrix
    private char letter;
    private boolean used; // Already in found word
    private boolean marked; // Isn't in target word

    public Element(char letter) {
        this.letter = letter;
        this.used = false;
        this.marked = false;
    }

    public char getLetter() {
        return this.letter;
    }

    public boolean isMatch(char letter) {
        return this.letter == letter;
    }

    public boolean isMarked() {
        return this.marked;
    }

    public void mark() {
        this.marked = true;
    }

    public void unMark() {
        this.marked = false;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void use() {
        this.used = true;
    }

    public void unUse() {
        this.used = false;
    }
}
