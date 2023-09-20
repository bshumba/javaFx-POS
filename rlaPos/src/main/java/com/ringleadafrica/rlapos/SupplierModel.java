package com.ringleadafrica.rlapos;

import java.sql.Timestamp;

public class SupplierModel {

   private Integer id;
   private String supplier_name;
   private String email;
   private String phone_number;
   private String address;
   private Timestamp created_at;

   public SupplierModel(Integer id, String supplier_name, String email, String phone_number, String address, Timestamp created_at) {
      this.id = id;
      this.supplier_name = supplier_name;
      this.email = email;
      this.phone_number = phone_number;
      this.address = address;
      this.created_at = created_at;
   }

   public Integer getId() {
      return id;
   }

   public String getSupplier_name() {
      return supplier_name;
   }

   public String getEmail() {
      return email;
   }

   public String getPhone_number() {
      return phone_number;
   }

   public String getAddress() {
      return address;
   }

   public Timestamp getCreated_at() {
      return created_at;
   }
}
