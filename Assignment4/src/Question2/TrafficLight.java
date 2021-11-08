package Question2;

public class TrafficLight {

    // signal represents which road is green
    private int signal;

    public TrafficLight() {
        // 1 represents light on A road is red, light on B road is green
        // 0 represents light on B road is red, light on A road is green
        this.signal = 1;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized(this){
            if((direction == 1 || direction == 2) && (signal == 1)){
                turnGreen.run();
                signal = ((signal+1)%2);
            }else if((direction == 3 || direction == 4) && (signal == 0)){
                turnGreen.run();
                signal = ((signal+1)%2);
            }
            crossCar.run();
        }
    }
}
