/**
 * @author Caleb Wallwork
 * Class for Customer
 */
package assg8_wallworkc19;

public class Customer extends KeyedItem<String> {

	String id, name, num;
	
	/**
	 * Constructor with given id, name, and phone number
	 * @param nId the id
	 * @param nName the name
	 * @param nNum the phone number
	 */
	public Customer (String nId, String nName, String nNum)
	{
		super(nId);
		id = nId;
		name = nName;
		num = nNum;
	}

	/**
	 * Gets id
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets id
	 * @param id the id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the phone number
	 * @return the num
	 */
	public String getNumber() {
		return num;
	}

	/**
	 * Sets phone number
	 * @param num the num
	 */
	public void setNum(String num) {
		this.num = num;
	}
	  
	/**
	 * Prints the customers id, name, and phone number
	 */
	@Override
	public String toString() {
		String cust = "ID: "+ this.id +"\tCustomer: " + this.name + "\t\tPhone Number " + this.num;
		return cust;
	      
	}
	
	/**
	 * Gets the customer
	 * @return the num
	 */
	public Customer getCustomer()
	{
		Customer x = new Customer(this.id, this.name, this.num);
		return x;
	}
	  
	/**
	 * Gets the full name by adding first and last names
	 * @return x the full name
	 */
	public String fullName(String f, String l)
	{
		String x = f + " " + l;
		return x;
	}
	
}
