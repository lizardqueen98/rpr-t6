package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;


public class Controller {

    public TextField ime;

    public TextField prezime;
    public TextField broj_indeksa;
    private SimpleStringProperty name, last_name, index;
    public Controller(){
        name=new SimpleStringProperty();
        last_name=new SimpleStringProperty();
        index=new SimpleStringProperty();
    }
    public void initialize() {
        ime.textProperty().bindBidirectional(name);
        prezime.textProperty().bindBidirectional(last_name);
        broj_indeksa.textProperty().bindBidirectional(index);
    }
    public SimpleStringProperty nameProperty() {
        return name;
    }
    public String getName() {
        return name.get();
    }
    public SimpleStringProperty lastNameProperty() {
        return last_name;
    }
    public String getLastName() {
        return last_name.get();
    }
    public SimpleStringProperty indexProperty() {
        return index;
    }
    public String getIndex() {
        return index.get();
    }
    public void unesi(){
        nameProperty().setValue(ime.getText());
        lastNameProperty().setValue(prezime.getText());
        indexProperty().setValue(broj_indeksa.getText());
    }
    public void potvrdi(javafx.event.ActionEvent actionEvent) {
        System.out.println(getName()+" "+getLastName()+" "+getIndex());
    }

}
