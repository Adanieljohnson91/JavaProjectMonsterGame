package com.monstergame.model;

import org.jetbrains.annotations.NotNull;

class MonsterDraco extends Monster {
    private final double DEFAULT_HEALTH = 57;
    private final double RAND = (Math.random() + 1);
    private final double DEFAULT_STRENGTH = 3;
    private final double DEFAULT_INTELLECT = 1;
    private final double DEFAULT_SPEED = 1;
    private final MonsterTypes DRACO_TYPE = MonsterTypes.DRAGONOID;
    private final String DRACO_NAME = "Draco";
    private final int DRAKO_SPECIAL_DAMAGE = 999;

    public MonsterDraco(int level){
        this.setName(DRACO_NAME);
        this.setHealth(DEFAULT_HEALTH + level * RAND);
        this.setFullHealth(this.getHealth());
        this.setStrength(DEFAULT_STRENGTH * level);
        this.setIntellect(DEFAULT_INTELLECT * level);
        this.setSpeed(DEFAULT_SPEED * level);
        this.setLevel(level);
        this.setType(DRACO_TYPE);
    }

    public static Monster SUPERCHARGED_DRACO(){

        return new SuperCharge(new MonsterDraco(19));
    }
    public static Monster DRACO(){
        return new MonsterDraco(11);
    }

    /**
     * Need to ask myself how i can modularize this method.
     * @param enemy is the opposing Monster when monsters do battle. attack should call the
     *              enemies takeDamage method.
     */
    public void attack(@NotNull Monster enemy){
        int minDamage = 0;
        int trueStrength = (int)this.getStrength();
        int attackDmg;
        if(Math.random() > 0.92){
            System.out.println("WAKKA FLACKAA FLAME THEORY!!!!");
            attackDmg = flameTheory(enemy.getType(), trueStrength);
        }else{
            attackDmg = this.getLevel() * ((this.ran.nextInt(1) + 1) * trueStrength);
        }
        int damageDone = attackDmg - enemy.defend();
        if(damageDone < minDamage){
            System.out.println(this.getName() + " Hits for zero");
            enemy.takeDamage(minDamage);
            return;
        }
        System.out.println(this.getName() + " hit for " + Math.abs(damageDone));
        enemy.takeDamage(Math.abs(damageDone));
    }

    public int defend(){
        int trueSpeed = (int)this.getSpeed();
        int defence = this.getLevel() * (ran.nextInt(2) * trueSpeed);
        return defence;
    }

    private int flameTheory(MonsterTypes monsterTypes, int trueStrength){
        switch (monsterTypes){
            case HYDRADON:
                System.out.println("Flame Theory has no effect!");
                return 0;
            case DRAGONOID:
                System.out.println("Flame Theory has no extra effect on fellow Dragonoid!");
                return this.getLevel() * ((this.ran.nextInt(1) + 1) * trueStrength);
            default:
                return DRAKO_SPECIAL_DAMAGE;
        }
    }
}

