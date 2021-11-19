package Question1;

public class CarDecorator implements Car{
    String name = "";
    protected Car basiccar = null;
    public CarDecorator(Car car) {
        this.basiccar = car;
    }
    @Override
    public void assemble() {
        basiccar.assemble();
        System.out.print(" Adding festures of " + this.name + ".");
    }
}
