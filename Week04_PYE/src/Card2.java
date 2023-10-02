import java.awt.*;
import javax.swing.*;



public class Card2 extends JFrame {
	public Card2()	{
		JPanel panel = new JPanel();
		add(panel);

    	setSize(400,200);
    	setTitle("Business Card");
    	setLayout(new GridLayout(1,3));
  
    	
    	JLabel label1 = new JLabel("김덕성 br");
    	JLabel label2 = new JLabel("프로젝트 매니저 ");
    	JLabel label3 = new JLabel("덕성주식회사    ");
    	JLabel label4 = new JLabel("");
    	ImageIcon icon = new ImageIcon("C:\\캐로피.jpg");
    	label4.setIcon(icon);
    	
    	panel.add(label4);
    	panel.add(label1);
    	panel.add(label2);
    	panel.add(label3);
    	
    
      	setVisible(true);
    			
	}

    public static void main(String[] args) {
    	Card2 t = new Card2();

    }
}



