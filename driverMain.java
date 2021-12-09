//Author: @Rishi Meka
import java.lang.*;
import java.util.*;
/*
* Author: Rishi Raj Manikanta Meka, RXM190057, Section: 002
* Problem Design:
*   - Create a commandline based tic-tac-toe project that has different game modes (Player vs Player, AI vs AI, and AI vs Player)
* Problem Analysis:
*   - Game Class:
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
*   - Board Class:
*       - Creating an array of boxes
*       - Printing out the tic-tac-toe board
*       - Checking a winner in this board
*           - A filler method to fill in the open slots if there is a winner in that board
*       - Checking if the board is full
*       - Printing out all the legal possible moves
*       - Setting the player char
*       - Providing information of weather the user input is valid or not
*   - Box Class:
*       - Generators individual boxes in each tic-tac-toe board
*   - Player:
*       - Determining the game mode
*       - Maintaining whose turn it is
*       - Getting the input from each player
*       - Determining the game mode
* Test:
*   - 1
*   - 2
*   - 3
* */
public class driverMain {
    public static void main(String[] args) {
        Game game = new Game();
    }
}

