import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Method to start the game
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {

        //Prompting the user to choose the puzzle number
        System.out.println("Hello player! Please enter the number for the puzzle you would like to play (between 0 and 2315) : ");
        int puzzleChoice = scanner.nextInt();
        //creating a game with the user input
        WordleGame game = new WordleGame(puzzleChoice);
        return game; 
    }

    // Method to play the game
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {

        //To keep playing while the game has not finished
        while(!game.isGameOver()){

            //to prompt the user to make a guess
            System.out.println("Please enter the 5 letter word that is your guess: ");
            String guessWord = scanner.next();

            //checking if the word is a valid dictionary word
            if(WordBank.checkInDictionary(guessWord)){

                game.guess(guessWord);

            }else{

                //to prompt the user if the word is not value
                System.out.println("That is not a valid word. Please try again: ");
            }

            //To print the state of the game
            System.out.println(game.toString());
            //To check if the player has won so the game can conclude if they did
            game.isGameWin();

        }
    }

    // Method to report the final game outcome to the user
    public static void reportGameOutcome(WordleGame game) {
        
        //To check if the game is over and the player won
        if(game.isGameWin() && game.isGameOver()){

            System.out.println("You Won!"); //informing the user

        }else{ //since the method is only called when the game is over, we can assume the player lost in this else statement

            System.out.println("The answer was " + game.getAnswer()); //to inform the user
        }
    }

    //Method to begin, play, and end a game
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}
