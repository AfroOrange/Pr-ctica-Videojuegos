# Sistema de Gestión de Videojuegos
Este es un programa de consola en Java para gestionar un inventario de videojuegos, usuarios y compras. Permite realizar diversas operaciones como agregar nuevos videojuegos, usuarios, realizar compras, entre otros.

---------------------------------------------------------------------------------------------------------------------
## Funcionalidades
El sistema cuenta con las siguientes funcionalidades:

Mostrar lista de videojuegos: Muestra la lista de todos los videojuegos disponibles en el inventario.

Añadir nuevo videojuego: Permite agregar un nuevo videojuego al inventario especificando su nombre, consola, estado y stock.

Mostrar lista de usuarios: Muestra la lista de todos los usuarios registrados en el sistema.

Añadir nuevo usuario: Permite agregar un nuevo usuario al sistema especificando su DNI, nombre, apellidos, teléfono y correo electrónico.

Comprar videojuego: Permite a un usuario realizar la compra de un videojuego, disminuyendo su stock en caso de disponibilidad.

## Estructura del proyecto
El proyecto está estructurado de la siguiente manera:

src: Contiene los archivos fuente del programa en Java.

Main.java: Clase principal que contiene el menú principal y las interacciones con el usuario.

Videojuegos.java: Clase que representa los videojuegos y sus métodos.

Usuarios.java: Clase que representa a los usuarios y sus métodos.

GestorCompras.java: Clase que gestiona las compras de videojuegos.

txtfiles: Carpeta que contiene los archivos de texto donde se almacenan los datos de videojuegos, usuarios y compras.

juegos.txt: Archivo que contiene la información de los videojuegos.

usuarios.txt: Archivo que contiene la información de los usuarios.

compras.txt: Archivo que registra las compras realizadas.

---------------------------------------------------------------------------------------------------------------------

## Requisitos
Para ejecutar el programa se requiere tener instalado Java Development Kit (JDK) en el sistema.

---------------------------------------------------------------------------------------------------------------------

## Instrucciones de uso
Clonar este repositorio en su máquina local.
Compilar los archivos fuente ejecutando el siguiente comando en la terminal:

-------------------------------------
    
    javac src/*.java  
    
------------------------------------

    java -cp src Main


