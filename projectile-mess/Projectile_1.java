import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A larger bomb that fires with "f" is pressed.
 * 
 * @author Chandler Clarke
 * @version 1.0
 */
public class Projectile_1 extends SmoothMover
{
    private boolean readyToFire;
    private int clusterCounter;

    public Projectile_1()
    {
        this(new Vector(-45, 6));
    }

    public Projectile_1(Vector velocity)
    {
        super(velocity);
    }

    /**
     * Act - do whatever the Projectile_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(AWorld.GRAVITY);
        move();
        collisionDetector(); //Must be at end
    }    

    private void collisionDetector(){
        if (getY() < 260)
            readyToFire = true;
        if (getY() > 260 && readyToFire == true && clusterCounter < 1){
            for(int i = -1; i <= 1; i++){
                int angle = 40 * i;
                AWorld world = (AWorld)getWorld();
                world.addObject(new Projectile_1End(getRotation() - 50 * i, new Vector(90 + angle, 5)), getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}
