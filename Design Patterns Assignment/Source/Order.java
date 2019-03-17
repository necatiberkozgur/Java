import java.util.*;

public class Order {

	private String orderID;
	private String orderCustomer; //Customer which order will be assigned on and updated
	private double checkSum = 0;
	private int drinks = 0;
	public ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	Order() {

	}

	Order(String id, String customerID) {
		orderID = id;
		orderCustomer = customerID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(String orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public void addPizza(Pizza newPizza) {
		pizzas.add(newPizza);
	}

	public double getPrice() {
		for (Pizza p : pizzas) {
			checkSum += p.price;
		}

		return checkSum + drinks;
	}

	public int getDrinks() {
		return drinks;
	}

	public void addDrink() {
		drinks++;
	}

	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}

}
