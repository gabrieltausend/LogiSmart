package model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String enderecoEntrega;
    private String caminhoImagem;
    public Produto(
            int id,
            String nome,
            String descricao,
            double preco,
            String enderecoEntrega,
            String caminhoImagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.enderecoEntrega = enderecoEntrega;
        this.caminhoImagem = caminhoImagem;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
    @Override
    public String toString() {
        return nome;
    }
}