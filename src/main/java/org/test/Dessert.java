package org.test;

/**
 * Created by jonte on 16/03/2017.
 */
public class Dessert {

    private String name;
    private Integer calories;
    private Double fat;
    private Integer carbs;
    private Double protein;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Integer getSodium() {
        return sodium;
    }

    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    public Integer getCalcium() {
        return calcium;
    }

    public void setCalcium(Integer calcium) {
        this.calcium = calcium;
    }

    public Integer getIron() {
        return iron;
    }

    public void setIron(Integer iron) {
        this.iron = iron;
    }

    private Integer sodium;
    private Integer calcium;
    private Integer iron;

    public Dessert(String name,
                   Integer calories,
                   Double fat,
                   Integer carbs,
                   Double protein,
                   Integer sodium,
                   Integer calcium,
                   Integer iron) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
        this.sodium = sodium;
        this.calcium = calcium;
        this.iron = iron;
    }

}
