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
                else if(positionObjects[row][column].getType() == "nothing"){
					System.out.print("-"+"  ");
				}
				else if((positionObjects[row][column].getType() == "ship") && (positionObjects[row][column].getOwner() == "user") && (positionObjects[row][column].getCalled() == false)){
                    System.out.print("B"+"  ");
                }
                else if((positionObjects[row][column].getType() == "grenade") && (positionObjects[row][column].getOwner() == "user") && (positionObjects[row][column].getCalled() == false)){
                    System.out.print("G"+"  ");
                }     
                else if((positionObjects[row][column].getType() == "ship") && (positionObjects[row][column].getOwner() == "computer") && (positionObjects[row][column].getCalled() == false)){
                    //System.out.print("b"+"  ");
                	System.out.print("-"+"  ");
                }
                else if((positionObjects[row][column].getType() == "grenade") && (positionObjects[row][column].getOwner() == "computer") && (positionObjects[row][column].getCalled() == false)){
                    //System.out.print("g"+"  ");
                	System.out.print("-"+"  ");
                }
			}
			System.out.println();
		}
	}
	
	public static void PlaceTokens(position[][] positionObjects)
	{
		int row, column = 0 ;
		Scanner kb = new Scanner(System.in);
		System.out.println("\nRemember you and your opponent will have 6 ships and 4 grenades.");
		System.out.println("\nLets place your 6 battleships!");


		int s = 0;
		while(s < 6)
		{
			System.out.println("Please enter a letter from A to H followed by a number from 1 to 8.");
			
			String coordinate = kb.nextLine();
			String input = coordinate.replace(" ", "");
			
			//check the length of the string
			if(input.length() != 2) 
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			
			char ch1 = input.charAt(0);
			int num1 = Character.getNumericValue(input.charAt(1));
			
			//check the letter
			if(ch1 == 'A' || ch1 == 'a')
				column = 0;
			else if(ch1 == 'B' || ch1 == 'b')
				column = 1;
			else if(ch1 == 'C' || ch1 == 'c')
				column = 2;
			else if(ch1 == 'D' || ch1 == 'd')
				column = 3;
			else if(ch1 == 'E' || ch1 == 'e')
				column = 4;
			else if(ch1 == 'F' || ch1 == 'f')
				column = 5;
			else if(ch1 == 'G' || ch1 == 'g')
				column = 6;
			else if(ch1 == 'H' || ch1 == 'h')
				column = 7;
			else
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			
			//now check the number
			row = num1;
			if(row < 1 || row > 8)
			{
				System.out.println("Bad coordinate format");
				continue;
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
		System.out.println("Now lets place your grenades");
				
		int g = 0;
		while(g < 4)
		{ 
			System.out.println("Please enter a letter from A to H followed by a number from 1 to 8.");
			
			String coordinate = kb.nextLine();
			String input = coordinate.replace(" ", "");
			
			//check the length of the string
			if(input.length() != 2) 
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			
			char ch1 = input.charAt(0);
			int num1 = Character.getNumericValue(input.charAt(1));

		
			//check the letter
			if(ch1 == 'A' || ch1 == 'a')
				column = 0;
			else if(ch1 == 'B' || ch1 == 'b')
				column = 1;
			else if(ch1 == 'C' || ch1 == 'c')
				column = 2;
			else if(ch1 == 'D' || ch1 == 'd')
				column = 3;
			else if(ch1 == 'E' || ch1 == 'e')
				column = 4;
			else if(ch1 == 'F' || ch1 == 'f')
				column = 5;
			else if(ch1 == 'G' || ch1 == 'g')
				column = 6;
			else if(ch1 == 'H' || ch1 == 'h')
				column = 7;
			else
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			
			//now check the number
			row = num1;
			if(row < 1 || row > 8)
			{
				System.out.println("Bad coordinate format");
				continue;
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
		//showboard(positionObjects);
		

		//Randomly set the computer's coordinates
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
		
		//Randomly generate grenades
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
		
		//showboard(positionObjects);
	}
	
	//method for the users turn
	public static void userturn(position[][] positionObjects)
	{
		int row = 0, column = 0;
		Scanner kb = new Scanner(System.in);
		System.out.println("Please choose a coordinate to fire a rocket!");
		
		boolean goodValue = false;
		
		while(goodValue == false)
		{
			System.out.println("Please enter a letter from A to H followed by a number from 1 to 8.");
			String coordinate = kb.nextLine();
			String input = coordinate.replace(" ", "");
			
			//check the length of the string
			if(input.length() != 2) 
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			
			char ch1 = input.charAt(0);
			int num1 = Character.getNumericValue(input.charAt(1));
			
			//check the letter
			if(ch1 == 'A' || ch1 == 'a')
				column = 0;
			else if(ch1 == 'B' || ch1 == 'b')
				column = 1;
			else if(ch1 == 'C' || ch1 == 'c')
				column = 2;
			else if(ch1 == 'D' || ch1 == 'd')
				column = 3;
			else if(ch1 == 'E' || ch1 == 'e')
				column = 4;
			else if(ch1 == 'F' || ch1 == 'f')
				column = 5;
			else if(ch1 == 'G' || ch1 == 'g')
				column = 6;
			else if(ch1 == 'H' || ch1 == 'h')
				column = 7;
			else
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			
			//now check the number
			row = num1;
			if(row < 1 || row > 8)
			{
				System.out.println("Bad coordinate format");
				continue;
			}
			goodValue = true;
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
	
	//method for the opponents turn
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
	
	//method if you win the game
	public static void youwin(position[][] positionObjects)
	{
		System.out.println("\n..."
				+ "\nafter a difficult, but fair game..."
				+ "\n..."
				+ "\nYou win!");
		System.exit(0);
	}
		
	//method if you lose the game
	public static void youlose(position[][] positionObjects)
	{
		System.out.println("\n..."
				+ "\nafter a difficult, but fair game..."
				+ "\n..."
				+ "\nYou lose!");
		System.exit(0);
	}
	
	
	
}
