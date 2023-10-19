package org.example;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor


@JacksonXmlRootElement(localName = "Atletas")
public class ListaAtletas {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "atleta")
    private List<AtletaFemenina> atletas;

    public ListaAtletas(List<AtletaFemenina> atletas) {
        this.atletas = atletas;
    }

    public void setAtletas(List<AtletaFemenina> atletas) {
        this.atletas = atletas;
    }

    @Override
    public String toString() {
        return "ListaAtletas{" +
                "Atletas =" + atletas +
                '}';
    }
}
