package edu.usc.softarch.arcade.frontend.arghandlers;

import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import edu.usc.softarch.arcade.frontend.arghandlers.ArgHandler;

public class DepsRsfFile
  extends ArgHandler
{
  //#region ATTRIBUTES
  private static ArgHandler depsRsfFile;
  //#endregion

  //#region CONSTRUCTORS
  private DepsRsfFile()
  {
    String name = "depsRsfFile";
    String description = "Dependencies RSF file";
    String instruction = "Dependencies RSF file: This is a file generated by ";
    instruction += "a dependency builder, usually of the form *_deps.rsf.";

    initialize(name, description, instruction);
  }

  public static ArgHandler getInstance()
  {
    if(depsRsfFile == null) depsRsfFile = new DepsRsfFile();
    return depsRsfFile;
  }
  //#endregion

  //#region VALIDATION
  @Override
  public boolean validateAsInput(String value)
    throws Exception
  {
    //TODO
	File depsFile = new File(value);
	    if(!depsFile.exists())
	    {	      
	      throw new FileNotFoundException(value + " not found.");
	    }
	    else if ((value.length() <= 4) 
	    		|| !(value.substring(value.length()-4).equals(".rsf"))) 
		    	{
		    	throw new IllegalArgumentException(value + " Invalid file type (must be .rsf file)");
			    }	   
	    
    return true;
  }
  
  @Override
  public boolean validateAsOutput(String value)
    throws Exception
  {
    //TODO
	
    return true;
  }
  
  @Override
  public boolean validate(String value)
    throws Exception
  {
    //TODO
	
    return true;
  }
  //#endregion
}
