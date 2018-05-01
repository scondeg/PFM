package FilesUtilities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

public class Posicion {

    private String Latitud;
    private String Longitud;

    public Posicion() {

    }

    public String getLatitud() {
        return Latitud;
    }

    @XmlElement(name = "Latitud")
    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    @XmlElement(name = "Longitud")
    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

}
