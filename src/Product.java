/* Class for creating products and 
defines what a products is made of*/

public class Product {

  /*Initializs name, price, quantiy, manufacturer,
 and purchase date for product*/

  private String name;
  private double price;
  private int quantity;
  private Manufacturer manu;
  private String states;
  private String purchaseDates;

  //Constructor
  public Product(
    String name,
    double price,
    int quantity,
    Manufacturer m,
    String states,
    String purchaseDates
  ) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.manu = m;
    this.states = states;
    this.purchaseDates = purchaseDates;
  }

  //Get product Name
  public String getName() {
    return name;
  }

  //Get product Price
  public double getPrice() {
    return price;
  }

  //Get product Quantity
  public int getQuantity() {
    return quantity;
  }

  // modify Product Price
  public void changePrice(double newprice) {
    price = newprice;
  }

  // Increase product stock
  public void addQuantity(int a) {
    quantity = a;
  }

  // Decrease product stock
  public void subQuantity(int s) {
    quantity = s;
  }

  //Get product manufacturer name
  public String getPManufactureName() {
    return manu.getManufacturerName();
  }

  //get product manufacurer address
  public String getPManufactureAddress() {
    return manu.getManufacturerAddress();
  }

  //get date product was purchased
  public String getPurchaseDate() {
    return purchaseDates;
  }

  // Get prodcut manufacture's State
  public String getStates() {
    return states;
  }
}
