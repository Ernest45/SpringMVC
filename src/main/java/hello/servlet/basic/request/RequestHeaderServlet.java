package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet { // 헤더 정보를 어떻게 처리 하는 지 알아보기


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(" --- request Line - start");

        System.out.println("getMethod = " + request.getMethod()); //http 메서드 (get,post 등등)
        System.out.println("getProtocol = " +  request.getProtocol()); // http 1.1을 말함
        System.out.println("getScheme = " + request.getScheme());
        // localhost8080/reqeust-header
        System.out.println("getRequestURL = " +  request.getRequestURL());
        // /request-test
        System.out.println("getRequestURI = " +  request.getRequestURI());
        // /username=hi
        System.out.println("getQueryString = " +  request.getQueryString());
        System.out.println("isSecure = " +  request.isSecure()); //https 의 사용 유무 (s)

        System.out.println(" --- request Line - end");


    }
}
