import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void addAccount() {

    }

    @Test
    void findAccount() {
        Bank test = new Bank(100);
        Account testAcc = new Account("savings",new AccountID("test1"), "Nicolas Ramos", 1000.13);
        test.addAccount(testAcc);
        assertTrue(test.findAccount(new AccountID("test1")) != null);

    }

    @Test
    void getCount() {
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);
        Account testAcc5 = new Account("checking",new AccountID("test5"), "Nicolas Ramos", 123.13 );
        test.addAccount(testAcc5);
        assertTrue(test.getCount()==5);

    }

    @Test
    void findAccount2() {
        Bank test = new Bank(100);

        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);
        Account testAcc5 = new Account("checking",new AccountID("test5"), "Nicolas Ramos", 123.13 );
        test.addAccount(testAcc5);
        AccountID testID = new AccountID("test4");
        assertTrue(test.findAccount(testID) != null);

    }

    @Test
    void getCount2() {
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);
        assertFalse(test.getCount()==5);

    }


    @Test
    void findAccount3() {
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);
        AccountID testID = new AccountID("test");
        assertTrue(test.findAccount(testID)==null);

    }

    @Test
    void getCount3() {
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);
        assertTrue(test.getCount()==4);

    }

    @Test
    void loadAccount1 (){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");

        assertTrue(test.getCount()==4);

    }
    @Test
    void loadAccount2 (){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");
        AccountID testID = new AccountID("as2323");

        assertTrue(test.findAccount(testID)!=null);

    }

    @Test
    void loadAccount3 (){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");

        assertTrue(test.getCount()!=5);

    }
    @Test
    void loadAccount4 (){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");
        AccountID testID = new AccountID("asa2323");

        assertTrue(test.findAccount(testID)==null);

    }

    @Test
    void saveAccount1(){
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);

        test.saveAccounts();

        test.loadAccounts("output.csv");
        assertTrue(test.getCount()==4);


    }

    @Test
    void saveAccount2(){
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings",new AccountID("test4"), "Nicolas Ramos", 40.1 );
        test.addAccount(testAcc4);

        test.saveAccounts();

        test.loadAccounts("output.csv");

        AccountID testID = new AccountID("test1");
        assertTrue(test.findAccount(testID)!=null);


    }
    @Test
    void saveAccount3(){
        Bank test = new Bank(100);
        Account testAcc1 =  new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13 );
        test.addAccount(testAcc1);
        Account testAcc2 =  new Account("checking",new AccountID("test2"), "Nicolas Ramos", 100.01 );
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings",new AccountID("test3"), "Nicolas Ramos", 12000.13 );
        test.addAccount(testAcc3);

        test.saveAccounts();

        test.loadAccounts("output.csv");
        assertTrue(test.getCount()!=4);


    }
    @Test
    void saveAccount4() {
        Bank test = new Bank(100);
        Account testAcc1 = new Account("savings", new AccountID("test1"), "Nicolas Ramos", 1100.13);
        test.addAccount(testAcc1);
        Account testAcc2 = new Account("checking", new AccountID("test2"), "Nicolas Ramos", 100.01);
        test.addAccount(testAcc2);
        Account testAcc3 = new Account("savings", new AccountID("test3"), "Nicolas Ramos", 12000.13);
        test.addAccount(testAcc3);
        Account testAcc4 = new Account("savings", new AccountID("test4"), "Nicolas Ramos", 40.1);
        test.addAccount(testAcc4);

        test.saveAccounts();

        test.loadAccounts("output.csv");
        AccountID testID = new AccountID("test");
        assertTrue(test.findAccount(testID) == null);
    }


    @Test
    void loadtransactions1(){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");
        Transaction[] testTransactions = test.loadTransactions("testTransactions.csv");
        assertTrue(testTransactions.length==3);

    }

    @Test
    void loadtransactions2(){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");
        Transaction[] testTransactions = test.loadTransactions("testTransactions.csv");
        assertFalse(testTransactions [0].equals(null));
    }

    @Test
    void executeTransactions1(){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");
        Transaction[] testTransactions = test.loadTransactions("testTransactions.csv");
        test.executeTransactions(testTransactions);
        AccountID testID = new AccountID("ty2423");
        Account testAcc = test.findAccount(testID);
        assertTrue(testAcc.getBalance()==866.65);

    }

    @Test
    void executeTransactions2(){
        Bank test = new Bank(100);
        test.loadAccounts("TestAccount.csv");
        Transaction[] testTransactions = test.loadTransactions("testTransactions.csv");
        test.executeTransactions(testTransactions);
        AccountID testID = new AccountID("as2323");
        Account testAcc = test.findAccount(testID);
        assertTrue(testAcc.getBalance()==786.99);


    }




}