public class Deposit extends Transaction{

    public Deposit(String accountNumber, double transactionAmount){
        super(accountNumber, transactionAmount);
    }

    public static Deposit fromCSV(String line){
        String [] tokens =line.split(",");
        if(tokens.length==3){
            return new Deposit(tokens[1], Double.parseDouble(tokens[2]));
        }else return null;
    }

    public void execute(BankAccessor access){
        Account acc = access.findAccount(getID());
        if (acc != null) {
            acc.credit(getAmount());
        }else{
            // todo: error auditing
        }
    }
}