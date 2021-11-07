public class Exoskeleton extends Monster {
    public Exoskeleton(){}

    public Exoskeleton(String name, int initLevel, int damage, int defense, int dodgeChance){
        super(name, initLevel, damage, defense, dodgeChance);
    }

    @Override
    public void levelUpTo(int Level){
        super.levelUpTo(Level);
        setDefense((int) Math.ceil(getDefense()*Math.pow((1.1/1.05),(Level - getInitLevel()))));
    }
}
