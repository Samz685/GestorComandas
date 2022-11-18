package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Estadistica implements Initializable {

    @FXML
    private MenuItem menuSalir;

    @FXML
    private Label detalle;
    @FXML
    private Button btnSalir;

    private Pedido pedidoActual = null;

    @FXML
    private Button btnHoy;

    @FXML
    private BarChart<String, String> chartA;

    private static final String VENTAS = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma FROM producto pr\n"
            + "INNER JOIN pedido p\n"
            + "WHERE pr.nombre = p.producto\n"
            + "and pr.nombre in (SELECT producto FROM pedido)\n"
            + "group by pr.nombre";

    ArrayList<ProductoVenta> productosVenta = traerVentas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        crearChart();

    }

    private void crearChart() {
        XYChart.Series serie1 = new XYChart.Series<>();
        serie1.setName("Producto");

        for (ProductoVenta p : productosVenta) {
            String nombre = p.getNombre();
            int venta = p.getVenta();

            serie1.getData().add(new XYChart.Data(nombre, venta));

        }
        chartA.getData().addAll(serie1);
        System.out.println(productosVenta.toString());
    }

    public ArrayList<Producto> traerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from Producto");
            productos = (ArrayList<Producto>) q.list();
        }

        return productos;

    }

    public ArrayList<ProductoVenta> traerVentas() {

        ArrayList<ProductoVenta> listaVentas = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(VENTAS);
            List<Object[]> rows = query.list();

            for (Object[] row : rows) {
                ProductoVenta pV = new ProductoVenta();
                pV.setNombre(row[0].toString());
                pV.setVenta(Integer.parseInt(row[1].toString()));
                listaVentas.add(pV);

            }

        } catch (Exception e) {
        }

        return listaVentas;

    }

    @FXML
    private void Salir(ActionEvent event) {
        try {
            App.setRoot("principal");
        } catch (IOException ex) {
            Logger.getLogger(Estadistica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirCarta(ActionEvent event) {

        try {
            App.setRoot("carta");
        } catch (IOException ex) {
            Logger.getLogger(Estadistica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void irHoy(ActionEvent event) {

        try {
            App.setRoot("pedidos");
        } catch (IOException ex) {
            Logger.getLogger(Estadistica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
