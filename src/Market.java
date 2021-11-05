import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Market {
    public Market(){
        FileReader fileReader = new FileReader();
        //create weapons
        weapons = new ArrayList<>();
        List<String> lines = fileReader.readFile("Weaponry");
        weanponCreator = new WeanponCreator();
        for(int i = 1; i < lines.size(); i++){
            weapons.add((Weapon) weanponCreator.createMercandise(lines.get(i)));
        }

        //create armors
        armors = new ArrayList<>();
        lines = fileReader.readFile("Armory");
        armorCreator = new ArmorCreator();
        for(int i = 1; i < lines.size(); i++){
            armors.add((Armor) armorCreator.createMercandise(lines.get(i)));
        }

        //create potions
        potions = new ArrayList<>();
        lines = fileReader.readFile("Potions");
        potionCreator = new PotionCreator();
        for(int i = 1; i < lines.size(); i++){
            potions.add((Potion) potionCreator.createMercandise(lines.get(i)));
        }
    }

    private ArrayList<Weapon> weapons;
    private WeanponCreator weanponCreator;
    private ArrayList<Armor> armors;
    private ArmorCreator armorCreator;
    private ArrayList<Potion> potions;
    private PotionCreator potionCreator;
}
