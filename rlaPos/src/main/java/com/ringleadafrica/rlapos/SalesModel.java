package com.ringleadafrica.rlapos;

import java.sql.Timestamp;

public class SalesModel {

   private Integer id;
   private Integer product_id;
   private Integer quantity;
   private Double unit_cost_price;
   private Double unit_selling_price;
   private Integer transaction_id;
   private Timestamp created_at;

   public SalesModel(Integer id, Integer product_id, Integer quantity, Double unit_cost_price, Double unit_selling_price, Integer transaction_id, Timestamp created_at) {
      this.id = id;
      this.product_id = product_id;
      this.quantity = quantity;
      this.unit_cost_price = unit_cost_price;
      this.unit_selling_price = unit_selling_price;
      this.transaction_id = transaction_id;
      this.created_at = created_at;
   }

   public Integer getId() {
      return id;
   }

   public Integer getProduct_id() {
      return product_id;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public Double getUnit_cost_price() {
      return unit_cost_price;
   }

   public Double getUnit_selling_price() {
      return unit_selling_price;
   }

   public Integer getTransaction_id() {
      return transaction_id;
   }

   public Timestamp getCreated_at() {
      return created_at;
   }
}
