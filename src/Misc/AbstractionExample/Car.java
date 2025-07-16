package Misc.AbstractionExample;

// Abstract class

public abstract class Car {

    private static final int MAX_GEARS = 6;
    static final int MAX_PASSENGERS = 4;

    private int noOfGears;
    public String fuelType;

    Car() {
        noOfGears = 5;
        fuelType = "GAS";
    }

    abstract void stop();

    void start() {
        System.out.println("Car has been started.");
    }

    int getNoOfGears() {
        return noOfGears;
    }

    void setNoOfGears(int n) {
        this.noOfGears = n;
    }

    static int getMaxGears() {
        return MAX_GEARS;
    }


}