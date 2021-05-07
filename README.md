# Generador de reporte: Precio promedio de Motos en Argentina por marca.

## Descripción
Genera un reporte de los precios promedio por marca de las motos nuevas publicadas en Mercado Libre Argentina a partir de una subpoblacion de 900 publicaciones.

## Requisitos
- Java 8. Asegurese de setear la variable de sistema JAVA_HOME.
- Maven 3.8.1 o superior (https://maven.apache.org/download.cgi). Asegurese de actualizar la variable de entorno PATH con el ejecutable mvn.exe (subdirectorio /bin)

## Consideraciones
- El sistema no discrimina valores. Algunas publicaciones muestran el valor de la cuota y no el precio final.
- Algunos precios son publicados en moneda distinta a pesos argentinos. A modo de simplificación no se convierte a dicha moneda.
- El análisis esta limitado a una población de 900 registros. El máximo soportado por la API REST de Mercado Libre sin un access_token es de 1000 registros.

## Ejecución
- Descargue el aplicativo desde el repositorio git.
- Abra una consola cmd.exe
- Ubicarse en el directorio del aplicativo.
- Ejecute mvn spring-boot:run

## Ejemplo de salida

-------------------------------------------------------------------------------
Motos: Precios promedio por marca.
-------------------------------------------------------------------------------
- VESPA - 141893 ARS$
- NUUV - 267036 ARS$
- KYMCO - 200094 ARS$
- APRILIA - 3100000 ARS$
- KTM - 707496 ARS$
- KIDEN - 234200 ARS$
- CORVEN - 129357 ARS$
- ZANE - 168990 ARS$
- ELPRA - 158444 ARS$
- VOGE - 1172708 ARS$
- EMUV - 195000 ARS$
- JAWA - 360116 ARS$
- GILERA - 153357 ARS$
- SUZUKI - 100367 ARS$
- TVS - 397083 ARS$
- GALIX - 65000 ARS$
- SUNRA - 182885 ARS$
- GILERA 110 - 102000 ARS$
- HONDA - 330139 ARS$
- MONDIAL - 131622 ARS$
- HERO - 236900 ARS$
- DUCATI - 296303 ARS$
- GUERRERO - 172900 ARS$
- BETA - 468495 ARS$
- 150 - 10378 ARS$
- SYM - 890000 ARS$
- MOTOMEL - 129796 ARS$
- CAN-AM - 19550 ARS$
- SUPERSOCO - 2875 ARS$
- GALIX - 125686 ARS$
- CFMOTO - 2403000 ARS$
- RVM - 1349000 ARS$
- GALIX - 125686 ARS$
- MOTO GUZZI - 3900000 ARS$
- BAJAJ - 411935 ARS$
- KELLER - 65047 ARS$
- PIAGGIO - 1350000 ARS$
- BENELLI - 974796 ARS$
- PAGANI - 63236 ARS$
- MV AGUSTA - 832250 ARS$
- KEEWAY - 247100 ARS$
- HUSQVARNA - 10323 ARS$
- CRONOS - 489000 ARS$
- ZANELLA - 174785 ARS$
- MOTO - 72490 ARS$
- KIDEN - 228333 ARS$
- VOGE - 595040 ARS$
- CITY COCO - 164990 ARS$
- ROYAL ENFIELD - 7184 ARS$
- SUPER SOCO - 880000 ARS$
- KAWASAKI - 17955 ARS$
- YAMAHA - 432665 ARS$
<br>
-------------------------------------------------------------------------------
- TOTAL DE REGISTROS ANALIZADOS=900
- TOTAL MOTOS ANALIZADAS (SOLO NUEVAS)=813
<br>
-------------------------------------------------------------------------------