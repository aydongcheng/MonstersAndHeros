public class CommenCell extends Cell{
    public CommenCell(){
        super("commen",true);
    }

    public boolean isMonster() {
        isMonster = Math.random() <= 0.8;
        return isMonster;
    }

    public String display(){
        return "C";
    }

    private boolean isMonster;
    private static final double probability = 0.6;
}
