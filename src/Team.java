import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//the entity of team
public class Team {
    public Team(){
        scan = new Scanner(System.in);
        heroes = new ArrayList<>();
        setColumn(0);
        setRow(0);
    }

    //move to new location
    public void move(int row, int column){
        setColumn(column);
        setRow(row);
    }

    //add a hero to the team
    private void addHero(Hero h){
        heroes.add(h);
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    //display the name of heroes in the team
    public void displayHerosName(){
        Displayer.listDisplay(heroes,"Heros",0);
    }

    //choose hero to join the team
    public void chooseHero(){
        ArrayList<Hero> heroes = new ArrayList<>();
        String[] files = new String[]{"Warriors", "Sorcerers", "Paladins"};
        for(String file: files) {
            List<String> lines = new FileReader().readFile(file);
            for(int i = 1;i<lines.size();i++){
                if(lines.get(i).equals(""))
                    break;
                if(file.equals("Warriors"))
                    heroes.add(new Warrior(lines.get(i).split("\\s+")));
                else if(file.equals("Sorcerers"))
                    heroes.add(new Sorcerer(lines.get(i).split("\\s+")));
                else
                    heroes.add(new Paladin(lines.get(i).split("\\s+")));
            }
        }
        System.out.println("Let's build your team.\nThere are heroes.");
        Displayer.listDisplay(heroes,"Heros",0);

        //the max number of hero in one team
        int HeroNum = 3;
        for(int i=0; i<HeroNum; i++){
            if(i!=0){
                System.out.println("Do you want to add a hero?(y/others)");
                String input = scan.next();
                if(!input.equals("y"))
                    break;;
            }
            System.out.println("Please select a hero you are interested in.");
            int index = Displayer.chooseList(heroes.size());
            if(this.heroes.contains(heroes.get(index))) {
                System.out.println("Hero " + heroes.get(index).getName() +
                        " is already in the team, please select other heroes.");
                i--;
            }
            else {
                heroes.get(index).display();
                System.out.println("Do you want hero "+ heroes.get(index).getName() + " to join your team?(y/others)");
                String input = scan.next();
                if(input.equals("y"))
                    addHero(heroes.get(index));
                else
                    i--;
            }
        }
    }

    private int row;
    private int column;
    private ArrayList<Hero> heroes;
    private Scanner scan;
}
