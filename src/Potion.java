public class Potion extends Merchandise {
    public Potion(){}

    public Potion(String name, int price, int minLevel, int attributeIncrease, String[] attributes){
        super(name, minLevel, price, "Potion");
        setAttributeIncrease(attributeIncrease);
        setAttributes(attributes);
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
