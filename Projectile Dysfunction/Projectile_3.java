import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile_3 here.
 * 
 * @author Camille Otillio
 * @version 1
 */
public class Projectile_3 extends SmoothMover
{
    /**
     * 
     */
   
   public Projectile_3()
    {
        this(new Vector(360, 12));
    }
   public Projectile_3(Vector velocity) {
        super(velocity);
    }
   /**
     * Bird goes for bats, if hit, releases tree bombs
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int angle = Greenfoot.getRandomNumber(5)-10;
        addToVelocity(AWorld.GRAVITY);
        move();
        turn(angle);
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
