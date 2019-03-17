
public class Soudjouk implements InterfaceTopping {

	public int price = 3;
	String title = " Soudjouk";
	// public boolean isUsed = false;

	Soudjouk() {

	}

	Soudjouk(InterfaceTopping ipizza) {

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
