CREATE TABLE [user] (
    id BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(150) NOT NULL,
    birth_date DATE NOT NULL,
    gender VARCHAR(30) NOT NULL,
    active BIT NOT NULL
);

INSERT INTO [user] (name, email, password, birth_date, gender, active)
VALUES ('Fernando Duarte', 'fernandoduarte@ifsp.edu.br',
        '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji',
        '1975-11-16', 'MASCULINO', 1);

INSERT INTO [user] (name, email, password, birth_date, gender, active)
VALUES ('Juliana Silva', 'julianasilva@ifsp.edu.br',
        '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji',
        '1980-01-01', 'FEMININO', 1);
