package Laptop.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    private List<String> listLaptops;
    private String path = "newfile.txt";
    private int fieldsNum = 7; // - Кол-во полей в записи для проверки файла


    public IOFile() { 
        listLaptops = new ArrayList<>();
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(" ").length != fieldsNum) {
                    System.out.println("Wrong data in file");
                    break;
                }
                this.listLaptops.add(line);
            }
        } catch (IOException e) {
            System.out.println(e);
            // e.printStackTrace();
        }
    }
    public void writeFile(){
        if (!listLaptops.isEmpty()){
            try (FileWriter fileWriter = new FileWriter(path, true)) {
                for (String line : listLaptops) {
                    fileWriter.write(line);
                    fileWriter.write("\n");    
                    }
                fileWriter.flush();
                System.out.println("File " + path + " saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            System.out.println("List is empty");
        }
    }
    public String getPath(){
        return this.path;
    }
    public List<String> getListLaptops() {
        return this.listLaptops;
    }

    public void setListLaptops(List<String> listLaptops) {
        this.listLaptops = listLaptops;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFieldsNum(int fieldsNum) {
        this.fieldsNum = fieldsNum;
    }
}
