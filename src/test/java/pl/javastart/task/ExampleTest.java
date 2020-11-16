package pl.javastart.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Timeout(5)
public class ExampleTest {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    void shouldDoSth() {
        // given
        // provideInput("1", "2", "3", "-12");

        // when
        // Main.main(new String[]{});

        // then
    }

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String... lines) {
        String input = String.join("\r\n", lines);
        input += "\r\n";

        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    private void copyFileFromResources(String name, String output) throws Exception {
        URL resource = getClass().getResource(name);
        Files.copy(Path.of(resource.toURI()), new File(output).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private void writeToFile(String fileContent, String filename) throws IOException {
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(fileContent);
        fileWriter.close();
    }

    private void writeToFile(List<String> lines, String filename) throws IOException {
        File file = new File(filename);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(String.join("\n", lines));
        fileWriter.close();
    }

}
