# Control de Gastos Personales

Este proyecto es una aplicación de control de gastos personales, donde los usuarios pueden gestionar sus ingresos y gastos, ver un resumen de sus transacciones y calcular su balance total. El sistema permite crear, editar, eliminar usuarios, así como registrar transacciones para cada uno de ellos.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 2.x**
- **Thymeleaf** (para renderizado del lado del servidor)
- **Bootstrap 5** (para el diseño de la interfaz)
- **Chart.js** (para gráficos)
- **MySql Database** (base de datos en memoria para desarrollo)

## Características

- **Gestión de usuarios**:
  - Crear nuevos usuarios
  - Editar y eliminar usuarios
  - Ver la lista de usuarios registrados

- **Gestión de transacciones**:
  - Registrar transacciones con descripción, tipo (ingreso o gasto), monto y fecha.
  - Ver todas las transacciones de un usuario.
  - Calcular el balance total de un usuario.

- **Gráficos interactivos**:
  - Visualización de transacciones en gráficos de barras, con ingresos y gastos desglosados.

## Endpoints

- `GET /usuarios`: Listar usuarios registrados.
- `POST /usuarios/guardar`: Crear un nuevo usuario.
- `GET /usuarios/nuevo`: Mostrar formulario de creación de usuario.
- `GET /usuarios/editar/{id}`: Mostrar formulario de edición de usuario.
- `DELETE /usuarios/eliminar/{usuarioId}`: Eliminar un usuario.
- `GET /transacciones/{usuarioId}`: Ver las transacciones de un usuario.
- `POST /transacciones/guardar`: Registrar una nueva transacción.
- `GET /transacciones/nueva`: Formulario para crear una nueva transacción.
- `GET /transacciones/balance/{usuarioId}`: Ver el balance total de un usuario.
