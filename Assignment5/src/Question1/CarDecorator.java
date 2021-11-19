package Question1;

public class CarDecorator implements Car{
    String name = "";
    protected Car car = null;
    public CarDecorator(Car car) {
        this.car = car;
    }
    @Override
    public void assemble() {
        System.out.print(name);
    }
}
