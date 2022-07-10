package hello.hellospring;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId";

    //동시성을 위해 CoCurrentHashMap 사용
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    //세션 생성
    public void createSession(Object value, HttpServletResponse response) {

        //세션 id를 생성하고 값을 세션에 저장
        //자바가 제공하는 확실한 랜덤값
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        //쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }

    //쿠키 조회
    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if(sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }

    //세션 만료
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        
        //만료된 쿠키를 지움
        if(sessionCookie != null){
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    //쿠키를 찾는 로직
    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        if(request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);  
    }

}
