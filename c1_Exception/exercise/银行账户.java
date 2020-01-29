package javaAdvanced.c1_Exception.exercise;

public class 银行账户 {
    double banlance;
    public 银行账户(double banlance){
        this.banlance = banlance;
    }
    public double getBanlance() {
        return banlance;
    }
    public void deposit(double amount){
        this.banlance += amount;
    }
    public void withdraw(double amount) throws 透支 {
        if(banlance>=amount)
            banlance -= amount;
        else
            throw new 透支("余额不足",amount-banlance);
    }

    public static void main(String[] args) {
        银行账户 account = new 银行账户(1000);
        account.deposit(1000);
        System.out.println("余额还有"+account.getBanlance());

        try{
            account.withdraw(5000);
        }catch (透支 e){
            e.printStackTrace();
            System.err.println("透支金额为"+e.getDeficit());
        }

    }
}
