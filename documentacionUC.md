Caso de Uso UC1: Ingresar ubicación

Actor Principal: Cliente

Actores involucrados e intereses:
- Cliente: Quiere realizar un pedido de recolección de material reciclable y debe ingresar ubicacion del pedido
- Sistema Geolocalización: Validar ruta hacia ubicación de cliente

Precondiciones: Iniciar la realización del pedido y haber dado los datos y descripcion del mismo

Postcondiciones: Se registra un pedido exitosamente en el sistema

Escenario principal de exito: //pasos poscondicion

    1. El cliente realiza el pedido
    2. El cliente entrega sus datos
    3. El cliente describe el pedido
    3. El cliente ingresa su ubicacion
    4. El caso de uso: Validar ubicación. Valida correctamente la ubicación del cliente
    5. Se registra un pedido en el sistema

Extensiones (Flujos Alternativos):

    Paso 2 - Faltan datos
    - Se pide realizar el pedido de nuevo
    Paso 3 - Falta la ubicación
    - Se pide realizar el pedido de nuevo
    Paso 4 - No se valida correctamente la ubicación
    - Se cancela el pedido
    Paso 4' - No se valida correctamente la ubicación
    - Se pide otra ubicacion
 

Caso de Uso UC2: Validar ubicación

Actor Principal: Sistema de geolocalización

Actores involucrados e intereses:
- Cliente: quiere validar su ubicación 
- Sistema de geolocalización: valida la ubicación entregada por el cliente

Precondiciones: Ninguna

Postcondiciones: El punto de recolección es válido para el sistema y se buscará el pedido en esa ubicación

Escenario principal de exito:

    1. El sistema geolocalizador valida correctamente la ubicación del cliente

Extensiones (Flujos Alternativos):

    Paso 1 - No es valida la ubicación
    - Se pide una nueva ubicación
    Paso 1' - No se valida correctamente la ubicación
