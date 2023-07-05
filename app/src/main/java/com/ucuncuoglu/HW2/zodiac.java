package com.ucuncuoglu.HW2;

public class zodiac {
    private String name;
    private String time;
    private String stone;
    private String color;
    private String element;
    private String planet;
    private int imgId;

    public zodiac(String name, String time, String stone, String color, String element, String planet, int imgId) {
        this.name = name;
        this.time = time;
        this.stone = stone;
        this.color = color;
        this.element = element;
        this.planet = planet;
        this.imgId = imgId;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlanet() {
        return this.planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getStone() {
        return this.stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return   name + '\n' +
                "Date= " + time + '\n' +
                "stone= " + stone + '\n' +
                "Color= " + color + '\n' +
                "Element= " + element + '\n' +
                "Planet= " + planet + '\n';
    }

}
