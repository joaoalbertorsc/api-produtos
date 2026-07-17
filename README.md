# API REST de Produtos com Java e Spring Boot ☕

## 📝 Sobre o Projeto

Este repositório contém uma **API REST de Produtos** desenvolvida em Java utilizando o ecossistema Spring. O projeto foi projetado para exemplificar o desenvolvimento de microserviços e APIs robustas, aplicando padrões de mercado para persistência em banco de dados, validação de dados e roteamento HTTP.

O objetivo principal é demonstrar como estruturar uma aplicação Spring Boot dividida em camadas bem definidas, expondo endpoints seguros para o gerenciamento de um inventário de produtos e garantindo a persistência de dados em banco relacional.

## 💡 Principais Conceitos Abordados

* **Arquitetura em Camadas (Controller, Service, Repository):** Divisão clara de responsabilidades, onde o Controller gerencia a camada HTTP, o Service encapsula as regras de negócio e o Repository abstrai a persistência de dados.
* **Spring Data JPA / Hibernate:** Mapeamento objeto-relacional (ORM) para simplificar a persistência de dados no banco de dados relacional, reduzindo a necessidade de consultas SQL manuais.
* **Validação de Dados (Bean Validation):** Uso de anotações como `@NotNull`, `@NotBlank`, `@Positive` e `@Size` para validar os payloads recebidos nos endpoints de criação e atualização de produtos.
* **Padrão DTO (Data Transfer Object):** Desacoplamento das entidades do banco de dados das respostas da API, garantindo segurança na exposição de atributos e facilitando a evolução do contrato da API.
* **Tratamento Centralizado de Exceções:** Uso de `@RestControllerAdvice` para capturar e tratar exceções de forma consistente em toda a aplicação.

## 🛠️ Tecnologias Utilizadas

* **Java 21** (versão recomendada)
* **Spring Boot 3.2.5** (Spring Web, Spring Data JPA, Validation)
* **Hibernate** (ORM para mapeamento objeto-relacional)
* **H2 Database** (banco de dados em memória para desenvolvimento e testes)
* **Maven** (gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

Você pode rodar a API REST tanto diretamente pelo terminal quanto utilizando a sua IDE de preferência.

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java JDK 21** configurado nas variáveis de ambiente (`JAVA_HOME`).
* **Apache Maven** instalado (ou utilize o Maven Wrapper `./mvnw` incluso na raiz do repositório).

### 💻 Opção 1: Executando pelo Terminal (Sem IDE)

Para compilar o projeto e subir o servidor local da API de forma rápida:

1. **Clone o repositório:**
```bash
git clone https://github.com/joaoalbertorsc/api-produtos.git
cd api-produtos
```

2. **Compile e baixe as dependências:**
Este comando baixa as dependências declaradas no `pom.xml` e compila os binários da aplicação:
```bash
mvn clean compile
```

3. **Execute a aplicação:**
Rode o Spring Boot diretamente pelo plugin do Maven:
```bash
mvn spring-boot:run
```

4. **Acesse a API:**
Por padrão, a aplicação estará disponível na porta `8080`. Você pode testar os endpoints através do seu navegador ou de ferramentas como Postman/Insomnia acessando:
```
http://localhost:8080/produtos
```

### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para visualizar melhor as classes controladoras e depurar as requisições HTTP:

1. **Importar o Projeto:**
   * Abra a sua IDE.
   * Selecione **Open** ou **Import Project**.
   * Escolha o arquivo `pom.xml` na raiz do diretório. A IDE fará o download e a indexação automática de todas as dependências do ecossistema Spring.

2. **Executar:**
   * Localize a classe principal que contém a anotação `@SpringBootApplication` (chamada `ProdutosApplication`).
   * Clique com o botão direito sobre ela e selecione **Run**.

3. **Explorar com Ferramentas Embutidas:**
   * Se você usa o **IntelliJ IDEA Ultimate**, pode utilizar o arquivo de requisições HTTP integrado (`.http`) para disparar requisições diretamente para sua API sem sair do ambiente de desenvolvimento.

### 📊 Acessar o Console H2

Para visualizar e gerenciar os dados no banco de dados H2:

```
http://localhost:8080/h2-console
```

**Credenciais padrão:**
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** (deixe em branco)

---

## 📚 Endpoints da API

### Listar todos os produtos
```http
GET /produtos
```

### Buscar produto por ID
```http
GET /produtos/{id}
```

### Criar novo produto
```http
POST /produtos
Content-Type: application/json

{
  "nome": "Notebook",
  "preco": 3500.00
}
```

### Atualizar produto (parcialmente)
```http
PATCH /produtos/{id}
Content-Type: application/json

{
  "nome": "Notebook Atualizado",
  "preco": 3200.00
}
```

### Deletar produto
```http
DELETE /produtos/{id}
```

---

## ⚠️ Nota Importante

Este projeto utiliza **H2 Database em memória** para fins educacionais e desenvolvimento rápido. Dados são persistidos durante a execução da aplicação, mas serão perdidos quando o servidor for reiniciado.

### Para Produção:
Para usar em produção com persistência real, substitua o H2 por:
- **MySQL:** Adicione `mysql-connector-java` ao `pom.xml` e configure em `application.properties`
- **PostgreSQL:** Adicione `postgresql` ao `pom.xml` e configure em `application.properties`
- **SQL Server ou outro BD:** Siga o mesmo padrão

---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

*Se este projeto te ajudou a entender como estruturar e rodar uma API RESTful utilizando o ecossistema Spring com persistência real em banco de dados, sinta-se à vontade para deixar uma ⭐ no repositório!*
