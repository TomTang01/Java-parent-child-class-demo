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
import java.io.*;

/**
 * concrete subclass of MyFile
 * contains elements for a zipped file
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class ZippedFile extends MyFile
{
    private FSComponent[] componentArray;

    /*
     * no arg constructor
     */
    public ZippedFile()
    {
    }

    /*
     * custom constructor
     */
    public ZippedFile(String name, FSComponent[] componentArray)
    {
        super(name);
        if(!name.endsWith(".zip"))
        {
            setName(name + ".zip");
        }
        this.componentArray = componentArray;

    }

    /**
     * write each of the names of the FSComponents stored in componentArray
     * on a new line in the file named outputFileName 
     * within the current directory
     *
     * @param (String outputFileName) (the file to write to)
     * 
     * @return (void)
     */
    @Override
    public void outputFileContents(String outputFileName) throws Exception
    {
        if(componentArray.length==0 ||
            componentArray == null)
        {
            throw new Exception("Empty file content!");
        }
        else 
        {
            java.io.File outputFile = new File(outputFileName);
            try 
            {
                outputFile.delete();
                outputFile.createNewFile();
                PrintWriter write = new PrintWriter(outputFile);
                //write all of the file names in the componentArray
                for(int i=0; i<componentArray.length; ++i)
                {
                    write.println(componentArray[i].getName());
                }
                write.close();
            } catch (Exception ex) 
            {
                System.out.println(ex.getMessage());
                throw ex;
            }
        }
    }

    /**
     * overrides the equals method in the MyFile class to check 
     * if the equals method of the MyFile class returns true and 
     * if both componentArrays contain the same elements
     *
     * @param (Object obj) (the input object)
     *
     * @return (true if they both are NormalFile and have the same contents)
     */
    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj) &&
            obj instanceof ZippedFile)
        {
            if(componentArray.length!=
                ((ZippedFile)obj).componentArray.length)
            {
                return false;
            }
            //checks all the element in the component arrays
            for(int i=0; i<componentArray.length; ++i)
            {
                if(componentArray[i]!=((ZippedFile)obj).componentArray[i])
                {
                    return false;
                }
            }
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**
     * This method returns the string representation 
     * of the ZippedFile object
     *
     * @return (the string representation of the ZippedFile Object)
     */
    @Override
    public String toString()
    {
        return "Zipped file: " + this.getName();
    }
}