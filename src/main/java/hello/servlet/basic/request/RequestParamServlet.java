package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송기능
 * http://localhost:8080/reqeust-param?username=hello&age=20
 *
 */

@WebServlet(name = "ReqeustParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName ->
                        System.out.println(paramName + " = " + req.getParameter(paramName)));
                //paramName은 이름을(key) 꺼내는거고  getParameter로 key를 넘기면 value를 꺼낼 수 있다

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println();
        System.out.println("username = " + username);
        System.out.println("age = " + age);




    }
}
