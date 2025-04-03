# demo-dao-jdbc 🗃️
Projeto utilizando padrões DAO com JDBC.

***Feito apartir do curso DevSuperior.***

<h2>Seja bem vindo ao projeto utilizando padrão Data Access Object!</h2>

### O que é o DAO?
É um padrão de design de objeto de acesso á dados, é o padrão de projeto que permite separar as **regras de negócio** das **regras de acesso aos dados**.

### Vantagens ✔️ 

* **Transparência**: Implementar dados de forma solida e e transparente, os objetos de negócio podem utilizar a fonte de dados sem conhecer os detalhes especificos da implementação da base de dados, sendo assim muito mais fácil a troca da mesma e na manutenção da aplicação.
* **Injeção de dependência**: O dao permite a injeção de dependência no meu caso eu utilizei o padrão **Dao Factory** criando uma classe FactoryDao, responsável por criar dois métodos que dão acesso a minha Interface que é implementada por duas classes que utilizam a **JDBC** são responsáveis pela implementação dos métodos utilizando o ````java.sql```` para acesso ao banco de dados.
  
 ![Captura de tela 2025-04-02 180025](https://github.com/user-attachments/assets/7721cff3-21f5-4fb8-afbf-129334887142)
* **Reduz a complexidade do código nas entidades de negócio**: Pois as classes DAO já cuidam de toda complexidade do código de acesso ao banco de dados.
* **Classes DAO trocam informações com o SGBD**: Fornecem operações CRUD e de pesquisa, buscam no banco de dados por meio de comandos SQL, e transformam em Objetos ou em Lista de Objetos. Ou fazem uma consulta no banco de dados para converter em Objetos.

### 🔄O Projeto 
O projeto consiste na manipulação de acesso aos dados apartir de duas entidades de um negócio: ````department```` e ````seller```` com seus respectivos conteúdos. O objetivo é explorar os métodos e padrões de projeto utilizando Classes no modelo DAO para maior persistência e organização da aplicação.  

### ⚙️Tecnologias utilizadas 
* Banco de dados: MySQL
* JDBC: API para fazer acesso aos dados.
* Biblioteca MySQLConnector: Biblioteca personalizada para realizar a conexão com o banco de dados pela JDBC.
* Java 17
  
### 🔵Como rodar o projeto em sua máquina
1. **Clone meu repositório** ````https://github.com/SasaGomess/demo-dao-jdbc.git````
2. **Crie um novo schema no MySql**
3. **Crie as tabelas:** Execute os scripts SQL fornecidos no projeto para criar as tabelas necessárias no banco de dados. Os scripts estão localizados em um diretório chamado ````database.sql````.
4. **Importe o projeto em sua IDE de preferência Eclipse ou IntelliJ**   
5. **Configure as credenciais:** No arquivo db.properties, insira as credenciais do seu banco de dados MySQL (nome do usuário, senha, URL do banco de dados).
6. **Rode o projeto:** Program(Seller) e Program2(Departament) (dividdos pois cada um das aplicações irá manipular objetos e tabelas diferentes).
   


