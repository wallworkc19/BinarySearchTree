/**
 * @author Caleb Wallwork
 * Class for Customer MIS 
 */
package assg8_wallworkc19;

import java.io.FileNotFoundException;
import java.util.*;

public class CustomerMIS {
	public static void main(String[] args) throws FileNotFoundException {
		CustomerRoster roster = new CustomerRoster();
		String fileName = "assg8_CustomerRoster.txt";
		roster.loadData(fileName);
		while(true) {
			System.out.print("1) Display the customer roster \n" +
					"2) Add a customer \n" +
					"3) Delete a customer \n" +
					"4) Search customer by ID \n" +
					"5) Update Information of a customer \n" +
					"6) Save and exit \n" +
					"7) Exit without saving\n\nEnter your choice:\n");
			Scanner scnr = new Scanner(System.in);
			int input = scnr.nextInt();
			String nId = "", nName = "", nNum = "";
			
			switch (input) {
			/**
			 * displays tree
			 */
			case 1:
				roster.displayCustomer();
				System.out.println("");
				break;
				
			/**
			 * adds customer
			 */
			case 2:
				System.out.println("Id:");
				while (nId.length() == 0) {
					nId = scnr.nextLine();
					if (nId.length() != 0) {
						System.out.println("Name:");
						while (nName.length() == 0) {
							nName = scnr.nextLine();
							if (nName.length() != 0) {
								System.out.println("Phone Number:");
								while (nNum.length() == 0) {
									nNum = scnr.nextLine();
									if (nNum.length() != 0) {
										roster.addCustomer(nId, nName, nNum);
										System.out.println("");
										break;
									}
								}
							}
						}
					}
				}
				break;
				
			/**
			 * deletes customer
			 */
			case 3:
				System.out.println("Id:");
				while (nId.length() == 0) {
					nId = scnr.nextLine();
					if (nId.length() != 0) {
						roster.deleteCustomer(nId);
						System.out.println("");
						break;
					}
				}
				break;
				
			/**
			 * search for customer by id
			 */
			case 4:
				System.out.println("Id:");
				while (nId.length() == 0) {
					nId = scnr.nextLine();
					if (nId.length() != 0) {
						roster.searchCustomer(nId);
						System.out.println("");
						break;
					}
				}
				break;
				
			/**
			 * updates customer
			 */
			case 5:
				System.out.println("Id:");
				while (nId.length() == 0) {
					nId = scnr.nextLine();
					if (nId.length() != 0) {
						System.out.println("Name:");
						while (nName.length() == 0) {
							nName = scnr.nextLine();
							if (nName.length() != 0) {
								System.out.println("Phone Number:");
								while (nNum.length() == 0) {
									nNum = scnr.nextLine();
									if (nNum.length() != 0) {
										roster.updateCustomer(nId, nName, nNum);
										System.out.println("");
										break;
									}
								}
							}
						}
					}
				}
				break;
				
			/**
			 * save and exit
			 */
			case 6:
				roster.Save(fileName);
	        	scnr.close();
	        	System.exit(0);
	        	
        	/**
			 * exit
			 */	
			case 7:
				scnr.close();
				System.exit(0);
			}
		}
	}
}
