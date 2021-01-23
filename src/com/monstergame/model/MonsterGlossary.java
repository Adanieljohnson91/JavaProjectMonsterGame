package com.monstergame.model;

public class MonsterGlossary extends Monster{

    MonsterGlossary(Monster monster){
        this.setAge(monster.getAge());
        this.setHealth(monster.getHealth());
        this.setFullHealth(monster.getHealth());
        this.setName(monster.getName());
        this.setType(monster.getType());
    }
    public static MonsterGlossary DRACO(int level){
        return new MonsterGlossary(new MonsterDraco(level));
    };
    public static MonsterGlossary GOBLIN(int level){
        return new MonsterGlossary(new MonsterGoblin(level));
    }
    public static MonsterGlossary FLAN(int level){
        return new MonsterGlossary(new MonsterFlan(level));
    }
    public static MonsterGlossary THE_ULTIMATE(int level, String name){
        return new MonsterGlossary( new SuperCharge( new Monster(98, ElementTypes.EARTH, 19, name, MonsterTypes.ELDER)));
    }
    public static MonsterGlossary DRAKOR(){
        return new MonsterGlossary(new Monster(34, ElementTypes.FIRE, 17, "Drakor", MonsterTypes.DRAGONOID));
    }
    public static MonsterGlossary FISALA(){
        return new MonsterGlossary(new Monster(321, ElementTypes.HEART, 16, "Fisala", MonsterTypes.FIINDIN));
    }
    public static MonsterGlossary GROOT(){
        return new MonsterGlossary(new Monster(2, ElementTypes.EARTH, 20, "Groot", MonsterTypes.ZOMBIE));
    }
    public static MonsterGlossary TRON(){
        return new MonsterGlossary(new Monster(52, ElementTypes.FIRE, 18, "Tron", MonsterTypes.SCEPTER));
    }
    public static MonsterGlossary HELEN(){
        return new MonsterGlossary(new Monster(24, ElementTypes.WATER, 16, "Helen", MonsterTypes.HYDRADON));
    }
    public static MonsterGlossary BACA(){
        return new MonsterGlossary(new Monster(12, ElementTypes.WIND, 19, "Baaka", MonsterTypes.ELDER));
    }

    public static MonsterGlossary commenceCreation(String[] args){
        /**
         * We can definitely think this out more, this is a good skeleton though.
         */
        try{
            switch (args.length){
                case 5:
                    return new MonsterGlossary(new Monster(
                            Integer.parseInt(args[0]),
                            ElementTypes.valueOf(args[1].toUpperCase()),
                            Double.parseDouble(args[2]),
                            args[3],
                            MonsterTypes.valueOf(args[4])));
                default:
                    return MonsterGlossary.GOBLIN(11);
            }
        }catch (Exception ex){
            System.out.println("Invalid entries, no worries though, we got you:");
            ex.printStackTrace();
            return MonsterGlossary.DRACO(11);

        }

    }
}
