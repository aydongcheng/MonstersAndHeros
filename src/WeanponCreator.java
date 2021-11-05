import java.util.Arrays;
import java.util.List;

public class WeanponCreator implements MerchandiseCreator{
    public WeanponCreator(){}

    @Override
    public Merchandise createMercandise(String infoList) {
        List<String> data = Arrays.asList(infoList.split("\\s+"));
        Weapon weapon = new Weapon(data.get(0),Integer.parseInt(data.get(1)),
                Integer.parseInt(data.get(2)),Integer.parseInt(data.get(3)));
        return weapon;
    }
}
