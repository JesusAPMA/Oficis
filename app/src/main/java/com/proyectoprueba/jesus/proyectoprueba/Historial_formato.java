package com.proyectoprueba.jesus.proyectoprueba;

public class Historial_formato {
String correo_cliente;
String correo_prestador;
String fecha;
int costo;
String hora_inicio;
String hora_final;
int calificacion_prestador;
int tipo_pago;


    public Historial_formato(String correo_cliente, String correo_prestador, String fecha, int costo, String hora_inicio, String hora_final, int calificacion_prestador, int tipo_pago) {
        this.correo_cliente = correo_cliente;
        this.correo_prestador = correo_prestador;
        this.fecha = fecha;
        this.costo = costo;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.calificacion_prestador = calificacion_prestador;

        this.tipo_pago = tipo_pago;

    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getCorreo_prestador() {
        return correo_prestador;
    }

    public void setCorreo_prestador(String correo_prestador) {
        this.correo_prestador = correo_prestador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public int getCalificacion_prestador() {
        return calificacion_prestador;
    }

    public void setCalificacion_prestador(int calificacion_prestador) {
        this.calificacion_prestador = calificacion_prestador;
    }


    public int getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(int tipo_pago) {
        this.tipo_pago = tipo_pago;
    }


}
