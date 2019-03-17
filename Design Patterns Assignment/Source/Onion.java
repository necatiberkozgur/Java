public class Onion implements InterfaceTopping {

	public int price = 2;
	public String title = " Onion";

	Onion(){
		
	}
	
	Onion(InterfaceTopping ipizza){

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
