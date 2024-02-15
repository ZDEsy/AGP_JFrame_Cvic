import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cvic3 extends JFrame {
    private JPanel Tab;
    private JComboBox numRange;
    private JButton startGameBut;
    private JTextField userTip;
    private JButton tipBut;
    private JLabel tipName;
    private JLabel fromZero;
    private JLabel messageLabel;

    public int guessNum;
    public int tries = 1;
    public ArrayList<String> stringList = new ArrayList<String>();


    public Cvic3()
    {
        initComponents();

        startGameBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Myslím si číslo, hádej!");
                guessNum = RandomNum();
            }
        });
        tipBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringList.add(userTip.getText());
                if(!CompareNum(guessNum))
                {
                    boolean compareTipGuess = guessNum > Integer.parseInt(userTip.getText());
                    messageLabel.setText("Špatný odhad, " + (compareTipGuess ? "zkus větší číslo." : "zkus menší číslo."));
                    tries++;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Vyhrál jsi! Číslo " + guessNum + " jsi uhodl na " + tries + ". pokus, Tvé tipy: " + NumTries(stringList));
                    tries = 1;
                    stringList.clear();
                }
            }
        });
    }

    public int RandomNum()
    {
        int min = 0;
        int max = switch (numRange.getSelectedIndex()) {
            case 1 -> 50;
            case 2 -> 100;
            case 3 -> 1000;
            default -> 10;
        };
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public boolean CompareNum(int guessNum)
    {
        return guessNum == Integer.parseInt(userTip.getText());
    }

    public String NumTries(ArrayList<String> stringArray)
    {
        return stringArray.toString();
    }

    private void initComponents()
    {
        setContentPane(Tab);
        setTitle("Odhad čísla");
        setSize(600, 450);
        setMinimumSize(new Dimension(500,350));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cvic3();
    }
}
