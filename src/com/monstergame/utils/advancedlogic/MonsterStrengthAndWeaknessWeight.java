package com.monstergame.utils.advancedlogic;

import com.monstergame.model.MonsterGlossary;
import com.monstergame.model.MonsterTypes;

import java.util.*;



public class MonsterStrengthAndWeaknessWeight {
    private final EnumMap<MonsterTypes, Double> zombieStats = new EnumMap<MonsterTypes, Double>(MonsterTypes.class) {};
    private final EnumMap<MonsterTypes, Double> dragonoidStats = new EnumMap<MonsterTypes, Double>(MonsterTypes.class) {};
    private final EnumMap<MonsterTypes, Double> hydragonStats = new EnumMap<MonsterTypes, Double>(MonsterTypes.class) {};
    private final EnumMap<MonsterTypes, Double> elderStats = new EnumMap<MonsterTypes, Double>(MonsterTypes.class) {};
    private final EnumMap<MonsterTypes, Double> fiindinStats = new EnumMap<MonsterTypes, Double>(MonsterTypes.class) {};
    private final EnumMap<MonsterTypes, Double> scepterStats = new EnumMap<MonsterTypes, Double>(MonsterTypes.class) {};

    private final double EFFECTIVE_MULTIPLIER = 2;
    private final double NOT_VERY_EFFECTIVE = 0.75;
    private final double NOT_EFFECTIVE = 0;
    public MonsterStrengthAndWeaknessWeight(){
        loadAllStats();
    }

    /**
     * the determine effects method takes in two monsters and compares their types it will alter their strength
     * and defense based on their TYPES.
     *
     * I played around with a few different ideas to implement this feature. I could of turned each Monster Class into
     * its own type and added checks within the class, but for time and learning, i chose to add effects by building
     * unique methods for each type.
     */
    public void determineEffects(MonsterGlossary m1, MonsterGlossary m2){
        checkType(m1, m2.getType());
        checkType(m2, m1.getType());
    }
    private void checkType(MonsterGlossary m1, MonsterTypes enemyType){
        switch (m1.getType()){
            case ELDER:
                checkElder(m1,enemyType);
                break;
            case ZOMBIE:
                checkZombie(m1,enemyType);
                break;
            case FIINDIN:
                checkFiidin(m1,enemyType);
                break;
            case SCEPTER:
                checkScepter(m1,enemyType);
                break;
            case HYDRADON:
                checkHydradon(m1,enemyType);
                break;
            case DRAGONOID:
                checkDraconoid(m1,enemyType);
                break;
            default:
                System.out.println("Nothing to do, Type is possible invalid");
                break;
        }
    }

    /**
     * check[MonsterType] methods are used to check what should be dont to monsters
     * strength stat with regards to its enemy's type.
     * @param m1 Main monster
     * @param enemyType Enum
     */
    private void checkElder(MonsterGlossary m1, MonsterTypes enemyType){
        if(elderStats.containsKey(enemyType)){
            m1.setStrength(m1.getStrength() * elderStats.get(enemyType));
        }
    }
    private void checkZombie(MonsterGlossary m1, MonsterTypes enemyType){
        if(zombieStats.containsKey(enemyType)){
            m1.setStrength(m1.getStrength() * zombieStats.get(enemyType));
        }
    }
    private void checkFiidin(MonsterGlossary m1, MonsterTypes enemyType){
        if(fiindinStats.containsKey(enemyType)){
            m1.setStrength(m1.getStrength() * fiindinStats.get(enemyType));
        }
    }
    private void checkScepter(MonsterGlossary m1, MonsterTypes enemyType){
        if(scepterStats.containsKey(enemyType)){
            m1.setStrength(m1.getStrength() * scepterStats.get(enemyType));
        }
    }
    private void checkHydradon(MonsterGlossary m1, MonsterTypes enemyType){
        if(hydragonStats.containsKey(enemyType)){
            m1.setStrength(m1.getStrength() * hydragonStats.get(enemyType));
        }
    }
    private void checkDraconoid(MonsterGlossary m1, MonsterTypes enemyType){
        if(dragonoidStats.containsKey(enemyType)){
            m1.setStrength(m1.getStrength() * dragonoidStats.get(enemyType));
        }
    }

    /**
     * Loading methods load strengths and weaknesses into our EnumMaps the describe
     * a monsters strengths and weaknesses
     */
    private void loadAllStats(){
        loadFiidinStats();
        loadZombieStats();
    }
    private void loadZombieStats(){
        zombieStats.put(MonsterTypes.ELDER, EFFECTIVE_MULTIPLIER);
        zombieStats.put(MonsterTypes.DRAGONOID, NOT_VERY_EFFECTIVE);
        zombieStats.put(MonsterTypes.FIINDIN, NOT_EFFECTIVE);
    }
    private  void loadFiidinStats(){
        fiindinStats.put(MonsterTypes.ZOMBIE, EFFECTIVE_MULTIPLIER);
        fiindinStats.put(MonsterTypes.HYDRADON, NOT_VERY_EFFECTIVE);
        fiindinStats.put(MonsterTypes.SCEPTER, NOT_EFFECTIVE);
    }
    private void loadElderStats(){
        elderStats.put(MonsterTypes.SCEPTER, EFFECTIVE_MULTIPLIER);
        elderStats.put(MonsterTypes.HYDRADON, NOT_VERY_EFFECTIVE);
        elderStats.put(MonsterTypes.ZOMBIE, NOT_VERY_EFFECTIVE);
    }
}
