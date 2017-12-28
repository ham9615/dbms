/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import f1dbms.SQLConnectionFile.sqlConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class DriverTableController implements Initializable {

    @FXML
    private TableView<driverModel> tableview;
    @FXML
    private TableColumn<?, ?> driverid;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> nationality;
    @FXML
    private TableColumn<?, ?> team;
    @FXML
    private TableColumn<?, ?> age;
    @FXML
    private TableColumn<?, ?> race;
    @FXML
    private TableColumn<?, ?> pole;
    @FXML
    private TableColumn<?, ?> win;
    @FXML
    private TableColumn<?, ?> championship;
    
    private ObservableList<driverModel> data;
 
    Connection conn;
    @FXML
    private Pane tablePane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    public void tableData() throws SQLException{
        
        String sql = "select * from driver";
        conn = sqlConnection.ConnectDb1();
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        data = FXCollections.observableArrayList();
        
        driverid.setCellValueFactory(new PropertyValueFactory<>("driverid"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        team.setCellValueFactory(new PropertyValueFactory<>("team"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        race.setCellValueFactory(new PropertyValueFactory<>("race"));
        pole.setCellValueFactory(new PropertyValueFactory<>("pole"));
        win.setCellValueFactory(new PropertyValueFactory<>("win"));
        championship.setCellValueFactory(new PropertyValueFactory<>("championship"));
        
        while(rs.next()){
            data.add(new driverModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
           System.out.println(String.valueOf(rs.getInt(6)));
        }
        
        tableview.setItems(data);
    }
    
     public void goBack(){
           Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       tablePane.getChildren().setAll(viewButtonPane);
    }
    
}
 