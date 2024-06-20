## JWT

Permite la transferencia de datos entre dos partes

## Funcionamiento

1. El cliente envia una peticion al endpoint (/api/login)
2. Servidor valida las credenciales (usuario y contrasenia), so no son correctos regresa una respuesta 401 (Unauthorized)
3. Si las credenciales son correctar, el servidor genera un token JWT utiliza una secret key