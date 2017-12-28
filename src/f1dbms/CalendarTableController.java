/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import f1dbms.SQLConnectionFile.sqlConnection;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class CalendarTableController implements Initializable {

    @FXML
    private TableView<calendarModel> calendarTable;
    @FXML
    private TableColumn<?, ?> circuitcode;
    @FXML
    private TableColumn<?, ?> circuitname;
    @FXML
    private TableColumn<?, ?> racedate;
    @FXML
    private TableColumn<?, ?> pole;
    @FXML
    private TableColumn<?, ?> winner;
    Connection conn = null;
    private ObservableList<calendarModel> data;
    
    @FXML Pane calendarPane;
    
    @FXML
    public void calendarData() throws SQLException{
         String sql = "SELECT * FROM f1db.racecalenadar;";
        conn = sqlConnection.ConnectDb1();
        ResultSet rs = conn.createStatement().executeQuery(sql);
        data = FXCollections.observableArrayList();
        System.out.println("This is working");
        
        circuitcode.setCellValueFactory(new PropertyValueFactory<>("circuitcode"));
        circuitname.setCellValueFactory(new PropertyValueFactory<>("circuitname"));
        //location.setCellValueFactory(new PropertyValueFactory<>("location"));
        racedate.setCellValueFactory(new PropertyValueFactory<>("racedate"));
        pole.setCellValueFactory(new PropertyValueFactory<>("pole"));
        winner.setCellValueFactory(new PropertyValueFactory<>("winner"));
        
        while(rs.next()){
            data.add(new calendarModel(rs.getString(1),rs.getString(2),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5)));
            
        }
        
        calendarTable.setItems(data);
        
        
        calendarTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 
                 String lead = calendarTable.getSelectionModel().getSelectedItem().getCircuitcode();
                 
                    FXMLLoader loader = new FXMLLoader();
                 try {
                             Stage primaryStage = new Stage();

                     Pane root = loader.load(getClass().getResource("circuitInfo.fxml").openStream());
                     CircuitInfoController cic = (CircuitInfoController) loader.getController();
                     cic.getInfo(lead);
                     Scene scene = new Scene(root);
             primaryStage.setScene(scene);
             primaryStage.show();
                 } catch (IOException ex) {
                     Logger.getLogger(CalendarTableController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });
        
    }
        
    
    
     public void goBack(){
           Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       calendarPane.getChildren().setAll(viewButtonPane);
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            // TODO
            
            String sql = "SELECT * FROM f1db.racecalenadar;";
            conn = sqlConnection.ConnectDb1();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            data = FXCollections.observableArrayList();
            System.out.println("This is working");
            
            circuitcode.setCellValueFactory(new PropertyValueFactory<>("circuitcode"));
            circuitname.setCellValueFactory(new PropertyValueFactory<>("circuitname"));
            //location.setCellValueFactory(new PropertyValueFactory<>("location"));
            racedate.setCellValueFactory(new PropertyValueFactory<>("racedate"));
            pole.setCellValueFactory(new PropertyValueFactory<>("pole"));
            winner.setCellValueFactory(new PropertyValueFactory<>("winner"));
            
            while(rs.next()){
                data.add(new calendarModel(rs.getString(1),rs.getString(2),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5)));
                
            }
            
            calendarTable.setItems(data);
            
            
             calendarTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 
                 System.out.println("clicked on " + calendarTable.getSelectionModel().getSelectedItem());
                 
             }
         });
        } 
        catch (SQLException ex) {
            Logger.getLogger(CalendarTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handle(MouseEvent event) {
    }
    
}
