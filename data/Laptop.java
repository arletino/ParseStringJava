package Laptop.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Laptop extends Product implements Comparable<Laptop>{

    private String typeOS, color;
    private Integer capacityRam, capacityRom;
    
    public Laptop(int id, String manufacturerProduct, String nameProduct, String typeOS, String color, Integer capacityRam, Integer capacityRom) {
        super(id, manufacturerProduct, nameProduct);
        this.typeOS = typeOS;
        this.color = color;
        this.capacityRam = capacityRam;
        this.capacityRom = capacityRom;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = ((super.hashCode() == 0) ? 1 : super.hashCode());
        result = prime * result + ((typeOS == null) ? 0 : typeOS.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((capacityRam == null) ? 0 : capacityRam.hashCode());
        result = prime * result + ((capacityRom == null) ? 0 : capacityRom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (!super.equals((Product) other)){
            return false;
        }
        if (typeOS == null) {
            if (other.typeOS != null)
                return false;
        } else if (!typeOS.equals(other.typeOS))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (capacityRam == null) {
            if (other.capacityRam != null)
                return false;
        } else if (!capacityRam.equals(other.capacityRam))
            return false;
        if (capacityRom == null) {
            if (other.capacityRom != null)
                return false;
        } else if (!capacityRom.equals(other.capacityRom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String s = 
            String.format("%s %s %s %s %s %s %s", 
                            super.getId(),super.getManufacturerProduct(), super.getNameProduct(),
                            typeOS, color, capacityRam, capacityRom);
        return s;
    }

    public String getTypeOS() {
        return typeOS;
    }

    public void setTypeOS(String typeOS) {
        this.typeOS = typeOS;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCapacityRam() {
        return capacityRam;
    }

    public void setCapacityRam(Integer capacityRam) {
        this.capacityRam = capacityRam;
    }

    public Integer getCapacityRom() {
        return capacityRom;
    }

    public void setCapacityRom(Integer capacityRom) {
        this.capacityRom = capacityRom;
    }

    // public List<String> getListLaptopParam(){
    //     List<String> params = new ArrayList<>();
    //     params.add("" + super.getId());
    //     params.add(super.getManufacturerProduct());
    //     params.add(super.getNameProduct());
    //     params.add(typeOS);
    //     params.add(color);
    //     params.add(capacityRam.toString());
    //     params.add(capacityRom.toString());
    //     return params;
    // }

    public Map<String, String> getMapLaptopParam(){
        Map<String, String> params = new LinkedHashMap<>(); 
        params.put("Company", super.getManufacturerProduct());
        params.put("Name", super.getNameProduct());
        params.put("Os", typeOS);
        params.put("Color", color);
        params.put("Ram", capacityRam.toString());
        params.put("Rom", capacityRom.toString());
        return params;    
    }
    
    @Override
    public int compareTo(Laptop arg0) {
        return super.getId() - arg0.getId();
    }

    
}
