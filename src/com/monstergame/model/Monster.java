package com.monstergame.model;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

/**
 * Monster Class:
 * This class describes a monster and its abilities, in the future we will
 */

class Monster {
    private final int DEFAULT_LEVEL = 1;
    private final double DEFAULT_INTELLIGENCE = 1;
    private final double DEFAULT_SPEED = 1;
    private final double DEFAULT_STRENGTH = 1;
    private final int DEFAULT_EXPERIENCE_NEEDED_NEXT_LEVEL = 20;
    private final boolean DEFAULT_ALIVE = true;
    private final boolean DEFAULT_DEAD = false;
    private final int DEFAULT_ZERO_HEALTH = 0;
    private final int MAX_VAL_ALL = 999;
    private final int MIN_VAL_ALL = 0;

    /**
     * Stats can be swapped with ints. will watch development.
     */
    private int age;
    private ElementTypes element;
    private int experience;
    private int experienceToNextLevel;
    private double fullHealth;
    private double health;
    private double intellect;
    private boolean isAlive;
    private int level;
    private String name;
    private double speed;
    private double strength;
    private MonsterTypes type;
    public Random ran = new Random();

    Monster(){
        setIntellect(DEFAULT_INTELLIGENCE);
        setLevel(DEFAULT_LEVEL);
        setStrength(DEFAULT_STRENGTH);
        setSpeed(DEFAULT_SPEED);
        setExperienceToNextLevel(DEFAULT_EXPERIENCE_NEEDED_NEXT_LEVEL);
        setAlive(DEFAULT_ALIVE);
    }

    public Monster(int age,
                   ElementTypes element,
                   double health,
                   String name,
                   MonsterTypes type){
        this();
        setAge(age);
        setElement(element);
        setHealth(health);
        setFullHealth(health);
        setName(name);
        setType(type);
        //CheckFields.checkFields(this);
    }


    public void setAge(int age) {
        if(age > MAX_VAL_ALL || age < MIN_VAL_ALL){
            System.out.println("Error Invalid age set;");
            this.age = MIN_VAL_ALL;
            return;
        }
        this.age = age;
    }

    public void setElement(ElementTypes element) {
        this.element = element;
    }

    public void setFullHealth(double fullHealth) {
        this.fullHealth = fullHealth;
    }

    public void setExperienceToNextLevel(int experienceToNextLevel) {
        this.experienceToNextLevel = experienceToNextLevel;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void calculateExperience(){
        experienceToNextLevel += experience * level;
    }

    public void setHealth(double health) {
        if(health > MAX_VAL_ALL){
            System.out.println("Error: Health must be between 0 and 999");
            return;
        }
        this.health = health;
    }

    private boolean checkRange(int num){
        return(num <= 999 || num >= 0) ? true : false;
    }
    private boolean checkRange(double num){
        return(num <= 999 || num >= 0) ? true : false;
    }

    public void setName(String name) {
        int maxStringLength  = 35;
        if(name.length() > maxStringLength){
            System.out.println("Error: Name is too long, must be under 35 characters");
            this.name = "Incredibly long Name";
            return;
        }
        this.name = name;
    }

    /**
     * User Math.abs() throughout setMethods, the only check in range is above zero.
     *
     */
    public void setType(MonsterTypes type) {
        this.type = type;
    }

    public void setIntellect(double intellect) {
       if(checkRange(intellect)){
           this.intellect = intellect;
           return;
       }
       System.out.println("Error: intellect is out of range, setting to default -> 1");
        this.intellect = 1;
    }

    public void setLevel(int level) {
        if (checkRange(level)){
            this.level = level;
            return;
        }
        this.level = !(this.level == 0) ? this.level : 1;
    }

    public void setSpeed(double speed) {
        this.speed = Math.abs(speed);

    }

    public void setStrength(double strength) {
        this.strength = Math.abs(strength);
    }

    public double getHealth() {
        return health;
    }

    public double getIntellect() {
        return intellect;
    }

    public double getSpeed() {
        return speed;
    }

    public double getStrength() {
        return strength;
    }

    public ElementTypes getElement() {
        return element;
    }

    public int getAge() {
        return age;
    }

    public int getLevel() {
        return level;
    }

    public MonsterTypes getType() {
        return type;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public String getName(){
        return name;
    }

    private double getFullHealth() {
        return fullHealth;
    }

    public void attack(@NotNull Monster enemy){
        int trueStrength = (int)this.strength;
        int attackDmg = level * (ran.nextInt(5) * trueStrength);
        int damageDone = attackDmg - enemy.defend();
        if(damageDone < 0){
            enemy.takeDamage(0);
            System.out.println(name+ " hit for zero damage");
            return;
        }
        System.out.println(name+ " hit for " + damageDone);
        enemy.takeDamage(Math.abs(damageDone));
    }
    public void special(Monster enemy){
        if(ran.nextInt(100) < (this.speed * this.strength)){
            this.type.specialMove(enemy);
        }
    }

    public static void riseFromTheDead(Monster monster1, Monster monster2){
        monster1.isAlive = true;
        monster2.isAlive = true;
        monster1.setHealth(monster1.getFullHealth());
        monster2.setHealth(monster2.getFullHealth());
    }

    public void takeDamage(int damage){
        setHealth(health - damage);
        checkHealth();
    }

    public void checkHealth(){
        if(health > DEFAULT_ZERO_HEALTH){
            System.out.println(name + "'s HEALTH: " + health);
            return;
        }
        System.out.println(name + " Has fallen!!~~~~~~~~~~~~~~~~~~~~~~~~`");
        setAlive(DEFAULT_DEAD);
    }

    public int defend(){
        int trueSpeed = (int)this.speed;
        return level * (ran.nextInt(2) * trueSpeed);
    }

    public void levelUp(){
        setLevel(level+1);
        increaseStats();
        calculateExperience();
    }

    private void increaseStats(){
        this.speed += (ran.nextInt(1) + 1) * level;
        this.fullHealth += Math.abs((ran.nextInt(1) +1) * level);
        this.strength += (ran.nextInt(1)+1) * level;
        this.intellect += (ran.nextInt(1) +1) * level;
    }

    public void addExperience(int enemyLevel){
        experience += enemyLevel * 10;
        while((experience >= experienceToNextLevel)){
            System.out.println(name + "Leveled up to level " + (level + 1));
            levelUp();
        }
    }

    public String toString(){
        return new StringBuilder()
                .append("Name: "+ name)
                .append("Full Health: "+ fullHealth)
                .append("Experience: "+experience)
                .append("Experience To Next Level: "+experienceToNextLevel)
                .append("Strength: "+strength)
                .append("Speed: "+speed)
                .append("Intellect: "+intellect)
                .append("Alive: "+isAlive)
                .toString();
    }
}



