
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curriculos")
public class Curriculo {

	private int curriculoId;
	private String dataAtualizacao;
	private String idioma;
	
	@Id
	@Column(name="id_curriculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@OneToMany(mappedBy="curriculo")
	private List<Experiencia> experiencias;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCurriculo() {
		return curriculoId;
	}

	public void setIdCurriculo(int idCurriculo) {
		this.curriculoId = idCurriculo;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}	
	
}
