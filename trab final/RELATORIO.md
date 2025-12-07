# Relatório do Miniprojeto - Sistema de Reservas de Restaurante

**Integrantes do Grupo:**
*   [Nome do Aluno 1] - RA: [000000]
*   [Nome do Aluno 2] - RA: [000000]
*   [Nome do Aluno 3] - RA: [000000]

---

## 1. Divisão de Tarefas
*   **Front-end (Vue.js/CSS):** Implementação das interfaces de cliente e funcionário, estilização com Glassmorphism e lógica de polling (AJAX) para atualização em tempo real.
*   **Back-end (Java Servlets):** Criação dos controladores (`MesaServlet`, `ReservaServlet`) para gerenciar as requisições HTTP e serialização JSON.
*   **Banco de Dados (DAO/SQL):** Modelagem do banco, implementação do padrão DAO (`MesaDAO`, `ReservaDAO`) e gerenciamento de conexões e transações.

## 2. Arquitetura MVC
O projeto segue estritamente o padrão Model-View-Controller:

*   **Model (Modelo):**
    *   Localizado em `com.restaurant.model` (`Mesa.java`, `Reserva.java`). Representa os dados da aplicação.
    *   A camada de acesso a dados (`com.restaurant.dao`) abstrai a comunicação com o banco de dados MySQL.
*   **View (Visão):**
    *   Localizado em `src/main/webapp` (`client.html`, `employee.html`).
    *   Desenvolvido com **Vue.js**, que renderiza a interface dinamicamente com base nos dados JSON recebidos.
    *   Não há geração de HTML no servidor (JSP); o servidor envia apenas dados (JSON), e o cliente (browser) constrói a visualização.
*   **Controller (Controlador):**
    *   Localizado em `com.restaurant.controller` (`MesaServlet.java`, `ReservaServlet.java`).
    *   Intercepta as requisições HTTP (GET/POST), invoca a lógica de negócios no DAO e retorna a resposta adequada em formato JSON.

## 3. Estrutura do Banco de Dados
O sistema utiliza duas tabelas principais:
1.  **`mesas`**: Armazena o estado atual das mesas.
    *   Colunas: `id` (PK), `numero` (Int), `status` (Varchar: 'LIVRE'/'RESERVADA').
2.  **`reservas`**: Registra o histórico de reservas.
    *   Colunas: `id` (PK), `mesa_id` (FK), `nome_cliente` (Varchar), `data_reserva` (Timestamp).

*O script completo de criação e população encontra-se no arquivo `database.sql` na raiz do projeto.*

## 4. Bibliotecas e Tecnologias Utilizadas
*   **Vue.js 3 (CDN):** Framework JavaScript para reatividade e construção das interfaces.
    *   Link: `https://unpkg.com/vue@3/dist/vue.global.js`
*   **Google Gson (Maven):** Biblioteca para conversão de Objetos Java em JSON.
*   **MySQL Connector/J (Maven):** Driver JDBC para conexão com o banco de dados.
*   **Google Fonts (CDN):** Fonte 'Inter' para tipografia moderna.
    *   Link: `https://fonts.googleapis.com`

## 5. Instruções de Execução
1.  Importe o projeto no VSCode.
2.  Certifique-se de ter um servidor MySQL rodando.
3.  Execute o script `database.sql` no seu banco de dados.
4.  Configure as credenciais do banco no arquivo `src/main/java/com/restaurant/util/DatabaseConnection.java`.
5.  Execute o projeto utilizando um servidor de aplicação (Tomcat/Jetty) via extensão do VSCode.
