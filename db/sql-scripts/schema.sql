DROP TABLE IF EXISTS `endereco`;

CREATE TABLE `endereco` (
                            `id` int NOT NULL,
                            `logradouro` varchar(45) NOT NULL,
                            `numero` int NOT NULL,
                            `complemento` varchar(45) DEFAULT NULL,
                            `estado` varchar(45) NOT NULL,
                            `cep` varchar(45) NOT NULL,
                            `cidade` varchar(45) NOT NULL,
                            `bairro` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`)
)


    LOCK TABLES `endereco` WRITE;

INSERT INTO `endereco` VALUES (1,'Rua Doutor Alcides Cruz',346,'Apto 206','RS','90630160','Porto Alegre','Santa Cecilia');

UNLOCK TABLES;



DROP TABLE IF EXISTS `estoque`;
CREATE TABLE `estoque` (
                           `id` int NOT NULL,
                           `estoque_minimo` int NOT NULL,
                           `id_produto` int NOT NULL,
                           PRIMARY KEY (`id`)
)



    LOCK TABLES `estoque` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `produtos`;

CREATE TABLE `produtos` (
                            `codigo` int NOT NULL,
                            `descricao` varchar(255) NOT NULL,
                            `preco` double NOT NULL,
                            `quantidade` double NOT NULL,
                            `situacao` varchar(255) NOT NULL,
                            `url_imagem` varchar(255) NOT NULL,
                            PRIMARY KEY (`codigo`)
)


    LOCK TABLES `produtos` WRITE;

INSERT INTO `produtos` VALUES (1,'Fogao',20,12,'A','https://images-americanas.b2w.io/produtos/4720519290/imagens/fogao-monaco-4-bocas-automatico-mesa-de-inox-atlas/4720519311_1_xlarge.jpg'),(2,'Geladeira',60,4,'A','https://imgs.ponto.com.br/12731690/1xg.jpg');

UNLOCK TABLES;


DROP TABLE IF EXISTS `venda`;

CREATE TABLE `venda` (
                         `id` int NOT NULL,
                         `frete` double NOT NULL,
                         `imposto` double NOT NULL,
                         `desconto` double NOT NULL,
                         `endereco` varchar(500) NOT NULL,
                         `items_carrinho` varchar(255) NOT NULL,
                         `valor` double NOT NULL,
                         PRIMARY KEY (`id`)
)


    LOCK TABLES `venda` WRITE;

INSERT INTO `venda` VALUES (0,25,30,0,'1','',40),(1,25,10,2,'1','{id:1, quantidade:2, id:2, quantidade:1}',93),(2,25,30,0,'1','{',40),(3,25,30,0,'1','{',80),(4,25,30,0,'1','{',80),(5,25,30,0,'1','{',80);

UNLOCK TABLES;