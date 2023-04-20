# StackTracer
Algoritmo que resuleve laberintos
Esta solución está compuesta por dos clases, una que contiene una pila la cual tiene una clase privada llamada nodo que almacena coordenadas en forma de Strings
La segunda clase es dónde creamos la lógica del algoritmo, el laberinto y la interfaz del laberinto, el laberinto está hecho por dos arreglos, uno de una dimensión
que se llama celda para simplificar el llenado del segundo arreglo que es el que vamos a usar, que es el de coordenadas, el cual es un arreglo de dos dimensiones
que contiene coordenadas y cada coordenada contiene un valor el cual puede ser 0, el cual es considerado un camino, el 1, el cual es un muro y el 2, el cual es
el punto de inicio.

A partir del arreglo de coordenadas, empezamos a crear otro arreglo de dos dimensiones para la creación de la interfaz del laberinto, este arreglo contiene una
etiqueta JLabel por cada espacio y dependiendo el valor en coordenadas[x][y], se va a poner el fondo de la etiqueta de un color o de otro, así distinguiendo los 
colores de lo que es un muro, el punto de inicio, el "jugador" y el camino.

Tenemos también la clase StackTracer la cual pide unas coordenadas iniciales, las cuales serán las del punto de partida, y tiene un método el cual suma en uno 
a sus coordenadas actuales dependiendo la entrada de dos números enteros para poder realizar un movimiento, a partir de este método se crearon otros 4 
métodos que indican una dirección especificamente. Esta clase se usará para crear un "jugador" mediante un objeto de la misma clase.

El panel en el que está la interfaz del laberinto tiene un escucha del teclado para que se pueda manejar al "jugador" por el laberinto con las teclas w, a, s y d,
pero también se tiene en el escucha que al presionar la tecla "espacio" en el punto que se encuentre, el "jugador", de manera automática empiece a resolver el laberinto.
La manera en que resuleve el laberinto es intentando ir en las 4 direcciones hasta llegar a un borde, que al intentar salir, genera una excepción, pero al atrapar la
excepción con un try-catch podemos indicar que se ha llegado al final del laberinto, en caso de que se encuentre en un callejón sin salida, le asignará a la casilla
en la que se encuentra un número para indicar que no puede pasar por ese lugar, como si colocara un muro en esa casilla, para poder realizar un pop en la pila
que contiene unas coordenadas anteriores y poder ir a una posición anterior.
