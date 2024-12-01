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

/**
 * An concrete subclass of Directory containing general data
 * fields and methods for Sub directory
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class SubDirectory extends Directory
{
    private Directory parentDir;

    /**
     * No-arg constructor.
     * DO NOT CHANGE!
     */
    public SubDirectory()
    {
    }

    /**
     * custom constructor.
     * 
     * @param (String name) name of the SubDirectory
     */
    public SubDirectory(String name)
    {
        super(name);
    }

    /**
     * Public setter that mutates instance variable - parentDir
     * 
     * @param parentDir instance variable - parentDir
     */
    @Override
    public void setParentDir(Directory parentDir)
    {
        this.parentDir = parentDir;
    }

    /**
     * public getter method for instance variable parentDir
     *
     * @return (parentDir)
     */
    public Directory getParentDir()
    {
        return parentDir;
    }

    /**
     * overrides the equals method in the Directory class to check 
     * if the equals method of the Directory class returns true and 
     * if they have the same parentDir
     *
     * @param (Object obj) (the input object)
     *
     * @return (true if they are both MyFile and have the same parentDir)
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SubDirectory))
        {
            return false;
        }
        else if(parentDir==null || ((SubDirectory)obj).getParentDir()==null)
        {
            if(parentDir==null && ((SubDirectory)obj).getParentDir()==null)
            {
                return true;
            }
            return false;
        }
        else if(super.equals(obj))
        {
            return parentDir.equals(((MyFile)obj).getParentDir());
        }
        else 
        {
            return false;
        }
    }

    /**
     * This method returns the string representation 
     * of the SubDirectory object
     *
     * @return (the string representation of the SubDirectory Object)
     */
    @Override
    public String toString()
    {
        return "Sub directory: " + this.getName();
    }
}