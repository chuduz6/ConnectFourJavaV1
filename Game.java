
/**
 * Write a description of class game here.
 * 
 * @author 
 * @version (Stage 1 of Connect Four)
 */
 
public class Game
{
    /**
     * Main method for the connect four game
     * It will ask the user for the players name and stores the name in array associating with the player class
     * It will terminate with the certain given condition.
     */
    public static void main() 
    {
        Player[] players; 
        players = new Player[2];
        Board board;
        board = new Board();
        Reader reads;
        reads = new Reader();
        System.out.println ("Welcome To The Game of Connect Four."); // prints the welcome message
        System.out.println ("Whoever completes the four disc in a row, or column, or diagonal (vertically or horizontally) wins the game.");
        System.out.println ("Its really simple game and FUN to play.");
        System.out.println ("Hope you ENJOY it. Dont worry!!! Details of instructions will be given to you as you move along.");
        System.out.println ("Good Luck and Try to win the game.");       
        do
        {
            for( int i = 0; i < 2; i++) // loop for asking the name of two players and storing in the player array
            {
                String color;
                System.out.println("Player " + (i+1) + " name?");           
                players[i] = new Player(reads.getRead()); // reads the name of players as an input from the command line
                System.out.println("Player " + (i+1) +": " + players[i].getPlayer());
                int colorcheck=1;
                while(colorcheck==1)
                {
                    System.out.println("Choose color for player"+(i+1)+ "      Red or black");
                    color=reads.getRead();
                    if (color.equalsIgnoreCase("Red") || color.equalsIgnoreCase("Black")) // error checking if the user enters the right color for disc
                    {
                        players[i].setColor(color);//setting color for the player from the command line as chosen by the user
                        System.out.println("Player"+ (i+1) +" disc symbol is: " +players[i].getColor()); 
                        colorcheck=0;
                    }
                    else
                    {
                        System.out.println("Error in Choosing the color of the disc.");
                    }
                }
            }
            board.iniBoard(); // initiating board will null value in the array
            int counter=0;
            while (counter <42)  // 42 since there are 6 rows and 7 column. I now it is hard coded!! sorry!!
            {   
                String input=null;
                int flag=-1;
                while(flag==-1)
                {
                    System.out.println("Follow the players turn. Enter the name of the column you wish to drop your disc, range 1 to 7.");
                    System.out.println(players[counter%2].getPlayer()+":");// printing current player name
                    input = reads.getRead();// reading the user input from the command line
                    if ((Integer.parseInt(input)<1) || (Integer.parseInt(input) >7)) // error checking to make sure the user enters the right column, if error found then default column is given
                    {
                        input="1";
                        System.out.println("Wrong Column Entered. Default column 1 is used instead.");
                    }
                    flag = board.checkFullColumn(Integer.parseInt(input)-1); // error checking whether the column is full or not. if error, then again asks the user to enter column
                }
                board.dropChip((Integer.parseInt(input)-1), players[counter%2].getColor());// dropping chip in the array of the string
                board.printBoard();//printing the current condition of the board.
                String won;
                System.out.println("Has the game been won?? y/n or Y/N");
                won = reads.getRead();
                if (won.compareToIgnoreCase("y")==0)// condition to check which player has won the game
                {
                    System.out.println(players[counter%2].getPlayer()+ " has won the game.");
                    break;
                }
                else
                {
                counter ++;
                }
            }
            if(counter==42) // this means the board is full, since there are only rows*column spaces.
            {
                System.out.println("The Game has been tied. Nobody won the game. You both suck.");
            }
            System.out.println("Do you want to start new game?? y/n or Y/N");
            String start;
            start = reads.getRead();
            if (start.compareToIgnoreCase("n")==0)// condition to ask user to start new game
            {
                System.out.println("Thank you for playing connect four game. You have a nice day.");
                break;
            }
        
        }
        while (true);
    }   
    

    
}


