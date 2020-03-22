package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.Random;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label myMessage;
	public void generateTxt(ActionEvent event) {
		Random rand = new Random();
		int myID = rand.nextInt(20)+1;
		myMessage.setText("Student ID: "+Integer.toString(myID)+" is here!");
		//System.out.println("Student ID: "+Integer.toString(myID)+" is here!");
		
	}
}
