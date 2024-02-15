import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cvic1 extends JFrame{
    private JPanel Tab;
    private JLabel Title;
    private JTextField FillBar;
    private JButton SubmitBut;

    public Cvic1(){
        initComponents();

        SubmitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FillBar.setText(FillBar.getText().toUpperCase());
            }
        });
    }

    private void initComponents()
    {
        setContentPane(Tab);
        setTitle("Velká písmena");
        setSize(600, 450);
        setMinimumSize(new Dimension(500,350));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cvic1();
    }
}
