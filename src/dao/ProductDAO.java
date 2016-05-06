/**
 * Class name: ProductDAO.java
 * Purpose of class: This file contains the ProviderDAO class and its methods.
 * Copyright: This software follows GPL license.
 **/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionDB;

import model.Product;

/**
 * Class name: ProductDAO
 * Purpose of class:  This class corresponds to persistence class Product, with methods insertProduct,
 * listProduct, deleteProduct and updateProduct.
 **/
public class ProductDAO {
        private Connection connection;

        public ProductDAO() {
                this.connection = ConnectionDB.getConnection().connectionWithDataBase;
        }

        /**
         * Method name: insertProduct
         * Purpose of method: Include in the data base a new product
         * @param A new product
         * @return wasAdd if the product was add
         */
        public boolean insertProduct(Product product) {
                assert(product != null) : "unexpected error: the product is null";
                String sql = "insert into Products (nome) values (?)";
                boolean wasAdd = false;

                try {
                        //Prepare param to execut the Query

                        PreparedStatement statement =  this.connection.prepareStatement(sql);

                        statement.setString(1, product.getProductName());
                        statement.execute();

                        //The product was added
                        wasAdd = true;

                        //Close the operators
                        statement.close();
                }
                catch(SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                }
                        return wasAdd;
        }

        /**
         * Method name: listProduct
         * Purpose of method: Shows all existing products in the database
         * @return all products in list
         */
        public ArrayList<Product> listProducts() {
                String sql = "select * from Products";
                ArrayList<Product> products = new ArrayList<Product>();

                try {
                        Class.forName("com.mysql.jdbc.Driver");
                }
                catch(ClassNotFoundException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                }

                try {
                        PreparedStatement statement = this.connection.prepareStatement(sql);

                        //Returns a result of the query of search
                        ResultSet rs = statement.executeQuery();

                        //Stores all the products listed in the array
                        while(rs.next()) {
                                Product product = new Product();

                                product.setProductName(rs.getString("nome"));
                                products.add(product);
                        }
                        //Close the operators
                        statement.close();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                return products;
        }

         /**
         * Method name: deleteProduct
         * Purpose of method: Delete product in the database
         * @return wasDeleted if the product was delete
         */
        public boolean deleteProduct(String name) {
                assert(name != null) : "unexpected error: the name is null";
                String sql = "delete from Products where nome = ?";
                boolean wasDeleted = false;

                try {
                        PreparedStatement statement = this.connection.prepareStatement(sql);

                        //Set the first atribute of the query
                        statement.setString(1, name);
                        statement.execute();

                        wasDeleted = true;

                        //Close the operators
                        statement.close();
                }
                catch(SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                }
                return wasDeleted;
        }

        /**
         * Method name: updateProduct
         * Purpose of method: Update product in the database
         * @return wasUpdated if the product was update
         */
        public boolean updateProduct(String nameToUpdate, Product product) {
                assert(nameToUpdate != null) : "unexpected error: the nameToUpdate is null";
                assert(product != null) : "unexpected error: the product is null";
                String sql = "update Products set nome=? where nome=?";
                boolean wasUpdated = false;

                try {
                        PreparedStatement statement = this.connection.prepareStatement(sql);

                        //Set the first atribute of the query
                        statement.setString(1, product.getProductName());
                        statement.setString(2, nameToUpdate);

                        statement.executeUpdate();

                        wasUpdated = true;

                        //Close the operators
                        statement.close();
                }
                catch(SQLException e) {
                        e.printStackTrace();
                }
                return wasUpdated;
            }
}
