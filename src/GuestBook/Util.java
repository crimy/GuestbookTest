package GuestBook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Util {
    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
    }

    public static void alert(HttpServletResponse response, String text) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + text + "'); history.go(-1);</script>");
        out.flush();
    }
}
