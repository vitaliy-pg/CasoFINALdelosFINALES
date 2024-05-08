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

3) Explica las di ferencias entre una pila y una cola. ¿Cuándo conviene utilizar cada 
una de estas estructuras? ¿Cuál es el orden de comple jidad computacional de
estas estructuras? No redacte el orden tal y como puede ver en los apuntes, 
razónelo con sus propias palabras y argumentos.

Pilas:
Una pila es una estructura de datos donde el último elemento que se inserta es el primero en ser retirado (LIFO - Last In, First Out). Esto significa que los elementos se añaden y eliminan desde el mismo extremo, conocido como la cima (top) de la pila. Las operaciones principales en una pila son la inserción de elementos (push), que añade un elemento a la cima de la pila, y la eliminación de elementos (pop), que retira el elemento superior de la pila. Las pilas son útiles en situaciones donde se necesita procesar elementos en orden inverso al que fueron añadidos, como en la gestión de llamadas en la recursión o en el procesamiento de operaciones matemáticas en notación postfija (postfix).

Colas:
Una cola es una estructura de datos donde el primer elemento que se inserta es el primero en ser retirado (FIFO - First In, First Out). Esto significa que los elementos se añaden al final de la cola y se eliminan del principio de la cola. Las operaciones principales en una cola son la inserción de elementos (enqueue), que añade un elemento al final de la cola, y la eliminación de elementos (dequeue), que retira el elemento del principio de la cola. Las colas son útiles en situaciones donde se necesita procesar elementos en el mismo orden en el que fueron añadidos, como en la gestión de tareas en un sistema de gestión de procesos o en la implementación de buffers en la comunicación de datos.

Orden de complejidad computacional:
Tanto para pilas como para colas, las operaciones básicas de inserción y eliminación tienen una complejidad de tiempo constante 
𝑂
(
1
)
O(1). Esto significa que estas operaciones tardan aproximadamente la misma cantidad de tiempo, independientemente del tamaño de la pila o la cola. Aunque algunas implementaciones específicas pueden variar, en general, el orden de complejidad de las operaciones básicas es 
𝑂
(
1
)
O(1).

¿Cuándo conviene utilizar cada una de estas estructuras?

Pila: Se utiliza cuando se necesita un comportamiento LIFO, es decir, cuando es importante procesar elementos en orden inverso al que fueron añadidos. Por ejemplo, en la gestión de llamadas en la recursión o en el procesamiento de operaciones matemáticas en notación postfija.
Cola: Se utiliza cuando se necesita un comportamiento FIFO, es decir, cuando es importante procesar elementos en el mismo orden en el que fueron añadidos. Por ejemplo, en la gestión de tareas en un sistema de gestión de procesos o en la implementación de buffers en la comunicación de datos.

4) Explica el método de ordenación denominado inserción y describe las 
iteraciones sobre el siguiente conjunto de datos:
50 20 84 13 22 16 89 85

Descripción del método de ordenación por inserción:

Comenzamos con la segunda posición de la lista y avanzamos hasta el final.
En cada iteración, tomamos el elemento actual y lo comparamos con los elementos que están a su izquierda en la parte ordenada de la lista.
Mientras el elemento actual sea menor que el elemento a su izquierda, intercambiamos esos elementos.
Continuamos este proceso hasta que el elemento actual sea mayor o igual que el elemento a su izquierda, o hasta que lleguemos al principio de la lista.
Una vez que todos los elementos hayan sido procesados, la lista estará ordenada.
Iteraciones sobre el conjunto de datos dado (50 20 84 13 22 16 89 85):

Iteración 1: Empezamos con el segundo elemento (20). Lo comparamos con el elemento anterior (50) y como es menor, los intercambiamos. La lista ahora es (20 50 84 13 22 16 89 85).

Iteración 2: Continuamos con el tercer elemento (84), lo dejamos en su posición porque es mayor que el elemento anterior (50). La lista sigue siendo (20 50 84 13 22 16 89 85).

Iteración 3: Pasamos al cuarto elemento (13). Lo comparamos con los elementos anteriores y lo vamos moviendo hacia la izquierda hasta que esté en su posición correcta. La lista se convierte en (13 20 50 84 22 16 89 85).

Iteración 4: Avanzamos al quinto elemento (22). Lo comparamos con los elementos anteriores y lo movemos a su posición correcta. La lista ahora es (13 20 22 50 84 16 89 85).

Iteración 5: Procesamos el sexto elemento (16). Lo comparamos y lo movemos a su posición correcta. La lista se convierte en (13 16 20 22 50 84 89 85).

Iteración 6: Continuamos con el séptimo elemento (89), lo dejamos en su posición porque es mayor que el elemento anterior (84). La lista sigue siendo (13 16 20 22 50 84 89 85).

Iteración 7: Finalmente, el octavo elemento (85) está en su posición correcta ya que es mayor que el elemento anterior (84). La lista permanece como (13 16 20 22 50 84 85 89).

5) Dadas dos funciones y su número de operaciones:
A = 1024n
B = 16n 3
Calcular a partir de qué tamaño de entrada n A es más eficiente que B

Función A:
(A = 1024n)
Función B:
(B = 16n^3)
Para encontrar el punto de cruce, igualaremos las dos funciones:

[1024n = 16n^3]

Resolvamos esta ecuación para encontrar el valor de (n):

[16n^3 - 1024n = 0]

Factorizamos:

[16n(n^2 - 64) = 0]

Esto nos da dos soluciones:

(n = 0)
(n^2 - 64 = 0)
Resolvamos la segunda ecuación:

[n^2 - 64 = 0] [n^2 = 64] [n = \pm 8]

Dado que estamos buscando un tamaño de entrada positivo, tomamos (n = 8).

Por lo tanto, a partir de un tamaño de entrada (n = 8), la función (A) es más eficiente que la función (B).

#EJERCICIO 3

Preguntas:
a) ¿Qué imprime el código? En caso de que no compile indique el motivo y arregle el programa 
como considere conveniente. Explique su solución de manera concisa.
b) Explica brevemente qué cálculo está haciendo y qué tipo de recursividad está empleando.

#EJERCICIO 4 

Calcular de forma recursiva la suma de los dígitos de un número siendo un ejemplo el número 102 -> 
1 + 0 + 2 = 3. Recuerde que puede realizar los cambios de tipo que crea necesarios para facilitar la 
resolución:
¿ Qué t ipo de recursividad se está empleando? ¿ Qué comple jidad computacional 
tiene el algoritmo?


Algoritmo Recursivo:
Definiremos una función llamada suma_digitos_recursiva que tomará un número entero como entrada.
Si el número es menor o igual a 9 (un solo dígito), simplemente devolveremos ese número.
De lo contrario, calcularemos la suma de los dígitos recursivamente:
Extraeremos el último dígito del número (módulo 10).
Luego llamaremos a la función recursivamente con el número restante (división entera por 10).
Sumaremos el último dígito extraído con el resultado de la llamada recursiva.
Finalmente, devolveremos la suma total.
Implementación en Python:
Python

def suma_digitos_recursiva(numero):
    if numero <= 9:
        return numero
    else:
        ultimo_digito = numero % 10
        resto_numero = numero // 10
        return ultimo_digito + suma_digitos_recursiva(resto_numero)

 Ejemplo de uso
numero_ejemplo = 102
suma_total = suma_digitos_recursiva(numero_ejemplo)
print(f"La suma de los dígitos de {numero_ejemplo} es: {suma_total}")
Código generado por IA. Revisar y usar cuidadosamente. Más información sobre preguntas frecuentes.
Tipo de Recursividad:
El algoritmo utiliza recursión directa, ya que la función se llama a sí misma directamente.
Complejidad Computacional:
La complejidad computacional de este algoritmo es (O(\log n)), donde (n) es el número de entrada.
Esto se debe a que en cada llamada recursiva, reducimos el tamaño del número en un dígito (división entera por 10).
Por lo tanto, el número de llamadas recursivas es proporcional al número de dígitos en el número de entrada.

#EJERCICIO 5 


Pregunta 1: Modificación de los atributos timeline y tweets

Respuesta:

No es necesario modificar los atributos timeline y tweets de la clase UserAccount para que contengan elementos de la clase hija Retweet. En Java, gracias a la herencia y el polimorfismo, un objeto de una clase derivada (como Retweet) puede ser manejado mediante una referencia de la clase base (Tweet). Por lo tanto, List<Tweet> puede contener tanto objetos Tweet como objetos Retweet sin necesidad de cambios.

Justificación:

Dado que Retweet es una subclase de Tweet, cualquier objeto Retweet es también un Tweet. Así, una lista que almacena objetos Tweet puede almacenar objetos Retweet también. Esto es un ejemplo clásico de polimorfismo, donde una variable de un tipo de superclase puede referenciar a un objeto de una subclase.

Si fuera necesario modificar para otro tipo de operación o necesidad específica (como almacenar atributos adicionales específicos de Retweet no presentes en Tweet), entonces sí habría que considerar ajustes. Pero para los fines de este sistema, como está diseñado actualmente, no es necesario.

Pregunta 2: Modificación del método tweet(Tweet tweet1)

Respuesta:

No es necesario modificar el método tweet(Tweet tweet1) de la clase UserAccount para que pueda enviar también objetos de tipo Retweet. Este método ya puede manejar objetos Retweet porque acepta un parámetro de tipo Tweet, y Retweet es un Tweet debido a la herencia.

Justificación:
El método tweet(Tweet tweet1) fue diseñado para aceptar un objeto Tweet. Gracias al polimorfismo en Java, este método también puede aceptar cualquier objeto de una subclase de Tweet, incluido Retweet. El comportamiento dinámico de Java determinará en tiempo de ejecución si el objeto es un Tweet o un Retweet, y actuará en consecuencia.
