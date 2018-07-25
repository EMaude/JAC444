/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

package T2;

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
        int moves = 0;
        do
        {
            red = !red;
            do{
                draw();
                System.out.println("Drop a " + ((red)? "red" : "yellow") + " disk at col (0 - 6)");
                col = Input.getInt();
            }while(!putDisk(red, col));
            moves++;
        }while(moves < 7 || !endState(red, col));

        if(again())
        {
            init();
        }

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
            state = checkHorz(red, col);
        }

        if(!state)
        {
            state = checkDiag1(red, col);
        }

        if(!state)
        {
            state = checkDiag2(red, col);
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
        char[] vert = new char[6];

        //Vertical
        for(int i = 0; i < 6; i++)
        {
            vert[i] = board[i][col];
        }

        return checkArray(vert, red);
    }

    /**
     * Checks for Horizontal win condition
     * @param red color to check
     * @param col column of last piece
     * @return state of the win condition
     */
    public  static boolean checkHorz(boolean red, int col)
    {
        char[] horz = new char[7];

        int row = getRow(col);

        for(int i = 0; i < 7; i++)
        {
            horz[i] = board[row][i];
        }

        return checkArray(horz, red);
    }

    /**
     * Checks for Diagonal win condition
     * @param red color to check
     * @param col column of last piece
     * @return state of the win condition
     */
    public  static boolean checkDiag1(boolean red, int col)
    {
        char[] diag = new char[6];

        int row = getRow(col);

        int x = row;
        int y = col;

        while(x > 0 && y > 0)
        {
            --x;
            --y;
        }

        int i = 0;
        while(x < 6 && y < 7){
            diag[i] = board[x][y];
            x++;
            y++;
            i++;
        }

        return checkArray(diag, red);
    }

    public  static boolean checkDiag2(boolean red, int col)
    {
        char[] diag = new char[6];

        int row = getRow(col);

        int x = row;
        int y = col;

        while(x < 5 && y > 0)
        {
            ++x;
            --y;
        }

        int i = 0;
        while(x > 0 && y < 7){
            diag[i] = board[x][y];
            x--;
            y++;
            i++;
        }

        return checkArray(diag, red);
    }

    public static boolean checkArray(char[] arr, boolean red)
    {
        char c = (red)? 'R' : 'Y';
        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == c)
            {
                count++;
                if(count == 4)
                {
                    return true;
                }
            }
            else
            {
                count = 0;
            }
        }

        return false;
    }

    public static int getRow(int col)
    {
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] != ' ') {
                row = i;
            }
        }
        return row;
    }

    public static void debugArrayPrint(char[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print( i + " " + arr[i] + "|");
        }
        System.out.println(" ");
    }

    public static boolean again()
    {
        System.out.println("Play Again?(y/n) ");
        char choice = Input.getChar();
        Input.clear();

        if(choice == 'Y' || choice == 'y')
        {
            return true;
        }
        else if(choice == 'N' || choice == 'n')
        {
            return false;
        }
        else {
            return again();
        }
    }
}
