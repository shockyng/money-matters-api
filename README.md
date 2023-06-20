## Run postgres in docker
```bash
docker run --name money-matters -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=money_matters -p 5433:5432 -d postgres
```