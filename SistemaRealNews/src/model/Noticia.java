package model;



public class Noticia {
	
	private static final long seralVersionUNNID  = 1L;
	
	private int id;
	private String titulo;
	private String descricao;
	private String texto;
	
	public Noticia() {}

	public Noticia(int id, String descricao, String titulo, String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return  " - " + "Identificador:  " + getId() +  "<br>" + 
				" - " + "Descrição:  "  + getDescricao() + "<br>" +
				" - " + "Titulo:  " + getTitulo() + "<br>" +
				" - " + "Texto:  " + getTexto(); 				
	}

}
