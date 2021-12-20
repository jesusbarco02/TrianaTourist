# TRIANA TOURIST

#### Repositorio del proyecto **TRIANA TOURIST** del módulo de Aceso a Datos y Programación de Servicios y Procesos 2021-22. ####

</br>

### Descargar JDK 17 de la página de Oracle, y también descargar IntelliJ IDEA Community Edition. Para poner en marcha el proyecto, una vez se ha abierto en *IntelliJ IDEA*, es ir a la pestaña de Maven, a la derecha de la ventana, abrir la carpeta de Plugins, abrir el apartado de *spring-boot* y pulsar donde diga *spring-boot:run*
### La aplicación nos permite manejar todas las funcionalidades de la página. 
</br>


## Entidades de la aplicación:
* ### Category
* ### POI(Point of Interest)
* ### Route


  
</br>

## <p>Funcionalidades de Category:</p> ##
* Crear nueva categoría, el nombre debe ser único y no puede estar vacío
* Obtener todas las Categorias
* Obtener los datos de una Categoria concreta
* Borrar una Categoria concreta
</br>

## <p>Funcionalidades de POI(Point of Interest):</p> ##

#### Asociación @ManyToOne hacia Categoria 

* Crear un nuevo punto de interés, no puede estar vacío, su categoría debe ser una categoría existente
* Mostrar todas los puntos de interés existentes
* Ver los datos de un punto de interés en concreto
* Modificar los datos de un punto de interés
* Borrar un punto de interés

</br>

## <p>Funcionalidades de Route:</p> ##

#### Asociación @ManyToMany hacia POI

* Crear una nueva ruta, el nombre de la ruta debe ser único
* Mostrar todas las rutas existentes
* Ver los datos de una ruta en concreto
* Modificar los datos de una ruta
* Borrar una ruta
</br>

## Realizado por:
* ### Jesús Barco Espinar
