public class TimestampLogger extends LoggerDecorator{

    public TimestampLogger(Logger logger){
        super(logger);
    }
    @Override
    public void log(String msg){
        String timeStampmsg=msg+" time -"+ java.time.LocalDateTime.now();
        super.log(timeStampmsg);
    }

}
