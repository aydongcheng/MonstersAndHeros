public class Armor extends Merchandise{
    public Armor(){}

    public Armor(String name, int price, int minLevel, int damageReduction){
        super(name, minLevel, price, "Weapon");
        setDamageReduction(damageReduction);
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    private void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    private int damageReduction;
}
