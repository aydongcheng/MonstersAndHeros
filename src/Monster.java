import java.util.Random;

public class Monster implements Fightable{
    public Monster(){}

    public Monster(String name, int initLevel, int damage, int defense, int dodgeChance){
        setName(name);
        setInitLevel(initLevel);
        setDamage(damage);
        setDefense(defense);
        setDodgeChance(dodgeChance);
        setHp(initLevel*100);
        setFaint(false);
    }

    @Override
    public int attack() {
        return getDamage();
    }

    @Override
    public int getHurt(int damage) {
        Random r = new Random();
        int i = r.nextInt(100);

        if(i <= Math.ceil(getDodgeChance()*0.01))
            return 0;

        int actualDamage = Math.max(damage - getDefense(), 0);

        if(getHp() <= actualDamage) {
            actualDamage = getHp();
            setFaint(true);
            setHp(0);
        }
        else
            setHp(getHp()-actualDamage);

        return actualDamage;
    }

    public int getInitLevel() {
        return initLevel;
    }

    private void setInitLevel(int initLevel) {
        this.initLevel = initLevel;
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    private void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isFaint() {
        return isFaint;
    }

    private void setFaint(boolean faint) {
        isFaint = faint;
    }

    private boolean isFaint;
    private int hp;
    private String name;
    private int initLevel;
    private int damage;
    private int defense;
    private int dodgeChance;
}
