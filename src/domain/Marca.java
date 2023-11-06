package domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_MARCA")
public class Marca {
    @Id
    @GeneratedValue(generator = "MARCA_SEQUENCE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MARCA_SEQUENCE",sequenceName = "SQ_MARCA",initialValue = 1,allocationSize = 1)
    private Long id;
    @Column(name = "NOME",nullable = false,unique = true)
    private String nome;
    @Column(name = "PAÍS",nullable = false)
    private String pais;
    @Column(name = "AN0_CRIAÇÃO",nullable = false)
    private Integer anoCriacao;
    @Column(name = "RANK_MERCADO")
    private Integer rankMercado;
    @OneToMany(mappedBy = "marca")
    private List<Carro>carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public Integer getRankMercado() {
        return rankMercado;
    }

    public void setRankMercado(Integer rankMercado) {
        this.rankMercado = rankMercado;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public String toString() {
        return "Marca{" +
                ", nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", rankMercado=" + rankMercado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(nome,marca.nome) &&
                Objects.equals(pais,marca.pais)&&
                Objects.equals(anoCriacao,marca.anoCriacao)&&
                Objects.equals(rankMercado,marca.rankMercado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pais, anoCriacao, rankMercado);
    }
}
