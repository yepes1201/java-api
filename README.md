# Java API usando Spring Boot

<hr/>

## Archivos de Configuración
Existen dos archivos de configuración principales del proyecto.
El primero es **/pom.xml** y el segundo **src/main/resources/application.properties**

### pom.xml
Este es parecido al **package.json** del NodeJS. Aquí se encuentra todas las dependencias y la información base del proyecto, tal como el nombre, descripción, versiones, etc.

### application.proporties
En este archivo se encuentra toda la información necesaria que necesita el proyecto para que su funcionalidad esté sin problemas, tal como claves de acceso, conexión a base de datos, etc.

## Archivos Fuente
El archivo principal donde la aplicación se ejecuta es **Main.java**. Cabe recalcar que puede llevar cualquier otro nombre, solo que este debe llevar el metodo **main** llamando a la función ``````SpringApplication.run(Main.class, args)``````.

Los archivos fuentes se encuentra del **src/main/java/com/example/javaapi**

``````
-- src/
--- main/
----- com/
------- example/
--------- javaapi/
----------- controllers/
----------- models/
----------- repositories/
----------- services/
----------- Main.java
``````
### Controllers
Dentro de esta carpeta se encontrarán todos los controladores de cada entidad que es usada en el proyecto. Estas son las encargadas de recibir la petición. Se apoyan en los services para realizar la petición.

### Models
Dentro de esta carpeta se encontrarán todos los modelos de cada entidad que es usada en el proyecto. Estos son los modelos de la base de datos, es decir, cada modelo sería una tabla equivalente a la base de datos. Estos suelen ser usados por los repositories o services.

### Repositories
Los repositorios son interfaces que heredan de una clase padre, esta suele ser **CrudRepository**. Esto permite la incerción, borrado, actualizado y el mostrado de la información de la base de datos de una manera fácil debido a que al heredar de la clase antes mencionada, esta última trae los métodos principales para realizar este tipo de acciones.
Estos suelen ser llamados por los services.

### Services
Los services es una clase donde se crean métodos para realizar algún tipo de accion en específico. Estos suelen ser llamados por los controllers.

## Notas Adicionales
Para crear cada servicio antes mencionado, en la clase se le debe agregar su respectivo nombre. Ejemplo:

``````;
// Controllers
@RestController
@RequestMapping("/producto") // Ruta principal del controlador
public class ProductoController {...}
``````

``````;
// Models
@Entity // Declaramos que es una entidad
@Table(name = "producto") // Le damos un nombre a la tabla en la BD
public class ProductoModel {...}
``````

``````;
// Services
@Service
public class ProductoServices {...}
``````

``````;
// Repositories
@Repository
public class ProductoRepository {...}
``````

## Nomenclaturas
- **@Autowired** hace que Spring Boot instancie o "conecte" de manera automática con otra clase de Spring Boot. Sería equivalente a llamar al constructor de la clase y settear las variables de la clase provientes del constructor.
- **@GetMapping** vuelve un método a una ruta API de método GET.
  - Se le puede agregar un parámetro "path" para especificar su ruta.
  - Para recibir un valor variable dentro de la ruta se encierra entre llaves {id}. **(Ejemplo en ProductoController.java, obtenerProducto)**
  - Para recibir parámetros queries dentro de la misma ruta se agrega dentro del método **@RequestParams(*NOMBRE DEL PARÁMETRO*)**, su naturaleza y un nombre. **(Ejemplo en ProductoController.java, obtenerProductosPorNombre)**
- **@PostMapping** vuelve un método a una ruta API de método POST. Para recibir la información dentro de los parámetros del método se agrega **@RequestBody**, el tipo de objeto a recibir y su nombre. **(Ejemplo en ProductoController.java)**
- **@Column** esta anotación indica que el atributo de esa identidad es una columna de la tabla.
- **@Id** indica que es el ID del registro.
- **@GeneratedValue(strategy = GenerationType.IDENTITY)** indica que el atributo es un valor generado por identidad, es decir, autoincremental.
- **@Query** nos permite ejectuar SQL puro agregandole el atributo **nativeQuery = true**.
- **@Param(NOMBRE DEL PARÁMETRO)** seguido del tipo de variable y su nombre, nos permite parametrizar las consultas. **(Ejemplo en ProductoRepositroy.java)**
  
<hr/>

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

