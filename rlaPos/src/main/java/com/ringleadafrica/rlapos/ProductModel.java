package com.ringleadafrica.rlapos;

public class ProductModel {

    private Integer id;
    private String name;
    private String description;
    private String barcode;
    private String measurement_unit;
    private Double cost_price;
    private Double selling_price;
    private Integer category_id;
    private Integer supplier_id;

    public ProductModel(Integer id, String name, String description, String barcode, String measurement_unit, Double cost_price, Double selling_price, Integer category_id, Integer supplier_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.measurement_unit = measurement_unit;
        this.cost_price = cost_price;
        this.selling_price = selling_price;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getMeasurement_unit() {
        return measurement_unit;
    }

    public Double getCost_price() {
        return cost_price;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }
}
