public class Dragon extends Monster{
    public Dragon(){}

    public Dragon(String name, int initLevel, int damage, int defense, int dodgeChance){
        super(name, initLevel, damage, defense, dodgeChance);
    }

    @Override
    public void levelUpTo(int Level){
        super.levelUpTo(Level);
        setDamage((int) Math.ceil(getDamage()*Math.pow((1.1/1.05),(Level - getInitLevel()))));
    }
}
