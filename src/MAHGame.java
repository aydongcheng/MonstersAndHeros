import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MAHGame {
    public MAHGame(){
       scan = new Scanner(System.in);
       mahBoard = new MAHBoard(8);
       team = new Team();
    }

    public void start(){
        chooseHero();
        while (true) {
            printInstruction();
            mahBoard.display(team.getRow(), team.getColumn());
            String action = chooseAction();
            if(action.equals("move")){
                if(mahBoard.getCells()[team.getRow()][team.getColumn()].getType().equals("market")){
                    System.out.println("WELCOME TO MARKET!!!");
                    Market market = ((MarketCell)mahBoard.getCells()[team.getRow()][team.getColumn()]).getMarket();
                    trade(market);
                }
                else {
                    if(((CommenCell)mahBoard.getCells()[team.getRow()][team.getColumn()]).isMonster()){
                        System.out.println("HERO MEET MONSTERS!!!");
                        fightManager = new FightManager(team);
                        fightManager.start();
                    }
                }
            }
        }
    }

    public void chooseHero(){
        ArrayList<Hero> heroes = new ArrayList<>();
        String[] files = new String[]{"Warriors", "Sorcerers", "Paladins"};
        for(String file: files) {
            List<String> lines = new FileReader().readFile(file);
            for(int i = 1;i<lines.size();i++){
                if(lines.get(i).equals(""))
                    break;
                heroes.add(new Hero(lines.get(i).split("\\s+")));
            }
        }

        Displayer.listDisplay(heroes,"Heros",0);
//        int HeroNum = 3;
//        while(HeroNum>0) {
//            index = chooseList(heroes.size());
//        }
        int index = Displayer.chooseList(heroes.size());
        team.addHero(heroes.get(index));
    }



    private void printInstruction(){
        System.out.println("+--------------------------------------+");
        System.out.println("|move:w a s d; Information: i; Quit : q|");
        System.out.println("+--------------------------------------+");
    }

    private String chooseAction(){
        while (true) {
            System.out.println("Please choose your action:");
            String input = scan.next();
            if(input.equals("w")){
                if(checkMove(team.getRow()-1, team.getColumn())){
                    team.move(team.getRow()-1, team.getColumn());
                    return "move";
                }
                else
                    System.out.println("The place is inaccessible. Please try again.");

            }
            else if(input.equals("s")){
                if(checkMove(team.getRow()+1, team.getColumn())){
                    team.move(team.getRow()+1, team.getColumn());
                    return "move";
                }
                else
                    System.out.println("The place is inaccessible. Please try again.");
            }
            else if(input.equals("a")){
                if(checkMove(team.getRow(), team.getColumn()-1)){
                    team.move(team.getRow(), team.getColumn()-1);
                    return "move";
                }
                else
                    System.out.println("The place is inaccessible. Please try again.");
            }
            else if(input.equals("d")){
                if(checkMove(team.getRow(), team.getColumn()+1)){
                    team.move(team.getRow(), team.getColumn()+1);
                    return "move";
                }
                else
                    System.out.println("The place is inaccessible. Please try again.");
            }
            else if(input.equals("i")){
                for(Hero hero:team.getHeroes())
                    hero.display();
                equipHero();
            }
        }
    }

    private boolean checkMove(int row, int column){
        if(row>=0 && column>=0 && mahBoard.getCells()[row][column].isAccessible())
            return true;
        else return false;
    }

    private void trade(Market market){
        int totalNum = market.display();
        while (true) {
            System.out.println("Do you want to check one of the merchandises in the market?(y/others)");
            String input = scan.next();
            if(input.equals("y")) {
                int index = Displayer.chooseList(totalNum);
                Merchandise merchandise = market.displayItems(index);
                System.out.println("Do you want to buy this merchandise for one of your heros?(y/others)");
                input = scan.next();
                if(input.equals("y")){
                    team.displayHerosName();
                    int indeOfHero = Displayer.chooseList(team.getHeroes().size());
                    Hero hero = team.getHeroes().get(indeOfHero);
                    if(!hero.buyMerchandise(merchandise))
                        System.out.println("Sorry hero " + hero.getName()+" does not meet the purchase conditions");
                    else
                        System.out.println("Hero " + hero.getName() + "got " + merchandise.getName());
                }
            }
            else break;
        }
        while (true) {
            System.out.println("Do you want to sell equipments?(y/others)");
            String input = scan.next();
            if(input.equals("y")) {
                System.out.println("Which hero wants to sell his/her equipment?");
                int indeOfHero = Displayer.chooseList(team.getHeroes().size());
                Hero hero = team.getHeroes().get(indeOfHero);
                int NumEquipInInventory = hero.getInventory().display();
                int indexOfEquipment = Displayer.chooseList(NumEquipInInventory);
                Merchandise merchandise = hero.getInventory().displayItems(indexOfEquipment);
                System.out.println("Do you want to sell this merchandise?(y/others)");
                input = scan.next();
                if(input.equals("y")){
                    hero.sellMerchandise(merchandise);
                }
            }
            else break;
        }
    }

    private void equipHero(){
        while (true) {
            System.out.println("Do you want to equip your heros?(y/others)");
            String input = scan.next();
            if(input.equals("y")) {
                System.out.println("Which hero needs to change equipment?");
                team.displayHerosName();
                int indeOfHero = Displayer.chooseList(team.getHeroes().size());
                Hero hero = team.getHeroes().get(indeOfHero);
                int NumEquipInInventory = hero.getInventory().display();
                System.out.println("Select the equipment you need to equip or use.");
                int indexOfEquipment = Displayer.chooseList(NumEquipInInventory);
                Merchandise merchandise = hero.getInventory().displayItems(indexOfEquipment);
                System.out.println("Do you want to equip or use this merchandise?(y/others)");
                input = scan.next();
                if(input.equals("y")){
                    hero.equipOrUseMerchandise(merchandise);
                }
            }
            else break;
        }
    }

    private MAHBoard mahBoard;
    private FightManager fightManager;
    private Team team;
    private Scanner scan;
}