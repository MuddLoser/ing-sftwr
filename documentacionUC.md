Caso de Uso UC1: Ingresar ubicación

Actor Principal: Cliente

Actores involucrados e intereses:
- Cliente: Quiere realizar un pedido de recolección de material reciclable y debe ingresar ubicacion del pedido
- Sistema Geolocalización: Validar ruta hacia ubicación de cliente

Precondiciones: El cliente ha iniciado el proceso de creación del pedido.
El cliente ya ingresó sus datos personales y la descripción del pedido.

Postcondiciones: El sistema registra la ubicación válida del pedido y se registra un pedido exitosamente

Escenario principal de exito:

    1. El cliente selecciona la opción “Ingresar ubicación”.
    2. El sistema solicita al cliente los datos de ubicación.
    3. El cliente ingresa la ubicación del pedido.
    4. El sistema ejecuta el include UC2: Validar ubicación.
    5. La ubicación es validada correctamente por el sistema de geolocalización.
    6. El sistema registra la ubicación ingresada como parte del pedido.
    7. Se registra un pedido en el sistema

Extensiones (Flujos Alternativos):

    Paso 3 - Falta la ubicación (dirección incompleta o vacía)
    -  El sistema solicita ingresar nuevamente los datos de ubicación.
    Paso 4 - El sistema de geolocalización indica que la ubicación no es válida.
    - El sistema informa al cliente que la ubicación es inválida.
    - El sistema solicita una nueva ubicación.
    - El cliente puede cancelar o intentar de nuevo.
    - El flujo vuelve al paso 3
    Paso 4' - El servicio de geolocalización no responde o entrega un error.
    - El sistema informa al cliente que no se pudo validar la ubicación.
    - El cliente puede cancelar o intentar de nuevo.
    - El flujo vuelve a paso 3

Caso de Uso UC2: Validar ubicación

Actor Principal: Sistema de geolocalización

Actores involucrados e intereses:
- Cliente: quiere validar su ubicación 
- Sistema de geolocalización: valida la ubicación entregada por el cliente

Precondiciones: El cliente ha ingresado una ubicación.

Postcondiciones: El punto de recolección es válido para el sistema.

Escenario principal de exito:

    1. El sistema envía la ubicación al Sistema de Geolocalización.
    2. El sistema de geolocalización valida correctamente la ubicación.
    3. El sistema informa al caso de uso anterior (UC1) que la ubicación es válida.

Extensiones (Flujos Alternativos):

    Paso 2 - El servicio de geolocalización determina que la ubicación no existe, está fuera de la zona o es incorrecta.
    - El sistema marca la ubicación como inválida.
    - El flujo retorna a UC1 para solicitar una nueva ubicación.
    Paso 2' - El sistema de geolocalización no responde o entrega un error.
    - El sistema marca la validación como fallida.
    - El flujo retorna a UC1 indicando “Error al validar ubicación”.

