
/**
 * This class creates an instance of the StockApp
 * and then calls on its run method.
 *
 * @author Derek Peacock
 * @version 0.1
 */
public class Program
{
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main(String [] args)
    {
        app = new StockApp();
        app.run();
    }
}
