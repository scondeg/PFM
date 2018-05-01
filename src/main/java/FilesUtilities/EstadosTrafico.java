package FilesUtilities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Estados_trafico")
public class EstadosTrafico {

    private List<EstadoTrafico> listadoEstadoTrafico;

    public EstadosTrafico() {

    }

    public List<EstadoTrafico> getListadoEstadoTrafico() {
        return listadoEstadoTrafico;
    }

    @XmlElement(name = "Estado_trafico")
    public void setListadoEstadoTrafico(List<EstadoTrafico> listadoEstadoTrafico) {
        this.listadoEstadoTrafico = listadoEstadoTrafico;
    }

}