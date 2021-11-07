import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    public Team(){
        scan = new Scanner(System.in);
        heroes = new ArrayList<>();
        setColumn(0);
        setRow(0);
    }

    public void move(int row, int column){
        setColumn(column);
        setRow(row);
    }

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

    public void displayHerosName(){
        Displayer.listDisplay(heroes,"Heros",0);
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
        System.out.println("Let's build your team.\nThere are heroes.");
        Displayer.listDisplay(heroes,"Heros",0);

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
