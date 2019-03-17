
public class User implements Comparable<User>{
	public int score;
	public String name = new String();
	
	public User() {
		name = "";
		score = 0;
	}
	public User(String n, int s) {
		name = n;
		score = s;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(User us) {
		int compareScore=((User)us).getScore();
		return compareScore-this.score;
	}
	

	
	
}
