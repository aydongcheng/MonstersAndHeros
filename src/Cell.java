public class Cell {
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

    private boolean isAccessible;
    private String type;
}
