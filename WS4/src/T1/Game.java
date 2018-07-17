/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

package T1;

import java.util.Arrays;

public class Game {

     public static void main(String []args){
        init();
     }

    /**
     * 2D array to hold the board data
     */
    static char[][] board = new char[6][7]; //rows cols


    /**
     * clears the game board and starts the game
     */
    public static void init()
    {
        for (char[] row: board){
            Arrays.fill(row, ' ');
        }
        
        game();
    }

    /**
     * Draws the game board from the array
     */
    public static void draw()
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                System.out.print("|" + board[i][j]);
            }
             System.out.println("|");
        }
        System.out.println("_______________"); //14 bars 2*rows
    }

    /**
     * Main game logic:
     * Handles who's turn it is
     * Ensures turns are valid @putDisk()
     * Checks for End State @endState()
     */
    public static void game()
    {
        boolean red = false;
        int col;
        
        do
        {
            red = !red;
            do{
                draw();
                System.out.println("Drop a " + ((red)? "red" : "yellow") + " disk at col (0 - 6)");
                col = Input.getInt();
            }while(!putDisk(red, col));
            
        }while(!endState(red, col));
        //endGame();
    }

    /**
     * Puts a disk of a color into a column. In the next free row.
     * @param red color of the disk
     * @param col column of the disk
     * @return if the disk was able to be put in column
     */
    public static boolean putDisk(boolean red, int col)
    {
        boolean good = false;

        if(col >= 0 && col < 7)
        {
            for(int i = 5; i >= 0; i--)
            {
                if(board[i][col] == ' ' && !good)
                {
                    board[i][col] = (red)? 'R' : 'Y';
                    good = true;
                }
            }
        }

        if(!good)
        {
            System.out.println("Could not place disk");
        }

        return good;
    }

    /**
     * Checks if the last placed piece completed a line of 4, or if this game is in a draw state
     * @param red the color of the last placed piece
     * @param col the column that the last placed piece was in
     * @return if the end state has been reached or not
     */
    public static boolean endState(boolean red, int col)
    {

        boolean state = checkVert(red, col);

        if(!state)
        {
            checkHorz(red, col);
        }

        if(!state)
        {
            checkDiag(red, col);
        }

        if(state)
        {
            draw();
            System.out.println(((red)? "Red" : "Yellow") + " Wins!");
        }

        if(checkDraw())
        {
            state = true;
            draw();
            System.out.println("Draw!");
        }
        
        return state;
    }

    /**
     * Checks if the board is full
     * @return if the game is a draw
     */
    public static boolean checkDraw()
    {
        boolean state = true;
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                if(board[i][j] == ' ')
                {
                    state = false;
                }
            }
        }
        
        return state;
    }

    /**
     * Checks for vertical win condition
     * @param red color to check
     * @param col column of last piece
     * @return state of the win condition
     */
    public static boolean checkVert(boolean red, int col)
    {
        boolean state = false;
        int count = 0;
        char c = (red)? 'R' : 'Y';

        //Vertical
        for(int i = 0; i < 6; i++)
        {
            if(board[i][col] == c)
            {
                count++;
                if(count == 4)
                {
                    state = true;
                }
            }
            else
            {
                count = 0;
            }
        }

        return state;
    }

    /**
     * Checks for Horizontal win condition
     * @param red color to check
     * @param col column of last piece
     * @return state of the win condition
     */
    public  static boolean checkHorz(boolean red, int col)
    {
        boolean state = false;
        int count = 0;
        char c = (red)? 'R' : 'Y';

        if(!state) {
            //Horizontal
            int row = 0;

            for (int i = 5; i >= 0; i--) {
                if (board[i][col] != ' ') {
                    row = i;
                }
            }
            for (int i = 0; i < 7; i++) {
                if (board[row][i] == c) {
                    count++;
                    if (count == 4) {
                        state = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return state;
    }


    //TODO: Make Work
    /**
     * Checks for Diagonal win condition
     * @param red color to check
     * @param col column of last piece
     * @return state of the win condition
     */
    public  static boolean checkDiag(boolean red, int col)
    {
        return false;
    }
}