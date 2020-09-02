/**
 *Name: Said-Mansour Maqsoudi	
 *Student ID: 27739656 
 *Comp 249
 *Assignment # 1 
 */
import java.util.Random;
import java.util.Scanner;
public class battleship
{
	/** the static variable "yourShip" and "cpuShip" will keep track of how many ships a player has.
	* the static variable cpu/user ExtraTurns will keep track of extra turns cause by hitting a grenade.
	*/
	
	public static int yourShip = 6, cpuShip = 6;
	public static int cpuExtraTurns = 0;
	public static int userExtraTurns = 0;
	
	
	
	/**A method to initialize the board. All positions will start with 0.
	 * 
	 * @param board
	 */
	public void initializeboard1(int[][] board)
	{
		for(int row = 0 ; row < 8 ; row++)
			for(int column = 0 ; column < 8 ; column++)
				board[row][column]= 0;
		yourShip--;
	}

	/**A method to place your Ships and grenades, as well as randomly place the computer's ships and grenades.
	 *  
	 * @param board
	 */
	public void PlaceTokens(int[][] board)
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
		
			if(board[row-1][column] == 1)
			{
				System.out.println("\nYou have already chosen this coordinate."
						+ "\nPlease choose a different coordinate");
				s--;
			}
		
			board[row-1][column] = 1;
		
			s++;
			showboard(board);
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
		
			if(board[row-1][column] == 1)
			{
				System.out.println("\nThere is already a ship in this coordinate."
						+ "Please choose a different coordinate");
				continue;
			}
			else if(board[row-1][column] == 2)
			{
				System.out.println("\nYou have already chosen this coordinate."
						+ "Please choose a different coordinate");
				continue;
				
			}
			else
			{
				board[row-1][column] = 2;
				g++;
				showboard(board);
			}
		}
		System.out.println("\nGreat your positions have been set!");
		showboard(board);
		
		/**Now we randomly set the computers coordinates.
		 * 
		 */
		
		Random rand = new Random();
		int i = 0;
		while(i < 6)
		{
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			if(board[x][y] == 1)
			{
				continue;
			}
			if(board[x][y] == 2)
			{
				continue;
			}
			if(board[x][y] == 3)
			{
				i--;
			}
			board[x][y]=3;
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
			if(board[x][y] == 1 )
			{
				continue;
			}
			if(board[x][y] == 2 )
			{
				continue;
			}
			if(board[x][y] == 3 )
			{
				continue;
			}
			if(board[x][y] == 4 )
			{
				j--;
			}
			
			board[x][y]=4;
			j++;
		}
		
		
	}
	
	/**A method to show the board
	 * 
	 * @param board
	 */
	public void showboard(int[][] board)
	{
		System.out.println("\n   A  B  C  D  E  F  G  H");
		for(int row = 0 ; row < 8 ; row++)
		{
			System.out.print((row+1) + "  ");
			for(int column = 0 ; column < 8 ; column++)
			{
				if(board[row][column] == 0)
				{
					System.out.print("-"+"  ");
				}
				else if(board[row][column] == 1)
                {
                    System.out.print("B"+"  ");
                }
                else if(board[row][column] == 2)
                {
                    System.out.print("G"+"  ");
                }     
                else if(board[row][column] == 3)
                {
                    System.out.print("b"+"  ");
                }
                else if(board[row][column] == 4)
                {
                    System.out.print("g"+"  ");
                }
                else if(board[row][column] == 5)
                {
                    System.out.print("*"+"  ");
                }     
			}
			System.out.println();
		}
	}

	/**A method for the user's turn
	 * 
	 * @param board
	 */
	public void userturn(int[][] board)
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
			userturn(board);
		}
	
		System.out.println("Enter a number from 1 to 8");
		row = kb.nextInt();
		while(row < 1 || row > 8)
		{
			System.out.println("Invalid input."
					+ "\nPlease enter a number from 1 to 8.");
			row = kb.nextInt();
		}
		
		if(board[row-1][column] == 0 )
		{
			System.out.println("You missed. ");
			board[row-1][column] = 5;
			showboard(board);
			if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(board);
			}
			cputurn(board);
		}
		else if(board[row-1][column] == 1)
		{
			System.out.println("You sunk your own ship! ");
			board[row-1][column] = 5;
			showboard(board);
			yourShip--;
			if(yourShip == 0)
			{
				youlose(board);
			}
			else if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(board);
			}
			else cputurn(board);
		}
		else if(board[row-1][column] == 2)
		{
			System.out.println("You destroyed your own grenade! ");
			board[row-1][column] = 5;
			showboard(board);
			if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(board);
			}
			cputurn(board);
		}
		else if(board[row-1][column] == 3)
		{
			System.out.println("You sunk your opponents ship! ");
			board[row-1][column] = 5;
			showboard(board);
			cpuShip--;
			if(cpuShip == 0)
			{
				youwin(board);
			}
			else if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(board);
			}
			else cputurn(board);
		}
		else if(board[row-1][column] == 4)
		{
			System.out.println("You hit a grenade!");
			board[row-1][column] = 5;
			showboard(board);
			cpuExtraTurns++;
			cputurn(board);
		}
		else if(board[row-1][column] == 5)
		{
			System.out.println("Position already called.");
			board[row-1][column] = 5;
			showboard(board);
			if(userExtraTurns > 0)
			{
				userExtraTurns--;
				userturn(board);
			}
			cputurn(board);
		}
		
	}
	
	/**A method for the opponent's turn
	 * 
	 * @param board
	 */
	public void cputurn(int[][] board)
	{
		Random rand = new Random();
		
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
		
			if(board[x][y] == 0)
			{
				board[x][y] = 5;
				System.out.println("The opponent missed.");
				showboard(board);
				if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(board);
				}
				userturn(board);
			}
			else if(board[x][y] == 1)
			{
				board[x][y] = 5;
				System.out.println("The opponent sunk your ship.");
				showboard(board);
				yourShip--;
				if(yourShip == 0)
				{
					youlose(board);
				}
				else if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(board);
				}
				else userturn(board);
			}
			else if(board[x][y] == 2)
			{
				board[x][y] = 5;
				System.out.println("The opponent hit your grenade. \nYou get two turns!");
				showboard(board);
				userExtraTurns++;
				userturn(board);
			}
			else if(board[x][y] == 3)
			{
				board[x][y] = 3;
				System.out.println("Your opponent was confused and accidentally hit their own ship.");
				showboard(board);
				cpuShip--;
				if(cpuShip == 0)
				{
					youwin(board);
				}
				else if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(board);
				}
				else userturn(board);
			}
			else if(board[x][y] == 4)
			{
				board[x][y] = 4;
				System.out.println("Your opponent destroyed their own grenade");
				showboard(board);
				if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(board);
				}
				userturn(board);
			}
			else if(board[x][y] == 5)
			{
				board[x][y] = 5;
				System.out.println("The opponent hit a coordinate previously hit");
				showboard(board);
				if(cpuExtraTurns > 0)
				{
					cpuExtraTurns--;
					cputurn(board);
				}
				userturn(board);
			}
				
	}
	
	/**A method if you win the game
	 * 
	 * @param board
	 */
	public void youwin(int[][] board)
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
	public void youlose(int[][] board)
	{
		System.out.println("\n..."
				+ "\nafter a difficult, but fair game..."
				+ "\n..."
				+ "\nYou lose!");
		System.exit(0);
	}
	

}
