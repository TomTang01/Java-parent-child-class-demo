///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment7.java
// Files:              none
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/**
 * concrete subclass of MyFile
 * contains elements for a normal file
 *
 * Bugs: none
 *
 * @author Tom Tang
 */

public class NormalFile extends MyFile
{
    private String contents;

    /*
     * no arg constructor
     */
    public NormalFile()
    {
    }

    /*
     * custom constructor
     */
    public NormalFile(String name, String contents)
    {
        super(name);
        this.contents = contents;
    }

    /**
     * Public getter method for contents
     *
     * @return (contents)
     */
    public String getContents()
    {
        return contents;
    }

    /**
     * Public setter that mutates instance variable - contents
     * 
     * @param parentDir instance variable - contents
     */
    public void setContents(String contents)
    {
        this.contents = contents;
    }

    /**
     * This method write the contents field to a file 
     * in the current directory
     *
     * @param (String outputFileName) (the file to write to)
     * 
     * @return (void)
     */
    @Override
    public void outputFileContents(String outputFileName) throws Exception
    {
        if(contents.equals("") ||
            contents == null)
        {
            throw new Exception("Empty file content!");
        }
        else 
        {
            try
            {
                java.io.File outputFile = new java.io.File(outputFileName);
                outputFile.delete();
                outputFile.createNewFile();
                PrintWriter write = new PrintWriter(outputFile);
                write.println(contents);
                write.close();
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
                throw ex;
            }
        }
    }

    /**
     * This method read the contents field to a file 
     * in the current directory
     * @param (String inputFileName) (the file to read from)
     * 
     * @return (void)
     */
    public void inputFileContents(String inputFileName) throws Exception
    {
        java.io.File inputFile = new java.io.File(inputFileName);
        try
        {
            Scanner input = new Scanner(inputFile);
            contents = "";
            if(input.hasNext())
            {
                contents += input.nextLine();
                while(input.hasNext())
                {
                    contents += ("\n" + input.nextLine());
                }
            input.close();
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    /**
     * overrides the equals method in the MyFile class to check 
     * if the equals method of the MyFile class returns true and 
     * if they have the same contents
     *
     * @param (Object obj) (the input object)
     *
     * @return (true if they both are NormalFile and have the same contents)
     */
    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj) &&
            obj instanceof NormalFile)
        {
            return contents.equals(((NormalFile)obj).getContents());
        }
        else 
        {
            return false;
        }
    }

    /**
     * This method returns the string representation 
     * of the NormalFile object
     *
     * @return (the string representation of the NormalFile Object)
     */
    @Override
    public String toString()
    {
        return "Normal file: " + this.getName();
    }
}