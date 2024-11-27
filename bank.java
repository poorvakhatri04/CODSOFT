public class bank{
    private double balance;
    public bank(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amt){
        if(amt>0){
            balance+=amt;
            System.out.println("Successfully deposited amount: "+amt);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }
    public boolean withdraw(double amt){
        if(amt>0 && amt<=balance){
            balance-=amt;
            System.out.println("Successfully withdrawn amount: "+amt);
            return true;
        }
        else{
            System.out.println("Insufficient balance!");
            return false;
        }
    }
}
