====================== Aplica��o Cliente =======================

1 - Primeiramente, execute o arquivo .jar pertencente ao cliente atrav�s de um terminal passando como par�metro o IP da m�quina servidor.

2 - Ao executar, uma tela de autentica��o ser� aberta e voc� poder� realizar o seu cadastro ou realizar o seu login.

	2.1 - Ao clicar para se cadastrar, uma mensagem deve surgir na tela informando-o que seu cadastro foi realizado com sucesso.
	2.2 - Ao clicar para realizar o signin no sistema, caso as informa��es de login e senha estejam corretas, voc� ser� redirecionado para a sua tela inicial do sistema. Caso contr�rio, uma mensagem informando que as informa��es de autentica��o est�o incorretas, surgir� no centro da tela.

** Para registrar um usu�rio na sua lista de amigos

Ao entrar no sistema pela primeira vez, voc� n�o ter� amigos na sua lista de contatos bem como mensagens. Para adicionar um contato j� registrado no sistema, voc� deve clicar no bot�o "Adicionar contato" e digitar o nickname do contato. Caso o nickname esteja correto e o usu�rio for identificado, ele ser� adicionado automaticamente na sua lista de amigos e voc� ver� um painel sendo exibido com algumas informa��es do contato e a��es que voc� pode executar em rela��o a este contato. Caso o nickname esteja incorreto e um usu�rio n�o seja retornado, voc� ser� notificado de que, de fato, o nickname digitado est� incorreto.

** Chats

	Iniciando um chat: Para iniciar um chat com algum contato, voc� deve ir at� a �rea que exibe os contatos, identificar o contato em quest�o e clicar no bot�o "Chat", feito isso, voc� poder� clicar no campo destinado a digitar uma mensagem, escrever algo e clicar no bot�o "Send".

	Recebendo um chat: Voc� s� receber� um chat de pessoas que voc� possui na sua lista de amigos. Ao receber uma mensagem do um usu�rio, voc� deve, PRIMEIRAMENTE, identificar o usu�rio na sua lista de contatos e CLICAR NO BOT�O "Chat" para s� ent�o responder a mesagem que foi recebida.

** Informa��es pessoas

	Se voc� quiser alterar sua informa��es pessoais, voc� deve clicar no bot�o "Configura��es" localizado no canto superior direito. Duas janelas ser�o abertas, a primeira solicitar� que voc� altere seu nome (caso n�o deseje alterar, apenas CLIQUE EM "OK"), a segunda janela solicitar� que voc� altere o seu status (caso n�o deseje alterar, apenas CLIQUE EM "OK")

** Portas utilizadas: 

	56000 - utilizada para realizar o signup e signin no sistema;
	56001 - porta destinada a receber dados do servidor para verificar que voc� est� online no sistema;
	56002 - porta destinada a ouvir mensagens de outros usu�rios;
	56003 - porta destinada a enviar mensagens para um contato;


====================== Aplica��o Servidor =======================

Antes de executar a aplica��o do servidor, voc� deve possuir o banco de dados Postgres instalados no seu computador e um banco de dados chamado "db-skype-clone" criado.

1 - Execute o arquivo .jar pertencente ao servidor atrav�s do terminal. Nenhum par�metro � necess�rio.

OBS: Ser� necess�rio ter a pasta lib que cont�m as bibliotecas para conex��o com o banco junto ao arquivo Server.jar

OBS 2: A senha do banco de dados deve ser CEAVI2018