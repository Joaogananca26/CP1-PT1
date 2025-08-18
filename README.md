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

![Image (4)](https://github.com/user-attachments/assets/88da50a6-0523-4357-90a2-4bd9a0a81a69)
![Image](https://github.com/user-attachments/assets/9c1b84a9-2a4e-4509-837d-a8d911a76453)
![Image (1)](https://github.com/user-attachments/assets/57e588a0-1a24-4d77-8148-46e8a632924a)
![Image (2)](https://github.com/user-attachments/assets/dba0d8bc-e284-4342-a685-61e8a34f5636)
![Image (3)](https://github.com/user-attachments/assets/24d6b9fb-ec6b-4459-bc14-e837b59f42ea)
<img width="1365" height="694" alt="Captura de tela 2025-08-18 202720" src="https://github.com/user-attachments/assets/9c90a399-6e17-46f5-9271-ba7b5858ca0e" />
<img width="1365" height="675" alt="Captura de tela 2025-08-18 202710" src="https://github.com/user-attachments/assets/1a27e1f5-83fe-4d6a-8f67-eaa652c8d88d" />
<img width="1365" height="672" alt="Captura de tela 2025-08-18 202642" src="https://github.com/user-attachments/assets/abe5a5ef-5aca-44fe-9421-9f1f9e5e97c0" />


##  Configuração do Projeto

Arquivo **application.properties**:

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
spring.datasource.username=rm556405
spring.datasource.password=Fiap#2025
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081

