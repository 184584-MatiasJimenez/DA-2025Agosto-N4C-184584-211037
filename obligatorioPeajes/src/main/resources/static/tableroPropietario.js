/**
 * Script de inicialización y carga de datos para el Tablero del Propietario.
 * (Las funciones de carga de datos deben ser definidas aquí).
 */
function cargarDatosIniciales() {
    console.log("Tablero Propietario: Iniciando carga de datos...");
    
    // MOCK: Aquí se haría una petición POST al controlador para obtener TODOS
    // los datos del usuario (vehículos, bonificaciones, tránsitos, etc.)
    
    // Ejemplo de cómo se actualizaría el saldo (solo si el HTML ya está cargado)
    const saldoElement = document.getElementById('saldo-value');
    if (saldoElement) {
        saldoElement.textContent = '$ 2.540,00';
        document.getElementById('nombre-completo-value').textContent = 'Juan Pérez';
        document.getElementById('estado-value').textContent = 'Activo';
        document.getElementById('estado-value').classList.add('activo');
        
        // Aquí se llamarían a funciones para llenar las tablas
        llenarTablaBonificaciones();
        llenarTablaVehiculos();
        llenarTablaTransitos();
        llenarTablaNotificaciones();
    } else {
        console.log("Esperando que el HTML se renderice antes de inyectar datos.");
    }
}

function borrarNotificaciones() {
    console.log("Petición para borrar notificaciones enviada.");
    // Aquí iría el envío de petición al controlador /propietario/borrarNotificaciones
}

// MOCKS para llenar las tablas (ejemplo)
function llenarTablaBonificaciones() {
    const body = document.getElementById('bonificaciones-body');
    body.innerHTML = `
        <tr><td data-label="Bonificación">Frecuente</td><td data-label="Puesto">Peaje Norte</td><td data-label="Fecha Asignada">2025-01-10</td></tr>
        <tr><td data-label="Bonificación">Trabajador</td><td data-label="Puesto">Peaje Centro</td><td data-label="Fecha Asignada">2025-03-02</td></tr>
    `;
}
function llenarTablaVehiculos() {
    const body = document.getElementById('vehiculos-body');
    body.innerHTML = `
        <tr><td data-label="Matrícula">SAB1234</td><td data-label="Modelo">Sedan</td><td data-label="Color">Azul</td><td data-label="Tránsitos">12</td><td data-label="Monto Total">$ 980.00</td></tr>
        <tr><td data-label="Matrícula">SCD5678</td><td data-label="Modelo">SUV</td><td data-label="Color">Gris</td><td data-label="Tránsitos">8</td><td data-label="Monto Total">$ 660.00</td></tr>
    `;
}
function llenarTablaTransitos() {
    const body = document.getElementById('transitos-body');
    body.innerHTML = `
        <tr><td data-label="Puesto">Norte</td><td data-label="Matrícula">SAB1234</td><td data-label="Categoría">Motocicleta</td><td data-label="Tarifa">$ 120.00</td><td data-label="Bonificación">Frecuente</td><td data-label="Monto Pagado">$ 96.00</td><td data-label="Fecha/Hora">2025-09-19 18:45</td></tr>
        <tr><td data-label="Puesto">Centro</td><td data-label="Matrícula">SCD5678</td><td data-label="Categoría">Camión</td><td data-label="Tarifa">$ 180.00</td><td data-label="Bonificación">Trabajador</td><td data-label="Monto Pagado">$ 144.00</td><td data-label="Fecha/Hora">2025-09-18 08:22</td></tr>
    `;
}
function llenarTablaNotificaciones() {
    const body = document.getElementById('notificaciones-body');
    body.innerHTML = `
        <tr><td data-label="Fecha/Hora">2025-10-01 10:30</td><td data-label="Mensaje">Pasaste por Peaje Norte con SAB1234. Costo: $96.</td></tr>
        <tr><td data-label="Fecha/Hora">2025-09-29 15:00</td><td data-label="Mensaje">Tu saldo actual es de $50.00. Te recomendamos hacer una recarga!</td></tr>
    `;
}


window.onload = cargarDatosIniciales;