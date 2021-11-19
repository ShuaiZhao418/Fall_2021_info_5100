package Question1;

public class LuxuryCar extends CarDecorator{
    public LuxuryCar(Car car) {
        super(car);
        this.name += "Adding features of Luxury Car.";
        super.assemble();
    }
    @Override
    public void assemble() {
    }

}
