import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class First extends JFrame {
	Scanner sc = new Scanner(System.in);
	char name;
	int number;
	int grade;
	
	public First() {
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel label1 = new JLabel("이름");
		JLabel label2 = new JLabel("학번");
		JLabel label3 = new JLabel("성적");
		JLabel label4 = new JLabel("학생 등록하기");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JTextField field3 = new JTextField(15);
		JButton button1 = new JButton("등록하기");
		JButton button2 = new JButton("취소");
		
		panel.add(label4);
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(button1);
		panel.add(button2);
				
		
		

		setTitle("덕성여대 화이팅");
		setSize(300,200);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		First f = new First();
	}
		
}
		
		

	