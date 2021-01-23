package com.monstergame.model;

import com.monstergame.images.MonsterImages;

/**
 * Monster Types started to be specifically for Monster Models, but was later built out to
 * include the types of all Monster subclasses excluding the supercharge boss class which is
 * a wrapper to enhance monsters.
 *
 * We have also shown the use of enum construction. Enums are classes and so have access to
 * a constructors, i chose to use a function to play with the Function type.
 *
 *
 */


public enum MonsterTypes {
    ZOMBIE("ZOMBIE IMAGE", "Zombie... UuUuuuUughuu"),
    DRAGONOID(MonsterImages.DRAGONOID_IMAGE, "Dragonoid in the House"),
    HYDRADON("HYDRADON IMAGE", "Hydra!!!"),
    ELDER("ELDER IMAGE", "There is no beginning without your end..."),
    FIINDIN("FIIDIN IMAGE", "Crushhhhh"),
    SCEPTER("SCEPTER IMAGE", "........"),
    GOBLIN("GOBLIN IMAGE", "Wez iz her fur ye neck"),
    FLAN("FLAN IMAGE", "Bloop bloop blo");

//  public Function<Monster, Void> specialMove;
    private String image;
    private String intro;


    MonsterTypes(String asciImage, String intro){
        this.image = asciImage;
        this.intro = intro;
    }

    public String getImage() {
        return image;
    }

    public String getIntro() {
        return intro;
    }

    public void specialMove(Monster enemy) {
        /**
         * TODO: Add special move method to be used inside of monster types
         *
         */
    }
}
