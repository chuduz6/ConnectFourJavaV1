public class Board {
	public static final int ROW =6; //board row number
	public static final int COLUMN= 7;// board column number
	
	private String[][] grid; // decelaration of  multidimention array of string 
	/**
     * Constructor for the Board class
     */
	public Board()
	{
		grid = new String[ROW][COLUMN]; // initializing string array
		
	}
	/**
     * Method to access the element in the Board
     * @param int row Board's row.
     * @param int column Board's column.
     * @return String the contents in the grid
     */
	public String getBoard(int row, int column)
	{
		return grid[row][column]; 
	}
	/**
     * Method to check for the empty space in row of the particular coloum
     * @param int column 
     * @return int the empty row if any or -1
     */
	public int checkSpace(int column)
	{
		for (int row =0; row<ROW; row ++ )
		{
			
			if(grid[row][column]==null)
			{
				return row;
			}
		}
		return -1; // return -1 if the condition is not satisfied
	}
	/**
     * Method to drop chip in the board
     * @param int column 
     * @param String value
     */
	
	public void dropChip(int column, String disc)
	{
		
			
			grid[checkSpace(column)][column]= disc; 
		
	}
	
	/**
	 * Method to check Full Column
	 * @param int column
	 * @return boolean true or false
	 */
	public int checkFullColumn(int column)
	{
	    for(int row = (ROW - 1); row >= 0; row--)
		{
		    if (grid[row][column]==null)
		    {
		        return column;
		    }
		}
		System.out.println("The column is Full. Please Enter new column. Same player has a turn.");
		return -1;
	    
	}

	/**
     * Method to initialize board with null value
     */
	public void iniBoard()
	{
		for(int row = (ROW - 1); row >= 0; row--)
		{

			for(int column = 0; column < COLUMN; column++)
			{
				
					grid[row][column]=null;
			}
			
		}
		
	}
	/**
     * Method to print elements in the Board
     */
	public void printBoard()
	{
		System.out.println("===================="); // print the boundary line
		for(int row = (ROW - 1); row >= 0; row--)
		{

			for(int column = 0; column < COLUMN; column++)
			{
				if (grid[row][column]==null)
				{
					System.out.print(" o "); // setting the null value of element in an array to "o"
				}
				else
				{
					System.out.print(" " + grid[row][column]+" ");
			    }
			}
			System.out.println();
		}
		System.out.println("====================");

	}
}
	