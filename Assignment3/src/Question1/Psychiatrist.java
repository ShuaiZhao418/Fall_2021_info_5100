package Question1;

public class Psychiatrist {

    //asks moody object about its mood
    public void examine(Moody moodyObject) {
        System.out.println(moodyObject.getMood());
    }
    //a moodyObject is observed to either laugh or cry
    public void observe(Moody moodyObject) {
        System.out.println("Observation: " + moodyObject.toString());
    }
    //returns message about self: “Subject laughs a lot”
    public String toString() {
        System.out.println("How are you feeling today?");
        return "How are you feeling today?";
    }
}
