ALTER TABLE pratos
ADD COLUMN cardapio_id BIGINT;


ALTER TABLE pratos
ADD CONSTRAINT fk_pratos_cardapio
FOREIGN KEY (cardapio_id) REFERENCES cardapio(id) ON DELETE CASCADE;