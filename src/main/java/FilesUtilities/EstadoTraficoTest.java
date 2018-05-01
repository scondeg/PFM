package FilesUtilities;

import javax.xml.bind.annotation.XmlElement;

public class EstadoTraficoTest {

    private String posicion;
    private String color;

    public EstadoTraficoTest() {

    }

    public String getListadoPosiciones() {
        return posicion;
    }

    @XmlElement (name = "Posicion")
    public void setlistadoPosiciones(String Posicion) {
        this.posicion = posicion;
    }

    public String getColor() {
        return color;
    }

    @XmlElement(name = "Color")
    public void setColor(String color) {
        this.color = color;
    }

}