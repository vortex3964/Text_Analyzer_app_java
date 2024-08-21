import java.util.ArrayList;

public class SentenceAnalyzer {
    protected  static ArrayList<String> text;
    protected ArrayList<StringBuffer> SentenceStatistics;
    private  StringBuffer temp;

    public SentenceAnalyzer(ArrayList<String> tex)
    {
        text=tex;
        this.SentenceStatistics=new ArrayList<>();
    }

    public void SentenceStatistics(String word)
    {
        int counter=0;
        for(String s:text)
        {
            this.temp=new StringBuffer();
            this.temp.append(" in sentence ").append((counter+1)).append(" the word '").append(word).append("' ");
            this.temp.append(find_positions(s,word));
            this.SentenceStatistics.add(temp);
            counter++;
        }
    }

    public StringBuffer find_positions(String sentence,String word)
    {
        StringBuilder positions=new StringBuilder();
        StringBuffer fill=new StringBuffer();
        int index=0;
        int counter=0;
        int wordLength = word.length();

        while ((index=sentence.indexOf(word,index)) != -1) {
            positions.append(index).append(",");
            index += wordLength;
            counter++;
        }
        if (!positions.isEmpty()) {
            positions.deleteCharAt(positions.length() - 1); // Remove the trailing comma
        }
        if(counter!=0)  fill.append("appears ").append(counter).append(" times in the positions ").append(positions);
        else fill.append(" appears ").append(counter).append(" times");
        return  fill;
    }
}
