package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.persistence.Persistente;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio2 implements Persistente{
	    
	
		@Id
		//@GeneratedValue(strategy=GenerationType.AUTO)
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
		public int hashCode() {
			return Objects.hash(codigo, nome, preco, tipoAcessorio);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Acessorio2 other = (Acessorio2) obj;
			return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome)
					&& Objects.equals(preco, other.preco) && Objects.equals(tipoAcessorio, other.tipoAcessorio);
		}
	    
	    
}
