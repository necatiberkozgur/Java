import java.util.*;

public interface CustomerDAO {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer, String Address);

	public void removeCustomer(Customer customer);

	public Customer getById(String ID); //Getting a customer from database by its ID

	public ArrayList<Customer> getAllCustomers();

	public Customer getByName(String name); //Getting a customer from database by its name

	public void sortByName();

	public void sortByID();

}
