///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment7.java
// Files:              Assignment7 starter code: Directory.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * An abstract subclass of FSComponent containing general data
 * fields and methods for directories
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public abstract class Directory extends FSComponent {

    private ArrayList<FSComponent> componentList;

    /**
     * No-arg constructor.
     * DO NOT CHANGE!
     */
    protected Directory() {
        super("Directory");
    }

    /**
     * custom constructor.
     * 
     * @param (String name) name of the Directory
     */
    protected Directory(String name) {
        super(name);
        componentList = new ArrayList<FSComponent>();
    }

    /**
     * checks if this FSComponent is a MyFile
     *
     * @return (false)
    */
    @Override
    public boolean isFile() {
        return false;
    }

    /**
     * checks if this FSComponent is a Directory
     *
     * @return (true)
    */
    @Override
    public boolean isDirectory() {
        return true;
    }

    /**
     * Public getter that retrieves instance variable - componentList.
     * DO NOT CHANGE!
     * 
     * @return the componentList instance variable
     */
    public ArrayList<FSComponent> getComponentList() {
        return this.componentList;
    }

    /**
     * Public setter that mutate instance variable - componentList.
     * DO NOT CHANGE!
     * @param componentList the new componentList variable to be assigned
     */
    public void setComponentList(ArrayList<FSComponent> componentList) {
        this.componentList = componentList;
    }

    /**
     * Add a component to the end of the componentList.
     * DO NOT CHANGE!
     * 
     * @param newComp the new component to be appended
     */
    public void appendComponent(FSComponent newComp) {
        this.componentList.add(newComp);
        newComp.setParentDir(this);
    }
    
    /**
     * same as appendComponent but fails and returns false if there 
     * already exist a file or directory with the same name
     *
     * @param (FSComponent newComp) (Describe the first parameter here)
     * 
     * @return (true if the element is successfully add, otherwise false)
     */
    public boolean addComponent(FSComponent newComp) {
        
        //checks the ComponentList for same object
        for(int i=0; i<componentList.size(); ++i)
        {
            if(componentList.get(i) instanceof MyFile &&
                newComp instanceof MyFile)
            {
                if(componentList.get(i).getName().equals(newComp.getName()))
                {
                    return false;
                }
            }
            else if(componentList.get(i) instanceof Directory &&
            newComp instanceof Directory)
            {
                if(componentList.get(i).getName().equals(newComp.getName()))
                {
                    return false;
                }
            }
        }
        this.appendComponent(newComp);
        return true;
    }

    /**
     * write all of the names of the FSComponent objects onto 
     * the file with the name outputFileName
     *
     * @param (String outputFileName) (the file to write on)
     * 
     * @return (void)
     */
    public void outputComponentNames(String outputFileName) throws Exception {
        if(componentList == null || componentList.size()==0)
        {
            throw new Exception("Empty directory content!");
        }
        else
        {
            java.io.File outputFile = new java.io.File(outputFileName);
            try
            {
                outputFile.delete();
                outputFile.createNewFile();
                PrintWriter write = new PrintWriter(outputFile);
                //write all of the file names in the componentArray
                for(int i=0; i<componentList.size(); ++i)
                {
                    write.println(componentList.get(i).getName());
                }
                write.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                throw ex;
            }
        }
    }

    /**
     * overrides the equals method in the FSComponent class to check 
     * if the equals method of the FSComponent class returns true and 
     * if both componentList contain the same objects
     *
     * @param (Object obj) (the input object)
     *
     * @return (true if they are both MyFile 
     * and have the same elements in componentList)
     */
    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj) &&
            obj instanceof Directory)
        {
            if(componentList.size()!=((Directory)obj).componentList.size())
            {
                return false;
            }
            //check all elements in both componentLists
            for(int i=0; i<componentList.size(); ++i)
            {
                if(componentList.get(i)!=((Directory)obj).componentList.get(i))
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
}