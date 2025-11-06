public class Withdrawal extends Transaction{

    public Withdrawal(String accountNumber, double transactionAmount){
        super(accountNumber, transactionAmount);
    }

    public static Withdrawal fromCSV(String line){
        String [] tokens =line.split(",");
        if(tokens.length==3){
            return new Withdrawal(tokens[1], Double.parseDouble(tokens[2]));
        }else return null;
    }

    public void execute(BankAccessor access) {
        Account acc = access.findAccount(getID());
        if (acc != null) {
            if (acc.getBalance() >= getAmount()) {
                acc.debit(getAmount());
            }
        }else{
            // todo: error auditing
        }
    }
}