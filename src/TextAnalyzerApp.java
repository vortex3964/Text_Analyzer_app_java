import java.io.*;
import java.util.*;

public class TextAnalyzerApp {
    public  static  String choice;
    public static  void main(String[] args)
    {
        //put in the subject.txt file the text you want analyzed
        File report=new File("TextAnalyzerAppReport.txt");

        //FileWriter
        PrintWriter writer;
        try {
            writer=new PrintWriter(new FileWriter("TextAnalyzerAppReport.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("TextAnalyzerApp\n***************");
        writer.println("TextAnalyzerApp\n***************");
        //the memory
        ArrayList<String> data=new ArrayList<>();

        //copy the file to memory
        try {
            File object=new File("subject.txt");
            Scanner fileScanner=new Scanner(object);
            String temp=fileScanner.nextLine();
            String[] ar_temp=temp.split("[.]");
            Collections.addAll(data,ar_temp);
            fileScanner.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //the hashmaps
        HashMap<String,String> words=new HashMap<>();
        HashMap<String,Analyzer> results=new HashMap<>();

        //fill the hash maps
        int counter=0;
       for(String s:data)
       {
           Scanner scanner=new Scanner(s);
           scanner.useDelimiter("[\\s,]+");
           while(scanner.hasNext())
           {
               String c=scanner.next();
               if(!words.containsValue(c))
               {
                   Analyzer temp=new Analyzer(data);
                   counter++;
                   words.put(String.valueOf(counter),c);
                   //methods to store and calc in analyzer
                   results.put(c,temp);
                   temp.FirstAppearance(c);
                   temp.MostAppearances(c);
                   temp.TotalAppearances(c);
                   temp.SentencesFound(c);
                   temp.SentenceStatistics(c);
               }
           }
       }

        System.out.println("the file contained:");
        writer.println("the file contained:");
        print_file(data,writer);
        System.out.println("*******************");
        writer.println("*******************");
        writer.flush();
        //the menu and statistics
        boolean run=true;
        print_words(words,writer);
        while(run)
        {
            switch (command_menu(writer))
            {
                case "x":
                    run=false;
                    break;
                case "ds":
                    print_file(data,writer);
                    break;
                case "dw":
                    print_words(words,writer);
                    break;
                case "dst":
                    if(words.containsKey(choice=stats(writer)))
                    {
                        System.out.println("the word is "+words.get(choice));
                        System.out.println("***************************");
                        System.out.println(results.get(words.get(choice)).PrintSentencesFound());
                        System.out.println(results.get(words.get(choice)).PrintTotalAppearances());
                        System.out.println(results.get(words.get(choice)).PrintFirstAppearance());
                        System.out.println(results.get(words.get(choice)).PrintMostAppearances());
                        System.out.println(results.get(words.get(choice)).PrintSentenceStatistics());
                        System.out.println("***************************");

                        writer.println("the word is "+words.get(choice));
                        writer.println("***************************");
                        writer.println(results.get(words.get(choice)).PrintSentencesFound());
                        writer.println(results.get(words.get(choice)).PrintTotalAppearances());
                        writer.println(results.get(words.get(choice)).PrintFirstAppearance());
                        writer.println(results.get(words.get(choice)).PrintMostAppearances());
                        writer.println(results.get(words.get(choice)).PrintSentenceStatistics());
                        writer.flush();
                        writer.println("***************************");
                        writer.flush();
                    }
                    else
                    {
                        System.out.println(choice+" is not an option");
                        writer.println(choice+" is not an option");
                    }
                    break;
                default:
                    System.out.println("not an option");
                    writer.println("not an option");
                    break;
            }
        }
        System.out.println("program terminated Successfully");
        writer.println("program terminated Successfully");
        writer.flush();
    }

    static String stats(PrintWriter writer)
    {
        System.out.print("choose the number of the word you would like to see the statistics of:");
        writer.println("choose the number of the word you would like to see the statistics of:");
        Scanner num=new Scanner(System.in);
        return num.next();
    }

    static String command_menu(PrintWriter writer)
    {
        System.out.println("ds-display sentences, dw-display words, dst-display Statistics,x-to quit");
        System.out.print("make your choice:");
        writer.println("ds-display sentences, dw-display words, dst-display Statistics,x-to quit");
        writer.println("make your choice:");
        Scanner c=new Scanner(System.in);
        return c.nextLine();
    }

    static void print_words(HashMap<String,String> words,PrintWriter writer)
    {
        System.out.println("here's all the words:");
        writer.println("here's all the words:");
        for(Map.Entry<String,String> pair:words.entrySet())
        {
            System.out.println(pair.getKey()+"--"+pair.getValue());
            writer.println(pair.getKey()+"--"+pair.getValue());
        }
        System.out.println("@**@*@*@*@**@*@***@*");
        writer.println("@**@*@*@*@**@*@***@*");
    }

    static void  print_file(ArrayList<String> data,PrintWriter writer)
    {
        int counter=0;
        for(String s:data)
        {
            counter++;
            System.out.println("["+(counter)+"]"+s);
            writer.println("["+(counter)+"]"+s);
        }

    }
}
