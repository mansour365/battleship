public class driver
{

	public static void main(String[] args)
	{
		int[][] board = new int[8][8];			//Create the board 8 x 8 
		
		battleship b1 = new battleship();
		
		b1.initializeboard1(board);
		
		System.out.println("\nHello, and welcome to Battleship!");
		System.out.println("\nThis is the battlefeild.\n");
		b1.showboard(board);
		
		b1.PlaceTokens(board);
		
		b1.showboard(board);
		
		b1.userturn(board);

	}

}
