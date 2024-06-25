## Como rodar o programa em um container docker
Rode os seguintes comandos:
1. `docker build -t const_softw:latest .`
2. `docker run -d --restart always --name const_soft_app -p 8080:8080 const_softw`

## Para subir a infra na AWS a partir do Teraform
- criar no diretório 'home' o arquivo '/home/.aws/credentials' e inserir as credenciais de acesso.
OBS.: se estiver rodando no Codespaces, então o diretório '.aws' deverá ser inserido no '/home/codespaces'.

## Exemplo de Url após o serviço ter subido na AWS
http://[ip_publico]:8080/api/v1/account/preferences?id=1