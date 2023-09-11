package com.example;

import java.io.IOException;
import java.sql.SQLException;

import com.example.data.PrestadorDao;
import com.example.model.Prestador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    TextField txtEmail;
    @FXML
    TextField txtSenha;
    @FXML
    TextField txtNome;
    @FXML
    TextField txtModeloGuincho;
    @FXML

    ListView<Prestador> lista;
    PrestadorDao dao = new PrestadorDao();

    public void adicionarAluno() {
        Prestador aluno = this.carregarPrestadorDoFormulario();

        try {
            this.dao.inserir(aluno);
            this.limparFormulario();
            this.atualizarTela();
        } catch (SQLException var3) {
            this.mostrarMensagem(AlertType.ERROR, "Erro", var3.getMessage());
        }

    }

    private void limparFormulario() {
        this.txtNome.clear();
        this.txtModeloGuincho.clear();
        this.txtEmail.clear();
        this.txtSenha.clear();
    }

    private void mostrarMensagem(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }

    private Prestador carregarPrestadorDoFormulario() {
        return new Prestador(this.txtEmail.getText(), this.txtSenha.getText(), this.txtNome.getText(),
                this.txtModeloGuincho.getText());
    }

    public void atualizarTela() {
        this.lista.getItems().clear();

        try {
            this.dao.buscarTodos().forEach((aluno) -> {
                this.lista.getItems().add(aluno);
            });
        } catch (SQLException var2) {
            this.mostrarMensagem(AlertType.ERROR, "ERRO", var2.getMessage());
        }

    }

    public void apagar() {
        Prestador aluno = (Prestador) this.lista.getSelectionModel().getSelectedItem();

        try {
            this.dao.apagar(aluno);
            this.atualizarTela();
        } catch (SQLException var3) {
            this.mostrarMensagem(AlertType.ERROR, "Erro", var3.getMessage());
        }

    }
}