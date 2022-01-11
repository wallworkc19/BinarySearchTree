/**
 * @author Caleb Wallwork
 * Class for Customer Roster
 */
package assg8_wallworkc19;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CustomerRoster{
	BinarySearchTree<Customer, String> cTree = new BinarySearchTree<Customer, String>();
	TreeIterator<Customer> dTree = new TreeIterator<Customer>(cTree);
	

	/**
	 * Loads the data from file
	 */
	public void loadData(String fileName) {
        try {
            Scanner scnr = new Scanner(new File(fileName));

            while(scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String split[] = line.split("\\s+");
                String id = String.valueOf(split[0]);
                String firstName = String.valueOf(split[1]);
                String lastName = String.valueOf(split[2]);
                String number = String.valueOf(split[3]);
                String fullName = firstName + " " + lastName;
                Customer Customer = new Customer(id, fullName, number);
                cTree.insert(Customer);
            }
            scnr.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

  
  
	/**
	 * Adds a customer with id, name, and phone number
	 * @param id the id
	 * @param name the name
	 * @param num the phone number
	 * @return true if added
	 * @return false if id already exists
	 */
	public boolean addCustomer(String id, String name, String num) {
		Customer nCustomer = new Customer(id,name,num);
		if(cTree.retrieve(id) == null) {
			cTree.insert(nCustomer);
			return true;
		}
		System.out.println("The id already exists");
		return false;
	}
  
  
  
	/**
	 * Searches the customer tree for id. If that id is found delete the contents of that node. if not found print error
	 * @param id the id  
	 * @return true if deleted
	 * @return false if no id found
	 */
	public boolean deleteCustomer(String id) {
		if(cTree.retrieve(id) == null) {
			System.out.println("The customer was not found.");
			return false;
		}
		Customer cust = cTree.retrieve(id);
		cTree.delete(cust);
		return true;
	}
	
	/**
	 * Searches the customer tree for id. If that id is found return the customer. If not found print error
	 * @param id the id 
	 * @return cust The customer with its data
	 */
	public Customer searchCustomer(String id) {
		Customer cust;
		if(cTree.retrieve(id) == null) {
			System.out.println("The customer does not exist");
			cust = null;
			return cust;
		}
		cust = cTree.retrieve(id);
		return cust;
	}
  
	/**
	 * Updates the customers id, name, and phone number
	 * @param id the id
	 * @param name the name
	 * @param num the phone number
	 */
	public void updateCustomer(String nId, String nName, String nNum) {
		Customer cust = searchCustomer(nId);
		if(cust != null) {
			cTree.delete(nId);
			cust.name = nName;
			cust.num = nNum;
			cTree.insert(cust);
		}
		else {
			System.out.println("The id does not exist");
		}
	}
	
	/**
	 * Displays the customers id, name, and phone number
	 */
	public void displayCustomer() {
		dTree.setInorder();
		while(dTree.hasNext()) {
			System.out.println(dTree.next());
		}
	}
   
	/**
	 * Saves all the customers by writing them back to the file
	 * @param fileName the file name
	 */
	public void Save(String fileName) {
        Customer customer;
        dTree.setInorder();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
        }
        catch (IOException ex) {
            System.out.println("File not found");
        }
        while (dTree.hasNext()) {
            customer = (Customer) dTree.next();
            writer.println(customer.getKey() + "\t" + customer.getName() + "\t" + customer.getNumber());
        }
        writer.close();
    }
}