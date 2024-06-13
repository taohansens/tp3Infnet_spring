INSERT INTO tb_aluno (name, email) values ('Alex', 'alex@gmail.com' );
INSERT INTO tb_aluno (name, email) values ('Maria', 'maria@gmail.com');
INSERT INTO tb_aluno (name, email) values ('Carlos', 'carlos@gmail.com');
INSERT INTO tb_aluno (name, email) values ('Ana', 'ana@gmail.com');
INSERT INTO tb_aluno (name, email) values ('Lucas', 'lucas@gmail.com');
INSERT INTO tb_aluno (name, email) values ('Beatriz', 'beatriz@gmail.com');

INSERT INTO tb_curso (nome, descricao, carga_horaria) values ('Java', 'Java para iniciantes', 40);
INSERT INTO tb_curso (nome, descricao, carga_horaria) values ('Python', 'Python para iniciantes', 40);
INSERT INTO tb_curso (nome, descricao, carga_horaria) values ('JavaScript', 'JavaScript para iniciantes', 40);
INSERT INTO tb_curso (nome, descricao, carga_horaria) values ('HTML', 'HTML para iniciantes', 40);
INSERT INTO tb_curso (nome, descricao, carga_horaria) values ('CSS', 'CSS para iniciantes', 40);
INSERT INTO tb_curso (nome, descricao, carga_horaria) values ('React', 'React para iniciantes', 40);

INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (1, 1);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (1, 2);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (1, 3);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (2, 4);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (2, 5);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (2, 6);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (3, 1);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (3, 2);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (3, 3);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (4, 4);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (4, 5);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (4, 6);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (5, 1);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (5, 2);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (5, 3);
INSERT INTO tb_aluno_curso (aluno_id, curso_id) values (6, 4);