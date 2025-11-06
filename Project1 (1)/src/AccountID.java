public class AccountID {
    //Has
     private String stringID;

    //Does

    public AccountID(String accountID){
         stringID = accountID;
    }

    public boolean equalsID(AccountID compare){
        return stringID.equals(compare.toString());
    }

    public String toString(){
        return stringID;
    }



}
