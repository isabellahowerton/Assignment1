/*Import statement for JOptionPane
 * dialog box.*/
import javax.swing.JOptionPane;

/* Class that receives user input for 
product information.*/
public class GetData {

  //Method receives user input as a double
  static double getDouble(String s) {
    return Double.parseDouble(getString(s));
  }

  //Method recieves user input as a string and converts it to an Int
  static int getInt(String s) {
    return Integer.parseInt(getString(s));
  }

  //Method that recieves user input as a String
  static String getString(String s) {
    return JOptionPane.showInputDialog(s);
  }
}
