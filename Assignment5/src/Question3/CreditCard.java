package Question3;

public class CreditCard implements PaymentStrategy{

    String cardNumber;

    public CreditCard(String number) {
        this.cardNumber = number;
    }

    @Override
    public void pay(int value) {
        System.out.println("CreditCard : " + value);
    }
}
