package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private List<Double> list = new List<>();

    @FXML
    private TextField inputTextField;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private TextField firstIndexField;

    @FXML
    private TextField secondIndexField;


    private void redraw(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
            sb.append("\n");
        }
        outputTextArea.setText(sb.toString());
    }

    @FXML
    private void add(){
        String input = inputTextField.getText();
        try{
            double a = Double.parseDouble(input);
            list.add(a);
        }
        catch (Exception e){
            //nothing
        }
        inputTextField.setText("");
        redraw();
    }

    @FXML
    private void remove(){
        int firstIndex = Integer.parseInt(firstIndexField.getText());
        int secondIndex = Integer.parseInt(secondIndexField.getText());
        list.remove(firstIndex, secondIndex);
        redraw();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        inputTextField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                add();
            }
        });
    }

}
