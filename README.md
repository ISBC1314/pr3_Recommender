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

El sistema se iniciará con una primer formulario con 2 campos principales, lugar y precio de la vivienda, a partir de ahí el sistema recomendará una serie de viviendas que se ajusten a esas carácterísticas.
Una vez mostradas estas viviendas, el usuario tendrá la opcion de:
1. seleccionar aquellas que más le gusten, y el recomendador propondrá más viviendas en referencia a esas mediante el metodo proposing
2. establecer mas filtros a esa busqueda, y el recomendador porpondrá más viviendas que se ajusten a dichos filtros

Por tanto, las tecnicas que vamos a utilizar son las siguientes:

1. Tecnica conversacional
2. Tecnica filtering
3. Tecnica filling
4. Tecnica proposing

También nos planteamos añadir más técnicas al diseño para optimizarlo, en caso de que nos den tiempo a desarrollarlas:
- Añadir un lista tabu con aquellas viviendas que el usuario ya ha seleccionado que no le gustan, por tanto no se volverían a mostrar.
- Aplicar una funcion de similitud con consultas anteriores, para así recomendar las viviendas que más se ajusten a la persona que está buscando
- Aprender de la sesion del usuario, para así recomendar viviendas que más se ajusten a las viviendas que el usuario a marcado como sus favoritas. En este caso guardaría informacion de las características de las viviendas que el usuario ha visitado y no ha descartado, para así fijarse en que características le gusta al usuario en una vivienda y priorizar viviendas con estas características sobre otras que  no las tengan.
- Relajacion de algún parámetro de consulta, como el precio, si se ajusta mucho más a lo que busca el usuario.

Por tanto, las posibles tecnicas a añadir al diseño ya descrito son las siguientes: 

1. Lista tabu
2. similitud
3. Aprender de la sesion
4. Relajar filtros

La conversación con el sistema terminará cuando el usuario cierre la sesión o seleccione una vivienda para quedarsela.

No pretendemos guardar información del perfil de usuario, puesto que un mismo usuario, podría querer realizar diversas búsquedas y a la vez dispares entre sí
	

#### Diseñar la interacción con el sistema.

>Aquí meteis luego el dibujito =D.

#### Diseño interno

> Creo que más o menos lo he redactado arriba
Sobre el comportamiento interno del sistema (similitud, filtrado, ..) también se pueden dar ideas del comportamiento (more like this,..)
