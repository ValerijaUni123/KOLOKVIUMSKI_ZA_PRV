package ZADACA4;

public interface ILog {
    //TODO write methods definitions here;
    String getType();
    String getMessage();
    long getTimestamp();
    void setMessage(String message);
}