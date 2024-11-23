package org.olesya.musicaldevapp.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ControllerUtils {
    public static void showCommonWarningAlert(String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание!");
        alert.setHeaderText(String.format("%s", description));
        alert.setResizable(true);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);

        alert.showAndWait();
    }

    public static Integer getIntegerFromTextField(TextField textField, String fieldName) throws CommonException {
        try {
            return Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            showCommonWarningAlert("Поле " + fieldName + " должно быть целым числом");
            throw new CommonException("Ошибка форматов");
        }
    }

    public static Integer getPositiveIntegerFromTextField(TextField textField, String fieldName) throws CommonException {
        Integer number = getIntegerFromTextField(textField, fieldName);
        if (number < 0) {
            showCommonWarningAlert("Поле " + fieldName + " должно быть положительным целым числом");
            throw new CommonException("Ошибка форматов");
        }
        return number;
    }
}
