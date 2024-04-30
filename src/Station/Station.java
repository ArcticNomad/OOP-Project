public class Station {

  private String stationName;
  private String location;
  private List<Facility> facilities;

  public Station(String stationName, String location) {
    this.stationName = stationName;
    this.location = location;
    this.facilities = new ArrayList<Facility>();
  }

  public void addFacility(Facility facility) {
    facilities.add(facility);
  }

  public void removeFacility(Facility facility) {
    facilities.remove(facility);
  }

  public List<Facility> getFacilities() {
    return facilities;
  }

  public void displayStationDetails() {
    System.out.println("Station Name: " + stationName);
    System.out.println("Location: " + location);
    System.out.println("Facilities: ");
    for (Facility facility : facilities) {
      System.out.println(facility);
    }
  }
}
public class Facility {

  private String name;
  private String description;

  public Facility(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String toString() {
    return "  * " + name + ": " + description;
  }
}
