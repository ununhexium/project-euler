import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P022NamesScore
{
    public static void main(String[] args)
    throws Exception
    {
        URL url = P022NamesScore.class.getResource("./P022Input.txt");
        List<String> names = read(url);
        System.out.println(names);
        Collections.sort(names);
        // System.out.println(names.get(937));
        // System.out.println(score(names.get(937)));
        
        long total = 0;
        for (int i = 0; i < names.size(); ++i)
        {
            total += score(names.get(i)) * (i + 1);
        }
        System.out.println(total);
    }
    
    private static long score(String name)
    {
        long score = 0;
        for (char c : name.toCharArray())
        {
            score += c - 'A' + 1;
        }
        return score;
    }
    
    private static List<String> read(URL url)
    throws Exception
    {
        List<String> names = new ArrayList<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader(new File(url.toURI()))))
        {
            String line = br.readLine();
            String[] input = line.split(",");
            for (String s : input)
            {
                names.add(s.replaceAll("\"", ""));
            }
        }
        return names;
    }
}
