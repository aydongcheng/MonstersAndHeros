import java.util.ArrayList;
import java.util.Arrays;

public class Potion extends Merchandise {
    public Potion(){}

    public Potion(String name, int price, int minLevel, int attributeIncrease, String[] attributes){
        super(name, minLevel, price, "Potion");
        setAttributeIncrease(attributeIncrease);
        setAttributes(attributes);
    }

    public ArrayList<StringBuilder> getDisplayLines(){
        ArrayList<StringBuilder> attributes = new ArrayList<>();

        attributes.add(new StringBuilder("Name: " + getName()));

        attributes.add(new StringBuilder("Price: " + getPrice()));

        attributes.add(new StringBuilder("Level: " + getMinLevel()));

        attributes.add(new StringBuilder("Attribute Increase: " + getAttributeIncrease()));

        attributes.add(new StringBuilder("Attribute Affected: " + Arrays.toString(getAttributes())));

        return attributes;
    }

    public void display(){
        ArrayList<StringBuilder> attributes = getDisplayLines();
        for(StringBuilder stringBuilder: attributes){
            System.out.println(stringBuilder);
        }
    }

    public int getAttributeIncrease() {
        return attributeIncrease;
    }

    private void setAttributeIncrease(int attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public String[] getAttributes() {
        return attributes;
    }

    private void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    private int attributeIncrease;
    private String[] attributes;
}
