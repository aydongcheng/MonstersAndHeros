import java.util.ArrayList;
import java.util.Scanner;

public class Displayer {
    public Displayer(){}

    public static void formDisplay(ArrayList<ArrayList<StringBuilder>> items, int itemSize, int formNum){
        for(int row = 0; row < Math.ceil(items.size()/formNum); row++) {
            int line = 0;
            boolean label = true;
            while (label){
                label = false;
                for(int i = 0; i<formNum; i++){
                    if(line <= items.get(row*formNum + i).size()) {
                        StringBuilder string = items.get(row * formNum + i).get(line);
                        string.append(" ".repeat(Math.max(0, itemSize - string.length())));
                        System.out.println(string);
                        label = true;
                    }
                    else {
                        StringBuilder string = new StringBuilder();
                        string.append(" ".repeat(itemSize));
                        System.out.println(string);
                    }
                }
                line++;
            }
        }
    }


    public static <T extends Displayable> void listDisplay(ArrayList<T> items, String itemName, int startIndex, int lineLength, int itemLength){
        int index = startIndex;
        StringBuilder s = new StringBuilder(itemName);
        if(s.length()<itemLength-2)
            s.append(" ".repeat(Math.max(0, itemLength - 2 - s.length())));
        else
            itemLength = s.length()+2;
        s.append(" :");
        StringBuilder stringBuilder = new StringBuilder(s);
        for(T t : items){
            s = new StringBuilder(index + "."+t.getName());
            s.append(" ".repeat(Math.max(0, itemLength - 2 - s.length())));
            if(s.length()<itemLength)
            stringBuilder.append(index + "."+t.getName()+" ");
            index++;
        }
        System.out.println(stringBuilder);
    }

    public static <T extends Displayable> void listDisplay(ArrayList<T> items, String itemName, int startIndex){
        listDisplay(items,itemName,startIndex,5,30);
    }

    public static int chooseList(int listSize){
        while (true) {
            System.out.println("Please make your choice:(input the number in front of the item)");
            String input = Displayer.scan.next();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Sorry, your input is illegal! Please try again.");
                continue;
            }
            if (choice < 0 || choice > listSize-1)
                System.out.println("Sorry, your input is illegal! Please try again.");
            else
                return choice;
        }
    }

    private static Scanner scan = new Scanner(System.in);
}
