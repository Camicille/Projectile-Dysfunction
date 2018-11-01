import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An explosion.
 * 
 * @author Chandler Clarke 
 * @version 1.0
 */
public class Explosion extends Actor
{
    public Explosion()
    {
        Greenfoot.playSound("explosion.wav");
    }
    public void act() 
    {
        int alpha = getImage().getTransparency();
        if (alpha > 10)
        {
            getImage().setTransparency(alpha - 10);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    
}
