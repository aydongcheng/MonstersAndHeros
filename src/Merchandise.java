public abstract class Merchandise implements Displayable{
    public Merchandise(){}

    public Merchandise(String name, int minLevel, int price, String type){
        setName(name);
        setMinLevel(minLevel);
        setPrice(price);
        setType(type);
    }

    public int getMinLevel() {
        return minLevel;
    }

    private void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Merchandise) obj).getName());
    }

    private String name;
    private int minLevel;
    private int price;
    private String type;
}
