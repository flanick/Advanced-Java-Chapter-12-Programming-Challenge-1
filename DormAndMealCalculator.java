import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class DormAndMealCalculator extends Application {
    double total = 0;



    public static void main(String[] args) {
        //launch the application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        //create a combo box for dorm options
        ComboBox<String> dormBox = new ComboBox<>();
        dormBox.getItems().addAll("Allen Hall $1800", "Pike Hall $2200",
                "Farthing Hall $2800", "University Suites $3000");



        //create a combo box for meal plans
        ComboBox<String> mealBox = new ComboBox<>();
        mealBox.getItems().addAll("7 Meals/Week $600", "14 Meals/Week $1400",
                "Unlimited Meals $1800");


        //create instruction labels
        Label dormLabel = new Label("Select a Dorm");
        Label mealLabel = new Label("Select a Meal Plan");
        Label outputLabel = new Label();

        //create button to get price total
        Button totalButton = new Button("Calculate Pricing");

        //create event handler for totalButton
        totalButton.setOnAction(event -> {
            if (dormBox.getSelectionModel().getSelectedIndex() != -1 &&
            mealBox.getSelectionModel().getSelectedIndex() != -1) {


                //get the value associated with the dormbox selection
                if (dormBox.getSelectionModel().getSelectedIndex() == 0) {
                    total += 1800;
                } else if (dormBox.getSelectionModel().getSelectedIndex() == 1) {
                    total += 2200;
                } else if (dormBox.getSelectionModel().getSelectedIndex() == 2) {
                    total += 2800;
                } else {
                    total += 3000;
                }

                //get the value associated with the mealbox selection


                if (mealBox.getSelectionModel().getSelectedIndex() == 0){
                    total += 600;
                }
                else if (mealBox.getSelectionModel().getSelectedIndex() == 1){
                    total += 1100;
                }
                else {
                    total += 1800;
                }
                outputLabel.setText(String.format("The price for your dorm and meal plan is $%,.2f.", total));

                outputLabel.setStyle("-fx-text-fill: purple; -fx-font-size: 10pt; -fx-font-weight: bold");

            }
            else {
                outputLabel.setText("Nothing is Selected");
            }
        });
        // add the controls to a VBox
        VBox dormVBox = new VBox(10, dormBox, dormLabel, totalButton );
        VBox mealVBox = new VBox(10, mealBox, mealLabel, outputLabel);
        dormVBox.setAlignment(Pos.TOP_LEFT);
        mealVBox.setAlignment(Pos.TOP_RIGHT);
        dormVBox.setPadding(new Insets(20));
        mealVBox.setPadding(new Insets(20));

        //add the Vbox, button to an hbox
        HBox hbox = new HBox(10, dormVBox, mealVBox);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));
        hbox.setPrefSize(700, 100);

        //create a scene
        Scene scene = new Scene(hbox);
        primaryStage.setTitle("Dorm and Meal Plan Calculator");
        scene.getStylesheets().add("DormAndMealCalculatorStylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
