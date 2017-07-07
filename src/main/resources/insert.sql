--utilizadores default
Insert into User (id,username,password,name) values(1,'admin','admin','admin');

Insert into UserRoles (userId,role) values (1,'ADMIN');
--turma default

--linguagem de programaçao default
Insert into academytype values (1, 'Java');
Insert into academytype values (2, '.NET');
Insert into academytype values (3, 'Outsystems');
Insert into academytype values (4, 'C#');


Insert into Academy(id,name,programmingLanguage) values (1,'Java Starter 1','Java')
