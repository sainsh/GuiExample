package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class Controller {

    @FXML
    public TextField inputTextField;
    @FXML
    public TextArea outputTextField;

    public void onSendCommand(ActionEvent actionEvent) {

        try {
            if (inputTextField.getText().charAt(0) == '@') {    //set input first
                StringBuilder s = new StringBuilder(inputTextField.getText());
                s.deleteCharAt(0);
                outputTextField.setText(s.toString() + "\n" + outputTextField.getText());


            } else if (inputTextField.getText().charAt(0) == '/') { //reverse input

                StringBuilder s = new StringBuilder(inputTextField.getText());
                s.deleteCharAt(0);
                s.reverse();
                if (outputTextField.getText().equals("")) {

                    outputTextField.setText(s.toString());

                } else {
                    outputTextField.setText(outputTextField.getText() + "\n" + s.toString());
                }

            } else {    //append input

                if (outputTextField.getText().equals("")) {
                    outputTextField.setText(inputTextField.getText());


                } else {
                    outputTextField.appendText("\n" + inputTextField.getText());
                }
            }
            inputTextField.setText("");



        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
    }


        public void onKeyPressed (KeyEvent keyEvent){   //press enter to run onSendCommand event
            if (keyEvent.getCode() == KeyCode.ENTER) {
                onSendCommand(new ActionEvent());
            }
        }

    public void imageMouseEnter(MouseEvent mouseEvent) {
        if(outputTextField.getText().equals("")){
            outputTextField.appendText("shit en dragehund!");
        }else{
            outputTextField.appendText("\nshit en dragehund!");
        }


    }
}
