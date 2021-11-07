import java.util.ArrayList;

public class Armor extends Merchandise{
    public Armor(){}

    public Armor(String name, int price, int minLevel, int damageReduction){
        super(name, minLevel, price, "Armor");
        setDamageReduction(damageReduction);
    }

    public Armor(String[] data){
        this(data[0],Integer.parseInt(data[1]),
                Integer.parseInt(data[2]),Integer.parseInt(data[3]));
    }

    public ArrayList<StringBuilder> getDisplayLines(){
        ArrayList<StringBuilder> attributes = new ArrayList<>();

        attributes.add(new StringBuilder("Name: " + getName()));

        attributes.add(new StringBuilder("Price: " + getPrice()));

        attributes.add(new StringBuilder("Level: " + getMinLevel()));

        attributes.add(new StringBuilder("Damage Reduction: " + getDamageReduction()));
        return attributes;
    }

    public void display(){
        Displayer.displayLines(getDisplayLines());
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    private void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    private int damageReduction;
}
