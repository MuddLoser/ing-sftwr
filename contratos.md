Nombre: IniciarPedido()
Responsabilidades: Iniciar la petición de recolección de material.
Referencias: Caso de uso: Realizar pedido
Notas: --
Excepciones: --
Salida: --
Precondiciones: --
Postcondiciones: 
* Inicia un pedido
* Genera un ID de pedido

Nombre: IngresarDatos(nombre:string, edad:entero, telefono:string)
Responsabilidades: Registra los datos del usuario necesitados para confirmación del pedido.
Referencias: Caso de uso: Realizar pedido
Notas: Utiliza acceso a la base de datos
Excepciones: --
Salida: nombre, edad, telefono
Precondiciones: Que se haya iniciado un pedido, que el pedido tenga un ID valido
Postcondiciones:
* Se crea un Cliente
* Se asocia el Cliente al pedido
* Se guarda la información de contacto

Nombre: IngresarUbicacion(calle:string, comuna:string, region:string, casa:string)
Responsabilidades: Registrar los datos de la ubicación del Cliente para usarse en la creación de rutas.
Referencias: Caso de uso: Realizar pedido
Notas:
* Utiliza acceso a la base de datos (??)
* Se llama de nuevo si la ubicación no es válida
Excepciones:--
Salida: calle, comuna, region, casa
Precondiciones:
* Que se haya iniciado un pedido
* Que el pedido tenga un ID valido
* Que haya un Cliente asociado al pedido
Postcondiciones:
* Se envian los datos a ValidarUbicacion()