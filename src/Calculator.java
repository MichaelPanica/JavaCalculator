import java.awt.*; // I import the GUI toolkit provided by Java for creating window-based applications.
import java.awt.event.*; // I also import the package that provides interfaces, classes, and adapter classes used to handle and respond to GUI.
import java.util.Arrays; // Imports the Arrays class. Useful for working with Arrays.
import javax.swing.*; // Java's GUI library. This allows me to make buttons, windows, etc.
import javax.swing.border.LineBorder; // Used to draw borders around the Swing components.

public class Calculator {
    int borderWidth = 360; // Set the width of the application - 360 pixels in this case.
    int borderHeight = 540; // Set the height of the application - 540 pixels.

    // The following 4 lines represent the colours I will use to customize my calculator.
    Color black = new Color(0,0,0);
    Color blue = new Color(32,91,122);
    Color darkBlue = new Color(20,47,68);
    Color lightBlue = new Color(162,187,207);

    JFrame frame = new JFrame("Calculator - by Michael Panica"); // Sets the title of the application.

    Calculator(){
        frame.setVisible(true); // Sets the visibility to True, so that the app can be seen.
        frame.setSize(borderWidth, borderHeight); // Sets the size of the app with the above defined sized in integers borderWidth & borderHeight;
        frame.setLocationRelativeTo(null); // Centers the window on the user's screen.
        frame.setResizable(false); // Sets the resizable to false, so that the user can't resize the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the application completely when the user clicks the window's close button.
        frame.setLayout(new BorderLayout()); // Sets the frame's layout manager to BorderLayout, allowing components to be placed in NORTH, SOUTH, EAST, WEST, or CENTER regions.
    }
}
