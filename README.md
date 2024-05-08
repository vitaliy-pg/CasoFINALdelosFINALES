#CASO FINAL DE LOS FINALES.

Si quieres acceder a mi repositorio click aqui:

#EJERCICIO 1:


1) En relación al estado de un objeto, para preservar el principio de encapsulación:

b) Debemos establecer la visibilidad más restrictiva (por ejemplo, privada) en los atributos 
de una clase. Así, cualquier software que utilice nuestro objeto, sólo accederá al 
estado de los objetos mediante los métodos que le hayamos permitido utilizar.

2) Los métodos de una clase no pueden devolver objetos:

b) Falso

3) ¿Cuál de las siguientes características de la programación orientada a objetos está 
relacionada con la reutilización de código?

b) Herencia

4) El tiempo de acceso a un dato en una lista de tipo LinkedList es en el mejor de los casos de:

b) O(1)

5) Un algoritmo de ordenación que implemente el método de inserción se basa en la idea de ir 
seleccionando el número correspondiente en la lista desordenada que se va a insertar en la 
posición última de la lista ordenada:

b) Falso

#EJERCICIO 2 (PREGUNTAS 2,3,4,5)

2) Explica las diferencias entre una tabla Hash y un árbol. ¿ Cuándo conviene utilizar 
cada una de estas estructuras? Justifique su respuesta y analice todas las 
posibles operaciones a realizar por las estructuras. No redacte el orden tal y 
como puede ver en los apuntes, razónelo con sus propias palabras y argumentos:

Tabla Hash:
Una tabla hash es una estructura de datos que utiliza una función hash para mapear claves a valores. Esta función convierte las claves en índices de un arreglo, donde se almacenan los valores correspondientes. La principal ventaja de una tabla hash es su rapidez en la búsqueda, inserción y eliminación de elementos, ya que el acceso a un elemento se realiza en tiempo constante, en promedio. Sin embargo, las tablas hash pueden sufrir de colisiones, lo que ocurre cuando dos claves distintas tienen el mismo valor hash y se almacenan en el mismo índice del arreglo. Para resolver esto, se utilizan técnicas como el encadenamiento o la resolución de colisiones mediante sondas. Las operaciones principales en una tabla hash incluyen la inserción de elementos, la eliminación de elementos y la búsqueda de elementos por clave.

Árbol:
Un árbol es una estructura de datos jerárquica que consta de nodos conectados entre sí mediante aristas. Cada nodo tiene un valor y cero o más nodos hijos. Los árboles se pueden implementar de diversas formas, como árboles binarios de búsqueda, árboles AVL, árboles rojo-negro, entre otros. La principal ventaja de los árboles es su capacidad para mantener los elementos ordenados de manera eficiente. Esto permite realizar operaciones como búsqueda, inserción y eliminación en tiempo logarítmico en el peor de los casos. Los árboles también pueden ofrecer otras características útiles, como el recorrido en orden, el recorrido en preorden y el recorrido en postorden, que permiten procesar los elementos en diferentes secuencias. Las operaciones principales en un árbol incluyen la inserción de elementos, la eliminación de elementos, la búsqueda de elementos por valor y el recorrido de los elementos.

¿Cuándo conviene utilizar cada una de estas estructuras?

Tabla Hash: Se suele utilizar cuando se necesita una búsqueda rápida de elementos y el orden de los elementos no es importante. Por ejemplo, en la implementación de tablas de dispersión, en el manejo de tablas de símbolos en compiladores o en la implementación de caches.
Árbol: Se utiliza cuando se necesita mantener los elementos ordenados y realizar operaciones eficientes de búsqueda, inserción y eliminación en un conjunto de datos ordenados. Por ejemplo, en la implementación de árboles de búsqueda binaria para diccionarios, en bases de datos para la indexación de registros o en sistemas de archivos para organizar directorios y archivos.


