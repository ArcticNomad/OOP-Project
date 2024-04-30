public class Route {

  private String[] stations;

  public Route(String[] stations) {
    this.stations = stations;
  }

  public String getNextStation(String currentStation) {
    for (int i = 0; i < stations.length - 1; i++) {
      if (stations[i].equals(currentStation)) {
        return stations[i + 1];
      }
    }
    return null;
  }

  public String getFinalStation() {
    return stations[stations.length - 1];
  }
}
