package web.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by guilherme on 24/12/15.
 */
public class WebUtils {

    private static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";

    public static boolean isNullOrEmpty(final String s) {

        return s == null || s.trim().isEmpty();
    }

    public static String getRequestURL(HttpServletRequest request, HttpServletResponse response) {

        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();

        String contextPath = request.getContextPath();

        final String headerInfo = request.getHeader(X_FORWARDED_PROTO);

        return getRequestURL(requestURL, requestURI, contextPath, headerInfo);
    }

    private static String getRequestURL(String requestURL, String requestURI, String contextPath,
                                String headerInfo) {

        final StringBuilder info = new StringBuilder();
        String protocol = requestURL.substring(0, requestURL.indexOf(":"));
        requestURL = requestURL.substring(requestURL.indexOf(":"), requestURL.indexOf(requestURI));

        if (headerInfo != null) {
            protocol = headerInfo;
        }

        info.append(protocol);
        info.append(requestURL);
        info.append(contextPath);

        return info.toString();

    }

    public static boolean login(){
        return true;
    }
}
