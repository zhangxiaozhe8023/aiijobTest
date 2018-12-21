import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;


import java.io.IOException;

   import java.net.URI;

import java.net.URISyntaxException;

import java.net.URL;

import java.net.URLConnection;

    /**普通类*/

    public class aiiJobTest {

        public static void main(String[] args) {

            try {

                System.out.println(isValidUrl("http://job.aiijob.com/a/login")+"---正确地址");

                UrlWithTime("http://job.aiijob.com/a/login",1000);

            } catch (Exception e) {

                System.out.println("链接不正确");

                e.printStackTrace();

            }

        }

        public static void UrlWithTime(String urlString,int timeOutMillSeconds){

            long lo = System.currentTimeMillis();

            URL url;

            try {

                url = new URL(urlString);

                URLConnection co =  url.openConnection();

                co.setConnectTimeout(timeOutMillSeconds);

                co.connect();

                System.out.println("链接可用");

            } catch (Exception e1) {

                System.out.println("链接打不开!");

                url = null;

            }

            System.out.println(System.currentTimeMillis()-lo);

        }

        private static final String acceptableSchemes[] = {

                "http:",

                "https:",

                "file:"

        };

        private static boolean urlHasAcceptableScheme(String url) {

            if (url == null) {

                return false;

            }

            for (int i = 0; i < acceptableSchemes.length; i++) {

                if (url.startsWith(acceptableSchemes[i])) {

                    return true;

                }

            }

            return false;

        }

        private static String isValidUrl(String incommingString) throws Exception{

            URL urlObj = new URL(incommingString);

            URI uriObj = new URI(urlObj.getProtocol(), urlObj.getHost(), urlObj.getPath(), urlObj.getQuery(), null);

            String scheme = uriObj.getScheme();

            if (!urlHasAcceptableScheme(incommingString)) {

                if (scheme != null) {

                    throw new URISyntaxException("", "");

                }

            }

            return incommingString;

        }

    }


