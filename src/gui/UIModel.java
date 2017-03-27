package gui;

public class UIModel {

    private String username;
    private boolean usernameEntered;
    private String sourceFilePath;
    private String zipFilePath;
    private String sourceFileName;
    private String zipFileName;

    //check if start scan button has been pressed
    private boolean runStatus;

    //maybe change to tone frequency(int) later
    // 0 = Warning, 1 = Error, 2 = Critical
    private String[] AlertTones = {"Ping", "Chime", "Ping"};

    //0 - Warning, 1 - Error, 2 - Critical
    private boolean[] severityBoxes = new boolean[3];

    //Include File sourceFile
    //Include Event ID, Time, etc. for table


    UIModel(){
        //initialize variables
        this.usernameEntered = false;
        this.runStatus = false;
    }

    String getUsername(){
        return this.username;
    }

    void setUsername(String name){
        this.username = name;
    }

    boolean getUsernameEntered(){
        return this.usernameEntered;
    }

    void setUsernameEntered(boolean nameSet){
        this.usernameEntered = nameSet;
    }

    String getsourceFilePath(){return this.sourceFilePath;}

    void setSourceFilePath(String path){
        this.sourceFilePath = path;
    }

    String getZipFilePath(){
        return this.zipFilePath;
    }

    void setZipFilePath(String path){
        this.zipFilePath = path;
    }

    String getZipFileName(){return this.zipFileName;}

    void setZipFileName(String name){ this.zipFileName = name;}

    String getSourceFileName(){
        return this.sourceFileName;
    }

    void setSourceFileName(String name){
        this.sourceFileName = name;
    }

    String getAlertTones(int index){ return this.AlertTones[index];}

    void setAlertTones(int index, String tone){this.AlertTones[index]= tone;}

    boolean getRunStatus(){return this.runStatus;}

    void setRunStatus(boolean status){this.runStatus = status;}

    void setSeverityBoxes(int index, boolean value){ this.severityBoxes[index] = value;}

    boolean getSeverityBoxes(int index){ return this.severityBoxes[index];}
}
