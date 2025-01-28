public class TimeLogger extends LoggerDecorator {
   
     TimeLogger(Logger logger) {
        super(logger);
    }

    public void log(String msg){
        msg=msg+" + time-"+java.time.LocalDateTime.now();
        super.log(msg);
    }


}
