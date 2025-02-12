import java.util.HashMap;
import java.util.Map;

public class WinRecords 
{
	private int winningNum;
	private int guessAmount;
	private double winTime;
	private String difficulty;
	
	public WinRecords(int winningNum, int guessAmount, double winTime, String difficulty)
	{
		this.winningNum = winningNum;
		this.guessAmount = guessAmount;
		this.winTime = winTime;
		this.difficulty = difficulty;
	}
	
	public WinRecords()
	{
		// Default Constructor
	}
	
											// Setters
	public void setWinningNum(int winningNum)
	{
		this.winningNum = winningNum;
	}
	
	public void setGuessAmount(int guessAmount)
	{
		this.guessAmount = guessAmount;
	}
	
	public void setWinTime(double winTime)
	{
		this.winTime = winTime;
	}
	
	public void setDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
	}
	
											// Getters
	public int getWinningNum(int winningNum)
	{
		return winningNum;
	}
	
	public int getGuessAmount(int guessAmount)
	{
		return guessAmount;
	}
	
	public double getWinTime(double winTime)
	{
		return winTime;
	}
	
	public String getDifficulty(String difficulty)
	{
		return difficulty;
	}	
	
											// Methods
	
	/*
	public void addRecord(int winningNum, int guessAmount, double winTime, String difficulty)
	{
		
	}
	*/
	
	public String toString()
	{
		String recordsString = "";
		
		recordsString = recordsString + " Winning Number: " + winningNum + " ----- Guess Amount: " + guessAmount;
		recordsString = recordsString + " ----- Win Time: " + winTime + " ----- Difficulty: " + difficulty;
		
		return recordsString;
	}
	
	private static Integer addRecordIterator = 1;
	static HashMap<Integer, String> allRecords = new HashMap<Integer, String>();
	public void addRecord(WinRecords winRecord)
	{
		allRecords.put(addRecordIterator, winRecord.toString());
		addRecordIterator++;
	}
	
	public static void printRecords()
	{
		System.out.println("\n---------------------------------------------------------------------------------------------");
		for (Integer j : allRecords.keySet())
		{
			System.out.println(j + "" + allRecords.get(j));
		}
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
}