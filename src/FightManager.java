import java.util.ArrayList;
import java.util.Scanner;

public class FightManager {
    public FightManager(){}

    public FightManager(Team team){
        scan = new Scanner(System.in);
        heros = team;
        randomMonsterCreator = new RandomMonsterCreator();
    }

    public void start(){
        int MonsterNum = heros.getHeroes().size();
        int monsterLevel = 1;
        for(Hero hero: heros.getHeroes())
            monsterLevel = Math.max(monsterLevel,hero.getLevel());
        monster = randomMonsterCreator.createMonster(monsterLevel);
        for(Hero hero: heros.getHeroes()){
            if(MonsterNum == 0){
                if(hero.getRewards(monster.getLevel()))
                    System.out.println("Hero " + hero.getName()+" level up!");
                continue;
            }
            while (!hero.isFaint()) {
                ArrayList<StringBuilder> heroPrintLines = hero.getDisplayLines();
                heroPrintLines.add(0,new StringBuilder("HERO"));
                ArrayList<StringBuilder> MonsterPrintLines = monster.getDisplayLines();
                MonsterPrintLines.add(0,new StringBuilder("MONSTER"));
                ArrayList<ArrayList<StringBuilder>> stringBuilders = new ArrayList<>();
                stringBuilders.add(heroPrintLines);
                stringBuilders.add(MonsterPrintLines);
                Displayer.formDisplay(stringBuilders,2,30);
                int herosAction = chooseAction();
                if(herosAction == 1){
                    int heroDamage = hero.attack();
                    int monsterGethurt = monster.getHurt(heroDamage);
                    System.out.println("Hero "+ hero.getName() +" cast "+ monsterGethurt + " damage to monster "+ monster.getName());
                }
                else if(herosAction == 2){
                    int heroDamage = hero.SpellAttack();
                    if(heroDamage==0){
                        System.out.println("Hero can't cast a spell!");
                        continue;
                    }
                    int monsterGethurt = monster.getHurt(heroDamage);
                    System.out.println("Hero "+ hero.getName() +" cast "+ monsterGethurt + " damage to monster "+ monster.getName());
                    System.out.println("Monster "+ monster.getName() + " " + hero.getSpell().getSpecil());
                }
                else if(herosAction == 3){
                    if(hero.getInventory().getPotions().size()==0) {
                        System.out.println("Hero has no potion to use.");
                        continue;
                    }
                    else {
                        hero.getInventory().displayPotions(0);
                        int index = Displayer.chooseList(hero.getInventory().getPotions().size());
                        hero.consumePotion(new ArrayList<Potion>(hero.getInventory().getPotions().keySet()).get(index));
                    }
                }
                else {
                    boolean hasEquipment= false;
                    if(hero.getInventory().getWeapons().size()==0) {
                        System.out.println("Hero has no weapon to use.");
                    }
                    else {
                        hero.getInventory().displayWeapons(0);
                        int index = Displayer.chooseList(hero.getInventory().getWeapons().size());
                        hero.setWeapon(hero.getInventory().getWeapons().get(index));
                        hasEquipment = true;
                    }
                    if(hero.getInventory().getArmors().size()==0) {
                        System.out.println("Hero has no armor to use.");
                    }
                    else {
                        hero.getInventory().displayArmors(0);
                        int index = Displayer.chooseList(hero.getInventory().getArmors().size());
                        hero.setArmor(hero.getInventory().getArmors().get(index));
                        hasEquipment = true;
                    }
                    if(!hasEquipment)
                        continue;
                }
                if(monster.isFaint()){
                    MonsterNum--;
                    if(MonsterNum == 0) {
                        hero.recover();
                        if(hero.getRewards(monster.getLevel()))
                            System.out.println("Hero " + hero.getName()+" level up!");
                        System.out.println("Heros win!!!");
                        break;
                    }
                    monster = randomMonsterCreator.createMonster(monsterLevel);
                    continue;
                }
                int monsterDamage = monster.attack();
                int heroGetHurt = hero.getHurt(monsterDamage);
                System.out.println("Monster "+ monster.getName() +" cast "+ heroGetHurt + " damage to hero "+ hero.getName());
                hero.recover();
            }
        }
        if(monster.getHp() != 0)
            System.out.println("Heros lose!!!");
    }

    private int chooseAction(){
        System.out.println("It's hero's turn!");
        while (true) {
            System.out.println("1.Attack 2.Cast a Spell 3.Use a potion 4.Change Equipment");
            System.out.println("Please choose your action:");
            String input = scan.next();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Sorry, your input is illegal! Please try again.");
                continue;
            }
            if (choice < 1 || choice > 4)
                System.out.println("Sorry, your input is illegal! Please try again.");
            else
                return choice;
        }
    }

    private Scanner scan;
    private RandomMonsterCreator randomMonsterCreator;
    private Team heros;
    private Monster monster;
}
