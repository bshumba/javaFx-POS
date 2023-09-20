package com.ringleadafrica.rlapos;

import java.sql.Timestamp;

public class InventoryModel {

   private Integer id;
   private Integer product_id;
   private Integer quantity;
   private Integer economic_order_quantity;
   private Timestamp created_at;

   public InventoryModel(Integer id, Integer product_id, Integer quantity, Integer economic_order_quantity, Timestamp created_at) {
      this.id = id;
      this.product_id = product_id;
      this.quantity = quantity;
      this.economic_order_quantity = economic_order_quantity;
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

   public Integer getEconomic_order_quantity() {
      return economic_order_quantity;
   }

   public Timestamp getCreated_at() {
      return created_at;
   }
}
