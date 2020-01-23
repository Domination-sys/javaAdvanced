package javaAdvanced.c1_Exception.exercise;

public class Account {
    double banlance;
    public Account(double banlance){
        this.banlance = banlance;
    }
    public double getBanlance() {
        return banlance;
    }
    public void deposit(double amount){
        this.banlance += amount;
    }
    public void withdraw(double amount) throws OverdrafException {
        if(banlance>=amount)
            banlance -= amount;
        else
            throw new OverdrafException("余额不足",amount-banlance);
    }

    public static void main(String[] args) {
        Account account = new Account(1000);
        account.deposit(1000);
        System.out.println("余额还有"+account.getBanlance());

        try{
            account.withdraw(5000);
        }catch (OverdrafException e){
            e.printStackTrace();
            System.err.println("透支金额为"+e.getDeficit());
        }

    }
}
