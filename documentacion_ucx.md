Caso de Uso UCX: Realizar Pedido
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
    4. El sistema geolocalizador valida correctamente la ubicación del cliente
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
    4.
    5.


Caso de Uso UCX: Generar Ruta Eficiente
Actor Principal:
Actores involucrados e intereses:
Precondiciones:
Postcondiciones:
Escenario principal de exito:
    1.
    2.  
Extensiones (Flujos Alternativos):
