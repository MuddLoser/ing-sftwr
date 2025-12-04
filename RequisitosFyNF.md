Requisitos funcionales

RF1 – Registro y autenticación de cliente

RF1.1 El sistema debe permitir el registro de un usuario tipo Cliente, solicitando: nombre, teléfono, correo y dirección.

RF1.2 El sistema debe permitir el ingreso manual de una nueva dirección o ubicación.

RF1.3 El sistema debe permitir el reingreso a la cuenta mediante validación por mensaje enviado al correo electrónico del cliente.

RF2 – Gestión de pedidos

RF2.1 El sistema debe permitir al cliente realizar un pedido indicando: tipo de material, cantidad estimada y hora preferida de reciclaje.

RF2.2 El sistema debe permitir al cliente cancelar un pedido antes de que sea asignado a un recolector.

RF3 – Validación de ubicación

RF3.1 El sistema debe validar la ubicación ingresada por el cliente mediante un servicio externo de geolocalización.

RF3.2 El sistema debe permitir al cliente reingresar una ubicación cuando esta sea inválida.

RF4 – Gestión de rutas por zona

RF4.1 El sistema debe agrupar automáticamente los pedidos correspondientes a una misma zona administrada por un jefe de zona.

RF4.2 El sistema debe generar una ruta óptima para los pedidos asociados a esa zona.

RF4.3 El sistema debe notificar al jefe de zona cuando un pedido sea cancelado, con el fin de actualizar o recalcular la ruta.

RF5 – Interacción del recolector

RF5.1 El sistema debe permitir al recolector indicar su llegada al destino del cliente durante la ruta asignada.

RF6 – Comprobantes

RF6.1 El sistema debe generar un comprobante digital una vez finalizada la recolección.

RF6.2 El sistema debe permitir al cliente descargar el comprobante digital.

RF7 – Notificaciones

RF7.1 El sistema debe enviar una notificación al cliente cuando el pedido esté aceptado o asignado.

RF7.2 El sistema debe enviar una notificación cuando existan retrasos o cancelaciones asociadas al pedido.

RF8 – Coordinación de entrega

RF8.1 El sistema debe permitir coordinar la entrega entre el cliente y el jefe de zona mediante una hora agendada o acordada.

Requisitos no funcionales

RNF1 – Conectividad

RNF1.1 El sistema debe funcionar únicamente con una conexión estable a Internet para registrar pedidos, validarlos y generar rutas.

RNF1.2 El sistema debe tolerar breves interrupciones de conexión y reintentar la sincronización automáticamente al restablecerse la red.

RNF2 – Seguridad

RNF2.1 El sistema debe garantizar la confidencialidad de los datos de los clientes mediante cifrado de información.

RNF2.2 El sistema debe restringir los accesos según el rol del usuario (Cliente, Recolector, Jefe de Zona).

RNF3 – Disponibilidad

RNF3.1 El sistema debe estar disponible durante el horario de oficina para permitir el registro y organización de pedidos.

RNF4 – Usabilidad

RNF4.1 El sistema debe ser accesible desde computadoras sin necesidad de instalar aplicaciones adicionales.

RNF5 – Compatibilidad

RNF5.1 El sistema debe ser compatible con navegadores modernos como Google Chrome, Mozilla Firefox y Microsoft Edge.

RNF5.2 La interfaz debe adaptarse correctamente a distintos tamaños de pantalla.

RNF6 – Mantenibilidad

RNF6.1 El sistema debe permitir la actualización de funcionalidades sin interrumpir su operación diaria.



