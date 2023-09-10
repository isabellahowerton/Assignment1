// Alejandro Cancio and Isabella Howerton Assignment 1

/* import statements for date format, ArrayLists,
 * and JOptionPane windows.*/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Assignment1 {

  public static void main(String[] args) throws Exception {
    /*Creates ArrayList for manufacturers */
    ArrayList<Manufacturer> manufacturerList = new ArrayList<>();
    /*Creates new instances of the database class for
     * inventory and deleted products.*/
    Database inventory = new Database();
    Database deleted = new Database();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    Date purchaseDate = new Date();
    boolean exit = false;

    //while loop creates start menu
    while (!exit) {
      int startmenu = GetData.getInt(
        "Inventory Program\n" +
        "Select what you want to do" +
        "\n1. Add Product" +
        "\n2. Remove Product" +
        "\n3. Inventory Report" +
        "\n4. Deleted Products" +
        "\n5. Modify Product" +
        "\n6. Add Manufacturer" +
        "\n7. Exit"
      );
      switch (startmenu) {
        case 1:
          //add product
          String n = GetData.getString("Enter Product Name");
          int q = GetData.getInt("Enter Product Quantity");
          double p = GetData.getDouble("Enter Product Price");

          //Product Manufacturer
          String mn = GetData.getString("Enter Product Manufacturer Name");
          String ma = GetData.getString("Enter Product Manufacturer State");
          Manufacturer m = new Manufacturer(mn, ma);
          String formattedDate = dateFormat.format(purchaseDate);

          //Add product to inventory
          Product pr = new Product(n, p, q, m, ma, formattedDate);
          inventory.addProduct(pr);

          String addedProduct =
            "Product: " +
            n +
            "\n" +
            "Purchase date: " +
            formattedDate +
            "\n" +
            "Quantity: " +
            q +
            "\n" +
            "Price: $" +
            p +
            "\n" +
            "Manufacturer: " +
            mn +
            "\n" +
            "State: " +
            ma;

          JOptionPane.showMessageDialog(
            null,
            addedProduct,
            "Product Information",
            JOptionPane.INFORMATION_MESSAGE
          );

          break;
        case 2:
          // remove product
          n = GetData.getString("Enter Product Name");
          inventory.findp(n);
          Product removedProduct = null;

          if (!inventory.inInventory()) {
            JOptionPane.showMessageDialog(null, "Product Does not Exist");
          } else {
            int index = inventory.getIndex();
            inventory.addProduct(inventory.removeProduct(index));
            removedProduct = inventory.removeProduct(inventory.getIndex());
            deleted.addDeletedProducts(removedProduct);
            JOptionPane.showMessageDialog(null, "The product has been deleted");
          }
          break;
        case 3:
          //inventory report
          int option = GetData.getInt(
            "1. View a Single Product" + "\n 2. View Whole Report"
          );

          switch (option) {
            case 1:
              //Viewing a Single product
              n = GetData.getString("Enter Product Name");
              inventory.findp(n);
              if (!inventory.inInventory()) JOptionPane.showMessageDialog(
                null,
                "Product not found"
              ); else {
                Product pp = inventory.getProduct();
                Object[][] inventoryReport = new Object[1][6];
                inventoryReport[0][0] = pp.getName();
                inventoryReport[0][1] = pp.getPurchaseDate();
                inventoryReport[0][2] = pp.getQuantity();
                inventoryReport[0][3] = pp.getPrice();
                inventoryReport[0][4] = pp.getPManufactureName();
                inventoryReport[0][5] = pp.getStates().toString();

                String[] headers = {
                  "Product",
                  "Purchase Date",
                  "Quantity",
                  "Price",
                  "Manufacturer",
                  "State",
                };
                JTable table = new JTable(inventoryReport, headers);

                JOptionPane.showMessageDialog(
                  null,
                  new JScrollPane(table),
                  "Product Information",
                  JOptionPane.INFORMATION_MESSAGE
                );
              }
              break;
            case 2:
              //Viewing Report
              ArrayList<Product> list = inventory.getReport();
              if (list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "There are no products");
              } else {
                Object[][] inventoryReport = new Object[list.size()][6];

                for (int i = 0; i < list.size(); i++) {
                  Product wholeReport = list.get(i);
                  inventoryReport[i][0] = wholeReport.getName();
                  inventoryReport[i][1] = wholeReport.getPurchaseDate();
                  inventoryReport[i][2] = wholeReport.getQuantity();
                  inventoryReport[i][3] = wholeReport.getPrice();
                  inventoryReport[i][4] = wholeReport.getPManufactureName();
                  inventoryReport[i][5] = wholeReport.getStates().toString();
                }
                String[] headers = {
                  "Product",
                  "Purchase Date",
                  "Quantity",
                  "Price",
                  "Manufacturer",
                  "State",
                };

                JTable table = new JTable(inventoryReport, headers);

                JOptionPane.showMessageDialog(
                  null,
                  new JScrollPane(table),
                  "Inventory Report",
                  JOptionPane.INFORMATION_MESSAGE
                );
              }

              break;
            default:
              JOptionPane.showMessageDialog(null, "Invalid Selection");
              break;
          }

          break;
        case 4:
          //deleted product
          ArrayList<Product> deleteProducts = deleted.getDeletedProducts();
          if (deleteProducts.isEmpty()) {
            JOptionPane.showMessageDialog(
              null,
              "There are no products that have been deleted."
            );
          } else {
            Object[][] deletedReport = new Object[deleteProducts.size()][3];

            for (int i = 0; i < deleteProducts.size(); i++) {
              Product d = deleteProducts.get(i);
              deletedReport[i][0] = d.getName();
              deletedReport[i][1] = d.getPurchaseDate();
              deletedReport[i][2] = d.getPManufactureName();
            }
            String[] headers = { "Product", "Date", "Manufacturer" };
            JTable table = new JTable(deletedReport, headers);

            JOptionPane.showMessageDialog(
              null,
              new JScrollPane(table),
              "Deleted Products",
              JOptionPane.INFORMATION_MESSAGE
            );
          }
          break;
        case 5:
          //modify product(s)
          inventory.findp(
            GetData.getString(
              "Enter the name of the product you would like to modify:"
            )
          );
          if (!inventory.inInventory()) {
            JOptionPane.showMessageDialog(null, "Unable to find product.");
          } else {
            Product modifiedProduct = inventory.getProduct();
            int modifiedIndex = inventory.getIndex();
            double newPrice = GetData.getDouble(
              "Enter the new price of the product:"
            );
            int newQuantity = GetData.getInt(
              "Enter the quantity of the new product:"
            );
            modifiedProduct.changePrice(newPrice);
            modifiedProduct.addQuantity(newQuantity);
            inventory.setProduct(modifiedIndex, modifiedProduct);
            JOptionPane.showMessageDialog(
              null,
              "Product was successfully modified."
            );
          }
          break;
        // add manufacturer(s)
        case 6:
          String manufacturerName = JOptionPane.showInputDialog(
            null,
            "Enter manufacturer name:"
          );
          String manufacturerAddress = JOptionPane.showInputDialog(
            null,
            "Enter manufacturer address:"
          );
          Manufacturer manufacturer = new Manufacturer(
            manufacturerName,
            manufacturerAddress
          );
          manufacturerList.add(manufacturer);
          JOptionPane.showMessageDialog(
            null,
            "Manufacturer added successfully." +
            "\n Manufacturer name: " +
            manufacturer.getManufacturerName() +
            "\n Manufacturer address: " +
            manufacturer.getManufacturerAddress()
          );
          JOptionPane.showMessageDialog(
            null,
            "Manufacturer was successfully added."
          );
          break;
        case 7:
          // exit menu option
          exit = true;
          break;
        default:
          JOptionPane.showMessageDialog(
            null,
            "Invalid selection. Please try again. "
          );
      }
    }
  }

  /*method to display scrollable JOptionPane window(s). */
  static void scrollPane(String s, String title, int o) {
    JTextArea output = new JTextArea(s, 100, 100);
    JScrollPane pane = new JScrollPane(
      output,
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    JOptionPane.showMessageDialog(null, pane);
  }
}
