package filecopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program takes two file paths, passed in the arguments for the program
 * on the command line, to copy one file byte-by-byte to another existing file.
 * @author Johnathan Tripp
 */
public class FileCopier {

    public static File f1, f2;
    private static FileInputStream in = null;
    private static FileOutputStream out = null;
    /**
     * Main method of the program, initializes a FileInputStream and FileOutputStream
     * to copy between the files passed in the main method's arguments. 
     * @param args the command line arguments, meant to contain two file paths (strings) for the file copy operation.
     * The arguments should be passed as strings in the format: "/root/desktop/File.txt" if using Linux, or "C:\\Users\\Johnathan\\Desktop\\File.txt" on Windows, using double backslashes between directories
     * @throws IOException exception thrown in case one of several file I/O operations used in the class fails
     */
    public static void main(String[] args) throws IOException{
        if(args.length > 0){
            //attempts to retrieve the input file from the method arguments
            f1 = new File(args[0]);
        }
        if(args.length > 1){
            //attempts to retrieve the output file from the method arguments
            f2 = new File(args[1]);
        }
        try{
            //attempts to initialize the input and output stream objects
            in = new FileInputStream(f1);
            out = new FileOutputStream(f2);
            int n;
            
            //copies bytes from the input file to the output file
            while((n = in.read()) != -1){
                out.write(n);
            }
        }
        /*catch(IOException e){
            //prints an error message if there is an exception thrown by the file operations and exits the program
            System.out.println("Invalid file operation. Please check your input/output files and try again.");
            System.exit(0);
        }*/
        finally{
            //close the input and output streams regardless of whether or not the program ran successfully
            if(in != null)
                in.close();
            if(out != null)
                out.close();
        }
        
        
    }
    
}
