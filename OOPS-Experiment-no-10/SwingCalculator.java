import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator extends JFrame implements ActionListener {

    JTextField num1Field, num2Field;
    JButton addBtn, subBtn, mulBtn, divBtn;

    public SwingCalculator() {
        setTitle("Swing Application");
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Number 1");
        num1Field = new JTextField(10);
        JLabel label2 = new JLabel("Number 2");
        num2Field = new JTextField(10);

        addBtn = new JButton("ADD");
        subBtn = new JButton("SUBTRACT");
        mulBtn = new JButton("MULTIPLY");
        divBtn = new JButton("DIVIDE");

        add(label1);
        add(num1Field);
        add(label2);
        add(num2Field);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        setSize(400, 250);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            String operation = "";

            if (e.getSource() == addBtn) {
                result = num1 + num2;
                operation = "Addition";
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
                operation = "Subtraction";
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
                operation = "Multiplication";
            } else if (e.getSource() == divBtn) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Division by zero is not allowed!");
                    return;
                }
                result = num1 / num2;
                operation = "Division";
            }

            JOptionPane.showMessageDialog(this, operation + ": " + result, "Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}
