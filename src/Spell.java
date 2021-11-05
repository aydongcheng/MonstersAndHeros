public class Spell extends Merchandise{
    public Spell(){}

    public Spell(String name, int price, int minLevel, int damage, int manaCost){
        super(name, minLevel, price, "Spell");
        setDamage(damage);
        setManaCost(manaCost);
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    private void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    private int damage;
    private int manaCost;
}
