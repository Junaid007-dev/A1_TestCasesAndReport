//The following are imports for the test file
import java.awt.event.KeyEvent;
import org.junit.jupiter.api.*;

/**
 *
 * @author Mohammed Junaid Hanif
 */
//Public class for the ThreadTest file
public class ThreadTest {
    
    //Creating objects of classes used
    private Window window;
    private KeyboardListener kListener;
    
    Tuple position = new Tuple(10,10);
    ThreadsController threadsController = new ThreadsController(position);
     
    //Start up
    //This function will execute before everything
    @BeforeAll
    public static void setupAll(){
        System.out.println("I should be printed before all the tests commence! ThreadTest");
    }
    
    //This function will execute before each and every test
    @BeforeEach
    public void setup(){
        System.out.println("I am Instantiating the User Test Scripts! ThreadTest");
        //Helps initialise the Objects
        window = new Window();
        kListener = new KeyboardListener();
    }
    
    //These are the actual tests for the program
    
    //Test for having a collision
    @Test
    @DisplayName("Should give a COLLISION message")
    public void shouldGiveACollision() 
    {
        threadsController.start();
        
        threadsController.headSnakePos.ChangeData(threadsController.foodPosition.getX()-1, threadsController.foodPosition.getY());
        
        int i = 0,j = 0;
        
        Tuple t = new Tuple(i,j);
        
        for(i = threadsController.Squares.size()-1; i>=0; i--){
            for(j = threadsController.Squares.size()-1; j>=0; j--)
            {
                t.x = i;
                t.y = j;
                threadsController.positions.add(t);
            }
        }

        threadsController.headSnakePos.ChangeData(threadsController.foodPosition.getX()-1, threadsController.foodPosition.getY());
    }
    
    //Test for the data squares
    @Test
    @DisplayName("Testing for the data sqaures of the thread")
    public void shouldWorkforDataSqaures() 
    {
        threadsController.start();
        
        int i,j;
        
        for(i = threadsController.Squares.size()-1; i>=0; i--){
            for(j = threadsController.Squares.size()-1; j>=0; j--)
            {
                threadsController.Squares.get(i).get(j).lightMeUp(2);
            }
        }
        
        threadsController.headSnakePos.ChangeData(threadsController.foodPosition.getX()-1, threadsController.foodPosition.getY());
    }
    
    //Test for an interrupt
    @Test
    @DisplayName("Should cause a interrupt exception in pauser()")
    public void shouldCauseInterrupt() 
    {
        threadsController.start();
        
        threadsController.interrupt();
    }
    
    //Test for a yummy message
    @Test
    @DisplayName("Should give a yummy message")
    public void shouldGiveYummy() 
    {
        threadsController.start();
        
        threadsController.headSnakePos.ChangeData(threadsController.foodPosition.getX()-1, threadsController.foodPosition.getY());
    }
    
    //Test for snake to go to bottom
    @Test
    @DisplayName("Snake should go to edge of screen bottom part")
    public void shouldGoToBottomEdge() 
    {
        threadsController.start();
        
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_DOWN,'D');
        kListener.keyPressed(key);
        
        threadsController.headSnakePos.ChangeData(10,19);
    }
    
    //Test for snake to go to left
    @Test
    @DisplayName("Snake should go to edge of screen left part")
    public void shouldGoToLeftEdge() 
    {
        threadsController.start();
        
        //Here we press up first then left 
        //because the snake starts off going left
        KeyEvent key_change = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_LEFT,'L');
        
        kListener.keyPressed(key_change);
        kListener.keyPressed(key);
        
        threadsController.headSnakePos.ChangeData(0,10); 
    }
    
    //Test for snake to go to top
    @Test
    @DisplayName("Snake should go to edge of screen top part")
    public void shouldGoToTopEdge() 
    {
        threadsController.start();
        
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        kListener.keyPressed(key);
        
        threadsController.headSnakePos.ChangeData(10,0); 
    }
    
    //Test for snake to go to right
    @Test
    @DisplayName("Snake should go to edge of screen right part")
    public void shouldGoToRightEdge() 
    {
        threadsController.start();
        
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        kListener.keyPressed(key);
        
        threadsController.headSnakePos.ChangeData(19,10); 
    }
    
    //Test for snake to go move
    @Test
    @DisplayName("Test for snake moving to a location")
    public void shouldWorkForSnakemove() 
    { 
        threadsController.start();
        
        KeyEvent key = new KeyEvent(window, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  
        KeyEvent.VK_UP,'U');
        kListener.keyPressed(key);
        
        threadsController.headSnakePos.ChangeData(threadsController.foodPosition.getX(), threadsController.foodPosition.getY()); 
    }
    
    //Clean Up bits
    //This function will be executed after each and every test
    @AfterEach
    public void afterEachTest(){
        System.out.println("Just completed a test! ThreadTest");
    }

    //This function will be the last one executed after everything
    @AfterAll
    public static void weAreDoneNow(){
        System.out.println("This is the last thing to be printed! ThreadTest");
    }
}
