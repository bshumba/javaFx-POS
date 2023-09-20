package com.ringleadafrica.rlapos;

public class CartModel {

    private Integer id;
    private Integer product_id;
    private String product_name;
    private Double product_price;
    private Integer product_qty;
    private Double product_total_price;

    public CartModel(Integer id, Integer product_id, String product_name, Double product_price, Integer product_qty, Double product_total_price) {
        this.id = id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_qty = product_qty;
        this.product_total_price = product_total_price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public Integer getProduct_qty() {
        return product_qty;
    }

    public Double getProduct_total_price() {
        return product_total_price;
    }
}
