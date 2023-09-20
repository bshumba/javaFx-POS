package com.ringleadafrica.rlapos;

import com.ringleadafrica.rlapos.dialog.AddQuantityDialog;
import com.ringleadafrica.rlapos.dialog.ConfirmationDialog;
import com.ringleadafrica.rlapos.dialog.PayDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TellerFormController implements Initializable {

   @FXML
   private Button addToCartBtn;

   @FXML
   private Button cancelPayBtn;

   @FXML
   private Button cancelSelectedProdBtn;

   @FXML
   private TableColumn<CartModel, Integer> cartProdId_col;

   @FXML
   private TableColumn<CartModel, String> cartProdName_col;

   @FXML
   private TableColumn<CartModel, Double> cartProdPrice_col;

   @FXML
   private TableColumn<CartModel, Integer> cartProdQty_col;

   @FXML
   private TableColumn<CartModel, Double> cartProdTotPrice_col;

   @FXML
   private TableView<CartModel> cartProducts_tableView;

   @FXML
   private Button dropFromCartBtn;

   @FXML
   private Button logoutBtn;

   @FXML
   private TextField netPayable_txtf;

   @FXML
   private TableColumn<ProductModel, String> prodName_col;

   @FXML
   private TableView<ProductModel> products_tableView;

   @FXML
   private Button removeAllFromCartBtn;

   @FXML
   private TextField searchProduct_txtf;

   @FXML
   private Label selectedProdCostPrice;

   @FXML
   private TextField selectedProdDesc;

   @FXML
   private Label selectedProdId;

   @FXML
   private TextField selectedProdName;

   @FXML
   private TextField selectedProdPrice;

   @FXML
   private TextField selectedProdQty;

   @FXML
   private Label selectedProdStock;

   @FXML
   private TextField subTotal_txtf;

   @FXML
   private Button usdPayBtn;

   @FXML
   private Label username;

   @FXML
   private TextField vat_txtf;

   @FXML
   private Button zwlPayBtn;

//   Quantity Dialog Pane FXML Variables
   @FXML
   private Button dialogAddQtyBtn;

   @FXML
   private Button dialogCancelBtn;

   @FXML
   private Button dialogDropProdBtn;

   @FXML
   private TextField dialogQuantity_txt;

   private Connection connect;
   private PreparedStatement prepare;
   private ResultSet result;

   private String currency;

   private Alert alert;

   private ObservableList<ProductModel> productsListData = FXCollections.observableArrayList();

   //    GET ALL PRODUCTS
   public ObservableList<ProductModel> getAllProducts() {

      ObservableList<ProductModel> listProducts = FXCollections.observableArrayList();

      String sql = "SELECT * FROM products";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         ProductModel prodList;

         int prodId;
         while (result.next()) {

            prodId = result.getInt("id");

            String checkStock = "SELECT quantity FROM inventory WHERE id = '" + prodId + "' ";

            try {

               ResultSet result1;

               prepare = connect.prepareStatement(checkStock);
               result1 = prepare.executeQuery();

               if (result1.next()) {

                  int qty = result1.getInt("quantity");

                  if (qty > 0) {
                     prodList = new ProductModel(result.getInt("id"),
                             result.getString("name"),
                             result.getString("description"),
                             result.getString("barcode"),
                             result.getString("measurement_unit"),
                             result.getDouble("cost_price"),
                             result.getDouble("selling_price"),
                             result.getInt("category_id"),
                             result.getInt("category_id"));

                     listProducts.add(prodList);
                  }

               }

            } catch (Exception e) {
               e.printStackTrace();
            }

         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return listProducts;
   }

   //    This is For Displaying Products The table
   private ObservableList<ProductModel> allProductsList;

   public void displayAllProducts() {

      allProductsList = getAllProducts();

      prodName_col.setCellValueFactory(new PropertyValueFactory<>("name"));

      products_tableView.setItems(allProductsList);

      searchProduct();
   }

   public void searchProduct() {
      FilteredList<ProductModel> filteredProducts = new FilteredList<>(allProductsList, e -> true);

      searchProduct_txtf.textProperty().addListener((observable, oldValue, newValue) -> {

         filteredProducts.setPredicate(productModel -> {

//                IF THERE IS NO SEARCH THEN DISPLAY ALL RECORDS
            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
               return true;
            }

            String searchKeyword = newValue.toLowerCase();

            if (productModel.getName().toLowerCase().indexOf(searchKeyword) > -1) {
               return true;
            } else if (productModel.getBarcode().toLowerCase().contains(searchKeyword)) {
               return true;
            } else {
               return false; // NO MATCH FOUND
            }
         });
      });

      SortedList<ProductModel> sortedProductList = new SortedList<>(filteredProducts);

//      Bind sorted Products with table view
      sortedProductList.comparatorProperty().bind(products_tableView.comparatorProperty());

//      APPLY / DISPLAY FILTERED AND SORTED PRODUCTS TO THE TABLE VIEW
      products_tableView.setItems(sortedProductList);
   }

   public void selectProduct() {

      ProductModel getSelectedProd = products_tableView.getSelectionModel().getSelectedItem();
      int num = products_tableView.getSelectionModel().getSelectedIndex();

      if ((num - 1) < -1) {
         return;
      }

      int prodId = getSelectedProd.getId();

      String sql = "SELECT * FROM inventory WHERE product_id = '" + prodId + "'";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         if (result.next()) {

            selectedProdStock.setText(String.valueOf(result.getInt("quantity")));

            selectedProdId.setText(String.valueOf(getSelectedProd.getId()));
            selectedProdName.setText(getSelectedProd.getName());
            selectedProdPrice.setText(String.valueOf(getSelectedProd.getSelling_price()));
            selectedProdQty.setText("1");
            selectedProdDesc.setText(getSelectedProd.getDescription());
            selectedProdCostPrice.setText(String.valueOf(getSelectedProd.getCost_price()));
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void addToCartBtn() {

      if (selectedProdQty.getText().isEmpty() || selectedProdQty.getText().isBlank()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all blank fields");
         alert.showAndWait();
      } else {

         int prodQty = Integer.valueOf(selectedProdQty.getText());

         if (prodQty < 1 || prodQty > Integer.valueOf(selectedProdStock.getText())) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Quantity Can Not Be Less Than 1 Or More Than Available Stock!");
            alert.showAndWait();

         } else {

            int SProdId = Integer.valueOf(selectedProdId.getText());

            String checkProdInCart = "SELECT * FROM cart WHERE product_id = '" + SProdId + "'";

            connect = Database.DbConnection();

            try {

               prepare = connect.prepareStatement(checkProdInCart);
               result = prepare.executeQuery();

               if (result.next()) {

                  int oldQty, newQty;
                  double oldTotalPrice, newTotalPrice;

                  oldQty = result.getInt("product_qty");
                  newQty = oldQty + Integer.valueOf(selectedProdQty.getText());

                  oldTotalPrice = result.getDouble("product_total_price");
                  newTotalPrice = (Integer.valueOf(selectedProdQty.getText()) * Double.valueOf(selectedProdPrice.getText())) + oldTotalPrice;

                  String sql = "UPDATE cart SET product_qty = '"
                          + newQty + "', product_total_price = '"
                          + newTotalPrice + "' WHERE product_id = '" + SProdId + "'";

                  connect = Database.DbConnection();

                  try {

                     prepare = connect.prepareStatement(sql);
                     prepare.executeUpdate();

                     displayCartProducts();
                     displayProductsTotalCost();
                     clear();

                  } catch (Exception e) {
                     e.printStackTrace();
                  }

               } else {

                  String sql = "INSERT INTO cart" +
                          " (product_id, product_name, product_price, product_qty, product_total_price, currency, cost_price)" +
                          " VALUES(?,?,?,?,?,?,?)";

                  connect = Database.DbConnection();

                  try {

                     prepare = connect.prepareStatement(sql);
                     prepare.setString(1, selectedProdId.getText());
                     prepare.setString(2, selectedProdName.getText());
                     prepare.setString(3, selectedProdPrice.getText());
                     prepare.setString(4, selectedProdQty.getText());
                     double totPrice = prodQty * Double.valueOf(selectedProdPrice.getText());
                     prepare.setString(5, String.valueOf(totPrice));
                     prepare.setString(6, "USD");
                     prepare.setString(7, selectedProdCostPrice.getText());

                     prepare.executeUpdate();

                     displayCartProducts();
                     displayProductsTotalCost();
                     clear();

                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            } catch (Exception e) {
               e.printStackTrace();
            }

         }
      }
   }

   private ObservableList<CartModel> cartProductsListData = FXCollections.observableArrayList();

   //    GET ALL PRODUCTS IN THE CART
   public ObservableList<CartModel> getAllCartProducts() {

      ObservableList<CartModel> listCartProducts = FXCollections.observableArrayList();

      String sql = "SELECT * FROM cart";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         CartModel cartProdList;

         while (result.next()) {

            cartProdList = new CartModel(result.getInt("id"),
                    result.getInt("product_id"),
                    result.getString("product_name"),
                    result.getDouble("product_price"),
                    result.getInt("product_qty"),
                    result.getDouble("product_total_price"));

            listCartProducts.add(cartProdList);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return listCartProducts;
   }

   //    Display Cart Products On The Table view
   private ObservableList<CartModel> allCartProducts;

   public void displayCartProducts() {

      allCartProducts = getAllCartProducts();

      cartProdId_col.setCellValueFactory(new PropertyValueFactory<>("product_id"));
      cartProdName_col.setCellValueFactory(new PropertyValueFactory<>("product_name"));
      cartProdPrice_col.setCellValueFactory(new PropertyValueFactory<>("product_price"));
      cartProdQty_col.setCellValueFactory(new PropertyValueFactory<>("product_qty"));
      cartProdTotPrice_col.setCellValueFactory(new PropertyValueFactory<>("product_total_price"));

      cartProducts_tableView.setItems(allCartProducts);

   }

   public void selectedCartProd() {

      CartModel getSelectedCartProd = cartProducts_tableView.getSelectionModel().getSelectedItem();
      int num = cartProducts_tableView.getSelectionModel().getSelectedIndex();

      if ((num - 1) < -1) {
         return;
      }

      int selectedProdId = getSelectedCartProd.getId();

      int oldQty = getSelectedCartProd.getProduct_qty();
      int newQty = AddQuantityDialog.addQuantity(oldQty);

      if (newQty == -1) {

         String confirmation = ConfirmationDialog.managerConfirm();

         if (confirmation.equals("yes")) {

            String sqlDrop = "DELETE FROM cart WHERE id = '" + selectedProdId + "'";

            connect = Database.DbConnection();

            try {

               prepare = connect.prepareStatement(sqlDrop);
               prepare.executeUpdate();

               displayCartProducts();
               displayProductsTotalCost();
               clear();

            } catch (Exception e) {
               e.printStackTrace();
            }
         }

      } else {
         newQty = newQty + oldQty;

         if (oldQty != newQty) {

            int prodId = getSelectedCartProd.getProduct_id();
            int stock;

            String sqlQty = "SELECT * FROM inventory WHERE product_id = '" + prodId + "'";

            connect = Database.DbConnection();

            try {

               prepare = connect.prepareStatement(sqlQty);
               ResultSet resultQty = prepare.executeQuery();

               if (resultQty.next()) {

                  stock = resultQty.getInt("quantity");

                  if (newQty > stock || newQty < 1) {

                     alert = new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("Error Message");
                     alert.setHeaderText(null);
                     alert.setContentText("Quantity Can Not Be Less Than 1 Or More Than Available Stock!");
                     alert.showAndWait();

                  } else {

                     double totP = newQty * getSelectedCartProd.getProduct_price();

                     String sql = "UPDATE cart SET product_qty = '"
                             + newQty + "', product_total_price = '"
                             + totP + "' WHERE id = '" + selectedProdId + "'";

                     connect = Database.DbConnection();

                     try {

                        prepare = connect.prepareStatement(sql);
                        prepare.executeUpdate();

                        displayCartProducts();
                        displayProductsTotalCost();
                        clear();

                     } catch (Exception e) {
                        e.printStackTrace();
                     }
                  }
               }
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }
   }

   public void clear() {
      selectedProdId.setText("0");
      selectedProdName.setText("");
      selectedProdPrice.setText("");
      selectedProdQty.setText("");
      selectedProdStock.setText("0");
      selectedProdDesc.setText("");
      selectedProdCostPrice.setText("");
   }

   private double totalP;

   public void productsTotalCost() {

      String total = "SELECT SUM(product_total_price) FROM cart";

      connect = Database.DbConnection();
      try {

         prepare = connect.prepareStatement(total);
         result = prepare.executeQuery();

         if (result.next()) {
            totalP = result.getDouble("SUM(product_total_price)");
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void displayProductsTotalCost() {
      productsTotalCost();
      subTotal_txtf.setText(String.valueOf(totalP));
      netPayable_txtf.setText(String.valueOf(totalP));
   }

   //    USD PAYMENT
   public void makeUsdPayBtn() {

      checkCartCurrency();

      if (currency.equals("ZWL")) {
         convertZwlToUsd();
      }

      if (Double.valueOf(netPayable_txtf.getText()) <= 0) {

         alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Warning Message");
         alert.setHeaderText(null);
         alert.setContentText("There are no products in the cart!!!");
         alert.showAndWait();

      } else {

         Double amount = PayDialog.makePayment(Double.valueOf(netPayable_txtf.getText()));

         if (amount == -1.0) {

            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Payment has been canceled");
            alert.showAndWait();

         } else {

            String sqlTransaction = "INSERT INTO transactions " +
                    "(transaction_type, amount, payment_channel, user_id)" +
                    " VALUES(?,?,?,?)";

            int transId = 0;
            connect = Database.DbConnection();

            try {

               String transactionsCols[] = new String[] { "id" };

               prepare = connect.prepareStatement(sqlTransaction, transactionsCols);
               prepare.setString(1, "sale");
               prepare.setString(2, netPayable_txtf.getText());
               prepare.setString(3, "USD");
               prepare.setString(4, String.valueOf(PersonalInfo.id));

               prepare.executeUpdate();
               result = prepare.getGeneratedKeys();

               if (result.next()) {
                  transId = result.getInt(1);

                  String cartProds = "SELECT * FROM cart";

                  try {

                     ResultSet cartResultSet;

                     prepare = connect.prepareStatement(cartProds);
                     cartResultSet = prepare.executeQuery();

                     while (cartResultSet.next()) {

//                            Retrieve details needed in the sales table
                        int cartProId = cartResultSet.getInt("product_id");
                        double cartProdPrice = cartResultSet.getDouble("product_price");
                        int cartProdQty = cartResultSet.getInt("product_qty");
                        double cartProdCostPrice = cartResultSet.getDouble("cost_price");

//                            INSERT INTO SALES TABLE
                        String sqlSales = "INSERT INTO sales " +
                                "(product_id, quantity, unit_cost_price, unit_selling_price, transaction_id)" +
                                " VALUES(?,?,?,?,?)";

                        try {

                           prepare = connect.prepareStatement(sqlSales);
                           prepare.setString(1, String.valueOf(cartProId));
                           prepare.setString(2, String.valueOf(cartProdQty));
                           prepare.setString(3, String.valueOf(cartProdCostPrice));
                           prepare.setString(4, String.valueOf(cartProdPrice));
                           prepare.setString(5, String.valueOf(transId));

                           prepare.executeUpdate();

//                                SELECT INVENTORY QUANTITY FOR THE PRODUCTS IN CART ONLY
                           String sqlSelectInventory = "SELECT quantity FROM inventory WHERE product_id = '"
                                   + cartProId + "'";

                           try {

                              prepare = connect.prepareStatement(sqlSelectInventory);
                              ResultSet InvQtyresultSet = prepare.executeQuery();

                              if (InvQtyresultSet.next()) {

                                 int oldQty, newQty;
                                 oldQty = InvQtyresultSet.getInt("quantity");

                                 newQty = oldQty - cartProdQty;

//                              UPDATE PRODUCT STOCK IN THE INVENTORY TABLE
                                 String sqlInventory = "UPDATE inventory SET quantity = '"
                                         + newQty + "' WHERE product_id = '" + cartProId + "'";

                                 try {

                                    prepare = connect.prepareStatement(sqlInventory);
                                    prepare.executeUpdate();

                                 } catch (Exception e) {
                                    e.printStackTrace();
                                 }
                              }
                           } catch (Exception e) {
                              e.printStackTrace();
                           }

                        } catch (Exception e) {
                           e.printStackTrace();
                        }

                     }

                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }

            } catch (Exception e) {
               e.printStackTrace();
            }

            emptyCart();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success Message");
            alert.setHeaderText(null);
            alert.setContentText("Transaction Success");
            alert.showAndWait();
         }

      }
   }

   public void checkCartCurrency() {

      String sql = "SELECT currency FROM cart";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         while (result.next()) {
            currency = result.getString("currency");
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

//   CONVERT ZWL PRICES TO USD
public void convertZwlToUsd() {

   String sqlRate = "SELECT rate FROM exchange_rates";

   connect = Database.DbConnection();

   try {

      prepare = connect.prepareStatement(sqlRate);
      result = prepare.executeQuery();

      if (result.next()) {

         double rate = result.getDouble("rate");

         String cartProds = "SELECT * FROM cart WHERE currency = '" + "ZWL" + "'";

         connect = Database.DbConnection();

         try {

            ResultSet cartResultSet;

            prepare = connect.prepareStatement(cartProds);
            cartResultSet = prepare.executeQuery();

            while (cartResultSet.next()) {

//                            Retrieve details needed in the sales table
               int cartProId = cartResultSet.getInt("product_id");
               double cartProdPrice = cartResultSet.getDouble("product_price") / rate;
               double cartProdTotPrice = cartResultSet.getDouble("product_total_price") / rate;
               double cartProdCostPrice = cartResultSet.getDouble("cost_price") / rate;

//                            UPDATE CART TABLE PRICES
               String sqlSales = "UPDATE cart SET product_price = '"
                       + cartProdPrice + "', product_total_price = '"
                       + cartProdTotPrice + "', currency = '"
                       + "USD" + "', cost_price = '"
                       + cartProdCostPrice + "' WHERE product_id = '" + cartProId + "'";

               try {

                  prepare = connect.prepareStatement(sqlSales);
                  prepare.executeUpdate();

               } catch (Exception e) {
                  e.printStackTrace();
               }

            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   } catch (Exception e) {
      e.printStackTrace();
   }

   displayProductsTotalCost();

}

//   Convert USD PRICES TO ZWL
   public void convertUsdToZwl() {

      String sqlRate = "SELECT rate FROM exchange_rates";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sqlRate);
         result = prepare.executeQuery();

         if (result.next()) {

            double rate = result.getDouble("rate");

            String cartProds = "SELECT * FROM cart WHERE currency = '" + "USD" + "'";

            connect = Database.DbConnection();

            try {

               ResultSet cartResultSet;

               prepare = connect.prepareStatement(cartProds);
               cartResultSet = prepare.executeQuery();

               while (cartResultSet.next()) {

//                            Retrieve details needed in the sales table
                  int cartProId = cartResultSet.getInt("product_id");
                  double cartProdPrice = cartResultSet.getDouble("product_price") * rate;
                  double cartProdTotPrice = cartResultSet.getDouble("product_total_price") * rate;
                  double cartProdCostPrice = cartResultSet.getDouble("cost_price") * rate;

//                            UPDATE CART TABLE PRICES
                  String sqlSales = "UPDATE cart SET product_price = '"
                          + cartProdPrice + "', product_total_price = '"
                          + cartProdTotPrice + "', currency = '"
                          + "ZWL" + "', cost_price = '"
                          + cartProdCostPrice + "' WHERE product_id = '" + cartProId + "'";

                  try {

                     prepare = connect.prepareStatement(sqlSales);
                     prepare.executeUpdate();

                  } catch (Exception e) {
                     e.printStackTrace();
                  }

               }

            } catch (Exception e) {
               e.printStackTrace();
            }
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      displayProductsTotalCost();

   }

//   ZWL PAYMENT
public void makeZwlPayBtn() {

   checkCartCurrency();

   if (currency.equals("USD")) {
      convertUsdToZwl();
   }

   if (Double.valueOf(netPayable_txtf.getText()) <= 0) {

      alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Warning Message");
      alert.setHeaderText(null);
      alert.setContentText("There are no products in the cart!!!");
      alert.showAndWait();

   } else {

      Double amount = PayDialog.makePayment(Double.valueOf(netPayable_txtf.getText()));

      if (amount == -1.0) {

         alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Warning Message");
         alert.setHeaderText(null);
         alert.setContentText("Payment has been canceled");
         alert.showAndWait();

      } else {

         String sqlTransaction = "INSERT INTO transactions " +
                 "(transaction_type, amount, payment_channel, user_id)" +
                 " VALUES(?,?,?,?)";

         int transId = 0;
         connect = Database.DbConnection();

         try {

            String transactionsCols[] = new String[] { "id" };

            prepare = connect.prepareStatement(sqlTransaction, transactionsCols);
            prepare.setString(1, "sale");
            prepare.setString(2, netPayable_txtf.getText());
            prepare.setString(3, "ZWL");
            prepare.setString(4, String.valueOf(PersonalInfo.id));

            prepare.executeUpdate();
            result = prepare.getGeneratedKeys();

            if (result.next()) {
               transId = result.getInt(1);

               String cartProds = "SELECT * FROM cart";

               try {

                  ResultSet cartResultSet;

                  prepare = connect.prepareStatement(cartProds);
                  cartResultSet = prepare.executeQuery();

                  while (cartResultSet.next()) {

//                            Retrieve details needed in the sales table
                     int cartProId = cartResultSet.getInt("product_id");
                     double cartProdPrice = cartResultSet.getDouble("product_price");
                     int cartProdQty = cartResultSet.getInt("product_qty");
                     double cartProdCostPrice = cartResultSet.getDouble("cost_price");

//                            INSERT INTO SALES TABLE
                     String sqlSales = "INSERT INTO sales " +
                             "(product_id, quantity, unit_cost_price, unit_selling_price, transaction_id)" +
                             " VALUES(?,?,?,?,?)";

                     try {

                        prepare = connect.prepareStatement(sqlSales);
                        prepare.setString(1, String.valueOf(cartProId));
                        prepare.setString(2, String.valueOf(cartProdQty));
                        prepare.setString(3, String.valueOf(cartProdCostPrice));
                        prepare.setString(4, String.valueOf(cartProdPrice));
                        prepare.setString(5, String.valueOf(transId));

                        prepare.executeUpdate();

//                                SELECT INVENTORY QUANTITY FOR THE PRODUCTS IN CART ONLY
                        String sqlSelectInventory = "SELECT quantity FROM inventory WHERE product_id = '"
                                + cartProId + "'";

                        try {

                           prepare = connect.prepareStatement(sqlSelectInventory);
                           ResultSet InvQtyresultSet = prepare.executeQuery();

                           if (InvQtyresultSet.next()) {

                              int oldQty, newQty;
                              oldQty = InvQtyresultSet.getInt("quantity");

                              newQty = oldQty - cartProdQty;

//                              UPDATE PRODUCT STOCK IN THE INVENTORY TABLE
                              String sqlInventory = "UPDATE inventory SET quantity = '"
                                      + newQty + "' WHERE product_id = '" + cartProId + "'";

                              try {

                                 prepare = connect.prepareStatement(sqlInventory);
                                 prepare.executeUpdate();

                              } catch (Exception e) {
                                 e.printStackTrace();
                              }
                           }
                        } catch (Exception e) {
                           e.printStackTrace();
                        }

                     } catch (Exception e) {
                        e.printStackTrace();
                     }

                  }

               } catch (Exception e) {
                  e.printStackTrace();
               }
            }

         } catch (Exception e) {
            e.printStackTrace();
         }

         emptyCart();

         alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success Message");
         alert.setHeaderText(null);
         alert.setContentText("Transaction Success");
         alert.showAndWait();
      }

   }
}

//   REMOVE EVERYTHING FROM THE CART
   public void emptyCart() {

      String sql = "DELETE FROM cart";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         prepare.executeUpdate();

         displayCartProducts();
         displayProductsTotalCost();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void displayUsername() {

      username.setText(PersonalInfo.username);
   }

   @Override
   public void initialize(URL location, ResourceBundle resource) {

      displayUsername();
      displayAllProducts();
      displayCartProducts();
      displayProductsTotalCost();
   }
}
