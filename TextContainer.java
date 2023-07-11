import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(path = "C://Users/User/IdeaProjects/file.txt")
public class TextContainer {
    String text = "Hello guys";
    @Saver
    public void save(String savePath, String textToSave){
        try {
            PrintWriter pw = new PrintWriter(savePath);
            pw.print(textToSave);
            pw.close();
            System.out.println("The file has been created and the information has been written into it correctly.");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
