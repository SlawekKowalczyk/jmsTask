package pl.hussar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static pl.hussar.JmsConfig.*;

/**
 * @author Sławomir Kowalczyk.
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = WebMvcAutoConfiguration.class)
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend(TOPIC, readFile("excercise-1.xml"));
    }

    private static String readFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        ClassLoader classLoader = Application.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}