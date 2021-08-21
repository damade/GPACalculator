package com.ou.gpa_calculator.LocalData.StaticData;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class MainDataClass {


    private Hashtable<String, Hashtable<String,
            Hashtable<String, ArrayList<CourseData>>>> mainDataDict = new Hashtable<>();


    public MainDataClass() {

        //BCH
        BchDataClass dataClassBch = new BchDataClass();
        mainDataDict.put(StaticVariables.Biochemistry, dataClassBch.getBchDataDict());


    }

    public Hashtable<String, Hashtable<String,
            Hashtable<String, ArrayList<CourseData>>>> getMainData() {
        return mainDataDict;
    }


    public ArrayList<CourseData> getCourseList(String dept, String year, String semester) {

        return Objects.requireNonNull(mainDataDict.get(dept)).get(year).get(semester);
    }





}
