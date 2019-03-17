
public class Pizza {
	public int price;
	public String title;

	public Pizza(int pan) {
		if (pan == 1) {
			title = "AmericanPan";
			price = 5;
		}

		if (pan == 2) {
			title = "Neapolitan";
			price = 10;
		}
	}

	public void addTopping(InterfaceTopping decoredPizza) {
		price += decoredPizza.getPrice();
		title += decoredPizza.getTitle();
	}

	public int cost() {
		return price;
	}

	public void printToppings() {
		System.out.println("\t" + title + " $" + cost());
		return;
	}

}
