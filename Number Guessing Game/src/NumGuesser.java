import java.util.Scanner;


public class NumGuesser 
{
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{	
		System.out.println("Welcome to number guesser!");
		String choice = getUserChoice(keyboard);
		
		while(true) 
		{
			
			switch(choice) 
			{
				case "1" :  setGameParameters(1);
        	    	break;
				case "2" :  setGameParameters(2);
        	    	break;
				case "3" :  setGameParameters(3);
        	    	break;  
				case "0" :  System.out.println("Thanks for playing!");
							System.exit(0);
				default : System.out.println("Please try again");
			}
			
			choice = getUserChoice(keyboard);
		}
	}
	
	// Gets the user's input choice
	private static String getUserChoice(Scanner keyboard) 
	{
		String choice;
		System.out.println("\nChoose your difficulty");
		System.out.println("1: Easy");
		System.out.println("2: Medium");
		System.out.println("3: Hard");
		System.out.println("0: Exit");
		System.out.println("Enter your choice");
		choice = keyboard.nextLine().trim();
		if (choice.isEmpty())
		{
			return " ";
		}
		
		return choice;
	}
	
	// Sets game parameters
	private static void setGameParameters(int value)
	{
		// Amount of guesses allowed by difficulty
		int guessAmount;
		int guessRange;
		
		if (value > 2)
		{
			guessAmount = 3;
			guessRange = (int)(Math.random()*101);
		} else if (value == 2) {
			guessAmount = 5;
			guessRange = (int)(Math.random()*51);
		} else {
			guessAmount = 10;
			guessRange = (int)(Math.random()*10);
		}

		gameStart(guessAmount, guessRange);
	}
	
	private static void gameStart(int guessNums, int guessRange)
	{
		// Number of guesses made by user
		int guesses = 0;
		int guess = 0;
		int i = 0;
		int targetNum = guessRange;
		
		while (guesses < guessNums && guess != targetNum)
		{
			System.out.println(guessNums - i + " Guesses Remaining");
			guess = keyboard.nextInt();
			guesses++;
			
			if (guess == targetNum)
			{
				System.out.println("You got it!");
				gameRestart();
				break;
			} else {
				System.out.println("Incorrect!");
				if(guess < targetNum)
				{
					System.out.println("Target is bigger than " + guess + "!");
				} else {
					System.out.println("Target is smaller than " + guess + "!");
				}
				i++;
			}
		}
		
		// Game Loss
		if (guesses == guessNums) 
		{
			System.out.println("You Lose! The value was: " + targetNum);
			gameRestart();
		}
	}
	
	public static void gameRestart()
	{
		System.out.println("Want to play again? Y or N");
		
		String restartChoice = keyboard.next();
		keyboard.nextLine();
		
		switch(restartChoice) 
		{
			case "N" : 
			case "n" :
				System.out.println("Thanks for playing!");
				System.exit(0);
    		case "Y" : 
    		case "y" :
    			return;
    		default : System.out.println("Please try again");
    	}
	}
}
