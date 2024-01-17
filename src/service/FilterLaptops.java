package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.Laptop;



public class FilterLaptops {
    private Map<String, String> filterParam = new LinkedHashMap<>();
    private List<Laptop> filterList = new ArrayList<>();;
    private List<Laptop> basicList;

    public FilterLaptops(Set<Laptop> setLaptop){
        filterParam.put("Company", "");
        filterParam.put("Name", "");
        filterParam.put("Os", "");
        filterParam.put("Color", "");
        filterParam.put("Ram", "");
        filterParam.put("Rom", "");
        basicList = new ArrayList<>(setLaptop);
    }
    public Set<Laptop> getFilterLaptop(){
        filtering();
        return new HashSet<Laptop>(filterList);
    }
    public void setFilterParams(List<String> params){
        int i = 0;
        for (Map.Entry<String, String> entry : filterParam.entrySet()) {
            filterParam.put(entry.getKey(), params.get(i));
            System.out.println(entry.getKey() + " " + params.get(i));
            i++;
        }
    }
    public String getFilterParams(){
        return filterParam.toString();
    }

    public void cleanFilterParams(){
        for (Map.Entry<String, String> entry : filterParam.entrySet()) {
            filterParam.put(entry.getKey(), "");
        }
        this.filterList.clear();
    }

    public void filtering(){
        for (Laptop laptop : basicList) {
            Map<String, String> params = laptop.getMapLaptopParam();
            for (Map.Entry<String, String> entry : filterParam.entrySet()) {
                String tempKey = entry.getKey();
                String tempValue = entry.getValue().toLowerCase();
                if (!tempValue.equals("") && params.get(tempKey).toLowerCase().contains(tempValue)){
                    filterList.add(laptop);
                }
            }
        }
    } 
    
    public void contains(String substring){
        for (Laptop laptop : basicList){
            if (laptop.toString().toLowerCase().contains(substring.toLowerCase())){
                filterList.add(laptop);
            }
        }
    }
}
