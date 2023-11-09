package domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.persistence.Persistente;

@Entity
@Table(name = "TB_CARRO")
public class Carro2 implements Persistente{
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
	public int hashCode() {
		return Objects.hash(anoFabricacao, codigo, marca, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro2 other = (Carro2) obj;
		return Objects.equals(anoFabricacao, other.anoFabricacao) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}
    
    

}
