import java.awt.*; // I import the GUI toolkit provided by Java for creating window-based applications.
import java.awt.event.*; // I also import the package that provides interfaces, classes, and adapter classes used to handle and respond to GUI.
import java.util.Arrays; // Imports the Arrays class. Useful for working with Arrays.
import javax.swing.*; // Java's GUI library. This allows me to make buttons, windows, etc.
import javax.swing.border.LineBorder; // Used to draw borders around the Swing components.

public class Calculator {
    int borderWidth = 360; // Set the width of the application - 360 pixels in this case.
    int borderHeight = 540; // Set the height of the application - 540 pixels.

    // The following 4 lines represent the colours I will use to customize my calculator.
    Color black = new Color(40,40,40);
    Color orange = new Color(255,183,0);
    Color grey = new Color(66,66,66 );
    Color darkGrey = new Color(33, 33, 33);

    // Create the grid for the buttons in arrays. (Ends on line 26 included)
    String[] buttonValues = { // Array of all the buttons.
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="}; //The buttons on the right side of the calculator.
    String[] topSymbols = {"AC", "+/-", "%"}; // The buttons on the top side of the calculator.

    JFrame frame = new JFrame("Calculator - by Michael Panica"); // Sets the title of the application.
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    // A+B, A-B, A*B, A/B
    String A = "0";
    String operator = null;
    String B = null;

    Calculator(){
        frame.setVisible(true); // Sets the visibility to True, so that the app can be seen.
        frame.setSize(borderWidth, borderHeight); // Sets the size of the app with the above defined sized in integers borderWidth & borderHeight;
        frame.setLocationRelativeTo(null); // Centers the window on the user's screen.
        frame.setResizable(false); // Sets the resizable to false, so that the user can't resize the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the application completely when the user clicks the window's close button.
        frame.setLayout(new BorderLayout()); // Sets the frame's layout manager to BorderLayout, allowing components to be placed in NORTH, SOUTH, EAST, WEST, or CENTER regions.

        displayLabel.setBackground(black); // Sets the background color of the displayLabel as black (value set on line 12)
        displayLabel.setForeground(Color.white); // Sets the text color in the displayLabel as white (value not previously defined, hence I use Color.white)
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80)); // Sets the font in the displayLabel as Arial with the size of 80 pixels.
        displayLabel.setHorizontalAlignment(JLabel.RIGHT); // Align the text in displayLabel to the right.
        displayLabel.setText("0"); // Sets a default text as 0.
        displayLabel.setOpaque(true); //Sets opacity as true.

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel); // Puts the displayLabel inside the displayPanel.
        frame.add(displayPanel, BorderLayout.NORTH); // Puts the Panel in the app window. Also moved the location of the panel to the NORTH, so that the text appears on top instead of center on Y axis.
        buttonsPanel.setLayout(new GridLayout(5, 4)); // Creates a Grid Layout inside the calculator with 5 rows and 4 columns.
        buttonsPanel.setBackground(darkGrey); //Sets the buttonsPanel background color to dark blue.
        frame.add(buttonsPanel); // Adds the buttonsPanel to the frame of the calculator.

        for (int i = 0; i < buttonValues.length; i++) { // Loop through every value in the buttonValues array.
            JButton button = createButton(i);
            buttonsPanel.add(button); // Add the configured button to the buttons panel.
        }
        frame.revalidate(); // Revalidates the frame to avoid missing buttons.
    }

    private JButton createButton(int i) {
        JButton button = new JButton(); // Create a new JButton object.
        String buttonValue = buttonValues[i]; // Get the current button value from the array.

        button.setFont(new Font("Arial", Font.PLAIN, 30)); // Set the button text font to Arial, plain style, size 30.
        button.setText(buttonValue); // Set the button's displayed text.
        button.setFocusable(false); // Disable the focus highlight that appears when the button is selected.
        button.setBorder(new LineBorder(black)); // Set the button border color to black.

        if (Arrays.asList(topSymbols).contains(buttonValue)) { // Check if the button belongs to the top row operators (e.g. C, ±, %).
            button.setBackground(darkGrey); // Set the button background to dark grey.
            button.setForeground(Color.WHITE); // Set the button text color to white.
        } else if (Arrays.asList(rightSymbols).contains(buttonValue)) { // Check if the button belongs to the right-side operators (e.g. ÷, ×, -, +, =).
            button.setBackground(orange); // Set the button background to orange.
            button.setForeground(Color.WHITE); // Set the button text color to white.
        } else { // If the button is a number or decimal point.
            button.setBackground(grey); // Set the button background to grey.
            button.setForeground(Color.WHITE); // Set the button text color to white.
        }
        buttonsPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                String buttonValue = button.getText();
                if(Arrays.asList(rightSymbols).contains(buttonValue)){

                } else if (Arrays.asList(topSymbols).contains(buttonValue)){
                    if (buttonValue == "AC"){
                        clearAll();
                        displayLabel.setText("0");
                    } else if (buttonValue == "+/-"){
                        double numDisplay = Double.parseDouble(displayLabel.getText());
                        numDisplay *= -1;
                        displayLabel.setText(Double.toString(numDisplay));
                    } else if (buttonValue == "="){

                    }
                } else {
                    if (buttonValue == "."){
                        if(!displayLabel.getText().contains(buttonValue)){
                            displayLabel.setText(displayLabel.getText() + buttonValue);
                        }
                    } else if ("0123456789".contains(buttonValue)){
                        if (displayLabel.getText() == "0"){
                            displayLabel.setText(buttonValue);
                        } else {
                            displayLabel.setText(displayLabel.getText() + buttonValue);
                        }
                    }
                }
            }
        }); return button;
    }
    void clearAll(){
        A = "0";
        operator = null;
        B = null;
    }
}
