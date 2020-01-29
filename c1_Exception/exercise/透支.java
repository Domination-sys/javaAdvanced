package javaAdvanced.c1_Exception.exercise;

public class 透支 extends Exception {
    double deficit;

    public double getDeficit() {
        return deficit;
    }
    public 透支(String msg, double deficit){
        super(msg);
        this.deficit = deficit;
    }
}
