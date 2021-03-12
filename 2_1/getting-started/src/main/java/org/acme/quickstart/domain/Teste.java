package org.acme.quickstart.domain;

import java.util.Objects;
import java.util.UUID;

public class Teste {
    private static final String ID = UUID.randomUUID().toString();
    private String texto = "Contrato de prestación de servicios MI CONTADOR (Datapar)\n" +
            "Términos y condiciones MI CONTADOR (DATAPAR)\nEntre DATAPAR S.A. proveedor de la herramienta " +
            "APP(aplicación) MI CONTADOR (DATAPAR)  y el Cliente, en adelante el USUARIO, cuyo nombre o razón " +
            "social y demás datos de identificación y contacto, así como el lugar y fecha del presente, se " +
            "consignan en los campos correspondientes, se celebra el presente contrato de prestación de servicios " +
            "el cual se regirá por las siguientes cláusulas que las partes a continuación acuerdan:" +
            "\nPRIMERA: OBJETO\n";

    public String getUuid() {
        return ID;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teste)) return false;
        Teste teste = (Teste) o;
        return Objects.equals(getUuid(), teste.getUuid()) && Objects.equals(getTexto(), teste.getTexto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getTexto());
    }
}
