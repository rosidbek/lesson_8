package kg.geeks.game.players;

public class King extends Hero {
    private boolean hasSummonedSaitama = false;

    public King (String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAITAMA_WRATH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean hasSummonedSaitama = false;
        if (!hasSummonedSaitama && Math.random() < 0.1) {
            System.out.println("Король призвал Сайтаму! Босс побежден мгновенно!");
            boss.setHealth(0);
            hasSummonedSaitama = true;
        }
    }

    }

