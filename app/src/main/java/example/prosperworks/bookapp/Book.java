package example.prosperworks.bookapp;

import java.io.Serializable;

/**
 * Created by markevans on 7/13/16.
 */
public class Book implements Serializable {
    private String mTitle;
    private String mFname;
    private String mLname;
    private String mAge;

    public Book(String title, String fname, String lname, String age) {
        mTitle = title;
        mFname = fname;
        mLname = lname;
        mAge = age;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getFname() {
        return mFname;
    }

    public void setFname(String fname) {
        mFname = fname;
    }

    public String getLname() {
        return mLname;
    }

    public void setLname(String lname) {
        mLname = lname;
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String age) {
        mAge = age;
    }
}
