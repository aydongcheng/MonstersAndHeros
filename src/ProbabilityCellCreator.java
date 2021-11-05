import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public abstract class ProbabilityCellCreator implements CellCreator{
    public ProbabilityCellCreator(){}

    public ProbabilityCellCreator(Map<String ,Float> probability){
        this.probability = probability;
    }

    protected String selectType(){
        Random r = new Random();
        int i = r.nextInt(100);
        int count = 0;
        int addUpProb = 0;
        for(Float prob : probability.values()){
            if(i <= prob * 100)
                return new ArrayList<String>(probability.keySet()).get(count);
            else {
                addUpProb += prob * 100;
                count++;
            }

        }
        return new ArrayList<String>(probability.keySet()).get(-1);
    }

    private Map<String ,Float> probability;
}
