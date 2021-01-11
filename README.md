 # Treinamento IBM
 ## Desafio
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/MarvelLogo.svg/1920px-MarvelLogo.svg.png" weight="500" height="100">



### Informações de pastas do projeto:

* Pasta DER: Pasta que contém diagrama de entidade relacionamento

* Pasta Postman: Pasta que contém o arquivo para importar os jsons no Postman.

* Pasta Desafio: Pasta que contém o ppt do desafio.

No projeto foi instalado também o Swagger que pode ser acessado através deste [link](http://localhost:8080/swagger-ui.html) após a execução da api no intellij.



### Instruções de Execução:

##### Ordem da população das tabelas

Devido algumas tabelas depender dos ids primários de outras tabelas para popular, é necessário popular as tabelas no Postman (ADD) na seguinte ordem que segue abaixo:

1. Popular tabela Criador
2. Popular tabela Filme/Revista
3. Popular tabela Herói
4. Popular tabela Poder
5. Popular tabela Ator

Após a população das tabelas, existe as requisições do CRUD dentro do Postman para buscar,deletar e atualizar:

	* Find All: Busca todo conteúdo da tabela.
	* Find By ID: Busca o conteúdo da tabela filtrado pelo ID.
	* Delete All: Deleta todo conteúdo da tabela.
	* Delete By ID: Deleta o conteúdo da tabela filtrado pelo ID.
	* Update: Atualiza o conteúdo filtrado pelo ID;


