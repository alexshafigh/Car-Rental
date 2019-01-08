package com;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class CarRental { //This is Singleton Class
    private static CarRental carRental;
    private static List<Car> cars ;
    private static int fail_times = 0;
    private static int initial_capacity = 3;

    private CarRental() {
        cars = new ArrayList<>(initial_capacity);
        for (int counter = 0 ; counter<initial_capacity ; counter++)
        {
            Car car = new Car();
            cars.add(car);
        }
    }

    public static CarRental getInstance(){
        if (carRental == null) return new CarRental();
        else return carRental;
    }

    public static void report(){
        System.out.printf(" Number Of cars In Repository is %d and Those Are :\n", cars.size());
        if (cars.isEmpty()) System.out.println("  ============== And You Must WAIT ======================");
        for (Car car:cars)
            System.out.println(car.toString());
    }

    public Car borrow(){
//        if (cars.isEmpty()) {
//            Car car = new Car();
//            cars.add(car);
//        }

        if (fail_times >= initial_capacity)
        {
            for (int counter = 0 ; counter<initial_capacity ; counter++)
            {
                Car car = new Car();
                cars.add(car);
                fail_times = 0;
            }
        }
        if (cars.isEmpty()) fail_times ++;
        return cars.remove(cars.size()-1);
    }

    public static void release(Car carz){
        System.out.println("  ************ A New Car Released *******************");
        cars.add(carz);
    }


}
