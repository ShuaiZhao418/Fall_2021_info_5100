package Question2;


class Printer {
    private static Printer myprinter;
    private Printer() {}
    private static Object obj = new Object();
    public static Printer getInstance() {
        if (myprinter == null) {
            synchronized (obj) {
                if (myprinter == null) {
                    myprinter = new Printer();
                }
            }
        }
        return myprinter;
    }
    public void getConnection() {
        System.out.println("Your printer is working!");
    }

}
