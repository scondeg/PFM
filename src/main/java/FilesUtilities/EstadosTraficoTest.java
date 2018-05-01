package FilesUtilities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="Estados_trafico")
public class EstadosTraficoTest {

    private List<EstadoTraficoTest> listadoEstadoTraficoTest;

    public EstadosTraficoTest() {

    }

    public List<EstadoTraficoTest> getListadoEstadoTraficoTest() {
        return listadoEstadoTraficoTest;
    }

    @XmlElement(name = "Estado_trafico")
    public void setListadoEstadoTraficoTest(List<EstadoTraficoTest> estadoTraficoTest) {
        this.listadoEstadoTraficoTest = listadoEstadoTraficoTest;
    }

}