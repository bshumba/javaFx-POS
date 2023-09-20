package com.ringleadafrica.rlapos;

import java.sql.Timestamp;

public class TransactionModel {

   private Integer id;
   private String transaction_type;
   private Double amount;
   private String payment_channel;
   private Integer user_id;
   private Timestamp created_at;

   public TransactionModel(Integer id, String transaction_type, Double amount, String payment_channel, Integer user_id, Timestamp created_at) {
      this.id = id;
      this.transaction_type = transaction_type;
      this.amount = amount;
      this.payment_channel = payment_channel;
      this.user_id = user_id;
      this.created_at = created_at;
   }

   public Integer getId() {
      return id;
   }

   public String getTransaction_type() {
      return transaction_type;
   }

   public Double getAmount() {
      return amount;
   }

   public String getPayment_channel() {
      return payment_channel;
   }

   public Integer getUser_id() {
      return user_id;
   }

   public Timestamp getCreated_at() {
      return created_at;
   }
}
