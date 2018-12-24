
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

    public class aiiJobTest {


        /**
         * 文件名称为：URLAvailability.java
         * 文件功能简述： 描述一个URL地址是否有效
         * @author Jason
         * @time   2010-9-14
         *
         */

            private static URL url;
            private static HttpURLConnection con;
            private static int state = -1;
           private String sTime;
        private long fist_time;
        private long hua_time;

        /**
             * 功能：检测当前URL是否可连接或是否有效,
             * 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用
             * @param urlStr 指定URL网络地址
             * @return URL
             */
            public synchronized URL isConnect(String urlStr) {
                int counts = 0;
                if (urlStr == null || urlStr.length() <= 0) {
                    return null;
                }
                while (counts < 5) {
                    try {
                        url = new URL(urlStr);
                        fist_time = System.currentTimeMillis();
                        con = (HttpURLConnection) url.openConnection();
                        state = con.getResponseCode();
                       hua_time= (System.currentTimeMillis()-fist_time);
                        sTime = con.getResponseMessage();

                        System.out.println(counts +"= "+state);
                        System.out.println(sTime);

                        if (state == 200 &&  hua_time<1000) {
                            System.out.println("URL可用！、时间="+hua_time+"ms");

                        }else{
                            //发送邮件
                            maillTest.main();
                        }
                        break;
                    }catch (Exception ex) {
                        counts++;
                        System.out.println("URL不可用，连接第 "+counts+" 次");
                        urlStr = null;
                        continue;
                    }
                }
                return url;
            }
         @Test
        public  void main() {
            aiiJobTest u=new aiiJobTest();
            u.isConnect("http://job.aiijob.com/a/login");
            u.isConnect("http://job.aiijob.com/e/login");
            System.out.println("test git hup");
         }
        }



