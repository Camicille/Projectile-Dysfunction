import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile_3 here.
 * 
 * @author Camille Otillio
 * @version (a version number or a date)
 */
public class Projectile_3 extends SmoothMover
{
    /**
     * 
     */
   private boolean readyToFire;
   
    
   public Projectile_3()
    {
        this(new Vector(360, 12));
    }
   public Projectile_3(Vector velocity) {
        super(velocity);
    }
   /**
     * Act - do whatever the Projectile_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(AWorld.GRAVITY);
        move();
        collisionDetector();
    }
   
    private void collisionDetector()
    {
        
       Actor target = getOneIntersectingObject(Target.class);
    if (target != null)
       {
            for(int i = -2; i <= 3; i++){
                int angle = 40 * i;
                AWorld world = (AWorld)getWorld();
                world.addObject(new Projectile_3End(getRotation() + 90 * i, new Vector(90 + angle, 5)), getX(), getY());
            }
            getWorld().removeObject(this);
        }
          
    }
}
