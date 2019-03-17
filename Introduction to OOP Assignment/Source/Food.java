import java.io.*;

public class Food {	
	
	String[] FoodNames= new String[100];
	int[] FoodId  = new int[100];
	int[] FoodCal  = new int[100];
	String line;

	public int[] getFoodId() {
		return FoodId;
	}
	public int[] getFoodCal() {
		return FoodCal;
	}
	public String[] getFoodNames() {
		return FoodNames;
	}
	public void setFoodId(int ind, int id) {
		FoodId[ind] = id;
	}
	public void setFoodCal(int ind, int cal) {
		FoodCal[ind] = cal;
	}
	public void setFoodNames(int ind, String name) {
		FoodNames[ind] = name;
	}
	
	public int searchFood(int foodid) {
		int key = -1;
		for(int c = 0; c<100; c++) {
			if (FoodId[c] == foodid) {
				key = c;
				break;
			}
		}
		return key;
	}
	
	public void read(BufferedReader fl) throws Exception {
		int idx = 0;
		int cnt;
		while ((line = fl.readLine()) != null) {
			cnt = 0;
			for (String retval: line.split("\t")) {
		        if(cnt == 0) {
		        	setFoodId(idx, Integer.parseInt(retval));
		        }
		        else if(cnt==1) {
		        	setFoodNames(idx, retval);
		        }
		        else {
		        	setFoodCal(idx, Integer.parseInt(retval));
		        }
		      cnt++; }
		idx++;
		}
	}
	
	public void show() {
		for(int c = 0; c<100; c++) {
			if(getFoodNames()[c]==null)
				break;
		System.out.print(getFoodId()[c]);	
		System.out.print("  " +getFoodNames()[c] + " ");
		System.out.println("  " +getFoodCal()[c]);
		}
	}

}
