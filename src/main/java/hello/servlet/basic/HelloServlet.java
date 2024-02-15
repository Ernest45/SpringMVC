package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/hello") // /hello로 들어오면 실행됨
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(request, response); // 서블릿이 호출되면 서비스 이 메서드가 호출됨
        // http요청이 오면 was(서블릿 컨테이너) request, response를 객체를 만들어서 서블릿에게 던져준다
        // Hello로 접속하면 즉 웹브라우저가 http 요청 메세지를 만들어서 서버에 던진 거

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 서블릿은 쿼리파라미터 편하게 읽을 수 있는데 그게
        String usernamer = request.getParameter("username");
        System.out.println("parameter = " + usernamer);

        response.setContentType("text/plain"); // 단순문자
        response.setCharacterEncoding("utf-8"); // 문자인코딩 정보를 넘겨줘야 하는데 이건 utf-8
        response.getWriter().write("hello" + usernamer);

    }
}
