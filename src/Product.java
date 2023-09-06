import java.time.LocalDate;

public class Product {

  private String name;
  private double price;
  private int quantity;
  private Manufacturer manu;
  private String states;
  private LocalDate purchaseDates;

  // private /*ArrayList<*/LocalDate purchaseDates;

  //private String manufacturer;

  //Constructor
  public Product(
    String name,
    double price,
    int quantity,
    Manufacturer m,
    String states,
    LocalDate purchaseDates
  ) { // /* ArrayList<*/LocalDate purchaseDates
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.manu = m;
    this.states = states;
    this.purchaseDates = purchaseDates;
    // this.purchaseDates = purchaseDates;
    /*this.purchaseDates = new ArrayList<>(purchaseDates);
    this.purchaseDates.addAll(purchaseDates);*/
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
    price = newprice;
  }

  public void addQuantity(int a) {
    quantity = a;
  }

  public void subQuantity(int s) {
    quantity = s;
  }

  public String getPManufactureName() {
    return manu.getManufacturerName();
  }

  public String getPManufactureAddress() {
    return manu.getManufacturerAddress();
  }

  public /*ArrayList<*/LocalDate getPurchaseDate() {
    return purchaseDates;
  }

  public String getStates() {
    return states;
  }
}
