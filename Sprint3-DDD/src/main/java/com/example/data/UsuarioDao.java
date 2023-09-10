package com.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Usuario;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    // Inserir um novo usuário no banco de dados
    public void inserirUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (email, cpf, senha, nome) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getNome());

            preparedStatement.executeUpdate();
        }
    }

    // Atualizar informações de um usuário no banco de dados
    public void atualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET email=?, cpf=?, senha=?, nome=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getNome());

            preparedStatement.executeUpdate();
        }
    }

    // Buscar um usuário pelo seu ID
    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapearUsuario(resultSet);
                }
            }
        }
        return null; // Retorna null se nenhum usuário com o ID fornecido for encontrado
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    usuarios.add(mapearUsuario(resultSet));
                }
            }
        }
        return usuarios;
    }

    // Excluir um usuário do banco de dados
    public void excluirUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    // Método auxiliar para mapear um resultado de consulta para um objeto Usuario
    private Usuario mapearUsuario(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String cpf = resultSet.getString("cpf");
        String senha = resultSet.getString("senha");
        String nome = resultSet.getString("nome");

        return new Usuario(id, email, cpf, senha, nome);
    }

    public boolean autenticarUsuario(String email, String senha) {
        return false;
    }
}
