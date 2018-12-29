import java.io.*;
public class Multimedia {
    //пример инкапсуляции:
    private String name_file;
    private String type_file;

    public Multimedia() {
    }

    public Multimedia(String name, String type) {
        this.name_file = name;
        this.type_file = type;
    }

    public String Open_file() {
        return "Файл " + name_file + "." + type_file + " успешно открыт!";
    }

    public int copy(String file1, String file2) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        int speed_progress = 0;
        final int size4Mb = 4 * 1024 * 1024;
        try {
            is = new FileInputStream(file1);
            os = new FileOutputStream(file2);
            byte[] buffer = new byte[size4Mb];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer,0, length);
                speed_progress++;
            }
        } finally {
            is.close();
            os.close();
            return speed_progress;
        }
    }
}