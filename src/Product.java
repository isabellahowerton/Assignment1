public class Product {

  private String name;
  private double price;
  private int quantity;
  private Manufacturer manu;

  //private String manufacturer;

  //Constructor
  public Product(String name, double price, int quantity, Manufacturer m) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.manu = m;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void changePrice(double newprice) {
    price += newprice;
  }

  public void addQuantity(int a) {
    quantity += a;
  }

  public void subQuantity(int s) {
    quantity -= s;
  }

  public String getPManufactureName() {
    return manu.getManufacturerName();
  }

  public String getPManufactureAddress() {
    return manu.getManufacturerAddress();
  }
}
