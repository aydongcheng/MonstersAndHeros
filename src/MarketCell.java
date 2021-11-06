public class MarketCell extends Cell {
    public MarketCell(){
        super("market", true);
        market = new Market();
    }

    public Market getMarket() {
        return market;
    }

    private Market market;
}
