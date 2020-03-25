package application;

import java.util.Scanner;
import java.util.StringTokenizer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class MainController {
	@FXML private TextArea result;
	@FXML private TextField fname, lname, credit, funds;
	@FXML private RadioButton instate, outstate, international;
	@FXML private CheckBox funding, tristate, exchange;
	@FXML private Button add, remove, print;
	
	
	public void filter(MouseEvent event) { 
		//if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			if(instate.isSelected()) {
				initialize();
				tristate.setDisable(true);
				exchange.setDisable(true);
				
			}

			if(outstate.isSelected()) {
				initialize();
				funding.setDisable(true);
				funds.setDisable(true);
				exchange.setDisable(true);
			}
			if(international.isSelected()) {
				initialize();
				funding.setDisable(true);
				funds.setDisable(true);
				tristate.setDisable(true);
			}
		//}
	}
	
	public void checkEvent(ActionEvent event) {
		if(funding.isSelected()) {
			funds.setDisable(false);
		}
		if(funding.isSelected() == false) {
			funds.setDisable(true);
		}
	}
	/**
	 * the user inputs the operation(s) on the StudentList.
	 */
	public void run(ActionEvent event) {

		result.setText("successfully added\n");
		initialize();
		instate.setSelected(false);
		outstate.setSelected(false);
		international.setSelected(false);
		
		fname.setText(null);
		lname.setText(null);
		credit.setText(null);
		funds.setText(null);;
		
	}
	
    public void initialize() {
        instate.setDisable(false);
        outstate.setDisable(false);
        international.setDisable(false);
        funding.setDisable(false);
        tristate.setDisable(false);
        exchange.setDisable(false);
        funds.setDisable(false);
        
        tristate.setSelected(false);
        exchange.setSelected(false);
        funding.setSelected(false);
    }
}
