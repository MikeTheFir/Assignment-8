
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author pistm9061
 */
public class A8Q1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;


    // GAME VARIABLES WOULD GO HERE
Color skin = new Color(248, 200, 171);
Color lip = new Color(201,130,118);

int Unibrow = 315;
int UniUp = 180;

int UnibrowDirection = 1;

int Nose = 100;
int NoseDirection = 1;
    // GAME VARIABLES END HERE   

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 
        // hair
        g.setColor(Color.BLACK);
        g.fillRect(285, 75, 232, 150);
        // face
        g.setColor(skin);
        g.fillOval(275, 100, 250, 350);
        // hair forehead thing
        g.setColor(Color.BLACK);
        g.fillRect(285, 100, 232, 55);
        // ears
        g.setColor(skin);
        g.fillOval(250, 205, 40, 100);
        g.fillOval(510, 205, 40, 100);
        // sideburns
        g.setColor(Color.BLACK);
        g.fillOval(282, 120, 25, 125);
        g.fillOval(494, 120, 25, 125);
        g.fillOval(290, 135, 30, 50);
        g.fillOval(481, 135, 30, 50);
        // eyes
        g.setColor(Color.WHITE);
        g.fillOval(312, 200, 75, 50);
        g.fillOval(413, 200, 75, 50);
        // pupils
        g.setColor(Color.BLUE);
        g.fillOval(335, 210, 25, 25);
        g.fillOval(435, 210, 25, 25);
        // iris
        g.setColor(Color.BLACK);
        g.fillOval(342, 217, 10, 10);
        g.fillOval(442, 217, 10, 10);
        // nose
        g.drawArc(375, 225, 50, Nose, 180, 180);
        //lips
        g.setColor(lip);
        g.fillArc(323, 315, 150, 115, 185, 195);
        // mouth
        g.setColor(Color.PINK);
        g.fillArc(330, 330, 140, 95, 185, 200);
        // eyebrows
        g.setColor(Color.BLACK);
        g.fillRect(Unibrow, UniUp, 172, 20);
        // GAME DRAWING ENDS HERE
    }


    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void  preSetup(){
       // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if (Unibrow > 335) {
                UnibrowDirection = -1;
                UniUp = (int) (-25 * Math.sin(1*(2)) + 180);
            }
            if(Unibrow < 300){
             UnibrowDirection = 1;
             UniUp = (int) (25 * Math.sin(1*(2)) + 180); 
            }
            Unibrow = Unibrow + UnibrowDirection;
            
            if(Nose > 300){
                NoseDirection = (int) (-25 * Math.sin(1*(2)) + 180);
            }
            if(Nose < 200){
                NoseDirection = (int) (25 * Math.sin(1*(2)) + 180);
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        A8Q1 game = new A8Q1();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());
        
        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e){
            
        }
        
        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e){
            
        }
        
        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e){
            
        }
    }
    
    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter{
        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e){
            
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e){
            
        }
    }
}
}
