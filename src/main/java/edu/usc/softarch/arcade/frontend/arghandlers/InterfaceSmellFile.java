package edu.usc.softarch.arcade.frontend.arghandlers;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;

/**
 * Argument Handler for the path of a Interface Smell csv file, typically of the form
 * *_interface_smells.csv.
 *
 * @author Khoi
 */
public class InterfaceSmellFile
  extends ArgHandler
{
  //#region ATTRIBUTES
  private static ArgHandler interfaceSmellFile;
  //#endregion

  //#region CONSTRUCTORS
  private InterfaceSmellFile()
  {
    String name = "interfaceSmellFile";
    String description = "Interface Smell File";
    String instruction = "Interface Smell File: This is a file generated by an interface smell";
    instruction += " detection technique, usually of the form *_interface_smells.csv";

    initialize(name, description, instruction);
  }

  public static ArgHandler getInstance()
  {
    if(interfaceSmellFile == null) interfaceSmellFile = new InterfaceSmellFile();
    return interfaceSmellFile;
  }
  //#endregion

  //#region VALIDATION
  @Override
  public boolean validateAsInput(String value)
    throws Exception
    {
	  //TO DO
    return true;
  }

  @Override
  public boolean validateAsOutput(String value)
    throws Exception
  {
    File interfaceSmellFile = new File(value);
    if(!interfaceSmellFile.getParentFile().exists()
      && !interfaceSmellFile.getParentFile().mkdirs())
        throw new IOException("Failed to create Interface Smell directory.");

    return true;
  }   
  
  //#endregion
}