public class Game {
    /*
    * Author: Rishi Raj Manikanta Meka, RXM190057, Section: 002
    * Class objectives:
    *   - This method initializes the ultimate tic-tac-toe board and plays the game
    *   - This class is responsible for:
    *       - Creating and initializing the ultimate tic-tac-toe board and the winner board
    *           - The winner board keeps tack of who is the winner in each individual board in the ultimate board
    *       - Creating a player object
    *       - Getting the player input for the board number and the box number
    *       - Playing the game until there is a winner
    *           - When the game is complete, then printing out the results of a game
    *       - Printing out the ultimate board and the winner for each board
    *       - Validates the player input for the board number
    *       - Updating the winners array when there is a winner in a certain board
    *       - Checking for a winner
    *       - Checking for a draw
    * */
    private Board[] ultimateBoard = new Board[9]; // Ultimate board
    private Player player; // Player object
    private char[] winnerBoard = new char[9]; // Array to keep track of winner in each board
    private int curBoard; // Keeps track of the current board
    public Game(){
        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
        // Initializing the ultimate tic-tac-toe board and the winner board
        for(int i = 0; i < 9; i++){
            ultimateBoard[i] = new Board();
            winnerBoard[i] = '-';
        }
        // Starts the game
        printBoard();
        player = new Player();
        getBoardNumber();
        playGame();
    }
    // Gets the board number
    private void getBoardNumber(){
        System.out.println("Please select a valid board:");
        // Input validation loop
        do {
            System.out.print("Selected Board : ");
            // Gets the input from the player
            curBoard = player.getAValidInput();
            // Input validation
            if(invalidateBoard())
                System.out.println("Please select a valid board:");
        } while(invalidateBoard());
    }
    // Gets the input for the square
    private void getInput(){
        System.out.println("Please select a valid square on the selected board: " + curBoard);
        // temp variable to store the player input
        int input;
        do {
            System.out.print("Selected Square : ");
            input = player.getAValidInput();
            // input validation
            if(!ultimateBoard[curBoard].checkAvailable(input))
                System.out.println("Please select a valid square on the selected board: " + curBoard);
        } while(!ultimateBoard[curBoard].checkAvailable(input));
        // sets that position to the player char
        ultimateBoard[curBoard].setPlayer(player.getPlayer(), input);
        // updates the current board to the player input
        curBoard = input;
    }
    private void playGame(){
        // This loop runs while there is no winner or tie declared
        while(Character.isDigit(getWinner())) {
            // Checks if the curBoard is a valid bord or not, if it is not a valid board then, the user needs to provide an input
            if (invalidateBoard()) {
                getBoardNumber();
            }
            // Instruction to print out all the possible moves
            ultimateBoard[curBoard].printPossibleMoves();
            // Gets the input from the player
            getInput();
            // Sets the winner board array
            setWinnerBoard();
            // Prints out the ultimate board
            printBoard();
            // If there is no winner, we want to change the player or switch players
            if(Character.isDigit(getWinner()))
                player.changePlayer();
        }
        // Prints out the final winner of the game
        System.out.println("Game winner is: " + getWinner());
    }
    // Print method
    private void printBoard(){
        int startingBoardNumber = 0;
        for(int lineNum = 0; lineNum < 9; lineNum++) {
            if(lineNum < 3)
                startingBoardNumber = 0;
            else if(lineNum < 6)
                startingBoardNumber = 3;
            else
                startingBoardNumber = 6;
            int max = startingBoardNumber + 3;
            for (; startingBoardNumber < max; startingBoardNumber++) {
                ultimateBoard[startingBoardNumber].printBoard(startingBoardNumber);
            }
            System.out.println();
        }
        System.out.println();
        // Printing out the winners for each board
        for(int i = 0; i < 9; i++){
            if(winnerBoard[i] == 'X' || winnerBoard[i] == 'O'){
                System.out.println("The Board#" + i + " winner is " + winnerBoard[i]);
            }
            else if(winnerBoard[i] == 'T')
                System.out.println("The Board#" + i + " resulted in a draw");
        }
        System.out.println();
    }
    // Validation for curBoard
    private boolean invalidateBoard(){
        if(ultimateBoard[curBoard].isFull())
            return true;
        if(curBoard < 0 || curBoard > 8)
            return true;
        if(winnerBoard[curBoard] == '-')
            return false;
        return true;
    }
    // Gets the winners for each board in the ultimate tic-tac-toe board, and sets the winner array
    private void setWinnerBoard(){
        for(int i = 0; i < 9; i++){
            winnerBoard[i] = ultimateBoard[i].checkWinner();
        }
    }
    // Gets the winning player
    private char getWinner(){
        // Horizontals
        if((winnerBoard[0] == winnerBoard[1]) && (winnerBoard[0] == winnerBoard[2]) && (winnerBoard[0] == 'X' || winnerBoard[0] == 'O')){
            return winnerBoard[0];
        }
        else if((winnerBoard[3] == winnerBoard[4]) && (winnerBoard[3] == winnerBoard[5]) && (winnerBoard[3] == 'X' || winnerBoard[3] == 'O')){
            return winnerBoard[3];
        }
        else if((winnerBoard[6] == winnerBoard[7]) && (winnerBoard[6] == winnerBoard[8]) && (winnerBoard[6] == 'X' || winnerBoard[6] == 'O')){
            return winnerBoard[6];
        }
        // Verticals:
        if((winnerBoard[0] == winnerBoard[3]) && (winnerBoard[0]  == winnerBoard[6]) && (winnerBoard[0] == 'X' || winnerBoard[0] == 'O')){
            return winnerBoard[0];
        }
        else if((winnerBoard[1] == winnerBoard[4]) && (winnerBoard[1] == winnerBoard[7]) && (winnerBoard[1] == 'X' || winnerBoard[1] == 'O')){
            return winnerBoard[1];
        }
        else if((winnerBoard[2] == winnerBoard[5]) && (winnerBoard[2]  == winnerBoard[8]) && (winnerBoard[2] == 'X' || winnerBoard[2] == 'O')){
            return winnerBoard[2];
        }
        // Diagonals
        if((winnerBoard[0] == winnerBoard[4]) && (winnerBoard[0]  == winnerBoard[8]) && (winnerBoard[0] == 'X' || winnerBoard[0] == 'O')){
            return winnerBoard[0];
        }
        else if((winnerBoard[6] == winnerBoard[4]) && (winnerBoard[6]  == winnerBoard[2]) && (winnerBoard[6] == 'X' || winnerBoard[6] == 'O')){
            return winnerBoard[6];
        }
        // Checks for draws
        else if(checkDraw()){
            return 'T';
        }
        // Returns a digit if there is no winner
        return '1';
    }
    // Checks for draws by checking if the ultimate board is full
    private boolean checkDraw(){
        for(int i = 0; i < 8; i++){
            if(!ultimateBoard[i].isFull())
                return false;
        }
        return true;
    }
}
