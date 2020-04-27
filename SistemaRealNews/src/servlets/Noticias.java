package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Noticia;
import model.Comentario;
import dao.NoticiaDAO;
import dao.ComentarioDAO;
import service.NoticiaService;
import service.ComentarioService;


@WebServlet("/Noticias.do")
public class Noticias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		HttpSession sessao = request.getSession();
		
		Noticia noticiaConsultada = (Noticia) sessao.getAttribute("noticiaConsultada");
		
		saida.println("<link rel=\"stylesheet\" href=\"style/style.css\" />");
		saida.println("<body class=\"-posts\">");
		saida.println("<div class=\"container\">");
		saida.println("<h1 class=\"logo -dark\"><a class=\"-dark\" href=\"/SistemaGerenciadorNoticiasRealNews/\">RealNews</a></h1>");
		saida.println("<hr>");
		saida.println("<h2 class=\"title\">" + noticiaConsultada.getTitulo() + "</h2>");
		saida.println("<p class=\"caption\">" + noticiaConsultada.getTexto() + "</p>");
		
		
		ComentarioService comentariaService = new ComentarioService();
		ArrayList<Comentario> listaComentarios = comentariaService.listarComentario();
		
		
		saida.println("<h2>Comentários:</h2>");
		
		listaComentarios.forEach(c -> {
					
			int id_noticia_fk = noticiaConsultada.getId();
			int id_comentario_fk = c.getFk_noticia_id(); 
			
			if(id_comentario_fk == id_noticia_fk) {
				saida.println("<h3>" + c.getNome() + "</h3>");
				saida.println("<p>" + c.getTexto() + "</p>" + "<br>");
				saida.println("<hr>");
			} 
			
		});
		
		saida.println("<h3>Adicionar comentário:</h3>");
		
		saida.println("<form action='Inserir_Comentario.do' method='get'>");
		saida.println("<label for=\"fname\">Nome:</label>");
		saida.println("<input id=\"fname\" type='text' name='nome_comentario'>");
		saida.println("<label id=\"fcomentario\">Comentario:</label>");
		saida.println("<textarea id=\"fcomentario\" name='texto_comentario' cols='40' rows='4'></textarea>");
		saida.println("<input  type='submit' value='Enviar'>");
		saida.println("</form>");
		saida.println("</div>");
				
	}

}
