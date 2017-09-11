package demo.keke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wim on 2017/9/11.
 */

/*


 */

public class HttpRequest {

    private URL url;
    private HttpURLConnection connection;

    private ArrayList<WordBean> list = null;

    public HttpRequest(String urlPath) {
        try {
            list = new ArrayList<>();

            this.url = new URL(urlPath);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }

    public void start() {
        try {
            connection = (HttpURLConnection)url.openConnection();

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(true);

            connection.setRequestProperty("Upgrade-Insecure-Requests","1");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");

            connection.setRequestProperty("Accept-Language","en,zh-CN;q=0.8,zh;q=0.6,zh-TW;q=0.4");
            connection.setRequestProperty("Cookie","Hm_lvt_9c68e8500a8dd6cbf338b9afc70517ec=1505091820; Hm_lpvt_9c68e8500a8dd6cbf338b9afc70517ec=1505091820; UM_distinctid=15e6e769932690-0bee42da06ec12-31607e01-1fa400-15e6e769933a93; PHPSESSID=j3kicfpc366jblr6d3oa8ok3p0; CNZZDATA2209395=cnzz_eid%3D142390382-1505086454-http%253A%252F%252Fwww.kekenet.com%252F%26ntime%3D1505091854");


            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP){
                System.out.println("302 ===  " + connection.getResponseMessage());
            }
            else if (responseCode == HttpURLConnection.HTTP_OK){


                InputStream is = connection.getInputStream();
                String charset = "UTF-8";
                Pattern pattern = Pattern.compile("charset=\\S*");
                Matcher matcher = pattern.matcher(connection.getContentType());
                if (matcher.find()) {
                    charset = matcher.group().replace("charset=", "");
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset));

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();

                HttpAnalyze httpAnalyze = new HttpAnalyze(sb.toString());
                WordBean wordBean =  httpAnalyze.parser();
                list.add(wordBean);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<WordBean> getList() {
        return list;
    }
}
