//The following are imports for the test file
import javax.swing.JFrame;
import org.junit.jupiter.api.*;

/**
 *
 * @author Mohammed Junaid Hanif
 */
//Public class for the MainTest file
public class MainTest {
    
    //Creating objects of classes used
    private Main main;
    
    //Start up
    //This function will execute before everything
    @BeforeAll
    public static void setupAll(){
        System.out.println("I should be printed before all the tests commence! MainTest");
    }
    
    //This function will execute before each and every test
    @BeforeEach
    public void setup(){
        System.out.println("I am Instantiating the User Test Scripts! MainTest");
        //Helps initialise the Objects
        main = new Main();
    }
    
    //These are the actual tests for the program
    
    //Test for running the main
    @Test
    @DisplayName("Testing for the main program to execute it")
    public void shouldWorkForMain() {
        
        //Creating the window
        Window window = new Window();
        
        //Setting up the window settings
        window.setTitle("Snake");
        window.setSize(300,300);
        window.setVisible(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.main(null);
    }
    
    //Clean Up bits
    //This function will be executed after each and every test
    @AfterEach
    public void afterEachTest(){
        System.out.println("Just completed a test! MainTest");
    }

    //This function will be the last one executed after everything
    @AfterAll
    public static void weAreDoneNow(){
        System.out.println("This is the last thing to be printed! MainTest");
    }
}
