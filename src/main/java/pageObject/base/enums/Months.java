package pageObject.base.enums;

public enum Months {
    JANUARY(1, "JANUARY"),
    FEBRUARY(2, "FEBRUARY"),
    MARCH(3, "MARCH"),
    APRIL(4, "APRIL"),
    MAY(5, "MAY"),
    JUNE(6, "JUNE"),
    JULY(7, "JULY"),
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
