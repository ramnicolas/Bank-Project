public class Transfer extends Transaction{
    private AccountID destinyAccount;

    public Transfer(String accountNumber, double transactionAmount, String toAccountID){
        super(accountNumber, transactionAmount);
        destinyAccount = new AccountID(toAccountID);
    }

    public static Transfer fromCSV(String line){
        String [] tokens = line.split(",");
        if(tokens.length==4){
            return new Transfer(tokens[1], Double.parseDouble(tokens[2]),tokens[3]);
        }else return null;
    }

    public void execute(BankAccessor access){
        Account acc = access.findAccount(getID());

        if (acc != null && destinyAccount != null) {
            if (acc.getBalance() >= getAmount()) {
                acc.debit(getAmount());
                access.findAccount(destinyAccount).credit(getAmount());
            }
        }else{
            // todo: error auditing
        }

    }

}
