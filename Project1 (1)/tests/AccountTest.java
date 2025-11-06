import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getID() {
        Account test = new Account("checking",new AccountID("test1"), "Nicolas Ramos", 100 );
        assertTrue(test.getID().toString().equals("test1") );

    }

    @Test
    void getOwner() {
        Account test = new Account("checking",new AccountID("test1"), "Nicolas Ramos", 100 );
        assertTrue(test.getOwner().equals("Nicolas Ramos"));
    }

    @Test
    void getBalance() {
        Account test = new Account("checking",new AccountID("test1"), "Nicolas Ramos", 100 );
        assertTrue(test.getBalance()==100);
    }


    @Test
    void getOwner2() {
        Account test = new Account("savings",new AccountID("test1"), "Nicolas Ramos", 100 );
        assertFalse(test.getOwner().equals("Nicolas"));
    }

    @Test
    void getBalance2() {
        Account test = new Account("savings",new AccountID("test1"), "Nicolas Ramos", 100 );
        assertTrue(test.getBalance()!=10000);
    }



}