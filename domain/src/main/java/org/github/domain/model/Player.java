package org.github.domain.model;

/**
 * Created by Cliente on 14/12/2015.
 */
public class Player implements Comparable{

    private String name;
    private int physics;
    private int technic;

    public Player(String name, int physics, int technic){
        this.name = name;
        this.physics = physics;
        this.technic = technic;
    }

    public int getRate(){
        return physics * 3 + technic * 2;
    }

    public String getName() {
        return name;
    }

    public int getPhysics() {
        return physics;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTechnic(int technic) {
        this.technic = technic;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getTechnic() {
        return technic;

    }

    @Override
    public int compareTo(Object another) {
        Player p = (Player) another; //creating a student object
        int studentCompare = this.getRate() - p.getRate();
        return studentCompare;
    }

    @Override
    public String toString() {
        return name + " - " + getRate();
    }

    public String toJson(){
        return  "{" + "\"nome:\"" + getName() + "\"rate:\"" + getRate() + "}";
    }
}
