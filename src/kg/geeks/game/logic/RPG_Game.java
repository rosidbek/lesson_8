package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Vurdalak", 1000, 50);
        Warrior warrior1 = new Warrior("Volt", 290, 10);
        Warrior warrior2 = new Warrior("Darius", 280, 15);
        Magic magic = new Magic("Terran", 270, 20);
        Berserk berserk = new Berserk("Viking", 240, 10);
        Medic doc = new Medic("Enstein", 200, 5, 15);
        Medic assistant = new Medic("Green", 300, 5, 5);
        King king = new King("Maximus", 200, 0);
        Kamikaze kamikaze = new Kamikaze("Katsumoto", 195,0);
        Hacker hacker = new Hacker("Neo", 150, 0);
        Ludoman ludoman = new Ludoman("Jhon", 150, 0);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, king, kamikaze,hacker, ludoman};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }



    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ---------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}