package Question1;

public class Reference extends Book{
    String category;
    public Reference(String title, double price, String publishYear, String category) {
        super(title, price, publishYear);
        this.category = category;
    }

    @Override
    public String description() {
        return "World Maps(title) all information is real.";
    }
}
