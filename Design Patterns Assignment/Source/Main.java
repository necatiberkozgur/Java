import java.io.*;

public class Main {


	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
			FileProcessor fp = new FileProcessor();
			
			BufferedReader customer = new BufferedReader(new FileReader(args[2]));
			BufferedReader order = new BufferedReader(new FileReader(args[1]));
			BufferedReader input = new BufferedReader(new FileReader(args[0]));
			fp.processfile(input, customer, order);
			customer.close();
			order.close();
			input.close();

	}
	
	
}
