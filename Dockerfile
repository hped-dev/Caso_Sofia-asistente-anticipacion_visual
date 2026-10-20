# ==========================================
# Etapa 1: Compilación (Build Stage)
# ==========================================
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

WORKDIR /build

# Copiar configuración de dependencias para cachear capas de Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B || true

# Copiar código fuente y compilar empaquetando en JAR
COPY src ./src
RUN mvn clean package -DskipTests

# ==========================================
# Etapa 2: Imagen final de ejecución (Runtime)
# ==========================================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Crear usuario y grupo sin privilegios de root por seguridad
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copiar el artefacto empaquetado desde la etapa de compilación
COPY --from=builder /build/target/*.jar app.jar
RUN chown -R appuser:appgroup /app

USER appuser

# Variable de entorno de puerto (sobreescribible por plataformas como Render)
ENV PORT=8080
EXPOSE 8080

# Optimización de JVM para contenedores en capas gratuitas (ej. 512 MB RAM en Render):
# -XX:+UseContainerSupport: Detecta las restricciones de cgroup de Docker
# -XX:MaxRAMPercentage=75.0: Evita que el Garbage Collector y el Heap excedan el límite y provoquen OOMKilled
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
