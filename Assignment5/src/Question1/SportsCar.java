package Question1;

public class SportsCar extends CarDecorator{
    public SportsCar(Car car) {
        super(car);
        this.name += "Adding features of Sports Car.";
        super.assemble();
    }
    @Override
    public void assemble() {

    }

}
