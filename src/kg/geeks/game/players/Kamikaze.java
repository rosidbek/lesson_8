package kg.geeks.game.players;

public class Kamikaze extends Hero{
    public Kamikaze (String name, int health, int damage) {
        super(name, health, damage, SuperAbility.FINNAL_SACRIFICE);
    }
        @Override
        public void applySuperPower(Boss boss, Hero[] heroes) {
            int damage = (Math.random() < 0.5) ? this.getHealth() : this.getHealth() / 2;
            System.out.println("Камикадзе жертвует собой и наносит " + damage + " урона боссу");
            if (boss != null) {
                boss.takeDamage(damage);
            }
            this.setHealth(0);
        }


}
