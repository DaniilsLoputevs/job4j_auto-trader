package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Util for more clean code.
 *
 * @author Daniils Loputevs(laiwiense@gmail.com)
 * @since 22.10.2020.
 */
public class ResponseWrite {
    public static <T> void write(HttpServletResponse resp, T string) {
        try (var writer = new PrintWriter(resp.getOutputStream())) {
            writer.write((String) string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void writeJacksonObjectMapper(HttpServletResponse resp, T content) {
        try (var writer = new PrintWriter(resp.getOutputStream())) {

            new ObjectMapper().writeValue(writer, content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
