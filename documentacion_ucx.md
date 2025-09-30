Caso de Uso UC1: Realizar Pedido

Actor Principal: Cliente

Actores involucrados e intereses:
- Cliente: Quiere realizar un pedido de recolección de material reciclable
- Sistema Geolocalización: Validar ruta hacia ubicación de cliente

Precondiciones: Ninguna

Postcondiciones: Se registra un pedido en el sistema

Escenario principal de exito: //pasos poscondicion
    1. El cliente realiza el pedido 
    2. El cliente entrega sus datos
    3. El cliente entrega su ubicacion
    4. El caso de uso: Validar ubicación. Valida correctamente la ubicación del cliente
    5. Se envía la notificación al sistema sobre el pedido
    6. Se registra un pedido en el sistema

Extensiones (Flujos Alternativos):
    Paso 2 - Faltan datos
    - Se pide realizar el pedido de nuevo
    Paso 3 - Falta la ubicacion
    - Se pide realizar el pedido de nuevo
    Paso 4 - No se valida correctamente la ubicacion
    - Se cancela el pedido
    Paso 4' - No se valida correctamente la ubicacion
    - Se pide otra ubicacion
 

Caso de Uso UC2: Validar ubicación

Actor Principal: Sistema de geolocalización

Actores involucrados e intereses:
- CLiente: quiere validar su ubicación 
- Sistema de geolocalización: valida la ubicacíon entregada por el cliente

Precondiciones: Ninguna

Postcondiciones: El punto de recolección es valido para el sistema y se buscara el reciclaje en esa ubicación

Escenario principal de exito:
    1. El sistema geolocalizador valida correctamente la ubicación del cliente
    2. Se prepara la notificación sobre el estado del pedido

Extensiones (Flujos Alternativos):
    Paso 1 - No es valida la ubicación
    - Se pide una nueva ubicación
    Paso 1' - No se valida correctamente la ubicaión
    - Se cancela el pedido
    Paso 2 - La notificación no se manda
    - Se actualiza el estado de la ubicación y se manda otra notificación

