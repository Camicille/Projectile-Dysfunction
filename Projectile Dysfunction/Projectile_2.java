import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * projectile
 * 
 * @author Philip Jepkes
 * @version (v.1)
 */
public class Projectile_2 extends SmoothMover
{
    /**
     * 
     */
    public Projectile_2()
    {
      this(new Vector(0,30));
    }

    /**
     * 
     */
    public Projectile_2(Vector velocity) {
        super(velocity);
    }

    /**
     * Act - do whatever the Projectile_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(AWorld.GRAVITY);
        turn(spinSpeed());
        move();
        destroyTarget();
    }    
    private int spinSpeed()
    {
        double sp = getSpeed();
        int s =(int) sp;
        return s;
    }
    private void destroyTarget(){ 
        Actor target = getOneIntersectingObject(Target.class);
        
        if (isAtEdge()&& this !=null)
        {
            getWorld().removeObject(this);return;
        }
        
        if (target != null)
        {
            AWorld world = (AWorld) getWorld();
            world.addObject(new Projectile_2End(), getX(), getY());
            world.removeObject(target);
            world.removeObject(this);
        }
    }
}