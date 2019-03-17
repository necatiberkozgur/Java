import java.util.*;

public abstract class Jewel {
	public int point;
	ArrayList<String> Jewels = new ArrayList<String>();
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point += point;
	}
	ArrayList<String> letterJewels = new ArrayList<String>();
	ArrayList<String> mathJewels = new ArrayList<String>();
	ArrayList<String> hJewels = new ArrayList<String>(); /*jewels which can match horizontally */
	ArrayList<String> vJewels = new ArrayList<String>(); /*jewels which can match vertically */
	
	public abstract void scanMatchings(ArrayList<ArrayList<String>> grid, int y_pos, int x_pos, User usr);
	
	public void arrangeGrid(ArrayList<ArrayList<String>> grid) {
		for(int j = 1; j<grid.size(); j++) {
			for(int i = 1; i<grid.get(j).size(); i++) {
				if(grid.get(j).get(i).equals(" ")) {
					for(int k = j; k>0; k--) {
						grid.get(k).set(i, grid.get(k-1).get(i));
						grid.get(k-1).set(i, " ");
					}
				}
			}
		}
	}
	public void showGrid(ArrayList<ArrayList<String>> grid) {
		System.out.println();
		for (ArrayList<String> a : grid) {
			for (String str : a) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int getJewelScore(String jewelType) {
		if (jewelType.equals("D")) {
			return 30;
		} else if (jewelType.equals("S")) {
			return 15;
		} else if (jewelType.equals("T")) {
			return 15;
		} else if (jewelType.equals("W")) {
			return 10;
		} else if (jewelType.equals("+")) {
			return 20;
		} else if (jewelType.equals("-")) {
			return 20;
		} else if (jewelType.equals("\\")) {
			return 20;
		} else if (jewelType.equals("/")) {
			return 20;
		} else if (jewelType.equals("|")) {
			return 20;
		} else {
			return 0;
		}
	}
	public void processScore(String a, String b, User u, int pt) {
		int sc = pt + getJewelScore(a) + getJewelScore(b);
		System.out.println("Score: " + sc + " points.");
		u.setScore(sc);
	}
}
