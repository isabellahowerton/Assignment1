import java.util.ArrayList;

public class Manufacturer {

  private String name;
  private String address;

  //   public ArrayList<String> manufacturerList = new ArrayList<String>();
  //   public ArrayList<String> manufacturerAddress = new ArrayList<String>();

  public Manufacturer(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public void setManufacturerName(String name) {
    this.name = name;
  }

  public void setManufacturerAddress(String address) {
    this.address = address;
  }

  public String getManufacturerName() {
    return name;
  }

  public String getManufacturerAddress() {
    return address;
  }
}
