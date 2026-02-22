import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {
    JTextField nameField;
    JRadioButton male, female;
    JCheckBox apple, samsung, redmi, oneplus;
    JComboBox<String> colorBox;
    JButton saveBtn;

    public StudentRegistration() {
        setTitle("Register");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);

        JLabel genderLabel = new JLabel("Gender:");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(male);
        genderPanel.add(female);

        JLabel modelLabel = new JLabel("Model:");
        apple = new JCheckBox("Apple");
        samsung = new JCheckBox("Samsung");
        redmi = new JCheckBox("Redmi");
        oneplus = new JCheckBox("OnePlus");

        JPanel modelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modelPanel.add(apple);
        modelPanel.add(samsung);
        modelPanel.add(redmi);
        modelPanel.add(oneplus);

        JLabel colorLabel = new JLabel("Color:");
        String[] colors = {"Black", "White", "Blue", "Red", "Green"};
        colorBox = new JComboBox<>(colors);

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(genderLabel);
        add(genderPanel);
        add(modelLabel);
        add(modelPanel);
        add(colorLabel);
        add(colorBox);
        add(new JLabel());
        add(saveBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not Selected");

        StringBuilder models = new StringBuilder();
        if (apple.isSelected()) models.append("Apple, ");
        if (samsung.isSelected()) models.append("Samsung, ");
        if (redmi.isSelected()) models.append("Redmi, ");
        if (oneplus.isSelected()) models.append("OnePlus, ");
        if (models.length() > 0) models.setLength(models.length() - 2);

        String color = (String) colorBox.getSelectedItem();

        new DisplayFrame(name, gender, models.toString(), color);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}

class DisplayFrame extends JFrame {
    public DisplayFrame(String name, String gender, String models, String color) {
        setTitle("Display");
        setSize(300, 200);
        setLayout(new GridLayout(5, 1));
        setLocationRelativeTo(null);

        add(new JLabel("Name: " + name));
        add(new JLabel("Gender: " + gender));
        add(new JLabel("Model: " + models));
        add(new JLabel("Color: " + color));

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(e -> dispose());
        add(okBtn);

        setVisible(true);
    }
}
