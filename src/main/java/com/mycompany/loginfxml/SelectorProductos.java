package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import models.Pedido;
import models.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SelectorProductos implements Initializable {

    @FXML
    private MenuItem menuSalir;

    @FXML
    private Button btnSalir;

    private Pedido pedidoActual = null;
   
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn7;
    @FXML
    private Button btn10;
    @FXML
    private Button btn13;
    @FXML
    private Button btn5;
    @FXML
    private Button btn8;
    @FXML
    private Button btn11;
    @FXML
    private Button btn14;
    @FXML
    private Button btn6;
    @FXML
    private Button btn9;
    @FXML
    private Button btn12;
    @FXML
    private Button btn15;
    @FXML
    private Button btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn1 = new Button();
        
        asignarBotones();

    }
    
    
    public ArrayList<Producto> traerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from Producto");
            productos = (ArrayList<Producto>) q.list();
        }
        
        return productos;
        
    }
    
    public void asignarBotones(){
        
        
        
            
        
        
    }

    @FXML
    private void Salir(ActionEvent event) {
        try {
            App.setRoot("principal");
        } catch (IOException ex) {
            Logger.getLogger(SelectorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirCarta(ActionEvent event) {

        try {
            App.setRoot("carta");
        } catch (IOException ex) {
            Logger.getLogger(SelectorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void irHoy(ActionEvent event) {

        try {
            App.setRoot("pedidos");
        } catch (IOException ex) {
            Logger.getLogger(SelectorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
