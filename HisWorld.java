import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HisWorld extends World {
    public HisWorld() {
        super(10, 8, 50);

        prepare();
    }

    private void prepare() {
        Boy boy = new Boy();
        addObject(boy, 4, 3);
        Girl girl = new Girl(1);
        addObject(girl, 2, 1);
        Girl girl2 = new Girl(2);
        addObject(girl2, 3, 7);
        Girl girl3 = new Girl(3);
        addObject(girl3, 8, 5);
        Girl girl4 = new Girl(4);
        addObject(girl4, 8, 2);
    }
}
