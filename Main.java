/* COP 3503C Assignment 2
This program is written by: Daylen Hendricks */

import java.util.Scanner;
import java.util.ArrayList;;

public class Main {
    public char[] targetWord;
    public char[] foundWord;
}

class element {     //the elements of the matrix
    private int letter;
    private boolean used;//true if already in found word
    private boolean marked;//letter isn't in target word

    public element(char letter){
        this.letter = letter;
    }
    public boolean checkMatch(char letter){
        if(this.letter == letter)
            return true;
        else
            return false;
    }

}
