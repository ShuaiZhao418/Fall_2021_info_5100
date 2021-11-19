package Question1;

public class SportsCar extends CarDecorator{
    public SportsCar(Car car) {
        super(car);
        this.name = "Sports Car";

    }
    @Override
    public void assemble() {
        super.assemble();
    }

}
