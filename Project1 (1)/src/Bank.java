import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Bank implements BankAccessor{
    //Has
    private Account[] accountList;
    private int maxAccounts;


    //Does

    public Bank( int accountAmount){
        maxAccounts = accountAmount;
        accountList = new Account[maxAccounts];

    }

    public void addAccount(Account acc){
        for(int i=0; i<accountList.length; i++){
            if(accountList[i] == null) {
                accountList[i] = acc;
                break;
            }
        }
    }

    public Account findAccount(AccountID checkID){
        int i=0;
        while(i < maxAccounts && (accountList[i]!=null)){
            if(accountList[i].getID().equalsID(checkID)){
                return accountList[i];
            }
            i++;
        }
        return null;
    }

    public int getCount(){
        int i=0;
        while(i < maxAccounts && accountList[i]!=null){
            i++;
        }
        return i;
    }

    public void loadAccounts(String fileLocation){
        try{
            File file = new File(fileLocation);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                Account acc = Account.fromCSV(line);
                addAccount(acc);
            }


        }catch (java.io.FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void saveAccounts(){
        File file = new File("output.csv");
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < accountList.length; i++) {
                if(accountList[i]!=null) {
                    String line = accountList[i].toCsv();
                    writer.write(line);
                }
            }
            writer.close();
        }catch(java.io.IOException e){

        }
    }

    public Transaction[] loadTransactions(String fileLocation){
        try {
            File file = new File(fileLocation);
            Scanner sc = new Scanner(file);
            int fileLength = docLength(fileLocation);
            Transaction[] transactions= new Transaction[fileLength];
            int i =0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                Transaction transaction = null;
                if (tokens[0].equals("deposit")) {
                    transaction = Deposit.fromCSV(line);
                    transactions[i]= transaction;
                    i++;
                } else if (tokens[0].equals("withdrawal")) {
                    transaction = Withdrawal.fromCSV(line);
                    transactions[i]= transaction;
                    i++;
                } else if (tokens[0].equals("transfer")) {
                    transaction = Transfer.fromCSV(line);
                    transactions[i]= transaction;
                    i++;
                }

            }
            return transactions;
        }catch (java.io.FileNotFoundException e){
        }
        return null;
    }

    private static int docLength(String fileLocation){
        try {
            File file = new File(fileLocation);
            Scanner sc = new Scanner(file);
            int fileLength = 0;
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                fileLength++;
            }

             return  fileLength;
        }catch (java.io.FileNotFoundException e){

        } return 0;
    }

    public void executeTransactions(Transaction[] transactions){
        for(int i=0; i<transactions.length;i++) {
            if (transactions[i]!=null) {
                transactions[i].execute(this);
            }
        }
    }

}
