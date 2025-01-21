public class TestLogger {
    public static void main(String args[]){

        Logger logger=new SimpleLogger();

        logger.log("logging");

        logger =new TimestampLogger(logger);

        logger.log("logging");

        logger =new TypeLogger(logger,"error");

        logger.log("logging");

        logger =new FileLogger(logger,"Myfile.txt");

        logger.log("logging");






    }
}
