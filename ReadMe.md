# ProyectoVerano

## Estructura del Proyecto


                    ProyectoVerano/
                    ├── src/
                    │ ├── main/
                    │ │ └── java/
                    │ │ └── Tienda/
                    │ │ ├── Cliente.java
                    │ │ ├── Mascota.java
                    │ │ ├── Venta.java
                    │ │ ├── Main.java
                    │ └── test/
                    │ └── java/
                    │ └── Tienda/
                    │ ├── ClienteTest.java
                    │ ├── MascotaTest.java
                    │ └── VentaTest.java
                    ├── docs/
                    │ └── [Documentación HTML generada con JavaDoc]
                    ├── pom.xml
                    └── README.md
---

##  Cómo ejecutar el proyecto

Este proyecto está construido con [Maven](https://maven.apache.org/). Asegúrate de tener Maven instalado correctamente:

```bash
mvn -v
```
Para compilar y ejecutar el proyecto:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="Tienda.Main"
```

Si exec-maven-plugin no está configurado, puedes ejecutar la clase Main desde tu entorno (como IntelliJ o VSCode).

## Requisitos de la práctica

Estructura clara de carpetas

Código documentado con JavaDoc

Proyecto con estructura Maven

Pruebas JUnit funcionales en src/test/java

Historial de commits y ramas en Git

Carpeta docs/ con documentación HTML generada por JavaDoc

## Documentación JavaDoc
La documentación JavaDoc ha sido generada automáticamente con Maven. Para visualizarla:

Abre el archivo docs/index.html en tu navegador.

Navega por las clases y métodos documentados.

Para generar el JavaDoc nuevamente:
```
mvn javadoc:javadoc
```

## Ejecutar Tests
Los tests están implementados con JUnit 5. Para ejecutarlos:

```mvn test```

## Autor
Ander Resano

Proyecto desarrollado como parte de la práctica de programación en Java con Maven.