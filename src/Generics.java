/*TODO: Create a program that has 2 classes: Car and Truck.
    Give them both a field int numberOfWheels and write a getter method for that.
    Now in your program, try to create a collection (can be List, a Set, anything) that holds an object of both classes.
 */

import java.util.ArrayList;
import java.util.List;

class Car {
    private int numberOfWheels;

    public Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}

class Truck {
    private int numberOfWheels;

    public Truck(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}

public class Generics {
    public static void main(String[] args){
        List<Object> vehicleList = new ArrayList<>();
        Car car = new Car(4);
        Truck truck = new Truck(6);

        vehicleList.add(car);
        vehicleList.add(truck);

        for(Object vehicle : vehicleList ){
            if(vehicle instanceof Car){
                System.out.println("Number of wheels for car: " + car.getNumberOfWheels());
            }
            if(vehicle instanceof Truck){
                System.out.println("Number of wheels for truck: " + truck.getNumberOfWheels());
            }
        }
    }
}

/*In the main method, a List called vehicleList is created,
and objects of both Car and Truck classes are added to it using the add method.

To retrieve objects from the list, we use a for-each loop and check if each object is an instance of Car or Truck
using the instanceof operator.

 */


