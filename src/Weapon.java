public class Weapon extends  Merchandise{
    public Weapon(){}

    public Weapon(String name, int price, int minLevel, int damage){
        super(name, minLevel, price, "Weapon");
        setDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    private int damage;
}
