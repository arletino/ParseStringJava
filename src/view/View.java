package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import data.Laptop;


public class View {

    public void printOnConsole(Set<Laptop> setLaptop){
        TreeSet<Laptop> setSorted = new TreeSet<>(setLaptop);
        Scanner scanner = new Scanner(System.in);
        String temp = "";
        String s = 
        String.format("%1$-3s | %2$-12s | %3$-10s | %4$-8s | %5$-8s | %6$-3s | %7$-5s", 
                        "id","Company", "Name","OS", "Color", "Ram", "Rom");
        System.out.println(s);
        String headLine = "-".repeat(67);
        System.out.println(headLine);
        Iterator<Laptop> it = setSorted.iterator(); 
        int lineNum = 0;
        while (!temp.equalsIgnoreCase("q") && (it.hasNext())){
            int counter = 5; // Порция вывода строк
            while(counter != 0 && it.hasNext()){
                String[] laptop = it.next().toString().split(" ");
                String format = String.format("%1$-3s | %2$-12s | %3$-10s | %4$-8s | %5$-8s | %6$-3s | %7$-5s", laptop);
                System.out.println(format);
                counter --;
                lineNum ++;
            }
            if (it.hasNext()){
                System.out.println("Continue press Enter or q return to menu");
                temp = scanner.nextLine();
            }
        }
        System.out.println("Output " + lineNum +" from " + setSorted.size() +" notes listed");
        System.out.println("Continue press Enter return to menu");
        temp = scanner.nextLine();
    }

    public String getOnConsole(){
        StringBuilder laptop = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Company: ");
        laptop.append(scanner.nextLine().trim());
        laptop.append(" ");
        System.out.print("Input Name: ");
        laptop.append(scanner.nextLine().trim());
        laptop.append(" ");
        System.out.print("Input Os: ");
        laptop.append(scanner.nextLine().trim());
        laptop.append(" ");
        System.out.print("Input Color: ");
        laptop.append(scanner.nextLine().trim());
        laptop.append(" ");
        System.out.print("Input Ram: ");
        laptop.append(scanner.nextLine().trim());
        laptop.append(" ");
        System.out.print("Input Rom: ");
        laptop.append(scanner.nextLine().trim());
        System.out.println(laptop.toString());
        return laptop.toString();
    }
    public int getIdConsole(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id: ");
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }
        return -1;
    }
    public List<String> setFilterParamsOnConsole(){
        List<String> params = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Company: ");
        params.add(scanner.nextLine().trim());
        System.out.print("Input Name: ");
        params.add(scanner.nextLine().trim());
        System.out.print("Input Os: ");
        params.add(scanner.nextLine().trim());
        System.out.print("Input Color: ");
        params.add(scanner.nextLine().trim());
        System.out.print("Input Ram: ");
        params.add(scanner.nextLine().trim());
        System.out.print("Input Rom: ");
        params.add(scanner.nextLine().trim());
        System.out.println(params.toString());
        return params;
    }

}
