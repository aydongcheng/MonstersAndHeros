public class NonAccessibleCell extends Cell {
    public NonAccessibleCell(){
        super("non-accessible",false);
    }

    public String display(){
        return "N";
    }
}
