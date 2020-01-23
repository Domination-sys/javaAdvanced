package javaAdvanced.c1_Exception.exercise;

public class OverdrafException extends Exception {
    double deficit;

    public double getDeficit() {
        return deficit;
    }
    public OverdrafException(String msg,double deficit){
        super(msg);
        this.deficit = deficit;
    }
}
