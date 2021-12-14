CREATE TABLE `usuario` (
  `login` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `rg` int(11) NOT NULL,
  `telefone` int(11) DEFAULT NULL,
  `data_nasc` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` int(11) NOT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `administrador` (
  `cod_adm` int(11) DEFAULT NULL,
  `usuario_login` varchar(10) NOT NULL,
  PRIMARY KEY (`usuario_login`),
  CONSTRAINT `fk_administrador_usuario1` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `aluno` (
  `matricula` varchar(14) DEFAULT NULL,
  `nome_mae` varchar(100) DEFAULT NULL,
  `nome_pai` varchar(100) DEFAULT NULL,
  `data_matricula` date NOT NULL,
  `tel_responsavel` int(11) DEFAULT NULL,
  `usuario_login` varchar(10) NOT NULL,
  PRIMARY KEY (`usuario_login`),
  CONSTRAINT `fk_aluno_usuario1` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `professor` (
  `cod_professor` int(11) DEFAULT NULL,
  `usuario_login` varchar(10) NOT NULL,
  PRIMARY KEY (`usuario_login`),
  CONSTRAINT `fk_professor_usuario1` FOREIGN KEY (`usuario_login`) REFERENCES `usuario` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sala` (
  `cod_sala` int(11) NOT NULL,
  `turma` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_sala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

