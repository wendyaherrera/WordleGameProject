public class WordleLetter {

	//private attributes
	private char letter; 
	private String color;

	//Constructor to take in a letter and set it
	public WordleLetter(char letterIn){

		this.letter = letterIn;

	}

	//Method that sets the letter color
	public void setColor(String colorIn){

		this.color = colorIn;

	}

	//Method to check if the WordleLetter color has been set
	public boolean isColorSet(){

		if(this.color == null){ //to check if the color has not been set, using null instead of checking specific colors

			return false;
		}

		return true; //returning true if the color has been set
	}

	//Method to check if the color is green
	public boolean isGreen(){

		if(this.color == null){ //to check if the color has not been set yet

			return false;

		}else if(!this.color.equals("green")){ //to check if the color is set but not green 
			
			return false;
		}

		return true; //returning true if the color has been set and is green
	}

	//Additional method to get the letter character when necessary in any of the other files
	public char getLetter(){
		
		return this.letter;
	}

	public String toString() {
		// Determining the special characters to add at the beginning of the String to change the text color to the right color.
		String colorCode;
		if(color.equals("green")) {
			colorCode = "\u001B[32m";
		} else if(color.equals("yellow")) {
			colorCode = "\u001B[33m";
		} else {
			colorCode = "\u001B[31m";
		}
	
		// The special character to add to the end of the String to signify the end of the color change.
		String resetCode = "\u001B[0m";
	
		// Surrounding the letter with space characters and with the above color changing special characters.
		return String.format(
			"%s %s %s",
			colorCode, letter, resetCode);
	}

}
