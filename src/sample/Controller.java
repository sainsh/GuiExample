package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {

    @FXML
    public TextField inputTextField;
    @FXML
    public TextArea outputTextField;

    public void onSendCommand(ActionEvent actionEvent) {

        try {

            String bob = inputTextField.getText();
            System.out.println(bob.charAt(bob.length() + 1));

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        } finally {
            if (inputTextField.getText().charAt(0) == '@') {
                StringBuilder s = new StringBuilder(inputTextField.getText());
                s.deleteCharAt(0);
                outputTextField.setText(s.toString() + "\n" + outputTextField.getText());


            } else if (inputTextField.getText().charAt(0) == '/') {

                StringBuilder s = new StringBuilder(inputTextField.getText());
                s.deleteCharAt(0);
                s.reverse();
                if(outputTextField.getText().equals("")) {

                    outputTextField.setText(s.toString());

                }else{
                    outputTextField.setText(outputTextField.getText() + "\n" + s.toString());
                }

            } else {

                if (outputTextField.getText().equals("")) {
                    outputTextField.setText(inputTextField.getText());


                } else {
                    outputTextField.setText(outputTextField.getText() + "\n" + inputTextField.getText());
                }
            }
            inputTextField.setText("");
        }


    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            onSendCommand(new ActionEvent());
        }
    }
}
