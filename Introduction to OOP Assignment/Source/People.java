import java.io.*;
public class People {
	String[] PplNames= new String[50];
	int[] PplId  = new int[50];
	int[] PplHeight  = new int[50];
	int[] PplYear = new int[50];
	int[] PplWeight = new int[50];
	int[] Taken = new int[50];
	int[] Burnt = new int[50];
	String[] PplGender= new String[50];
	String line;
	
	public int[] getBurnt() {
		return Burnt;
	}
	
	public int[] getTaken() {
		return Taken;
	}
	public int[] getPplId() {
		return PplId;
	}
	public int[] getPplHeight() {
		return PplHeight;
	}
	public String[] getPplNames() {
		return PplNames;
	}
	public int[] getPplYear() {
		return PplYear;
	}
	public String[] getPplGender() {
		return PplGender;
	}
	public int[] getPplWeight() {
		return PplWeight;
	}
	
	public void setTaken(int ind, int taken) {
		Taken[ind] += taken;
	}
	public void setBurnt(int ind, int burnt) {
		Burnt[ind] += burnt;
	}
	public void setPplId(int ind, int id) {
		PplId[ind] = id;
	}
	public void setPplHeight(int ind, int Height) {
		PplHeight[ind] = Height;
	}
	public void setPplNames(int ind, String name) {
		PplNames[ind] = name;
	}
	public void setPplYear(int ind, int year) {
		PplYear[ind] = year;
	}
	public void setPplGender(int ind, String Gender) {
		PplGender[ind] = Gender;
	}
	public void setPplWeight(int ind, int weight) {
		PplWeight[ind] = weight;
	}
	
	public int searchPeople(int peopleid) {
		int key = -1;
		for(int c = 0; c<50; c++) {
			if (PplId[c] == peopleid) {
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
		        	setPplId(idx, Integer.parseInt(retval));
		        }
		        else if(cnt == 1) {
		        	setPplNames(idx, retval);
		        }
		        else if(cnt == 2){
		        	setPplGender(idx, retval);
		        }
		        else if(cnt == 3) {
		        	setPplWeight(idx, Integer.parseInt(retval));
		        }
		        else if(cnt == 4) {
		        	setPplHeight(idx, Integer.parseInt(retval));
		        }
		        else {
		        	setPplYear(idx, Integer.parseInt(retval));
		        }
		      cnt++; }
		idx++;
		}
	}
	public double dailyCalorieNeed(int key) {
		String m = new String("male");
		if(getPplGender()[key].equals(m)) {
			return (66 + 13.75*getPplWeight()[key] + 5*getPplHeight()[key] - 6.8*(2018-getPplYear()[key]));
			}
		else{
			return (665 + 9.6*getPplWeight()[key] + 1.7*getPplHeight()[key] - 4.7*(2018-getPplYear()[key]));
			}
	}
	
	public String show(int c) {
		return (getPplNames()[c] + "\t" + (2018-getPplYear()[c]) + "\t" +Math.round(dailyCalorieNeed(c)) + "kcal\t" 
	+ getTaken()[c] + "kcal\t"+ getBurnt()[c] + "kcal\t" + Math.round(getTaken()[c]-dailyCalorieNeed(c)-getBurnt()[c]) + "kcal");	
	}
}
