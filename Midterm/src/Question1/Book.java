package Question1;

public abstract class Book {
    private String title;
    private double price;
    private String publishYear;
    public Book(String title, double price, String publishYear) {
        this.title = title;
        this.price = price;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public abstract String description();
}
