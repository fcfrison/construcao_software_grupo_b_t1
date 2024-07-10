# Gerência da Configuração do Account - Loja Virtual
Este repositório contém um microsserviço para a gerência da configuração do account de uma loja virtual. O foco deste documento é descrever o fluxo DevOps utilizado para construir, rodar e fazer deploy da aplicação.

## Fluxo DevOps
### Arquitetura
A arquitetura do microsserviço é construída utilizando o Terraform, uma ferramenta de infraestrutura como código (IaC) que permite definir e provisionar a infraestrutura através de arquivos de configuração.

### Containerização
A aplicação é containerizada utilizando Docker. Isso garante que o ambiente de execução da aplicação seja consistente e facilita a portabilidade.

### DockerHub
As imagens Docker da aplicação são armazenadas e versionadas no DockerHub, um repositório de containers que permite o fácil compartilhamento e acesso às imagens.

### Integração e Deploy Contínuos
Para realizar o deploy contínuo da aplicação, utilizamos o Github Actions juntamente com o AWS CodeDeploy. O fluxo de deploy é descrito a seguir:
    1. Github Actions: Automatiza o processo de build e deploy da aplicação. Cada push ou pull request no repositório dispara um workflow que constrói a imagem Docker, publica no DockerHub e inicia o processo de deploy.

    2. AWS CodeDeploy: Gerencia o processo de deploy na nuvem AWS, garantindo que a aplicação seja distribuída e atualizada de forma eficiente e confiável.
### Nuvem AWS
O microsserviço é executado na AWS (Amazon Web Services), aproveitando a escalabilidade e confiabilidade da plataforma

## Configuração de Variáveis de Ambiente
Para que o fluxo de trabalho funcione corretamente, algumas variáveis de ambiente devem ser configuradas no serviço de secrets do Github:

### Variáveis da AWS
    - AWS_ACCESS_KEY_ID: Chave de acesso para a AWS.
    - AWS_SECRET_ACCESS_KEY: Chave secreta de acesso para a AWS.
    - SESSION_TOKEN: Token de sessão para autenticação na AWS.

### Variáveis do DockerHub
    - DOCKERHUB_USERNAME: Nome de usuário do DockerHub.
    - DOCKERHUB_TOKEN: Token de acesso para o DockerHub.
Estas variáveis são essenciais para que os processos de build, push e deploy possam ser executados corretamente e de forma segura.

