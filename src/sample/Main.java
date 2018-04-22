package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Main extends Application {
    public static String CurrentCal = "";
    public boolean showhistory = false;
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        String css = this.getClass().getResource("style.css").toExternalForm();

        Parent root = loader.load();
        Scene scene = new Scene(root, 230, 420);
        primaryStage.setTitle("Kalkylator");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon2.png")));
        primaryStage.setScene(scene);
        root.getStylesheets().add(css);
        Button but1 = (Button) loader.getNamespace().get("but1");
        Button but2 = (Button) loader.getNamespace().get("but2");
        Button but3 = (Button) loader.getNamespace().get("but3");
        Button but4 = (Button) loader.getNamespace().get("but4");
        Button but5 = (Button) loader.getNamespace().get("but5");
        Button but6 = (Button) loader.getNamespace().get("but6");
        Button but7 = (Button) loader.getNamespace().get("but7");
        Button but8 = (Button) loader.getNamespace().get("but8");
        Button but9 = (Button) loader.getNamespace().get("but9");
        Button but0 = (Button) loader.getNamespace().get("but0");
        Button butCE = (Button) loader.getNamespace().get("butCE");
        Button BtnPlus = (Button) loader.getNamespace().get("btnplus");
        Button btndelete = (Button) loader.getNamespace().get("btndelete");
        Button btnequals = (Button) loader.getNamespace().get("btnEquals");
        Button BtnMinu = (Button) loader.getNamespace().get("BtnMinu");
        Button BtnPower = (Button) loader.getNamespace().get("BtnPower");
        Button BtnDev = (Button) loader.getNamespace().get("BtnDev");
        Button Btn1x = (Button) loader.getNamespace().get("Btn1x");
        Button BtnTimes = (Button) loader.getNamespace().get("BtnTimes");
        Button Btnsqrt = (Button) loader.getNamespace().get("Btnsqrt");
        Button BtnPlMi = (Button) loader.getNamespace().get("BtnPlMi");
        Label num1 = (Label) loader.getNamespace().get("num1");

        butCE.setOnAction(e-> setInfoText(num1, ""));
        but1.setOnAction(e-> setInfoText(num1, "1"));
        but2.setOnAction(e-> setInfoText(num1, "2"));
        but3.setOnAction(e-> setInfoText(num1, "3"));
        but4.setOnAction(e-> setInfoText(num1, "4"));
        but5.setOnAction(e-> setInfoText(num1, "5"));
        but6.setOnAction(e-> setInfoText(num1, "6"));
        but7.setOnAction(e-> setInfoText(num1, "7"));
        but8.setOnAction(e-> setInfoText(num1, "8"));
        but9.setOnAction(e-> setInfoText(num1, "9"));
        but0.setOnAction(e-> setInfoText(num1, "0"));

        btndelete.setOnAction(e-> deleteLastValue(num1));

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                                   @Override
                                   public void handle(KeyEvent event) {
                                       switch (event.getCode()) {
                                           case DIGIT0:
                                               setInfoText(num1, "0");
                                               break;
                                           case DIGIT1:
                                               setInfoText(num1, "1");
                                               break;
                                           case DIGIT2:
                                               setInfoText(num1, "2");
                                               break;
                                           case DIGIT3:
                                               setInfoText(num1, "3");
                                               break;
                                           case DIGIT4:
                                               setInfoText(num1, "4");
                                               break;
                                           case DIGIT5:
                                               setInfoText(num1, "5");
                                               break;
                                           case DIGIT6:
                                               setInfoText(num1, "6");
                                               break;
                                           case DIGIT7:
                                               setInfoText(num1, "7");
                                               break;
                                           case DIGIT8:
                                               setInfoText(num1, "8");
                                               break;
                                           case DIGIT9:
                                               setInfoText(num1, "9");
                                               break;
                                           case BACK_SPACE:
                                               deleteLastValue(num1);
                                               break;
                                           case PLUS:
                                               setInfoText(num1, "+");
                                               break;
                                           case MINUS:
                                               setInfoText(num1, "-");
                                       }
                                   }
                               });

        BtnPlMi.setOnAction(e-> {
            if (!CurrentCal.substring(0, 1).equals("-") ) {
                System.out.println(CurrentCal.charAt(0));
                CurrentCal = "-" + CurrentCal;
                lengthCheck(num1, CurrentCal.length());
                num1.setText(CurrentCal);
            } else {
                CurrentCal = CurrentCal.substring(1, CurrentCal.length());
                lengthCheck(num1, CurrentCal.length());
                num1.setText(CurrentCal);
            }
        });

        BtnPlus.setOnAction(e-> {
            if(!num1.getText().contains("+"))
            setInfoText(num1, "+");
        });
        BtnMinu.setOnAction(e->
        {
            int count = num1.getText().length() - num1.getText().replace("-", "").length();
            System.out.println(count);
            if (count < 1){
                setInfoText(num1, "-");
            }else if(CurrentCal.substring(0, 1).equals("-")){
                if (count < 2) {
                    setInfoText(num1, "-");
                }

            }

        });
        BtnDev.setOnAction(e-> {
            if(!num1.getText().contains("/")){
                setInfoText(num1, "/");
            }
        });
        BtnTimes.setOnAction(e-> {
            if(!num1.getText().contains("*")) {
                setInfoText(num1, "*");
            }
        });

        Btnsqrt.setOnAction(e-> {
            if (!CurrentCal.isEmpty() && !CurrentCal.equals("0")) {
                CurrentCal = String.valueOf(Math.sqrt(Double.parseDouble(CurrentCal)));
                lengthCheck(num1, CurrentCal.length());
                num1.setText(CurrentCal);
            }
        });
        Btn1x.setOnAction(e-> {
            if (!CurrentCal.isEmpty() && !CurrentCal.equals("0")) {
                CurrentCal = String.valueOf(1 / Double.parseDouble(CurrentCal.toString()));
                lengthCheck(num1, CurrentCal.length());
                num1.setText(CurrentCal);
            }
        });

        BtnPower.setOnAction(e-> {

            try {
                CurrentCal = String.valueOf(Math.pow(Double.parseDouble(CurrentCal), 2));
                num1.setText(CurrentCal);
            }catch (Exception ex) {
                System.out.println(ex);
            }
            int length = CurrentCal.length();
            System.out.println(length);
            lengthCheck(num1, length);
        });
        btnequals.setOnAction((ActionEvent e) -> {
            if(CurrentCal.contains("+")) {
                String calc;
                double Sum = 0;
                calc = CurrentCal.replace("+", ",");
                List<String> Equation = Arrays.asList(calc.split(","));
                for(int i=0; Equation.size() > i; i++) {
                    try {
                        Sum = Sum + Double.parseDouble(Equation.get(i).toString());
                        CurrentCal = String.valueOf(Sum);
                        num1.setText(CurrentCal);
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }else if (CurrentCal.contains("-")){
                String calc;
                double Sum;
                calc = CurrentCal.replace("-", ",");
                List<String> Equation = Arrays.asList(calc.split(","));
                if(Equation.get(0).toString().isEmpty()) {
                    Sum = - + Double.parseDouble(Equation.get(1).toString());
                }else {
                    Sum = Double.parseDouble(Equation.get(0).toString());
                }
                for(int i=1; Equation.size() > i; i++) {
                    try {
                        Sum = Sum - Double.parseDouble(Equation.get(i).toString());
                        System.out.println(Sum);
                        CurrentCal = String.valueOf(Sum);
                        num1.setText(CurrentCal);
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }else if (CurrentCal.contains("/")){
                String calc;
                double Sum;
                calc = CurrentCal.replace("/", ",");
                List<String> Equation = Arrays.asList(calc.split(","));
                Sum = Double.parseDouble(Equation.get(0).toString());
                for(int i=1; Equation.size() > i; i++) {
                    try {
                        Sum = Sum / Double.parseDouble(Equation.get(i).toString());
                        System.out.println(Sum);
                        CurrentCal = String.valueOf(Sum);
                        num1.setText(CurrentCal);
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }
            else if (CurrentCal.contains("*")){
                String calc;
                double Sum;
                calc = CurrentCal.replace("*", ",");
                List<String> Equation = Arrays.asList(calc.split(","));
                Sum = Double.parseDouble(Equation.get(0).toString());
                for(int i=1; Equation.size() > i; i++) {
                    try {
                        Sum = Sum * Double.parseDouble(Equation.get(i).toString());
                        System.out.println(Sum);
                        CurrentCal = String.valueOf(Sum);
                        num1.setText(CurrentCal);
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            }
            String LastChar;
            LastChar = CurrentCal.substring(CurrentCal.length()-2) + CurrentCal.substring(CurrentCal.length()-1);;
            if (LastChar.equals(".0")) {
                deleteLastValue(num1);
                deleteLastValue(num1);
            }
        });
        primaryStage.show();
    }
    private static void lengthCheck(Label num1, int length) {
        if(length > 9 && length < 10) {
            num1.setFont(new Font( 30));
            num1.setStyle("-fx-font-weight: bold");
        }else if(length > 9 && length < 17){
            num1.setFont(new Font( 25));
        }else if(length > 16) {
            num1.setFont(new Font(20));
        }
    }
    public static void setInfoText(Label label, String num) {
        int length = CurrentCal.length();
        lengthCheck(label, length);
        if(num.isEmpty()) {
            CurrentCal = "";
            label.setText("0");
        }else {
            CurrentCal = CurrentCal + num;
            label.setText(CurrentCal);
        }
    }
    public static void deleteLastValue(Label label) {
        String str = CurrentCal;
        if (!(str.length() < 1)) {
            str = str.substring(0, str.length() - 1);
            CurrentCal = str;
        }
        if(CurrentCal.length() < 1) {
            label.setText("0");
        }else {
            label.setText(CurrentCal);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
