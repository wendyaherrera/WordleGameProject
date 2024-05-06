import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank {

  // Method to return the answer word according to the puzzle number
  public static String getAnswerForPuzzleNumber(int puzzleNumber) throws FileNotFoundException {
    // file scanner to read answers.txt.
    Scanner scanner = new Scanner(new File("answers.txt"));
    // Skipping the first puzzleNumber number of words in the file.
    for (int i = 0; i < puzzleNumber; i++) {
      scanner.next();
    }
    // Returning the very next word.
    return scanner.next();
  }

  // Method to check if the word the user guesses is in the dictionary file
  public static boolean checkInDictionary(String proposed) throws FileNotFoundException {
    
    //scanner to scan dictionary file
    Scanner dict = new Scanner(new File("dictionary.txt"));

    //to scan the entire file to look for a match while there are still words
    while(dict.hasNext()){

      //making the word in the file a String variable
      String currentWord = dict.next();

      //checking if the word in the file is the same as the proposed guess word
      if(currentWord.equals(proposed)){ 

        return true;//returning true if they are a match
      }
    }

    return false; //returning false if the end of the file is reached and the word was never found

  }  
}
