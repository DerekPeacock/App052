
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Derek Peacock
 * @version 0.1
 */
public class StockApp
{
    // instance variables - replace the example below with your own
    private final StockManager manager;

    private final InputReader reader;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        manager = new StockManager();
        StockDemo demo = new StockDemo(manager);
        
        reader = new InputReader();
    }

    
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
            
            String prompt = "\n    Enter your choice > ";
            String choice = reader.getString(prompt).toLowerCase();
            System.out.println();
            
            if(choice.startsWith("quit"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
    
    /**
     * Call on methods of the StockManager to
     * execute the selected menu choice
     */
    private void executeMenuChoice(String choice)
    {
        if(choice.startsWith("add"))
        {
            addProduct();
        }
        else if(choice.startsWith("deliver"))
        {
            deliverProduct();
        }        
        else if(choice.startsWith("low"))
        {
            printLowStock();
        } 
        else if(choice.startsWith("remove"))
        {
            removeProduct();
        }         
        else if(choice.startsWith("sell"))
        {
            sellProduct();
        } 
        else if(choice.startsWith("search"))
        {
            searchProducts();
        }         
        else if(choice.startsWith("print"))
        {
            manager.printAllProducts();
        }
    }
    
    private void addProduct()
    {
        System.out.println(" Adding a new Product\n");
        
        String prompt = "\n Please enter the product ID number > ";
        int id = reader.getInt(prompt);

        prompt = "\n Please enter the product name > ";
        String name = reader.getString(prompt);
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        manager.takeDelivery(id,1);
        
        System.out.println("\n" + product + " added!\n");
        
    }

    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void deliverProduct()
    {
        System.out.println(" Deliver an amount of an existing Product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            String prompt = "\n Please enter the order quantity > ";
            int quantity = reader.getInt(prompt);
            
            manager.takeDelivery(product.getID(), quantity);
            System.out.println("\n" + quantity + " of " + 
                product + " delivered!\n");
        }
    }

    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void removeProduct()
    {
        System.out.println(" Removing an old Product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            manager.removeProduct(product.getID());
            System.out.println("\n" + product + " removed!\n");
        }
    }
    
    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void sellProduct()
    {
        System.out.println(" Deliver an amount of an existing Product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            String prompt = "\n    Please enter the order quantity > ";
            int quantity = reader.getInt(prompt);
        
            manager.sellProduct(product.getID(), quantity);
            System.out.println("\n    " + product + " " + quantity + " sold!\n");
        }
    }
    
    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void printLowStock()
    {
        String prompt = "\n Please enter the minimum stock level > ";
        int minimum = reader.getInt(prompt);
        
        System.out.println(" Printing Stock with levels lower than " 
                           + minimum + "\n");
                           
        manager.printLowStockProducts(minimum);
    }
    
    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void searchProducts()
    {
        String prompt = "\n Please enter search term > ";
        String target = reader.getString(prompt);
        
        System.out.println(" Printing products matching " 
                           + target + "\n");
                           
        manager.searchProducts(target);
    }

    
    private Product getProduct()
    {
        String prompt = "\n Please enter the product ID number > ";
        
        int id = reader.getInt(prompt);
        Product product = manager.findProduct(id);
        
        if(product == null)
            System.out.println("    Product " + id + " not found!");
            
        return product;
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        if(ConsoleColours.IS_AVAILABLE)
            System.out.print(ConsoleColours.ANSI_BRIGHT_WHITE +
                    ConsoleColours.ANSI_BG_YELLOW);

        System.out.println();
        System.out.println("    Add:         Add a new product");
        System.out.println("    Deliver:     Deliver a product");
        System.out.println("    Remove:      Remove an old product");
        System.out.println("    Sell  :      Sell a product");
        System.out.println("    Search:      For products by name");
        System.out.println("    Low Stock:   List all low stock products");
        System.out.println("    Print:       Print all products");
        System.out.println("    Quit:        Quit the program");
        System.out.println();
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        if(ConsoleColours.IS_AVAILABLE)
            System.out.print(ConsoleColours.ANSI_BLACK +
                         ConsoleColours.ANSI_BG_YELLOW);
                           
        System.out.println("    ******************************");
        System.out.println("     Stock Management Application ");
        System.out.println("       App05: by Derek Peacock");
        System.out.println("    ******************************");
    }
}
