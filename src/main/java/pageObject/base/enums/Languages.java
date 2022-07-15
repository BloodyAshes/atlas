package pageObject.base.enums;

public enum Languages {
    UA("uk"),
    EN_US("en-us"),
    EN_UK("en-gb"),
    TR("tr"),
    PL("pl"),
    RU("ru");

    private String lang;


    Languages(String lang){
        this.lang = lang;
    }

    public String getLang(){
        return lang;
    }

    @Override
    public String toString() {
        return lang;
    }
}
