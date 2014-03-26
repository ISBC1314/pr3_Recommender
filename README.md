# Practica 3 - Recomendador de viviendas


## Analizar 3 sistemas de recomendacion existentes

###Recomendador Filmaffinity
Recomendador basado en las puntuaciones de tus "almas gemelas".
Las "almas gemelas en filmaffinity" son aquellas que han votado películas en común contigo y su perfíl de películas vistas es muy similar al tuyo.


##### Tipo de producto que recomienda
Recomienda películas para ver que aún no has visto. Señalar que no vende los productos que recomienda. 

##### Técnicas que utiliza y características

 - Es un método de `recomendador de filtrado colaborativo` por ratings de peliculas. 

 - El algoritmo de las almas gemelas devuelve un conjunto de películas recomendadas para ti. La `diversidad de resultados` es alta. 

 - Se puede calibrar el umbral por el cuál encontrar a tus almas gemelas. (Nearest Neighbour - Medidas de similitud) 

 - El recomendador crea un `perfil de usuario`de forma explicita. Ya que el usuario tiene que votar las películas. Así dice que películas ha visto, y cuánto le han gustado. Eso sirve tanto para recomendar al usuario como para recomendar a otros (almas gemelas)

 - Por la `forma de interacción` el recomendador es un single shot ya que no hay ciclos de interacción. Una vez que se muestran las propuestas sobre las películas acaba la recomendación. 

 - La recomendación de películas ofrece la posibilidad de una lista tabú. Se pueden meter las películas en una lista de ignorar recomendación si no quieres que te recomienden una determinada película

##### Ventajas e inconvenientes


- El `filtrado colaborativo` solo tiene en cuenta el rating de otros usuarios para hacer la función de similitud y el filtrado de los usuarios parecidos a ti. Se puede hacer pesado o difícil entoncontrar una película por otros criterios como acción, comedia, histórica, ciencia-ficción, de culto etc. Ya que no se puede buscar explicitamente por estas carasterísticas en el recomendador. Aunque se puede filtrar los resultados por género y décadas 


- No está pensado para explorar películas sin más, como hace el Spoty, por ejemplo. 

###Recomendador de empleo de Job and Talent
Recomendador basado en el perfil de usuario y va aprendiendo de tus preferencias en las ofertas de empleo que marcas como "favoritas" o las descartas porque no te interesan.
Es un método de recomendador basado en la consulta acumulativa.

##### Tipo de producto que recomienda
Recomienda ofertas de trabajo que encajan con tu perfil, lo que buscas y lo que más te gusta.

##### Técnicas que utiliza y características

- Filtrado exacto. (Lo contrario a Nearest Neighbout)

- En un recomendador basado en `perfiles de usuario`
	- Basado en características personales: edad, sexo, zona residencia, estudios cursador, experiencia laboral anterior
	- Basado en sus gustos, preferencias generales,.. Evaluaciones (ratings) hechas sobre los items(ofertas de trabajo). 

**Nota:**  segun la teoría hay dos tipos de recomendador de perfiles de usuario a la hora de construir el perfil

- con elementos explícitos como preguntas directas o escalas sobre gustos,.. o
- con econ elementos implícitos como observación (qué productos mira y durante cuánto tiempo, qué compra,.. elementos explícitos como
preguntas directas o escalas sobre gustos,..

> No conozco el recomendador y no sé cuál usa

>> Yo diría que es de elementos explícitos, pero lo miramos luego, XD

- Por la `forma de interacción de interaccion` el recomendador es ... (**Elegir single shot , conversacional  o mixto entre los dos **) 


##### Ventajas e inconvenientes

###Recomendador de música en Spotify, pestaña Descubrir
Recomendador basado en varios aspectos: Música que escuchan tus "amigos", música que has escuchado y estilos similares, gente que escucha tus artistas los artistas que también escuchan, música que escuchabas y hace tiempo que no lo haces.
Por tanto se trata de un recomendador tanto acumulativo como colaborativo.

##### Tipo de producto que recomienda
Recomienda música, tanto canciones en particular como artistas más en general. También recomienda listas de reproducción de música.

##### Técnicas que utiliza y características

- Es un recomendador basado en `perfiles de usuario con elementos implícitos` como observación (qué productos mira y durante cuánto tiempo, qué compra, qué música escucha, las listas que guarda etc. 

- Las canciones y los artistas tienen ratings eso también se usa a la hora de recomendar. `filtrado colaborativo` 


##### Ventajas e inconvenientes

- Por la `forma de interacción` el recomendador es ... (**Elegir single shot , conversacional o mixto entre los dos **) 


## Diseñar un sistema de recomendacion de viviendas

##### Técnicas de recomendación

Enumerar las técnicas de recomendación que va a usar nuestro recomendador. Necesitamos 3 al menos. Pero lo ideal sería tener 4 o 5 diferentes por lo que han dicho en clase. 
Enumerar también las características del recomendador. 

Las tecnicas de recomentación para el recomendador de viviendas podrían ser:

1. Tecnicas de filtrado de información usando la aproximación basada en contenido, ya que al ser un caso de recomendar una vivienda se haría un formulario donde el usuario pueda elegir aquellos aspectos que desearía que la vivienda tuviera/no tuviera.
	
	La forma de interacción que podríamos elegir es la de Single Shot, es decir, con consulta. Ya que el usuario haría una consulta, el recomendador le propondría una serie de productos y el usuario elige la que le guste o se sale.

2. Otra tecnica distinta podría ser la de antes pero esta vez sin hacer una consulta proponer varias viviendas de varios estilos ya que habrá usuarios que no tengan las ideas tan claras y quieran ver variedad para poder luego elegir.

3. Combinar las dos anteriores.

#### Diseñar la interacción con el sistema.

No sé que quieren en este apartado algún dibujillo o algo supongo. 

##### Diseño interno

Sobre el comportamiento interno del sistema (similitud, filtrado, ..) también se pueden dar ideas del comportamiento (more like this,..)
