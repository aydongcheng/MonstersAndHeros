public class CommenCell extends Cell{
    public CommenCell(){
        super("commen",true);
        if(Math.random() <= 0.6)
            monster = new RandomMonsterCreator().createMonster();
        else
            monster = null;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    private Monster monster;
    private static final double probability = 0.6;
}
