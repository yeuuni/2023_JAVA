import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Grid extends JFrame	{
	public Grid()	{
		super("격자 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(150,160);
		setVisible(true);
	}
	class MyPanel extends JPanel	{
		public void paintCompoment(Graphics g)	{
			super.paintComponent(g);
			int dw = getWidth()/10;
			for(int i = 1; i<=9; i++)
				g.drawLine(i*dw,  0,  i*dw,  getHeight());
			int dh = getHeight()/10;
			for(int i = 1; i<=9; i++)
				g.drawLine(0,i*dh,getWidth(), i*dh);
			
				
		}
	}

	public static void main(String[] args) {
		new Grid();
	}

}
