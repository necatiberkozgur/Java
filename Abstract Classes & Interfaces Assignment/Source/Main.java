import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		
		/* Variables for file IO*/
		BufferedReader input = new BufferedReader(new FileReader("gameGrid.txt"));
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		String line = new String();
		String strInput = new String();
	    strInput = null;
	    
	    /*Variables for game process*/
	    ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
	    ArrayList<User> users = new ArrayList<User>();
		User u = new User();
		D jewelD = new D();
		W jewelW = new W();
		S jewelS = new S();
		T jewelT = new T();
		BackSlash jewelBSlash = new BackSlash();
		Slash jewelSlash = new Slash();
		Plus jewelPlus = new Plus();
		Minus jewelMinus = new Minus();
		VerticalLine jewelVLine = new VerticalLine();
		int x, y;
		

		/* Initialize grid */
		while ((line = input.readLine()) != null) {
			ArrayList<String> gridLine = new ArrayList<String>();
			for (String jewel : line.split(" ")) {
				gridLine.add(jewel);
			}
			grid.add(gridLine);
		}

		System.out.println("Game grid: ");
		jewelD.showGrid(grid);
		System.out.print("Enter coordinates or press " + "E" + " to exit: ");
		/*  Processing the input file/entered coordinates  */
		    try {
		      while ((strInput = bufReader.readLine()) != null) {
		    	  System.out.println(strInput);
					if (strInput.equalsIgnoreCase("E")) {
						System.out.print("Enter username: ");
						String username = bufReader.readLine();
						System.out.println(username);
						u.setName(username);
						break;
					} else {
						
						try {
							y = Integer.parseInt(strInput.split(" ")[0]);
							x = Integer.parseInt(strInput.split(" ")[1]);
							if (y < 0 || y > grid.size() - 1 || x < 0 || x > grid.get(0).size() - 1) {
								System.out.println("Coordinates out of bound!");
								System.out.print("Enter coordianates or press " + "E" + " to exit: ");		
							}
							else {
								if (grid.get(y).get(x).equals("D")) {
									jewelD.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("S")) {
									jewelS.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("T")) {
									jewelT.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("W")) {
									jewelW.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("+")) {
									jewelPlus.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("-")) {
									jewelMinus.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("\\")) {
									jewelBSlash.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("/")) {
									jewelSlash.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else if (grid.get(y).get(x).equals("|")) {
									jewelVLine.scanMatchings(grid, y, x, u);
									jewelD.arrangeGrid(grid);
									jewelD.showGrid(grid);
								} else {
									System.out.println("No jewel at that coordinate!");
								}
								System.out.print("Enter coordianates or press " + "E" + " to exit: ");		
							}
						} catch (Exception e) {
							System.out.println("Invalid input.");
							System.out.print("Enter coordianates or press " + "E" + " to exit: ");
						}
					}
				}	      
		    } catch (Exception e) {
		    	System.out.println("An error occured while reading!");
		      e.printStackTrace();
		    }
		    
		    try {
				BufferedReader inBuf = new BufferedReader(new FileReader("leaderboard.txt"));
				while ((line = inBuf.readLine()) != null) {
					String[] temp = line.split(" ");
						users.add(new User(temp[0], Integer.parseInt(temp[1])));
				}
				inBuf.close();
			} catch (Exception e) {
				try {	System.out.println("Error occured while reading file(leaderboard.txt)(file not found/invalid entry)");
					BufferedWriter outBuf = new BufferedWriter(new FileWriter("leaderboard.txt"));
					outBuf.write((u.getName() + " " + Integer.toString(u.getScore())));
					outBuf.close();

				} catch (IOException e1) {
					System.out.println("Error occured while writing to file");

				}
			}
		    users.add(u);
			Collections.sort(users);
		    System.out.println("Total score: " + u.getScore());
			if(users.size()>1) {
		    if(users.indexOf(u)==0) {
		    	System.out.println("Your rank is 1/ " + users.size() + ", your score is "+ (u.getScore() - users.get(1).getScore()) + " point(s) higher than " + users.get(1).getName());
		    }
		     else if(users.indexOf(u)==users.size()-1) {
		    	System.out.println("Your rank is " + users.size() + "/" + users.size() + 
				", your score is "+ ((users.get(users.size()-2).getScore() - u.getScore())*-1) + " point(s) lower than " + users.get(users.size()-2).getName());
			} else{
				System.out.println("Your rank is " + (users.indexOf(u)+1) + "/" + users.size() + 
				", your score is "+ (users.get(users.indexOf(u)-1).getScore() - u.getScore()) + " point(s) lower than " + users.get(users.indexOf(u)-1).getName() + " and " + 
					(u.getScore() - users.get(users.indexOf(u)+1).getScore()) + " point(s) higher than " + users.get(users.indexOf(u)+1).getName());
			}
			}else{System.out.println("Your rank is 1/1. Your score: " + u.getScore());}
		    System.out.println("Good Bye!");		   
		input.close();
	}

}

