package pageObject.base.enums;

public enum Months {
    JANUARY(01, "JANUARY"),
    FEBRUARY(02, "FEBRUARY"),
    MARCH(03, "MARCH"),
    APRIL(04, "APRIL"),
    MAY(05, "MAY"),
    JUNE(06, "JUNE"),
    JULY(07, "JULY"),
    AUGUST(8, "AUGUST"),
    SEPTEMBER(9, "SEPTEMBER"),
    OCTOBER(10, "OCTOBER"),
    NOVEMBER(11, "NOVEMBER"),
    DECEMBER(12, "DECEMBER");

    private int month;
    private String name;


    Months(int month, String december){
        this.month = month;
        this.name = name();
    }

    public int getMonth(){
        return month;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
