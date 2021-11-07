public class MarketCell extends Cell {
    public MarketCell(){
        super("market", true);
        market = new Market();
    }

    public Market getMarket() {
        return market;
    }

    public String display(){
        return "M";
    }

    private Market market;
}
