///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment7
// Files:              Assignment7 starter code: Assignment7.java
// Quarter:            CSE8B Spring 2023
//
// Author:             Tom Tang
// Email:              zit008@ucsd.edu
// Instructor's Name:  Ben Ochoa
//
///////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/**
 * cheks that all of the classes and methods are functioning as they should
 *
 * Bugs: none
 *
 * @author Tom Tang
 */
public class Assignment7 {
    /**
     * A tester for the file system.
     * 
     * @return return true if the tester passes
     */
    private static boolean testOne() {
        RootDirectory root = new RootDirectory("Home");
        NormalFile pic = new NormalFile("cat.png", "contents of picture");
        NormalFile rice = new NormalFile("rice.mp3", "contents of mp3 file");
        SubDirectory music = new SubDirectory("music");
        root.addComponent(pic);
        root.addComponent(rice);
        root.addComponent(music);

        if (!root.getName().equals("Home")) return false;
        if (!pic.getName().equals("cat.png")) return false;
        if (!rice.getName().equals("rice.mp3")) return false;
        if (!music.getName().equals("music")) return false;

        System.out.println();
        return true;
    }

    /**
     * A tester for the file system.
     * 
     * @return return true if the tester passes
     */
    private static boolean testTwo() {
        NormalFile pic1 = new NormalFile("cat.png", "contents of picture");
        NormalFile pic2 = new NormalFile("cat.png", "contents of picture");
        

        if (!pic1.equals(pic2)) return false;

        NormalFile pic3 = new NormalFile("cat.png", "contents of picture");
        Directory dir = new SubDirectory("test");
        pic2.setParentDir(dir);
        pic3.setParentDir(dir);

        if (!pic2.equals(pic3)) return false;

        System.out.println();
        return true;
    }

    /**
     * A tester for the file system.
     * 
     * @return return true if the tester passes
     */
    private static boolean testThree() {
        NormalFile pic1 = new NormalFile("cat.png", "");
        pic1.setContents("cat pictures");
        NormalFile pic2 = new NormalFile("dog.png", "dog pictures");
        NormalFile pic3 = new NormalFile("kitty.png", "");
        Directory dir1 = new SubDirectory("UCSD\\8b\\cse8b\\assignment7\\Test");
        Directory dir2 = new SubDirectory("UCSD\\8b\\cse8b\\assignment7\\Test");
        pic1.setParentDir(dir1);
        pic2.setParentDir(dir1);
        pic3.setParentDir(dir1);
        try
        {
            pic1.outputFileContents("Test.txt");
            pic3.inputFileContents("Test.txt");
            if(!pic3.getContents().equals("cat pictures"))
            {
                return false;
            }
            pic3.setName("cat.png");
            if(!pic3.equals(pic1))
            {
                return false;
            }
            pic3.setParentDir(dir2);
            if(pic3.equals(pic1))
            {
                return false;
            }
            File file1 = new File("Test3.txt");
            file1.createNewFile();
            pic3.inputFileContents("Test3.txt");
            if(!pic3.getContents().equals("")) return false;
            File file2 = new File("Test4.txt");
            PrintWriter write = new PrintWriter(file2);
            write.print("House cats ");
            write.println("stray cats");
            write.print("1 month olds");
            write.close();
            pic3.inputFileContents("Test4.txt");
            if(!pic3.getContents().equals(
                "House cats stray cats\n1 month olds")) 
            {return false;}
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }

    /**
     * A tester for the file system.
     * 
     * @return return true if the tester passes
     */
    private static boolean testFour()
    {
        RootDirectory root = new RootDirectory("Home");
        NormalFile pic = new NormalFile("cat.png", "contents of picture");
        NormalFile rice = new NormalFile("rice.mp3", "contents of mp3 file");
        SubDirectory music = new SubDirectory("music");

        Directory dir1 = new SubDirectory("UCSD\\8b\\cse8b\\assignment7\\Test");
        dir1.addComponent(root);
        dir1.addComponent(pic);
        dir1.addComponent(rice);
        dir1.addComponent(music);
        dir1.appendComponent(root);
        dir1.addComponent(pic);
        ArrayList<FSComponent> list = dir1.getComponentList();
        //System.out.println(list.size());
        if(list.size() != 5) return false;
        if(!list.get(0).toString().equals("Root Directory: Home")) return false;
        if(!list.get(1).toString().equals("Normal file: cat.png")) return false;
        if(!list.get(2).toString().equals("Normal file: rice.mp3")) return false;
        if(!list.get(3).toString().equals("Sub directory: music")) return false;
        if(!list.get(4).toString().equals("Root Directory: Home")) return false;
        return true;
    }

    /**
     * A tester for the file system.
     * 
     * @return return true if the tester passes
     */
    private static boolean testFive()
    {
        FSComponent[] arr = {new RootDirectory("Home"),
        new NormalFile("cat.png", "contents of picture"),
        new NormalFile("rice.zip", "contents of mp3 file"),
        new SubDirectory("musiczip")};

        ZippedFile zip = new ZippedFile("Testzip",arr);
        if(!zip.getName().equals("Testzip.zip")) return false;
        try
        {
            zip.outputFileContents("zipTest");
            Scanner scan = new Scanner(new File("zipTest"));
            if(!scan.next().equals("Home")) return false;
            if(!scan.next().equals("cat.png")) return false;
            if(!scan.next().equals("rice.zip")) return false;
            if(!scan.next().equals("musiczip")) return false;
            scan.close();
        }
        catch(Exception ex)
        {
            return false;
        }

        return true;
    }
    
    public static boolean testSix()
    {
        NormalFile pic1 = new NormalFile("cat.png", "cat pictures");
        NormalFile pic2 = new NormalFile("cat.png", "cat pictures");
        SubDirectory dir1 = new SubDirectory("UCSD\\8b\\cse8b\\assignment7\\Test");
        if(!pic1.equals(pic2)) return false;
        pic1.setParentDir(dir1);
        if(pic1.equals(pic2)) return false;
        pic1.setContents("");
        try
        {
            pic1.outputFileContents("Test2.txt");
        }
        catch(Exception ex)
        {
            if(ex.getMessage().equals("Empty file content!")) 
            {}
            else return false;
        }

        try
        {
            pic1.inputFileContents("Test5.txt");
            return false;
        }
        catch(Exception ex)
        {
            
        }

        return true;
    }
    
    /**
     * All unit tests. This method should be executed to ensure that all
     * methods are correctly implemented.
     * 
     * @return true if all unit tests passed, false otherwise.
     */
    public static boolean unitTests() {
        if (!testOne()) {
            return false;
        }

        if (!testTwo()) {
            return false;
        }

        if (!testThree()) {
            return false;
        }

        if (!testFour()) {
            return false;
        }

        if (!testFive()) {
            return false;
        }
        if (!testSix()) {
            return false;
        }
        
        return true;
    }

    /**
     * The main method, where program execution begins.
     * 
     * @param args Any command-line arguments.
     */
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
        }
        // Don't need to write code here!
    }
}