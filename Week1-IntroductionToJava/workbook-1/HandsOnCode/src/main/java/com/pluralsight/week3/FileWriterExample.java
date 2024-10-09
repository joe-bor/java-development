package com.pluralsight.week3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
// open the file
            FileWriter writer = new FileWriter("skills.md");
 // write to the file
            writer.write("""
                    # Hello
                    
                    ### how
                    
                    ### are
                    
                    you
                    
                    doing ??
                    
                    """);
//            writer.write("Skills:\n");
//            writer.write("Git, HTML, CSS, Bootstrap\n");
//            writer.write(
//                    "JavaScript/ES6, jQuery, REST API, Node.js, Express\n");
//            writer.write("Angular\n");
//            writer.write("Java");
//// close the file when you are finished using it
            writer.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.printStackTrace();
        }
    }
}

class  BufferedWriterExample {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("skills.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("""
                1
                2
                3
                4
                5
                6
                7
                8
                9
                10
                
                """);
        bufferedWriter.write("AA", 2, 1);
        bufferedWriter.close();
    }
}