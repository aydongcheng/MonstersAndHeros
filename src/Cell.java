//the super class of all cell in the map
public abstract class Cell {
    public Cell(){};
    public Cell(String type, boolean accessible){
        setType(type);
        setAccessible(accessible);
    };

    private void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }

    private void setType(String type) {
        this.type = type;
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public String getType() {
        return type;
    }

    public abstract String display();

    //whether the cell is accessible
    private boolean isAccessible;
    //the type of the cell
    private String type;
}
