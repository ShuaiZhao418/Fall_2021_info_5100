package Question1;

public class NonFiction extends Book implements iBorrowable {
    int borrowDay;
    int returnDay;

    public NonFiction(String title, double price, String publishYear) {
        super(title, price, publishYear);
        this.borrowDay = 0;
        this.returnDay = 0;
    }

    @Override
    public String description() {
        return "Anne Frank(title) all events are true and based on real fact";
    }

    @Override
    public void setBorrowData(int day) {
        this.borrowDay = day;
    }

    @Override
    public void setReturnData(int day) {
        this.returnDay = day;
    }

    @Override
    public boolean isAvailable(int day) {
        if (day >= borrowDay && day <= returnDay) {
            return false;
        }
        return true;
    }
}
