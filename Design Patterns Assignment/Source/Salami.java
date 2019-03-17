
public class Salami implements InterfaceTopping{

	public int price = 3;
	public String title = " Salami";
	//public boolean isUsed = false;
	
	Salami(){
		
	}
	
	Salami(InterfaceTopping ipizza){
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
