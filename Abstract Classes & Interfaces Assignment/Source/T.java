import java.util.*;

public class T extends Jewel {
	public T() {
		point = 15;
	}

	@Override
	public void scanMatchings(ArrayList<ArrayList<String>> grid, int y_pos, int x_pos, User usr) {
		if (x_pos >= 0 && x_pos < grid.get(0).size() && y_pos >= 0 && y_pos < grid.size()) {
			if (x_pos < 2 && y_pos < 2) { /* Upper Left Corner of the Grid */
				if ((grid.get(y_pos + 1).get(x_pos)).equals("T") && (grid.get(y_pos + 2).get(x_pos)).equals("T")) {

					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos < 2 && y_pos > grid.size() - 3) { // Lower Left Corner of the Grid
				if ((grid.get(y_pos - 1).get(x_pos)).equals("T") && (grid.get(y_pos - 2).get(x_pos)).equals("T")) {

					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos >= 2 && y_pos < 2 && x_pos <= grid.get(0).size() - 3) { // Upper Middle of the Grid
				if ((grid.get(y_pos + 1).get(x_pos)).equals("T") && (grid.get(y_pos + 2).get(x_pos)).equals("T")) {

					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}

			} else if (x_pos < 2 && y_pos >= 2 && y_pos <= grid.size() - 3) { /* Mid-Left of the Grid */
				if ((grid.get(y_pos - 1).get(x_pos)).equals("T") && (grid.get(y_pos - 2).get(x_pos)).equals("T")) {

					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else if ((grid.get(y_pos + 1).get(x_pos)).equals("T")
						&& (grid.get(y_pos + 2).get(x_pos)).equals("T")) {

					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos > grid.get(0).size() - 3 && y_pos >= 2
					&& y_pos <= grid.size() - 3) { /* Mid - RIGHT of the Grid */
				if ((grid.get(y_pos - 1).get(x_pos)).equals("T") && (grid.get(y_pos - 2).get(x_pos)).equals("T")) {

					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else if ((grid.get(y_pos + 1).get(x_pos)).equals("T")
						&& (grid.get(y_pos + 2).get(x_pos)).equals("T")) {

					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}

			} else if (x_pos > grid.get(0).size() - 3 && y_pos > grid.size() - 3) { /* Lower Right Corner of the Grid */
				if ((grid.get(y_pos - 1).get(x_pos)).equals("T") && (grid.get(y_pos - 2).get(x_pos)).equals("T")) {

					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}

			} else if (y_pos > grid.size() - 3 && x_pos <= grid.get(0).size() - 3
					&& x_pos >= 2) { /* Lower Middle of the Grid */
				if ((grid.get(y_pos - 1).get(x_pos)).equals("T") && (grid.get(y_pos - 2).get(x_pos)).equals("T")) {

					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}
			} else { /* Normal Situations */
				if ((grid.get(y_pos - 1).get(x_pos)).equals("T") && (grid.get(y_pos - 2).get(x_pos)).equals("T")) {

					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else if ((grid.get(y_pos + 1).get(x_pos)).equals("T")
						&& (grid.get(y_pos + 2).get(x_pos)).equals("T")) {

					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					usr.setScore(point * 3);
					System.out.println("Score: " + point * 3);
					return;
				} else {
					System.out.println("No matching found");
				}
			}
		} else {
			System.out.println("Invalid coordinates!");
		}
	}
}