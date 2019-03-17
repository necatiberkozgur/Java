import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String foodtxt = new String("food.txt");
		String peopletxt = new String("people.txt");
		String commandtxt = new String(args[0]);
		String sporttxt = new String("sport.txt");
		Food fd = new Food();
		Sport sp = new Sport();
		People ppl = new People();
		BufferedReader people = new BufferedReader(new FileReader(peopletxt));
		BufferedReader food = new BufferedReader(new FileReader(foodtxt));
		BufferedReader sport = new BufferedReader(new FileReader(sporttxt));
		BufferedReader command = new BufferedReader(new FileReader(commandtxt));
		fd.read(food);
		sp.read(sport);
		ppl.read(people);
		Cmdrun.CommandRun(fd,sp,ppl,command);
		food.close();
		people.close();
		sport.close();
		command.close();
		return;
		}
}	
