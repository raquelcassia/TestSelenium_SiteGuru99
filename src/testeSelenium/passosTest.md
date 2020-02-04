#### -> Para grabalhar com logger <-

- Registar o log chamando a classe de teste no inicio (importar o apache)
- abrir o arquivo que esta em src
- alterar local de gravação para /resultadoTestDemoGuru
- para oular linha 		logger.info("\n");


# Metodo principal 
#### Etapa 1: Cadastro

- criar variavel email raquelteste@teste.com
- Insirir @test.
- declarar void

- inspecionar o nome id do campo para inserir o email
- Enviar email para o campo
- inspecionar o nome id do campo para enviar o email
- clicar no botão
- inserir tempo
- imprimir resultado 

- inserir registro do log (logger.info(...))
- inserir roteiro em logger.info no codigo (static Logger logger = Logger.getLogger(TestEmailLogin.class);)

#### Etapa 2: Pegando os dados 

- Selecionar id/senha e login > inpecionar > copiar xpath
- colar no gedit para pegar o caminho:
	ID:    /html/body/table/tbody/tr[4]/td[2]
	senha: /html/body/table/tbody/tr[5]/td[2]
	
- chamar o elemento id e apontar o caminho
- chamar o elemento senha e apontar o caminho
- registrar no log id e senha


#### Etapa 3: Logar no site

- chamar o site
- inserir tempo
- entrar no site http://demo.guru99.com/V1/index.php
- inspecionar campo user e campo senha
- chamar o campo apontando para o userid do login
- chamar o campo apontando para o senha do login

- *Teve que transformar o campo em texto primeiro pois nesse site não queria logar pegando diretamente o by.name do campo

- registrar log

#### Etapa 4: Realizar Logout.

- Inspecionar o botao Logout do site 
- colar no gedit para pegar o caminho:
	/html/body/div[3]/div/ul/li[10]/a
- apontar o caminho do botão (quando for objeto é direto, qnd for elemento tem q usar o web element)

- registrar o texto de logout 
- imprimir o texto


#### TESTE
- 	Verifica a resposta do teste (verde ou vermelho)

- retorna o resultado do tested V ou F
	





####
####
























