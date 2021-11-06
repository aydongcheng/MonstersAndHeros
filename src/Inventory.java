import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public Inventory(){
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        potions = new HashMap<>();
        spells = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }

    public void sellWeapon(Weapon weapon){
        weapons.remove(weapon);
    }

    public void addArmor(Armor armor){
        armors.add(armor);
    }

    public void sellArmor(Armor armor){
        armors.remove(armor);
    }

    public void addPotion(Potion potion){
        if(potions.containsKey(potion))
            potions.put(potion, potions.get(potion)+1);
        else
            potions.put(potion,1);
    }

    public void consumePotion(Potion potion){
        if(potions.get(potion) == 1)
            potions.remove(potion);
        else
            potions.put(potion, potions.get(potion)-1);
    }

    public void addSpell(Spell spell){
        spells.add(spell);
    }

    public void sellSpell(Spell spell){
        spells.remove(spell);
    }

    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;
    private Map<Potion, Integer> potions;
    private ArrayList<Spell> spells;
}
