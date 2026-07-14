# API REST de Produtos com Java e Spring Boot ☕

## 📝 Sobre o Projeto

Este repositório contém uma **API REST de Produtos** desenvolvida em Java utilizando o ecossistema Spring. O projeto foi projetado para exemplificar o desenvolvimento de microserviços e APIs robustas, aplicando padrões de mercado para persistência, validação de dados e roteamento HTTP.

O objetivo principal é demonstrar como estruturar uma aplicação Spring Boot dividida em camadas bem definidas, expondo endpoints seguros para o gerenciamento de um inventário de produtos e garantindo que as regras de negócio sejam validadas antes de atingir o banco de dados.

## 💡 Principais Conceitos Abordados

* **Arquitetura em Camadas (Controller, Service, Repository):** Divisão clara de responsabilidades, onde o Controller gerencia a camada HTTP, o Service encapsula as regras de negócio e o Repository lida com a persistência de dados.
* **Spring Data JPA / Hibernate:** Mapeamento objeto-relacional (ORM) para simplificar a persistência de dados no banco de dados relacional, reduzindo a necessidade de consultas SQL manuais.
* **Validação de Dados (Bean Validation):** Uso de anotações como `@NotNull`, `@NotBlank` e `@Min` para validar os payloads recebidos nos endpoints de criação e atualização de produtos.
* **Padrão DTO (Data Transfer Object):** Desacoplamento das entidades do banco de dados das respostas da API, garantindo segurança na exposição de atributos e facilitando a evolução do contrato da API.

## 🛠️ Tecnologias Utilizadas

* Java (versão 17 ou superior recomendada)
* Spring Boot (Spring Web, Spring Data JPA, Validation)
* Banco de Dados (H2 Database para desenvolvimento/testes ou MySQL/PostgreSQL)
* Maven (gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

Você pode rodar a API REST tanto diretamente pelo terminal quanto utilizando a sua IDE de preferência.

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java JDK** (versão 17 ou superior) configurado nas variáveis de ambiente (`JAVA_HOME`).
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
`http://localhost:8080/produtos`

### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para visualizar melhor as classes controladoras e depurar as requisições HTTP:

1. **Importar o Projeto:**
* Abra a sua IDE.
* Selecione **Open** ou **Import Project**.
* Escolha o arquivo `pom.xml` na raiz do diretório. A IDE fará o download e a indexação automática de todas as dependências do ecossistema Spring.


2. **Executar:**
* Localize a classe principal que contém a anotação `@SpringBootApplication` (geralmente chamada de `ApiProdutosApplication` ou similar).
* Clique com o botão direito sobre ela e selecione **Run**.


3. **Explorar com Ferramentas Embutidas:**
* Se você usa o IntelliJ IDEA Ultimate, pode utilizar o arquivo de requisições HTTP integrado (`.http`) para disparar requisições diretamente para a sua API sem sair do ambiente de desenvolvimento.



---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

*Se este projeto te ajudou a entender como estruturar e rodar uma API RESTful utilizando o ecossistema Spring, sinta-se à vontade para deixar uma ⭐ no repositório!*
