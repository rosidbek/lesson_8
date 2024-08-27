package kg.geeks.game.players;

public class Hacker extends Hero{
    private int roundCounter = 0;
    private int stealAmount = 50;

    public Hacker (String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CODE_BREACH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        roundCounter++;
        if (roundCounter % 2 == 0) {
            Hero targetHero = getRandomHero(heroes);
            if (targetHero != null) {
                System.out.println("Hacker крадет " + stealAmount + " здоровье у босса и передает его " + targetHero.getName() + ".");
                boss.takeDamage(stealAmount);
                targetHero.heal(stealAmount);
            }
        }
    }

    private Hero getRandomHero(Hero[] heroes){
        if (heroes.length > 0) {
            int randomIndex = (int) (Math.random() * heroes.length);
            return heroes[randomIndex];
        }
        return null;
    }

}