# Spring Boot Invoice System — Sistema de Facturación

Aplicación backend desarrollada con **Spring Boot** que simula un sistema de facturación con clientes, productos e ítems. Demuestra el uso avanzado del contenedor de IoC de Spring, gestión del ciclo de vida de beans y exposición de datos vía API REST.

## Tecnologías y conceptos

- **Lenguaje:** Java 21
- **Framework:** Spring Boot 4.x
- **Build:** Maven
- **Servidor:** Apache Tomcat (embebido)
- **Serialización:** Jackson (JSON)
- **Paradigma:** Programación Orientada a Objetos (POO), Inversión de Control (IoC)

## Habilidades demostradas

- Inyección de dependencias con `@Autowired`, `@Qualifier` y `@Value`
- Gestión del ciclo de vida de beans con `@PostConstruct` y `@PreDestroy`
- Uso de scopes de Spring: `@RequestScope`
- Configuración de beans con `@Configuration` y `@Bean`
- Carga de recursos externos con `ClassPathResource` y `ObjectMapper` (Jackson)
- Lectura de datos desde archivos JSON en tiempo de ejecución
- Construcción de APIs REST con `@RestController` y `@GetMapping`
- Serialización de objetos con Jackson y control de propiedades con `@JsonIgnoreProperties`
- Configuración de propiedades con `@PropertySource`

## Endpoints disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/invoices/show` | Devuelve la factura con cliente, ítems y total |

## Estructura del modelo

```
Invoice
├── Client        (nombre, apellido)
├── List<Item>    (producto, cantidad, importe)
│   └── Product   (nombre, precio)
└── total
```

## Cómo ejecutar

```bash
git clone https://github.com/Lautarovh27/spring-boot-invoice-system.git
cd spring-boot-invoice-system
./mvnw spring-boot:run
```

La app corre en `http://localhost:8080`. Probá el endpoint con Postman o desde el navegador:

```
GET http://localhost:8080/invoices/show
```

## Autor

**Lautaro** — Desarrollador Java Junior  
📎 [GitHub](https://github.com/Lautarovh27) · [LinkedIn](https://www.linkedin.com/in/TU-USUARIO-AQUI)
