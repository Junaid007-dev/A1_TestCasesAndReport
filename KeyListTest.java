//The following are imports for the test file
import org.junit.jupiter.api.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mohammed Junaid Hanif
 */
//Public class for the KeyListTest file
public class KeyListTest {
    
    //Creating objects of classes used
    private Window window; 
    private KeyboardListener kListener;
    
    //Start up
    //This function will execute before everything
    @BeforeAll
    public static void setupAll(){
        System.out.println("I should be printed before all the tests commence! KeyListTest");
    }

    //This function will execute before each and every test
    @BeforeEach
    public void setup(){
        System.out.println("I am Instantiating the User Test Scripts! KeyListTest");
        //Helps initialise the Objects
        window = new Window();        
        kListener = new KeyboardListener();
    }
    
    //These are the actual tests for the program

    //Test for pressing up key
    @Test
    @DisplayName("Test for press up")
    public void shouldWorkForPressup()
    {
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        kListener.keyPressed(key);
    }
    
    //Test for pressing down key
    @Test
    @DisplayName("Test for press down")
    public void shouldWorkForPressdown()
    {
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_DOWN,'D');
        kListener.keyPressed(key);
    }
    
    //Test for pressing right key
    @Test
    @DisplayName("Test for press right")
    public void shouldWorkForPressright()
    {
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_RIGHT,'R');
        kListener.keyPressed(key);
    }
    
    //Test for pressing left key
    @Test
    @DisplayName("Test for press left")
    public void shouldWorkForPressleft()
    {
        //Here we press up first then left 
        //because the snake starts off going left
        KeyEvent key_change = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_LEFT,'L');
        
        kListener.keyPressed(key_change);
        kListener.keyPressed(key);
    }
    
    //Test for pressing all keys
    @Test
    @DisplayName("Press all direction keys ")
    public void shouldWorkForAllkeys()
    {
        KeyEvent key_up = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        
        KeyEvent key_right = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_RIGHT,'R');
        
        KeyEvent key_down = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_DOWN,'D');
        
        KeyEvent key_left = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_LEFT,'L');
        
        kListener.keyPressed(key_up);
        kListener.keyPressed(key_right);
        kListener.keyPressed(key_left);
        kListener.keyPressed(key_down);
    }
    
    //Test for pressing random(1) keys
    @Test
    @DisplayName("Test for press anything")
    public void shouldnotWorkForPressSomekey()
    {
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_1,'1');
        kListener.keyPressed(key);
    }
        
    //Clean Up bits
    //This function will be executed after each and every test
    @AfterEach
    public void afterEachTest(){
        System.out.println("Just completed a test! KeyListTest");
    }

    //This function will be the last one executed after everything
    @AfterAll
    public static void weAreDoneNow(){
        System.out.println("This is the last thing to be printed! KeyListTest");
    }
}
