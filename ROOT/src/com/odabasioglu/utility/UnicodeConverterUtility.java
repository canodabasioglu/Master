package com.odabasioglu.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


/**
 * @author Can Odabasioglu
 * Created on 25.Þub.2005
 * @version 1.02
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UnicodeConverterUtility
{

    private static final String CHAR1_UNICODE  = "\\u015F";                                                                  //þ
    private static final String CHAR2_UNICODE  = "\\u00E7";                                                                  //ç
    private static final String CHAR3_UNICODE  = "\\u0131";                                                                  //ý
    private static final String CHAR4_UNICODE  = "\\u011f";                                                                  //ð
    private static final String CHAR5_UNICODE  = "\\u00FC";                                                                  //ü
    private static final String CHAR6_UNICODE  = "\\u00F6";                                                                  //ö
    private static final String CHAR7_UNICODE  = "\\u015e";                                                                  //Þ
    private static final String CHAR8_UNICODE  = "\\u00C7";                                                                  //Ç
    private static final String CHAR9_UNICODE  = "\\u0130";                                                                  //Ý
    private static final String CHAR10_UNICODE = "\\u011e";                                                                  //Ð
    private static final String CHAR11_UNICODE = "\\u00DC";                                                                  //Ü
    private static final String CHAR12_UNICODE = "\\u00D6";

    private static final String CHAR1          = "þ";
    private static final String CHAR2          = "ç";
    private static final String CHAR3          = "ý";
    private static final String CHAR4          = "ð";
    private static final String CHAR5          = "ü";
    private static final String CHAR6          = "ö";
    private static final String CHAR7          = "Þ";
    private static final String CHAR8          = "Ç";
    private static final String CHAR9          = "Ý";
    private static final String CHAR10         = "Ð";
    private static final String CHAR11         = "Ü";
    private static final String CHAR12         = "Ö";
 
    // Only change these parameters
    private static final String INPUT_FILE     = "formtext_unicode.properties";
    private static final String OUTPUT_FILE    = "#modulebundle.properties";
    private static final String PATH           = "C:\\Documents and Settings\\can\\workspace\\Model\\src\\com\\odabasioglu\\resources\\";
    private static final boolean IS_REVERSE=true;
   //private static final String INPUT_FILE     = "controls.js";
 // private static final String OUTPUT_FILE    = "controls2.js";
   // private static final String PATH           = "C:\\Program Files\\eclipse\\workspace\\Framework\\WebContent\\script\\js\\";

    public static String replace(String target, String from, String to)
    {
        int start = target.indexOf(from);
        if (start == -1)
            return target;
        int lf = from.length();
        char[] targetChars = target.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int copyFrom = 0;
        while (start != -1)
        {
            buffer.append(targetChars, copyFrom, start - copyFrom);
            buffer.append(to);
            copyFrom = start + lf;
            start = target.indexOf(from, copyFrom);
        }
        buffer.append(targetChars, copyFrom, targetChars.length - copyFrom);
        return buffer.toString();
    }

    public static void main(String[] args)
    {
        try
        {
            //ResourceUtility resource = new ResourceUtility("application");
            
        	
        	System.out.println("FILE PATH >> " + PATH + "\n");
        	 File inputFile = new File(PATH + UnicodeConverterUtility.INPUT_FILE);
            
            if(!inputFile.exists()){
                System.out.println("File Not Exists !!!");
                return;
            }
            System.out.println("Last modified >>"+new Date(inputFile.lastModified()));
            System.out.println("Last modified >>"+inputFile.setReadOnly());
            
            System.out.println("INPUT FILE READ >> " + UnicodeConverterUtility.INPUT_FILE + "\n");
            File outputFile = new File(PATH + UnicodeConverterUtility.OUTPUT_FILE);
            String result = getContents(inputFile);
            FileInputStream in = new FileInputStream(inputFile);
            FileWriter out = new FileWriter(outputFile);
            String unicodeText="";
          
			if(IS_REVERSE){
            
            unicodeText = replace(result, CHAR1, CHAR1_UNICODE);
            unicodeText = replace(unicodeText, CHAR2, CHAR2_UNICODE);
            unicodeText = replace(unicodeText, CHAR3, CHAR3_UNICODE);
            unicodeText = replace(unicodeText, CHAR4, CHAR4_UNICODE);
            unicodeText = replace(unicodeText, CHAR5, CHAR5_UNICODE);
            unicodeText = replace(unicodeText, CHAR6, CHAR6_UNICODE);
            unicodeText = replace(unicodeText, CHAR7, CHAR7_UNICODE);
            unicodeText = replace(unicodeText, CHAR8, CHAR8_UNICODE);
            unicodeText = replace(unicodeText, CHAR9, CHAR9_UNICODE);
            unicodeText = replace(unicodeText, CHAR10, CHAR10_UNICODE);
            unicodeText = replace(unicodeText, CHAR11, CHAR11_UNICODE);
            unicodeText = replace(unicodeText, CHAR12, CHAR12_UNICODE);
            
            }else{
           
            unicodeText = replace(result, CHAR1_UNICODE, CHAR1);
            unicodeText = replace(unicodeText, CHAR2_UNICODE, CHAR2);
            unicodeText = replace(unicodeText, CHAR3_UNICODE, CHAR3);
            unicodeText = replace(unicodeText, CHAR4_UNICODE, CHAR4);
            unicodeText = replace(unicodeText, CHAR5_UNICODE, CHAR5);
            unicodeText = replace(unicodeText, CHAR6_UNICODE, CHAR6);
            unicodeText = replace(unicodeText, CHAR7_UNICODE, CHAR7);
            unicodeText = replace(unicodeText, CHAR8_UNICODE, CHAR8);
            unicodeText = replace(unicodeText, CHAR9_UNICODE, CHAR9);
            unicodeText = replace(unicodeText, CHAR10_UNICODE, CHAR10);
            unicodeText = replace(unicodeText, CHAR11_UNICODE, CHAR11);
            unicodeText = replace(unicodeText, CHAR12_UNICODE, CHAR12);
            }
            
            out.write(unicodeText);
            System.out.println("UNICODE FILE CREATED >> " + UnicodeConverterUtility.OUTPUT_FILE);

            in.close();
            out.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static String getContents(File aFile)
    {
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try
        {
            input = new BufferedReader(new FileReader(aFile));
            String line = null;
            while ((line = input.readLine()) != null)
            {
                contents.append(line);
                contents.append(System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException ex)
        {
        	
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
        	
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (input != null)
                {
                    //flush and close both "input" and its underlying FileReader
                    input.close();
                }
            }
            catch (IOException ex)
            {
            	
                ex.printStackTrace();
            }
        }
        return contents.toString();
    }
}
