package br.com.alura.jdbc.modelo;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private int categoriaId;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    @Override
    public String toString(){
        return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }


}
