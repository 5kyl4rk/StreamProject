package stream.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter; //writes to file
import java.io.File;//makes a File object, this is needed in order for the Scanner to read it
import java.util.Scanner;//reads file

public class StreamController
{

	PrintWriter outputStream;
	File file;
	String fileName;
	String filePath;
	Scanner reader;
	boolean isFile;

	public StreamController()
	{
		isFile = true;
		fileName = "out.txt";// makes a new file call "out.txt", if there's no file, it will create a new
								// one, else, it will erase it and overwrite it
		filePath = "C:\\Users\\Skyler\\eclipse-workspace\\HelloCruelWorld\\src\\hello.java";
		try// 'try-catch' is used to prevent program from crashing if file can't be
			// accessed
		{
			file = new File(fileName);
			outputStream = new PrintWriter(fileName);
			reader = new Scanner(file);
		}
		catch(FileNotFoundException error)
		{
			System.out.println("couldn't open file");
			isFile = false;

		}

	}

	public void start()
	{
		if(isFile)
		{
			outputStream.println("here's line 1");
			outputStream.println("here's line 2");
			outputStream.close();
			while (reader.hasNextLine())
			{
				System.out.println(reader.nextLine());
			}
			System.out.println("filePath: " + file.getAbsolutePath());
			System.out.println("Readable?: " + file.canRead());
			System.out.println("Writable?: " + file.canWrite());
			System.out.print("Hidden?: " + file.isHidden());
			reader.close();
		}

	}

}
