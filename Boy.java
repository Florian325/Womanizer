import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

class BoyGettersAndSetters extends Actor {
    private int score = 0;
    private int acts = 0;
    private Girl girl;

    public int getScore() {
        return score;
    }

    public void setScore(int s) {
        score = s;
    }

    public void increaseScoreBy(int s) {
        score = score + s;
    }

    public int getActs() {
        return acts;
    }

    public void setActs(int a) {
        acts = a;
    }

    public void increaseActsBy(int a) {
        acts = acts + a;
    }

    public void resetActs() {
        setActs(0);
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl g) {
        girl = g;
    }
}

public class Boy extends BoyGettersAndSetters {
    public void act() {
        updateGirlPosition();
        updatePosition();
    }

    private void onHamburgerCollision() {
        Actor hamburger = getOneObjectAtOffset(0, 0, Hamburger.class);
        if (hamburger != null) {
            getWorld().removeObject(hamburger);
            increaseScoreBy(100);
        }
    }

    private void spawnHamburger() {
        if (Greenfoot.getRandomNumber(100) < 5) {
            getWorld().addObject(new Hamburger(), Greenfoot.getRandomNumber(10), Greenfoot.getRandomNumber(8));
        }
    }

    private void notifyHamburgersOnAct() {
        getWorld().getObjects(Hamburger.class).forEach(hamburger -> {
            hamburger.onNewActStep();
        });
    }

    private void onGirlCollision() {
        Girl g = (Girl) getOneObjectAtOffset(0, 0, Girl.class);

        if (g != null) {
            setGirl(g);
            resetActs();
        } else {
            increaseActsBy(1);
        }
    }

    private void updateGirlPosition() {
        if (getGirl() != null) {
            getGirl().setLocation(getX(), getY());
        }
    }

    private void checkForGameOver() {
        if (getActs() == 20) {
            Greenfoot.stop();
            getWorld().showText("Game Over || Punkte: " + getScore(), 5, 4);
        }
    }

    private void onPositionUpdate() {
        increaseScoreBy(1);
        onHamburgerCollision();
        spawnHamburger();
        notifyHamburgersOnAct();
        onGirlCollision();
        checkForGameOver();
    }

    private void updatePosition() {
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 1, getY());
            onPositionUpdate();
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 1, getY());
            onPositionUpdate();
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 1);
            onPositionUpdate();
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 1);
            onPositionUpdate();
        }
    }
}
