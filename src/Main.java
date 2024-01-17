import controller.Controller;
import menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createLaptop("Asus", "VivoBook", "Windows", "Black", "8", "128");
        controller.createLaptop("Asus", "VivoBook", "Windows", "Black", "8", "128");
        controller.createLaptop("Acer", "VivoBook", "Windows", "Black", "16", "128");
        controller.createLaptop("Huawai", "VivoBook", "Windows", "Black", "8", "256");
        controller.createLaptop("Honor", "VivoBook", "Windows", "Black", "16", "128");
        controller.createLaptop("Azerty", "VivoBook", "Windows", "Black", "16", "256");
        controller.createLaptop("Acer", "VivoBook", "Windows", "Black", "16", "128");
        controller.createLaptop("CHUWI", "VivoBook", "Windows", "Black", "16", "128");
        controller.createLaptop("Thunderobot", "VivoBook", "Windows", "Black", "16", "128");
        MainMenu mainMenu = new MainMenu();
        int menuPoint = -1;
        do{
            mainMenu.printMainMenu();
            menuPoint = mainMenu.parseAction(3);
            if (menuPoint != -1) {
                if (menuPoint == 1){
                    displayTableMenu(mainMenu, controller);
                }
                else if (menuPoint == 2){
                    displayFileMenu(mainMenu, controller);
                }
            }
        }
        while(menuPoint != 3); 

    }
    
    public static void displayTableMenu(MainMenu mainMenu, Controller controller){
        int menuPoint = -1;
        do{
            mainMenu.printTableMenu();
            menuPoint = mainMenu.parseAction(6);
            if (menuPoint != -1) {
                if (menuPoint == 1){
                    controller.printOnConsole();
                }
                else if (menuPoint == 2){
                    controller.createOnConsole();
                }
                else if (menuPoint == 3){
                    controller.deleteLaptop();
                }
                else if (menuPoint == 4){
                    controller.crateFilter();
                    controller.contains();
                    controller.printFilteredSet();
                }
                else if (menuPoint == 5){
                    displayFilterMenu(mainMenu, controller);
                }
            }
        } while(menuPoint != 6);
    }
    public static void displayFileMenu(MainMenu mainMenu, Controller controller){
        int menuPoint = -1;
        do{
            System.out.println("File path: " + controller.getPathFile());
            mainMenu.printFileMenu();
            menuPoint = mainMenu.parseAction(6);
            if (menuPoint != -1) {
                if (menuPoint == 1){
                    controller.setPathFile();
                }
                else if (menuPoint == 2){
                    controller.readFile();
                }
                else if (menuPoint == 3){
                        controller.writeToFile();
                }               
            }
        } while(menuPoint != 4);
    }

    public static void displayFilterMenu(MainMenu mainMenu, Controller controller){
        int menuPoint = -1;
        controller.crateFilter();
        do{
            System.out.println("Filter: " + controller.getFilterString());
            mainMenu.printFilterMenu();
            menuPoint = mainMenu.parseAction(5);
            if (menuPoint != -1) {
                if (menuPoint == 1){
                    controller.setFilter();
                }
                else if (menuPoint == 2){
                    controller.printFilteredSet();                }
                else if (menuPoint == 3){
                        controller.cleanFilter();;
                }
                else if (menuPoint == 4){
                        controller.acceptFilter();
                }             
            }
        } while(menuPoint != 5);
    }

}