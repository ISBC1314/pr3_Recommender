# Practica 3 - Recomendador de viviendas


## Analizar 3 sistemas de recomendacion existentes

###Recomendador filmaffinity
Recomendador basado en las puntuaciones de tus "almas gemelas".
Las "almas gemelas en filmaffinity" son aquellas que ha votado películas en común contigo y su perfíl de películas vistas es muy similar al tuyo.


##### Tipo de producto que recomienda
Recomienda películas para ver que aún no has visto. Señalar que no vende los productos de recomienda. 

##### Técnicas que utiliza

 - Es un método de recomendador colaborativo por ratings de productos. 
 - No es single shot. 
 - Se puede calibrar el umbral por el cuál encontrar a tus almas gemelas. (Nearest Neighbour - Medidas de similitud) 

##### Ventajas e inconvenientes

- Está fuertemente orientado a `recomendadores colaborativos+`, por lo que se puede hacer pesado, o difícil entontrar una película por tema (umm... pero se puede filtrar los resultado por género y décadas). Es decir por acción, comedia, histórica, ciencia-ficción, de culto etc. 

- No está pensado para explorar películas sin más, como hace el Spoty, por ejemplo. 

- El recomendador crea un `perfil de usuario`de forma explicita. Ya que el usuario tiene que votar las películas. Así dice que películas ha visto, y cuánto le han gustado. Eso sirve tanto para recomendar al usuario como para recomendar a otros (almas gemelas)

###Recomendador de empleo de job and talent
Recomendador basado en el perfil de usuario y va aprendiendo de tus preferencias en las ofertas de empleo que marcas como "favoritas" o las descartas porque no te interesan.
Es un método de recomendador basado en la consulta acumulativa.

##### Tipo de producto que recomienda
Recomienda ofertas de trabajo que encajan con tu perfil, lo que buscas y lo que más te gusta.

##### Técnicas que utiliza
- Filtrado exacto. (Lo contrario a Nearest Neighbout)

- En un recomendador basado en `pérfiles de usuario`
	- Basado en características personales: edad, sexo, zona residencia, estudios cursador, experiencia laboral anterior
	- Basado en sus gustos, preferencias generales,.. Evaluaciones (ratings) hechas sobre los items(ofertas de trabajo). 

**Nota:**  segun la teoría hay dos tipos de recomendador de perfiles de usuario a la hora de construir el perfil

- con elementos explícitos como preguntas directas o escalas sobregustos,.. o
- con econ elementos implícitos como observación (qué productos mira y durante cuánto tiempo, qué compra,..e lementos explícitos como
preguntas directas o escalas sobre gustos,.. o 

No conozco el recomendador y no sé cuál usa

Yo diría que es de elementos explícitos, pero lo miramos luego, XD

##### Ventajas e inconvenientes



###Recomendador de música en Spotify, pestaña Descubrir
Recomendor basado en varios aspectos: Música que escuchan tus "amigos", música que has escuchado y estilos similares, gente que escucha tus artistas los artistas que también escuchan, música que escuchabas y hace tiempo que no lo haces.
Por tanto se trata de un recomendador tanto acumulativo como colaborativo.

##### Tipo de producto que recomienda
Recomienda música, tanto canciones en particular como artistas más en general

##### Técnicas que utiliza

- Es un recomendador basado en pérfiles de usuario con econ `elementos implícitos` como observación (qué productos mira y durante cuánto tiempo, qué compra, qué música escucha, las listas que guarda etc. 

- Las canciones y los artistas tienen ratings. 


##### Ventajas e inconvenientes


## Diseñar un sistema de recomendacion de viviendas
