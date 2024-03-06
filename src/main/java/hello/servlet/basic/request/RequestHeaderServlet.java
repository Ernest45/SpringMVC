package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.ErrorProperties;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet { // 헤더 정보를 어떻게 처리 하는 지 알아보기


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);


    }

    private static void printStartLine(HttpServletRequest request) {
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

    private static void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");

//        Enumeration<String> headerNames = request.getHeaderNames(); //옛날 방식의 헤더
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + " : " + headerName);
//        }

        request.getHeaderNames().asIterator() // 최근 방식의 헤더 호출
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));

        System.out.println("--- Headers - end ---");
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더 System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
                        System.out.println("request.getLocale() = " + request.getLocale());

        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            } }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //

        System.out.println();
        System.out.println("[Local 정보]"); System.out.println("request.getLocalName() = " + request.getLocalName()); // System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); // System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }

}
