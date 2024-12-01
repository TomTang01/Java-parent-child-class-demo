///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment7.java
// Files:              Assignment7 starter code: MyFile.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.io.IOException;
import java.util.ArrayList;

/**
 * An abstract subclass of FSComponent containing general data
 * fields and methods for files
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public abstract class MyFile extends FSComponent  {

    private Directory parentDir;

    /**
     * No-arg constructor. 
     * DO NOT CHANGE!
     */
    protected MyFile() {
        super("My File");
    }

    /**
     * custom constructor
     *
     * @param (String name) (the name to assign to the MyFile object)
     */
    protected MyFile(String name) {
        super(name);
    }

    /**
     * checks if the FSComponent is a MyFile
     *
     * @return (true)
     */
    public boolean isFile() {
        return true;
    }

    /**
     * checks if the FSComponent is a Directory
     *
     * @return (false)
     */
    public boolean isDirectory() {
        return false;
    }

    /**
     * Public getter that retrieves instance variable - parentDir
     * DO NOT CHANGE!
     * 
     * @return instance variable - parentDir
     */
    public Directory getParentDir() {
        return this.parentDir;
    }

    /**
     * Public setter that mutates instance variable - parentDir
     * DO NOT CHANGE!
     * 
     * @param parentDir instance variable - parentDir
     */
    @Override
    public void setParentDir(Directory parentDir) {
        this.parentDir = parentDir;
    }

    /**
     * overrides the equals method in the FSComponent class to check 
     * if the equals method of the FSComponent class returns true and 
     * if they have the same parentDir
     *
     * @param (Object obj) (the input object)
     *
     * @return (true if they are both MyFile and have the same parentDir)
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MyFile))
        {
            return false;
        }
        if(parentDir==null || ((MyFile)obj).getParentDir()==null)
        {
            if(parentDir==null && ((MyFile)obj).getParentDir()==null)
            {
                return true;
            }
            return false;
        }
        else if(super.equals(obj))
        {
            return parentDir == ((MyFile)obj).getParentDir();
        }
        else 
        {
            return false;
        }
    }
    public abstract void outputFileContents(String outputFileName) throws Exception;
}