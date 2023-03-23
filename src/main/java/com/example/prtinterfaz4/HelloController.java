package com.example.prtinterfaz4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldApellidos;
    @FXML
    private TextField fieldEdad;
    @FXML
    private TableView<Persona> tabla;
    @FXML
    private TableColumn tNombre;
    @FXML
    private TableColumn tApellidos;
    @FXML
    private TableColumn tEdad;
    @FXML
    private Button agregarPersona;
    @FXML
    private Button modificar;
    @FXML
    private Button eliminar;

    private ObservableList<Persona> personas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personas = FXCollections.observableArrayList();
        this.tNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.tEdad.setCellValueFactory(new PropertyValueFactory("edad"));
    }

    public void meterPersona(ActionEvent event) {
        try {
            String name = this.fieldNombre.getText();
            String surname = this.fieldApellidos.getText();
            int age = Integer.parseInt(this.fieldEdad.getText());

            Persona p = new Persona(name, surname, age);

            if (!this.personas.contains(p)) {
                this.personas.add(p);
                this.tabla.setItems(personas);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }
}