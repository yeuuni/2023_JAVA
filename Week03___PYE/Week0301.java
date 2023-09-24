import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Week0301 extends JFrame {
	
	public Week0301()
	{
		setTitle("login window");
		setSize(300,250);
		
		JPanel panel = new JPanel();
        add(panel);
        
        panel.add(new JLabel("이름:"));
        panel.add(new JTextField(25));
        panel.add(new JLabel("패스워드:"));
        panel.add(new JPasswordField(20));
        panel.add(new JLabel("이메일 주소:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("전화번호"));
        panel.add(new JTextField(20));
        
        JButton 등록하기 = new JButton("등록하기");
        panel.add(등록하기);
        
        JButton 취소 = new JButton("취소");
        panel.add(취소);
        
        setVisible(true);
	}
	public static void main(String[] args) {
		Week0301 t = new Week0301();
	}
}
	