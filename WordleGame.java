import java.io.FileNotFoundException;

public class WordleGame {

  //game attributes
  private String userGuess; //the guesses the user makes
  private int guessNum; //the number of guesses
  private String answer; //the puzzle answer
  private WordleLetter[][] wordTracker = new WordleLetter[6][5]; //to store all the guesses of the user

  //Constructor that takes in the puzzle number to obtain the puzzle answer
  public WordleGame(int puzzleNumber) throws FileNotFoundException{

    this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);

  }

  //Method to return the puzzle answer
  public String getAnswer(){

    return this.answer;

  }

  //Method for the user to guess the answer to the puzzle and set the colors of the letters in the guess word
  public void guess(String guessWord){ 

    //making the guess that the user inputs the game guess 
    this.userGuess = guessWord;
    //accumulating the number of guesses every time a guess is made
    this.guessNum = this.guessNum + 1;

    //to traverse the guess word to set the colors of the letters
    for(int i = 0; i < this.userGuess.length(); i ++){

      WordleLetter word = new WordleLetter(userGuess.charAt(i)); //creating a wordle letter for every letter in the guess 
      char letter = word.getLetter(); //getting only the character attribute of the letter

      //setting the letter color as green if it is in the answer word and in the same position
      if(letter == this.answer.charAt(i)){

        word.setColor("green");

      }else if(letter != this.answer.charAt(i)){ //checking if the letter was not in found in the same position in the answer

        //traversing the guess word to check if the letter is found in another position in the answer
        for(int x = 0; x < this.userGuess.length(); x ++){ 

          word.setColor("red"); //to later only turn yellow if the letter is somewhere in the word

          if(letter == this.answer.charAt(x)){ //checking if the letter was found somewhere in the answer

            word.setColor("yellow");
            break; //so there are no further comparisions made and the letter stays yellow

          }
        }
      }
    //putting the wordle letter in the word tracker array, subtracting 1 from the rows to start at the correct position
     this.wordTracker[this.guessNum - 1][i] = word; 
    }
  } 

  //Method to get the number of guesses the user has made
  public int getNumberGuessesSoFar(){

    return this.guessNum;

  }

  //Method to get the wordle letter array containing the guess the user has made
  public WordleLetter[] getGuess(int guessNumber){ 

    //creating a WordleLetter array to store the word letters
    WordleLetter[] guessLetters = new WordleLetter[5];

    //traversing the array
    for(int i = 0; i < wordTracker[guessNumber].length; i++){

      //storing only the current guess in the 1D array, by obtaining it from the 2D array that is storing all the user guesses
      guessLetters[i] = wordTracker[guessNumber][i];

    }

    return guessLetters; //to return the array

  }

  //Method to check if the game has finished
  public boolean isGameOver(){

    //to first check if a guess has not been made yet
    if(this.guessNum == 0){

      return false;

    }else if(isGameWin()){ //to check if the player has already won by getting the correct answer

      return true;

    }else if(this.guessNum >= 6){ //to check if the player has reached their guess limit

      return true;
    }

    return false; //so the game can continue if the player still has guesses and has not guesses correctly

  }

  //Method to check if the game has been won
  public boolean isGameWin(){ //

    //to first check if no guesses have been made or the game has not begin
    if(this.guessNum == 0){

      return false;

    }else if(this.userGuess.equals(this.answer)){ //to check if the player has already won by getting the correct answer

      return true;

    }

    return false; //to return false if the game is not over or is over and the player did not get the correct answer

  }


  public String toString() {
    // result will be used to build the full answer String
    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      // get each letter of each word
      for (int j = 0; j < 5; j++) {
        // concatenate it to the result
        // WordleLetter's toString() is automatically invoked here.
        result += getGuess(i)[j];
      }
      // new line separator between each word
      result += "\n";
    }
    return result;
  }
}
