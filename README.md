# PátioInteligenteMottu

O PátioInteligenteMottu é um sistema de gerenciamento de frotas desenvolvido em Java com Spring Boot. Seu objetivo principal é realizar a gestão eficiente de motos nos pátios, bem como monitorar sua localização em tempo real. A aplicação foi programada para controlar o fluxo de veículos entre diferentes filiais e garantir o monitoramento constante da ocupação e movimentação no pátio
## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- JPA/Hibernate
- Oracle Database
- Maven

## 📋 Pré-requisitos

- JDK 21
- Maven
- Oracle Database
- IntelliJ IDEA (recomendado)

## 🔧 Configuração do Ambiente

1. Clone o repositório:
```bash
git clone [url-do-repositorio]
```

2. Configure o banco de dados Oracle no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl
spring.datasource.username=[usuário] 
spring.datasource.password=[senha] 
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update

```

3. Importe o projeto no IntelliJ IDEA:
- File > Open > Selecione a pasta do projeto
- Aguarde o Maven baixar as dependências
- Configure o JDK 21 no projeto

## 🏗️ Estrutura do Projeto

### Camadas da Aplicação

1. **Controller**: Recebe as requisições HTTP
2. **Model**: Entidades do sistema
3. **DTO**: Objetos de transferência de dados
4. **Annotation**: Anotações personalizadas
5. **Service**: Lógica de negócio
6. **Repository**: Interface com o banco de dados

### Exemplo de Fluxo (Usando a classe Moto)

1. Controller (`MotoController.java`): Requisições REST
2. DTO (`MotoDto.java`): Valida e transporta dados
3. Service (`MotoService.java`): Processa regras de negócio
4. Repository (`MotoRepository.java`): Realiza operações no banco
5. Entity (`Moto.java`): Representa a tabela no banco
#Acesse os endpoints via:http://localhost:8080/filial


## 🚀 Como Executar

1. Abra o projeto no IntelliJ IDEA
2. Configure o banco de dados Oracle
3. Execute a classe principal `MottuApplication.java`
4. A aplicação estará disponível em `http://localhost:8080`

## 📦 Compilação

```bash
mvn clean install
```

## 🧪 Testes

```bash
mvn test
```
