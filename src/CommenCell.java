public class CommenCell extends Cell{
    public CommenCell(){
        super("commen",true);
        if(Math.random() <= 0.6)
            isMonster = true;
        else
            isMonster = false;
    }

    public boolean isMonster() {
        return isMonster;
    }

    public String display(){
        return "C";
    }

    private boolean isMonster;
    private static final double probability = 0.6;
}
