package Question3;

public class Paypal implements PaymentStrategy{

    String email;

    public Paypal(String email) {
        this.email = email;
    }

    @Override
    public void pay(int value) {
        System.out.println("Paypal : " + value);
    }
}
