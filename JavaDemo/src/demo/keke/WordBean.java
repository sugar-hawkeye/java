package demo.keke;

/**
 * Created by wim on 2017/9/11.
 */
public class WordBean {
    private String name;
    private String mean;
    private String symbol;
    private String mp3;
    private String example;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        String string = getName() + "  " + getSymbol() + "  \n " +getMean() + " \n"  +getExample();
        return string;
    }
}
