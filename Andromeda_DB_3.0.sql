-- -----------------------------------------------------
-- Schema andromeda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS andromeda; -- DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE andromeda;

-- -----------------------------------------------------
-- Table 'andromeda'.'direccion'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.direcciones (
  id_direccion INT NOT NULL AUTO_INCREMENT,
  estado VARCHAR(255) NOT NULL,
  ciudad VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  codigo_postal MEDIUMINT NOT NULL,
  numero_interior VARCHAR(45) NOT NULL,
  numero_exterior VARCHAR(45) NOT NULL,
  informacion_adicional VARCHAR(255) NOT NULL,
  nombre_destinatario VARCHAR(255) NOT NULL,
  apellido_destinatario VARCHAR(255) NOT NULL,
  email_destinatario VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_direccion),
  UNIQUE INDEX id_direccion_UNIQUE (id_direccion ASC) VISIBLE);

-- -----------------------------------------------------
-- Table 'andromeda'.'formas_de_pago'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.formas_de_pago (
  id_forma_de_pago INT NOT NULL AUTO_INCREMENT,
  tipo_tarjeta VARCHAR(255) NOT NULL,
  numero_tarjeta BIGINT NOT NULL,
  fecha_vencimiento INT NOT NULL,
  cvv SMALLINT NOT NULL,
  PRIMARY KEY (id_forma_de_pago),
  UNIQUE INDEX id_forma_de_pago_UNIQUE (id_forma_de_pago ASC) VISIBLE);

-- -----------------------------------------------------
-- Table 'andromeda'.'producto'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.productos (
  id_producto INT NOT NULL AUTO_INCREMENT,
  nombre_producto VARCHAR(255) NOT NULL,
  precio_producto INT NOT NULL,
  cantidad_producto INT NOT NULL,
  descripcion_producto VARCHAR(255) NOT NULL,
  ruta_imagen_1 VARCHAR(255) NOT NULL,
  ruta_imagen_2 VARCHAR(255) NOT NULL,
  ruta_imagen_3 VARCHAR(255) NOT NULL,
  categoria VARCHAR(255) NOT NULL,
  descuento INT NOT NULL,
  codigo_de_barras INT NOT NULL,
  PRIMARY KEY (id_producto),
  UNIQUE INDEX id_producto_UNIQUE (id_producto ASC) VISIBLE);

-- -----------------------------------------------------
-- Table 'andromeda'.'metodos_de_envio'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.metodos_de_envio (
  id_envio INT NOT NULL AUTO_INCREMENT,
  tipo_de_envio VARCHAR(255) NOT NULL,
  precio_de_envio INT NOT NULL,
  PRIMARY KEY (id_envio),
  UNIQUE INDEX id_envio_UNIQUE (id_envio ASC) VISIBLE);
  
-- -----------------------------------------------------
-- Table 'andromeda'.'usuario'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.usuarios (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre_cliente VARCHAR(255) NOT NULL,
  apellido_cliente VARCHAR(255) NOT NULL,
  correo VARCHAR(255) NOT NULL,
  contrasenia VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE INDEX id_usuario_UNIQUE (id_usuario ASC) VISIBLE,
  UNIQUE INDEX correo_UNIQUE (correo ASC) VISIBLE);

-- -----------------------------------------------------
-- Table 'andromeda'.'ticket'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.tickets (
  id_ticket INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_direccion INT NOT NULL,
  id_envio INT NOT NULL,
  id_forma_de_pago INT NOT NULL,
  estatus_del_pedido VARCHAR(255) NOT NULL,
  fecha DATETIME DEFAULT LOCALTIMESTAMP NOT NULL,
  -- fecha DATE NOT NULL,
  PRIMARY KEY (id_ticket),
  INDEX fk_ticket_usuario_idx (id_usuario ASC) ,
  INDEX fk_ticket_direccion_idx (id_direccion ASC) VISIBLE,
  INDEX fk_ticket_metodo_envio_idx (id_envio ASC) VISIBLE,
  INDEX fk_ticket_forma_de_pago_idx (id_forma_de_pago ASC) VISIBLE,
  CONSTRAINT fk_ticket_direccion
    FOREIGN KEY (id_direccion)
    REFERENCES andromeda.direcciones (id_direccion),
  CONSTRAINT fk_ticket_forma_de_pago
    FOREIGN KEY (id_forma_de_pago)
    REFERENCES andromeda.formas_de_pago (id_forma_de_pago),
  CONSTRAINT fk_ticket_metodo_envio
    FOREIGN KEY (id_envio)
    REFERENCES andromeda.metodos_de_envio (id_envio),
  CONSTRAINT fk_ticket_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES andromeda.usuarios (id_usuario));

-- -----------------------------------------------------
-- Table 'andromeda'.'listas'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS andromeda.tickets_productos (
  id_producto INT NOT NULL,
  id_ticket INT NOT NULL,
  INDEX fk_lista_producto_idx (id_producto ASC) VISIBLE,
  INDEX fk_lista_ticket_idx (id_ticket ASC) VISIBLE,
  CONSTRAINT fk_lista_producto
    FOREIGN KEY (id_producto)
    REFERENCES andromeda.productos (id_producto),
  CONSTRAINT fk_lista_ticket
    FOREIGN KEY (id_ticket)
    REFERENCES andromeda.tickets (id_ticket));
        
INSERT INTO usuarios(nombre_cliente, apellido_cliente, correo, contrasenia) VALUES
("Daniel", "Nava", "daniel@hotmail.com", "contraseniadaniel"),
("Jose Manuel", "Carvajal", "jose@hotmail.com", "contraseniajose"),
("Eduardo", "Diaz", "eduardo@hotmail.com", "contraseniaeduardo"),
("Ruben", "Perez", "ruben@hotmail.com", "contraseniaruben"),
("Fernando", "Hernandez", "fernando@hotmail.com", "contraseniafernando"),
("Felix	", "Garcia", "felix@hotmail.com", "contraseniafelix"),
("Omar", "Martinez", "omar@hotmail.com", "contraseniaomar"),
("Raul", "Lopez", "raul@hotmail.com", "contraseniaraul"),
("Josue", "Gonzalez", "josue@hotmail.com", "contraseniajosue"),
("Kevin", "Iturbe", "kevin@hotmail.com", "contraseniakevin"),
("Francisco", "Rodriguez", "francisco@hotmail.com", "contraseniafrancisco"),
("Raymundo", "Sanchez", "raymundo@hotmail.com", "contraseniaraymundo"),
("Lorenzo", "Diaz", "lorenzo@hotmail.com", "contrasenialorenzo"),
("Santiago", "Uriel", "santiago@hotmail.com", "contraseniasantiago"),
("Luis", "Ramirez", "luis@hotmail.com", "contrasenialuis");

INSERT INTO formas_de_pago (tipo_tarjeta, numero_tarjeta, fecha_vencimiento, cvv) VALUES
("débito", 4867906774836862, 102029, 780),
("débito", 5143674714234159, 122026, 675),
("débito", 6011605337542781, 112032, 322),
("crédito", 4238765899600518, 092029, 210),
("débito", 3579700423298900, 082025, 650),
("crédito", 3435412744615722, 082030, 811),
("débito", 4096188909194847, 122030, 933),
("débito", 4065966400447328, 062029, 347),
("crédito", 4736296011733059, 082031, 566),
("débito", 4764009779330421, 072024, 932),
("débito", 4390516781061184, 092032, 877),
("débito", 5359445160673326, 102031, 469),
("débito", 5518558112265039, 052025, 423),
("crédito", 5559396890737840, 122022, 782),
("débito", 5163678155088219, 082028, 810);

INSERT INTO metodos_de_envio (tipo_de_envio, precio_de_envio) VALUES
("Envio a Domicilio",60),
("Envio Express",100),
("Entrega a Tienda",0);

INSERT INTO productos (nombre_producto, precio_producto, cantidad_producto, descripcion_producto, ruta_imagen_1, ruta_imagen_2, ruta_imagen_3, categoria, descuento, codigo_de_barras) VALUES
("UltraGear FHD IPS 1ms 144Hz HDR Monitor ",5000,20,"Monitor","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/24''%20UltraGear%20FHD%20IPS%201ms%20144Hz%20HDR%20Monitor%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/24''%20UltraGear%20FHD%20IPS%201ms%20144Hz%20HDR%20Monitor%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/24''%20UltraGear%20FHD%20IPS%201ms%20144Hz%20HDR%20Monitor%20(3).webp","Accesorios",0,321634587),
("UltraGear™ Nano IPS 1ms (GtG) Curved Gaming Monito",4500,20,"Monitor","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/34''%20219%20UltraGear%E2%84%A2%20Nano%20IPS%201ms%20(GtG)%20Curved%20Gaming%20Monitor%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/34''%20219%20UltraGear%E2%84%A2%20Nano%20IPS%201ms%20(GtG)%20Curved%20Gaming%20Monitor%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/34''%20219%20UltraGear%E2%84%A2%20Nano%20IPS%201ms%20(GtG)%20Curved%20Gaming%20Monitor%20(3).webp","Accesorios",0,321634536),
("Audifonos-Gamer-Eagle-Warrior-Quimera",3500,20,"Audifonos","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Audifonos-Gamer-Eagle-Warrior-Quimera-(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Audifonos-Gamer-Eagle-Warrior-Quimera-(2).webp","N/a","Accesorios",0,321634534),
("Audífonos-Cougar-Phontum",4000,25,"Audifonos","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Aud%C3%ADfonos-Cougar-Phontum%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Aud%C3%ADfonos-Cougar-Phontum%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Aud%C3%ADfonos-Cougar-Phontum%20(3).webp","Accesorios",0,321634533),
("ESCRITORIO GAMER COUGAR MARS",6000,15,"Escritorio","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/ESCRITORIO%20GAMER%20COUGAR%20MARS%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/ESCRITORIO%20GAMER%20COUGAR%20MARS%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/ESCRITORIO%20GAMER%20COUGAR%20MARS%20(3).webp","Accesorios",0,321634532),
("ESCRITORIO GAMER YEYIAN LOKII BLANCO",5800,10,"Escritorio","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/ESCRITORIO%20GAMER%20YEYIAN%20LOKII%20BLANCO%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/ESCRITORIO%20GAMER%20YEYIAN%20LOKII%20BLANCO%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/ESCRITORIO%20GAMER%20YEYIAN%20LOKII%20BLANCO%20(3).webp","Accesorios",0,321634531),
("Cooler-Master-Devastator-3-Plus",5200,13,"Kit mouse y teclado","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-Cooler-Master-Devastator-3-Plus%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-Cooler-Master-Devastator-3-Plus%20(2).webp","N/a","Accesorios",0,321634564),
("Cougar-Deathfire-EX-RGB ",5400,15,"Kit mouse y teclado","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-Cougar-Deathfire-EX-RGB%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-Cougar-Deathfire-EX-RGB%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-Cougar-Deathfire-EX-RGB%20(3).webp","Accesorios",0,321634529),
("Kit-gamerAO1",6200,13,"Kit mouse y teclado","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-gamerAO1%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-gamerAO1%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Kit-gamerAO1%20(3).webp","Accesorios",0,321634564),
("SILLA GAMER ROSA COUGAR ARMOR ONE EVA",5700,15,"Silla gamer","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/SILLA%20GAMER%20ROSA%20COUGAR%20ARMOR%20ONE%20EVA%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/SILLA%20GAMER%20ROSA%20COUGAR%20ARMOR%20ONE%20EVA%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/SILLA%20GAMER%20ROSA%20COUGAR%20ARMOR%20ONE%20EVA%20(3).webp","Accesorios",0,321634527),
("Silla-Gamer-RGB-Balam-Rush",5400,15,"Silla gamer","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Silla-Gamer-RGB-Balam-Rush%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Silla-Gamer-RGB-Balam-Rush%20(2).webp","N/a","Accesorios",0,321634554),
("Silla-Xzeal-XZ15",5800,12,"Silla gamer","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Silla-Xzeal-XZ15%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/Silla-Xzeal-XZ15%20(2).webp","N/a","Accesorios",0,321634526),
("kultec-negra",5400,16,"Silla gamer","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/kultec-negra-x2%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/kultec-negra-x2%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/accesorios/kultec-negra-x2%20(3).webp","Accesorios",0,321634512),
("Deepcool-Matrexx-50",3200,5,"Gabinete GAMER con la mejor ventilacion para tus juegos y con luces led que te haran ver cool","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/Deepcool-Matrexx-50%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/Deepcool-Matrexx-50%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/Deepcool-Matrexx-50%20(3).webp","PC Gamer",0,694578987),
("GA-Gigabyte-Aorus-C300W",2500,8,"La mejor calidad al mejor precio","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/GA-Gigabyte-Aorus-C300W%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/GA-Gigabyte-Aorus-C300W%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/GA-Gigabyte-Aorus-C300W%20(3).webp","PC Gamer",0,694578987),
("MasterBox-TD500-ARGB",2990,15,"El mejor diseño para tu gabinete, llevatelo a buen precio","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/MasterBox-TD500-ARGB%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/MasterBox-TD500-ARGB%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/MasterBox-TD500-ARGB%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Agis 70z",1800,7,"Diseño discreto y elegante sin perder el toque gamer, gracia a su tira led al centro","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Agis%2070z%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Agis%2070z%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Agis%2070z%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Agis 80z",1950,3,"Para las chicas gamer, un diseño cute y llamativo lo cual quedara perfecto en tu cuato uwu ","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Agis%2080z%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Agis%2080z%20(3).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Agis%2080z%20(4).webp","PC Gamer",0,694578987),
("PC Gamer Caster Max",2600,6,"Grande y con stilo elegante, con lateral traparente luciendo asi todo tu poder gamer","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Caster%20Max%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Caster%20Max%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Caster%20Max%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Gladius 60z X",2600,8,"Con tiras gamer para aumentar tus FP´s, y la mejor ventilacion para tu hardware","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Gladius%2060z%20X%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Gladius%2060z%20X%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Gladius%2060z%20X%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Stelios 70i",1550,5,"Equipo con un toque gamer de materiales de alta calidad","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Stelios%2070i%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Stelios%2070i%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Stelios%2070i%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Stelios 90z",3600,3,"Total trasparencia para que luzca la maquina que gamer que armaste, ademas ayuda a una mejor ventilacion","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Stelios%2090z%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Stelios%2090z%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Stelios%2090z%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Streambox Master",1500,11,"La mejor calidad al mejor precio","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Streambox%20Master%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Streambox%20Master%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Streambox%20Master%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Telios 80i",2800,5,"Gabinete gamer con pantalla pixeleada al frente para aumentar esos fps","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Telios%2080i%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Telios%2080i%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Telios%2080i%20(3).webp","PC Gamer",0,694578987),
("PC Gamer Telios ZX",3200,3,"Diseño abstracto solo para los que llevan los juegos a otro nivel","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Telios%20ZX%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Telios%20ZX%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/PC%20Gamer%20Telios%20ZX%20(3).webp","PC Gamer",0,694578987),
("VISOR-GALERIA",2000,10,"Uno de los mejor equipo, top ventas por su diseño y calidad, lleva los juegos a otro nivel","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/VISOR-GALERIA%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/VISOR-GALERIA%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/VISOR-GALERIA%20(3).webp","PC Gamer",0,694578987),
("Yeyian-Haizen-Negro",1850,8,"Equipo con un toque gamer de materiales de alta calidad","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/Yeyian-Haizen-Negro%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/Yeyian-Haizen-Negro%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/Yeyian-Haizen-Negro%20(3).webp","PC Gamer",0,694578987),
("conquer",3500,5,"Uno de los gabinetes mas usados por los profesionales por su gran diseño totalmente gamer","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/conquer%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/conquer%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/conquer%20(3).webp","PC Gamer",0,694578987),
("inwin-309-neg",1200,3,"Diseño basico para los camperos que no les gusta llamar la atencion","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/inwin-309-neg%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/inwin-309-neg%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/inwin-309-neg%20(3).webp","PC Gamer",0,694578987),
("tuf-gaming-gt501",2500,18,"Diseño para jugadores gamer de corazon que llevan el juego a otro nivel, no apto para noobs","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/tuf-gaming-gt501%20(1).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/tuf-gaming-gt501%20(2).webp","https://raw.githubusercontent.com/SantiagoUGC07/Operacion_Andromeda/master/public/assets/img/pc-gamer/tuf-gaming-gt501%20(3).webp","PC Gamer",0,694578987);

INSERT INTO direcciones(estado, ciudad, direccion, codigo_postal, numero_interior, numero_exterior , informacion_adicional, nombre_destinatario, apellido_destinatario, email_destinatario)	VALUES
("Jalisco", "Guadalajara", "Arquimides", 44770, "120", "45", " ", "Irene", "Benavides", "irene@hotmail.com"),
("Michoacan", "Morelia", "Morelos Nte", 58110, "2055", "34"," ","Cynthia", "James", "cynthia@hotmail.com"),
("Mexico", "Ciudad de Mexico", "Av Universidad", 03020, "3456", "360"," ", "Lourdes", "Anaya", "lourdes@hotmail.com"),
("Quintana Roo", "Tulum", "Calle Chichen Itza", 77780, "001", "24"," ","Abelardo Frida", "Portillo Valentin", "abelardo@hotmail.com"),
("Nuevo Leon", "Monterrey", "Palo Azul", 64100, "1000", "67"," ","Nicolás", "Rangel Mojica", "irene@hotmail.com"),
("Estado de México", "Ixtapaluca", "Jaral 7", 25783, "345", "345"," ","Kevin" , "Ortega", "ejemplo@ejemplo.com"),
("Quintana Roo", "Cancun", "Av Tulum", 77500, "7", "1", "Casa Azul", "José", "Prado", "prado7868@gmail.com"),
("Puebla", "Puebla", "Km 66.6 Carretera Federal Apizaco-Zacatlan", 2202, "5", "3", "A un lado de la tienda", "Manuel", "Amaya", "manuel45@gmail.com"),
("Monterrey", "Nuevo Leon", "Capitan Vasco de Gama 8", 58170, "6", "1", "Avisar al portero", "Paulina", "Perez", "zadkiel9e@gmail.com"),
("Guerrero", "Acapulco de Juarez", "Lomas del Valle", 58170, "8", "5","Ninguna", "Pamela", "Valverde", "contacto@gmail.com"),
("Quintana Roo", "Cancun", "Blvd Kukulkan Km 14.5", 77500, "01", "9", "Adentro de la plaza", "Diego", "Anaya", "Diegoamaya@gmail.com"),
("Jalisco", "Guadalajara", "Manuel M. Dieguez 118", 44600, "01", "33", "Sin indicaciones", "Pedro", "Torres", "Torestores@gmail.com"),
("Tabasco", "Comalcalco", "Reforma 460", 86323, "6", "7", "Barda de piedra", "Daniel", "Santana", "santanadanielgmail.com"),
("Sonora", "Hermosillo", "Boulevard Jose Maria Morelos", 83144, "01", "662", "Sin puerta", "Juan", "Varela", "varela9893@gmail.com"),
("Guanajuato", "Celaya", "Agustin Arroyo", 38050, "40", "3", "Dentro de la plaza", "Gema", "Reyes", "Reyesw94@gmail.com");

insert into tickets (id_usuario, id_direccion, id_envio, id_forma_de_pago, estatus_del_pedido) values 
(1,2,1,1,"procesando"),
(2,3,2,2,"procesando"),
(3,4,3,3,"procesando"),
(4,5,1,4,"procesando"),
(5,6,2,5,"procesando"),
(2,3,2,2,"completado"),
(3,4,3,3,"completado"),
(3,4,3,3,"completado");

insert into tickets_productos (id_producto, id_ticket) values 
(1,2),
(2,2),
(3,2),
(4,3),
(5,3),
(6,3),
(1,4),
(1,4),
(1,4),
(6,5),
(7,6),
(5,7);