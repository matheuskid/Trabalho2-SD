# Trabalho 2 - Sistemas Distribuídos

## Integrantes
- Ezequiel dos Santos Melo
- Matheus Mendes dos Santos

## Descrição do Serviço Remoto

Este projeto implementa um serviço remoto de gerenciamento de estudantes utilizando Java RMI (Remote Method Invocation). O sistema segue o modelo de requisição-resposta, permitindo que clientes remotos realizem operações sobre entidades acadêmicas de forma distribuída.

### Funcionalidades Remotas
- **Adicionar estudante a um programa**
- **Listar todos os estudantes cadastrados**
- **Buscar estudante por ID**
- **Calcular bolsa de iniciação científica ou pós-graduação**

O serviço é composto pelas seguintes entidades principais:
- `Student` (abstrata)
- `UndergraduateStudent` (graduação)
- `PostGraduateStudent` (pós-graduação)
- `ScientificInitiationStudent` (iniciação científica)
- `UndergraduateProgram` (programa de graduação)

O servidor expõe a interface remota `StudentService`, que pode ser acessada por múltiplos clientes simultaneamente via RMI.

## Requisitos
- Java 17+
- Maven 3.6+

## Como baixar e executar o projeto

1. **Clone o repositório:**

```sh
git clone <URL_DO_REPOSITORIO>
cd Trabalho2-SD
```

2. **Compile o projeto e gere o JAR com dependências:**

```sh
mvn clean package assembly:single
```

3. **Inicie o servidor:**

```sh
java -jar target/untitled-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Você verá:
```
RMI Registry iniciado na porta 1099.
StudentService registrado e pronto para receber requisições.
```

4. **Em outro terminal, execute o cliente:**

```sh
java -cp target/classes org.example.client.ClientMain
```

O cliente irá demonstrar as operações remotas, como adicionar estudantes, calcular bolsas e listar todos os estudantes cadastrados.

## Observações
- O servidor deve estar rodando antes de executar o cliente.
- Para personalizar operações, edite o arquivo `ClientMain.java`.
- O projeto não utiliza sockets diretamente, apenas RMI.

---

Desenvolvido para a disciplina de Sistemas Distribuídos.
