import java.util.Scanner;
class ATM {
    private BankAccount account;
    public ATM(BankAccount account){
        this.account=account;
    }
    public void initialise(){
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Menu:");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            switch(choice){
                case 1: checkBal();
                        break;
                case 2: System.out.print("Enter amount to deposit: ");
                        double dep=sc.nextDouble();
                        deposit(dep);
                        break;
                case 3:System.out.print("Enter amount to withdraw: ");
                        double wit=sc.nextDouble();
                        withdraw(wit);
                        break;
                case 4: System.out.println("Thank you for using the ATM. Goodbye!");
                        sc.close();
                        return;
                default:
                        System.out.println("Invalid option. Try again!");
            }
        }while(true);
    }
    private void checkBal(){
        System.out.println("Your current balance is: "+account.getBalance());
    }
    private void deposit(double amount){
        account.deposit(amount);
    }
    private void withdraw(double amount){
        account.withdraw(amount);
    }
}
