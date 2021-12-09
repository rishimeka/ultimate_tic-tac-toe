public class Board {
    /*
    * Author: Rishi Raj Manikanta Meka, RXM190057, Section: 002
    * Class objective:
    *   - This object acts the individual tic-tac-toe boards in the ultimate tic-tac-toe board
    *   - This board object is responsible for:
    *       - Creating an array of boxes
    *       - Printing out the tic-tac-toe board
    *       - Checking a winner in this board
    *           - A filler method to fill in the open slots if there is a winner in that board
    *       - Checking if the board is full
    *       - Printing out all the legal possible moves
    *       - Setting the player char
    *       - Providing information of weather the user input is valid or not
    * */
    // Array of boxes to make the individual tic-tac-toe board
    private Box[] board;
    private static int temp = 0;
    // Constructor
    public Board(){
        // Initializing the board array with box objects
        board = new Box[9];
        for(int i = 0; i < 9; i++){
            board[i] = new Box((char)(i + '0'));
        }
    }
    // Print function
    public void printBoard(int boardNumber){
        for(int i = temp; i < temp + 3; i++){
            if(i % 3 ==0) {
                System.out.print("   BOARD#" + boardNumber + "	| ");
            }
            System.out.print(board[i].getChar());
            System.out.print(" | ");
            if((i+1) % 3 == 0){
                System.out.print("  ");
            }
        }
        if((boardNumber + 1) % 3 == 0)
            temp += 3;
        if(temp >= 9)
            temp = 0;
    }
    // Checks and returns the winning player
    public char checkWinner(){
        // Checks Horizontals:
        if((board[0].getChar() == board[1].getChar()) && (board[0].getChar()  == board[2].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[0].getChar();
        }
        else if((board[3].getChar() == board[4].getChar()) && (board[3].getChar()  == board[5].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[3].getChar();
        }
        else if((board[6].getChar() == board[7].getChar()) && (board[6].getChar()  == board[8].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[6].getChar();
        }
        // Checks Verticals:
        if((board[0].getChar() == board[3].getChar()) && (board[0].getChar()  == board[6].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[0].getChar();
        }
        else if((board[1].getChar() == board[4].getChar()) && (board[1].getChar()  == board[7].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[1].getChar();
        }
        else if((board[2].getChar() == board[5].getChar()) && (board[2].getChar()  == board[8].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[2].getChar();
        }
        // Checks Diagonals
        if((board[0].getChar() == board[4].getChar()) && (board[0].getChar()  == board[8].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[0].getChar();
        }
        else if((board[6].getChar() == board[4].getChar()) && (board[6].getChar()  == board[2].getChar())){
            fillBoard();  // If there is a winner, fill in the available positions with a '*'
            return board[6].getChar();
        }
        // Checks for a tie
        else if(isFull()){
            return 'T';
        }
        return '-';
    }
    // Checks if the board is full (No possible moves)
    public boolean isFull(){
        for(int i = 0; i < 8; i++){
            if(Character.isDigit(board[i].getChar()))
                return false;
        }
        return true;
    }
    // Checks for possible moves, and prints it out to console
    public void printPossibleMoves(){
        System.out.println("Your possible, legal moves are: ");
        for(int i = 0; i < 9; i++){
            if(Character.isDigit(board[i].getChar())){
                System.out.print(board[i].getChar() + " ");
            }
        }
        System.out.println();
    }
    // Checks for available positions with a '*'
    private void fillBoard(){
        for(int i = 0; i < 9; i++){
            if(Character.isDigit(board[i].getChar())){
                board[i].setChar('*');
            }
        }
    }
    // Sets the player char at the given position
    public void setPlayer(char player, int box){
        board[box].setChar(player);
    }
    // Checks if the given position is available
    public boolean checkAvailable(int box){
        if(isFull())
            return false;
        if(box < 0 || box > 8)
            return false;
        if(Character.isDigit(board[box].getChar())){
            return true;
        }
        return false;

    }
}
