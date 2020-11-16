import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void takeDelivery(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("\n    Product ID" + id + " not found! \n"); 
        }
        else
        {
            System.out.println("    " + product);
            product.increaseQuantity(amount);
            System.out.println("    Re-stocking by " + amount);
            System.out.println();
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int index = 0;
        boolean found = false;
        Product product = null;
        
        while(!found && index < stock.size())
        {
           product = stock.get(index);
           if(product.getID() == id)
           {
               found = true;
           }
           else index++;
        }
        
        return product;
    }
    
    public void searchProducts(String targetPhrase)
    {
        int count = 0;
        targetPhrase.toLowerCase();
        
        System.out.println("\nSearching for " + targetPhrase + "\n");
        
        for(Product product : stock)
        {
            if(product.getName().toLowerCase().contains(targetPhrase))
            {
                System.out.println(product);
                count++;
            }
        }
        
        System.out.println("\nThere are " + count + " products containing " + 
                            targetPhrase + " in their name!\n");
    }
    
    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        for(Product product : stock)
        {
            System.out.println("    " + product);
        }
        
        System.out.println();
    }
    
    /**
    *  Print all product with zero quantity
    */
    public ArrayList<Product> printLowStockProducts(int minimum)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int count = 0;
        
        System.out.println(" Printing all out of stock products");
        System.out.println();
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= minimum)
            {
                count++;
                lowStock.add(product);
                System.out.println(product);
            }
        }
        
        System.out.println();
        System.out.println("There were " + count + 
                           " stock products with less than " + minimum +
                           " items\n");
        return lowStock;
    }
    
    /**
     * Increase the quantity of stock for all products in the lowStock
     * ArrayList.
     */
    public void restockLowProducts(int minimum)
    {
       ArrayList<Product> lowStock = printLowStockProducts(minimum);
       
       System.out.println("\nRe-Stocking to a minimum level of " + 
                          minimum + "\n");
                          
       for(Product product : lowStock)
       {
          product.increaseQuantity(minimum - product.getQuantity()); 
       }
    }
    
    /**
     * If the product exists that matches the id
     * remove that product from the list.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("\n Product ID " + id + " NOT FOUND!\n");
        }
        else
        {
            stock.remove(product);
            System.out.println("\n Product ID " + id + " REMOVED!\n");            
        }
    }
    
    public void renameProduct(int id, String newName)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println(" Product id = " + id + " not found!");
        }
        else
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("***RENAMED***");
            System.out.println(product);
        }
    }
    
    /**
     * If the product exists that matches the id
     * remove that product from the list.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("\n Product ID " + id + " NOT FOUND!\n");
        }
        else
        {
            product.sell(amount);
            System.out.println("\n Product ID " + id + " sold!\n");            
        }
    }    
}
