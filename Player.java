public class Player {
	// creating the field for the player class
	private String name;
	private String color;
	
	/**
     * Constructor for the Player class
     * initialize fields name and color.
     * @param String
     */
	// constructor for the player class
	public Player(String Name)
	{
		setPlayer(Name);
		color =" ";
	}
	
	/**
     * To get the name of the player.
     * @return String name of the player.
     */
	
	public String getPlayer() //accessor method 
	{
		return name;
	}
	
	/**
     * Set name of the player
     * @param String player name
     */
	public void setPlayer(String Player)// mutator method
	{
		this.name = Player;
	}
	/**
     * set color for the chip as desired by the user
     * @param String color choice
     */
	
	public void setColor(String color) 
	{
		if(color.compareToIgnoreCase("red") == 0)
		{
			this.color =  "X";
		}
		else if(color.compareToIgnoreCase("black") == 0)
		{
			this.color = "+";
		}
	}
	
	/**
     * Access the color
     * @return String the value set in the color field.
     */
	public String getColor()
	{
		return color;
	}
}
