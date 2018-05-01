package FilesUtilities;

import java.util.List;

        import javax.xml.bind.annotation.XmlElement;

public class EstadoTrafico {

    private List<Posicion> listadoPosiciones;
    private String color;

    public EstadoTrafico() {

    }

    public List<Posicion> getListadoPosiciones() {
        return listadoPosiciones;
    }

    @XmlElement (name = "Posicion")
    public void setlistadoPosiciones(List<Posicion> listadoPosiciones) {
        this.listadoPosiciones = listadoPosiciones;
    }

    public String getColor() {
        return color;
    }

    @XmlElement(name = "Color")
    public void setColor(String color) {
        this.color = color;
    }

}