package br.com.felipe.agenda.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by felipe on 11/01/2017.
 */
public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private String sexo;
    private Integer idade;
    private String endereco;
    private String fone;
    private String site;
    private String email;
    private BigDecimal nota;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Aluno aluno = (Aluno) o;
        if (!id.equals(aluno.id)) {
            return false;
        }
        return nome.equals(aluno.nome);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        return result;
    }

    private Aluno(){}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getFone() {
        return fone;
    }

    public String getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public static synchronized Aluno create() {
        return new Aluno();
    }

    public Aluno withId(final Long id) {
        this.id = id;
        return this;
    }

    public Aluno withNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public Aluno withSexo(final String sexo) {
        this.sexo = sexo;
        return this;
    }

    public Aluno withIdade(final Integer idade) {
        this.idade = idade;
        return this;
    }

    public Aluno withEndereco(final String endereco) {
        this.endereco = endereco;
        return this;
    }

    public Aluno withFone(final String fone) {
        this.fone = fone;
        return this;
    }

    public Aluno withSite(final String site) {
        this.site = site;
        return this;
    }

    public Aluno withEmail(final String email) {
        this.email = email;
        return this;
    }

    public Aluno withNota(final BigDecimal nota) {
        this.nota = nota;
        return this;
    }
}
