import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Projects all of the projectiles
 * 
 * @author Marlene Inoue 
 * @version 1.1 31 October 2018
 */
public class Projector extends Actor {
    //times for each projector
    private int chandlerTime = 1000, philipTime = 100, camilleTime = 100, tylerTime =100;

    /**
     * FIXME: write down what your vector rotation will be
     */
    private void chandlerFire() {
        boolean chandlerAim = true;
        AWorld world = (AWorld) getWorld();
        List <Projectile_1> c =world.getObjects(Projectile_1.class);
        List <Projectile_1End> c2 =world.getObjects(Projectile_1End.class);
        if (Greenfoot.isKeyDown("shift")&& chandlerTime >=100 && c.size()==0 && c2.size()==0){
            int ang = world.getCHR(); // adjust angle for image

            
            Projectile_1 ball = new Projectile_1(new Vector(ang, 20));
            getWorld().addObject(ball, world.getChandlerX(), world.getChandlerY());
            ball.setRotation(ang);
            ball.move(42); // clear the cannon barrel
            chandlerTime = 0;
        }
    }

    /**
     * FIXME: write down what your vector rotation will be
     */
    private void philipFire() {
         AWorld world = (AWorld) getWorld();
        List <Projectile_2> p =world.getObjects(Projectile_2.class);
        List <Projectile_2End> p2 =world.getObjects(Projectile_2End.class);
        if (Greenfoot.isKeyDown("f")&& philipTime >=100 && p.size()==0 && p2.size()==0) {
            int angle = world.getPR(); // adjust angle for image

            
            Projectile_2 ball = new Projectile_2(new Vector(angle,30));
            getWorld().addObject(ball, world.getPhilipX(), world.getPhilipY());
            ball.setRotation(angle);
            ball.move(-42); // clear the cannon barrel
            philipTime = 0;
        }
    }

    /**
     * FIXME: write down what your vector rotation will be
     */
    private void camilleFire() {
        AWorld world = (AWorld) getWorld();
        List <Projectile_3> ca =world.getObjects(Projectile_3.class);
        List <Projectile_3End> ca2 =world.getObjects(Projectile_3End.class);
        if (Greenfoot.isKeyDown("a")&& camilleTime >=100 && ca.size()==0 && ca2.size()==0){
            int angle = world.getCAR(); // adjust angle for image

            
            Projectile_3 ball = new Projectile_3(new Vector(angle, 9));
            getWorld().addObject(ball, world.getCamilleX(), world.getCamilleY());
            ball.setRotation(angle);
            ball.move(42); // clear the cannon barrel
            camilleTime = 0;
        }
    }

    /**
     * FIXME: write down what your vector rotation will be
     */
    private void tylerFire() {
        AWorld world = (AWorld) getWorld();
        List <Projectile_4> t =world.getObjects(Projectile_4.class);
        List <Projectile_4End> t2 =world.getObjects(Projectile_4End.class);
        if (Greenfoot.isKeyDown("w")&& camilleTime >=100 && t.size()==0 && t2.size()==0) {
            int angle = world.getTR(); // adjust angle for image

            
            Projectile_4 ball = new Projectile_4(new Vector(angle, 9));
            getWorld().addObject(ball, world.getTylerX(), world.getTylerY());
            ball.setRotation(angle);
            ball.move(-42); // clear the cannon barrel
            tylerTime = 0;
        }
    }

    /**
     * Resets the all the times when it reaches 100
     */
    private void resetTime() {
        if (chandlerTime >=1000) {
            chandlerTime = 1000;
        }

        if (philipTime >=100) {
            philipTime = 100;
        }

        if (camilleTime >= 100) {
            camilleTime = 100;
        }

        if (tylerTime >=100) {
            tylerTime = 100;
        }
    }

    /**
     * Act - do whatever the Projector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        chandlerTime++;
        philipTime++;
        camilleTime++;
        tylerTime++;

        resetTime();

        
            chandlerFire();
        
            philipFire();
        
            camilleFire();
        
            tylerFire();
        }
    }



