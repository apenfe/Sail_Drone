-- Creación de la base de datos
create DATABASE redes_neuronales;
USE redes_neuronales;

-- Tabla network (redes neuronales)
CREATE TABLE red (
    nombre VARCHAR(255) PRIMARY KEY,
    numCapas INT NOT NULL,
    descripcion TEXT
);

-- Tabla layer (capas)
CREATE TABLE capa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    red_nombre VARCHAR(255),
    ordenCapa INT NOT NULL,
    numNeuronas INT,
    numNeuronasCapaAnterior INT,
    funcion INT,
    FOREIGN KEY (red_nombre) REFERENCES red(nombre)
);

-- Crear la tabla entornos
CREATE TABLE entorno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    alto DOUBLE,
    ancho DOUBLE,
    entradaX DOUBLE,
    entradaY DOUBLE,
    salidaX DOUBLE,
    salidaY DOUBLE,
    paso DOUBLE,
    areaAprox DOUBLE
);




-- Crear la tabla data_set
CREATE TABLE adn (
    nombre VARCHAR(255) PRIMARY KEY,
    nombre_red VARCHAR(255) NOT NULL,
    description TEXT,
    CONSTRAINT FK_adn FOREIGN KEY (nombre_red) REFERENCES red (nombre)
);

-- Crear la tabla numbers
CREATE TABLE gen (
    posicion INT,
    nombre_adn varchar(255) NOT NULL,
    valor DOUBLE,
    FOREIGN KEY (nombre_adn) REFERENCES adn(nombre)
);