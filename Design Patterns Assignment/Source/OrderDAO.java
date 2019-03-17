import java.util.ArrayList;

public interface OrderDAO {
	public Order getById(String ID); //Getting an order element by its ID
	public void addOrder(Order order);
	public void deleteOrder(int i);
	public ArrayList<Order> getAllOrders(); //Getting arraylist of orders(i.e. database)
	public void removeByCustomer(String ID);
	
}
