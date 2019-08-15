package fcu.selab.progedu.project;

public enum ProjectTypeEnum {
  JAVAC("Javac"), MAVEN("Maven"), WEB("Web"), APP("App");

  private String type;

  private ProjectTypeEnum(String projectType) {
    this.type = projectType;
  }

  /**
   * 
   * @param type is proJectStatus String
   * @return status is getStatusProjecTypeEnum object
   */
  public static ProjectTypeEnum getProjectTypeEnum(String type) {
    for (ProjectTypeEnum projectType : ProjectTypeEnum.values()) {
      if (projectType.getTypeName().equals(type)) {
        return projectType;
      }
    }
    return null;
  }

  public String getTypeName() {
    return this.type;
  }
}