create table treino (
  id bigint not null auto_increment,
  id_exercicios bigint not null,
  
  primary key (id),
  FOREIGN KEY (id_exercicios) REFERENCES exercicios(id)
) engine=InnoDB default charset=utf8;