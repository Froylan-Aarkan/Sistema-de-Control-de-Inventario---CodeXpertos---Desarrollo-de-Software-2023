/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadecontroldeinventario.CentroComputo;

import Modelo.DAO.CentroComputoDAO;
import Modelo.POJO.CentroComputo;
import Utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistemadecontroldeinventario.InicioSesionFXMLControlador;
import sistemadecontroldeinventario.VentanaPrincipalFXMLControlador;

/**
 * FXML Controller class
 *
 * @author Elotlan
 */
public class ConsultarCentroDeComputoController implements Initializable {

    @FXML
    private TableView<CentroComputo> tbCentroComputo;
    @FXML
    private TableColumn colAula;
    @FXML
    private TableColumn colFacultad;
    @FXML
    private TableColumn colEdificio;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnConsultar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    public void mostrarTabla() throws SQLException{
        colAula.setCellValueFactory(new PropertyValueFactory<CentroComputo, String>("aula"));
        colFacultad.setCellValueFactory(new PropertyValueFactory<CentroComputo, String>("facultad"));
        colEdificio.setCellValueFactory(new PropertyValueFactory<CentroComputo, String>("edificio"));
        
        CentroComputoDAO centroComputoDAO = new CentroComputoDAO();
        ArrayList<CentroComputo> centrosComputo;
        centrosComputo = centroComputoDAO.recuperarCentroComputo();
    
        ObservableList<CentroComputo> centrosComputoObservable = FXCollections.observableArrayList();
        for(CentroComputo centrocomputo : centrosComputo){
            centrosComputoObservable.add(centrocomputo);
        }
        
        tbCentroComputo.setItems(centrosComputoObservable);
        
        if(centrosComputo.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion");
            alert.setHeaderText("No hay problematicas registradas para consultar");
            alert.setContentText("Intentelo de nuevo más tarde");
            alert.showAndWait();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mostrarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCentroDeComputoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void clicSalir(ActionEvent event) throws SQLException, IOException {
        try {
            FXMLLoader loaderVentanaPrincipal = new FXMLLoader(getClass().getResource("/sistemadecontroldeinventario/VentanaPrincipalFXML.fxml"));
            Parent ventanaPrincipal = loaderVentanaPrincipal.load();
            VentanaPrincipalFXMLControlador controladorVentanaPrincipal = loaderVentanaPrincipal.getController();
            
            Scene escenaVentanaPrincipal = new Scene(ventanaPrincipal);
            Stage stageVentanaPrincipal = new Stage();
            stageVentanaPrincipal.setScene(escenaVentanaPrincipal);
            stageVentanaPrincipal.show();
            
            Stage stage = (Stage) btnSalir.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionFXMLControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clicRegistrar(ActionEvent event) {
        try {
            FXMLLoader loaderVentanaRegistrarEquipoDeComputo = new FXMLLoader(getClass().getResource("RegistrarCentroDeComputo.fxml"));
            Parent ventanaRegistrarEquipoDeComputo = loaderVentanaRegistrarEquipoDeComputo.load();
            
            Scene escenarioRegistrarEquipoDeComputo = new Scene(ventanaRegistrarEquipoDeComputo);
            Stage stageEquiposDeComputo = new Stage();
            stageEquiposDeComputo.setScene(escenarioRegistrarEquipoDeComputo);
            stageEquiposDeComputo.initModality(Modality.APPLICATION_MODAL);
            stageEquiposDeComputo.showAndWait();
            
            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(ConsultarCentroDeComputoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clicConsultar(ActionEvent event) {
        if(verificarSeleccion()){
            try {
                FXMLLoader loaderInformacionCentroDeComputo = new FXMLLoader(getClass().getResource("InformacionCentroDeComputo.fxml"));
                Parent ventanaInformacionCentroDeComputo = loaderInformacionCentroDeComputo.load();

                InformacionCentroDeComputoController controladorInfoCC = loaderInformacionCentroDeComputo.getController();
                controladorInfoCC.recibirCentroComputo(tbCentroComputo.getSelectionModel().getSelectedItem());

                Scene escenarioInformacionCentroDeComputo = new Scene(ventanaInformacionCentroDeComputo);
                Stage stageInformacionCentroDeComputo = new Stage();
                stageInformacionCentroDeComputo.setScene(escenarioInformacionCentroDeComputo);
                stageInformacionCentroDeComputo.initModality(Modality.APPLICATION_MODAL);
                stageInformacionCentroDeComputo.showAndWait();

                Stage stage = (Stage) btnConsultar.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(ConsultarCentroDeComputoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Utilidades.mostrarAlertaSimple("centro no seleccionado", "No se ha seleccionado el centro de cómputo a consultar.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void clicModificar(ActionEvent event) {
        if(verificarSeleccion()){
            try {
                FXMLLoader loaderModificarCentroDeComputo = new FXMLLoader(getClass().getResource("ModificarCentroDeComputo.fxml"));
                Parent ventanaInformacionCentroDeComputo = loaderModificarCentroDeComputo.load();

                ModificarCentroDeComputoController controladorModificarCC = loaderModificarCentroDeComputo.getController();
                controladorModificarCC.recibirCentroComputo(tbCentroComputo.getSelectionModel().getSelectedItem());

                Scene escenarioInformacionCentroDeComputo = new Scene(ventanaInformacionCentroDeComputo);
                Stage stageInformacionCentroDeComputo = new Stage();
                stageInformacionCentroDeComputo.setScene(escenarioInformacionCentroDeComputo);
                stageInformacionCentroDeComputo.initModality(Modality.APPLICATION_MODAL);
                stageInformacionCentroDeComputo.showAndWait();

                Stage stage = (Stage) btnConsultar.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(ConsultarCentroDeComputoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void clicEliminar(ActionEvent event) throws SQLException {
        if(verificarSeleccion()){
            if(Utilidades.mostrarDialogoConfirmacion("Eliminar centro de cómputo", "¿Desea eliminar el centro de cómputo seleccionado?")){
                try {
                    if(CentroComputoDAO.eliminarCentroComputo(tbCentroComputo.getSelectionModel().getSelectedItem().getIdCentroComputo())){
                        Utilidades.mostrarAlertaSimple("Eliminación exitosa.", "Se eliminó exitosamente el centro de cómputo.", Alert.AlertType.INFORMATION);
                        
                    }
                } catch (SQLException e) {
                    Utilidades.mostrarAlertaSimple("Error", "Algo ocurrió mal: " + e.getMessage(), Alert.AlertType.ERROR);
                }
            }
        }else{
            Utilidades.mostrarAlertaSimple("centro no seleccionado", "No se ha seleccionado el centro de cómputo a eliminar.", Alert.AlertType.WARNING);
        }        
        mostrarTabla();
    }
    
    private boolean verificarSeleccion(){
        return tbCentroComputo.getSelectionModel().getSelectedItem() != null;
    }
    
}
