package com.monstergame.client;

import com.monstergame.model.MonsterGlossary;
import com.monstergame.prebuiltmonster.DefaultStadiums;
import com.monstergame.model.*;

/**
 * Monster Client: Main Client used to run the monster class and affiliates
 *
 */

class MonsterClient {
    public static void main(String[] args) {
        try {
            MonsterGlossary player1 = MonsterGlossary.commenceCreation(args);
            banginAssBattleIntro(player1);
            System.out.println(player1);//toString is called by default by Objects?
            DefaultStadiums.Thunderdome.doBattle(MonsterGlossary.BACA(), player1);
        }catch (Exception ex){
            System.out.println("ERROR UNABLE TO RUN APPLICATION");
            ex.printStackTrace();
        }

    }



    public static void banginAssBattleIntro(MonsterGlossary monster){
                System.out.print(monster.getType().getIntro()+ "\n" + monster.getType().getImage());
    }

}