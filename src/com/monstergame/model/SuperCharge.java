package com.monstergame.model;

public class SuperCharge extends Monster {

    private int powerUpMultiplier = 10;

    public SuperCharge(Monster monster){
        super(monster.getAge(), monster.getElement(), monster.getHealth(), monster.getName(), monster.getType());
        superCharge();
    }
    private void superCharge(){
        this.setHealth(this.getHealth() * powerUpMultiplier);
        this.setStrength(this.getStrength() * powerUpMultiplier);
        this.setSpeed(this.getSpeed() * powerUpMultiplier);
        this.setIntellect(this.getIntellect() * powerUpMultiplier);
    }
    public void destroy(){
        System.out.println(getName()+ " goes into a rage!!!");
    }


}
