package Question1;

public class Main {
    public static void main(String[] args) {
        Moody happy = new Happy("Object1");
        Moody sad = new Sad("Object2");
        Psychiatrist psy = new Psychiatrist();

        psy.toString();
        psy.examine(happy);
        happy.expressFeelings();
        psy.observe(happy);
        System.out.println();
        psy.toString();
        psy.examine(sad);
        sad.expressFeelings();
        psy.observe(sad);
    }
}
