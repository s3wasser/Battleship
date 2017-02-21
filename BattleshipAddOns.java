//By: Sabrina Wasserman
//Date: Friday, February 20, 2015
//Title: Battleship
//Purpose: to generate a program that utilized methods and matrices to simuluate a one player game of battleShip
package tasks;
import java.util.*;
public class BattleshipAddOns {
	//creating global variable to store where the ships will go
	static int [] [] shipGrid = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}};
	static int [] [] userGuessOutputGrid = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0}};
	
	//creating global variables for all of the location values of the ships
	static int horizontalOrVertical;
	static int shipRow;
	static int shipColumn;


	//creating global variable for a random generator
	static Random generator = new Random ();
	
	//creating a global counting variable
	static int counter = 0;
	
	//creating global variables for user guesses
	static int userRowGuess;
	static int userColumnGuess;
	
	//creating global variables to save which ships the users hit/sunk
	static int hitAircraftCarrier = 0;
	static int hitBattleship = 0;
	static int hitSubmarine = 0;
	static int hitCruiser = 0;
	static int hitDestroyer = 0;
	
	//creating static variable for if all the spots on the grid have been guessed
	static int totalGuesses = 0;
	
	/*
	 * Title: shipLocations
	 * Purpose: to run other methods and store the locations of each individual battleship on the grid
	 * @Param: none
	 * @Return: none
	 */
	
	public static void shipLocations() throws Exception
	{
		//calling all ship methods
		shipLocation();
		
			
		//BEGIN: aircraftcarrier locations	
		//setting values on the grid if the ship is vertical
			if (horizontalOrVertical == 0)
			{
				
				//saving values of the ship location
					for (int i = 0; i<5; i++)	
					{
						//saving values into ship grid, using a try catch to make sure they work
						try
						{
							shipGrid [shipRow] [shipColumn+i] = 1;
					
						}
						
						catch (ArrayIndexOutOfBoundsException ex)
						{
							//calling shipLocation method
							shipLocation();
						
							//resetting all originally saved values to 0
							for(int row=0;row<shipGrid.length;row++)
							{
								for (int column = 0; column<shipGrid[row].length;column++)
								{
									shipGrid[row][column] = 0;
								}
							}
							
							//resetting i to reset loop to beginning
							i = -1;
							
						}
						
					}
			}
			
			//setting values on the grid if the ship is vertical
			else
			{
				//saving values of the ship location
				for (int i = 0; i<5; i++)	
				{
					
					//trying to update values of shipGrid, but if it is out of bounds, randomly generating a new location
					try
					{
					shipGrid [shipRow+i] [shipColumn] = 1;
					}
						catch (ArrayIndexOutOfBoundsException ex)
						{
							//resetting all originally saved values to 0
							for(int row=0;row<shipGrid.length;row++)
							{
								for (int column = 0; column<shipGrid[row].length;column++)
								{
									shipGrid[row][column] = 0;
								}
							}
						
							//calling shipLocation method
							shipLocation();
					
						//resetting i to reset loop to beginning
						i = -1;
						
						}
			
				}
			}
			//END of aircraft carrier ship location
			
			//BEGIN: Battleship locations
			//calling shipLocation method to reset ship values for new ship
			shipLocation();
			
			//setting values on the grid if the ship is horizontal
			if (horizontalOrVertical == 0)
			{
				for (int i = 0; i<4;i++)
				{
				
				//using a try catch box the check if the battleship locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i==0)
					{
					for (int z = 0; z<4; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow][shipColumn+z] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					
					//saving battleship values to the grid
					shipGrid [shipRow] [shipColumn+i] = 2;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
					
					//resetting i to reset loop to beginning
					i = -1;
				}
					catch (Exception ex)
					{
						//calling shipLocation method
						shipLocation();
			
						//resetting i to reset loop to beginning
						i = -1;
					}
				}
			
			}
			
			//saving ship values if the ship is vertical
			else
			{
				for (int i = 0; i<4;i++)
				{
				
				//using a try catch box the check if the battleship locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i ==0)
					{
					for (int z = 0; z<4; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow+z][shipColumn] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					//saving battleship values to the grid
					shipGrid [shipRow+i] [shipColumn] = 2;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
				catch (Exception ex)
				{
					//calling shipLocation method
					shipLocation();
			
				//resetting i to reset loop to beginning
				i = -1;
					}
				}
			
			}
			
			//END of Battleship
			//calling shipLocation method to reset ship values
			shipLocation();
			//BEGIN: submarine
			if (horizontalOrVertical == 0)
			{
				for (int i = 0; i<3;i++)
				{
				
				//using a try catch box the check if the submarine locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i==0)
					{
					for (int z = 0; z<3; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow][shipColumn+z] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					
					//saving submarine values to the grid
					shipGrid [shipRow] [shipColumn+i] = 3;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
					catch (Exception ex)
					{
						//calling shipLocation method
						shipLocation();
			
						//resetting i to reset loop to beginning
						i = -1;
					}
				}
			
			}
			
			//saving ship values if the ship is vertical
			else
			{
				for (int i = 0; i<3;i++)
				{
				
				//using a try catch box the check if the submarine locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i ==0)
					{
					for (int z = 0; z<3; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow+z][shipColumn] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					//saving submarine values to the grid
					shipGrid [shipRow+i] [shipColumn] = 3;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
				catch (Exception ex)
				{
				//calling submarine method again to reset values of the ship
				shipLocation();
			
				//resetting i to reset loop to beginning
				i = -1;
					}
				}
			}
			
			//END submarine location
			//BEGIN: criuser locations
			//calling shipLocation method to reset ship values
			shipLocation();
			if (horizontalOrVertical == 0)
			{
				for (int i = 0; i<3;i++)
				{
				
				//using a try catch box the check if the cruiser locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i==0)
					{
					for (int z = 0; z<3; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow][shipColumn+z] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					
					//saving cruiser values to the grid
					shipGrid [shipRow] [shipColumn+i] = 4;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
					catch (Exception ex)
					{
						//calling shipLocation method
						shipLocation();
			
						//resetting i to reset loop to beginning
						i = -1;
					}
				}
			
			}
			
			//saving ship values if the ship is vertical
			else
			{
				for (int i = 0; i<3;i++)
				{
				
				//using a try catch box the check if the submarine locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i ==0)
					{
					for (int z = 0; z<3; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow+z][shipColumn] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					//saving cruiser values to the grid
					shipGrid [shipRow+i] [shipColumn] = 4;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
				catch (Exception ex)
				{
				//calling cruiser method again to reset values of the ship
				shipLocation();
			
				//resetting i to reset loop to beginning
				i = -1;
					}
				}
			}
			
			//END cruiser locations
			//BEGIN destroyer locations
			//calling shipLocation method to reset ship values
			shipLocation();
			if (horizontalOrVertical == 0)
			{
				for (int i = 0; i<2;i++)
				{
				
				//using a try catch box the check if the destroyer locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i==0)
					{
					for (int z = 0; z<2; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow][shipColumn+z] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					
					//saving cruiser values to the grid
					shipGrid [shipRow] [shipColumn+i] = 5;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
					catch (Exception ex)
					{
						//calling shipLocation method
						shipLocation();
			
						//resetting i to reset loop to beginning
						i = -1;
					}
				}
			
			}
			
			//saving ship values if the ship is vertical
			else
			{
				for (int i = 0; i<3;i++)
				{
				
				//using a try catch box the check if the destroyer locations will work
				try
				{
					//checking (the first time only) to see if all values are in bounds and working
					if (i ==0)
					{
					for (int z = 0; z<2; z++)
					{
						//checking if another ship is in the desired location
						if (shipGrid[shipRow+z][shipColumn] !=0)
						{
							throw new Exception ("Ship location already taken");
						}
					}
					}
					//saving cruiser values to the grid
					shipGrid [shipRow+i] [shipColumn] = 5;
				}
				catch (ArrayIndexOutOfBoundsException ex)
				{
					//calling shipLocation method
					shipLocation();
				
					//resetting i to reset loop to beginning
					i = -1;
				}
				catch (Exception ex)
				{
				//calling destroyer method again to reset values of the ship
				shipLocation();
			
				//resetting i to reset loop to beginning
				i = -1;
					}
				}
			}
	}
	
	
	/*
	 * Title: shipLocation
	 * Purpose: to randomly find and choose the location of the ships
	 * @Param: none
	 * @Return: none
	 */
	
	public static void shipLocation()
	{
		//checking if the ship will lie horizontally or vertically
				//NOTE: 0 = horizontal, 1 = vertical￼
		horizontalOrVertical = generator.nextInt(2);
		shipRow = generator.nextInt(10)+1;
		shipColumn = generator.nextInt(10)+1;
		
	}
	
	/*
	 * Title: userGuesses
	 * Purpose: to obtain the user's guess and update the ship grid
	 * @Param: none
	 * @Return: none
	 */
	
	public static void userGuesses() throws Exception
	{
		
		
		//creating scanners
		Scanner kboard = new Scanner (System.in);
		Scanner yboard = new Scanner (System.in);
	
		
				
		//creating for loop to account for invald input
		for (int i = 0; i<1; i++)
		{
		
			//trying to obtain the user's input
			try
			{
			//prompting the user
				System.out.println("Please enter the row letter and column number you would like to guess (from A-J for row, from 1-10 for column):");	
				
				//saving the user's row guess
				String userGuess = kboard.nextLine();
				String userRow = userGuess.charAt(0) + "";
				
				//saving the user's column guess
				userColumnGuess = Integer.parseInt(userGuess.substring(1)+""); 
				userColumnGuess = userColumnGuess-1;
			
				//throwing exception if the column number is out of bounds
				if (userColumnGuess>9 || userColumnGuess<0)
				{
					throw new Exception ("Column number out of bounds");
				}
				
				
					//saving user's row guess to a numeric value
				if (userRow.equalsIgnoreCase("a"))
				{
					userRowGuess = 0;
				}
				else if (userRow.equalsIgnoreCase("b"))
				{
					userRowGuess = 1;
				}
				else if (userRow.equalsIgnoreCase("c"))
				{
					userRowGuess = 2;
				}
				else if (userRow.equalsIgnoreCase("d"))
				{
					userRowGuess = 3;
				}
				else if (userRow.equalsIgnoreCase("e"))
				{
					userRowGuess = 4;
				}
				else if (userRow.equalsIgnoreCase("f"))
				{
					userRowGuess = 5;
				}
				else if (userRow.equalsIgnoreCase("g"))
				{
					userRowGuess = 6;
				}
				else if (userRow.equalsIgnoreCase("h"))
				{
					userRowGuess = 7;
				}
				else if (userRow.equalsIgnoreCase("i"))
				{
					userRowGuess = 8;
				}
				else if (userRow.equalsIgnoreCase("j"))
				{
					userRowGuess = 9;
				}
			
				//setting user's guess to cause an exception and restart the loop if the value is not correct
				else 
				{
					throw new Exception ("Your row number is out of bounds");
				}
			}
				catch (InputMismatchException ex)
				{
					i = -1;
					System.out.println("Invalid input. Please re-enter a coordinate");
				}
				catch (Exception ex)
			{
					i = -1;
					System.out.println("Invalid input. Please re-enter a coordinate");
			}
			
		}
			
		//updating counter
		counter++;
		
		//calling grid check method
		gridCheck();
		
		
		
	}
	
	/*
	 * Title: gridCheck
	 * Purpose: to check if the user's guesses are a hit or miss
	 * @Param: none
	 * @Return: none
	 */
	
	public static void gridCheck () throws Exception
	{
		//checking if the user has a hit or miss
		if (shipGrid [userRowGuess] [userColumnGuess] == 1 || shipGrid [userRowGuess] [userColumnGuess] == 2 || shipGrid [userRowGuess] [userColumnGuess] == 3||shipGrid [userRowGuess] [userColumnGuess] == 4||shipGrid [userRowGuess] [userColumnGuess] == 5)
		{
					//informing the user that they hit a ship
					System.out.println("hit!");
			
						//updating the user's guess matrix
						userGuessOutputGrid [userRowGuess] [userColumnGuess] = 1;
			
						//printing user's matrix
						System.out.println("Here is your updated board");
				for(int i=0;i<userGuessOutputGrid.length;i++)
				{
					for (int j=0;j<userGuessOutputGrid[i].length;j++)
					{
						
						System.out.print(userGuessOutputGrid [i][j] + " ");
					}
					System.out.println();
				}
			
				//checking if the user sunk a ship
				//updating how many coordinates of each ship has been hit to see if the ship has been sunk
				if (shipGrid [userRowGuess] [userColumnGuess] == 1)
				{
					hitAircraftCarrier = hitAircraftCarrier+1;
					if (hitAircraftCarrier ==5)
					{
						System.out.println("You sunk the aircraft carrier!");
					}
				}
		
			else if (shipGrid[userRowGuess] [userColumnGuess] == 2)
			{
				hitBattleship = hitBattleship+1;
				if (hitBattleship ==4)
				{
					System.out.println("You sunk the battleship");
				}
			}
			else if (shipGrid [userRowGuess][userColumnGuess] ==3)
			{
				hitSubmarine = hitSubmarine+1;
				if (hitSubmarine ==3)
				{
					System.out.println("You sunk the submarine!");
				}
			}
			else if (shipGrid [userRowGuess] [userColumnGuess] == 4)
			{
				hitCruiser = hitCruiser+1;
				if (hitCruiser==3)
				{
					System.out.println("You sunk the cruiser!");
				}
			}	
				
			else if (shipGrid [userRowGuess] [userColumnGuess] ==5)
			{
				hitDestroyer = hitDestroyer+1;
				if (hitDestroyer ==2)
				{
					System.out.println("You sunk the Destroyer!");
				}

				//setting the ship grid value to 6 (6 will represent a hit)
				shipGrid [userRowGuess] [userColumnGuess] = 6;
	
			}
		
	
		}
		//if the user gets a miss
		else if (shipGrid[userRowGuess] [userColumnGuess] == 0)
		{
			//outputting "miss" to user
			System.out.println("Miss!");
			
			//updating value of user's guesses matrix
			userGuessOutputGrid [userRowGuess] [userColumnGuess] = 2;
			
			//setting the ship grid value to 6 (7 will represent a miss)
			shipGrid [userRowGuess] [userColumnGuess] = 7;
			
			//printing user's matrix
			System.out.println("Here is your updated board");
			for(int i=0;i<userGuessOutputGrid.length;i++)
			{
				for (int j=0;j<userGuessOutputGrid[i].length;j++)
				{
					
					System.out.print(userGuessOutputGrid [i][j] + " ");
				}
				System.out.println();
			}
		}
		//if the user guesses a spot already guessed
		else
		{
			System.out.println("You already guessed this spot!");
		}
		
		
		//checking if all of the ships/places have been guessed
		for (int i = 0; i<shipGrid.length; i++)
		{
			for (int j = 0; j<shipGrid.length;j++)
			{
				if (shipGrid [i] [j] == 0 || shipGrid [i] [j] == 6 || shipGrid [i] [j] == 7 )
				{
					totalGuesses++;
				}
			}
		}
		
		//ending program if user guessed all spots
		if (hitAircraftCarrier ==5 && hitBattleship == 4 && hitSubmarine ==3 && hitCruiser ==3 && hitDestroyer ==2)
		{
			System.out.println("You have completed the game!");
			System.out.println("You took "+counter+" rounds to win the game! Congrats!");
			System.out.println("Thanks for playing!");
			
		}
		else
		{
			userGuesses();
		}
		}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		//calling shipLocations to set the coordinates of the ship for the game
		shipLocations();
		
		
		//Welcoming user
		System.out.println("Welcome to Battleship!");
		System.out.println("Please note: when outputting your grid:");
		System.out.println("2 = miss");
		System.out.println("1 = hit");
		System.out.println("0 = not guessed");
		System.out.println();
		
		//calling user guesses column to allow the user to input their guess
		userGuesses();
		
		
	}
	
	
	
}
