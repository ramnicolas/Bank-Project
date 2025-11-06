public abstract class Transaction {
    private AccountID accID;
    private double amount;

    abstract public void execute(BankAccessor access);

    protected Transaction(String accountNumber, double transactionAmount){
        accID = new AccountID(accountNumber);
        amount = transactionAmount;

    }

    protected double getAmount(){
        return amount;
    }
    protected AccountID getID(){
        return accID;
    }
}