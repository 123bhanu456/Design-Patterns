import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileLogger extends LoggerDecorator{

    String filePath;
    public FileLogger(Logger logger,String filePath){
        super(logger);
        this.filePath=filePath;
    }

    @Override
    public void log(String msg){
        super.log(msg);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(msg);
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            System.err.println("Failed to log in the file: " + e.getMessage());
        }
    }

}
