package edu.usc.softarch.arcade.frontend.arghandlers;

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
  public boolean validate(String value)
    throws Exception
  {
    //TODO
    return true;
  }
  //#endregion
}