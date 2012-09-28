/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codec;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristiano
 */
public class CalendarOperationTest {
    
    public CalendarOperationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        DateFormat dateFormat = SimpleDateFormat.getTimeInstance(SimpleDateFormat.SHORT);
        try {
            Date start = dateFormat.parse("10:20");
            Date end = dateFormat.parse("14:15");
            Duration duration = new Duration(start.getTime(), end.getTime());
            System.out.println(duration.toStandardDays());
            System.out.println(duration.toStandardHours());
            System.out.println(duration.toStandardMinutes());
            System.out.println(duration.toStandardSeconds());
            System.out.println(duration.toString());
            System.out.println(duration.toPeriod().toString());
            org.joda.time.Interval interval = new Interval(start.getTime(), end.getTime());
            System.out.println(interval.toString());
//            interval.toDuration().toStandardHours().tos
        } catch (ParseException e) {
            
        }        
    }
}
