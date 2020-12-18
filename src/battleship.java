import java.util.Random;
import java.util.Scanner;
public class battleship
{
	//the static variable "yourShip" and "cpuShip" will keep track of how many ships a player has.
	//the static variable cpu/user ExtraTurns will keep track of extra turns cause by hitting a grenade.
	public static int yourShip = 6;
	public static int cpuShip = 6;
	public static int cpuExtraTurns = 0;
	public static int userExtraTurns = 0;
	
	//method to show the board
	public static void showboard(position[][] positionObjects)
	{
		System.out.println("\n   A  B  C  D  E  F  G  H");
		for(int row = 0 ; row < 8 ; row++)
		{
			System.out.print((row+1) + "  ");
			for(int column = 0 ; column < 8 ; column++)
			{
                if(positionObjects[row][column].getCalled() == true){
                    System.out.print("*"+"  ");
                }     
				if(positionObjects[row][column].getType() == "nothing"){
					System.out.print("-"+"  ");
				}
				else if((positionObjects[row][column].getType() == "ship") && (positionObjects[row][column].getOwner() == "user") && (positionObjects[row][column].getCalled() == false)){
                    System.out.print("B"+"  ");
                }
                else if((positionObjects[row][column].getType() == "grenade") && (positionObjects[row][column].getOwner() == "user") && (positionObjects[row][column].getCalled() == false)){
                    System.out.print("G"+"  ");
                }     
                else if((positionObjects[row][column].getType() == "ship") && (positionObjects[row][column].getOwner() == "computer") && (positionObjects[row][column].getCalled() == false)){
                    System.out.print("b"+"  ");
                }
                else if((positionObjects[row][column].getType() == "grenade") && (positionObjects[row][column].getOwner() == "computer") && (positionObjects[row][column].getCalled() == false)){
                    System.out.print("g"+"  ");
                }
			}
			System.out.println();
		}
	}
	
	public static void PlaceTokens(position[][] positionObjects)
	{
		char c;
		int row, column = 0 ;
		Scanner kb = new Scanner(System.in);
		System.out.println("\nRemember you and your opponent will have 6 ships and 4 grenades.");
		System.out.println("\nLets place your 6 battleships!");
		System.out.println("Please enter a letter from A to H and a number from 1 to 8.");
		
		int s = 0;
		while(s < 6)
		{
			System.out.println("Enter your letter...");
			c = kb.next().charAt(0);
		
			if(c == 'A' || c == 'a')
				column = 0;
			else if(c == 'B' || c == 'b')
				column = 1;
			else if(c == 'C' || c == 'c')
				column = 2;
			else if(c == 'D' || c == 'd')
				column = 3;
			else if(c == 'E' || c == 'e')
				column = 4;
			else if(c == 'F' || c == 'f')
				column = 5;
			else if(c == 'G' || c == 'g')
				column = 6;
			else if(c == 'H' || c == 'h')
				column = 7;
			else
			{
				System.out.println("\nInvalid input"
						+ "\nPlease enter a letter from A to H");
				continue;
			}
		
			System.out.println("\nEnter your number...");
			row = kb.nextInt();
			while(row < 1 || row > 8)
			{
				System.out.println("\nInvalid input."
						+ "\nPlease enter a number from 1 to 8.");
				row = kb.nextInt();
			}
		
			if(positionObjects[row-1][column].getType() == "ship")
			{
				System.out.println("\nYou have already chosen this coordinate."
						+ "\nPlease choose a different coordinate");
				s--;
			}
		
			positionObjects[row-1][column].setType("ship");
			positionObjects[row-1][column].setOwner("user");
		
			s++;
			showboard(positionObjects);
		}
		System.out.println("\nGreat your ships have been placed!"
				+ "\nYou also have 4 grenades.");
		System.out.println("Please enter your coordinates"
				+ " to place yours grenades."
				+ "A letter from A to H and a number from 1 to 8");
		
		int g = 0;
		while(g < 4)
		{ 
			System.out.println("\nEnter your letter...");
			c = kb.next().charAt(0);
		
			if(c == 'A' || c == 'a')
				column = 0;
			else if(c == 'B' || c == 'b')
				column = 1;
			else if(c == 'C' || c == 'c')
				column = 2;
			else if(c == 'D' || c == 'd')
				column = 3;
			else if(c == 'E' || c == 'e')
				column = 4;
			else if(c == 'F' || c == 'f')
				column = 5;
			else if(c == 'G' || c == 'g')
				column = 6;
			else if(c == 'H' || c == 'h')
				column = 7;
			else
			{
				System.out.println("\nInvalid input"
						+ "\nPlease enter a letter from A to H");
				continue;
			}
		
			System.out.println("Enter your number...");
			row = kb.nextInt();
			while(row < 1 || row > 8)
			{
				System.out.println("\nInvalid input."
						+ "\nPlease enter a number from 1 to 8.");
				row = kb.nextInt();
			}
		
			if(positionObjects[row-1][column].getType() == "ship")
			{
				System.out.println("\nThere is already a ship in this coordinate."
						+ "Please choose a different coordinate");
				continue;
			}
			else if(positionObjects[row-1][column].getType() == "grenade")
			{
				System.out.println("\nYou have already chosen this coordinate."
						+ "Please choose a different coordinate");
				continue;
				
			}
			else
			{
				positionObjects[row-1][column].setType("grenade");
				positionObjects[row-1][column].setOwner("user");
				g++;
				showboard(positionObjects);
			}
		}
		System.out.println("\nGreat your positions have been set!");
		showboard(positionObjects);
		
		/**Now we randomly set the computers coordinates.
		 * 
		 */
		
		Random rand = new Random();
		int i = 0;
		while(i < 6)
		{
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			if((positionObjects[x][y].getType() == "ship") && (positionObjects[x][y].getOwner() == "user"))
			{
				continue;
			}
			if((positionObjects[x][y].getType() == "grenade") && (positionObjects[x][y].getOwner() == "user"))
			{
				continue;
			}
			if((positionObjects[x][y].getType() == "ship") && (positionObjects[x][y].getOwner() == "computer"))
			{
				i--;
			}
			positionObjects[x][y].setType("ship");
			positionObjects[x][y].setOwner("computer");
			i++;
		}
		
		/**Now randomly generate grenades
		 * 
		 */
		int j =0;
		while(j < 4)
		{
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			if((positionObjects[x][y].getType() == "ship") && (positionObjects[x][y].getOwner() == "user"))
			{
				continue;
			}
			if((positionObjects[x][y].getType() == "grenade") && (positionObjects[x][y].getOwner() == "user"))
			{
				continue;
			}
			if((positionObjects[x][y].getType() == "ship") && (positionObjects[x][y].getOwner() == "computer"))
			{
				continue;
			}
			if((positionObjects[x][y].getType() == "grenade") && (positionObjects[x][y].getOwner() == "computer"))
			{
				j--;
			}
			
			positionObjects[x][y].setType("grenade");
			positionObjects[x][y].setOwner("computer");
			j++;
		}
		
		showboard(positionObjects);
	}
	
	/**A method for the user's turn
	 * 
	 * @param board
	 */
	public static void userturn(position[][] positionObjects)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please choose a coordinate to fire a rocket!");
		System.out.println("Enter a letter from A to H");
		char c;
		int row, column = 0;
		c = kb.next().charAt(0);
	
		if(c == 'A' || c == 'a')
			column = 0;
		else if(c == 'B' || c == 'b')
			column = 1;
		else if(c == 'C' || c == 'c')
			column = 2;
		else if(c == 'D' || c == 'd')
			column = 3;
		else if(c == 'E' || c == 'e')
			column = 4;
		else if(c == 'F' || c == 'f')
			column = 5;
		else if(c == 'G' || c == 'g')
			column = 6;
		else if(c == 'H' || c == 'h')
			column = 7;
		else
		{
			System.out.println("\nInvalid Inpout");
			userturn(positionObjects);
		}
	
		System.out.println("Enter a number from 1 to 8");
		row = kb.nextInt();
		while(row < 1 || row > 8)
		{
			System.out.println("Invalid input."
					+ "\nPlease enter a number from 1 to 8.");
			row = kb.nextInt();
		}
		
		if(positionObjects[row-1][column].getType() == "nothing")
		{
			System.out.println("You missed. ");
			positionObjects[row-1][column].setCalled(true);
			showboard(positionObjects);
			if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(positionObjects);
			}
			cputurn(positionObjects);
		}
		else if((positionObjects[row-1][column].getType() == "ship") && (positionObjects[row-1][column].getOwner() == "user"))
		{
			System.out.println("You sunk your own ship! ");
			positionObjects[row-1][column].setCalled(true);
			showboard(positionObjects);
			yourShip--;
			if(yourShip == 0)
			{
				youlose(positionObjects);
			}
			else if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(positionObjects);
			}
			else cputurn(positionObjects);
		}
		else if((positionObjects[row-1][column].getType() == "grenade") && (positionObjects[row-1][column].getOwner() == "user"))
		{
			System.out.println("You destroyed your own grenade! ");
			positionObjects[row-1][column].setCalled(true);
			showboard(positionObjects);
			if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(positionObjects);
			}
			cputurn(positionObjects);
		}
		else if((positionObjects[row-1][column].getType() == "ship") && (positionObjects[row-1][column].getOwner() == "computer"))
		{
			System.out.println("You sunk your opponents ship! ");
			positionObjects[row-1][column].setCalled(true);
			showboard(positionObjects);
			cpuShip--;
			if(cpuShip == 0)
			{
				youwin(positionObjects);
			}
			else if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(positionObjects);
			}
			else cputurn(positionObjects);
		}
		else if((positionObjects[row-1][column].getType() == "grenade") && (positionObjects[row-1][column].getOwner() == "computer"))
		{
			System.out.println("You hit a grenade!");
			positionObjects[row-1][column].setCalled(true);
			showboard(positionObjects);
			cpuExtraTurns++;
			cputurn(positionObjects);
		}
		else if(positionObjects[row-1][column].getCalled() == true)
		{
			System.out.println("Position already called.");
			positionObjects[row-1][column].setCalled(true);
			showboard(positionObjects);
			if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(positionObjects);
			}
			cputurn(positionObjects);
		}
		
	}
	
	/**A method for the opponent's turn
	 * 
	 * @param board
	 */
	public static void cputurn(position[][] positionObjects)
	{
		Random rand = new Random();
		
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
		
			if(positionObjects[x][y].getType() == "nothing")
			{
				positionObjects[x][y].setCalled(true);
				System.out.println("The opponent missed.");
				showboard(positionObjects);
				if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(positionObjects);
				}
				userturn(positionObjects);
			}
			else if((positionObjects[x][y].getType() == "ship") && (positionObjects[x][y].getOwner() == "user"))
			{
				positionObjects[x][y].setCalled(true);
				System.out.println("The opponent sunk your ship.");
				showboard(positionObjects);
				yourShip--;
				if(yourShip == 0)
				{
					youlose(positionObjects);
				}
				else if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(positionObjects);
				}
				else userturn(positionObjects);
			}
			else if((positionObjects[x][y].getType() == "grenade") && (positionObjects[x][y].getOwner() == "user"))
			{
				positionObjects[x][y].setCalled(true);
				System.out.println("The opponent hit your grenade. \nYou get two turns!");
				showboard(positionObjects);
				userExtraTurns++;
				userturn(positionObjects);
			}
			else if((positionObjects[x][y].getType() == "ship") && (positionObjects[x][y].getOwner() == "computer"))
			{
				positionObjects[x][y].setCalled(true);
				System.out.println("Your opponent was confused and accidentally hit their own ship.");
				showboard(positionObjects);
				cpuShip--;
				if(cpuShip == 0)
				{
					youwin(positionObjects);
				}
				else if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(positionObjects);
				}
				else userturn(positionObjects);
			}
			else if((positionObjects[x][y].getType() == "grenade") && (positionObjects[x][y].getOwner() == "computer"))
			{
				positionObjects[x][y].setCalled(true);
				System.out.println("Your opponent destroyed their own grenade");
				showboard(positionObjects);
				if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(positionObjects);
				}
				userturn(positionObjects);
			}
			else if(positionObjects[x][y].getCalled() == true)
			{
				positionObjects[x][y].setCalled(true);
				System.out.println("The opponent hit a coordinate previously hit");
				showboard(positionObjects);
				if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(positionObjects);
				}
				userturn(positionObjects);
			}
				
	}
	
	/**A method if you win the game
	 * 
	 * @param board
	 */
	public static void youwin(position[][] positionObjects)
	{
		System.out.println("\n..."
				+ "\nafter a difficult, but fair game..."
				+ "\n..."
				+ "\nYou win!");
		System.exit(0);
	}
		
	/**A method if you lose the game
	 * 
	 * @param board
	 */
	public static void youlose(position[][] positionObjects)
	{
		System.out.println("\n..."
				+ "\nafter a difficult, but fair game..."
				+ "\n..."
				+ "\nYou lose!");
		System.exit(0);
	}
	
	
	
}
