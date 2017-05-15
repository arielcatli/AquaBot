package projects.arielcatli.aquabot;

import java.util.Date;

/**
 * Created by Ariel Domingo Catli on 5/8/2017.
 */

public class DataPoint
{
    public enum TYPE
    {PH, TEMP, SAL, CON};


    private Date mDate;
    private double mReading;
    private TYPE mType;
    private long mX;
    private int mY;

    public DataPoint(Date date, double reading, TYPE type)
    {
        this.mDate = date;
        this.mReading = reading;
        this.mType = type;
        this.mX = date.getTime();
        this.mY =(int) mReading;
    }

    public Date getDate() {
        return mDate;
    }

    public double getReading() {
        return mReading;
    }

    public TYPE getType() {
        return mType;
    }

    public long getX() {
        return mX;
    }

    public int getY() {

        return mY;
    }
}
