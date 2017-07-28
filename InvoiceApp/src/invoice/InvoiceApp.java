/**
 * 
 */
package invoice;

/**
 * @author Jerilyn Mensah
 * Date: Friday July 28,2017
 *
 *
 *	This application will accept a list of products and its prices
 *	with the tax rate and will give an output of the product prices 
 *	added, the amount of tax due and the total amount due.
 *
 *  Sight modification on code done on 11:19 am.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		//Declare variables
		
		boolean addProduct = true;   // Continues to ask for product description until user says no then boolean sets to false
		double taxRate;              // Tax rate of all products
		double price;                // Price of products 
		double finalAmount = 0;          // total of taxRateAmount + subTotal 
		double subTotal = 0;             // Amount before tax rate is added
		double taxRateAmount = 0;        // Amount of taxRate * Price
		
		String descr;              	 // Product description
		String getPrice;			 // Finds the price of product
		String description = null;		     // Finds the description of product
		
		List<Product> products = new ArrayList<Product>();  // Stores all products entered
		
	do{
		// Enter the product description
		
		System.out.println("Enter the product description:");
		descr = scanner.nextLine();
		
		// Enter the price of the products to be stored 
		
		System.out.println("Enter the price of object:");
		price = scanner.nextDouble();  
		scanner.nextLine();
						
		
		// Enter the tax rate
		
		System.out.println("Enter the tax rate. i.e. press 6 for 6%");
		taxRate = scanner.nextDouble();  // Stores tax rate. Tax rate is an integer.
		scanner.nextLine();
		taxRate /= 100;     // converts to decimal i.e. 5% converts to .05.
		
		// Make a new product
		
		Product currentProduct = new Product(taxRateAmount, description);
		
		// Add to ArrayList
		
		products.add(currentProduct);
		
		
		// Prompt the user to add more products or get total
		System.out.println("Would you like to add another product? Press Y/N");
		addProduct = scanner.nextLine().equalsIgnoreCase("y")? true : false;
	
	
  }   while(addProduct);
	
		// Display the sub total of product and description
	
			for (Product p : products){
				
		    
				subTotal += p.getPrice();
				System.out.println("Product price:" + p.getPrice());
				System.out.println("Product description:" + p.description());
			}
	
			
		// Get the Tax rate Amount
			
			taxRateAmount = subTotal * taxRate;
			
		// Get the Final Amount
			
			finalAmount = subTotal + taxRateAmount;
			
		// Display Tax Rate Amount and Final Amount
			System.out.println("Tax total:" + taxRateAmount);
			System.out.println("Total Amount due:" + finalAmount);
			
	}
	
}
			
			
	
	
