import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world to put objects in
 * 
 * @author Marlene Inoue
 * @version 1.2 31 October 2018
 */
public class AWorld extends World {
    public static final Vector GRAVITY = new Vector(0.0, 0.5);

    //all actors individual projectors
    private Projector chandlerProjector = new Projector();
    private Projector philipProjector = new Projector();
    private Projector camilleProjector = new Projector();
    private Projector tylerProjector = new Projector();

    //locations of the projectors
    private static final int PROJECTOR_MIN = 20;
    private static final int PROJECTOR_MAX_X = 785;
    private static final int PROJECTOR_MAX_Y = 585;
    //remove text from screen
    private boolean removetext=false;
    //max turn of projectors
    private boolean cht=false;
    private boolean pt=false;
    private boolean cat=false;
    private boolean tt=false;
    //target locations
    private int[] xLocation = {Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100,
            Greenfoot.getRandomNumber(600) + 100};
    private int[] yLocation = {Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100,
            Greenfoot.getRandomNumber(400) + 100};

    /**
     * Constructor for objects of class AWorld.
     */
    public AWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        setUp();

    }

    /**
     * What the world will repeat
     */
    public void act() {
        instructions();
        turnG();
    }

    /**
     * Setting locations and angle for each projector
     */
    private void setUp() {
        addObject(chandlerProjector, PROJECTOR_MIN, PROJECTOR_MAX_Y);
        chandlerProjector.setRotation(300);

        addObject(philipProjector, PROJECTOR_MAX_X, PROJECTOR_MAX_Y);
        philipProjector.setRotation(260);

        addObject(camilleProjector, PROJECTOR_MIN, PROJECTOR_MIN);
        camilleProjector.setRotation(45);

        addObject(tylerProjector, PROJECTOR_MAX_X, PROJECTOR_MIN);
        tylerProjector.setRotation(120);

        for (int i = 0; i < xLocation.length; i++) 
        {
            addObject(new Target(), xLocation[i], yLocation[i]);
        }

        showText("Press \"a\" to fire the upper left projector up to rotate", 800 / 2, (600 / 2) - 30);
        showText("Press \"shift\" to fire the lower left projector left to rotate", 800 / 2, 600 / 2);

        showText("Press \"w\" to fire the upper left projector down to rotate", 800 / 2, (600 / 2) + 30);
        showText("Press \"f\" to fire the lower left projector right to rotate", 800 / 2, (600 / 2) + 60);
        showText("Press\"backspace\" to remove text",800 / 2, (600 / 2) + 90);

    }

    /**
     * Showing instructions within some time frame
     */
    private void instructions() {

      
        if (Greenfoot.isKeyDown("backspace"))
        {
            removetext=true;
        }
        if (removetext) 
        {
            showText(null, 800 / 2, (600 / 2) - 30);
            showText(null, 800 / 2, 600 / 2);
            showText(null, 800 / 2, (600 / 2) + 30);
            showText(null, 800 / 2, (600 / 2) + 60);
            showText(null, 800 / 2, (600 / 2) + 90);
        }
    }

    /**
     * Returns the current x location of chandlerProjector
     */
    public int getChandlerX(){
        return chandlerProjector.getX();
    }

    /**
     * Returns the current x location of philipProjector
     */
    public int getPhilipX(){
        return philipProjector.getX();
    }

    /**
     * Returns the current x location of camilleProjector
     */
    public int getCamilleX(){
        return camilleProjector.getX();
    }

    /**
     * Returns the current x location of tylerProjector
     */
    public int getTylerX(){
        return tylerProjector.getX();
    }

    /**
     * Returns the current y location of chandlerProjector
     */
    public int getChandlerY(){
        return chandlerProjector.getY();
    }

    /**
     * Returns the current y location of philipProjector
     */
    public int getPhilipY(){
        return philipProjector.getY();
    }

    /**
     * Returns the current y location of ca,o;;eProjector
     */
    public int getCamilleY(){
        return camilleProjector.getY();
    }

    /**
     * Returns the current y location of tylerProjector
     */
    public int getTylerY(){
        return tylerProjector.getY();
    }

    public void turnG()
    {   
        if (getCHR()==269)
        {
            cht=true;
        }
        
        if (getCHR()==0)
        {
            cht=false;
        }
        
        if (getPR()==269)
        {
            pt=true;
        }
        
        if (getPR()==180)
        {
            pt=false;
        }
        
        if (getCAR()==90)
        {
            cat=true;
        }
        
        if (getCAR()==0)
        {
            cat=false;
        }
        
        if (getTR()==90)
        {
            tt=true;
        }
        
        if (getTR()==180)
        {
            tt=false;
        }
        
        if (Greenfoot.isKeyDown("left")&& !cht)
        {
            chandlerProjector.turn(-1);
        }
        else if (Greenfoot.isKeyDown("left")&& cht)
        {
            chandlerProjector.turn(1);
        }
        
        if (Greenfoot.isKeyDown("right") &&  !pt)
        {
            philipProjector.turn(1);
        }
        else if (Greenfoot.isKeyDown("right") &&  pt)
        {
            philipProjector.turn(-1);
        }
        
        if (Greenfoot.isKeyDown("up")&&!cat)
        {
            camilleProjector.turn(1);
        }
        else if (Greenfoot.isKeyDown("up") && cat)
        {
            camilleProjector.turn(-1);
        }
        
        if (Greenfoot.isKeyDown("down")&& !tt)
        {
            tylerProjector.turn(-1);
        }
        else if (Greenfoot.isKeyDown("down")&& tt)
        {
            tylerProjector.turn(1);
        }
    }

    public int getCHR()
    {
        return chandlerProjector.getRotation();
    }

    public int getPR()
    {
        return philipProjector.getRotation();
    }

    public int getCAR()
    {
        return camilleProjector.getRotation();
    }

    public int getTR()
    {
        return tylerProjector.getRotation();
    }
}