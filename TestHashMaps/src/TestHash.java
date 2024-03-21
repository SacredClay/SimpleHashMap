import java.lang.String;

public class TestHash
{
    public static void main(String[] args)
    {
        MyHashMap<String, String> hashy = new MyHashMap<>();

        hashy.put("A", "B");
        hashy.put("H", "P");
        hashy.put("E", "F");
        hashy.put("P", "2");
        hashy.put("1",  "G");
        hashy.put("2", "6");
        hashy.put("3", "2");
        hashy.put("4", "4");
        hashy.put("1",  "H");

        System.out.println(hashy);

        System.out.println("Wow look at that we removed " + hashy.remove("4"));

        System.out.println("Wow look at that we removed " + hashy.remove("E"));

        System.out.println("The size is " + hashy.size());

        System.out.println(hashy);
    }
}
