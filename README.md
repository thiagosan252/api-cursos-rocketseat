# API Cursos

API fictícia para uma empresa de cursos de programação.

## Como utilizar?

1. Crie o banco de dados com o Docker Compose:

```bash
docker-compose up
```

2. Para testar as requisições, utilize uma ferramenta como Postman, Insomnia ou a ferramenta que melhor te agrade. No exemplo abaixo, utilizaremos o [httpie](https://httpie.io/).

Criação de um novo curso

```bash
http POST ":8080/cursos" name="Java" category="Programação"
```

Listagem de todos os cursos

```bash
http GET ":8080/cursos"
```

Atualização de um curso pelo id

```bash
http PUT ":8080/cursos/{id}" name="PostgreSQL" category="Banco de Dados"
```

Altera o status de ativo ou não do curso

```bash
http PATCH ":8080/cursos/{id}/active"
```

Remover um curso pelo id

```bash
http DELETE ":8080/cursos/{id}"
```
