package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProducerApplication {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/produce")
    public String produce(@RequestParam String message) {
        kafkaTemplate.send("kafka-test", String.valueOf(System.currentTimeMillis()), message);
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
