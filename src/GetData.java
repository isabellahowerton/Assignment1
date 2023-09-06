import javax.swing.JOptionPane;

// import javax.swing.JScrollPane;
// import javax.swing.JTextArea;

public class GetData {

  static double getDouble(String s) {
    return Double.parseDouble(getString(s));
  }

  static int getInt(String s) {
    return Integer.parseInt(getString(s));
  }

  static String getString(String s) {
    return JOptionPane.showInputDialog(s);
  }
}
