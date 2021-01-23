package com.monstergame.model;

import org.jetbrains.annotations.NotNull;

public class MonsterFlan extends Monster{

    private final double DEFAULT_HEALTH = 22;
    private final double RAND = (Math.random() + 1);
    private final double DEFAULT_STRENGTH = 1;
    private final double DEFAULT_INTELLECT = 1;
    private final double DEFAULT_SPEED = 25;
    private final MonsterTypes FLAN_TYPE = MonsterTypes.FLAN;
    private final String FLAN_NAME = "Flanny";
    private final int FLAN_SPECIAL_DEFENCE = 25;

    public MonsterFlan(int level){
        this.setName(FLAN_NAME);
        this.setHealth(DEFAULT_HEALTH + level * RAND);
        this.setFullHealth(this.getHealth());
        this.setStrength(DEFAULT_STRENGTH * level);
        this.setIntellect(DEFAULT_INTELLECT * level);
        this.setSpeed(DEFAULT_SPEED * level);
        this.setLevel(level);
        this.setType(FLAN_TYPE);

    }

    public void attack(@NotNull Monster enemy){
        int minDamage = 0;
        System.out.println(this.getName() + " Hits with Pumpkin Smash");
        int trueStrength = (int)this.getStrength();
        int attackDmg = this.getLevel() * ((this.ran.nextInt(1) + 1) * trueStrength);
        int damageDone = attackDmg - enemy.defend();
        if(damageDone < minDamage){
            enemy.takeDamage(minDamage);
            return;
        }
        System.out.println(this.getName() + " hit for " + Math.abs(damageDone));
        enemy.takeDamage(Math.abs(damageDone));
    }

    public int defend(){
        int trueSpeed = (int)this.getSpeed();
        int defence = this.getLevel() * (ran.nextInt(2) * trueSpeed);

        if(true){
            System.out.println(getName() + " Dodged the Attack");
            return FLAN_SPECIAL_DEFENCE;
        }
        return defence;
    }
}
