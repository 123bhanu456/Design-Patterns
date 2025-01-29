import java.io.*;

public class FileFunction {


    String filePath;
    String lastWrite="";
    FileFunction(String filePath){
        this.filePath=filePath;
    }
   public void read(){
        try{
            String line;
            System.out.println("Reading file content : ");
            BufferedReader reader=new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }


        }
        catch (Exception e){
            System.out.println("Error Reading the file"+e);

        }
    }

    public void write(String msg){

       try{
           BufferedWriter writer=new BufferedWriter(new FileWriter(filePath,true));
           lastWrite=msg;
           writer.write(msg);
           writer.flush();
           writer.newLine();

           System.out.println("Written to file: " + msg);
       }
       catch (Exception e){
           System.out.println("Error Writing into File"+e);
       }

    }

   public void undoWrite(){
     File file=new File(filePath);

     if(!file.exists()){
         System.out.println("No file Found toi undo");
         return ;
     }

     String line;
     try {
         BufferedReader reader = new BufferedReader(new FileReader(file));
         StringBuilder content=new StringBuilder();

         line =reader.readLine();
         while(line!=null){
             if(!line.equals(lastWrite)){
                 content.append(line).append("\n'");
             }
             line =reader.readLine();
         }
         reader.close();

         BufferedWriter writer=new BufferedWriter(new FileWriter(file));

         writer.write(content.toString());
         writer.flush();
         writer.newLine();
         writer.close();
         System.out.println("undo the last written");
     }
     catch(Exception e){
         System.out.println("Error while undoing the written one");
       }



   }


}
