import java.util.Arrays;
import java.util.List;

public class ArmorCreator implements MerchandiseCreator{
    public ArmorCreator(){}

    @Override
    public Merchandise createMercandise(String infoList) {
        List<String> data = Arrays.asList(infoList.split("\\s+"));
        Armor armor = new Armor(data.get(0),Integer.parseInt(data.get(1)),
                Integer.parseInt(data.get(2)),Integer.parseInt(data.get(3)));
        return armor;
    }
}
