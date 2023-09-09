/*Import statement for JOptionPane
 * dialog box.*/
import java.util.ArrayList;

/*Class that stores product reports, deleted products, updates the inventory 
report, and checks to see if the product is in the inventory. */
public class Database {

  private ArrayList<Product> report;
  private ArrayList<Product> deletedProducts;
  private Product pr;
  private int index;
  private boolean exist;

  public Database() {
    report = new ArrayList<Product>();
    deletedProducts = new ArrayList<Product>();
  }

  //Method for searching the database array
  void findp(String name) {
    exist = false;
    int i = 0;

    while (!exist && i < report.size()) {
      Product p = report.get(i);

      if (p.getName().equalsIgnoreCase(name)) {
        pr = p;
        exist = true;
        index = i;
      } else {
        i++;
      }
    }
  }

  //Adding a product to the database
  public void addProduct(Product p) {
    report.add(p);
  }

  //Removing a product from the database
  public Product removeProduct(int index) {
    Product removeProduct = report.remove(index);
    deletedProducts.add(removeProduct);
    return removeProduct;
  }

  //Retrieve product information from databse
  public Product getProduct() {
    return pr;
  }

  //Finds a product and determines if it exist
  public boolean inInventory() {
    return exist;
  }

  //Gets index for product
  public int getIndex() {
    return index;
  }

  //Retrieve inventory report from database
  public ArrayList<Product> getReport() {
    return report;
  }

  //determines if array list is empty
  public boolean empty() {
    return report.isEmpty();
  }

  //returns the szie of the array list
  public int size() {
    return report.size();
  }

  // Used to change the value of the quantity and price of a product
  public void setProduct(int index, Product p) {
    report.set(index, p);
  }

  //Add products that have been deleted to the deleted products database
  public void addDeletedProducts(Product p) {
    deletedProducts.add(p);
  }

  //retrieves products that have beein deleted from the inventory database
  public ArrayList<Product> getDeletedProducts() {
    return deletedProducts;
  }
}
