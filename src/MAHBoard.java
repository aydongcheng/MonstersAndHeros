import java.util.HashMap;
import java.util.Map;

public class MAHBoard extends Board {
    public MAHBoard(){}

    public MAHBoard(int size){
        super(size);
        MAHBoard.probability.put("non-accessible", 0.1);
        MAHBoard.probability.put("market", 0.3);
        MAHBoard.probability.put("commen", 0.6);
        probabilityCellCreator = new ProbabilityMAHCellCreator(MAHBoard.probability);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                cells[i][j] = probabilityCellCreator.createCell();
            }
        }
    }

    public int getSize(){
        return getWidth();
    }

    public void display(int row, int column){
        for(int j=0; j<getCells()[0].length; j++){
            System.out.print("  "+ (j+1) +" ");
        }
        System.out.print("\n");
        for(int i=0; i<getCells().length; i++){
            for(int j=0; j<getCells()[i].length; j++){
                System.out.print("+---");
            }
            System.out.print("+\n");
            for(int j=0; j<getCells()[i].length; j++){
                if(i==row&&j==column)
                    System.out.print("| H ");
                else
                    System.out.print("| "+getCells()[i][j].display()+" ");
            }
            System.out.print("| " + (i+1) +"\n");
        }
        for(int j=0; j<getCells()[0].length; j++){
            System.out.print("+---");
        }
        System.out.print("+\n");
    }

    private ProbabilityMAHCellCreator probabilityCellCreator;
    private static Map<String, Double> probability = new HashMap<String, Double>();
}
