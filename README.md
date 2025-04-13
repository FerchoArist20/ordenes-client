# 🛡️ Sistema de Validación para Órdenes en Línea (Spring Boot)

Este proyecto implementa una API REST para procesar órdenes en línea de forma segura, utilizando el **patrón de diseño Chain of Responsibility** para aplicar múltiples validaciones antes de aceptar una orden.

---

## ✅ Funcionalidad

La API permite recibir solicitudes de creación de órdenes y valida cada una de ellas a través de una cadena de verificaciones:

1. **Autenticación** del usuario
2. **Prevención de ataques por fuerza bruta** (bloqueo de IPs)
3. **Autorización** (solo administradores pueden continuar)
4. **Sanitización de datos** para evitar ataques como XSS o SQL injection
5. **Respuesta desde caché** si la orden fue previamente procesada

---

## 📦 Tecnologías usadas

- Java 17
- Spring Boot 3.4.4
- Maven
- Lombok
- SLF4J (Logs)
- Postman / Thunder Client para pruebas

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/FerchoArist20/ordenes-client.git
   cd ordenes-client
   ```

2. Ejecuta con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

3. El servidor arrancará en:
   ```
   http://localhost:8080
   ```

---

## 📬 Endpoint disponible

### `POST /api/orders`

Crea una orden luego de pasar por todas las validaciones.

#### 🧾 Cuerpo de la solicitud (`application/json`)
```json
{
  "user": "user123",
  "credentials": "pass123",
  "data": "Compra de item <script>alert(1)</script>",
  "ip": "192.168.1.10",
  "isAdmin": true
}
```

#### ✅ Respuesta exitosa:
```json
{
  "success": true,
  "message": "Orden procesada exitosamente"
}
```

#### ❌ Respuesta fallida:
```json
{
  "success": false,
  "message": "Orden rechazada"
}
```

## ✨ Posibles mejoras

- Uso de JWT para autenticación segura
- Persistencia en base de datos de órdenes
- Manejo avanzado de caché (Redis)
- Frontend para el consumo del API
- Dockerización para despliegue

---

## 🧑‍💻 Autor

Desarrollado por Luis Fernando Aristizabal Ramirez - Proyecto académico de diseño de software flexible y reusable.

---
