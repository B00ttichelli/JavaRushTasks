package com.javarush.task.task13.task1328;

public abstract class  AbstractRobot implements Attackable,Defensable {
    private static int hitCount;

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 0) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 1) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {

            attackedBodyPart = BodyPart.LEG;
        } else if(hitCount==3){
            hitCount = 0;
            attackedBodyPart = BodyPart.CHEST;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount +1;

        if (hitCount == 0) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 1) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 2) {

            defendedBodyPart = BodyPart.ARM;
        } else if(hitCount==3){
            hitCount = 0;
            defendedBodyPart = BodyPart.CHEST;
        }
        return defendedBodyPart;
    }
    public abstract  String getName();
}
