///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:    Assignment7.java
// Files:              Assignment7 starter code: FSComponent.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////

import javax.lang.model.util.ElementScanner6;


/**
 * An abstract class that has a single instance variable name, 
 * getter and setter associated with name, 
 * two protected constructors, and four abstract methods 
 * (setParentDir(Directory dir), isFile(), and isDirectory()) 
 * 
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public abstract class FSComponent {
    private String name;

    /**
     * No-arg constructor. 
     * DO NOT CHANGE!
     */
    protected FSComponent() {}

    /**
     * Public constructor that takes in a String.
     * DO NOT CHANGE!
     * 
     * @param name the name of the FSComponent
     */
    protected FSComponent(String name) {
        this.name = name;
    }

    /**
     * Public getter that retrieves instance variable - name
     * DO NOT CHANGE!
     * 
     * @return instance variable - name
     */
    public String getName() {
        return name;
    }

    /**
     * Public setter that mutates instance variable - name
     * DO NOT CHANGE!
     * @param name instance variable - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * overrides the equals method in the object class to check 
     * if the input object is of type FSComponent 
     * and if they have the same names
     *
     * @param (Object obj) (the input object)
     *
     * @return (true if they are both FSComponent and have the same name)
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FSComponent)
        {
            return name.equals(((FSComponent)obj).getName());
        }
        else
        {
            return false;
        }
    }

    /* The following four abstract methods need
     * to be implemented by its subclasses. 
     * DO NOT CHANGE! */
    public abstract void setParentDir(Directory dir);
    public abstract boolean isFile();
    public abstract boolean isDirectory();
}