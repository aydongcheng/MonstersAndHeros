public class Board {
    public Board(){}

    public Board(int width, int length){
        setLength(length);
        setWidth(width);
        cells = new Cell[length][width];
    }

    public Board(int size){
        this(size,size);
    }

    private void setWidth(int width) {
        this.width = width;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    private int width;
    private int length;
    protected Cell[][] cells;
}
