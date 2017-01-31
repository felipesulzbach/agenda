package br.com.felipe.agenda.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by felipe on 11/01/2017.
 */
public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private Integer idade;
    private String endereco;
    private String fone;
    private String site;
    private String email;
    private BigDecimal nota;

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append(getId());
        stb.append(" - ");
        stb.append(getNome());
        return stb.toString();
    }

    private Aluno(){}

    public static synchronized Aluno create() {
        return new Aluno();
    }

    public Long getId() {
        return id;
    }

    public Aluno withId(final Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Aluno withNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public Integer getIdade() {
        return idade;
    }

    public Aluno withIdade(final Integer idade) {
        this.idade = idade;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Aluno withEndereco(final String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getFone() {
        return fone;
    }

    public Aluno withFone(final String fone) {
        this.fone = fone;
        return this;
    }

    public String getSite() {
        return site;
    }

    public Aluno withSite(final String site) {
        this.site = site;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Aluno withEmail(final String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public Aluno withNota(final BigDecimal nota) {
        this.nota = nota;
        return this;
    }
}
