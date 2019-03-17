import java.io.*;

public class Sport {

	String[] SportNames= new String[100];
	int[] SportId  = new int[100];
	int[] SportCal  = new int[100];
	String line;

	public int[] getSportId() {
		return SportId;
	}
	public int[] getSportCal() {
		return SportCal;
	}
	public String[] getSportNames() {
		return SportNames;
	}
	public void setSportId(int ind, int id) {
		SportId[ind] = id;
	}
	public void setSportCal(int ind, int cal) {
		SportCal[ind] = cal;
	}
	public void setSportNames(int ind, String name) {
		SportNames[ind] = name;
	}
	
	public int searchSport(int sportid) {
		int key = -1;
		for(int c = 0; c<100; c++) {
			if (SportId[c] == sportid) {
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
		        	setSportId(idx, Integer.parseInt(retval));
		        }
		        else if(cnt==1) {
		        	setSportNames(idx, retval);
		        }
		        else {
		        	setSportCal(idx, Integer.parseInt(retval));
		        }
		      cnt++; }
		idx++;
		}idx = 0;
		
	}
	
	public void show() {
		for(int c = 0; c<100; c++) {
			if(getSportNames()[c]==null)
				break;
		System.out.print(getSportId()[c]);	
		System.out.print("  " +getSportNames()[c] + " ");
		System.out.println("  " +getSportCal()[c]);
		}
	}
}
