
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile_3End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Projectile_3End extends SmoothMover   
{
    private static final int NUMBER_IMAGES= 20;
    private static GreenfootImage[] images;
    private int currentImage = 0;
    
    public Projectile_3End(){
        
    }
    public Projectile_3End(int direction, Vector velocity){
        addToVelocity(velocity);
        setRotation(direction);
    }

    /**
     * Act - do whatever the Projectile_1End wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(AWorld.GRAVITY);
        move();
        turn(Greenfoot.getRandomNumber(4) - 8);
        initializeImages();
        
        explode();
        grow();
    }
    public static void initializeImages() 
    {
         if (images == null) 
         {
            GreenfootImage baseImage = new GreenfootImage("tree3.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            for (int i = 0; i < NUMBER_IMAGES; i++) 
            {
                int size = (i+1) * 3 * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    private void grow()
    {
        if (currentImage > NUMBER_IMAGES) 
        {
            currentImage--;
            setImage(images[currentImage]);
            
        }
        else if  (currentImage < NUMBER_IMAGES) 
        {
            setImage(images[currentImage]);
            currentImage++;
        }
    }
    private void explode(){
        if (isAtEdge() == true || isTouching(Target.class)){
            removeTouching(Target.class);
            getWorld().removeObject(this);
        }
    }
}

