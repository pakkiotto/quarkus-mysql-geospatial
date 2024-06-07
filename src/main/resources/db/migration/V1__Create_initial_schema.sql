-- V1__Create_initial_schema.sql
-- Crea la tabella con i campi specificati
CREATE TABLE expense (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    location POINT
    );

-- Inserisci alcune righe di dati di esempio
INSERT INTO expense (name, price, location) VALUES
('Coffee Shop', 2.50, ST_GeomFromText('POINT(12.4924 41.8902)')),  -- Roma
('Bakery', 5.00, ST_GeomFromText('POINT(-0.1276 51.5074)')),      -- Londra
('Bookstore', 15.75, ST_GeomFromText('POINT(2.3522 48.8566)')),   -- Parigi
('Restaurant', 45.30, ST_GeomFromText('POINT(13.4050 52.5200)')); -- Berlino