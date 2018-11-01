import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile_3End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile_3End extends SmoothMover
{
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
        explode();
    }    
    private void explode(){
        if (isAtEdge() == true || isTouching(Target.class)){
            removeTouching(Target.class);
            getWorld().removeObject(this);
        }
    }
}
