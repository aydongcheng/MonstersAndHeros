public class LightningSpell extends Spell{
    public LightningSpell(){}

    public LightningSpell(String name, int price, int minLevel, int damage, int manaCost){
        super(name,price,minLevel,damage,manaCost);
        setSpecil("reduce 10% e dodge chance");
    }

    public LightningSpell(String[] data) {
        super(data);
        setSpecil("reduce 10% e dodge chance");
    }

    @Override
    protected void specialEffect(Monster monster) {
        monster.setDodgeChance((int) Math.ceil(monster.getDodgeChance()*0.9));
    }
}
