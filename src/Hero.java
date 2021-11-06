import java.util.ArrayList;
import java.util.Random;

public class Hero implements Fightable{
    public Hero(){}

    public Hero(String name, int mana, int strength, int agility, int dexterity, int startingMoney, int startingExp){
        setName(name);
        setMana(mana);
        setStrength(strength);
        setAgility(agility);
        setDexterity(dexterity);
        setStartingMoney(startingMoney);
        setStartingExp(startingExp);
        setExp(100);
        setLevel(1);
        setFaint(false);
        weapon = null;
        armor = null;
        spell = null;
        inventory = new Inventory();
    }

    @Override
    public int attack() {
        int damage = getStrength();
        if(weapon!=null)
            damage += weapon.getDamage();
        return (int) Math.ceil(damage*0.05);
    }

    @Override
    public int getHurt(int damage) {
        Random r = new Random();
        int i = r.nextInt(100);
        if(i <= Math.ceil(getAgility()*0.002))
            return 0;
        int actualDamage = damage;
        if(armor != null)
            actualDamage = Math.max(damage - armor.getDamageReduction(), 0);
        if(actualDamage>getHp()){
            actualDamage =getHp();
            setHp(0);
            setFaint(true);
        }
        else
            setHp(getHp()-actualDamage);
        return actualDamage;
    }

    public int SpellAttack(){
        if(spell!=null && getMana() >= spell.getManaCost()) {
            setMana(getMana()-spell.getManaCost());
            return (int) spell.getDamage() + (getDexterity() / 10000) * spell.getDamage();
        }
        else return 0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    private void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStartingMoney() {
        return StartingMoney;
    }

    private void setStartingMoney(int startingMoney) {
        StartingMoney = startingMoney;
    }

    public int getStartingExp() {
        return StartingExp;
    }

    private void setStartingExp(int startingExp) {
        StartingExp = startingExp;
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public int getExp() {
        return exp;
    }

    private void setExp(int exp) {
        this.exp = exp;
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isFaint() {
        return isFaint;
    }

    public void setFaint(boolean faint) {
        isFaint = faint;
    }

    private String name;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int StartingMoney;
    private int StartingExp;
    private int money;
    private int exp;
    private int hp;
    private int level;
    private boolean isFaint;
    private Weapon weapon;
    private Armor armor;
    private Spell spell;
    private Inventory inventory;
}
