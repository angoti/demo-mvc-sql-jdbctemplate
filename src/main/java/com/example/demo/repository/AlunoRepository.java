package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Aluno;
import com.example.demo.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoRepository {

        @Autowired
        JdbcTemplate jdbc;

        public List<Aluno> buscaTodos() {
                String consulta = "SELECT * FROM aluno, usuario where usuario.login = aluno.usuario_login;";
                return jdbc.query(consulta,
                                (res, linha) -> new Aluno(
                                                new Usuario(res.getString("login"), res.getString("senha"),
                                                                res.getInt("rg"),
                                                                res.getInt("telefone"), res.getDate("data_nasc"),
                                                                res.getString("email"),
                                                                res.getString("nome"), res.getInt("cpf"),
                                                                res.getString("endereco")),
                                                res.getString("matricula"), res.getString("nome_mae"),
                                                res.getString("nome_pai"),
                                                res.getDate("data_matricula"), res.getInt("tel_responsavel")));
        }

        public int grava(Aluno aluno) {
                Usuario us = aluno.getUsuario();
                String sqlUsuario = "insert into usuario(login, senha, rg, telefone, data_nasc, email, nome, cpf, endereco) values(?,?,?,?,?,?,?,?,?)";
                String sqlAluno = "insert into aluno(matricula,nome_mae,nome_pai,data_matricula,tel_responsavel,usuario_login) values(?,?,?,?,?,?)";
                jdbc.update(sqlUsuario, us.getLogin(), us.getSenha(), us.getRg(), us.getTelefone(), us.getDataNasc(),
                                us.getEmail(), us.getNome(), us.getCpf(), us.getEndereco());
                return jdbc.update(sqlAluno, aluno.getMatricula(), aluno.getNomeMae(), aluno.getNomePai(),
                                aluno.getDataMatricula(), aluno.getTelResponsavel(), aluno.getUsuario().getLogin());

        }

        public int excluir(String id) {
                String sqlAluno = "delete from aluno where usuario_login = ?";
                String sqlUsuario = "delete from usuario where login= ?";
                jdbc.update(sqlAluno, id);
                return jdbc.update(sqlUsuario, id);
        }

        public int atualiza(Aluno aluno) {
                Usuario us = aluno.getUsuario();
                String sqlAluno = "update aluno set matricula = ?,nome_mae = ?,nome_pai = ?,data_matricula = ?,tel_responsavel = ? where usuario_login = ?";
                String sqlUsuario = "update usuario set rg = ?, telefone = ?, data_nasc = ?, email = ?, nome = ?, cpf = ?, endereco = ? where login = ?";
                jdbc.update(sqlAluno, aluno.getMatricula(), aluno.getNomeMae(), aluno.getNomePai(),
                                aluno.getDataMatricula(), aluno.getTelResponsavel(), aluno.getUsuario().getLogin());
                return jdbc.update(sqlUsuario, us.getRg(), us.getTelefone(), us.getDataNasc(), us.getEmail(),
                                us.getNome(), us.getCpf(), us.getEndereco(), us.getLogin());
        }

        public Aluno buscaPorLogin(String login) {
                return jdbc.queryForObject(
                                "SELECT * FROM aluno, usuario where usuario.login = aluno.usuario_login and usuario.login=?;",
                                (res, linha) -> new Aluno(
                                                new Usuario(res.getString("login"), res.getString("senha"),
                                                                res.getInt("rg"),
                                                                res.getInt("telefone"), res.getDate("data_nasc"),
                                                                res.getString("email"),
                                                                res.getString("nome"), res.getInt("cpf"),
                                                                res.getString("endereco")),
                                                res.getString("matricula"), res.getString("nome_mae"),
                                                res.getString("nome_pai"),
                                                res.getDate("data_matricula"), res.getInt("tel_responsavel")),
                                login);
        }
}
