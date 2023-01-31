package com.example.myjavafxproj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        JSONReader jsonReader = new JSONReader();
        jsonReader.parsJson();
        CSVReader csvReader = new CSVReader();
        csvReader.readCSV();

        // Skapar 2 knappar
        Button showJson = new Button("Load JSON");
        Button showCSV = new Button("Load CSV");
        //Skapar en tableview
        TableView<Customer> tableView = new TableView<>();
        //Skapar 8 kollumner och säger åt dom att hämta data från ex "orderDate" i mitt customer object
        TableColumn<Customer, String> orderDate = new TableColumn<>("Order date");
        orderDate.setCellValueFactory(new PropertyValueFactory<Customer, String>("orderDate"));

        TableColumn<Customer, String> region = new TableColumn<>("Region");
        region.setCellValueFactory(new PropertyValueFactory<Customer, String>("region"));

        TableColumn<Customer, String> repOne = new TableColumn<>("Rep 1");
        repOne.setCellValueFactory(new PropertyValueFactory<Customer, String>("rep1"));

        TableColumn<Customer, String> repTwo = new TableColumn<>("Rep 2");
        repTwo.setCellValueFactory(new PropertyValueFactory<Customer, String>("rep2"));

        TableColumn<Customer, String> item = new TableColumn<>("Item");
        item.setCellValueFactory(new PropertyValueFactory<Customer, String>("item"));

        TableColumn<Customer, Float> units = new TableColumn<>("Units");
        units.setCellValueFactory(new PropertyValueFactory<Customer, Float>("unit"));

        TableColumn<Customer, Float> cost = new TableColumn<>("Cost");
        cost.setCellValueFactory(new PropertyValueFactory<Customer, Float>("Cost"));

        TableColumn<Customer, Float> total = new TableColumn<>("Total");
        total.setCellValueFactory(new PropertyValueFactory<Customer, Float>("total"));
        //Lägger till mina kollumner i min tableview
        tableView.getColumns().add(orderDate);
        tableView.getColumns().add(region);
        tableView.getColumns().add(repOne);
        tableView.getColumns().add(repTwo);
        tableView.getColumns().add(item);
        tableView.getColumns().add(units);
        tableView.getColumns().add(cost);
        tableView.getColumns().add(total);
        //Denna metoden gör så att jag sprider ut mina kolumner så dom tar upp all plats
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //Skapar ett event för att hämta min CSV data
        EventHandler<ActionEvent> csvHandler = e -> {
            BorderPane root = new BorderPane();






            for (int i = 0; i < csvReader.customers.size(); i++) {
                tableView.getItems().add(new Customer(csvReader.customers.get(i).getOrderDate(),
                        csvReader.customers.get(i).getRegion(),
                        csvReader.customers.get(i).getRep1(),
                        csvReader.customers.get(i).getRep2(),
                        csvReader.customers.get(i).getItem(),
                        csvReader.customers.get(i).getUnit(),
                        csvReader.customers.get(i).getCost(),
                        csvReader.customers.get(i).getTotal()
                ));

            }
            root.setCenter(tableView);

            Scene scene = new Scene(root, 800, 800);
            stage.setTitle("Tableview");
            stage.setScene(scene);
            stage.show();


        };
        //Se kommentar ovanför
        EventHandler<ActionEvent> jsonHandler = e -> {
            BorderPane root = new BorderPane();




            for (int i = 0; i <= jsonReader.parsJson().size() - 1; i++) {


                tableView.getItems().add(new Customer(jsonReader.parsJson().get(i).getOrderDate(),
                        jsonReader.parsJson().get(i).getRegion(),
                        jsonReader.parsJson().get(i).getRep1(),
                        jsonReader.parsJson().get(i).getRep2(),
                        jsonReader.parsJson().get(i).getItem(),
                        jsonReader.parsJson().get(i).getUnit(),
                        jsonReader.parsJson().get(i).getCost(),
                        jsonReader.parsJson().get(i).getTotal()
                ));
            }

            root.setCenter(tableView);

            Scene scene = new Scene(root, 800, 800);
            stage.setTitle("TableView JSON");
            stage.setScene(scene);
            stage.show();

        };

        showCSV.setLayoutX(100);

        //Binder mina event till mina knappar
        showCSV.setOnAction(csvHandler);
        showJson.setOnAction(jsonHandler);

        stage.setTitle("Table view");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);

        root.getChildren().add(showCSV);
        root.getChildren().add(showJson);

        stage.show();
    }
}