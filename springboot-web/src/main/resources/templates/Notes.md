

- `./mvnw clean package`: Empaquetar el proyecto utilizando Maven Wrapper. Este comando limpia los archivos generados en compilaciones anteriores y construye un nuevo paquete del proyecto.

- `java -jar ./springboot-web-0.0.1-SNAPSHOT.jar`: Este comando se utiliza para ejecutar un archivo JAR de una aplicación Spring Boot. El archivo JAR se encuentra dentro del directorio "target". Al ejecutar este comando, se cargan todas las dependencias y configuraciones de la aplicación.

Para realizar el despliegue utilizando Maven, puedes aprovechar el ciclo de vida (lifecycle) del mismo. El uso de las fases `clean` aqui importante el reload o refresh realizarlo y `package` nos permite Limpiar y Empaquetar el Proyecto
