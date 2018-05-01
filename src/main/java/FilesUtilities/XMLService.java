package FilesUtilities;

public class XMLService {

    public Object getEstadosTrafico() {

        return EstadosTraficoXMLParser.getEstadosTrafico();

    }

    public EstadosTraficoTest getEstadosTraficoTest() {

        return EstadosTraficoTestXMLParser.getEstadosTrafico();

    }
}
