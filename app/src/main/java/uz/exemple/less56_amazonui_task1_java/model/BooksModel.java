package uz.exemple.less56_amazonui_task1_java.model;

import java.util.PrimitiveIterator;

public class BooksModel {
    private int image;
    private String title;
    private Double price;
    private Double oldPrice = null;

    public BooksModel(int image, String title, Double price, Double oldPrice) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.oldPrice = oldPrice;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }
}
