import java.util.*;

public class ManageOrders implements OrderDAO {
	ArrayList<Order> orderList = new ArrayList<Order>();

	public Order createOrder(String orderID, String customerID) {
		Order newOrder = new Order();
		newOrder.setOrderID(orderID);
		newOrder.setOrderCustomer(customerID);
		return newOrder;
	}

	public void addOrder(Order order) {
		orderList.add(order);
	}

	public void deleteOrder(int i) {
		orderList.remove(i);
	}

	public ArrayList<Order> getAllOrders() {
		return orderList;
	}

	public Order getById(String ID) {
		Order ord = new Order();
		for (Order o : orderList) {
			if (o.getOrderID().equals(ID)) {
				ord = o;
			}
		}
		return ord;
	}

	public void removeByCustomer(String ID) {
		Order toRemove = new Order();
		for (Order o : orderList) {
			if (o.getOrderCustomer().equals(ID)) {
				toRemove = o;
			}

		}
		orderList.remove(toRemove);
	}
}
