public class Transact {
    public static void main(String args[]){
        bank user=new bank(1000.00);
        atm a=new atm(user);
        a.initialise();
    }
}
