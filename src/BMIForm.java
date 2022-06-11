import javax.swing.*;
import java.awt.*;

public class BMIForm extends JFrame {
    private JPanel borderPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JSlider heightSlider;
    private JSlider weightSlider;
    private JRadioButton smallBtn;
    private JRadioButton mediumBtn;
    private JRadioButton largeBtn;
    private JComboBox genderBox;
    private JButton submitBtn;
    private JButton clearBtn;
    private JLabel weightLabel;
    private JLabel weightResult;
    private JLabel heightResult;
    private JLabel lastName;
    private JPanel westPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    private JLabel title;
    private JLabel instructions;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JLabel firstName;
    private JLabel idealWeightResult;
    private JLabel bodyFrameTitle;
    private JLabel bmiResult;
    private JLabel age;
    private JTextField ageField;

    public BMIForm() {
        setContentPane(borderPanel);
        setTitle("BMI ");
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        borderPanel.add(northPanel , BorderLayout.NORTH);
        borderPanel.add(southPanel , BorderLayout.SOUTH);
        borderPanel.add(eastPanel , BorderLayout.EAST);
        borderPanel.add(westPanel , BorderLayout.WEST);
        borderPanel.add(centerPanel , BorderLayout.CENTER);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(smallBtn);
        buttonGroup.add(mediumBtn);
        buttonGroup.add(largeBtn);

        submitBtn.addActionListener(e -> {
            double weight = weightSlider.getValue();
            double height = heightSlider.getValue();
            double heightInCm = (height / 100);
            double doubleHeight = heightInCm * heightInCm;
            double result = weight / doubleHeight;
            double roundedResult = Math.round(result * 1000) / 1000.0;
            if (roundedResult < 15) {
                bmiResult.setText("Your BMI result is: " + roundedResult + " Anorexic");
            }
            if (roundedResult > 15 && roundedResult <= 18.5) {
                bmiResult.setText("Your BMI result is: " + roundedResult + " Underweight");
            }
            if (roundedResult > 18.5 && roundedResult <= 24.9) {
                bmiResult.setText("Your BMI result is: " + roundedResult + " Normal");
            }
            if (roundedResult > 25 && roundedResult <= 29.9) {
                bmiResult.setText("Your BMI result is: " + roundedResult + " Overweight");
            }
            if (roundedResult > 30 && roundedResult <= 35) {
                bmiResult.setText("Your BMI is: " + roundedResult + " Obese");
            }
            if (roundedResult > 35) {
                bmiResult.setText("Your BMI is: " + roundedResult + " Extreme Obese");
            }

            if (smallBtn.isSelected()) {
                double slimness = 0.9;
                String age = ageField.getText();
                double doubleAge = Double.parseDouble(age);
                double idealWeight = ((height - 100 + (doubleAge/10))*(0.9*slimness));
                idealWeightResult.setText("Your ideal weight is: " + idealWeight);

            } else if (mediumBtn.isSelected()){
                double slimness = 1;
                String age = ageField.getText();
                double doubleAge = Double.parseDouble(age);
                double idealWeight = ((height - 100 + (doubleAge/10))*(0.9*slimness));
                idealWeightResult.setText("Your ideal weight is: " + idealWeight);

            } else if (largeBtn.isSelected()) {
                double slimness = 1.1;
                String age = ageField.getText();
                double doubleAge = Double.parseDouble(age);
                double idealWeight = ((height - 100 + (doubleAge/10))*(0.9*slimness));
                idealWeightResult.setText("Your ideal weight is: " + idealWeight);


            }
        });


        clearBtn.addActionListener(e -> {
            firstNameField.setText(null);
            lastNameField.setText(null);
            ageField.setText(null);
            weightSlider.setValue(40);
            heightSlider.setValue(140);
            genderBox.getModel().setSelectedItem("Select your gender");
            smallBtn.setSelected(false);
            mediumBtn.setSelected(false);
            largeBtn.setSelected(false);

            weightLabel.setText("Choose your weight: ");
            lastName.setText("Last name: ");
            title.setText("BMI Calculator , ");
            instructions.setText("Enter your details: ");
            firstName.setText("First name: ");
            bodyFrameTitle.setText("Choose your body frame: ");
            age.setText("Age:");
            bmiResult.setText("Your Bmi is: --- ");
            weightResult.setText("Your weight is: --- ");
            heightResult.setText("Your height is: --- ");
            idealWeightResult.setText("Choose your body frame: ");

        });

        weightSlider.addChangeListener(e -> weightResult.setText("your weight is : " + weightSlider.getValue() + "Kg"));


        heightSlider.addChangeListener(e -> heightResult.setText("your height is: " + heightSlider.getValue() + "Cm"));


    }

    public static void main (String[]args){
        BMIForm bmi = new BMIForm();
    }
}