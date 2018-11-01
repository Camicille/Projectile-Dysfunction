import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * BLACK HOLE
 * 
 * @author Philip Jepkes
 * @version (v.1)
 */
public class Projectile_2End extends Actor
{   
    private static final int IMAGE_AMOUNT =32;

    private GreenfootImage[] images;
    private int counter;
    public Projectile_2End()
    {

        this(0);
    }

    public Projectile_2End(int spin)
    {
        initializeImages();
        setRotation(spin);
    }

    /**
     * Act - do whatever the Projectile_2End wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        setImage(images[counter]);
        countPlus();
        turn(5);
        hole();
        if (counter>=IMAGE_AMOUNT)
        {   AWorld world =(AWorld)getWorld();
            world.removeObject(this);
        }
    }  
    /**
     * increment counter
     */
    private void countPlus()
    {
        counter++;
        if(counter>=IMAGE_AMOUNT){counter =IMAGE_AMOUNT;}
    }

    private void initializeImages()
    {

        if (images == null)
        {
            GreenfootImage start = new GreenfootImage("Water02.png");
            GreenfootImage next  = new GreenfootImage("Water03.png");
            GreenfootImage next2  =new GreenfootImage("Water04.png");
            GreenfootImage next3  =new GreenfootImage("Water05.png");
            images = new GreenfootImage[IMAGE_AMOUNT];
            for (int i = 0; i < IMAGE_AMOUNT; i++)
            {

                if (i<8)
                {
                    images[i] = new GreenfootImage(start);
                }
                if (i>7 && i<16)
                {
                    images[i] = new GreenfootImage(next);
                }
                if (i>15 && i<24)
                {
                    images[i] = new GreenfootImage(next2);
                }
                if (i>23 && i<32)
                {
                    images[i] = new GreenfootImage(next3);
                }

            }
        }
    }
    private void hole()
    {
        AWorld world = (AWorld) getWorld();
        List <Target> targets =world.getObjects(Target.class);
        for(Target target : targets)
        {
            target.turnTowards(getX(),getY());
            target.move(2);
        }
    }
}