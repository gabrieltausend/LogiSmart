package dao;

import database.Conexao;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProdutoDAO {
    public void salvar(
            Produto produto
    ){
        String sql =
                """
                INSERT INTO produto
                (
                nome,
                descricao,
                preco,
                endereco,
                imagem
                )
                VALUES
                (
                ?,?,?,?,?
                )
                """;

        try(
            Connection con =
                    Conexao.conectar();
            PreparedStatement stmt =
                    con.prepareStatement(sql)
        ){
            stmt.setString(
                    1,
                    produto.getNome()
            );
            stmt.setString(
                    2,
                    produto.getDescricao()
            );
            stmt.setDouble(
                    3,
                    produto.getPreco()
            );
            stmt.setString(
                    4,
                    produto.getEnderecoEntrega()
            );
            stmt.setString(
                    5,
                    produto.getCaminhoImagem()
            );
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}