package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

import org.apache.commons.validator.routines.EmailValidator;
public class Controller {

    public TextField ime;
    public TextField prezime;
    public TextField broj_indeksa;
    public TextField jmbg;
    public DatePicker datum;
    public ComboBox izbor;
    public TextField adresa;
    public TextField telefon;
    public TextField mail;
    public ChoiceBox<String> odsjek;
    public ChoiceBox<String> godina;
    public ChoiceBox<String> ciklus;
    public RadioButton redovan;
    public RadioButton samofinansirajuci;
    public CheckBox check;
    private ToggleGroup dugmad;
    public Controller(){
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
        broj_indeksa.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String staro, String novo){
                if (validanIndeks(novo)) {
                    broj_indeksa.getStyleClass().removeAll("poljeNijeIspravno");
                    broj_indeksa.getStyleClass().add("poljeIspravno");
                } else {
                    broj_indeksa.getStyleClass().removeAll("poljeIspravno");
                    broj_indeksa.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        jmbg.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String staro, String novo){
                if (validanJmbg(novo)) {
                    jmbg.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbg.getStyleClass().add("poljeIspravno");
                } else {
                    jmbg.getStyleClass().removeAll("poljeIspravno");
                    jmbg.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        datum.valueProperty().addListener(new ChangeListener<LocalDate>(){
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate staro, LocalDate novo){
                if (validanDatum(novo)) {
                    datum.getStyleClass().removeAll("poljeNijeIspravno");
                    datum.getStyleClass().add("poljeIspravno");
                } else {
                    datum.getStyleClass().removeAll("poljeIspravno");
                    datum.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        adresa.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String staro, String novo){
                if (validnaAdresa(novo)) {
                    adresa.getStyleClass().removeAll("poljeNijeIspravno");
                    adresa.getStyleClass().add("poljeIspravno");
                } else {
                    adresa.getStyleClass().removeAll("poljeIspravno");
                    adresa.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        telefon.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String staro, String novo){
                if (validanTelefon(novo)) {
                    telefon.getStyleClass().removeAll("poljeNijeIspravno");
                    telefon.getStyleClass().add("poljeIspravno");
                } else {
                    telefon.getStyleClass().removeAll("poljeIspravno");
                    telefon.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        ime.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if (!n){
                    if (validnoIme(ime.getText())) {
                        ime.getStyleClass().removeAll("poljeNijeIspravno");
                        ime.getStyleClass().add("poljeIspravno");
                    } else {
                        ime.getStyleClass().removeAll("poljeIspravno");
                        ime.getStyleClass().add("poljeNijeIspravno");
                    }
                }
            }
        });

        mail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String o, String n) {
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(n)) {
                    mail.getStyleClass().removeAll("poljeNijeIspravno");
                    mail.getStyleClass().add("poljeIspravno");
                } else {
                    mail.getStyleClass().removeAll("poljeIspravno");
                    mail.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        prezime.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
            if(!n){
                if (validnoIme(prezime.getText())) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                    }
                }
            }
        });
        jmbg.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
            if(!n){
                if (validanJmbg(jmbg.getText())) {
                    jmbg.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbg.getStyleClass().add("poljeIspravno");
                } else {
                    jmbg.getStyleClass().removeAll("poljeIspravno");
                    jmbg.getStyleClass().add("poljeNijeIspravno");
                }
            }
        }
    });
        mail.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
            if(!n){
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(mail.getText())) {
                    mail.getStyleClass().removeAll("poljeNijeIspravno");
                    mail.getStyleClass().add("poljeIspravno");
                } else {
                    mail.getStyleClass().removeAll("poljeIspravno");
                    mail.getStyleClass().add("poljeNijeIspravno");
                }
            }
        }
    });
        broj_indeksa.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
            if(!n){
                if (validanIndeks(broj_indeksa.getText())) {
                    broj_indeksa.getStyleClass().removeAll("poljeNijeIspravno");
                    broj_indeksa.getStyleClass().add("poljeIspravno");
                } else {
                    broj_indeksa.getStyleClass().removeAll("poljeIspravno");
                    broj_indeksa.getStyleClass().add("poljeNijeIspravno");
                }
            }
        }
    });
        datum.focusedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
            if(!n){
                if (validanDatum(datum.getValue())) {
                    datum.getStyleClass().removeAll("poljeNijeIspravno");
                    datum.getStyleClass().add("poljeIspravno");
                } else {
                    datum.getStyleClass().removeAll("poljeIspravno");
                    datum.getStyleClass().add("poljeNijeIspravno");
                }
            }
        }
    });
        adresa.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validnaAdresa(adresa.getText())) {
                        adresa.getStyleClass().removeAll("poljeNijeIspravno");
                        adresa.getStyleClass().add("poljeIspravno");
                    } else {
                        adresa.getStyleClass().removeAll("poljeIspravno");
                        adresa.getStyleClass().add("poljeNijeIspravno");
                    }
                }
            }
        });
        telefon.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validanTelefon(telefon.getText())) {
                        telefon.getStyleClass().removeAll("poljeNijeIspravno");
                        telefon.getStyleClass().add("poljeIspravno");
                    } else {
                        telefon.getStyleClass().removeAll("poljeIspravno");
                        telefon.getStyleClass().add("poljeNijeIspravno");
                    }
                }
            }
        });

}
    private boolean validanTelefon(String novo) {
        return novo.matches("[0-9]+");
    }

    private boolean validnaAdresa(String novo) {
        if(novo.length()==0)
            return false;

        if(!novo.contains(" "))
            return false;

        String ime_ulice = novo.substring(0, novo.indexOf(' '));
        String broj_ulice = novo.substring(novo.indexOf(' ')+1, novo.length());

        if(!ime_ulice.matches("[a-zA-Z]+") || !broj_ulice.matches("[0-9]+"))
            return false;

        return true;
    }

    private boolean validanDatum(LocalDate novo) {
        //DatePicker.getValue() vraca LocalDate
        int dd = Integer.parseInt(jmbg.getText(0, 2));
        int mm = Integer.parseInt(jmbg.getText(2, 4));
        int ggg = Integer.parseInt(jmbg.getText(4, 7));


        if(ggg != novo.getYear()%1000)
            return false;

        if(mm != novo.getMonthValue())
            return false;

        if(dd != novo.getDayOfMonth())
            return false;

        return true;
    }

    private boolean validanJmbg(String novo) {

        if(novo.length()!=13)
            return false;

        if(!novo.matches("[0-9]+")) 
            return false;

        int dd = Integer.parseInt( novo.substring(0,2) );
        int mm = Integer.parseInt( novo.substring(2,4) );
        int ggg = Integer.parseInt( novo.substring(4,7) );

        if( dd < 1 || dd > YearMonth.of(ggg, mm).lengthOfMonth() )
            return false;

        if(mm>12 || mm<0)
            return false;

        if(ggg>18 && ggg<0)
            return false;

        int k = Integer.parseInt(novo.substring(12, 13));

        int l = 11 - ((7*(Integer.parseInt(jmbg.getText(0,1)) + Integer.parseInt(jmbg.getText(6,7))) +
                6*(Integer.parseInt(jmbg.getText(1,2)) + Integer.parseInt(jmbg.getText(7,8))) +
                5*(Integer.parseInt(jmbg.getText(2,3)) + Integer.parseInt(jmbg.getText(8,9))) +
                4*(Integer.parseInt(jmbg.getText(3,4)) + Integer.parseInt(jmbg.getText(9,10))) +
                3*(Integer.parseInt(jmbg.getText(4,5)) + Integer.parseInt(jmbg.getText(10,11))) +
                2*(Integer.parseInt(jmbg.getText(5,6)) + Integer.parseInt(jmbg.getText(11,12)))) % 11);


        if(l>=1 && l<=9 && l!=k)
            return false;

        if(l>9 && k!=0)
            return false;

        return true;
    }

    private boolean validanIndeks(String novo) {
        if(novo.length()!=5 || !novo.matches("[0-9]+")) return false;
        return true;
    }

    public boolean validnoIme(String novo_ime){
        if(novo_ime.length()>20 || novo_ime.length()<=0) return false;
        if(!novo_ime.matches("[a-zA-Z]+")) return false;
        if(Character.isLowerCase(novo_ime.charAt(0))) return false;
        for(int i=1; i<novo_ime.length(); i++)
        {
            if(Character.isUpperCase(novo_ime.charAt(i)))
                return false;
        }
        return true;
    }
    private boolean Ispravno() {
        if(ime.getText().length() == 0 || prezime.getText().length() == 0 || broj_indeksa.getText().length() == 0 ||
                mail.getText().length() == 0 || jmbg.getText().length() == 0 || datum.getValue() == null)
            return false;
        //getStyleClass vraca ObservableList<String> - imena klasa u css-u
        ArrayList<ObservableList<String>> validno = new ArrayList<>();

        validno.add(ime.getStyleClass());
        validno.add(prezime.getStyleClass());
        validno.add(jmbg.getStyleClass());
        validno.add(broj_indeksa.getStyleClass());
        validno.add(adresa.getStyleClass());
        validno.add(telefon.getStyleClass());
        validno.add(mail.getStyleClass());
        validno.add(datum.getStyleClass());

        for(ObservableList<String> o : validno)
        {
            if(o.contains("poljeNijeIspravno"))
                return false;
        }
        return true;
    }
    private void upozorenje(ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Greška");
        alert.setHeaderText("Forma nije validna!");
        alert.setContentText("Unesite ispravne podatke!");
        alert.showAndWait();
    }

    public void potvrdi(javafx.event.ActionEvent actionEvent) {

        if(!Ispravno())
            upozorenje(actionEvent);
        else {
            System.out.print(ime.getText() + " " + prezime.getText() + " " + broj_indeksa.getText() + " " + jmbg.getText() + " " + datum.getValue() + " " + izbor.getValue()
                    + " " + adresa.getText() + " " + telefon.getText() + " " + mail.getText() + " " + odsjek.getValue() + " " + godina.getValue() + " " + ciklus.getValue());
            if (dugmad.getSelectedToggle().equals(redovan)) System.out.print(" redovan");
            if (dugmad.getSelectedToggle().equals(samofinansirajuci)) System.out.print(" samofinansirajuci");
            if (check.isSelected()) System.out.print(" pripada posebnim borackim kategorijama");
            //da se prozor zatvori nakon pritiska na potvrdi
            Node n = (Node) actionEvent.getSource();
            Stage stage = (Stage) n.getScene().getWindow();
            stage.close();
        }
    }

}
