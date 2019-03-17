
public class HotPepper implements InterfaceTopping {

	public int price = 1;
	String title = " Hot Pepper";

	HotPepper() {

	}

	HotPepper(InterfaceTopping ipizza) {

		price += ipizza.getPrice();
		title = ipizza.getTitle() + title;

	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

}
