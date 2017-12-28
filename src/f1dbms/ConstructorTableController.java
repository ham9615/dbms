/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import f1dbms.SQLConnectionFile.sqlConnection;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class ConstructorTableController implements Initializable {

    @FXML
    private TableView<constructorModel> teamTable;
    @FXML
    private TableColumn<?, ?> teamid;
    @FXML
    private TableColumn<?, ?> teamname;
    @FXML
    private TableColumn<?, ?> location;
    @FXML
    private TableColumn<?, ?> carid;
    @FXML
    private TableColumn<?, ?> championship;
    Connection conn;
    private ObservableList<constructorModel> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void loadData() throws SQLException{
        String sql = "select * from constructor";
        conn = sqlConnection.ConnectDb1();
        ResultSet rs = conn.createStatement().executeQuery(sql);
        data = FXCollections.observableArrayList();
        
        teamid.setCellValueFactory(new PropertyValueFactory<>("teamid"));
        teamname.setCellValueFactory(new PropertyValueFactory<>("teamname"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        carid.setCellValueFactory(new PropertyValueFactory<>("carid"));
        championship.setCellValueFactory(new PropertyValueFactory<>("championship"));
        
        while(rs.next()){
            data.add(new constructorModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            
        }
        
        teamTable.setItems(data);
        
        
    }
    
}
