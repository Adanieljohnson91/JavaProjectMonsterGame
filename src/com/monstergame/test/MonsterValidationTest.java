package com.monstergame.test;

import com.monstergame.model.MonsterGlossary;

/**
 * Validation Class is used to test different inputs.
 *
 */


class MonsterValidationTest {
    public static void main(String[] args) {
        String[] testArray1 = {"44", "fire", "67", "Killer", "DRAGONOID"};
        String[] testArray2 = {"888888", "fire", "67", "Killer", "DRAGONOID"};
        String[] testArray3 = {"8888999", "fi8re", "67", "Killer", "DRAGONOID"};
        String[] testArray4 = {"5676575675", "fi6re", "6667", "Killer", "DRAGONOID"};
        String[] testArray5 = {
                "44",
                "fire",
                "67",
                "Ki6756666666666666666666666666666666666666666666666666666666666777777777777777777777777777ller",
                "DRAGONOID"
        };
        String[] testArray6 = {
                "4sdfsdf4",
                "fsdfdsire",
                "6fsdfsd7",
                "Killedssfsdfsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddr",
                "DRAGOsdafsdfNOID"
        };

        System.out.println(MonsterGlossary.GOBLIN(11));
        MonsterGlossary mon1 = MonsterGlossary.commenceCreation(testArray1);
        MonsterGlossary mon2 =MonsterGlossary.commenceCreation(testArray2);
        MonsterGlossary mon3 =MonsterGlossary.commenceCreation(testArray3);
        MonsterGlossary mon4 =MonsterGlossary.commenceCreation(testArray4);
        MonsterGlossary mon5 =MonsterGlossary.commenceCreation(testArray5);
        System.out.println(mon1);
        System.out.println(mon2);
        System.out.println(mon3);
        System.out.println(mon4);
        System.out.println(mon5);

    }
}
