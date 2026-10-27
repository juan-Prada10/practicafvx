package co.edu.uniquindio.poo.empresajfx.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresajfx.App;
import co.edu.uniquindio.poo.empresajfx.controller.ClienteController;
import co.edu.uniquindio.poo.empresajfx.controller.TrabajadorController;
import co.edu.uniquindio.poo.empresajfx.model.Cliente;
import co.edu.uniquindio.poo.empresajfx.model.Trabajador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TrabajadorViewController {

    TrabajadorController trabajadorController;
    ObservableList<Trabajador> listTrabajadores = FXCollections.observableArrayList();
    Trabajador selectedTrabajador;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Trabajador> tblListTrabajador;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TableColumn<Trabajador, String> tbcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Trabajador, String> tbcApellido;

    @FXML
    private Button btbAgregarTrabajador;

    @FXML
    private TableColumn<Trabajador, String> tbcCedula;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    void onAgregarTrabajador() {
        agregarTrabajor();
    }

    @FXML
    void onActualizarTrabajador() {
        actualizarTrabajador();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarTrabajador();
    }

    @FXML
    void initialize() {
        this.app=app;
        trabajadorController = new TrabajadorController(app.empresa);
        initView();
    }

    private void initView() {
        // Traer los datos del trabajador a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerTrabajador();

        // Limpiar la tabla
        tblListTrabajador.getItems().clear();

        // Agregar los elementos a la tabla
        tblListTrabajador.setItems(listTrabajadores);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerTrabajador() {
        listTrabajadores.addAll(TrabajadorController.obtenerListaTrabajadores());
    }

    private void listenerSelection() {
        tblListTrabajador.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedTrabajador = newSelection;
            mostrarInformacionTrabajador(selectedTrabajador);
        });
    }

    private void mostrarInformacionTrabajador(Trabajador trabajador) {
        if (trabajador != null) {
            txtCedula.setText(trabajador.getCedula());
            txtNombre.setText(trabajador.getNombre());
            txtApellido.setText(trabajador.getApellido());
        }
    }

    private void agregarTrabajor() {
        Trabajador trabajador = buildTrabajador();
        if (trabajadorController.crearTrabajador(trabajador)) {
            listTrabajadores.add(trabajador);
            limpiarCamposTrabajador();
        }
    }

    private Trabajador buildTrabajador() {
        Trabajador trabajador = new Trabajador(txtCedula.getText(), txtNombre.getText(), txtApellido.getText());
        return trabajador;
    }

    private void eliminarTrabajador() {
        if (trabajadorController.eliminarTrabajador(txtCedula.getText())) {
            listTrabajadores.remove(selectedTrabajador);
            limpiarCamposTrabajador();
            limpiarSeleccion();
        }
    }

    private void actualizarTrabajador() {

        if (selectedTrabajador != null &&
                TrabajadorController.actualizarTrabajador(selectedTrabajador.getCedula(), buildTrabajador())) {

            int index = listTrabajadores.indexOf(selectedTrabajador);
            if (index >= 0) {
                listTrabajadores.set(index, buildTrabajador());
            }

            tblListTrabajador.refresh();
            limpiarSeleccion();
            limpiarCamposTrabajador();
        }
    }

    private void limpiarSeleccion() {
        tblListTrabajador.getSelectionModel().clearSelection();
        limpiarCamposTrabajador();
    }

    private void limpiarCamposTrabajador() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
