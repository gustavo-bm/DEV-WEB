

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@WebServlet("/recommend")
public class MovieServlet extends HttpServlet {

    private List<Movie> movieList;
    private final Random random = new Random();

    @Override
    public void init() throws ServletException {
        // Carrega os filmes do JSON uma vez quando o servlet é iniciado
        try (InputStream is = getServletContext().getResourceAsStream("/WEB-INF/movies.json")) {
            if (is == null) {
                throw new ServletException("Arquivo movies.json não encontrado no /WEB-INF!");
            }
            
            // Leitura do arquivo com Charset UTF-8 para garantir a acentuação correta
            String jsonText = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

            Gson gson = new Gson();
            Type listType = new TypeToken<List<Movie>>() {}.getType();
            movieList = gson.fromJson(jsonText, listType);

        } catch (IOException e) {
            throw new ServletException("Erro ao ler o arquivo movies.json", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (movieList != null && !movieList.isEmpty()) {
            // Seleciona um filme aleatório da lista
            Movie randomMovie = movieList.get(random.nextInt(movieList.size()));
            request.setAttribute("movie", randomMovie);
        } else {
            // Caso a lista esteja vazia ou não tenha sido carregada
            request.setAttribute("error", "Nenhum filme disponível para recomendação.");
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    // Classe interna para representar a estrutura de um filme no JSON
    // Gson usará esta classe para converter o JSON em objetos Java
    public static class Movie {
        private String titulo;
        private int ano;
        private String diretor;
        private String genero;
        private String sinopse;
        private String posterUrl;

        // Getters são necessários para que a Expression Language (EL) no JSP possa acessá-los
        public String getTitulo() { return titulo; }
        public int getAno() { return ano; }
        public String getDiretor() { return diretor; }
        public String getGenero() { return genero; }
        public String getSinopse() { return sinopse; }
        public String getPosterUrl() { return posterUrl; }
    }
}