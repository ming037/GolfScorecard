package hh.com.golfscorecard;

/**
 * Created by Administrator on 2017-02-16.
 */

public class Hole {
    private String mLable;
    private int mStrokeCount;

    public String getLable() {
        return mLable;
    }

    public void setLable(String lable) {
        mLable = lable;
    }

    public int getStrokeCount() {
        return mStrokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        mStrokeCount = strokeCount;
    }

    public Hole(String lable, int strokeCount)
    {
        mLable = lable;
        mStrokeCount = strokeCount;

    }
}
