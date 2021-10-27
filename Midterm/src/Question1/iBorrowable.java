package Question1;

public interface iBorrowable {
    void setBorrowData(int day);
    void setReturnData(int day);
    boolean isAvailable(int day);
}
