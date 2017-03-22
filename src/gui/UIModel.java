package gui;

public class UIModel {

    private String username;
    private boolean usernameEntered;
    private String sourceFilePath;
    private String zipFilePath;
    private String sourceFileName;

    //check if start scan button has been pressed
    private boolean runStatus;

    //maybe change to tone frequency(int) later
    private String errorAlertTone;
    private String warningAlertTone;
    private String criticalAlertTone;

    //Include File sourceFile
    //Include Event ID, Time, etc. for table


    UIModel(){
        this.usernameEntered = false;
        this.runStatus = false;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String name){
        this.username = name;
    }

    boolean getUsernameEntered(){
        return this.usernameEntered;
    }

    void setUsernameEntered(boolean nameSet){
        this.usernameEntered = nameSet;
    }

    public String getsourceFilePath(){
        return this.sourceFilePath;
    }

    public void setSourceFilePath(String path){
        this.sourceFilePath = path;
    }

    public String getZipFilePath(){
        return this.zipFilePath;
    }

    public void setZipFilePath(String path){
        this.zipFilePath = path;
    }

    public String getSourceFileName(){
        return this.sourceFileName;
    }

    public void setSourceFileName(String name){
        this.sourceFileName = name;
    }

    public String getErrorAlertTone(){
        return this.errorAlertTone;
    }

    public void setErrorAlertTone(String tone){
        this.errorAlertTone = tone;
    }

    public String getCriticalAlertTone(){
        return this.criticalAlertTone;
    }

    public void setCriticalAlertTone(String tone){
        this.criticalAlertTone = tone;
    }

    public String getWarningAlertTone(){
        return this.warningAlertTone;
    }

    public void setWarningAlertTone(String tone){
        this.warningAlertTone = tone;
    }
}
