import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hamburger extends Actor {
    private int acts = 0;
    private int actLives = 20;

    public int getActs() {
        return acts;
    }

    public void setActs(int a) {
        acts = a;
    }

    public void increaseActsBy(int a) {
        acts = acts + a;
    }

    public void onNewActStep() {
        increaseActsBy(1);
        if (getActs() == actLives) {
            getWorld().removeObject(this);
        }
    }
}
