package sample;
import java.io.*;

public class Test implements Serializable {
    @Save
    private String str1 = "Save this string";
    @Save
    private Integer str2 = 777;
    private String dstr = "Don't save this string";
    private String path = "serialization.txt";

    public void serialization(String text) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(text);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deseralization() throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            String str = (String) ois.readObject();
            System.out.printf(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
