# 🍿 Movie Recommender

Um aplicativo web simples e elegante para recomendação de filmes, construído com Java (Servlet), Maven e Tomcat.

Este projeto oferece uma interface limpa e responsiva que busca um filme aleatório de uma lista local (um arquivo JSON) e exibe seus detalhes. É uma demonstração prática de como construir uma aplicação web dinâmica com um backend Java sem depender de APIs externas ou bancos de dados complexos.

## ✨ Características Principais

  * **Recomendação Aleatória de Filmes:** A cada clique, um novo filme é sugerido a partir de um catálogo pré-definido, garantindo uma nova descoberta a cada visita.
  * **Zero Dependências Externas:** Não é necessário criar contas ou configurar chaves de API. O projeto é totalmente autônomo e funciona offline (após a primeira carga das imagens dos pôsteres).
  * **Backend Simples com Java Servlets:** Demonstra o uso de Servlets para processar requisições, ler arquivos locais e encaminhar dados para a camada de visualização.
  * **Renderização Dinâmica com JSP:** Utiliza JavaServer Pages (JSP) e JSTL para exibir dinamicamente as informações do filme recomendado no front-end.
  * **Interface Responsiva e Moderna:** O design se adapta perfeitamente a desktops, tablets e dispositivos móveis, proporcionando uma ótima experiência de usuário em qualquer tela.

## 🛠️ Tecnologias Utilizadas

  * **Backend:** Java Servlets, Apache Tomcat
  * **Build:** Apache Maven
  * **Frontend:** JavaServer Pages (JSP), JSTL, HTML5, CSS3
  * **Bibliotecas:**
      * **Gson:** Para fazer o parsing do arquivo `movies.json` de forma eficiente no backend.

-----

## 🚀 Como Fazer Funcionar

Siga os passos abaixo para compilar e executar o projeto em sua máquina local.

### Pré-requisitos

Antes de começar, garanta que você tenha os seguintes softwares instalados:

1.  **JDK 11** ou superior (Java Development Kit)
2.  **Apache Maven**

### 1\. Clone o Repositório

```bash
git clone https://github.com/seu-usuario/movie-recommender.git
cd movie-recommender
```

### 2\. Compile o Projeto

Use o Maven para compilar o projeto e empacotá-lo em um arquivo `.war`. Este comando também baixará as dependências necessárias (como a biblioteca Gson).

```bash
mvn clean package
```

Isso irá gerar o arquivo `movie-recommender.war` dentro da pasta `target/`.

### 3\. Execute a Aplicação

Você tem duas opções principais:

#### Opção A (Recomendado para Desenvolvimento): Usar o Plugin Maven do Tomcat

Se o seu `pom.xml` tiver o plugin do Tomcat, este é o método mais rápido:

```bash
mvn tomcat7:run
```

#### Opção B: Deploy Manual em um Servidor Tomcat Externo

1.  Copie o arquivo `target/movie-recommender.war` para a pasta `webapps/` da sua instalação do Tomcat.
2.  Inicie o servidor Tomcat (`startup.sh` no Linux/macOS ou `startup.bat` no Windows).

### 4\. Acesse a Aplicação

Abra seu navegador e acesse a URL:

**[http://localhost:8080/movie-recommender/](https://www.google.com/search?q=http://localhost:8080/movie-recommender/)**

Agora é só clicar no botão "Encontrar um Filme\!" para receber sua primeira sugestão\!

-----

## 🗺️ Melhorias Futuras

Este projeto é uma ótima base para expansão. Algumas ideias para os próximos passos:

  - [ ] **Filtrar por Gênero:** Adicionar um menu dropdown para que o usuário possa pedir recomendações de um gênero específico (Ação, Comédia, Drama, etc.).
  - [ ] **Conectar a uma API Externa:** Substituir o `movies.json` local por chamadas a uma API de filmes real, como a do [The Movie Database (TMDb)](https://www.themoviedb.org/documentation/api), para ter acesso a um catálogo infinito.
  - [ ] **Adicionar um Campo de Busca:** Permitir que o usuário busque por um filme específico.
  - [ ] **Sistema de "Gostei" / "Não Gostei":** Usar `localStorage` ou `sessionStorage` para evitar que o mesmo filme seja recomendado novamente em uma mesma sessão.
  - [ ] **Melhorar a Interface:** Adicionar mais animações ou transições para uma experiência de usuário ainda mais fluida.