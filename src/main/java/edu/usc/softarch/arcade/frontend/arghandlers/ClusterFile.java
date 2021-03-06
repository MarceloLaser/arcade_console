package edu.usc.softarch.arcade.frontend.arghandlers;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;

/**
 * Argument Handler for the path of a Clusters file, typically of the form
 * *_cluster.rsf.
 *
 * @author Marcelo Schmitt Laser
 */
public class ClusterFile
  extends ArgHandler
{
  //#region ATTRIBUTES
  private static ArgHandler clusterFile;
  //#endregion

  //#region CONSTRUCTORS
  private ClusterFile()
  {
    String name = "clusterFile";
    String description = "Cluster RSF File";
    String instruction = "Cluster RSF file: This is a file generated by an ";
    instruction += "architectural recovery technique, usually of the form ";
    instruction += "*_cluster.rsf.";

    initialize(name, description, instruction);
  }

  public static ArgHandler getInstance()
  {
    if(clusterFile == null) clusterFile = new ClusterFile();
    return clusterFile;
  }
  //#endregion

  //#region VALIDATION
  @Override
  public boolean validateAsInput(String value)
    throws Exception
  {
    File clusterFile = new File(value);
    if(!clusterFile.exists())
      throw new FileNotFoundException(value + " not found.");
    else if ((value.length() < 4) 
			|| !(value.substring(value.length()-4).equals(".rsf"))) 
			{		      
		      throw new IllegalArgumentException(value + "Invalid file type (must be .rsf file)" );
		    }	   

    return true;
  }

  @Override
  public boolean validateAsOutput(String value)
    throws Exception
  {
    File clusterFile = new File(value);
    if (!clusterFile.getParentFile().exists()
      && !clusterFile.getParentFile().mkdirs())
        throw new IOException("Failed to create Cluster .ser output directory.");

    return true;
  }
 
  //#endregion
}
