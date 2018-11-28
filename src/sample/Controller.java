package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;


public class Controller {

    public TextField ime;

    public TextField prezime;
    public TextField broj_indeksa;
    public TextField jmbg;
    public TextField datum;
    public ComboBox izbor;
    public TextField adresa;
    public TextField telefon;
    public TextField mail;
    public ChoiceBox<String> odsjek;
    public ChoiceBox<String> godina;
    public ChoiceBox<String> ciklus;
    private SimpleStringProperty name, last_name, index, JMBG, date, adress, phone, email;
    public Controller(){
        name=new SimpleStringProperty();
        last_name=new SimpleStringProperty();
        index=new SimpleStringProperty();
        JMBG=new SimpleStringProperty();
        date=new SimpleStringProperty();
        adress=new SimpleStringProperty();
        phone=new SimpleStringProperty();
        email=new SimpleStringProperty();
    }
    public void initialize() {
        ime.textProperty().bindBidirectional(name);
        prezime.textProperty().bindBidirectional(last_name);
        broj_indeksa.textProperty().bindBidirectional(index);
        jmbg.textProperty().bindBidirectional(JMBG);
        datum.textProperty().bindBidirectional(date);
        izbor.getItems().addAll("Sarajevo", "Mostar", "Zenica", "Foca", "Tuzla", "Doboj");
        adresa.textProperty().bindBidirectional(adress);
        telefon.textProperty().bindBidirectional(phone);
        mail.textProperty().bindBidirectional(email);
        odsjek.getItems().addAll("AE","EE","RI","TK");
        godina.getItems().addAll("prva","druga","treca");
        ciklus.getItems().addAll("bachelor", "master", "doktorski studij", "stručni studij");
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
    public SimpleStringProperty JMBGProperty() {
        return JMBG;
    }
    public String getJMBG() {
        return JMBG.get();
    }
    public SimpleStringProperty dateProperty() {
        return date;
    }
    public String getDate() {
        return date.get();
    }
    public SimpleStringProperty adressProperty(){
        return adress;
    }
    public String getAdress(){
        return adress.get();
    }
    public SimpleStringProperty phoneProperty(){
        return phone;
    }
    public String getPhone(){
        return phone.get();
    }
    public SimpleStringProperty emailProperty(){
        return email;
    }
    public String getEmail(){
        return email.get();
    }
    public void potvrdi(javafx.event.ActionEvent actionEvent) {
        System.out.println(getName()+" "+getLastName()+" "+getIndex()+" "+getJMBG()+" "+getDate()+" "+izbor.getValue()
        +" "+getAdress()+" "+getPhone()+" "+getEmail()+" "+odsjek.getValue()+" "+godina.getValue()+" "+ciklus.getValue());
    }

}
