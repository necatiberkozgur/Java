import java.io.*;
import java.io.PrintWriter;

public class FileProcessor {

	public void processfile(BufferedReader input, BufferedReader customer, BufferedReader order)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		ManageCustomers mngCust = new ManageCustomers(); //Creating a ManageCustomers object to work on customers.
		ManageOrders mngOrd = new ManageOrders();	//Creating a ManageOrders object to work on orders.
		
		//Variables to work on input files as strings
		int wordCount;
		String[] splittedstring;
		String line = new String();
		PrintWriter out = new PrintWriter("output.txt");

		//Temporary variables which will be assigned to necessary attributes later.
		int ordernum = -1;
		String customerID = new String();
		String customerName = new String();
		String customerPhone = new String();
		String customerAddress = new String();
		String orderid = new String();
		String ordercust = new String();
		Pizza pizza;


		//Reading customer file:
		while ((line = customer.readLine()) != null) {
			wordCount = 0;
			for (String retval : line.split(" ")) {
				if (wordCount == 0) {
					customerID = retval;
				} else if (wordCount == 1) {
					retval = retval + " ";
					customerName = retval;
				} else if (wordCount == 2) {
					customerName = customerName + retval;
				} else if (wordCount == 3) {
					customerPhone = retval;
				} else if (wordCount == 5) {
					customerAddress = retval;
				} else if (wordCount > 5) {
					customerAddress += " " + retval;
				}
				wordCount++;
			}
			mngCust.addCustomer(new Customer(customerID, customerName, customerPhone, customerAddress));

		}


		//Reading order file:
		while ((line = order.readLine()) != null) {
			splittedstring = line.split(" ");
			if (splittedstring[0].equals("Order:")) {
				ordernum++;
				orderid = splittedstring[1];
				ordercust = splittedstring[2];
				mngOrd.addOrder(new Order(orderid, ordercust));
			} else if (splittedstring[0].equals("AmericanPan")) {
				pizza = new Pizza(1);
				for (int a = 1; a < splittedstring.length; a++) {
					if (a <= 3) {
						pizza.addTopping((InterfaceTopping) Class.forName(splittedstring[a]).newInstance());
					}
				}
				mngOrd.getAllOrders().get(ordernum).addPizza(pizza);
			} else if (splittedstring[0].equals("Neapolitan")) {
				pizza = new Pizza(2);
				for (int a = 1; a < splittedstring.length; a++) {
					if (a <= 3) {
						pizza.addTopping((InterfaceTopping) Class.forName(splittedstring[a]).newInstance());
					}
					if (a == 4) {
						out.println("Maximum 3 toppings can be added!");
					}
				}
				mngOrd.getAllOrders().get(ordernum).addPizza(pizza);
			} else if (splittedstring[0].equals("Softdrink")) {
				mngOrd.getAllOrders().get(ordernum).addDrink();
			} else {
				out.println("Error occured while reading file! Check order list");
			}

		}


		// Reading input file:
		while ((line = input.readLine()) != null) {
			splittedstring = line.split(" ");
			if (splittedstring[0].equals("AddCustomer")) {
				customerID = splittedstring[1];
				customerName = splittedstring[2] + " " + splittedstring[3];
				customerPhone = splittedstring[4];
				for (int a = 5; a < splittedstring.length; a++) {
					if (a == 5) {
						customerAddress = splittedstring[a];
					} else {
						customerAddress = " " + splittedstring[a];
					}
				}
				mngCust.addCustomer(new Customer(customerID, customerName, customerPhone, customerAddress));
				out.println("Customer  " + customerID + " " + splittedstring[2] + " added");
			} else if (splittedstring[0].equals("RemoveCustomer")) {
				out.println("Customer " + mngCust.getById(splittedstring[1]).getCustomerID() + " "
						+ mngCust.getById(splittedstring[1]).getCustomerName() + " removed");
				mngOrd.removeByCustomer(splittedstring[1]);
				mngCust.removeCustomer(mngCust.getById(splittedstring[1]));
			} else if (splittedstring[0].equals("CreateOrder")) {
				mngOrd.addOrder(new Order(splittedstring[1], splittedstring[2]));
				out.println("Order " + splittedstring[1] + " created");

			} else if (splittedstring[0].equals("AddPizza")) {
				if (splittedstring[2].equals("AmericanPan")) {
					pizza = new Pizza(1);
					for (int a = 3; a < splittedstring.length; a++) {
						if (a < 6) {
							pizza.addTopping((InterfaceTopping) Class.forName(splittedstring[a]).newInstance());
						}
						if (a >= 6) {
							out.println("Maximum 3 toppings can be added!");
							break;
						}
					}
					mngOrd.getById(splittedstring[1]).addPizza(pizza);
					out.println("AmericanPan pizza added to order " + splittedstring[1]);
				}
				if (splittedstring[2].equals("Neapolitan")) {
					pizza = new Pizza(2);
					for (int a = 3; a < splittedstring.length; a++) {
						if (a < 6) {
							pizza.addTopping((InterfaceTopping) Class.forName(splittedstring[a]).newInstance());
						}
						if (a >= 6) {
							out.println("Maximum 3 toppings can be added!");
							break;
						}
					}
					mngOrd.getById(splittedstring[1]).addPizza(pizza);
					out.println("Napolitan pizza added to order " + splittedstring[1]);

				}

			} else if (splittedstring[0].equals("AddDrink")) {
				mngOrd.getById(splittedstring[1]).addDrink();
				out.println("Drink added to order " + splittedstring[1]);
			} else if (splittedstring[0].equals("PayCheck")) {
				out.println("Paycheck for order " + splittedstring[1]);
				for (Pizza p : mngOrd.getById(splittedstring[1]).getPizzas()) {
					out.println("\t" + p.title);
				}
				if (mngOrd.getById(splittedstring[1]).getDrinks() > 0) {
					out.println("\tSoft Drink: $" + mngOrd.getById(splittedstring[1]).getDrinks());
				}
				out.println("\tTotal: $" + mngOrd.getById(splittedstring[1]).getPrice());

			} else if (splittedstring[0].equals("ListCustomers") || splittedstring[0].equals("List")) {
				out.println("Customer List:");
				mngCust.sortByName();
				for (Customer cs : mngCust.getAllCustomers()) {
					out.println(cs.getCustomerID() + " " + cs.getCustomerName() + " " + cs.getCustomerPhone()
							+ " Address: " + cs.getCustomerAddress());
				}
			} else {
				out.println("Error occured while reading file! Check input list");
			}
		}

		//Creating files to write updated databases
		PrintWriter writeCustomers = new PrintWriter("customerafter.txt");
		PrintWriter writeOrders = new PrintWriter("orderafter.txt");
		mngCust.sortByID();
		for (Customer cs : mngCust.getAllCustomers()) {
			writeCustomers.println(cs.getCustomerID() + " " + cs.getCustomerName() + " " + cs.getCustomerPhone()
					+ " Address: " + cs.getCustomerAddress());
		}
		mngCust.sortByID();
		for (Order or : mngOrd.getAllOrders()) {
			writeOrders.println("Order: " + or.getOrderID() + " " + or.getOrderCustomer());
			for (Pizza pi : or.getPizzas()) {
				writeOrders.println(pi.title);

			}
			if (or.getDrinks() > 0) {
				writeOrders.println("Softdrink");
			}
		}

		//Closing files
		writeCustomers.close();
		writeOrders.close();
		out.close();

	}
}
