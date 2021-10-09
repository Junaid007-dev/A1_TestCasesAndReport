//The following are imports for the test file
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Mohammed Junaid Hanif
 */
//Public class for the MainTest file
public class TupleTest {
    
    //Creating objects of classes used
    private Tuple tuple = new Tuple(10,10);
    
    //Start up
    //This function will execute before everything
    @BeforeAll
    public static void setupAll(){
        System.out.println("I should be printed before all the tests commence! TupleTest");
    }
    
    //This function will execute before each and every test
    @BeforeEach
    public void setup(){
        System.out.println("I am Instantiating the User Test Scripts! TupleTest");
    }
    
    //These are the actual tests for the program
    
    //Test for setting the x vlaue of the tuple
    @Test
    @DisplayName("Should set the x vlaue of the tuple")
    public void shouldSetXValue() {
        
        int data = 12;
        tuple.ChangeData(data, tuple.getY());
                
        assertEquals(12,tuple.getX());
        assertEquals(10,tuple.getY());
        assertEquals(0,tuple.getXf());
        assertEquals(0,tuple.getYf());
    }
    
    //Test for setting the x vlaue of the tuple
    @Test
    @DisplayName("Should set set the x vlaue of the tuple")
    public void shouldSetYValue() {
        
        int data = 12;
        tuple.ChangeData(tuple.getX(), data);
                
        assertEquals(10,tuple.getX());
        assertEquals(12,tuple.getY());
        assertEquals(0,tuple.getXf());
        assertEquals(0,tuple.getYf());
    }
    
    //Clean Up bits
    //This function will be executed after each and every test
    @AfterEach
    public void afterEachTest(){
        System.out.println("Just completed a test! TupleTest");
    }

    //This function will be the last one executed after everything
    @AfterAll
    public static void weAreDoneNow(){
        System.out.println("This is the last thing to be printed! TupleTest");
    }
}
