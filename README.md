![ub](https://user-images.githubusercontent.com/122720038/213809348-cf4eac0e-b551-4e64-b08a-50616dd995c7.PNG) 

# **M4-Actividad-Final**
Ejercicio de Automatización sobre una Aplicación Web

## **Tabla de contenidos**
- [Inicio](#inicio)
- [1. Introducción](#1-introducción)
  * [1.1 Objetivos](#11-objetivos)
  * [1.2 Instrucciones](#12-instrucciones)
- [2. Conjunto de herramientas iniciales](#2-conjunto-de-herramientas-iniciales)
  * [2.1 Instalación de prerequisitos](#21-instalación-de-prerequisitos)
    + [2.1.1 Git](#211-git)
    + [2.1.2 Visual Studio Code](#212-visual-studio-code)
- [3. Conjunto de herramientas de desarrollo](#3-conjunto-de-herramientas-de-desarrollo)
  * [3.1 Instalación de herramientas](#31-instalación-de-herramientas)
    + [3.1.1 Java SE Development Kit](#311-java-se-development-kit)
    + [3.1.2 Apache Maven](#312-apache-maven)
    + [3.1.3 IntelliJ IDEA](#313-intellij-idea)
- [4. Creación del proyecto](#4-creación-del-proyecto)
- [5. Ejecución de Pruebas](#5-ejecución-de-pruebas)
  * [5.1 Test 1 Sign Up en la Tienda Online](#51-test-1-sign-up-en-la-tienda-online)
    + [5.1.1 COMO usuario QUIERO ser capaz de darme de alta](#511-como-usuario-quiero-ser-capaz-de-darme-de-alta)
  * [5.2 Test 2 Iniciar sesión](#52-test-2-iniciar-sesión)
    + [5.2.1 COMO usuario QUIERO ser capaz de iniciar sesión en la Tienda Online](#521-como-usuario-quiero-ser-capaz-de-iniciar-sesión-en-la-tienda-online)
  * [5.3 Test 3 Navegar en Teléfonos ordenadores y pantallas](#53-test-3-navegar-en-teléfonos-ordenadores-y-pantallas)
    + [5.3.1 COMO usuario QUIERO ser capaz de navegar por diferentes productos](#531-como-usuario-quiero-ser-capaz-de-navegar-por-diferentes-productos)
  * [5.4 Test 4 Añadir al carrito](#54-test-4-añadir-al-carrito)
    + [5.4.1 COMO usuario QUIERO añadir un s7 un s6 y un vaio i7](#541-como-usuario-quiero-añadir-un-s7-un-s6-y-un-vaio-i7)
  * [5.5 Test 5 Eliminar del carrito](#55-test-5-eliminar-del-carrito)
    + [5.5.1 COMO usuario QUIERO eliminar el Samsung galaxy s6](#551-como-usuario-quiero-eliminar-el-samsung-galaxy-s6)
  * [5.6 Test 6 Pedido de artículos](#56-test-6-pedido-de-artículos)
    + [5.6.1 COMO usuario QUIERO realizar el pedido de artículos seleccionados](#561-como-usuario-quiero-realizar-el-pedido-de-artículos-seleccionados)
- [6. Resultado Final](#6-resultado-final)
- [7. Realizado Con](#7-realizado-con)
- [8. Autores](#8-autores)
- [9. Licencia](#9-licencia)

## Inicio
El proyecto consiste en implementar comprobaciones automatizadas web en el siguiente enlace <a href="https://www.demoblaze.com/index.html" onclick="window.open(this.href, '_blank'); return false;">TIENDA ONLINE</a>

[Volver al menú](#tabla-de-contenidos)

## **1. Introducción**
El proyecto consiste en la implementación de pruebas automatizadas para verificar su correcto funcionamiento.

[Volver al menú](#tabla-de-contenidos)

### 1.1 Objetivos
Aprender a crear un proyecto de automatización web con tecnología Maven.
Aprender a respetar el Patrón AAA durante la creación de la prueba automática. 
Aprender a ejecutar la prueba de forma local y por comandos Maven. 
Aprender a utilizar el patrón de diseño de objetos en pruebas automatizadas.  
Aprender a utilizar correctamente el lenguaje Gherkin.

[Volver al menú](#tabla-de-contenidos)

### 1.2 Instrucciones
El lenguaje de programación a utilizar ha de ser Java y el framework para automatizar dichas pruebas automáticas  
ha de ser Selenium WebDriver, Maven, Junit, AssertJ y Cucumber/Gherkin. Otra de las herramientas que se puede  
utilizar en sustitución de Selenium WebDriver podrá ser Serenity BDD (esta herramienta ya tiene integrado  
Selenium WebDriver y la librería Junit).

[Volver al menú](#tabla-de-contenidos)

## **2. Conjunto de herramientas iniciales**
El proyecto requiere contar con una serie de prerequisitos y herramientas las cuales se describen a continuación:

[Volver al menú](#tabla-de-contenidos)

#### 2.1 Instalación de prerequisitos 
A continuación se detalla la lista de Prerequisitos requeridos:

[Volver al menú](#tabla-de-contenidos)

##### 2.1.1 Git

A) Ir al siguiente enlace: <a href="https://git-scm.com/" onclick="window.open(this.href, '_blank'); return false;">Git</a>

<p align="left">
    <img width="500" alt="git_webpage" src="https://user-images.githubusercontent.com/122720038/213792206-f32d9ece-63e8-4ec2-8dde-9e8715bf4623.PNG">
</p>

[Volver al menú](#tabla-de-contenidos)

B) Descargar e instalar Git

<p align="left">
  <img src="https://user-images.githubusercontent.com/122720038/213799332-a551f771-f532-4432-b7ce-7ff59caf1777.PNG" width="350" />
  <img src="https://user-images.githubusercontent.com/122720038/213799595-b935757e-4e48-4e78-9b3f-25aacc83b4ec.PNG" width="350" /> 
</p>

[Volver al menú](#tabla-de-contenidos)

C) Verificar la instalación de Git

<p align="left">
    <img width="400" alt="git_version" src="https://user-images.githubusercontent.com/122720038/213815492-75d894eb-c86f-4c6a-8db2-1f72197e681d.PNG">
</p>

[Volver al menú](#tabla-de-contenidos)

##### 2.1.2 Visual Studio Code

A) Ir al siguiente enlace: <a href="https://code.visualstudio.com/" onclick="window.open(this.href, '_blank'); return false;">Visual Studio Code</a>

<p align="left">
    <img width="450" alt="git_webpage" src="https://user-images.githubusercontent.com/122720038/213801996-b0dc6084-fe5f-4902-a7da-8a4d26127735.PNG">
</p>

[Volver al menú](#tabla-de-contenidos)

B) Descargar e instalar Visual Studio Code

<p align="left">
  <img src="https://user-images.githubusercontent.com/122720038/213816951-e9ac9da4-816c-4189-9e5d-f454f7c9518b.PNG" width="400" />
</p>

[Volver al menú](#tabla-de-contenidos)

C) Verificar la instalación de Visual Studio Code

![vc_version](https://user-images.githubusercontent.com/122720038/213803283-226fb356-f0b2-4130-80c9-5b13b6968e66.PNG)

[Volver al menú](#tabla-de-contenidos)

## **3. Conjunto de herramientas de desarrollo**
El proyecto requiere una serie de herramientas para pruebas y desarrollo las cuales se describen a continuación:

[Volver al menú](#tabla-de-contenidos)

#### 3.1 Instalación de herramientas
A continuación se detalla la lista de herramientas requeridas:

[Volver al menú](#tabla-de-contenidos)

##### 3.1.1 Java SE Development Kit

A) Ir al siguiente enlace: <a href="https://www.oracle.com/java/technologies/downloads/" onclick="window.open(this.href, '_blank'); return false;">Java SE Development Kit</a>

<img width="650" alt="jdk" src="https://user-images.githubusercontent.com/122720038/213766846-59b20f3a-db03-47b9-a160-ba3082271919.png">

[Volver al menú](#tabla-de-contenidos)

B) Descargar e instalar Java SE Development Kit

<p align="left">
  <img src="https://user-images.githubusercontent.com/122720038/213831077-e7119151-ce3e-429d-99ec-faddc9d9bee4.PNG" width="325" />
  <img src="https://user-images.githubusercontent.com/122720038/213831185-72fbd98e-6409-4d18-914f-94081d8f1e4e.PNG" width="325" /> 
</p>

[Volver al menú](#tabla-de-contenidos)

C) Verificar la instalación de Java SE Development Kit

<p align="left">
    <img width="650" alt="java_version" src="https://user-images.githubusercontent.com/122720038/213831236-97808b9c-9efb-4f78-a297-8d3292360d04.PNG">
</p>

[Volver al menú](#tabla-de-contenidos)

##### 3.1.2 Apache Maven

A) Ir al siguiente enlace: <a href="https://maven.apache.org/download.cgi" onclick="window.open(this.href, '_blank'); return false;">Apache Maven</a>

<img width="650" alt="apache_maven" src="https://user-images.githubusercontent.com/122720038/213772643-ac8b8917-c1d4-4ab8-8209-be8ecd1023ee.png">

[Volver al menú](#tabla-de-contenidos)

B) Descargar, instalar y verificar Apache Maven

<p align="left">
    <img width="650" alt="maven_version" src="https://user-images.githubusercontent.com/122720038/213831335-130d9a99-b1dc-4ae6-ac89-5051c283f61b.PNG">
</p>

[Volver al menú](#tabla-de-contenidos)

##### 3.1.3 IntelliJ IDEA

A) Ir al siguiente enlace: <a href="https://www.jetbrains.com/idea/" onclick="window.open(this.href, '_blank'); return false;">IntelliJ IDEA</a>

<img width="650" alt="intellij" src="https://user-images.githubusercontent.com/122720038/213779508-de1d1c72-d362-425c-a0ce-0f2b55619248.png">

[Volver al menú](#tabla-de-contenidos)

B) Descargar e instalar IntelliJ IDEA

<p align="left">
  <img src="https://user-images.githubusercontent.com/122720038/213832306-58d7a34e-9cce-4bce-8929-fac5d1b4db91.PNG" width="325" />
  <img src="https://user-images.githubusercontent.com/122720038/213832763-cc678a1e-0df9-4b17-8965-9f1ead6d6e66.PNG" width="325" /> 
</p>

[Volver al menú](#tabla-de-contenidos)

### 4. Creación del proyecto
Para crear el proyecto, siga los siguientes pasos:


1. Abra IntelliJ IDEA.

[Volver al menú](#tabla-de-contenidos)

### Prerequisitos
Anotaciones

EJEMPLOS:
<p align="left">
    <img width="650" alt="mvp1" src="https://user-images.githubusercontent.com/122720038/213835852-70b9d172-20f1-47ca-812a-ee68d861557c.PNG">
</p>
<p align="left">
    <img width="650" alt="mvp2" src="https://user-images.githubusercontent.com/122720038/213835898-81a8833b-cafc-4ee0-bd66-1c1cb5cb3237.PNG">
</p>


### Instalación
1. Clonar el repositorio: `git clone https://github.com/xxxx.git`
2. Importe el proyecto a IntelliJ IDEA como un proyecto Maven

```
M4-Actividad-Final/
├── .idea
├── src/
| ├── main/
| | └── java/
| | └── resources/
| ├── test/
| | └── java/
| | ├──TestWhenDoingActividadFinal
| | └── resources/
| | ├── drivers/
| | | └── windows/
| | | └── chromedriver.exe
├── target/
├── pom.xml
External Libraries/
Scratches and Consoles
```

4. Actualice webdriver.chrome.driver en la clase `xxxx` en la ruta del ejecutable drivers/windows/chromedriver.exe de su máquina local

### 5. Ejecución de Pruebas
El conjunto de pruebas contiene las siguientes pruebas

[Volver al menú](#tabla-de-contenidos)

#### 5.1 Test 1 Sign Up en la Tienda Online

Escenario: Registrar un nuevo usuario

Given - Dado que el usuario navega a la página de registro
When -  Cuando el usuario ingresa su correo electrónico, contraseña e información personal Y el usuario hace clic en el botón "Registrarse"
Then -  Luego se debe crear una nueva cuenta y el usuario debe iniciar sesión

[Volver al menú](#tabla-de-contenidos)

##### 5.1.1 COMO usuario QUIERO ser capaz de darme de alta

![test1](https://user-images.githubusercontent.com/123221049/214040957-05b9b38f-ce99-4ac6-b7a0-ebeb47884e27.PNG)

[Volver al menú](#tabla-de-contenidos)

#### 5.2 Test 2 Iniciar sesión

[Volver al menú](#tabla-de-contenidos)

##### 5.2.1 COMO usuario QUIERO ser capaz de iniciar sesión en la Tienda Online

![test1](https://user-images.githubusercontent.com/123221049/214043666-31386829-e55a-4546-8b11-0a5a6b3c2c52.PNG)

[Volver al menú](#tabla-de-contenidos)

#### 5.3 Test 3 Navegar en Teléfonos ordenadores y pantallas

[Volver al menú](#tabla-de-contenidos)

##### 5.3.1 COMO usuario QUIERO ser capaz de navegar por diferentes productos
```
@Test
public void 
}
```
[Volver al menú](#tabla-de-contenidos)

#### 5.4 Test 4 Añadir al carrito

[Volver al menú](#tabla-de-contenidos)

##### 5.4.1 COMO usuario QUIERO añadir un s7 un s6 y un vaio i7
```
@Test
public void 
}
```
[Volver al menú](#tabla-de-contenidos)

#### 5.5 Test 5 Eliminar del carrito

[Volver al menú](#tabla-de-contenidos)

##### 5.5.1 COMO usuario QUIERO eliminar el Samsung galaxy s6
```
@Test
public void 
}
```
[Volver al menú](#tabla-de-contenidos)

#### 5.6 Test 6 Pedido de artículos

[Volver al menú](#tabla-de-contenidos)

##### 5.6.1 COMO usuario QUIERO realizar el pedido de artículos seleccionados
```
@Test
public void 
}
```
[Volver al menú](#tabla-de-contenidos)

## **6. Resultado Final**

Los resultados del test fueron satisfactorios

![image1](https://user-images.githubusercontent.com/123221049/214038162-96d1fd30-5c37-4217-af64-f4b13255a803.png)

![image2](https://user-images.githubusercontent.com/123221049/214038825-4336897c-4fe3-42a1-9c4b-2d46f43c26c9.png)


## **7. Realizado Con**
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![DuckDuckGo](https://img.shields.io/badge/DuckDuckGo-DE5833?style=for-the-badge&logo=DuckDuckGo&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white)
<img width="125" alt="jetbrains_intellij_button_icon_151878" src="https://user-images.githubusercontent.com/122720038/213829729-3785c0d4-d936-4c43-a0c8-9cb059f62e8f.png">
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Windows 11](https://img.shields.io/badge/Windows%2011-%230079d5.svg?style=for-the-badge&logo=Windows%2011&logoColor=white)


[Volver al menú](#tabla-de-contenidos)

## **8. Autores**
Derun Chen  
Jimmy Ulloa Mora  
Jose Valentin Serra Mendoza

[Volver al menú](#tabla-de-contenidos)

## **9. Licencia**
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[Volver al menú](#tabla-de-contenidos)
