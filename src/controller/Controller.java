package controller;

import java.util.List;
import java.util.Scanner;

import service.FilterLaptops;
import service.IOFile;
import service.ServiceLaptop;
import view.View;

public class Controller {
    private IOFile ioFile = new IOFile();
    private ServiceLaptop serviceLaptop = new ServiceLaptop();
    private View view = new View();
    private FilterLaptops filterLaptops;

    public void createLaptop(String manufacturerProduct, String nameProduct, String typeOS, String color, String capacityRam, String capacityRom){
        serviceLaptop.create(manufacturerProduct, nameProduct, typeOS, color, capacityRam, capacityRom);   
    }

    public void createOnConsole(){
        String laptop = view.getOnConsole();
        serviceLaptop.createFromString(laptop);
    }
    
    public void getSetLaptops(){
        serviceLaptop.getSetLaptop();
    }
    public void printOnConsole(){
        view.printOnConsole(serviceLaptop.getSetLaptop());
    }

    public void deleteLaptop(){
        int id = view.getIdConsole();
        serviceLaptop.deleteLaptop(id);
        
    }

    public void crateFilter(){
        filterLaptops= new FilterLaptops(serviceLaptop.getSetLaptop());
    }
    public void setFilter(){
        List<String> filterParams = view.setFilterParamsOnConsole();
        filterLaptops.setFilterParams(filterParams);
    }
    public String getFilterString(){
        return filterLaptops.getFilterParams();
    }
    public void printFilteredSet(){
        view.printOnConsole(filterLaptops.getFilterLaptop());
    }
    public void cleanFilter(){
        filterLaptops.cleanFilterParams();
    }

    public void acceptFilter(){
        serviceLaptop.setListLaptops(filterLaptops.getFilterLaptop());
    }
    public void contains(){
        System.out.println("Input string for search: ");
        Scanner scanner = new Scanner(System.in);
        String substring = scanner.nextLine();
        filterLaptops.contains(substring);
    }
    public void setPathFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input path file");
        String path = scanner.nextLine(); 
        if (!path.trim().isEmpty()){
            ioFile.setPath(path);
        } 
    }
    public String getPathFile(){
        return ioFile.getPath();
    }
    
    public void writeToFile(){
        List<String> temp = serviceLaptop.getListStringLaptop(); 
        ioFile.setListLaptops(temp);
        ioFile.writeFile();
    }

    public void readFile(){
        ioFile.readFile();
        for (String laptop : ioFile.getListLaptops()) {
            serviceLaptop.createFromString(laptop.substring(laptop.indexOf(" ") + 1));    
        }
    }
}
