/*Class for setting and getting manufacturer
 * name and address.*/
public class Manufacturer {

  /*Initializes name and address variables
   * for manufactuer(s).*/
  private String name;
  private String address;

  //Constructor.
  public Manufacturer(String name, String address) {
    this.name = name;
    this.address = address;
  }

  //Method to set manufacturer name.
  public void setManufacturerName(String name) {
    this.name = name;
  }

  // Method to set manufacturer address.
  public void setManufacturerAddress(String address) {
    this.address = address;
  }

  // Method to retrieve manufacturer name.
  public String getManufacturerName() {
    return name;
  }

  // Method to retrieve manufacturer address.
  public String getManufacturerAddress() {
    return address;
  }
}
