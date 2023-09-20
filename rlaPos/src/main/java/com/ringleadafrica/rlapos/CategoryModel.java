package com.ringleadafrica.rlapos;

import java.sql.Timestamp;

public class CategoryModel {

   private Integer id;
   private String name;
   private String description;
   private Timestamp created_at;

   public CategoryModel(Integer id, String name, String description, Timestamp created_at) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.created_at = created_at;
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

   public Timestamp getCreated_at() {
      return created_at;
   }
}
