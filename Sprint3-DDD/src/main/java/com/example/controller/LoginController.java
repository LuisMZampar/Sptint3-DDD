package com.example.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.connection.DatabaseUtil;
import com.example.data.UsuarioDao;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class LoginController {
    @FXML
    private TextField emailField;

    @FXML
    private TextField senhaField;

    @FXML
    private void login() {
        String email = emailField.getText();
        String senha = senhaField.getText();

        try (Connection connection = DatabaseUtil.getConnection()) {
            UsuarioDao usuarioDao = new UsuarioDao(connection);

            boolean autenticado = usuarioDao.autenticarUsuario(email, senha);

            if (autenticado) {
                exibirMensagem("Login bem-sucedido!");
                // Redirecione para a próxima tela ou realize outras ações após o login bem-sucedido
            } else {
                exibirMensagem("Login falhou. Verifique suas credenciais.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            exibirMensagem("Erro ao autenticar o usuário.");
        }
    }

    // Métodos auxiliares, como exibirMensagem, devem ser definidos aqui
    private void exibirMensagem(String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensagem");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }/*  */
}
