package kg.geeks.game.players;

import java.util.Random;

public class Ludoman extends Hero{
    private Random random = new Random();

    public Ludoman (String name, int health, int damage) {
        super(name, health, damage, SuperAbility.DICE_STRIKE);
    }




    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }

    public void useSuperAbility(Hero boss) {
        int die1 = rollDie();
        int die2 = rollDie();

        System.out.println("Лудоман бросает две игральные кости: " + die1 + " и " + die2);

        if (die1 == die2) {
            int damageToBoss = die1 * die2;
            System.out.println("Выпали одинаковые числа! Лудоман отнимает " + damageToBoss + " здоровья у босса.");
            boss.takeDamage(damageToBoss);
        } else {
            int damageToTeammate = die1 + die2;
            Hero randomTeammate = getRandomTeammate();
            System.out.println("Выпали разные числа. Лудоман отнимает " + damageToTeammate + " здоровья у " + randomTeammate.getName() + ".");
            randomTeammate.takeDamage(damageToTeammate);
        }
    }

    private int rollDie() {
        return random.nextInt(6) + 1;
    }

    private Hero getRandomTeammate() {

        return null;
    }


}







