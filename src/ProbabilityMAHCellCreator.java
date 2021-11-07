import java.util.Map;

public class ProbabilityMAHCellCreator extends ProbabilityCellCreator{
    public ProbabilityMAHCellCreator(){}

    public ProbabilityMAHCellCreator(Map<String ,Double> probability){
        super(probability);
    }

    @Override
    public Cell createCell() {
        String type = selectType();
        Cell cell;
        switch (type){
            case "non-accessible":
                cell = new NonAccessibleCell();
                break;
            case "market":
                cell = new MarketCell();
                break;
            case "commen":
                cell = new CommenCell();
                break;
            default:
                cell = null;
        }
        return cell;
    }
}
