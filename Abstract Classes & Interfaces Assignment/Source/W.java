import java.util.ArrayList;

public class W extends Jewel {

	public W() {
		Jewels.add("W");
		Jewels.add("S");
		Jewels.add("T");
		Jewels.add("D");
		Jewels.add("+");
		Jewels.add("-");
		Jewels.add("/");
		Jewels.add("\\");
		Jewels.add("|");
		letterJewels.add("W");
		letterJewels.add("S");
		letterJewels.add("T");
		letterJewels.add("D");
		mathJewels.add("+");
		mathJewels.add("-");
		mathJewels.add("/");
		mathJewels.add("\\");
		mathJewels.add("|");
		hJewels.add("+");
		hJewels.add("-");
		vJewels.add("+");
		vJewels.add("|");
		point = 10;
	}

	@Override
	public void scanMatchings(ArrayList<ArrayList<String>> grid, int y_pos, int x_pos, User usr) {
		if (x_pos >= 0 && y_pos >= 0 && x_pos <= grid.get(1).size() - 1 && y_pos <= grid.size() - 1) {
			if (x_pos < 2 && y_pos < 2) { /* Upper Left Corner of the Grid */
				if (!grid.get(y_pos + 2).get(x_pos).equals(" ") && (grid.get(y_pos + 1).get(x_pos).equals("W")
						|| (grid.get(y_pos + 1).get(x_pos).equals(grid.get(y_pos + 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {
					processScore(grid.get(y_pos + 1).get(x_pos), grid.get(y_pos + 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos + 2).equals(" ") && (grid.get(y_pos).get(x_pos + 1).equals("W")
						|| (grid.get(y_pos).get(x_pos + 1).equals(grid.get(y_pos).get(x_pos + 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& !grid.get(y_pos).get(x_pos + 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2))))) {
					processScore(grid.get(y_pos).get(x_pos + 1), grid.get(y_pos).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos + 1))
										&& grid.get(y_pos + 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos + 2))))) {
					processScore(grid.get(y_pos + 1).get(x_pos + 1), grid.get(y_pos + 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos + 1, " ");
					grid.get(y_pos + 2).set(x_pos + 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos < 2 && y_pos >= 2 && y_pos <= grid.size() - 3) { /* Mid-Left of the Grid */
				if (!grid.get(y_pos - 2).get(x_pos).equals(" ") && (grid.get(y_pos - 1).get(x_pos).equals("W")
						|| (grid.get(y_pos - 1).get(x_pos).equals(grid.get(y_pos - 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos).get(x_pos - 2), grid.get(y_pos).get(x_pos - 1), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos).equals(" ") && (grid.get(y_pos + 1).get(x_pos).equals("W")
						|| (grid.get(y_pos + 1).get(x_pos).equals(grid.get(y_pos + 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos + 1).get(x_pos), grid.get(y_pos + 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos + 2).equals(" ") && (grid.get(y_pos).get(x_pos + 1).equals("W")
						|| (grid.get(y_pos).get(x_pos + 1).equals(grid.get(y_pos).get(x_pos + 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& !grid.get(y_pos).get(x_pos + 1).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2))))) {

					processScore(grid.get(y_pos).get(x_pos + 2), grid.get(y_pos).get(x_pos + 1), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos + 1))
										&& grid.get(y_pos + 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos + 2), grid.get(y_pos + 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos + 1, " ");
					grid.get(y_pos + 2).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos - 1))
										&& grid.get(y_pos - 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos + 1), grid.get(y_pos - 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos + 1, " ");
					grid.get(y_pos - 2).set(x_pos + 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos < 2 && y_pos > grid.size() - 3) { // Lower Left Corner of the Grid
				if (!grid.get(y_pos - 2).get(x_pos).equals(" ") && (grid.get(y_pos - 1).get(x_pos).equals("W")
						|| (grid.get(y_pos - 1).get(x_pos).equals(grid.get(y_pos - 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos - 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos + 2).equals(" ") && (grid.get(y_pos).get(x_pos + 1).equals("W")
						|| (grid.get(y_pos).get(x_pos + 1).equals(grid.get(y_pos).get(x_pos + 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& !grid.get(y_pos).get(x_pos + 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2))))) {

					processScore(grid.get(y_pos).get(x_pos + 1), grid.get(y_pos).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos + 1))
										&& grid.get(y_pos - 2).get(x_pos + 1).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos - 2), grid.get(y_pos - 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos + 1, " ");
					grid.get(y_pos - 2).set(x_pos + 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos >= 2 && y_pos < 2 && x_pos <= grid.get(0).size() - 3) { // Upper Middle of the Grid
				if (!grid.get(y_pos + 2).get(x_pos).equals(" ") && (grid.get(y_pos + 1).get(x_pos).equals("W")
						|| (grid.get(y_pos + 1).get(x_pos).equals(grid.get(y_pos + 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos + 1).get(x_pos), grid.get(y_pos + 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos - 2).equals(" ") && (grid.get(y_pos).get(x_pos - 1).equals("W")
						|| (grid.get(y_pos).get(x_pos - 1).equals(grid.get(y_pos).get(x_pos - 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos).get(x_pos - 1).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos - 2))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos + 2).equals(" ") && (grid.get(y_pos).get(x_pos + 1).equals("W")
						|| (grid.get(y_pos).get(x_pos + 1).equals(grid.get(y_pos).get(x_pos + 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& !grid.get(y_pos).get(x_pos + 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2))))) {

					processScore(grid.get(y_pos).get(x_pos + 1), grid.get(y_pos).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos + 1))
										&& grid.get(y_pos + 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos + 1), grid.get(y_pos + 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos + 1, " ");
					grid.get(y_pos + 2).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals(grid.get(y_pos + 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos - 1))
										&& grid.get(y_pos + 2).get(x_pos - 2).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos - 1), grid.get(y_pos + 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos - 1, " ");
					grid.get(y_pos + 2).set(x_pos - 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}

			} else if (x_pos > grid.get(0).size() - 3 && y_pos < 2) { // Upper Right Corner of the grid
				if (!grid.get(y_pos + 2).get(x_pos).equals(" ") && (grid.get(y_pos + 1).get(x_pos).equals("W")
						|| (grid.get(y_pos + 1).get(x_pos).equals(grid.get(y_pos + 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos + 1).get(x_pos), grid.get(y_pos + 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos - 2).equals(" ") && (grid.get(y_pos).get(x_pos - 1).equals("W")
						|| (grid.get(y_pos).get(x_pos - 1).equals(grid.get(y_pos).get(x_pos - 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos).get(x_pos - 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos - 2))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals(grid.get(y_pos + 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos - 1))
										&& grid.get(y_pos + 2).get(x_pos).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos - 2), grid.get(y_pos + 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos - 1, " ");
					grid.get(y_pos + 2).set(x_pos - 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos > grid.get(0).size() - 3 && y_pos >= 2
					&& y_pos <= grid.size() - 3) { /* Mid- Right of the Grid */
				if (!grid.get(y_pos - 2).get(x_pos).equals(" ") && (grid.get(y_pos - 1).get(x_pos).equals("W")
						|| (grid.get(y_pos - 1).get(x_pos).equals(grid.get(y_pos - 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& !grid.get(y_pos - 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos))))) {

					processScore(grid.get(y_pos - 1).get(x_pos), grid.get(y_pos - 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos).equals(" ") && (grid.get(y_pos + 1).get(x_pos).equals("W")
						|| (grid.get(y_pos + 1).get(x_pos).equals(grid.get(y_pos + 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos + 1).get(x_pos), grid.get(y_pos + 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos - 2).equals(" ") && (grid.get(y_pos).get(x_pos - 1).equals("W")
						|| (grid.get(y_pos).get(x_pos - 1).equals(grid.get(y_pos).get(x_pos - 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos).get(x_pos - 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos - 2))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals(grid.get(y_pos - 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos - 1))
										&& grid.get(y_pos - 2).get(x_pos - 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos - 1), grid.get(y_pos - 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos - 1, " ");
					grid.get(y_pos - 2).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals(grid.get(y_pos + 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos - 1))
										&& grid.get(y_pos + 2).get(x_pos - 2).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos - 1), grid.get(y_pos + 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos - 1, " ");
					grid.get(y_pos + 2).set(x_pos - 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (x_pos > grid.get(0).size() - 3 && y_pos > grid.size() - 3) { /* Lower Right Corner of the Grid */
				if (!grid.get(y_pos - 2).get(x_pos).equals(" ") && (grid.get(y_pos - 1).get(x_pos).equals("W")
						|| (grid.get(y_pos - 1).get(x_pos).equals(grid.get(y_pos - 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + -1).get(x_pos))
								&& !grid.get(y_pos - 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos))))) {

					processScore(grid.get(y_pos - 1).get(x_pos), grid.get(y_pos - 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos - 2).equals(" ") && (grid.get(y_pos).get(x_pos - 1).equals("W")
						|| (grid.get(y_pos).get(x_pos - 1).equals(grid.get(y_pos).get(x_pos - 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos).get(x_pos - 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos - 2))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals(grid.get(y_pos - 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos - 1))
										&& grid.get(y_pos - 2).get(x_pos - 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos - 1), grid.get(y_pos - 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos - 1, " ");
					grid.get(y_pos - 2).set(x_pos - 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else if (y_pos > grid.size() - 3 && x_pos <= grid.get(0).size() - 3
					&& x_pos >= 2) { /* Lower Middle of the Grid */
				if (!grid.get(y_pos - 2).get(x_pos).equals(" ") && (grid.get(y_pos - 1).get(x_pos).equals("W")
						|| (grid.get(y_pos - 1).get(x_pos).equals(grid.get(y_pos - 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& !grid.get(y_pos - 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos))))) {

					processScore(grid.get(y_pos - 1).get(x_pos), grid.get(y_pos - 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos - 2).equals(" ") && (grid.get(y_pos).get(x_pos - 1).equals("W")
						|| (grid.get(y_pos).get(x_pos - 1).equals(grid.get(y_pos).get(x_pos - 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos).get(x_pos - 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos - 2))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos + 2).equals(" ") && (grid.get(y_pos).get(x_pos + 1).equals("W")
						|| (grid.get(y_pos).get(x_pos + 1).equals(grid.get(y_pos).get(x_pos + 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& !grid.get(y_pos).get(x_pos - 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2))))) {

					processScore(grid.get(y_pos).get(x_pos + 1), grid.get(y_pos).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals(grid.get(y_pos - 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos - 1))
										&& grid.get(y_pos - 2).get(x_pos - 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos - 1), grid.get(y_pos - 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos - 1, " ");
					grid.get(y_pos - 2).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos + 1))
										&& grid.get(y_pos - 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos + 1), grid.get(y_pos - 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos + 1, " ");
					grid.get(y_pos - 2).set(x_pos + 2, " ");
					return;
				} else {
					System.out.println("No matching found");
				}
			} else { /* Normal cases */
				if (!grid.get(y_pos - 2).get(x_pos).equals(" ") && (grid.get(y_pos - 1).get(x_pos).equals("W")
						|| (grid.get(y_pos - 1).get(x_pos).equals(grid.get(y_pos - 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& !grid.get(y_pos - 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos - 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos))))) {

					processScore(grid.get(y_pos - 1).get(x_pos), grid.get(y_pos - 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos, " ");
					grid.get(y_pos - 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos).equals(" ") && (grid.get(y_pos + 1).get(x_pos).equals("W")
						|| (grid.get(y_pos + 1).get(x_pos).equals(grid.get(y_pos + 2).get(x_pos))
								&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& !grid.get(y_pos + 2).get(x_pos).equals("D"))
						|| (vJewels.contains(grid.get(y_pos + 1).get(x_pos))
								&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos))))) {

					processScore(grid.get(y_pos + 1).get(x_pos), grid.get(y_pos + 2).get(x_pos), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos, " ");
					grid.get(y_pos + 2).set(x_pos, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos - 2).equals(" ") && (grid.get(y_pos).get(x_pos - 1).equals("W")
						|| (grid.get(y_pos).get(x_pos - 1).equals(grid.get(y_pos).get(x_pos - 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& !grid.get(y_pos).get(x_pos - 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos - 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos - 2))))) {

					processScore(grid.get(y_pos).get(x_pos - 1), grid.get(y_pos).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos - 1, " ");
					grid.get(y_pos).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos).get(x_pos + 2).equals(" ") && (grid.get(y_pos).get(x_pos + 1).equals("W")
						|| (grid.get(y_pos).get(x_pos + 1).equals(grid.get(y_pos).get(x_pos + 2))
								&& letterJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& !grid.get(y_pos).get(x_pos + 2).equals("D"))
						|| (hJewels.contains(grid.get(y_pos).get(x_pos + 1))
								&& mathJewels.contains(grid.get(y_pos).get(x_pos + 2))))) {

					processScore(grid.get(y_pos).get(x_pos + 1), grid.get(y_pos).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos).set(x_pos + 1, " ");
					grid.get(y_pos).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals(grid.get(y_pos - 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos - 1))
										&& grid.get(y_pos - 2).get(x_pos - 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos - 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos - 1), grid.get(y_pos - 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos - 1, " ");
					grid.get(y_pos - 2).set(x_pos - 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos + 1))
										&& grid.get(y_pos + 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos + 1).equals("\\")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos + 1), grid.get(y_pos + 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos + 1, " ");
					grid.get(y_pos + 2).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos - 2).get(x_pos + 2).equals(" ")
						&& (grid.get(y_pos - 1).get(x_pos + 1).equals("W")
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals(grid.get(y_pos + 2).get(x_pos + 2))
										&& letterJewels.contains(grid.get(y_pos - 1).get(x_pos + 1))
										&& grid.get(y_pos - 2).get(x_pos + 2).equals("D"))
								|| (grid.get(y_pos - 1).get(x_pos + 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos - 2).get(x_pos + 2))))) {

					processScore(grid.get(y_pos - 1).get(x_pos + 1), grid.get(y_pos - 2).get(x_pos + 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos - 1).set(x_pos + 1, " ");
					grid.get(y_pos - 2).set(x_pos + 2, " ");
					return;
				} else if (!grid.get(y_pos + 2).get(x_pos - 2).equals(" ")
						&& (grid.get(y_pos + 1).get(x_pos - 1).equals("W")
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals(grid.get(y_pos + 2).get(x_pos - 2))
										&& letterJewels.contains(grid.get(y_pos + 1).get(x_pos - 1))
										&& grid.get(y_pos + 2).get(x_pos - 1).equals("D"))
								|| (grid.get(y_pos + 1).get(x_pos - 1).equals("/")
										&& mathJewels.contains(grid.get(y_pos + 2).get(x_pos - 2))))) {

					processScore(grid.get(y_pos + 1).get(x_pos - 1), grid.get(y_pos + 2).get(x_pos - 2), usr,
							getJewelScore("W"));
					grid.get(y_pos).set(x_pos, " ");
					grid.get(y_pos + 1).set(x_pos - 1, " ");
					grid.get(y_pos + 2).set(x_pos - 2, " ");
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
