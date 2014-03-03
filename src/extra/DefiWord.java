//package extra;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.Multimap;
//
//import net.lab0.tools.MyString;
//
//public class DefiWord
//{
//    private static String alphabet = "";
//    static
//    {
//        for (char c = 'a'; c <= 'z'; ++c)
//        {
//            alphabet += c;
//        }
//    }
//    
//    public static void main(String[] args)
//    throws Exception
//    {
//        URI uri = DefiWord.class.getResource("/french_words_list.txt").toURI();
//        BufferedReader reader = new BufferedReader(new FileReader(new File(uri)));
//        
//        List<String> dictionary = new ArrayList<>();
//        
//        String line = null;
//        while ((line = reader.readLine()) != null)
//        {
//            dictionary.add(MyString.deAccent(line));
//        }
//        
//        System.out.println("Complete dictionary size = " + dictionary.size());
//        dictionary = new ArrayList<>(new HashSet<String>(dictionary)); // == uniq
//        System.out.println("Complete dictionary without dicritics duplicates size = " + dictionary.size());
//        
//        String letters = "sfbolelitaee";
//        Map<Character, Integer> availableLetters = map(letters);
//        
//        List<String> words = maxLettersUse(availableLetters, dictionary);
//        
//        reader.close();
//    }
//    
//    private static Map<Character, Integer> map(String letters)
//    {
//        Map<Character, Integer> mapped = new HashMap<>();
//        
//        for (char a : alphabet.toCharArray())
//        {
//            int count = 0;
//            for (char l : letters.toCharArray())
//            {
//                if (a == l)
//                {
//                    count++;
//                }
//            }
//            
//            mapped.put(a, count);
//        }
//        
//        return mapped;
//    }
//    
//    private static List<String> maxLettersUse(Map<Character, Integer> letters, List<String> dictionary)
//    {
//        List<String> usable = new ArrayList<>();
//        for (String word : dictionary)
//        {
//            if (canBeWritten(letters, word))
//            {
//                usable.add(word);
//            }
//        }
//        
//        // map by length
//        ArrayListMultimap<Integer, String> sortedWords = ArrayListMultimap.create();
//        
//        for (String word : usable)
//        {
//            sortedWords.put(word.length(), word);
//        }
//        
//        System.out.println("Usable size = " + sortedWords.size());
//        for (int i : sortedWords.keySet())
//        {
//            System.out.println("length=" + i + " -> " + sortedWords.get(i).size());
//        }
//        
//        boolean found = false;
//        int currentStartLength = 12;
//        while (!found)
//        {
//            Map<Character, Integer> lettersToUse = new HashMap<>(letters);
//            while (sortedWords.get(currentStartLength).size() == 0 && sortedWords.size() > 0)
//            {
//                currentStartLength--;
//            }
//            
//            recursiveMaxLetters(lettersToUse, sortedWords, currentStartLength);
//            
//            System.out.println("Using " + word);
//            System.out.println("remaining " + lettersToUse);
//            found = true;
//        }
//        
//        return usable;
//    }
//    
//    private static List<String> recursiveMaxLetters(Map<Character, Integer> letters,
//    ArrayListMultimap<Integer, String> sortedWords, int maxLength, int index)
//    {
//        List<String> wordsList = sortedWords.get(maxLength);
//        String word = wordsList.remove(wordsList.size() - 1);
//        Map<Character, Integer> lettersUsed = map(word);
////        lettersToUse = subtract(lettersToUse, lettersUsed);
//        return null;
//    }
//    
//    private static Map<Character, Integer> subtract(Map<Character, Integer> lettersToUse,
//    Map<Character, Integer> lettersUsed)
//    {
//        Map<Character, Integer> ret = new HashMap<Character, Integer>();
//        for (char c : lettersToUse.keySet())
//        {
//            ret.put(c, lettersToUse.get(c) - lettersUsed.get(c));
//        }
//        return ret;
//    }
//    
//    /**
//     * 
//     * @param letters
//     * @param word
//     * @return true if <code>word</code> can be written with <code>letters</code>
//     */
//    private static boolean canBeWritten(Map<Character, Integer> letters, String word)
//    {
//        Map<Character, Integer> mappedWord = map(word);
//        for (char c : alphabet.toCharArray())
//        {
//            if (mappedWord.get(c) > letters.get(c))
//            {
//                return false;
//            }
//        }
//        
//        return true;
//    }
//}
