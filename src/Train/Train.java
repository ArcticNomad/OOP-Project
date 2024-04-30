public class Train {

  private int trainNumber;
  private int capacity;
  private String currentStation;
  private Route schedule;

  public Train(int trainNumber, int capacity) {
    this.trainNumber = trainNumber;
    this.capacity = capacity;
    this.currentStation = "";
    this.schedule = null;
  }

  public void moveToNextStation() {
    if (schedule != null && currentStation != schedule.getFinalStation()) {
      currentStation = schedule.getNextStation(currentStation);
    }
  }

  public void displayTrainDetails() {
    System.out.println("Train Number: " + trainNumber);
    System.out.println("Capacity: " + capacity);
    System.out.println("Current Station: " + currentStation);
  }

  public void setSchedule(Route schedule) {
    this.schedule = schedule;
  }

  public String getCurrentStation() {
    return currentStation;
  }
}
