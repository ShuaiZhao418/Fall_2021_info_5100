package Question1;

public abstract class Moody {


    // Return the mood : sad or happy – depending on which object sends the message
    abstract String getMood();

    // Each Object expresses a different motion
    abstract void expressFeelings();

    //an object responds according to how it feels, print ”I feel Question1.Happy(or Question1.Sad) today!!”
    public void queryMood(String mood) {
        System.out.println("I feel Question1."+ mood +" today!!");
    }
}
