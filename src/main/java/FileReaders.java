import FilesUtilities.EstadosTrafico;
import FilesUtilities.EstadosTraficoTest;
import FilesUtilities.XMLService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaders {

    private static Logger logger = Logger.getLogger(FileReaders.class.getName());

    public static void main(String args[]){
      /*  URL url = null;
        File fileDatosTrafico = new File("DatosTrafico.xml");
        try {
            url = new URL("http://www.mc30.es/images/xml/DatosTrafico.xml");
            FileUtils.copyURLToFile(url, fileDatosTrafico);
        } catch (MalformedURLException e) {
            logger.log(Level.ALL,"Error al crear URL DatosTrafico", e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ALL,"Error al crear  fichero DatosTrafico", e.getMessage());
        }

        File fileEstadoTrafico = new File("EstadoTrafico.xml");
        try {
            url = new URL("http://www.mc30.es/components/com_hotspots/datos/estado_trafico.xml");
            FileUtils.copyURLToFile(url, fileEstadoTrafico);
        } catch (MalformedURLException e) {
            logger.log(Level.ALL,"Error al crear URL estadoTrafico", e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ALL,"Error al crear  fichero estadoTrafico", e.getMessage());
        }

        File fileEstimacionesTrafico = new File("EstimacionesTrafico.xml");
        try {
            url = new URL("http://www.mc30.es/images/xml/EstimacionesTrafico.xml");
            FileUtils.copyURLToFile(url, fileEstimacionesTrafico);
        } catch (MalformedURLException e) {
            logger.log(Level.ALL,"Error al crear URL estimacionesTrafico", e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ALL,"Error al crear  fichero estimacionesTrafico", e.getMessage());
        }

        File fileIncidenciasTrafico = new File("IncidenciasTrafico.xml");
        try {
            url = new URL("http://www.mc30.es/components/com_hotspots/datos/incidencias.xml");
            FileUtils.copyURLToFile(url, fileIncidenciasTrafico);
        } catch (MalformedURLException e) {
            logger.log(Level.ALL,"Error al crear URL incidenciasTrafico", e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ALL,"Error al crear  fichero incidenciasTrafico", e.getMessage());
        }*/

 //       XMLService xmlService = new XMLService();

//        EstadosTrafico estadosTrafico = xmlService.getEstadosTrafico();
//        EstadosTraficoTest estadosTraficoTest = xmlService.getEstadosTraficoTest();
        InputStream inputStream;
        InputStream inputStream2;
        try {
            inputStream = new FileInputStream(new File(
                    "/home/pfm/IdeaProjects/PFM_FilesReader/EstadoTrafico.xml"));
            String xml = IOUtils.toString(inputStream);
            JSONObject jObject = XML.toJSONObject(xml);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            Object json = mapper.readValue(jObject.toString(), Object.class);
            String output = mapper.writeValueAsString(json);
            System.out.println(output);

            inputStream2 = new FileInputStream(new File(
                    "/home/pfm/IdeaProjects/PFM_FilesReader/EstadoTraficoEmpty.xml"));
            String xml2 = IOUtils.toString(inputStream2);
            JSONObject jObject2 = XML.toJSONObject(xml2);
            ObjectMapper mapper2 = new ObjectMapper();
            mapper2.enable(SerializationFeature.INDENT_OUTPUT);
            Object json2 = mapper.readValue(jObject2.toString(), Object.class);
            String output2 = mapper.writeValueAsString(json2);
            System.out.println(output2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
