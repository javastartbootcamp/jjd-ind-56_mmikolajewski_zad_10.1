package pl.javastart.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    void shouldDoSth() {
        // given
        Scanner scanner = TestUtils.createScannerWithGivenOutput("1", "2");

        // when
        // Main.run(scanner);

        // then
        assertThat(outContent.toString()).isEqualTo("Cośtam");
    }

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }


}
