import com.Car;
import com.CarRental;

public class TestCarRental {
    public static void main(String[] args) {

        CarRental cr = CarRental.getInstance();
        cr.report();

        Car customer1 = cr.borrow();
        cr.report();

        Car customer2 = cr.borrow();
        cr.report();

        Car customer3 = cr.borrow();
        cr.report();

        cr.release(customer1);
        cr.report();

        cr.release(new Car());
        cr.report();


    }
}
