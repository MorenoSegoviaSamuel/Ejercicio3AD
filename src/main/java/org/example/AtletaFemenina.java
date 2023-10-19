package org.example;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "atleta")
public class AtletaFemenina {
    @JacksonXmlElementWrapper(localName = "nombre")
    private String nombre;
    @JacksonXmlElementWrapper(localName = "pruebas")
    @JacksonXmlProperty(localName = "prueba")
    private List<String> prueba;
    @JacksonXmlElementWrapper(localName = "edad")
    private int edad;
    @JacksonXmlElementWrapper(localName = "pais")
    private String pais;

    public AtletaFemenina() {
    }

    public AtletaFemenina(String nombre, List<String> prueba, int edad, String pais){

        this.nombre=nombre;
        this.edad=edad;
        this.prueba=prueba;
        this.pais=pais;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrueba(List<String> prueba) {
        this.prueba = prueba;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "nombre='" + nombre + '\'' +
                ", prueba=" + prueba +
                ", edad=" + edad +
                ", pais=" + pais +
                '}';
    }
}
