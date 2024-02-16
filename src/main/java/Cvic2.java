import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Cvic2 extends JFrame{
    private JPanel Tab;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField inputField;
    private JComboBox list;
    private JButton submitBut;
    private JLabel sumArea;
    private JLabel lowestNum;
    private JLabel biggestNum;
    private JLabel averageNum;
    private JLabel sortedNum;


    public Cvic2()
    {
        initComponents();


        submitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] strArray = inputField.getText().split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++) {
                    intArray[i] = Integer.parseInt(strArray[i]);
                }
                sumArea.setText(Sum(intArray));
                lowestNum.setText(Lowest(intArray));
                biggestNum.setText(Biggest(intArray));
                averageNum.setText(Average(intArray));
                sortedNum.setText(Arrays.toString(Sort(intArray)).replaceAll("[^0-9\\s+]",",").substring(1,Arrays.toString(Sort(intArray)).length()-1));
            }
        });
    }

    public String Sum(int[] intArray)
    {
        int result = 0;
        for (int j : intArray) {
            result += j;
        }
        return Integer.toString(result);
    }

    public String Lowest(int[] intArray)
    {
        int result = intArray[0];
        for (int j : intArray) {
            if (j < result) result = j;
        }
        return Integer.toString(result);
    }

    public String Biggest(int[] intArray)
    {
        int result = intArray[0];
        for (int j : intArray) {
            if (j > result) result = j;
        }
        return Integer.toString(result);
    }

    public String Average(int[] intArray)
    {
        double sum = Double.parseDouble(Sum(intArray));
        return Double.toString(sum / intArray.length);
    }

    public int[] Sort(int[] intArray)
    {
        if(list.getSelectedIndex() == 0)
        {
            for(int i = 0; i < intArray.length; i++)
            {
                for(int j = i; j < intArray.length; j++)
                {
                    if(intArray[i] < intArray[j])
                    {
                        int temp = intArray[i];
                        intArray[i] = intArray[j];
                        intArray[j] = temp;
                    }
                }
            }
        }
        else
        {
            for(int i = 0; i < intArray.length; i++)
            {
                for(int j = i; j < intArray.length; j++)
                {
                    if(intArray[i] > intArray[j])
                    {
                        int temp = intArray[i];
                        intArray[i] = intArray[j];
                        intArray[j] = temp;
                    }
                }
            }
        }
        return intArray;
    }

    private void initComponents()
    {
        setContentPane(Tab);
        setTitle("Matematické operace");
        setSize(600, 450);
        setMinimumSize(new Dimension(500,350));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cvic2();
    }
}
