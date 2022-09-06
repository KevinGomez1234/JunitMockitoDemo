package co.kevingomez.iodemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//writing to a file
/* A stream is a sequence of data, in Java 
 * An I/O Stream represents an input source or an output destination. A stream can represent many different kinds of sources and destinations, including disk files, devices, other programs, and memory arrays.
 * 
 * Streams support many different kinds of data, including simple bytes, primitive data types, localized characters, and objects. Some streams simply pass on data; others manipulate and transform the data in useful ways.
 * 
 * No matter how they work internally, all streams present the same simple model to programs that use them: A stream is a sequence of data. A program uses an input stream to read data from a source, one item at a time:
 * Program => Data destination
 * Data source => Program
 * 
 * Programs use byte streams to perform input and output of 8-bit bytes. All byte stream classes are descended from InputStream and OutputStream.
 * There are many byte stream classes. To demonstrate how byte streams work, we'll focus on the file I/O byte streams, FileInputStream and FileOutputStream. Other kinds of byte streams are used in much the same way; they differ mainly in the way they are constructed.
 * 
 * 
 * */

public class FilesDemo {
	public static void main(String[] args)  throws IOException{
		final String outputFile = "src/main/resources/OutputFile.txt";
		final String inputFile = "src/main/resources/InputFile.txt";
		File outputFileHandler = new File(outputFile);
		File inputFileHandler = new File(inputFile);
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			if(outputFileHandler.createNewFile() || inputFileHandler.exists()) {
				System.out.println("Working...");
				in = new FileInputStream(inputFile);
				out = new FileOutputStream(outputFile);
				int c;
				int bytesRead = 0;
				while((c = in.read()) != -1) {
					out.write(c);
					bytesRead++;
				}
				System.out.println("Bytes: " + bytesRead);
			} else {
				System.out.println("Errors...");
			}
		} 
		finally {
			if(out!=null){
				out.close();
			}
			if(in!=null) {
				in.close();
			}
		}
	}
	
	
}
