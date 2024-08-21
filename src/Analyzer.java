import java.util.ArrayList;

public class Analyzer extends TextAnalyzer
{
    public Analyzer(ArrayList<String> data)
    {
        super(data);
    }

    public StringBuffer PrintTotalAppearances()
    {

        return this.TotalAppearances;
    }

    public StringBuffer PrintFirstAppearance()
    {
        return this.FirstAppearance;
    }

    public StringBuffer PrintMostAppearances()
    {

        return this.MostAppearances;
    }

    public StringBuffer PrintSentencesFound()
    {

        return this.SentencesFound;
    }

    public StringBuffer PrintSentenceStatistics()
    {
        StringBuffer f=new StringBuffer();
        for(StringBuffer buff:this.SentenceStatistics)
        {
            f.append(buff).append("\n");
        }
        return f;
    }
}
