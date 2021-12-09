public class Box {
    //  Class Objective: This object represents the individual boxes in each tic-tac-toe board
    //  Author: Rishi Raj Manikanta Meka, RXM190057, Section: 002
    private char positionChar;  //  Stores the character that belongs in that box
    public Box(char positionChar){
        this.positionChar = positionChar;
    }
    //  Getter Method for the positionChar
    public char getChar(){
        return positionChar;
    }
    //  Setter Method for the positionChar
    public void setChar(char player){
        positionChar = player;
    }
}