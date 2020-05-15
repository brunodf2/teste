

<h2 align="center">
  Teste Mirante Back-end
</h2>



## :gear:  Back-end

### :information_source: Instruções Back-end

Para clonar esse app voce precisa [Git](https://git-scm.com),  Para ele poder funcionar precisa de um banco [PostgreSQL](https://www.postgresql.org/) instalado e rodando na imagem via Docker  <details><summary>podendo utilizar o [Docker](https://www.docker.com/).</summary>
```bash

# instalar PostgreSQL
docker run --name database -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres:11

# inicializar PostgreSQL
docker start database
```
</details>







