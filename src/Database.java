import java.util.ArrayList;

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

  public void addProduct(Product p) {
    report.add(p);
  }

  public Product removeProduct(int index) {
    Product removeProduct = report.remove(index);
    deletedProducts.add(removeProduct);
    return removeProduct;
  }

  public Product getProduct() {
    return pr;
  }

  public boolean inInventory() {
    return exist;
  }

  public int getIndex() {
    return index;
  }

  public ArrayList<Product> getReport() {
    return report;
  }

  public boolean empty() {
    return report.isEmpty();
  }

  public int size() {
    return report.size();
  }

  public void setProduct(int index, Product p) {
    report.set(index, p);
  }

  public void addDeletedProducts(Product p) {
    deletedProducts.add(p);
  }

  public ArrayList<Product> getDeletedProducts() {
    return deletedProducts;
  }
}
