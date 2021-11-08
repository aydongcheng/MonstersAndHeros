//the entity of market cell
public class MarketCell extends Cell {
    public MarketCell(){
        super("market", true);
        market = new Market();
    }

    //get the market in the cell
    public Market getMarket() {
        return market;
    }

    public String display(){
        return "M";
    }

    private Market market;
}
