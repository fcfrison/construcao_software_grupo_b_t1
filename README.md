# Como rodar o programa em um container docker
Rode os seguintes comandos:
1. `mvn install`
2. `docker build -t constStwApp:latest .`
3. `docker run --rm -p 8080:8080 constr_soft_app`
