import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomMonsterCreator implements MonsterCreator{
    public RandomMonsterCreator(){}

    @Override
    public Monster createMonster() {
        return createMonster(-1);
    }

    public Monster createMonster(int level){
        Random r = new Random();
        int i = r.nextInt(RandomMonsterCreator.fileName.length);
        List<String> lines = new FileReader().readFile(RandomMonsterCreator.fileName[i]);
        lines.remove(0);
        lines.removeIf(o -> o.equals(""));
        if(level>0)
            lines.removeIf(o -> Integer.parseInt(o.split("\\s+")[1])>level);
        if(lines.size()>1)
            i = r.nextInt(lines.size()-1);
        else i=0;
        Monster monster = new Monster(lines.get(i).split("\\s+"));
        monster.levelUpTo(level);
        return monster;
    }

    private static final String[] fileName = new String[]{"Dragons", "Exoskeletons", "Spirits"};
}
