## Link do deploy: https://cp1-pt1.onrender.com

## Participantes: 
### Brendon de Paula Brasil - RM559196
### João Ganança - RM556405
### Vinicius Leandro - RM554728
### David Rapackman - RM556607


#  Sistema de Gestão de Ferramentas - Spring Boot

Este projeto foi desenvolvido como exercício de revisão da disciplina de **Desenvolvimento Java com Spring**.  
O objetivo é criar uma aplicação para gerenciar ferramentas e acessórios, com **persistência em banco Oracle**, uso de **Lombok**, **HATEOAS** e **CRUD completo**, além de realizar o **deploy** e documentar os testes via Postman/Insomnia.

---

## Tecnologias Utilizadas

- **Java 17**  
- **Spring Boot** (Maven Project)
- **Spring Data JPA**
- **Lombok**
- **HATEOAS**
- **Banco de Dados Oracle** (SQL Developer)
- **Postman / Insomnia** (para testes)
- **IDE:** IntelliJ IDEA (pode ajustar conforme o grupo)
- **Deploy:** (adicione o link da plataforma usada)

---

## Requisitos Atendidos

- CRUD completo (`Create`, `Read`, `Update`, `Delete`)
- Conexão com **Oracle SQL Developer**
- Retorno dos dados no padrão **HATEOAS** (Nível de Maturidade 3)
- Configuração via `application.properties`
- Testes realizados no **Postman**
- Deploy da aplicação em nuvem

---

## Estrutura da Tabela no Banco

Tabela: **TDS_TB_Ferramentas**

| Coluna        | Tipo         | Descrição                       |
|---------------|-------------|---------------------------------|
| **id**        | NUMBER (PK) | Identificador único              |
| **nome**      | VARCHAR2    | Nome da ferramenta               |
| **tipo**      | VARCHAR2    | Tipo da ferramenta               |
| **classificacao** | VARCHAR2 | Classificação de uso             |
| **tamanho**   | VARCHAR2    | Tamanho (cm, mm, etc.)           |
| **preco**     | NUMBER      | Preço em reais                   |

---

##  Configuração do Projeto

Arquivo **application.properties**:

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081
