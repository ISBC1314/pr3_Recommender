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

- Es un recomendador basado en `perfiles de usuario`
	- Basado en características personales: edad, sexo, zona residencia, estudios cursador, experiencia laboral anterior
	- Basado en sus gustos, preferencias generales que son en su mayoría evaluaciones (ratings) hechas sobre las ofertas de trabajo.

- Dentro de recomendador de perfiles de usuario, este tipo de `recomendador explicito`, puesto que está basado en las respuestas directas que el usuario hace una seleccion de las ofertas como favoritas o descartadas. Sin embargo también tiene elementos de `recomendador implícito` puesto que una vez hecho el perfil el recomendador va aprendiendo de las ofertas que marcas como favoritas o descartadas, aunque no te envía otras recomendaciones diferentes.  

- Por la `forma de interacción de interaccion` el recomendador es se considera `single-shot`, puesto que en base al formulario que rellenas con tu curriculum te envían las ofertas de trabajo.

##### Ventajas e inconvenientes

Lo positivo de la recomendación `single shot` es que para este caso, no te satura con ofertas de trabajo que realmente no te interesan. Por otro lado, no condiciona mucho tu perfil, y para obtener otro tipo de ofertas tendrías que buscarlas a través del buscador.


###Recomendador de música en Spotify, pestaña Descubrir
Recomendador basado en varios aspectos: Música que escuchan tus "amigos", música que has escuchado y estilos similares, gente que escucha tus artistas los artistas que también escuchan, música que escuchabas y hace tiempo que no lo haces.
Por tanto se trata de un recomendador tanto acumulativo como colaborativo.

##### Tipo de producto que recomienda
Recomienda música, tanto canciones en particular como artistas más en general. También recomienda listas de reproducción de música.

##### Técnicas que utiliza y características

- Es un recomendador basado en `perfiles de usuario con elementos implícitos` como observación (qué productos mira y durante cuánto tiempo, qué compra, qué música escucha, las listas que guarda etc. 

- Las canciones y los artistas tienen ratings eso también se usa a la hora de recomendar. `filtrado colaborativo` 

- Por la `forma de interacción` el recomendador es ... (**Elegir single shot , conversacional o mixto entre los dos **) 

>Yo diría que es conversacional, similar al de filmaffinity, porque te recomienda en base a lo que el cree sin preguntarte ni nada.


##### Ventajas e inconvenientes


## Diseñar un sistema de recomendacion de viviendas

#### Técnicas de recomendación

Enumerar las técnicas de recomendación que va a usar nuestro recomendador. Necesitamos 3 al menos. Pero lo ideal sería tener 4 o 5 diferentes por lo que han dicho en clase. 
Enumerar también las características del recomendador. 

Las técnicas de recomendación para el recomendador de viviendas podrían ser:

1. Técnicas de filtrado de información usando la aproximación basada en contenido, ya que al ser un caso de recomendar una vivienda se haría un formulario donde el usuario pueda elegir aquellos aspectos que desearía que la vivienda tuviera/no tuviera.
	
	La forma de interacción que podríamos elegir es la de Single Shot, es decir, con consulta. Ya que el usuario haría una consulta, el recomendador le propondría una serie de productos y el usuario elige la que le guste o se sale.

2. Otra técnica distinta podría ser la de antes pero esta vez sin hacer una consulta proponer varias viviendas de varios estilos ya que habrá usuarios que no tengan las ideas tan claras y quieran ver variedad para poder luego elegir.

3. Combinar las dos anteriores.

4. Creo que deberíamos descartar el filtrado colaborativo. Las casas no sé pueden recomendar como se recomiendan pelis o libros porque las casas son solo para una persona. (que la compra o alquila) no se pueden compartir ni recomendar. 

5. Quizás podríamos hacer un perfil de usuario, donde guardásemos cosas generales com ola ciudad donde quiere buscar la vivienda y el rango de precios donde la quiere. Todo muy general nada particular pero así no tendría que poner esos datos cada vez que haga la consulta. Y en ese perfil de usuario podriamos guardar las casas vistas anteriormente o una seccion de casas favoritas que nos ayudaria a aprender de los gustos del comprador.  

>Por mi experiencia buscando viviendas, pondría un formulario base (lugar, tipo, y precio) A partir de ese formulario mostraría recomendaciones que se ajusten a esas 3 características básicas de distintos estilos el método de proponer y criticar, empezar a "filtrar" esos resultados. 
>>En cierto sentido podría "aprender" en el sentido, si he visto que ha visto 5 viviendas y de ellas 4 tenían terraza, vamos a priorizar que tenga terraza.
>>También estaría guay, recomendar viviendas lo típico de "por 50€ más tambien tiene esto", para así fomentar una compra..., es decir, relajar el criterio del precio si observas que lo que le ofreces al usuario le va a gustar
>>Lo del conocimiento de otros usuarios no me gusta nada!!!!
>>>> Lo de aprender cosas como que le gusta la terraza porque ha visto algunas con terraza me gusta. Voto por ponerlo

#### Diseñar la interacción con el sistema.

No sé que quieren en este apartado algún dibujillo o algo supongo. 
>En que parte del guión ponen este punto?
>> En las trasparencias está el enunciado y los puntos que hay que rellenar y como lo quieren y eso. He sacado estas secciones de las traspas 

#### Diseño interno

Sobre el comportamiento interno del sistema (similitud, filtrado, ..) también se pueden dar ideas del comportamiento (more like this,..)
