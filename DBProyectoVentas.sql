Drop database if exists DBProyectoVentas;
create database DBProyectoVentas;

use DBProyectoVentas;

Create table Cliente(
	codigoCliente int not null auto_increment,
    DPICliente varchar (15) not null,
    nombresCliente varchar(200) not null,
    direccionCliente varchar(150) not null,
    estado varchar(1) not null,
    primary key PK_codigoCliente (codigoCliente)
);

Create table Empleado(
	codigoEmpleado int not null auto_increment,
    DPIEmpleado varchar(15) not null,
    nombresEmpleado varchar(200) not null,
    telefonoEmpleado varchar (8) not null,
    estado varchar(1) not null,
    usuario varchar (15) not null,
    primary key PK_codigoEmpleado (codigoEmpleado)
);

Create table Producto(
	codigoProducto int not null auto_increment,
    nombreProducto varchar(200) not null,
    precio double not null,
    stock int not null,
    estado varchar (1) not null,
    primary key PK_codigoProducto (codigoProducto)
);

Create table Venta(
	codigoVenta int not null auto_increment,
    numeroSerie varchar(255) not null,
    fechaVenta date not null,
    monto double not null,
    estado varchar(1) not null,
    codigoCliente int not null,
    codigoEmpleado int not null,
    primary key PK_codigoVenta (codigoVenta),
    constraint FK_Venta_Cliente foreign key (codigoCliente) references Cliente(codigoCliente),
    constraint FK_Venta_Empleado foreign key (codigoEmpleado) references Empleado (codigoEmpleado)
	);
    
Create table DetalleVenta(
	codigoDetalleVenta int not null auto_increment,
    codigoProducto int not null,
    cantidad int not null,
    precioVenta double not null,
    codigoVenta int not null, 
    primary key PK_codigoDetalleVenta(codigoDetalleVenta),
    constraint FK_DetalleVenta_Producto foreign key (codigoProducto) references Producto(codigoProducto),
    constraint FK_DetalleVenta_Venta foreign key (codigoVenta) references Venta(codigoVenta)
);

insert into Cliente(DPICliente, nombresCliente, direccionCliente, estado)
 values('12345678912345', 'Edgar Sinay', 'Zona 18, Guatemala', '1');
 insert into Cliente(DPICliente, nombresCliente, direccionCliente, estado)
 values('12345678911232', 'Fredy Alexander', 'Zona 1, Guatemala', '1');
  insert into Cliente(DPICliente, nombresCliente, direccionCliente, estado)
 values('12345343434333', 'Jefry Milian', 'Zona 4, Guatemala', '1');
  insert into Cliente(DPICliente, nombresCliente, direccionCliente, estado)
 values('12345621312311', 'Rodrigo Veliz', 'Zona 10, Mixco', '1');
  insert into Cliente(DPICliente, nombresCliente, direccionCliente, estado)
 values('12345673453454', 'Brian Zepeda', 'Zona 4, Guatemala', '1');
 
 insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) 
<<<<<<< HEAD
 values('4579342483943', 'Carlos Valle', '53239288', '1', 'cvalle');
  insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) 
 values('4938283475892', 'Edgar Sinay', '32830011', '1', 'esinay');

insert into Producto(nombreProducto, precio, stock, estado) 
values('Teclado redragon k552', '469.00',25 , '1');
=======
 values('2893829291021', 'Carlos Valle', '123123', '1', 'cvalle');
  insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) 
 values('2483293848293', 'Edgar Sinay', '1333332', '1', 'esinay');

insert into Producto(nombreProducto, precio, stock, estado) 
values('Teclado redragon k552', '125.00',25 , '1');
>>>>>>> develop
insert into Producto(nombreProducto, precio, stock, estado) 
values('Monitor AOC 24G2', '900.00', 35, '1');

select * from Cliente;
select * from Empleado;
select * from Producto;

Select * from empleado where usuario = 'esinay' and DPIEmpleado = '4938283475892';

select * from empleado where codigoEmpleado = 2;

select * from cliente where codigoCliente = 2;


Select * from empleado where usuario = 'esinay' and DPIEmpleado = '2483293848293';

select * from empleado where codigoEmpleado = 2;

select * from cliente where codigoCliente = 2;





 
 
 
 


