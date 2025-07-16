package Misc.AbstractionExample;

public class Main {
    public static void main(String args[]) {
        Car obj = new Honda(); // Car object =>contents of Honda

        System.out.println("Fuel Type is: " + obj.fuelType);
        System.out.println("No. of gears are: " + obj.getNoOfGears());
        System.out.println("No. of max gears:" + Car.getMaxGears());
        obj.setNoOfGears(Car.getMaxGears());
        System.out.println("New No. of max gears:" + Car.getMaxGears());
        System.out.println("Max occupancy:" + Car.MAX_PASSENGERS);

        obj.start();
        obj.stop(); // call the method


    }
}