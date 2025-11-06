import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountIDTest {

    @Test
    void testEquals() {
        AccountID acc1 = new AccountID("test");
        AccountID acc2 = new AccountID("test");

        assertTrue( acc1.equals(acc2));

    }

    @Test
    void testToString() {
        AccountID acc1 = new AccountID("test");
        assertTrue( acc1.toString().equals("test"));
    }
}