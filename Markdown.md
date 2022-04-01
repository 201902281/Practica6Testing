En esta práctica he realizado varios tests unitarios a los métodos de la clase Teléfono y DNI.
Adicionalmente, he realizado varios tests E2E a dos métodos POST de la clase ProcessControler.

Para la clase DNI en primer lugar he comprobado, presentando varios DNI de mi entorno, que el método validarDNI devolviese un true siempre y cuando los dni presentados fuesen correctos.
En segundo lugar he comprobado que el método devolviese un false para dos situaciones. En primer lugar, con aquellos dnis que no pueden existir fuesen considerados como tal, y en segundo lugar con aquellos dnis cuyo formato no fuese el establecido (debido a su longitud, caracteres no pertenecientes al alfabeto...).

Para la clase Teléfono he comprobado su método validar teléfono para dos situaciones. En la primera introduje teléfonos correctos además de validar un con la extension de un país, en este caso comprobaba que la función devolviese un true. En la segunda situación seguí el mismo procedimiento que para la clase DNI, comprobando casos erroneos donde probaba diferentes situaciones que no cumpliesen con el formato establecido (longitud, caracteres, signos...).

Dentro de los test E2E realizados, para cada método he realizado dos tests distintos. 
En ambos casos, con el fin de comrpobar ambos métodos POST, me cree unos parámetros de entrada para poder ejecutar el método. Una vez los datos cumpliesen el formato y el programa me permitiese ejecutar las peticiones, analicé tanto el status de la respuesta a la petición como el mensaje devuelto por el método.
Para ambos casos hice dos tests diferentes, donde en el primero comprobaba la respuesta a la petición con los parámetros de entrada correctos (he considerado no realizar un test de nuevo para los métodos de validación porque ya se hizo en el apartado anterior de la práctica). Y en el segundo caso varié los parámetros de entrada para comprobabar que la respuesta a los métodos era la correcta cuando los parámetros de entrada eran incorrectos. En todos los casos también se evaluó el estatus http de la respuesta.  

