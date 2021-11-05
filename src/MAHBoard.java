import java.util.HashMap;
import java.util.Map;

public class MAHBoard extends Board {
    public MAHBoard(){}

    public MAHBoard(int size){
        super(size);
        probabilityCellCreator = new ProbabilityMAHCellCreator(MAHBoard.probability);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                cells[i][i] = probabilityCellCreator.createCell();
            }
        }
    }

    public int getSize(){
        return getWidth();
    }

    private ProbabilityMAHCellCreator probabilityCellCreator;
    private static final Map<String, Float> probability = new HashMap<>();
}
