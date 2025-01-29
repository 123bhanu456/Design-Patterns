public class Demo {

    public static void main(String[] args) {

        LoggerFactory loggerFactory=new LoggerFactory();

        Observer consoleLog = new ConsoleLog();
        Observer serverLog = new ServerLog();


        Logger syncLogger=loggerFactory.getSynchronousLogger();



        syncLogger.addObserver(serverLog);
        syncLogger.addObserver(consoleLog);


        syncLogger =new TimeLogger(syncLogger);
        syncLogger =new LevelLogger(syncLogger,3);

        Logger asyncLogger= loggerFactory.getAsynchronousLogger();

//        syncLogger.removeObserver(serverLog);

        asyncLogger =new LevelLogger(asyncLogger,2);



        asyncLogger.log("Hey");
        syncLogger.log("Hola");
        asyncLogger.log(" Hello");
        syncLogger.log(" Hi");










    }
}
