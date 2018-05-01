package FilesUtilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Logger;

public class EstadosTraficoTestXMLParser {

    private static Logger logger = Logger.getLogger(EstadosTraficoTestXMLParser.class.getName());

    public static EstadosTraficoTest getEstadosTrafico(){
        EstadosTraficoTest estadosTraficoTest = null;

        try {

          /*  BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream("/home/pfm/IdeaProjects/PFM_FilesReader/EstadoTrafico.xml")));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } finally {
                br.close();
            }*/
                    //File fileEstadoTrafico = new File("EstadoTrafico.xml");

            //URL url = new URL("http://www.mc30.es/components/com_hotspots/datos/estado_trafico.xml");
            //FileUtils.copyURLToFile(url, fileEstadoTrafico);
            File fileEstadoTrafico = new File("/home/pfm/IdeaProjects/PFM_FilesReader/EstadoTraficoTest.xml");
            //FileInputStream fileEstadoTrafico = new FileInputStream("/home/pfm/IdeaProjects/PFM_FilesReader/EstadoTrafico.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(EstadosTraficoTest.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            estadosTraficoTest = (EstadosTraficoTest) jaxbUnmarshaller.unmarshal(fileEstadoTrafico);

        /*} catch (MalformedURLException e) {
            logger.log(Level.ALL,"Error al crear URL estadoTrafico", e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ALL,"Error al crear  fichero estadoTrafico", e.getMessage());*/
        } catch (JAXBException e) {
            e.printStackTrace();
        /*} catch (FileNotFoundException e) {
            e.printStackTrace();*/
        }
        return estadosTraficoTest;
    }

}
