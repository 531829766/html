package cn.edu.hziee.model;

public class Commodity {
    private int id;

    private String picture;//图片

    private String commodity_name;//商品名称

    private int original;//原价

    private int discount;//折扣价

    private int stock;//库存数量

    private String commodity_type;//商品类型

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", picture=" + picture + '\'' +
                ", commodity_name='" + commodity_name + '\'' +
                ", original='" + original + '\'' +
                ", discount='" + discount + '\'' +
                ", stock='" + stock + '\'' +
                ", commodity_type='" + commodity_type + '\'' +
                '}';
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public int getOriginal() {
        return original;
    }

    public void setOriginal(int original) {
        this.original = original;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCommodity_type() {
        return commodity_type;
    }

    public void setCommodity_type(String commodity_type) {
        this.commodity_type = commodity_type;
    }
}
