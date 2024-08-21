import java.util.ArrayList;
import java.util.Scanner;

public class TextAnalyzer extends SentenceAnalyzer{
    protected StringBuffer TotalAppearances;
    protected StringBuffer FirstAppearance;
    protected StringBuffer MostAppearances;
    protected StringBuffer SentencesFound;

    public TextAnalyzer(ArrayList<String> data)
    {
        super(data);
        this.TotalAppearances=new StringBuffer();
        this.SentencesFound=new StringBuffer();
        this.MostAppearances=new StringBuffer();
        this.FirstAppearance=new StringBuffer();
    }

    public void TotalAppearances(String word)
    {
        int appearances = 0;

        for (String current:text)
        {
            Scanner reader = new Scanner(current);
            reader.useDelimiter("[\\s,]+");
            while (reader.hasNext()) {
                if (word.equals(reader.next())) appearances++;
            }
        }
        this.TotalAppearances.append("the word ").append(word).append(" appears:").append(appearances).append(" times in total");
    }

    public void FirstAppearance(String word)
    {
        boolean found = false;
        int counter=0;
        for(String current:text)
        {
            Scanner reader = new Scanner(current);
            reader.useDelimiter("[\\s,]+");
            while (reader.hasNext() && !found) {
                if (word.equals(reader.next())) found=true;
            }
            counter++;
            if(found) break;
        }
        this.FirstAppearance.append(found?"the word "+word+" first appears in sentence:"+counter:"word not found in text");
    }

    public void MostAppearances(String word)
    {
        int current=0;
        int previous=0;
        int biggest=0;

        for(int i=0;i<text.size();i++)
        {
            Scanner reader = new Scanner(text.get(i));
            reader.useDelimiter("[\\s,]+");
            while(reader.hasNext())
            {
                if(word.equals(reader.next())) current++;
            }
            if(current>=previous){
                previous=current;
                biggest=i;
            }
            current=0;
        }

        this.MostAppearances.append((previous==0)?"word not found in text":"the word "+word+" appears the most times in sentence:"+(biggest+1));
    }

    public void SentencesFound(String word)
    {
        this.SentencesFound.append("the word ").append(word).append(" appears in the sentences ");
        boolean found = false;
        for (int i = 0; i < text.size(); i++) {
            Scanner reader = new Scanner(text.get(i));
            reader.useDelimiter("[\\s,]+");
            while (reader.hasNext() && !found) {
                if (word.equals(reader.next())) {
                    this.SentencesFound.append(i+1).append(",");
                    found = true;
                }
            }
            found = false;
        }
        this.SentencesFound.deleteCharAt(this.SentencesFound.length()-1);
    }
}
