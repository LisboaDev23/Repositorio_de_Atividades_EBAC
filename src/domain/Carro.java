package domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_CARRO")
public class Carro {
    @Id
    @GeneratedValue(generator = "CARRO_SEQUENCE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CARRO_SEQUENCE",sequenceName = "SQ_CARRO",initialValue = 1,allocationSize = 1)
    private Long id;
    @Column(name = "NOME",nullable = false)
    private String nome;
    @Column(name = "CODIGO",nullable = false,unique = true)
    private Long codigo;
    @Column(name = "PREÇO",nullable = false)
    private Double preco;
    @Column(name = "ANO_FABRICAÇÃO",nullable = false)
    private Integer anoFabricacao;
    @ManyToOne
    @JoinColumn(name = "ID_MARCA",foreignKey = @ForeignKey(name = "FK_CARRO_MARCA"),referencedColumnName ="ID",nullable = false)
    private Marca marca;
    @OneToMany(mappedBy = "carro")
    private List<Acessorio> acessorios;


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

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Double.compare(carro.preco,preco) ==0 &&
                Objects.equals(nome, carro.nome) &&
                Objects.equals(codigo, carro.codigo) &&
                Objects.equals(anoFabricacao, carro.anoFabricacao) &&
                Objects.equals(marca, carro.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, preco, anoFabricacao, marca);
    }
}
