<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Movie Recommender 🍿</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png">
        <link rel="manifest" href="${pageContext.request.contextPath}/manifest.json">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
        <style>
            :root {
                --bg-color: #14181c;
                --card-color: #1f2833;
                --primary-color: #e50914;
                /* Cor inspirada em serviços de streaming */
                --text-color: #f5f5f5;
                --secondary-text-color: #c5c6c7;
            }

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Poppins', sans-serif;
                background-color: var(--bg-color);
                color: var(--text-color);
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                padding: 2rem;
            }

            .container {
                width: 100%;
                max-width: 800px;
                text-align: center;
            }

            .title {
                font-size: 2.5rem;
                font-weight: 700;
                margin-bottom: 0.5rem;
            }

            .title .highlight {
                color: var(--primary-color);
            }

            .subtitle {
                font-size: 1.2rem;
                color: var(--secondary-text-color);
                margin-bottom: 2.5rem;
            }

            .recommend-button {
                background-color: var(--primary-color);
                color: var(--text-color);
                border: none;
                border-radius: 8px;
                padding: 1rem 2.5rem;
                font-size: 1.2rem;
                font-weight: 600;
                cursor: pointer;
                transition: transform 0.2s ease, box-shadow 0.2s ease;
                margin-bottom: 3rem;
            }

            .recommend-button:hover {
                transform: scale(1.05);
                box-shadow: 0 0 20px rgba(229, 9, 20, 0.5);
            }

            .movie-card {
                background-color: var(--card-color);
                border-radius: 12px;
                padding: 2rem;
                text-align: left;
                display: flex;
                gap: 2rem;
                align-items: flex-start;
                animation: fadeIn 0.5s ease-in-out;
            }

            @keyframes fadeIn {
                from {
                    opacity: 0;
                    transform: translateY(20px);
                }

                to {
                    opacity: 1;
                    transform: translateY(0);
                }
            }

            .movie-poster img {
                max-width: 200px;
                border-radius: 8px;
                box-shadow: 0 4px 15px rgba(0, 0, 0, 0.4);
            }

            .movie-details h2 {
                font-size: 2rem;
                font-weight: 700;
                color: var(--primary-color);
                margin-bottom: 0.5rem;
            }

            .movie-details .meta {
                font-size: 1rem;
                color: var(--secondary-text-color);
                margin-bottom: 1.5rem;
            }

            .movie-details .meta span {
                margin-right: 1rem;
            }

            .movie-details .synopsis-title {
                font-weight: 600;
                margin-bottom: 0.5rem;
            }

            .movie-details p {
                line-height: 1.6;
            }

            /* Media query para telas menores */
            @media (max-width: 600px) {
                .movie-card {
                    flex-direction: column;
                    align-items: center;
                    text-align: center;
                }

                .movie-details h2 {
                    font-size: 1.5rem;
                }
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h1 class="title">Movie<span class="highlight">Recommender</span></h1>
            <p class="subtitle">Não sabe o que assistir hoje? Deixe a gente te ajudar! 🎬</p>

            <form action="${pageContext.request.contextPath}/recommend" method="post"> <button type="submit"
                    class="recommend-button">Encontrar um Filme!</button>
            </form>

            <c:if test="${not empty movie}">
                <div class="movie-card">
                    <!-- <div class="movie-poster">
                        <img src="${movie.posterUrl}" alt="Pôster de ${movie.titulo}">
                    </div> -->
                    <div class="movie-details">
                        <h2>${movie.titulo}</h2>
                        <div class="meta">
                            <span><strong>Ano:</strong> ${movie.ano}</span>
                            <span><strong>Gênero:</strong> ${movie.genero}</span>
                        </div>
                        <p class="synopsis-title">Diretor:</p>
                        <p>${movie.diretor}</p>
                        <br>
                        <p class="synopsis-title">Sinopse:</p>
                        <p>${movie.sinopse}</p>
                    </div>
                </div>
            </c:if>

        </div>
    </body>
    
    <script>
        if ('serviceWorker' in navigator) {
            window.addEventListener('load', () => {
                navigator.serviceWorker.register('${pageContext.request.contextPath}/sw.js')
                    .then(registration => {
                        console.log('Service Worker registrado com sucesso:', registration.scope);
                    })
                    .catch(error => {
                        console.log('Falha ao registrar o Service Worker:', error);
                    });
            });
        }
    </script>

    </html>