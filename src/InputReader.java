import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Prompt the user to enter a string
     * Read a line of text from standard input 
     * (the text terminal),
     * and return a String.
     *
     * @return  A String typed by the user.
     */
    public String getInput(String prompt)
    {
        System.out.println(prompt);   
        String inputLine = reader.nextLine();

        return inputLine;
    }
    
    /**
     * Prompt the user to enter an int
     * Read an int from standard input 
     * (the text terminal),
     * and return it as an int.
     *
     * @return  A String typed by the user.
     */
    public int getInt(String prompt)
    {
        System.out.println(prompt); 
        String value = reader.nextLine();
        //int number = reader.nextInt();
        
        int number = Integer.parseInt(value);
        return number;
    }    
}
