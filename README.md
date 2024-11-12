# API Plataforma de Cursos

Este repositório contém o código para uma plataforma de cursos online, desenvolvida usando Spring Boot e Hibernate para facilitar o gerenciamento de alunos, cursos e inscrições.

# Estrutura do Projeto

- Controllers: Definem os endpoints REST da API.
- Services: Contêm a lógica de negócios e são responsáveis por manipular os dados antes de passá-los aos controladores.
- Repositories: Interagem com o banco de dados H2 usando Hibernate.
- DTOs e Populators: Utilizados para converter entidades para objetos de transferência de dados, evitando a exposição direta das entidades.

# Funcionalidades

- Gerenciamento de Alunos: Criação, listagem e recuperação de alunos.
- Gerenciamento de Cursos: Criação, listagem e recuperação de cursos.
- Inscrições: Inscrição de alunos em cursos e listagem dos cursos em que um aluno está inscrito e vice-versa.
- Banco de Dados: Uso de banco de dados H2 em memória para testes e desenvolvimento rápido.

# Requisitos

1.  Java 11 ou superior
2.  Maven
3.  Postman (para testes da API)

# Instalação e Execução

1.  Clone o repositório:

```bash
git clone https://github.com/seu-usuario/plataforma-cursos.git
cd plataforma-cursos
```

2.  Compile e execute a aplicação:

```bash
mvn spring-boot:run
Acesse a API em http://localhost:8080.
```

# Estrutura de Pastas

- src/main/java/com/example/plataformacursos/plataformcursos
  - controller/: Contém os controladores REST da API.
  - service/: Contém a lógica de negócios do sistema.
  - repository/: Contém as interfaces para acesso ao banco de dados.
  - dto/: Contém os Data Transfer Objects (DTOs) usados para a API.
  - populator/: Contém os populators para conversão de entidades para DTOs.

# Endpoints Principais

### Aluno

- POST /alunos - Cadastra um novo aluno
- GET /alunos/{id}/cursos - Lista todos os cursos em que um aluno está inscrito
- GET /alunos - Lista todos os alunos

### Curso

- POST /cursos - Cadastra um novo curso
- GET /cursos/{id}/alunos - Lista todos os alunos inscritos em um curso
- GET /cursos - Lista todos os cursos

### Inscrição

- POST /inscricoes - Inscreve um aluno em um curso

# Exemplo de Requisições

### Cadastro de Aluno

```json
POST /alunos
{
"nome": "João da Silva",
"email": "joao.silva@example.com",
"dataCadastro": "2024-11-12"
}
```

### Cadastro de Curso

```json
POST /cursos
{
"nome": "Introdução ao Spring Boot",
"descricao": "Curso básico de Spring Boot",
"dataCriacao": "2024-11-12"
}
```

### Inscrição de Aluno em Curso

```json
POST /inscricoes
{
"alunoId": 1,
"cursoId": 1,
"dataInscricao": "2024-11-12"
}
```

# Testes da API

Para testar a API, você pode utilizar o Postman para enviar requisições aos endpoints. Verifique o código HTTP retornado para cada requisição:

- 200 OK: Operação bem-sucedida.
- 404 Not Found: Aluno ou Curso não encontrado.
- 500 Internal Server Error: Erro no servidor (exemplo: dados incorretos ou falta de implementação de algum método).

# Contribuição

Sinta-se à vontade para abrir issues e pull requests para melhorias. Toda contribuição é bem-vinda!
