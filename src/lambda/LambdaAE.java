/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class LambdaAE extends Application {
     
    @Override
    public void start(Stage primaryStage) {
        Label AIRtext = new Label("Annual Interest Rate:");
        TextField AnnualInteresRate = new TextField();

        Label NOYtext = new Label("Number of Years:");
        TextField NumberOfYears = new TextField();

        Label LAtext = new Label("Loan Amount:");
        TextField LoanAmount = new TextField();

        Label MPtext = new Label("Monthly Payment:");
        TextField MonthlyPayment = new TextField();
        MonthlyPayment.setEditable(false);

        Label TPtext = new Label("Total Payment:");
        TextField TotalPayment = new TextField();
        TotalPayment.setEditable(false);
    
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setOnAction(e-> {
                float i=Float.parseFloat(AnnualInteresRate.getText());
                int n=Integer.parseInt(NumberOfYears.getText());
                int h=Integer.parseInt(LoanAmount.getText());
                double exponente=(-12*n);
                double r=(i/(100*12));
                double abajo=1-Math.pow((1+r), exponente);
                double m=((h*r)/abajo);
                
                MonthlyPayment.setText(String.format("$"+"%.2f", m));
                TotalPayment.setText(String.format("$"+"%.2f", m*(n*12)));
                
        });
        
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.TOP_CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(5);
        gridpane.setPadding(new Insets(25, 25, 25, 25));
        
        gridpane.add(AIRtext, 0, 0);
        gridpane.add(AnnualInteresRate, 1, 0);
        gridpane.add(NOYtext, 0, 1);
        gridpane.add(NumberOfYears, 1, 1);
        gridpane.add(LAtext, 0, 2);
        gridpane.add(LoanAmount, 1, 2);
        gridpane.add(MPtext, 0, 3);
        gridpane.add(MonthlyPayment, 1, 3);
        gridpane.add(TPtext, 0, 4);
        gridpane.add(TotalPayment, 1, 4);
        gridpane.add(btn, 1, 5);
        
        
        Scene scene = new Scene(gridpane, 350, 250);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
