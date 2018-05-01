package kafka.producer;

import FilesUtilities.EstadosTraficoXMLParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class EstadoTraficoProducer {
    public static String KAFKA_HOST = "127.0.0.1:9092";
    public static String TOPIC = "EstadoTrafico";

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_HOST);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "serializers.JsonSerializer");
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "kafka.producer.SimplePartitioner");

        Thread.currentThread().setContextClassLoader(null); 
        Producer<String, Map<String, Object>> producer = new KafkaProducer<>(props);

        Map<String, Object> myJson = new HashMap<>();

        //while (true){
        for (int i = 0; i < 5; i++) {
            String json = EstadosTraficoXMLParser.getEstadosTrafico();
            if (json != null){
                int jsonKey = json.hashCode();
                myJson.put("EstadoTrafico - " + json.hashCode() , json);
                String key = String.format("key[%d]", jsonKey);
                System.out.println("Sending message with: " + key);
                ProducerRecord<String, Map<String,Object>> rec = new ProducerRecord<>(TOPIC,key,myJson);
                producer.send(rec);
                Thread.sleep(1000);
            }
        }

        producer.flush();
        producer.close();
    }
}
