package application;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private int minutes;
	private int seconds;
	
	public void switchToScene1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserInformation.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene3(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ReminderPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML private TextArea timerText; //where the time is displayed
	
	//Initializing time and setting up the timer animation
	Time time = new Time("00:30:00");
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> { //change 1 to 0.001 or lower for quick testing
		if (time.getCurrentTime().equals("00:00:00")) {
			System.out.println("END TIMER");
		}
		time.oneSecondPassed();
		timerText.setText(time.getCurrentTime());
	}));
	 
	public void startTimer()
	{
		timerText.setText(time.getCurrentTime());
		timeline.setCycleCount(1800); //Each cycle = 1 second or whatever the keyframe duration is set to. 1800 cycles -> 30 min
		timeline.play();
		System.out.println("Drink Water!");
		time.resetTime();
	}
	
	//BMR Calculation
    private double age;
    private double activity;
    private double weight;
    private double height;
    private String sex;
    private double BMR;
    
    @FXML private TextField activityField;
    @FXML private TextField ageField;
    @FXML private TextField heightField; 
    @FXML private TextField weightField;
    @FXML private Button femaleButton;
    @FXML private Button maleButton;
    @FXML private TextArea waterInfo;
    
    public void female(ActionEvent event) throws IOException
    {
        sex = "female";
    }
    
    public void male(ActionEvent event) throws IOException
    {
        sex = "male";
    }
    
    public void calculate(ActionEvent event) throws IOException
    {
        age = Double.parseDouble(ageField.getText());
        activity = Double.parseDouble(activityField.getText());
        weight = Double.parseDouble(weightField.getText());
        height = Double.parseDouble(heightField.getText());
        
        System.out.println(age + " " + activity+ " " + weight + " " + height + " " + sex);
        
        if (sex.equals("male")){
        	BMR =  66 + (6.23 * weight) + (12.7 * height) - (6.76 * age);
        }
        else{
            BMR = 655.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
        }
        
        System.out.println(BMR);
        
        System.out.println(String.valueOf(BMR));
        
        
    }

}
