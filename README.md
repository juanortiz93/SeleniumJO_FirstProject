# Proyecto de Automatización - Free Range Testers

[![Selenium Tests](https://github.com/juanortiz93/SeleniumJO_FirstProject/actions/workflows/selenium-tests.yml/badge.svg)](https://github.com/juanortiz93/SeleniumJO_FirstProject/actions/workflows/selenium-tests.yml)

Este proyecto contiene pruebas automatizadas para el sitio web de Free Range Testers (www.freerangetesters.com) utilizando Selenium WebDriver con Java, Cucumber y el patrón Page Object Model.

![GitHub last commit](https://img.shields.io/github/last-commit/juanortiz93/SeleniumJO_FirstProject)
![GitHub issues](https://img.shields.io/github/issues/juanortiz93/SeleniumJO_FirstProject)
![GitHub pull requests](https://img.shields.io/github/issues-pr/juanortiz93/SeleniumJO_FirstProject)

## Descripción del Proyecto

El proyecto está diseñado para validar las funcionalidades principales del sitio web de Free Range Testers, enfocándose en:

1. Navegación por la barra de menú
2. Acceso a cursos
3. Proceso de selección de planes

## Casos de Prueba

### 1. Navegación por la Barra de Menú
- Validación de acceso a todas las secciones principales:
  - Cursos
  - Recursos
  - Udemy
  - Mentorías
  - Blog
  - Academia

### 2. Validación de Cursos
- Acceso a la sección de cursos
- Verificación del curso "Introducción al Testing de Software"
- Validación del contenido y título del curso

### 3. Proceso de Selección de Plan
- Acceso a la opción "Elegir Plan"
- Validación de las opciones disponibles en la página de checkout

## Estructura del Proyecto

```
src/
├── test/
│   ├── java/
│   │   ├── pages/          # Page Objects
│   │   ├── runner/         # TestRunner configuration
│   │   └── steps/          # Step definitions
│   └── resources/
│       ├── features/       # Cucumber feature files
│       └── cucumber.properties
```

## Tecnologías Utilizadas

- Java
- Selenium WebDriver
- Cucumber
- JUnit
- Gradle

## Configuración del Proyecto

1. Requisitos previos:
   - Java JDK 8 o superior
   - Gradle
   - ChromeDriver (asegúrate de que coincida con tu versión de Chrome)

2. Clonar el repositorio:
   ```bash
   git clone https://github.com/juanortiz93/SeleniumJO_FirstProject.git
   ```

3. Instalar dependencias:
   ```bash
   gradle clean build
   ```

## Ejecución de Pruebas

### Desde línea de comandos:
```bash
gradle test
```

### Desde Jenkins:
1. Crear un nuevo proyecto de tipo Pipeline
2. Configurar el repositorio Git
3. Usar el JenkinsFile incluido en el proyecto
4. Ejecutar el pipeline

## Reportes

Los reportes se generan en:
```
build/reports/tests/test/index.html
```

Este reporte incluye:
- Resultados detallados de las pruebas
- Tiempo de ejecución
- Capturas de pantalla en caso de fallos
- Trazas de errores si los hay

## Estructura de Page Objects

El proyecto utiliza el patrón Page Object Model (POM) para mantener el código organizado y fácil de mantener:

- `BasePage.java`: Clase base con métodos comunes
- `PaginaPrincipal.java`: Page object para la página principal
- `PaginaCursos.java`: Page object para la sección de cursos
- `PaginaFundamentosTesting.java`: Page object para la página del curso de testing

## Contribución

1. Fork el proyecto
2. Crea tu rama de características (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Mantenimiento

Para mantener el proyecto actualizado:

1. Actualizar regularmente las dependencias en build.gradle
2. Mantener el ChromeDriver actualizado
3. Revisar y actualizar los localizadores si cambia el sitio web
4. Ejecutar las pruebas regularmente para detectar fallos tempranos

## Solución de Problemas Comunes

1. **ElementNotInteractableException**:
   - Asegurarse de que los elementos sean visibles antes de interactuar
   - Verificar que los localizadores sean correctos
   - Agregar esperas explícitas cuando sea necesario

2. **TimeoutException**:
   - Revisar la conectividad a internet
   - Verificar que el sitio esté accesible
   - Ajustar los tiempos de espera en la configuración

3. **WebDriverException**:
   - Actualizar el ChromeDriver
   - Verificar la compatibilidad con la versión de Chrome
   - Asegurarse de que el navegador no esté siendo utilizado por otro proceso

## Contacto

Juan Ortiz - juanortiz93@github.com

Link del proyecto: [https://github.com/juanortiz93/SeleniumJO_FirstProject](https://github.com/juanortiz93/SeleniumJO_FirstProject)