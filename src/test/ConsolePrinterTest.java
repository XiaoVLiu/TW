package test;

import main.ConsolePrinter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lxw on 15-12-4.
 */
public class ConsolePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testshouldPrintContentToOutputStreamWhenIWantToPrintIt() {
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("say hello to console!");

        assertThat(outContent.toString(), is("say hello to console!"));
    }
}
