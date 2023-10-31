import java.io.Serializable;

public class StudentClass implements Serializable{
	String name;
	int num;
	int score;
	
	public StudentClass(String name, int num, int score) {
		this.name=name;
		this.num=num;
		this.score=score;
	}
	
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	public int getScore() {
		return score;
	}

	
}
