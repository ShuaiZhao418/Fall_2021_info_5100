package Question1;

public class Happy extends Moody{
    public String name;

    public Happy(String name) {
        this.name = name;
    }

    //returns string indicating happy
    @Override
    public String getMood() {
        return "I feel happy Today";
    }
    //print laughter string “heeehee….hahahah…HAHAHA!!”
    @Override
    public void expressFeelings() {
        System.out.println("heeehee….hahahah…HAHAHA!!");
    }
    //returns message about self: “Subject laughs a lot”
    public String toString() {
        return this.name + " laughs a lot";
    }
}
