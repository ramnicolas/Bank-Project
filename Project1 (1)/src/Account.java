public class Account {
    //Has
    private double accountBalance;
    private String accOwner;
    private AccountID accID;
    private String accType;


    // Does
    public Account(String type, AccountID accountNumber, String owner, double startBalance){
       accountBalance = startBalance;
       accOwner = owner;
       accID = accountNumber;
       accType = type;
    }

    public AccountID getID(){
        return accID;
    }

    public String getOwner(){
        return accOwner;
    }

    public double getBalance(){
       return accountBalance;
    }

    public String getType(){
        return accType;
    }

    public void credit(double amount){
         accountBalance+=amount;
    }
    public void debit(double amount){
        if(accountBalance>=amount){
            accountBalance-=amount;
        }
    }


    public static Account fromCSV(String line) {
        String[] tokens = line.split(",");
        if (tokens.length == 4) {
            AccountID addAccountID = new AccountID(tokens[1]);
            Account acct = new Account(tokens[0],addAccountID,tokens[2],Double.parseDouble(tokens[3]));
            return acct;
        } else{
            return null;
        }
    }

    public String toCsv(){
        String str =getType()+","+ getID().toString() + "," + getOwner() + "," + getBalance();
        return str;
    }




}
