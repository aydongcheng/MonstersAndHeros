import java.util.ArrayList;

public class Team {
    public Team(){
        heroes = new ArrayList<>();
        setColumn(0);
        setRow(0);
    }

    public void move(int row, int column){
        setColumn(column);
        setRow(row);
    }

    public void addHero(Hero h){
        heroes.add(h);
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void displayHerosName(){
        Displayer.listDisplay(heroes,"Heros",0);
    }

    private int row;
    private int column;
    private ArrayList<Hero> heroes;
}
