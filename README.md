# Implementación de una API REST  

La API REST estará formada por dos recursos que permitirán manipular colecciones de libros y libros respectivamente. 

### Recurso Song ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET |  /books | Devuelve todas los libros de la aplicación.  •	 Es posible ordenar los libros por el género, el año o el autor con el parámetro de query “order”, que acepta los valores “genre”, “-genre”, “year”, “-year”, "author" o "-author". • 	También es posible filtrar los libros devueltos con el parámetro de query “q”, que devuelve aquellas canciones cuyo título, autor, genero o editorial contengan la cadena enviada (ignorando mayúsculas y minúsculas). |
| GET | /books/{bookId}  |  Devuelve el libro con id=bookId. Si el libro no existe devuelve un “404 Not Found”. |
| POST | /books | Añade un nuevo libro cuyos datos se pasan en el cuerpo de la petición en formato JSON (el id se genera automáticamente). Si el nombre del libro no es válido (null o vacío) devuelve un error “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido del libro. |
| PUT | /books  | Actualiza el libro cuyos datos se pasan en el cuerpo de la petición en formato JSON (deben incluir el id del libro). Si el libro no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”. |
| DELETE | /books/{bookId}  |  Elimina el libro con id=bookId. Si el libro no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”.|

Cada **libro** tiene un id, titulo, nombre del autor, genero, año de publicación, valoración, número de páginas y editorial. La representación JSON del recurso es:

```cpp
{
	"id":"s0",
	"title":"Fundamentals of Wavelets",
	"author":"Goswami, Jaideva",
	"genre":"signal_processing",
	"year":"0",
	"rate":"0.",
	"pagnumber":"228",
	"publisher":"Wiley"
}
```


### Recurso Playlist ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET | /bookslists  | Ver todas las listas de libros existentes. •	Es posible ordenar las listas de libros por nombre con el parámetro de query “order”, que solo acepta dos valores, “name” o “-name”. •	También es posible filtrar las listas de libros devueltas con dos parámetros de query: “isEmpty”, que devuelve listas sin libros si vale “true” o listas con libros si vale “false”; “name”, que devuelve las listas cuyo nombre coincida exactamente con el valor del parámetro. |
| GET | /bookslists/{bookslistId} | Devuelve la lista con id=bookslistId. Si la lista de libros no existe devuelve un “404 Not Found”. |
| POST | /bookslists | Añadir una nueva lista de libros. Los datos de la lista (nombre y descripción) se proporcionan en el cuerpo de la petición en formato JSON. Los libros de la lista se pueden incluir aquí opcionalmente. Si el nombre de la lista no es válido (nulo o vacío), devuelve un error “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la lista. |
| PUT | /bookslists | Actualiza la lista cuyos datos se pasan en el cuerpo de la petición en formato JSON (deben incluir el id de la lista).  Si la lista no existe, devuelve un “404 Not Found”. Si se intenta actualizar los libros de la lista, devuelve un error “400 Bad Request”. Para actualizar los libros se debe usar el recurso Book mostrado previamente. Si se realiza correctamente, devuelve “204 No Content”. |
| DELETE | /bookslists/{bookslistId} | Elimina la lista con id=bookslistId. Si la lista no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”. |
| POST |  /bookslists/{bookslistId}/{bookId} | Añade el libro con id=bookId a la lista con id=bookslistId. Si la lista o el libro no existe, devuelve un “404 Not Found”. Si el libro ya está incluido en la lista devuelve un “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la lista. |
| DELETE | /bookslists/{bookslistId}/{bookId}  | Elimina el libro con id=bookId de la lista con id=bookslistId. Si la lista o el libro no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”.|


Una **lista de libros** tiene un _identificador, nombre, descripción y un conjunto de libros_. La representación JSON de este recurso es:

```cpp
{
	"id":"b1",
	"name":"Favourites",
	"description":"A sample booklist",
	"books":[
		{
			"id":"s3",
			"title":"Superfreakonomics",
			"author":"Dubner, Stephen",
			"genre":"economics",
			"year":"0",
			"rate":"0.",
			"pagnumber":"179",
			"publisher":"HarperCollins"
		},

		{			
			"id":"s4",
			"title":"Orientalism",
			"author":"Said, Edward",
			"genre":"history",
			"year":"0",
			"rate":"0.",
			"pagnumber":"197",
			"publisher":"Penguin"
		}
		]
}

```
