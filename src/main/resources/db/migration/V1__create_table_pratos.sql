CREATE TABLE pratos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    imagem_url VARCHAR(500) NOT NULL,
    tipo ENUM('BEBIDA', 'PF', 'SOBREMESA') NOT NULL
)