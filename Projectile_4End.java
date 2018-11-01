import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile_4End here.
 * 
 * @author Tyler Bakeman
 * @version (a version number or a date)
 */
public class Projectile_4End extends SmoothMover{
    public Projectile_4End(){
        setImage("bullet.jpg");
        getImage().scale(70,70);
        setRotation(180);
        trimWhite();
    }
    
    public void act() 
    {
        addToVelocity(new Vector(180,7));
        move();
        main();
    }    
    
    public void main()
    {
        Target who = (Target)getOneIntersectingObject(Target.class);
        if(who != null){
            getWorld().removeObject(who);
            getWorld().removeObject(this);
        } else if(isAtEdge()){
            getWorld().removeObject(this);
        }
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
