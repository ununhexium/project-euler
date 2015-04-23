import net.lab0.tools.math.MyMath;





public class P017NumberLetterCounts
{
    public static void main(String[] args)
    {
//        for (int i = 0; i < 25; i++)
//        {
//            System.out.println("" + i + " -> " + toAlpha(i));
//        }
//        
//        System.out.println(toAlpha(342) + " -> " + countLetters(toAlpha(342)));
//        System.out.println(toAlpha(115) + " -> " + countLetters(toAlpha(115)));
//        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1001; i++)
        {
            sb.append(MyMath.toAlphaEnglish(i));
        }
        
//        String result = sb.toString();
//        for (int i = 0; i <= result.length()/100; ++i)
//        {
//            System.out.println(result.substring(100 * i, Math.min(100 * i + 100, result.length())));
//        }
        
        System.out.println(countLetters(sb.toString()));
        
        System.out.println(MyMath.toAlphaEnglish(153_211));
    }
    
    private static int countLetters(String s)
    {
        return s.replaceAll(" ", "").replaceAll("-", "").length();
    }
}
