package domain;

import javax.persistence.*;

import dao.persistence.Persistente;

import java.util.Objects;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio implements Persistente {
    @Id
    @GeneratedValue(generator = "ACESSORIO_SEQUENCE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ACESSORIO_SEQUENCE",sequenceName = "SQ_ACESSORIO",initialValue = 1,allocationSize = 1)
    private Long id;
    @Column(name = "NOME",nullable = false)
    private String nome;
    @Column(name = "CODIGO",nullable = false,unique = true)
    private Long codigo;
    @Column(name = "PREÇO",nullable = false)
    private Double preco;
    @Column(name = "TIPO_ACESSORIO",nullable = false)
    private String tipoAcessorio;
    @ManyToOne
    @JoinColumn(name = "ID_CARRO",foreignKey = @ForeignKey(name = "FK_ACESSORIO_CARRO"),referencedColumnName = "ID",nullable = false)
    private Carro carro;

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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipoAcessorio() {
        return tipoAcessorio;
    }

    public void setTipoAcessorio(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acessorio acessorio = (Acessorio) o;
        return Objects.equals(nome, acessorio.nome) &&
                Objects.equals(codigo, acessorio.codigo) &&
                Double.compare(preco, acessorio.preco) ==0 &&
                Objects.equals(tipoAcessorio, acessorio.tipoAcessorio) &&
                Objects.equals(carro, acessorio.carro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, preco, tipoAcessorio, carro);
    }
}
