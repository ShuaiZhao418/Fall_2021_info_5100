package Question1;

public class LuxuryCar extends CarDecorator{
    public LuxuryCar(Car car) {
        super(car);
        this.name = "Luxury Car";
    }
    @Override
    public void assemble() {
        super.assemble();
    }

}
