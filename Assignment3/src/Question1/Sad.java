package Question1;

public class Sad extends Moody {
    private String name;

    public Sad(String name) {
        this.name = name;
    }
    //returns string indicating sad
    @Override
    public String getMood() {
        return "I feel sad Today";
    }
    //print crying string “‘waah’ ‘boo hoo’ ‘weep’ ‘sob’”
    @Override
    public void expressFeelings() {
        System.out.println("‘waah’ ‘boo hoo’ ‘weep’ ‘sob’");
    }
    //returns message about self : “Subject cries a lot”
    public String toString() {
        return this.name + " cries a lot";
    }
}
