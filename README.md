# 📝 ToDo-Back
Back-end do projeto ToDo App, desenvolvido em Java com Spring Boot, responsável por gerenciar tarefas (To-Do List). Este projeto se comunica com o front-end Angular disponível no repositório [ToDo-Front](https://github.com/Nall99/ToDo-Front).

## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- Maven

## 🏗️ Estrutura do Projeto
``` bash
src/main/java/com/Nall99/ToDo_Back
│
├── controllers       # Controladores REST
│    └── TarefaController.java
│
├── dtos              # Objetos de Transferência de Dados
│    └── TarefaDTO.java
│
├── models            # Entidades JPA
│    └── Tarefa.java
│
├── repositories      # Interfaces JPA Repository
│    └── TarefaRepository.java
│
├── services          # Regras de negócio
│    ├── TarefaService.java
│    └── ToDoBackApplication.java
│
└── resources         # Configurações e recursos do projeto
```

## 🔧 Configuração do Banco de Dados
Este projeto utiliza PostgreSQL. Para rodá-lo localmente, adicione as seguintes propriedades no application.properties:
``` bash
spring.datasource.url= jdbc:postgresql://localhost:5432/seu_bancop
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=true
```

## ▶️ Como Executar Localmente
### Pré-requisitos
-Java 17 ou superior
- PostgreSQL em execução
- Maven 3.8+

### Passos:
``` bash
# Clone o repositório
git clone https://github.com/seu-usuario/ToDo-Back.git
cd ToDo-Back

# Execute o projeto
./mvnw spring-boot:run

```
A aplicação estará disponível em:
``` bash
http://localhost:8080
```

## 🛠️ Endpoints Principais
| Método | Endpoint      | Descrição                     |
| ------ | ------------- | ----------------------------- |
| GET    | /tarefas      | Lista todas as tarefas        |
| POST   | /tarefas      | Cria uma nova tarefa          |
| PUT    | /tarefas/{id} | Atualiza uma tarefa existente |
| DELETE | /tarefas/{id} | Remove uma tarefa             |

## ✅ Testes
Para rodar os testes:
``` bash
./mvnw test
```

## 📂 Dependências Principais
- Spring web
- Spring data JPA
- Validation
- Postgresql driver
- Lombok

## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 🔗 Front-end
O front-end Angular está disponível no repositório:
➡️ [ToDo-Front](https://github.com/Nall99/ToDo-Front)
