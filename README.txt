====================== Aplicação Cliente =======================

1 - Primeiramente, execute o arquivo .jar pertencente ao cliente através de um terminal passando como parâmetro o IP da máquina servidor.

2 - Ao executar, uma tela de autenticação será aberta e você poderá realizar o seu cadastro ou realizar o seu login.

	2.1 - Ao clicar para se cadastrar, uma mensagem deve surgir na tela informando-o que seu cadastro foi realizado com sucesso.
	2.2 - Ao clicar para realizar o signin no sistema, caso as informações de login e senha estejam corretas, você será redirecionado para a sua tela inicial do sistema. Caso contrário, uma mensagem informando que as informações de autenticação estão incorretas, surgirá no centro da tela.

** Para registrar um usuário na sua lista de amigos

Ao entrar no sistema pela primeira vez, você não terá amigos na sua lista de contatos bem como mensagens. Para adicionar um contato já registrado no sistema, você deve clicar no botão "Adicionar contato" e digitar o nickname do contato. Caso o nickname esteja correto e o usuário for identificado, ele será adicionado automaticamente na sua lista de amigos e você verá um painel sendo exibido com algumas informações do contato e ações que você pode executar em relação a este contato. Caso o nickname esteja incorreto e um usuário não seja retornado, você será notificado de que, de fato, o nickname digitado está incorreto.

** Chats

	Iniciando um chat: Para iniciar um chat com algum contato, você deve ir até a área que exibe os contatos, identificar o contato em questão e clicar no botão "Chat", feito isso, você poderá clicar no campo destinado a digitar uma mensagem, escrever algo e clicar no botão "Send".

	Recebendo um chat: Você só receberá um chat de pessoas que você possui na sua lista de amigos. Ao receber uma mensagem do um usuário, você deve, PRIMEIRAMENTE, identificar o usuário na sua lista de contatos e CLICAR NO BOTÃO "Chat" para só então responder a mesagem que foi recebida.

** Informações pessoas

	Se você quiser alterar sua informações pessoais, você deve clicar no botão "Configurações" localizado no canto superior direito. Duas janelas serão abertas, a primeira solicitará que você altere seu nome (caso não deseje alterar, apenas CLIQUE EM "OK"), a segunda janela solicitará que você altere o seu status (caso não deseje alterar, apenas CLIQUE EM "OK")

** Portas utilizadas: 

	56000 - utilizada para realizar o signup e signin no sistema;
	56001 - porta destinada a receber dados do servidor para verificar que você está online no sistema;
	56002 - porta destinada a ouvir mensagens de outros usuários;
	56003 - porta destinada a enviar mensagens para um contato;


====================== Aplicação Servidor =======================

Antes de executar a aplicação do servidor, você deve possuir o banco de dados Postgres instalados no seu computador e um banco de dados chamado "db-skype-clone" criado.

1 - Execute o arquivo .jar pertencente ao servidor através do terminal. Nenhum parâmetro é necessário.

OBS: Será necessário ter a pasta lib que contém as bibliotecas para conexção com o banco junto ao arquivo Server.jar

OBS 2: A senha do banco de dados deve ser CEAVI2018