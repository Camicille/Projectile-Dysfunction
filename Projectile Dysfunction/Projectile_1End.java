import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * smaller bombs.
 * 
 * @author Camille Otillio
 * @version (a version number or a date)
 */
public class Projectile_1End extends SmoothMover
{
    public Projectile_1End(){
    }

    public Projectile_1End(int direction, Vector velocity){
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
            AWorld world = (AWorld)getWorld();
            world.addObject(new Explosion(), getX(), getY());
            removeTouching(Target.class);
            getWorld().removeObject(this);
        }
    }
}
