
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import sample.Main;

import javax.security.auth.callback.ChoiceCallback;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
class MainTest {

    @Start
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        stage.setScene(new Scene(parent));
        stage.show();
        stage.toFront();
    }

    @Test
    public void imeTacnoPrijeUnosa(FxRobot robot){
        robot.clickOn("#ime");
        TextField imePolje = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("",imePolje.getText());
    }

    @Test
    public void prezimeTacnoPrijeUnosa(FxRobot robot){
        robot.clickOn("#prezime");
        TextField prezimePolje = robot.lookup("#prezime").queryAs(TextField.class);
        assertEquals("",prezimePolje.getText());
    }

    @Test
    public void indeksTacanPrijeUnosa(FxRobot robot){
        robot.clickOn("#broj_indeksa");
        TextField indeksPolje = robot.lookup("#broj_indeksa").queryAs(TextField.class);
        assertEquals("",indeksPolje.getText());
    }

    @Test
    public void jmbgTacanPrijeUnosa(FxRobot robot){
        robot.clickOn("#jmbg");
        TextField jmbgPolje = robot.lookup("#jmbg").queryAs(TextField.class);
        assertEquals("",jmbgPolje.getText());
    }

    @Test
    public void kontaktAdresaTacnaPrijeUnosa(FxRobot robot)
    {
        robot.clickOn("#adresa");
        TextField kontaktAdresaPolje = robot.lookup("#adresa").queryAs(TextField.class);
        assertEquals("",kontaktAdresaPolje.getText());
    }

    @Test
    public void  kontaktTelefonTacanPrijeUnosa(FxRobot robot){
        robot.clickOn("#telefon");
        TextField kontaktTelefonPolje = robot.lookup("#telefon").queryAs(TextField.class);
        assertEquals("",kontaktTelefonPolje.getText());
    }

    @Test
    public void  emailTacanPrijeUnosa(FxRobot robot){
        robot.clickOn("#mail");
        TextField emailPolje = robot.lookup("#mail").queryAs(TextField.class);
        assertEquals("",emailPolje.getText());
    }

    @Test
    public void imeTacnoUneseno(FxRobot robot){
        robot.clickOn("#ime");
        TextField imePolje = robot.lookup("#ime").queryAs(TextField.class);
        robot.write("Nadija");
        assertTrue( imePolje.getStyleClass().contains("poljeIspravno") );
    }

    @Test
    public void imeNetacnoUneseno(FxRobot robot){
        robot.clickOn("#ime");
        TextField imePolje = robot.lookup("#ime").queryAs(TextField.class);
        robot.write("Nadija");
        assertAll("testiranje",
                () ->  { assertTrue( imePolje.getStyleClass().contains("poljeIspravno") ); },
                () ->  { robot.write("1");},
                () -> { assertTrue( imePolje.getStyleClass().contains("poljeNijeIspravno") ); },
                () ->  { robot.type(KeyCode.BACK_SPACE);},
                () ->  { robot.write("N");},
                () -> { assertTrue( imePolje.getStyleClass().contains("poljeNijeIspravno") ); },
                () -> {
                    while( imePolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () ->  { robot.write("nadija");},
                () -> { assertTrue( imePolje.getStyleClass().contains("poljeNijeIspravno") ); }
        );

    }

    @Test
    public void prezimeTacnoUneseno(FxRobot robot){
        robot.clickOn("#prezime");
        TextField prezimePolje = robot.lookup("#prezime").queryAs(TextField.class);
        robot.write("Borovina");
        assertTrue( prezimePolje.getStyleClass().contains("poljeIspravno") );
    }

    @Test
    public void prezimeNetacnoUneseno(FxRobot robot)
    {
        robot.clickOn("#prezime");
        TextField prezimePolje = robot.lookup("#prezime").queryAs(TextField.class);
        robot.write("Borovina");
        assertAll("testiranje",
                () ->  { assertTrue( prezimePolje.getStyleClass().contains("poljeIspravno") ); },

                () ->  { robot.write("1");},
                () -> { assertTrue( prezimePolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () ->  { robot.type(KeyCode.BACK_SPACE);},
                () ->  { robot.write("F");},

                () -> { assertTrue( prezimePolje.getStyleClass().contains("poljeNijeIspravno") ); },
                () -> {
                    while( prezimePolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () ->  { robot.write("slrlk");},
                () -> { assertTrue( prezimePolje.getStyleClass().contains("poljeNijeIspravno") ); }
        );
    }

    @Test
    public void indeksTacnoUnesen(FxRobot robot)
    {
        robot.clickOn("#broj_indeksa");
        TextField indeksPolje = robot.lookup("#broj_indeksa").queryAs(TextField.class);
        robot.write("18067");
        assertTrue( indeksPolje.getStyleClass().contains("poljeIspravno") );
    }

    @Test
    public void indeksNetacnoUnesen(FxRobot robot)
    {
        robot.clickOn("#broj_indeksa");
        TextField indeksPolje = robot.lookup("#broj_indeksa").queryAs(TextField.class);
        robot.write("18067");
        assertAll("testiranje",
                () ->  { assertTrue( indeksPolje.getStyleClass().contains("poljeIspravno") ); },

                () ->  { robot.write("1");},
                () -> { assertTrue( indeksPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () ->  { robot.type(KeyCode.BACK_SPACE);},
                () ->  { robot.write("a");},
                () -> { assertTrue( indeksPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () -> {
                    while( indeksPolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () ->  { robot.write("18a31 ");},
                () -> { assertTrue( indeksPolje.getStyleClass().contains("poljeNijeIspravno") ); }
        );


    }

    @Test
    public void jmbgTacnoUnesen(FxRobot robot)
    {
        robot.clickOn("#jmbg");
        TextField jmbgPolje = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.write("2108998175006");
        assertTrue( jmbgPolje.getStyleClass().contains("poljeIspravno") );
    }

    @Test
    public void  jmbgNetacnoUnesen(FxRobot robot){
        robot.clickOn("#jmbg");
        TextField jmbgPolje = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.write("2108998175006");
        assertAll("testiranje",
                () ->  { assertTrue( jmbgPolje.getStyleClass().contains("poljeIspravno") ); },

                () ->  { robot.write("1");},
                () -> { assertTrue( jmbgPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () ->  { robot.type(KeyCode.BACK_SPACE);},
                () ->  { robot.write("a");},
                () -> { assertTrue( jmbgPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () -> {
                    while( jmbgPolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () ->  { robot.write(" 2908998a70086");},
                () -> { assertTrue( jmbgPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () -> {
                    while( jmbgPolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                }

        );

    }

    @Test
    public void  kontaktTelefonTacnoUnesen(FxRobot robot){
        robot.clickOn("#telefon");
        TextField kontaktTelefonPolje = robot.lookup("#telefon").queryAs(TextField.class);
        robot.write("062119900");
        assertTrue( kontaktTelefonPolje.getStyleClass().contains("poljeIspravno") );
    }

    @Test
    public void  kontaktTelefonNetacnoUnesen(FxRobot robot){
        robot.clickOn("#telefon");
        TextField kontaktTelefonPolje = robot.lookup("#telefon").queryAs(TextField.class);
        robot.write("246387658745");
        assertAll("testiranje",
                () ->  { assertTrue( kontaktTelefonPolje.getStyleClass().contains("poljeIspravno") ); },

                () ->  { robot.write("2");},
                () -> { assertTrue( kontaktTelefonPolje.getStyleClass().contains("poljeIspravno") ); },

                () ->  { robot.type(KeyCode.BACK_SPACE);},
                () ->  { robot.write("N");},
                () -> { assertTrue( kontaktTelefonPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () -> {
                    while( kontaktTelefonPolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () ->  { robot.write(" 060338a1032");},
                () -> { assertTrue( kontaktTelefonPolje.getStyleClass().contains("poljeNijeIspravno") ); }
        );
    }

    @Test
    public void  kontaktAdresaTacnoUnesena(FxRobot robot){
        robot.clickOn("#adresa");
        TextField kontaktAdresaPolje = robot.lookup("#adresa").queryAs(TextField.class);
        robot.write("Radnicka 19");
        assertAll("testiranje",
                () -> { assertTrue( kontaktAdresaPolje.getStyleClass().contains("poljeIspravno") ); },
                () -> { robot.write("Radnicka"); },
                () -> { assertTrue( kontaktAdresaPolje.getStyleClass().contains("poljeNijeIspravno") ); }
        );
    }

    @Test
    public void emailTacnoUnesen(FxRobot robot){
        robot.clickOn("#mail");
        TextField emailPolje = robot.lookup("#mail").queryAs(TextField.class);
        robot.write("nadija.b@gmail.com");
        assertTrue( emailPolje.getStyleClass().contains("poljeIspravno") );
    }

    @Test
    public void emailNetacnoUnesen(FxRobot robot){
        robot.clickOn("#mail");
        TextField emailPolje = robot.lookup("#mail").queryAs(TextField.class);
        robot.write("nborovina1@etf.unsa.ba");
        assertAll("testiranje",
                () ->  { assertTrue( emailPolje.getStyleClass().contains("poljeIspravno") ); },

                () ->  { robot.write("1");},
                () -> { assertTrue( emailPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () -> {
                    while( emailPolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () ->  { robot.write("nadija@.com");},
                () -> { assertTrue( emailPolje.getStyleClass().contains("poljeNijeIspravno") ); },

                () -> {
                    while( emailPolje.getText().length() != 0 )
                        robot.type(KeyCode.BACK_SPACE);
                },
                () -> { robot.write("@hotmail.com");},
                () -> { assertTrue( emailPolje.getStyleClass().contains("poljeNijeIspravno") ); }
        );
    }
}