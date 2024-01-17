package Laptop.menu;

import java.util.Scanner;


/**
 * MainMenu
 */
public class MainMenu {

    public void printMainMenu(){
        // System.out.print("\033[H\033[2J");
        System.out.println("Добро пожаловать, выберете пункт меню:");
        System.out.println("1) - Меню работы записями");
        System.out.println("2) - Меню загрузки и сохранения");
        System.out.println("3) - Выход");
    }

    public void printTableMenu(){
        // System.out.print("\033[H\033[2J");
        System.out.println("1) - Отобразить перечень ноутбуков");
        System.out.println("2) - Добавить запись с ноутбуком");
        System.out.println("3) - Удалить запись с ноутбуком");
        System.out.println("4) - Поиск по вхождению");
        System.out.println("5) - Фильтрация по параметрам");
        System.out.println("6) - Возврат в предыдущее меню");
    }
    public void printFilterMenu(){
        // System.out.print("\033[H\033[2J");
        System.out.println("1) - Задать фильтр");
        System.out.println("2) - Отобразить отфильтрованные элементы ");
        System.out.println("3) - Сбросить фильтр и отфильтрованный список");
        System.out.println("4) - Перенести фильтр в основной список");
        System.out.println("5) - Возврат в предыдущее меню");
    }
    
    public void printFileMenu(){
        // System.out.print("\033[H\033[2J");
        System.out.println("1) - Задать имя и путь для чтения из файла");
        System.out.println("2) - Загрузить из файла");
        System.out.println("3) - Записать данные в файл");
        System.out.println("4) - Возврат в предыдущее меню");
    }

    public int parseAction(int maxPoint){
        try {
            Scanner scanner = new Scanner(System.in);
            String tempAction = scanner.nextLine();    
            int action = Integer.parseInt(tempAction);
            if (action > maxPoint || action <= 0){
                throw new NumberFormatException();
            } 
            return action;
        } catch (NumberFormatException  e){
            System.out.println("Wrong input");
            return -1;
        }
    }
    
}
