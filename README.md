# projeto_af

Uma aplicação do tipo API Web RestFul que permita gerenciar reservas de veículos. A aplicação deverá permitir:

    ~Gerenciar Veículos-CRUD:

  1. Código
  
  2. Modelo

  3. Valor diária
 
	~Gerenciar Clientes e listar as reservas de um Cliente-CRUD:

  1. Código

  2. Nome

  3. Endereço

  4. CPF
 

    ~Fazer uma reserva de um veículo por um cliente. A reserva deverá ter:

  1. Tem um número
  
  2. Cliente deverá existir.
  
  3. Veículo deverá existir.
  
  4. Data de Início (Deverá ser maior que a data do sistema). Não pode começar no Domingo.
  
  5. Data de Fim (Deverá ser maior que a data de Início). Não existe entrega no Domingo.
  
  6. O total da reserva deverá ser calculado.
  
  7. Um veículo pode ser reservado várias vezes, porém somente em períodos/datas diferentes.
 
    ~Listar uma reserva pelo número.

    ~Listar as reservas de um cliente.

    ~Listar as reservas de um veículo
 
    ~Itens Obrigatórios:

-Projeto deverá estar em um repositório GIT e enviar o link.

-Validar todos os dados de cadastro e alteração. Usar @Valid e Constrains

-Usar o padrão DTO em pelo menos um recurso.

-Publicar a aplicação no Heroku (heroku.com (Links para um site externo.)) e enviar o link.

https://youtu.be/L9mEmVaTjZw
