//the entity of commom cell
public class CommenCell extends Cell{
    public CommenCell(){
        super("commen",true);
    }

    //every time hero enter the common cell check whether there is a monster
    public boolean isMonster() {
        isMonster = Math.random() <= probability;
        return isMonster;
    }

    public String display(){
        return "C";
    }

    private boolean isMonster;
    //the probability to meet a monster
    private static final double probability = 0.8;
}
