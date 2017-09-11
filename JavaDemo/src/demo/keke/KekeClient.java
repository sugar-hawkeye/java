package demo.keke;

/**
 * Created by wim on 2017/9/11.
 */
public class KekeClient {

    public void parser() {


        for (int i = 1; i < 2; i++) {
            synchronized (this) {
                String url = "http://word.kekenet.com/index.php?do=wordstart&type=wordmean&cid=174&coid=" + i;
                HttpRequest httpRequest = new HttpRequest(url);
                for (int j = 0; j < 15; j++) {
                    httpRequest.start();
                }
                for (int w = 0; w < httpRequest.getList().size(); w++) {
                    WordBean wordBean = httpRequest.getList().get(w);
                }
            }
        }


    }

    public static void main(String[] args) {



    }

}
