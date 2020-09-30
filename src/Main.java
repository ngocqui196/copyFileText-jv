import sun.awt.windows.WBufferStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> readFileSource()  {
        List<String> line = new ArrayList<>();

        try {
             File filesource = new File("textFileSource.txt");  // Tạo file nguồn
            FileReader fileReader = new FileReader(filesource);  // Đọc file nguồn(đọc theo từng chữ).
            BufferedReader bufReader = new BufferedReader(fileReader);// Nhanh hơn thì ta chuyển các chữ đó trong 1 dòng vào vùng nhớ đối tượng.
            String line1 = null;
            while ((line1 = bufReader.readLine()) != null) {
                line.add(line1);
            }
            bufReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    public static void writeFileDest() throws IOException {

        try {
            File fileDest = new File("textFileDest.txt");       // Tạo file đích
            FileWriter fileWriter = new FileWriter(fileDest,true);
            String line2 = null;
            List<String> lineFileSource = readFileSource();
            for (int i = 0; i < readFileSource().size(); i++) {
                fileWriter.write(lineFileSource.get(i) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        try {
            readFileSource();
            writeFileDest();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//        fileWriter.close();
//        fileReader.close();

    }
}
