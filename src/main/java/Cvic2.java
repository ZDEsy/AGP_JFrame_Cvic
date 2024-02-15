import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cvic2 extends JFrame{
    private JPanel Tab;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JTextField InputField;
    private JComboBox List;
    private JButton SubmitBut;
    private JLabel sumArea;

    public Cvic2()
    {
        initComponents();


        SubmitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] strArray = InputField.getText().split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++) {
                    intArray[i] = Integer.parseInt(strArray[i]);
                }

                System.out.println(Sum(intArray));
                sumArea.setText(Sum(intArray));
            }
        });
    }

    public String Sum(int[] intArray)
    {
        int result = 0;
        for(int i = 0; i < intArray.length; i++)
        {
            result += intArray[i];
        }
        return Integer.toString(result);
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
        new Cvic2();
    }
}
