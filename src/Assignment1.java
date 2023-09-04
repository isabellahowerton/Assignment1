import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Assignment1 {

  public static void main(String[] args) throws Exception {
    ArrayList<Manufacturer> manufacturerList = new ArrayList<>();

    // Manufacturer addManufacturer = new Manufacturer(null, null);
    // manufacturerList.add(addManufacturer);
    Database inventory = new Database();
    Database deleted = new Database();
    boolean exit = false;

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
          String ma = GetData.getString("Enter Product Manufacturer address");
          Manufacturer m = new Manufacturer(mn, ma);

          //Add product to inventory
          Product i = new Product(n, p, q, m);
          inventory.addProduct(i);

          break;
        case 2:
          // remove product
          n = GetData.getString("Enter Product Name");
          inventory.findp(n);
          Product removedProduct = null;

          if (!inventory.inInventory()) {
            JOptionPane.showMessageDialog(null, "Product Does not Exist");
          } else {
            Product d = inventory.getProduct();
            int index = inventory.getIndex();
            //inventory.addProduct(inventory.removeProduct(index));
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
          ArrayList inStock = inventory.getReport();

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
                String pr =
                  "Product\t Price\t Quantity\n" +
                  pp.getName() +
                  "\t" +
                  pp.getPrice() +
                  "\t" +
                  pp.getQuantity();
                JOptionPane.showMessageDialog(null, pr);
              }
              break;
            case 2:
              //Viewing Report
              if (inStock.isEmpty()) {
                JOptionPane.showMessageDialog(null, "There are no products");
              } else {
                String info = "";
                int index = 0;
                int size = inventory.size();

                while (index < size) {
                  Product p1 = (Product) inStock.get(index);

                  info =
                    p1.getName() +
                    p1.getQuantity() +
                    p1.getPrice() +
                    p1.getPManufactureName();
                  p1.getPManufactureAddress();
                  index++;
                }

                scrollPane(
                  info,
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
            StringBuilder ListofDeletedProducts = new StringBuilder(
              "Deleted products: "
            );
            for (Product deletedProduct : deleteProducts) {
              ListofDeletedProducts
                .append("\nDeleted product name: ")
                .append(deletedProduct.getName());
            }
            JOptionPane.showMessageDialog(null, ListofDeletedProducts);
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
          // exit = true;
          break;
        case 7:
          // exit
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

  static void scrollPane(String s, String title, int o) {
    JTextArea output = new JTextArea(s, 100, 10);
    JScrollPane pane = new JScrollPane(output);
    JOptionPane.showMessageDialog(null, pane);
  }
}
