package com.monstergame.model;

import org.jetbrains.annotations.NotNull;

public class MonsterGoblin extends Monster{
    private final double DEFAULT_HEALTH = 42;
    private final double RAND = (Math.random() + 1);
    private final double DEFAULT_STRENGTH = 2;
    private final double DEFAULT_INTELLECT = 2;
    private final double DEFAULT_SPEED = 2;
    private final MonsterTypes GOBLIN_TYPE = MonsterTypes.GOBLIN;
    private final String GOBLIN_NAME = "Goblin";

    public MonsterGoblin(int level){
        this.setName(GOBLIN_NAME);
        this.setHealth(DEFAULT_HEALTH + level * RAND);
        this.setFullHealth(this.getHealth());
        this.setStrength(DEFAULT_STRENGTH * level);
        this.setIntellect(DEFAULT_INTELLECT * level);
        this.setSpeed(DEFAULT_SPEED * level);
        this.setLevel(level);
        this.setType(GOBLIN_TYPE);
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
        boolean dodged = luckyDodge();
        if(dodged){
            System.out.println(getName() + " Dodged the Attack");
            return 999;
        }
        return defence;
    }

    private boolean luckyDodge(){
        double randomNumber = Math.random();
        return (randomNumber > 0.79);
    }
}
