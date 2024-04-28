public class Train
{
    private int trainNUmber;
    private int trainSpeed;
    private int capacity;
    Station currentStation;

    //Schedule trainSchedule;

    public Train(int trainNUmber, int trainSpeed, int capacity)
    {
        setCapacity(capacity);
        setTrainSpeed(trainSpeed);
        setTrainNUmber(trainNUmber);
    }

    public void moveTrainToNextStation()
    {}
    public void displayTrainDetails()
    {}

    public int getTrainNUmber() {
        return trainNUmber;
    }

    public void setTrainNUmber(int trainNUmber) {
        this.trainNUmber = trainNUmber;
    }

    public int getTrainSpeed() {
        return trainSpeed;
    }

    public void setTrainSpeed(int trainSpeed) {
        this.trainSpeed = trainSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }
}
