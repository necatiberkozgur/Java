import java.util.ArrayList;

public class Minus extends Jewel {
	public Minus() {
		mathJewels.add("-");
		mathJewels.add("+");
		mathJewels.add("/");
		mathJewels.add("\\");
		hJewels.add("+");
		hJewels.add("-");
		vJewels.add("+");
		vJewels.add("|");
		point = 20;
	}

	@Override
	public void scanMatchings(ArrayList<ArrayList<String>> grid, int y_pos, int x_pos, User usr) {

		if (x_pos >= 0 && y_pos >= 0 && x_pos <= grid.get(1).size() - 1
				&& y_pos <= grid.size() - 1) {/* Checks whether the entered coordinates are in grid or not */
			if (x_pos < 2 && y_pos < 2) { /* Upper Left Corner of the Grid */
				if ((grid.get(y_pos).get(x_pos + 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos + 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos + 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				}else {
					System.out.println("No matching found");
				}
			} else if (x_pos < 2 && y_pos >= 2 && y_pos <= grid.size() - 3) { /* Mid-Left of the Grid */
				if ((grid.get(y_pos).get(x_pos + 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos + 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos + 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				}else {
					System.out.println("No matching found");
				}

			} else if (x_pos < 2 && y_pos > grid.size() - 3) { // Lower Left Corner of the Grid
				if ((grid.get(y_pos).get(x_pos + 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos + 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos + 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				}else {
					System.out.println("No matching found");
				}

			} else if (x_pos >= 2 && y_pos < 2 && x_pos <= grid.get(0).size() - 3) { // Upper Middle of the Grid
				if ((grid.get(y_pos).get(x_pos - 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos - 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos - 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else if ((grid.get(y_pos).get(x_pos + 1).equals("-")
						&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos + 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else {
					System.out.println("No matching found");
				}

			} else if (x_pos > grid.get(0).size() - 3 && y_pos < 2) { // Upper Right Corner of the grid
				if ((grid.get(y_pos).get(x_pos - 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos - 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos - 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				}else {
					System.out.println("No matching found");
				}
				
			} else if (x_pos > grid.get(0).size() - 3 && y_pos >= 2
					&& y_pos <= grid.size() - 3) { /* Mid- RIGHT of the Grid */
				if ((grid.get(y_pos).get(x_pos - 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos - 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos - 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else {
					System.out.println("No matching found");
				}
				
			} else if (x_pos > grid.get(0).size() - 3 && y_pos > grid.size() - 3) { /* Lower Right Corner of the Grid */
				if ((grid.get(y_pos).get(x_pos - 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos - 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos - 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else {
					System.out.println("No matching found");
				}
				
			} else if (y_pos > grid.size() - 3 && x_pos <= grid.get(0).size() - 3
					&& x_pos >= 2) { /* Lower Middle of the Grid */
				if ((grid.get(y_pos).get(x_pos - 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos - 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos - 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else if ((grid.get(y_pos).get(x_pos + 1).equals("-")
						&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos + 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else {
					System.out.println("No matching found");
				}
			} else { /* Normal cases */
				if ((grid.get(y_pos).get(x_pos - 1).equals("-") && mathJewels.contains(grid.get(y_pos).get(x_pos - 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos - 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				} else if ((grid.get(y_pos).get(x_pos + 1).equals("-")
						&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2)))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& hJewels.contains(grid.get(y_pos).get(x_pos + 2)))) {
					 
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					usr.setScore(point*3);System.out.println("Score: " + point*3);
					return;
				}else {
					System.out.println("No matching found");
				}
			}

		} else {
			System.out.println("Invalid coordinates");
		}

	}
}
