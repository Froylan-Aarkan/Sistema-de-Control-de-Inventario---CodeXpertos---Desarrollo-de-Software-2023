/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistemadecontroldeinventario.usuario;


import Modelo.DAO.UsuarioDAO;
import Modelo.POJO.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistemadecontroldeinventario.InicioSesionFXMLControlador;
/**
 * FXML Controller class
 *
 * @author Elian
 */
public class UsuarioFXMLControlador implements Initializable {


    private ObservableList<Usuario> listaUsuarios;
    @FXML
    private TableView<Usuario> tvUsuarios;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcCorreo;
    @FXML
    private TableColumn tcCargo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarTabla();
        cargarDatosTabla();
    }    
    
    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) tvUsuarios.getScene().getWindow();
        stage.close();
    }
    
    private void configurarTabla(){
        tcNombre.setCellValueFactory(new PropertyValueFactory ("nombreCompleto"));
        tcCorreo.setCellValueFactory(new PropertyValueFactory("correoInstitucional"));
        tcCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
    }
    
    private void cargarDatosTabla(){
        try{
            listaUsuarios = FXCollections.observableArrayList();
            ArrayList<Usuario> usuarioBD = UsuarioDAO.recuperarTodoUsuario();
            listaUsuarios.addAll(usuarioBD);
            tvUsuarios.setItems(listaUsuarios);
        }catch(SQLException | NullPointerException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void eliminarUsuario(ActionEvent event) {
    }

    @FXML
    private void consultarUsuario(ActionEvent event) {
        if(!tvUsuarios.getSelectionModel().isEmpty()){
            String usuarioSeleccionado = tvUsuarios.getSelectionModel().getSelectedItem().getCorreoInstitucional();
            
            try {
            FXMLLoader loaderVentanaConsultarUsuario = new FXMLLoader(getClass().getResource("ConsultarUsuarioFXML.fxml"));
            Parent ventanaConsultarUsuario = loaderVentanaConsultarUsuario.load();
            
            Scene escenarioUsuario = new Scene(ventanaConsultarUsuario);
            Stage stageSoftware = new Stage();
            stageSoftware.setScene(escenarioUsuario);
            stageSoftware.initModality(Modality.APPLICATION_MODAL);
            stageSoftware.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionFXMLControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @FXML
    private void modificarUsuario(ActionEvent event) {
    }

    @FXML
    private void registrarUsuario(ActionEvent event) {
    }

}