package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

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
    public RadioButton redovan;
    public RadioButton samofinansirajuci;
    private ToggleGroup dugmad;
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
        dugmad=new ToggleGroup();
    }
    public void initialize() {
        izbor.getItems().addAll("Sarajevo", "Mostar", "Zenica", "Foca", "Tuzla", "Doboj");
        odsjek.getItems().addAll("AE","EE","RI","TK");
        godina.getItems().addAll("prva","druga","treca");
        ciklus.getItems().addAll("bachelor", "master", "doktorski studij", "stručni studij");
        redovan.setToggleGroup(dugmad);
        samofinansirajuci.setToggleGroup(dugmad);
        ime.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String staro, String novo){
                if (validnoIme(novo)) {
                   ime.getStyleClass().removeAll("poljeNijeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        prezime.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String staro, String novo){
                if (validnoIme(novo)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        ime.textProperty().bindBidirectional(name);
        prezime.textProperty().bindBidirectional(last_name);
        broj_indeksa.textProperty().bindBidirectional(index);
        jmbg.textProperty().bindBidirectional(JMBG);
        datum.textProperty().bindBidirectional(date);
        adresa.textProperty().bindBidirectional(adress);
        telefon.textProperty().bindBidirectional(phone);
        mail.textProperty().bindBidirectional(email);
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

    /*ime.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
            if (validnoImePrezime(n)) {
                name.getStyleClass().removeAll("poljeNijeIspravno");
                name.getStyleClass().add("poljeIspravno");
            } else {
                imePrezimeField.getStyleClass().removeAll("poljeIspravno");
                imePrezimeField.getStyleClass().add("poljeNijeIspravno");
            }
        }
    });*/
    public boolean validnoIme(String novo_ime){
        if(novo_ime.length()>20 || novo_ime.length()<=0) return false;
        return true;
    }
    public void potvrdi(javafx.event.ActionEvent actionEvent) {

        System.out.print(getName()+" "+getLastName()+" "+getIndex()+" "+getJMBG()+" "+getDate()+" "+izbor.getValue()
        +" "+getAdress()+" "+getPhone()+" "+getEmail()+" "+odsjek.getValue()+" "+godina.getValue()+" "+ciklus.getValue());
        if(dugmad.getSelectedToggle().equals(redovan)) System.out.print(" redovan");
        if(dugmad.getSelectedToggle().equals(samofinansirajuci)) System.out.print(" samofinansirajuci");
    }

}
