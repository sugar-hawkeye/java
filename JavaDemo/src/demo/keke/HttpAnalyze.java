package demo.keke;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wim on 2017/9/11.
 */
public class HttpAnalyze {

    private String content = null;
    private Document doc;


    public HttpAnalyze(String content) {
        this.content = content;
        doc = Jsoup.parse(this.content);

    }

    public WordBean parser() {
        WordBean wordBean = new WordBean();


        Elements dancname = doc.getElementsByClass("dancname");
        String nameRegx = " +";
        String name[] = dancname.text().split(nameRegx);
        wordBean.setName(name[0]);
        wordBean.setSymbol(name[1]);


        String mp3 = findMp3(dancname.toString());
        wordBean.setMp3(mp3);

        Element sshowm = doc.getElementById("sshowm");
        wordBean.setMean(sshowm.text());

        Elements lijulist = doc.getElementsByClass("lijulist");
        wordBean.setExample(lijulist.text());

        return wordBean;
    }

    private String findMp3(String text) {
        String mp3Regx = "(?<=\\(')(.+?)(?='\\))";
        Pattern pattern = Pattern.compile(mp3Regx);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()){
            return matcher.group();
        }
        return "";
    }



}
