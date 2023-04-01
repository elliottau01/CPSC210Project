package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTest {

    private Event e;
    private Date d;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("E1");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }

//    @Test
//    public void testEvent() {
//        assertEquals("E1", e.getDescription());
//        assertEquals(d, e.getDate());
//    }

    @Test
    public void testHashCode() {
        Event e1 = new Event("E1");
        Event e2 = new Event("E1");

        assertTrue(e1.equals(e2));
    }


    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "E1", e.toString());
    }


}
