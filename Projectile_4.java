import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile_4 here.
 * 
 * @author Tyler Bakeman
 * @version 10/31/2018
 */
public class Projectile_4 extends SmoothMover
{
    private Vector velocity;
    private int time = 0;
    public Projectile_4(){
        super(new Vector(45,2));
        velocity = new Vector(45,2);
        setImage("gun.png");
        getImage().scale(75,75);
        trimWhite();
    }
    public Projectile_4(Vector _velocity) {
        super(_velocity);
        velocity = _velocity;
        setImage("gun.png");
        getImage().scale(75,75);
        trimWhite();
    }
    
    /**
     * Act - do whatever the Projectile_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        time++;
        addToVelocity(AWorld.GRAVITY);
        addToVelocity(new Vector(-90,.05));
        velocity.add(AWorld.GRAVITY);
        move();
        main();
    }     
    
    public void main()
    {
        Target who = (Target)getOneIntersectingObject(Target.class);
        if(time % 5 == 0){
            Projectile_4End bullet = new Projectile_4End();
            bullet.addToVelocity(velocity);
            getWorld().addObject(bullet,(int)getExactX(),(int)getExactY());
        }
        if(who != null){
            getWorld().removeObject(who);
        }
        if(getY() >= getWorld().getHeight() - 50){
            getWorld().removeObject(this);
        }
        turn(7);
    }
    
    public void trimWhite(){
        int maxW = 235;
        GreenfootImage img = getImage();
        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                Color c = img.getColorAt(x,y);
                if(c.getRed() > maxW && c.getGreen() > maxW && c.getBlue() > maxW)
                    img.setColorAt(x,y,new Color(255,255,255,0)); //make transparent
            }
        }
        setImage(img);
    }
}
