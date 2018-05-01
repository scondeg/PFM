package FilesUtilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Logger;

public class EstadosTraficoXMLParser {

    private static Logger logger = Logger.getLogger(EstadosTraficoXMLParser.class.getName());

    public static String getEstadosTrafico(){
        String estadosTraficoPlainJSON = null;
        try (InputStream inputStream = new FileInputStream(new File(
                "/home/pfm/IdeaProjects/PFM_FilesReader/EstadoTrafico.xml"))) {
            String xml = IOUtils.toString(inputStream);
            JSONObject jObject = XML.toJSONObject(xml);
            //Se comprueba que el XML obtenido tenga información, en caso contrario no se crea JSON y se devuelve null
            //jObject.getJSONObject("Estados_trafico").getJSONArray("Estado_trafico")
            if(!jObject.get("Estados_trafico").equals("")) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                Object json = mapper.readValue(jObject.toString(), Object.class);
                estadosTraficoPlainJSON = Arrays.toString(mapper.writeValueAsString(json).split("\n"));
                System.out.println(estadosTraficoPlainJSON);
            }
            return estadosTraficoPlainJSON;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estadosTraficoPlainJSON;
    }
}
