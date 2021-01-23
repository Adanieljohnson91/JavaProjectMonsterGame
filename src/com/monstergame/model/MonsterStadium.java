package com.monstergame.model;

import com.monstergame.utils.advancedlogic.MonsterStrengthAndWeaknessWeight;

/**
 *Monster Stadium, this is where contestants do battle.
 */

public class MonsterStadium {
    private final StadiumType stadiumType;
    private int rounds;
    private int round = 1;
    private final MonsterStrengthAndWeaknessWeight modiMonsters = new MonsterStrengthAndWeaknessWeight();
    public MonsterStadium(StadiumType stadiumType, int rounds){
        this.stadiumType = stadiumType;
        this.rounds = Math.max(rounds, 1);
    }

    public void doBattle(MonsterGlossary m1, MonsterGlossary m2){
           modiMonsters.determineEffects(m1,m2);
           System.out.println("~~~~~~~~~~~~~~~~START ROUNDS~~~~~~~~~~~~~~~~");
           while(true){
               m1.attack(m2);
               if(!m2.getIsAlive())break;
               m2.attack(m1);
               if(!m1.getIsAlive())break;
           }
           System.out.println(m1.getIsAlive() ? m1.getName() : m2.getName() + " WINS Round: " + round);
           if(m1.getIsAlive()){
               m1.addExperience(m2.getLevel());
           }else{
               m2.addExperience(m1.getLevel());
           }
           if(rounds >=1){
               System.out.println("~~~~~~~~~~~~~~~~~~~~~~ROUNDS: " + rounds);
               Monster.riseFromTheDead(m1,m2);
               rounds--;
               round++;
               doBattle(m2,m1);
           }
    }

}



