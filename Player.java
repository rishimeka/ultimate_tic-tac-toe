import java.util.*;
/*
* Author: Rishi Raj Manikanta Meka, RXM190057, Section: 002
* Class Objective:
*   - This player object is responsible for:
*       - Determining the game mode
*       - Maintaining whose turn it is
*       - Getting the input from each player
*       - Determining the game mode
* */
public class Player {
    private static char player;  //  Maintains the player character
    private static int gameMode; //  Maintains the game mode
    //  Constructor
    public Player(){
        //  Getting the input for the game mode from the user
        do{
            System.out.print("Please enter a valid game mode (1 for Computer vs Computer, 2 for Player vs Computer, and 3 for Player vs Player): ");
            gameMode = getUserInput();
            if(gameMode < 1 || gameMode > 3)
                System.out.println("Invalid game mode selected.");
        } while (gameMode < 1 || gameMode > 3);
        //  Initializing the player char
        player = 'X';
        System.out.println("Current Player is : " + player);
    }
    //  Changes the players turn (Setter Method)
    public void changePlayer (){
        if(player == 'X')
            player = 'O';
        else
            player = 'X';
        System.out.println("Current Player is : " + player);
    }
    //  Gets the player char (Getter Method)
    public char getPlayer(){
        return this.player;
    }
    //  Gets the player input for the game based on game mode
    public int getAValidInput(){
        switch (gameMode){
            // Ai vs Ai
            case 1:
                return getComputerInput();
            // Computer Vs Player
            case 2:
                if(player == 'X')
                    return getUserInput();
                else
                    return getComputerInput();
            // Player vs Player
            case 3:
                return getUserInput();
        }
        return -1;
    }
    //  Returns a random number as the computer input
    private int getComputerInput(){
            int input = new Random().nextInt(9 - 0);
            System.out.println(input);
            return input;
    }
    //  Returns the user input
    private int getUserInput(){
        return new Scanner(System.in).nextInt();
    }

}