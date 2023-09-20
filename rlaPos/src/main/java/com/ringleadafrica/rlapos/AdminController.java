package com.ringleadafrica.rlapos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

   @FXML
   private Button addCategory_btn;

   @FXML
   private Button addInv_btn;

   @FXML
   private Button addProd_btn;

   @FXML
   private Button addSupplier_btn;

   @FXML
   private Button addUser_btn;

   @FXML
   private TextArea address_txt;

   @FXML
   private TableView<ProductModel> adminProductsTableView;

   @FXML
   private TextField barcode_txt;

   @FXML
   private Button cancelCategory_btn;

   @FXML
   private Button cancelInv_btn;

   @FXML
   private Button cancelProd_btn;

   @FXML
   private Button cancelSupplier_btn;

   @FXML
   private Button cancelUser_btn;

   @FXML
   private AnchorPane categories_form;

   @FXML
   private TableColumn<CategoryModel, Timestamp> categoryDate_col;

   @FXML
   private TableColumn<CategoryModel, String> categoryDesc_col;

   @FXML
   private TextField categoryDesc_txt;

   @FXML
   private TableColumn<CategoryModel, Integer> categoryId_col;

   @FXML
   private Label categoryId_lbl;

   @FXML
   private TableColumn<CategoryModel, String> categoryName_col;

   @FXML
   private TextField categoryName_txt;

   @FXML
   private TableView<CategoryModel> categoryTableView;

   @FXML
   private ComboBox<?> category_combo;

   @FXML
   private Button categrories_btn;

   @FXML
   private TextField costPrice_txt;

   @FXML
   private Button dashboard_btn;

   @FXML
   private AnchorPane dashboard_form;

   @FXML
   private Button deleteCategory_btn;

   @FXML
   private Button deleteProd_btn;

   @FXML
   private Button deleteSupplier_btn;

   @FXML
   private Button deleteUser_btn;

   @FXML
   private TextField email_txt;

   @FXML
   private TextField fName_txt;

   @FXML
   private TableColumn<InventoryModel, Integer> invEOQ_col;

   @FXML
   private TableColumn<InventoryModel, Integer> invId_col;

   @FXML
   private TableColumn<InventoryModel, Integer> invProdId_col;

   @FXML
   private TableColumn<InventoryModel, Integer> invProdQty_col;

   @FXML
   private TextField inv_prodEOQ_txt;

   @FXML
   private ComboBox<?> inv_prodId_combo;

   @FXML
   private TextField inv_prodQty_txt;

   @FXML
   private TextField inv_searchProdId;

   @FXML
   private Label inventoryId_lbl;

   @FXML
   private TableView<InventoryModel> inventoryTableView;

   @FXML
   private Button inventory_btn;

   @FXML
   private AnchorPane inventory_form;

   @FXML
   private Button logout_btn;

   @FXML
   private TextField measurementUnit_txt;

   @FXML
   private TextField nationalID_txt;

   @FXML
   private Button notifications_btn;

   @FXML
   private PasswordField password_txt;

   @FXML
   private TextField phone_txt;

   @FXML
   private TableColumn<ProductModel, String> prodBarcode_col;

   @FXML
   private TableColumn<ProductModel, Integer> prodCategory_col;

   @FXML
   private TableColumn<ProductModel, Double> prodCostPrice_col;

   @FXML
   private TableColumn<ProductModel, String> prodDesc_col;

   @FXML
   private TextArea prodDesc_txt;

   @FXML
   private Label prodId_lbl;

   @FXML
   private TableColumn<ProductModel, String> prodMeasurement_col;

   @FXML
   private TableColumn<ProductModel, String> prodName_col;

   @FXML
   private TextField prodName_txt;

   @FXML
   private TableColumn<ProductModel, Double> prodSellingPrice_col;

   @FXML
   private TableColumn<ProductModel, Integer> prodSupplier_col;

   @FXML
   private Button products_btn;

   @FXML
   private AnchorPane products_form;

   @FXML
   private ComboBox<?> role_combo;

   @FXML
   private TableColumn<SalesModel, Timestamp> saleDate_col;

   @FXML
   private TableColumn<SalesModel, Integer> saleId_col;

   @FXML
   private TableColumn<SalesModel, Integer> saleProdId_col;

   @FXML
   private TableColumn<SalesModel, Integer> saleQuantity_col;

   @FXML
   private TableColumn<SalesModel, Double> saleSellingPrice_col;

   @FXML
   private TableColumn<SalesModel, Integer> saleTransactionId_col;

   @FXML
   private TableColumn<SalesModel, Double> saleUnitCost_col;

   @FXML
   private TableView<SalesModel> salesTableView;

   @FXML
   private Button sales_btn;

   @FXML
   private AnchorPane sales_form;

   @FXML
   private TextField searchCategory_txt;

   @FXML
   private TextField searchProd_txt;

   @FXML
   private TextField searchSale_txt;

   @FXML
   private TextField searchSupplier_txt;

   @FXML
   private TextField searchTransact_txt;

   @FXML
   private TextField searchUser_txt;

   @FXML
   private TextField sellingPrice_txt;

   @FXML
   private TableColumn<SupplierModel, String> supplierAddress_col;

   @FXML
   private TextArea supplierAddress_txt;

   @FXML
   private TableColumn<SupplierModel, Timestamp> supplierDate_col;

   @FXML
   private TableColumn<SupplierModel, String> supplierEmail_col;

   @FXML
   private TextField supplierEmail_txt;

   @FXML
   private TableColumn<SupplierModel, Integer> supplierId_col;

   @FXML
   private Label supplierId_lbl;

   @FXML
   private TableColumn<SupplierModel, String> supplierName_col;

   @FXML
   private TextField supplierName_txt;

   @FXML
   private TableColumn<SupplierModel, Integer> supplierPhone_col;

   @FXML
   private TextField supplierPhone_txt;

   @FXML
   private ComboBox<?> supplier_combo;

   @FXML
   private TableView<SupplierModel> suppliersTableView;

   @FXML
   private Button suppliers_btn;

   @FXML
   private AnchorPane suppliers_form;

   @FXML
   private TextField surname_txt;

   @FXML
   private TableColumn<TransactionModel, Double> transactionAmount_col;

   @FXML
   private TableColumn<TransactionModel, Timestamp> transactionDate_col;

   @FXML
   private TableColumn<TransactionModel, Integer> transactionId_col;

   @FXML
   private TableColumn<TransactionModel, String> transactionPayChannel_col;

   @FXML
   private TableColumn<TransactionModel, String> transactionType_col;

   @FXML
   private TableColumn<TransactionModel, Integer> transactionUserId_col;

   @FXML
   private TableView<TransactionModel> transactionsTableView;

   @FXML
   private Button transactions_btn;

   @FXML
   private AnchorPane transanctions_form;

   @FXML
   private Button updateCategory_btn;

   @FXML
   private Button updateInv_btn;

   @FXML
   private Button updateProd_btn;

   @FXML
   private Button updateSupplier_btn;

   @FXML
   private Button updateUser_btn;

   @FXML
   private Label userId_lbl;

   @FXML
   private Label username;

   @FXML
   private TextField username_txt;

   @FXML
   private TableColumn<UserModel, String> usersAddress_col;

   @FXML
   private TableColumn<UserModel, String> usersEmail_col;

   @FXML
   private TableColumn<UserModel, String> usersName_col;

   @FXML
   private TableColumn<UserModel, String> usersNationalId_col;

   @FXML
   private TableColumn<UserModel, String> usersPhone_col;

   @FXML
   private TableColumn<UserModel, String> usersRole_col;

   @FXML
   private TableColumn<UserModel, String> usersSurname_col;

   @FXML
   private TableView<UserModel> usersTableView;

   @FXML
   private TableColumn<UserModel, String> usersUsername_col;

   @FXML
   private Button users_btn;

   @FXML
   private AnchorPane users_form;

   private Connection connect;
   private PreparedStatement prepare;
   private ResultSet result;

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

         while (result.next()) {

                    prodList = new ProductModel(result.getInt("id"),
                    result.getString("name"),
                    result.getString("description"),
                    result.getString("barcode"),
                    result.getString("measurement_unit"),
                    result.getDouble("cost_price"),
                    result.getDouble("selling_price"),
                    result.getInt("category_id"),
                    result.getInt("supplier_id"));

            listProducts.add(prodList);

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
      prodDesc_col.setCellValueFactory(new PropertyValueFactory<>("description"));
      prodBarcode_col.setCellValueFactory(new PropertyValueFactory<>("barcode"));
      prodMeasurement_col.setCellValueFactory(new PropertyValueFactory<>("measurement_unit"));
      prodCategory_col.setCellValueFactory(new PropertyValueFactory<>("category_id"));
      prodSupplier_col.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
      prodCostPrice_col.setCellValueFactory(new PropertyValueFactory<>("cost_price"));
      prodSellingPrice_col.setCellValueFactory(new PropertyValueFactory<>("selling_price"));

      adminProductsTableView.setItems(allProductsList);

       searchProduct();

   }

   public void searchProduct() {
      FilteredList<ProductModel> filteredProducts = new FilteredList<>(allProductsList, e -> true);

      searchProd_txt.textProperty().addListener((observable, oldValue, newValue) -> {

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
      sortedProductList.comparatorProperty().bind(adminProductsTableView.comparatorProperty());

//      APPLY / DISPLAY FILTERED AND SORTED PRODUCTS TO THE TABLE VIEW
      adminProductsTableView.setItems(sortedProductList);
   }

//   Add Product
   public void addProduct() {

      if (prodName_txt.getText().isEmpty() || barcode_txt.getText().isEmpty()
              || measurementUnit_txt.getText().isEmpty() || costPrice_txt.getText().isEmpty()
              || sellingPrice_txt.getText().isEmpty() || prodDesc_txt.getText().isEmpty()
              || category_combo.getSelectionModel().getSelectedItem() == null
              || supplier_combo.getSelectionModel().getSelectedItem() == null) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();

      } else {

         String sql = "INSERT INTO products " +
                 "(name, description, barcode, measurement_unit, cost_price, selling_price, category_id, supplier_id) " +
                 "VALUES (?,?,?,?,?,?,?,?)";

         connect = Database.DbConnection();

         try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, prodName_txt.getText());
            prepare.setString(2, prodDesc_txt.getText());
            prepare.setString(3, barcode_txt.getText());
            prepare.setString(4, measurementUnit_txt.getText());
            prepare.setString(5, costPrice_txt.getText());
            prepare.setString(6, sellingPrice_txt.getText());

//            Split Category Id From Category name
            String categoryStr = String.valueOf(category_combo.getSelectionModel().getSelectedItem());
            String[] splitedCategID = categoryStr.split("-");
            String categId = splitedCategID[0];
            prepare.setString(7, categId);

//            Split Supplier Id From Supplier name
            String supplierStr = String.valueOf(supplier_combo.getSelectionModel().getSelectedItem());
            String[] splitedSupId = supplierStr.split("-");
            String supId = splitedSupId[0];
            prepare.setString(8, supId);

            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("product successfully added!");
            alert.showAndWait();

            displayAllProducts();
            clearProductsTxtF();

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Select Product
   public void selectedProduct() {

      ProductModel prodData = adminProductsTableView.getSelectionModel().getSelectedItem();
      int num = adminProductsTableView.getSelectionModel().getSelectedIndex();

      if((num - 1) < -1) {
         return;
      }

      prodId_lbl.setText(String.valueOf(prodData.getId()));
      prodName_txt.setText(prodData.getName());
      prodDesc_txt.setText(prodData.getDescription());
      barcode_txt.setText(prodData.getBarcode());
      measurementUnit_txt.setText(prodData.getMeasurement_unit());
      costPrice_txt.setText(String.valueOf(prodData.getCost_price()));
      sellingPrice_txt.setText(String.valueOf(prodData.getSelling_price()));

//      Split String
//      String str = "123-myname";
//      String[] prodsup = str.split("-", 1);
//      int cusid = Integer.valueOf(prodsup[1]);

      category_combo.getSelectionModel().select(prodData.getCategory_id() - 1);

      supplier_combo.getSelectionModel().select(prodData.getSupplier_id() - 1);

   }

//   Update Products
   public void updateProduct() {

      if (prodName_txt.getText().isEmpty() || barcode_txt.getText().isEmpty() || prodId_lbl.getText().isEmpty()
              || measurementUnit_txt.getText().isEmpty() || costPrice_txt.getText().isEmpty()
              || sellingPrice_txt.getText().isEmpty() || prodDesc_txt.getText().isEmpty()
              || category_combo.getSelectionModel().getSelectedItem() == null
              || supplier_combo.getSelectionModel().getSelectedItem() == null) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();

      } else {

         //            Split Category Id From Category name
         String categoryStr = String.valueOf(category_combo.getSelectionModel().getSelectedItem());
         String[] splitedCategID = categoryStr.split("-");
         String categId = splitedCategID[0];

//            Split Supplier Id From Supplier name
         String supplierStr = String.valueOf(supplier_combo.getSelectionModel().getSelectedItem());
         String[] splitedSupId = supplierStr.split("-");
         String supId = splitedSupId[0];

         String sql = "UPDATE products SET name = '" + prodName_txt.getText() + "', description = '"
                 + prodDesc_txt.getText() + "', barcode = '"
                 + barcode_txt.getText() + "', measurement_unit = '"
                 + measurementUnit_txt.getText() + "', cost_price = '"
                 + costPrice_txt.getText() + "', selling_price = '"
                 + sellingPrice_txt.getText() +"', category_id = '"
                 + categId + "', supplier_id = '"
                 + supId + "' WHERE id = '"
                 + prodId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update product: " + prodId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Updated");
               alert.showAndWait();

               displayAllProducts();
               clearProductsTxtF();

            } else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();

            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Remove Product
   public void deleteProduct() {

      if (prodId_lbl.getText().isEmpty()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please Select The Product You Want To Delete");
         alert.showAndWait();

      } else {

         String sql = "DELETE FROM products WHERE id = '" + prodId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete product: " + prodId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Deleted");
               alert.showAndWait();

               displayAllProducts();
               clearProductsTxtF();

            } else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();
            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Clear Product Text Fields
   public void clearProductsTxtF() {
      prodId_lbl.setText("");
      prodName_txt.clear();
      prodDesc_txt.clear();
      barcode_txt.clear();
      measurementUnit_txt.clear();
      costPrice_txt.clear();
      sellingPrice_txt.clear();
      category_combo.getSelectionModel().clearSelection();
      supplier_combo.getSelectionModel().clearSelection();
   }

   //   Products List
   public void productsList() {

      List<String> listP = new ArrayList<>();
      String sql = "SELECT id, name  FROM products";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         while (result.next()) {

            listP.add(result.getString("id") + "-" + result.getString("name"));
         }

         ObservableList listProducts = FXCollections.observableArrayList(listP);
         inv_prodId_combo.setItems(listProducts);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

//   Add Category
   public void addCategory() {

      if (categoryName_txt.getText().isEmpty() || categoryDesc_txt.getText().isEmpty()) {
         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();
      } else {

         String sql = "INSERT INTO categories(name, description) VALUES(?,?)";

         connect = Database.DbConnection();

         try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, categoryName_txt.getText());
            prepare.setString(1, categoryDesc_txt.getText());

            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Category Added Successfully");
            alert.showAndWait();

            displayCategories();
            clearCategoriesFields();

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private ObservableList<CategoryModel> categoriesListData = FXCollections.observableArrayList();
//Get Categories
   public ObservableList<CategoryModel> getCategories() {

      ObservableList<CategoryModel> listCategories = FXCollections.observableArrayList();

      String sql = "SELECT * FROM categories";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         CategoryModel catList;

         while (result.next()) {
            catList = new CategoryModel(result.getInt("id"),
                    result.getString("name"),
                    result.getString("description"),
                    result.getTimestamp("created_at"));

            listCategories.add(catList);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return listCategories;
   }

//   Display Categories
   private ObservableList<CategoryModel> allCategories;
   public void displayCategories() {

      allCategories = getCategories();

      categoryId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
      categoryName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
      categoryDesc_col.setCellValueFactory(new PropertyValueFactory<>("description"));
      categoryDate_col.setCellValueFactory(new PropertyValueFactory<>("created_at"));

      categoryTableView.setItems(allCategories);

      searchCategory();

   }

//   Search Category
   public void searchCategory() {
      FilteredList<CategoryModel> filteredCategories = new FilteredList<>(allCategories, e -> true);

      searchCategory_txt.textProperty().addListener((observable, oldValue, newValue) -> {

         filteredCategories.setPredicate(categoryModel -> {

   //                IF THERE IS NO SEARCH THEN DISPLAY ALL RECORDS
            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
               return true;
            }

            String searchKeyword = newValue.toLowerCase();

            if (categoryModel.getId().equals(searchKeyword)) {
               return true;
            } else if (categoryModel.getName().toLowerCase().contains(searchKeyword)) {
               return true;
            } else {
               return false; // NO MATCH FOUND
            }
         });
   });

      SortedList<CategoryModel> sortedCategoriesList = new SortedList<>(filteredCategories);

   //      Bind sorted Categories with table view
         sortedCategoriesList.comparatorProperty().bind(categoryTableView.comparatorProperty());

   //      APPLY / DISPLAY FILTERED AND SORTED CATEGORIES TO THE TABLE VIEW
         categoryTableView.setItems(sortedCategoriesList);
   }

//   SELECT CATEGORY
   public void selectedCategory() {

      CategoryModel categoryData = categoryTableView.getSelectionModel().getSelectedItem();
      int num = categoryTableView.getSelectionModel().getSelectedIndex();

      if((num - 1) < -1) {
         return;
      }

      categoryId_lbl.setText(String.valueOf(categoryData.getId()));
      categoryName_txt.setText(categoryData.getName());
      categoryDesc_txt.setText(categoryData.getDescription());

   }

//   Categories List
   public void categoriesList() {

//      allCategories = getCategories();
      List<String> listC = new ArrayList<>();
      String sql = "SELECT * FROM categories";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         while (result.next()) {

            listC.add(result.getString("id") + "-" + result.getString("name"));
         }

         ObservableList listCategories = FXCollections.observableArrayList(listC);
         category_combo.setItems(listCategories);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

//   Update Category
   public void updateCategory() {

      if (categoryName_txt.getText().isEmpty()
              || categoryDesc_txt.getText().isEmpty()
              || categoryId_lbl.getText().isEmpty()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();

      } else {

         String sql = "UPDATE categories SET name = '" + categoryName_txt.getText() + "', description = '"
                 + categoryDesc_txt.getText() + "' WHERE id = '"
                 + categoryId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update category: " + categoryId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Updated");
               alert.showAndWait();

               displayCategories();
               clearCategoriesFields();

            } else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();

            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Delete Category
   public void deleteCategory() {

      if (categoryId_lbl.getText().isEmpty()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please Select The Category You Want To Delete");
         alert.showAndWait();

      } else {

         String sql = "DELETE FROM categories WHERE id = '" + categoryId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete category: " + categoryId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Deleted");
               alert.showAndWait();

               displayCategories();
               clearCategoriesFields();

            } else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();
            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Clear Categories Text Fields
   public void clearCategoriesFields() {

      categoryName_txt.clear();
      categoryDesc_txt.clear();
      categoryId_lbl.setText("");
   }

//   GET ALL INVENTORY
   public ObservableList<InventoryModel> getInventoryList() {

      ObservableList<InventoryModel> listSuppliers = FXCollections.observableArrayList();

      String sql = "SELECT * FROM inventory";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         InventoryModel invList;

         while (result.next()) {

            invList = new InventoryModel(result.getInt("id"),
                    result.getInt("product_id"),
                    result.getInt("quantity"),
                    result.getInt("economic_order_quantity"),
                    result.getTimestamp("created_at"));
            listSuppliers.add(invList);
         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return listSuppliers;
   }

//   Display Inventory
   private ObservableList<InventoryModel> listInv;
   public void displayAllInventory() {

      listInv = getInventoryList();

      invId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
      invProdId_col.setCellValueFactory(new PropertyValueFactory<>("product_id"));
      invProdQty_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
      invEOQ_col.setCellValueFactory(new PropertyValueFactory<>("economic_order_quantity"));

      inventoryTableView.setItems(listInv);

      searchInventory();
   }

   public void searchInventory() {
      FilteredList<InventoryModel> filteredInventory = new FilteredList<>(listInv, e -> true);

      inv_searchProdId.textProperty().addListener((observable, oldValue, newValue) -> {

         filteredInventory.setPredicate(inventoryModel -> {

//                IF THERE IS NO SEARCH THEN DISPLAY ALL RECORDS
            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
               return true;
            }

            int searchKeyword = Integer.valueOf(newValue.toLowerCase());

            if (inventoryModel.getProduct_id().equals(searchKeyword)) {
               return true;
            } else {
               return false; // NO MATCH FOUND
            }
         });
      });

      SortedList<InventoryModel> sortedInvList = new SortedList<>(filteredInventory);

//      Bind sorted Products with table view
      sortedInvList.comparatorProperty().bind(inventoryTableView.comparatorProperty());

//      APPLY / DISPLAY FILTERED AND SORTED PRODUCTS TO THE TABLE VIEW
      inventoryTableView.setItems(sortedInvList);
   }

//   Select Inventory
public void selectedInventory() {

   InventoryModel invData = inventoryTableView.getSelectionModel().getSelectedItem();
   int num = inventoryTableView.getSelectionModel().getSelectedIndex();

   if((num - 1) < -1) {
      return;
   }

   inventoryId_lbl.setText(String.valueOf(invData.getId()));
   inv_prodQty_txt.setText(String.valueOf(invData.getQuantity()));
   inv_prodEOQ_txt.setText(String.valueOf(invData.getEconomic_order_quantity()));

//      Split String
//      String str = "123-myname";
//      String[] prodsup = str.split("-", 1);
//      int cusid = Integer.valueOf(prodsup[1]);

   inv_prodId_combo.getSelectionModel().select(invData.getProduct_id() - 1);

}

// Update Inventory
   public void updateInventory() {

      if (inventoryId_lbl.getText().isEmpty() || inv_prodQty_txt.getText().isEmpty()
              || inv_prodEOQ_txt.getText().isEmpty()) {
         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();
      } else {

         String sql = "UPDATE inventory SET quantity = '"
                 + inv_prodQty_txt.getText() + "', economic_order_quantity = '"
                 + inv_prodEOQ_txt.getText() + "' WHERE id = '" + inventoryId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update product: " + inventoryId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully Updated");
               alert.showAndWait();

               displayAllInventory();
               clearInvTxt();

            } else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();

            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Cancel Inventory
   public void clearInvTxt() {

      inv_prodId_combo.getSelectionModel().clearSelection();
      inv_prodQty_txt.clear();
      inv_prodEOQ_txt.clear();
      inventoryId_lbl.setText("");
   }

//   Add Supplier
   public void addSupplier() {

      if (supplierName_txt.getText().isEmpty()
              || supplierEmail_txt.getText().isEmpty()
              || supplierPhone_txt.getText().isEmpty()
              || supplierAddress_txt.getText().isEmpty()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();

      } else {

         String sql = "INSERT INTO suppliers (supplier_name, email, phone_number, address) " +
                 " VALUES(?,?,?,?)";

         connect = Database.DbConnection();

         try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, supplierName_txt.getText());
            prepare.setString(2, supplierEmail_txt.getText());
            prepare.setString(3, supplierPhone_txt.getText());
            prepare.setString(4, supplierAddress_txt.getText());

            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added Supplier");
            alert.showAndWait();

            displaySuppliers();
            clearSupplier_txt();

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Get All Suppliers
   public ObservableList<SupplierModel> getSupplierList() {

      ObservableList<SupplierModel> listSuppliers = FXCollections.observableArrayList();

      String sql = "SELECT * FROM suppliers";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         SupplierModel supplData;

         while (result.next()) {
            supplData = new SupplierModel(result.getInt("id"),
                    result.getString("supplier_name"),
                    result.getString("email"),
                    result.getString("phone_number"),
                    result.getString("address"),
                    result.getTimestamp("created_at"));

            listSuppliers.add(supplData);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return  listSuppliers;
   }

   private ObservableList<SupplierModel> suppliersList;
//   Display Suppliers
   public void displaySuppliers() {

      suppliersList = getSupplierList();

      supplierId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
      supplierName_col.setCellValueFactory(new PropertyValueFactory<>("supplier_name"));
      supplierEmail_col.setCellValueFactory(new PropertyValueFactory<>("email"));
      supplierPhone_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
      supplierAddress_col.setCellValueFactory(new PropertyValueFactory<>("address"));
      supplierDate_col.setCellValueFactory(new PropertyValueFactory<>("created_at"));

      suppliersTableView.setItems(suppliersList);

      searchSupplier();
   }

//   Search Supplier
   public void searchSupplier() {

      FilteredList<SupplierModel> filteredSuppliers = new FilteredList<>(suppliersList, e -> true);

      searchSupplier_txt.textProperty().addListener((observable, oldValue, newValue) -> {

         filteredSuppliers.setPredicate(supplierModel -> {

//                IF THERE IS NO SEARCH THEN DISPLAY ALL RECORDS
            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
               return true;
            }

            String searchKeyword = newValue.toLowerCase();

            if (supplierModel.getId().equals(searchKeyword)) {
               return true;
            } else if (supplierModel.getSupplier_name().toLowerCase().contains(searchKeyword)) {
               return true;
            } else if (supplierModel.getEmail().toLowerCase().contains(searchKeyword)) {
               return true;
            } else if (supplierModel.getAddress().toLowerCase().contains(searchKeyword)) {
               return true;
            } else if (supplierModel.getPhone_number().equals(searchKeyword)) {
               return true;
            } else if (supplierModel.getCreated_at().equals(searchKeyword)) {
               return true;
            } else {
               return false; // NO MATCH FOUND
            }
         });
      });

      SortedList<SupplierModel> sortedSupplList = new SortedList<>(filteredSuppliers);

//      Bind sorted Suppliers with table view
      sortedSupplList.comparatorProperty().bind(suppliersTableView.comparatorProperty());

//      APPLY / DISPLAY FILTERED AND SORTED SUPPLIERS TO THE TABLE VIEW
      suppliersTableView.setItems(sortedSupplList);
   }

//   Select Supplier
   public void selectedSupplier() {

      SupplierModel supplData = suppliersTableView.getSelectionModel().getSelectedItem();
      int num = suppliersTableView.getSelectionModel().getSelectedIndex();

      if((num - 1) < -1) {
         return;
      }

      supplierId_lbl.setText(String.valueOf(supplData.getId()));
      supplierName_txt.setText(supplData.getSupplier_name());
      supplierEmail_txt.setText(supplData.getEmail());
      supplierPhone_txt.setText(supplData.getPhone_number());
      supplierAddress_txt.setText(supplData.getAddress());
   }

   //   Suppliers List
   public void suppliersList() {

      List<String> listS = new ArrayList<>();
      String sql = "SELECT id, supplier_name  FROM suppliers";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         while (result.next()) {

            listS.add(result.getString("id") + "-" + result.getString("supplier_name"));
         }

         ObservableList listSuppliers = FXCollections.observableArrayList(listS);
         supplier_combo.setItems(listSuppliers);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

//   Update Supplier
   public void updateSupplier() {

      if (supplierName_txt.getText().isEmpty()
              || supplierEmail_txt.getText().isEmpty()
              || supplierPhone_txt.getText().isEmpty()
              || supplierAddress_txt.getText().isEmpty()
              || supplierId_lbl.getText().isEmpty()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please fill in all fields");
         alert.showAndWait();

      } else {

         String sql = "UPDATE suppliers SET supplier_name = '"
                 + supplierName_txt.getText() + "', email = '"
                 + supplierEmail_txt.getText() + "', phone_number = '"
                 + supplierPhone_txt.getText() + "', address = '"
                 + supplierAddress_txt.getText() + "' WHERE id = '" + supplierId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to update supplier : " + supplierId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Supplier Successfully Updated");
               alert.showAndWait();

               displaySuppliers();
               clearSupplier_txt();
            }  else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();

            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Delete Supplier
   public void deleteSupplier() {

      if (supplierId_lbl.getText().isEmpty()) {

         alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
         alert.setHeaderText(null);
         alert.setContentText("Please Select The Supplier You Want to Remove");
         alert.showAndWait();

      } else {

         String sql = "DELETE FROM suppliers WHERE id = '" + supplierId_lbl.getText() + "'";

         connect = Database.DbConnection();

         try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete supplier : " + supplierId_lbl.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

               prepare = connect.prepareStatement(sql);
               prepare.executeUpdate();

               alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Success Message");
               alert.setHeaderText(null);
               alert.setContentText("Supplier Successfully Deleted");
               alert.showAndWait();

               displaySuppliers();
               clearSupplier_txt();
            }  else {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Cancelled. ");
               alert.showAndWait();

            }

         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

//   Clear Supplier Text Fields
   public void clearSupplier_txt() {

      supplierId_lbl.setText("");
      supplierName_txt.clear();
      supplierEmail_txt.clear();
      supplierPhone_txt.clear();
      supplierAddress_txt.clear();

   }

//   --------------- Transactions ------------------

   //   Get All Transactions
   public ObservableList<TransactionModel> getTransactionList() {

      ObservableList<TransactionModel> listTransactions = FXCollections.observableArrayList();

      String sql = "SELECT * FROM transactions";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         TransactionModel transactData;

         while (result.next()) {
            transactData = new TransactionModel(result.getInt("id"),
                    result.getString("transaction_type"),
                    result.getDouble("amount"),
                    result.getString("payment_channel"),
                    result.getInt("user_id"),
                    result.getTimestamp("created_at"));

            listTransactions.add(transactData);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return  listTransactions;
   }

   private ObservableList<TransactionModel> transactionsList;
   //   Display Suppliers
   public void displayTransactions() {

      transactionsList = getTransactionList();

      transactionId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
      transactionType_col.setCellValueFactory(new PropertyValueFactory<>("transaction_type"));
      transactionAmount_col.setCellValueFactory(new PropertyValueFactory<>("amount"));
      transactionPayChannel_col.setCellValueFactory(new PropertyValueFactory<>("payment_channel"));
      transactionUserId_col.setCellValueFactory(new PropertyValueFactory<>("user_id"));
      transactionDate_col.setCellValueFactory(new PropertyValueFactory<>("created_at"));

      transactionsTableView.setItems(transactionsList);

      searchTransaction();
   }

   //   Search Supplier
   public void searchTransaction() {

      FilteredList<TransactionModel> filteredTransactions = new FilteredList<>(transactionsList, e -> true);

      searchTransact_txt.textProperty().addListener((observable, oldValue, newValue) -> {

         filteredTransactions.setPredicate(transactionModel -> {

//                IF THERE IS NO SEARCH THEN DISPLAY ALL RECORDS
            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
               return true;
            }

            String searchKeyword = newValue.toLowerCase();

            if (transactionModel.getTransaction_type().toLowerCase().contains(searchKeyword)) {
               return true;
            } else if (transactionModel.getPayment_channel().toLowerCase().contains(searchKeyword)) {
               return true;
            } else {
               return false; // NO MATCH FOUND
            }
         });
      });

      SortedList<TransactionModel> sortedTransactions = new SortedList<>(filteredTransactions);

//      Bind sorted Suppliers with table view
      sortedTransactions.comparatorProperty().bind(transactionsTableView.comparatorProperty());

//      APPLY / DISPLAY FILTERED AND SORTED SUPPLIERS TO THE TABLE VIEW
      transactionsTableView.setItems(sortedTransactions);
   }

//   ------------------- Sales -----------------
//   Get All Sales
public ObservableList<SalesModel> getSalesList() {

   ObservableList<SalesModel> listSales = FXCollections.observableArrayList();

   String sql = "SELECT * FROM sales";

   connect = Database.DbConnection();

   try {

      prepare = connect.prepareStatement(sql);
      result = prepare.executeQuery();

      SalesModel salesData;

      while (result.next()) {
         salesData = new SalesModel(result.getInt("id"),
                 result.getInt("product_id"),
                 result.getInt("quantity"),
                 result.getDouble("unit_cost_price"),
                 result.getDouble("unit_selling_price"),
                 result.getInt("transaction_id"),
                 result.getTimestamp("created_at"));

         listSales.add(salesData);
      }
   } catch (Exception e) {
      e.printStackTrace();
   }

   return  listSales;
}

   private ObservableList<SalesModel> salesList;
   //   Display Sales
   public void displaySales() {

      salesList = getSalesList();

      saleId_col.setCellValueFactory(new PropertyValueFactory<>("id"));
      saleProdId_col.setCellValueFactory(new PropertyValueFactory<>("product_id"));
      saleQuantity_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
      saleUnitCost_col.setCellValueFactory(new PropertyValueFactory<>("unit_cost_price"));
      saleSellingPrice_col.setCellValueFactory(new PropertyValueFactory<>("unit_selling_price"));
      saleTransactionId_col.setCellValueFactory(new PropertyValueFactory<>("transaction_id"));
      saleDate_col.setCellValueFactory(new PropertyValueFactory<>("created_at"));

      salesTableView.setItems(salesList);

//      searchSale();
   }

//   --------------------- USERS --------------------------

   //    GET ALL USERS
   public ObservableList<UserModel> getAllUsers() {

      ObservableList<UserModel> listUser = FXCollections.observableArrayList();

      String sql = "SELECT * FROM users";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();

         UserModel userList;

         while (result.next()) {

            userList = new UserModel(result.getInt("id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getString("national_id"),
                    result.getString("phone_number"),
                    result.getString("address"),
                    result.getString("username"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("role"));

            listUser.add(userList);

         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return listUser;
   }

   //    This is For Displaying Users The table
   private ObservableList<UserModel> allUsersList;

   public void displayAllUsers() {

      allUsersList = getAllUsers();

      usersName_col.setCellValueFactory(new PropertyValueFactory<>("first_name"));
      usersSurname_col.setCellValueFactory(new PropertyValueFactory<>("last_name"));
      usersNationalId_col.setCellValueFactory(new PropertyValueFactory<>("national_id"));
      usersPhone_col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
      usersAddress_col.setCellValueFactory(new PropertyValueFactory<>("address"));
      usersUsername_col.setCellValueFactory(new PropertyValueFactory<>("username"));
      usersEmail_col.setCellValueFactory(new PropertyValueFactory<>("email"));
      usersRole_col.setCellValueFactory(new PropertyValueFactory<>("role"));

      usersTableView.setItems(allUsersList);

//      searchProduct();

   }

//   ADD USERS
public void addUser() {

   if (fName_txt.getText().isEmpty() || surname_txt.getText().isEmpty()
           || username_txt.getText().isEmpty() || nationalID_txt.getText().isEmpty()
           || phone_txt.getText().isEmpty() || email_txt.getText().isEmpty()
           || password_txt.getText().isEmpty() || address_txt.getText().isEmpty()
           || role_combo.getSelectionModel().getSelectedItem() == null) {

      alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Message");
      alert.setHeaderText(null);
      alert.setContentText("Please fill in all fields");
      alert.showAndWait();

   } else {

      String sql = "INSERT INTO users " +
              "(first_name, last_name, national_id, phone_number, address, username, email, password, role) " +
              "VALUES (?,?,?,?,?,?,?,?,?)";

      connect = Database.DbConnection();

      try {

         prepare = connect.prepareStatement(sql);
         prepare.setString(1, fName_txt.getText());
         prepare.setString(2, surname_txt.getText());
         prepare.setString(3, nationalID_txt.getText());
         prepare.setString(4, phone_txt.getText());
         prepare.setString(5, address_txt.getText());
         prepare.setString(6, username_txt.getText());
         prepare.setString(7, email_txt.getText());
         prepare.setString(8, password_txt.getText());

//            Split Supplier Id From Supplier name
         String userRole = String.valueOf(role_combo.getSelectionModel().getSelectedItem());
         prepare.setString(9, userRole);

         prepare.executeUpdate();

         alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Information Message");
         alert.setHeaderText(null);
         alert.setContentText("User successfully added!");
         alert.showAndWait();

         displayAllUsers();
         clearUserTxtf();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

public void clearUserTxtf() {

   fName_txt.clear();
   surname_txt.clear();
   nationalID_txt.clear();
   phone_txt.clear();
   address_txt.clear();
   username_txt.clear();
   email_txt.clear();
   password_txt.clear();
   role_combo.getSelectionModel().clearSelection();

}

   public void switchForm(ActionEvent event) {

      if (event.getSource() == dashboard_btn) {

         dashboard_form.setVisible(true);
         products_form.setVisible(false);
         inventory_form.setVisible(false);
         categories_form.setVisible(false);
         transanctions_form.setVisible(false);
         sales_form.setVisible(false);
         suppliers_form.setVisible(false);
         users_form.setVisible(false);

      } else if (event.getSource() == products_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(true);
         inventory_form.setVisible(false);
         categories_form.setVisible(false);
         transanctions_form.setVisible(false);
         sales_form.setVisible(false);
         suppliers_form.setVisible(false);
         users_form.setVisible(false);

         categoriesList();
         suppliersList();

      } else if (event.getSource() == inventory_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(false);
         inventory_form.setVisible(true);
         categories_form.setVisible(false);
         transanctions_form.setVisible(false);
         sales_form.setVisible(false);
         suppliers_form.setVisible(false);
         users_form.setVisible(false);

         displayAllInventory();
         productsList();

      } else if (event.getSource() == categrories_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(false);
         inventory_form.setVisible(false);
         categories_form.setVisible(true);
         transanctions_form.setVisible(false);
         sales_form.setVisible(false);
         suppliers_form.setVisible(false);
         users_form.setVisible(false);

         displayCategories();

      } else if (event.getSource() == transactions_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(false);
         inventory_form.setVisible(false);
         categories_form.setVisible(false);
         transanctions_form.setVisible(true);
         sales_form.setVisible(false);
         suppliers_form.setVisible(false);
         users_form.setVisible(false);

         displayTransactions();

      } else if (event.getSource() == sales_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(false);
         inventory_form.setVisible(false);
         categories_form.setVisible(false);
         transanctions_form.setVisible(false);
         sales_form.setVisible(true);
         suppliers_form.setVisible(false);
         users_form.setVisible(false);

         displaySales();

      } else if (event.getSource() == suppliers_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(false);
         inventory_form.setVisible(false);
         categories_form.setVisible(false);
         transanctions_form.setVisible(false);
         sales_form.setVisible(false);
         suppliers_form.setVisible(true);
         users_form.setVisible(false);

         displaySuppliers();

      } else if (event.getSource() == users_btn) {

         dashboard_form.setVisible(false);
         products_form.setVisible(false);
         inventory_form.setVisible(false);
         categories_form.setVisible(false);
         transanctions_form.setVisible(false);
         sales_form.setVisible(false);
         suppliers_form.setVisible(false);
         users_form.setVisible(true);

         displayAllUsers();

      }
   }

   public void displayUsername() {

      username.setText(PersonalInfo.username);
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      displayUsername();

      displayAllProducts();
      displayAllInventory();
      displayCategories();
      displaySuppliers();
      displayTransactions();
      displaySales();
      displayAllUsers();

      categoriesList();
      suppliersList();
      productsList();
   }
}
