
public class driver
{

	public static void main(String[] args)
	{
		//create an 8 x 8 board using 2D array of objects 
		position[][] positionObjects = new position[8][8];
		
		//initialize all the objects with default constructor
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				positionObjects[i][j] = new position();
			}
		}
			
		battleship.showboard(positionObjects);
		
		battleship.PlaceTokens(positionObjects);
		
		battleship.userturn(positionObjects);

	}

}
