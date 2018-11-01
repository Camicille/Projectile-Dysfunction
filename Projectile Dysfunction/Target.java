import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object to destroy
 * 
 * @author Marlene Inoue 
 * @version 1.0 30 October 2018
 */
public class Target extends Actor {
    private boolean turn;
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {

        side();
    }  
    private void side()
    {
        if (getX() <=0)
        {
            turn = true;
        }
        if (getX()>=799){
            turn = false;
        } 
        if (turn == false )
        {
            setLocation(getX()-5,getY());
        }
        if (turn == true)
        {
            setLocation(getX()+5,getY());
        } 

    }
}
