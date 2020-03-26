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
	
	boolean selectedInstate = false;
	boolean selectedOutstate = false;
	boolean selectedInternational = false;
	
	boolean selectedTristate = false;
	boolean selectedExchange = false;
	StudentList classOf2020 = new StudentList();
	
	public void filter(MouseEvent event) { 
		//if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			if(instate.isSelected()) {
				initialize();
				selectedInstate = true;
				tristate.setDisable(true);
				exchange.setDisable(true);
				
			}

			if(outstate.isSelected()) {
				initialize();
				selectedOutstate = true;
				funding.setDisable(true);
				funds.setDisable(true);
				exchange.setDisable(true);
				
			}
			if(international.isSelected()) {
				initialize();
				selectedInternational = true;
				funding.setDisable(true);
				funds.setDisable(true);
				tristate.setDisable(true);
			}
		//}
	}
	
	public void checkEvent(ActionEvent event) {
		selectedTristate = false;
    	selectedExchange = false;
		if(funding.isSelected()) {
			funds.setDisable(false);
		}
		if(funding.isSelected() == false) {
			funds.setDisable(true);
		}
		if(tristate.isSelected()) {
			selectedTristate = true;
		}
		if(exchange.isSelected()) {
			selectedExchange = true;
		}
	}

	/**
	 * reset the view such as buttons and etc.
	 */
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
        
    	selectedInstate = false;
    	selectedOutstate = false;
    	selectedInternational = false;
    	
    }
    
    /**
	 * add different types of student to the StudentList.
	 */
	public void addStudent(ActionEvent event) {
		
		if(selectedInstate == true) {		
			Instate inStudent = new Instate(fname.getText(), lname.getText(), Integer.parseInt(credit.getText()), Integer.parseInt(funds.getText()));
			if(classOf2020.contains(inStudent)) {
	        	result.setText("Duplicate student");	          
	        }
			else {
				classOf2020.add(inStudent);
				result.setText("successfully added student");
			}
		}
		
		if(selectedOutstate == true) {
			Outstate outStudent = new Outstate(fname.getText(), lname.getText(), Integer.parseInt(credit.getText()), selectedTristate);
			if(classOf2020.contains(outStudent)) {
	        	result.setText("Duplicate student");
	        }
			else {
				classOf2020.add(outStudent);
				result.setText("successfully added student");
			}
		}
		
		if(selectedInternational == true) {
			International intStudent = new International(fname.getText(), lname.getText(), Integer.parseInt(credit.getText()), selectedExchange);
			if(classOf2020.contains(intStudent)) {
	        	result.setText("Duplicate student");	          
	        }
			else {
				classOf2020.add(intStudent);
				result.setText("successfully added student");
			}
		}
		
		initialize();
		instate.setSelected(false);
		outstate.setSelected(false);
		international.setSelected(false);
		
		fname.setText(null);
		lname.setText(null);
		credit.setText(null);
		funds.setText(null);	
		
		classOf2020.print();
	}
	
	
	/**
	 * Remove a Student s from the studentList
	 */
	public void remove(ActionEvent event) {
		
		if(classOf2020.getNumStudents() == 0) {
			result.setText("Empty list of Students.");
		}
		
		else if(selectedInstate == true) {		
			Instate student = new Instate(fname.getText(), lname.getText(), 0, 0);
			if(classOf2020.contains(student)) {
				classOf2020.remove(student);	
				result.setText("Student removed");
			}
		}
		
		else {
        	result.setText("Student not found");
		}
		
		initialize();
		instate.setSelected(false);
		outstate.setSelected(false);
		international.setSelected(false);
		
		fname.setText(null);
		lname.setText(null);
		credit.setText(null);
		funds.setText(null);
		
	}
	
	public void print() {
		int num = classOf2020.getNumStudents();
        if (num == 0) {
            result.setText("There are zero students.");
        }
        result.setText(classOf2020.GUItoString());
        System.out.println(classOf2020.GUItoString());
	}
}
