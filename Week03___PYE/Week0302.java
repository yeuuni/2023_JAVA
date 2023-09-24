import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Week0302 extends JFrame {

    private JTextField mileTextField;
    private JLabel resultLabel;

    public Week0302() {
        setTitle("Mile->Km");
        setSize(400, 150);

        JPanel panel = new JPanel();
        add(panel);

        panel.add(new JLabel("마일을 입력하세요"));
        mileTextField = new JTextField(10);
        panel.add(mileTextField);

        JButton 변환 = new JButton("변환");
        panel.add(변환);

        resultLabel = new JLabel("결과: ");
        panel.add(resultLabel);

        변환.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertMilesToKilometers();
            }
        });

        setVisible(true);
    }

    private void convertMilesToKilometers() {
        try {
            double miles = Double.parseDouble(mileTextField.getText());
            double kilometers = miles * 1.60934;
            resultLabel.setText("결과: " + String.format("%.2f 킬로미터", kilometers));
        } catch (NumberFormatException ex) {
            resultLabel.setText("결과: 유효한 숫자를 입력하세요.");
        }
    }

    public static void main(String[] args) {
        Week0302 t = new Week0302();
    }
}