package com.ou.gpa_calculator.LocalData.StaticData;

import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;

public class BchDataClass {


    private Hashtable<String, Hashtable<String,ArrayList<CourseData>>> bchDataDict = new Hashtable<>();


    public Hashtable<String, Hashtable<String,ArrayList<CourseData>>> getBchDataDict() {
        return bchDataDict;
    }

    public BchDataClass() {
        bchDataDict.put("100", flDict());
        bchDataDict.put("200",slDict());
        bchDataDict.put("300",flDict());
        bchDataDict.put("400",flDict());

    }

    private Hashtable<String,ArrayList<CourseData>> flDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", flFirstSemesterCourse());
        data.put("Second",flSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData>  flSecondSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO102","GENERAL BIOLOGY II",3));
        list.add(new CourseData("BIO108","EXPERIMENTAL BIOLOGY II",1));
        list.add(new CourseData("CHM102","GENERAL ORGANIC CHEMISTRY I",3));
        list.add(new CourseData("CHM108","EXPERIMENTAL CHEMISTRY II",1));
        list.add(new CourseData("MTH102","ELEMENTARY MATHEMATICS II",3));
        list.add(new CourseData("PHY102","GENERAL PHYSICS II",3));
        list.add(new CourseData("PHY108","EXPERIMENTAL PHYSICS II",1));
        list.add(new CourseData("GST102","GAFRICAN CULTURE AND CIVILISATION",2));
        list.add(new CourseData("GST104","ENTREPRENEURIAL SKILLS",2));


        return list;
    }

    private ArrayList<CourseData>  flFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO101","GENERAL BIOLOGY I",3));
        list.add(new CourseData("BIO107","EXPERIMENTAL BIOLOGY I",1));
        list.add(new CourseData("CHM101","GENERAL PHYSICAL CHEMISTRY I",3));
        list.add(new CourseData("CHM103","GENERAL INORGANIC CHEMISTRY I",2));
        list.add(new CourseData("CHM107","EXPERIMENTAL CHEMISTRY I",1));
        list.add(new CourseData("CSC101","INTRODUCTION TO COMPUTER SCIENCE",3));
        list.add(new CourseData("MTH101","ELEMENTARY MATHEMATICS I",3));
        list.add(new CourseData("PHY101","GENERAL PHYSICS",3));
        list.add(new CourseData("PHY107","EXPERIMENTAL PHYSICS I",1));
        list.add(new CourseData("GST101","USE OF ENGLISH",2));
        list.add(new CourseData("GST105","USE OF LIBRARY",2));
        list.add(new CourseData("ENG001","COMMUNICATION IN ENGLISH I",0));


        return list;
    }

    private Hashtable<String,ArrayList<CourseData>> slDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", slFirstSemesterCourse());
        data.put("Second",slSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData>  slSecondSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH202","STRUCTURE AND CHEMISTRY OF BIOMOLECULES",3));
        list.add(new CourseData("BCH204","GENERAL ASPECTS OF METABOLISM",3));
        list.add(new CourseData("BCH206","INTRODUCTORY PHYSIOLOGY AND PHARMACOLOGY",3));
        list.add(new CourseData("BCH214","GENERAL BIOCHEMISTRY LAB II",1));
        list.add(new CourseData("CHM204","EXPERIMENTAL CHEMISTRY III",1));
        list.add(new CourseData("CHM210","PHYSICAL CHEMISTRY II",3));
        list.add(new CourseData("CHM212","INORGANIC CHEMISTRY II",2));
        list.add(new CourseData("GST202","LOGIC PHILOSOPHY OF SCIENCE",2));
        list.add(new CourseData("GST204","HEALTH EDUCATION AND BASIC EPIDEMIOLOGY",2));
        list.add(new CourseData("ENG 002","COMMUNICATION IN ENGLISH II",0));


        return list;
    }

    private ArrayList<CourseData>  slFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO101","GENERAL BIOLOGY I",3));
        list.add(new CourseData("BIO107","EXPERIMENTAL BIOLOGY I",1));
        list.add(new CourseData("CHM101","GENERAL PHYSICAL CHEMISTRY I",3));
        list.add(new CourseData("CHM103","GENERAL INORGANIC CHEMISTRY I",2));
        list.add(new CourseData("CHM107","EXPERIMENTAL CHEMISTRY I",1));
        list.add(new CourseData("CSC101","INTRODUCTION TO COMPUTER SCIENCE",3));
        list.add(new CourseData("MTH101","ELEMENTARY MATHEMATICS I",3));
        list.add(new CourseData("PHY101","GENERAL PHYSICS",3));
        list.add(new CourseData("PHY107","EXPERIMENTAL PHYSICS I",1));
        list.add(new CourseData("GST101","USE OF ENGLISH",2));
        list.add(new CourseData("GST105","USE OF LIBRARY",2));
        list.add(new CourseData("ENG001","COMMUNICATION IN ENGLISH I",0));


        return list;
    }

    private Hashtable<String,ArrayList<CourseData>> tlDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", tlFirstSemesterCourse());
        data.put("Second",tlSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData>  tlSecondSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO102","GENERAL BIOLOGY II",3));
        list.add(new CourseData("BIO108","EXPERIMENTAL BIOLOGY II",1));
        list.add(new CourseData("CHM102","GENERAL ORGANIC CHEMISTRY I",3));
        list.add(new CourseData("CHM108","EXPERIMENTAL CHEMISTRY II",1));
        list.add(new CourseData("MTH102","ELEMENTARY MATHEMATICS II",3));
        list.add(new CourseData("PHY102","GENERAL PHYSICS II",3));
        list.add(new CourseData("PHY108","EXPERIMENTAL PHYSICS II",1));
        list.add(new CourseData("GST102","GAFRICAN CULTURE AND CIVILISATION",2));
        list.add(new CourseData("GST104","ENTREPRENEURIAL SKILLS",2));


        return list;
    }

    private ArrayList<CourseData>  tlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO101","GENERAL BIOLOGY I",3));
        list.add(new CourseData("BIO107","EXPERIMENTAL BIOLOGY I",1));
        list.add(new CourseData("CHM101","GENERAL PHYSICAL CHEMISTRY I",3));
        list.add(new CourseData("CHM103","GENERAL INORGANIC CHEMISTRY I",2));
        list.add(new CourseData("CHM107","EXPERIMENTAL CHEMISTRY I",1));
        list.add(new CourseData("CSC101","INTRODUCTION TO COMPUTER SCIENCE",3));
        list.add(new CourseData("MTH101","ELEMENTARY MATHEMATICS I",3));
        list.add(new CourseData("PHY101","GENERAL PHYSICS",3));
        list.add(new CourseData("PHY107","EXPERIMENTAL PHYSICS I",1));
        list.add(new CourseData("GST101","USE OF ENGLISH",2));
        list.add(new CourseData("GST105","USE OF LIBRARY",2));
        list.add(new CourseData("ENG001","COMMUNICATION IN ENGLISH I",0));


        return list;
    }


    private Hashtable<String,ArrayList<CourseData>> finlDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", finlFirstSemesterCourse());
        data.put("Second",finlSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData>  finlSecondSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO102","GENERAL BIOLOGY II",3));
        list.add(new CourseData("BIO108","EXPERIMENTAL BIOLOGY II",1));
        list.add(new CourseData("CHM102","GENERAL ORGANIC CHEMISTRY I",3));
        list.add(new CourseData("CHM108","EXPERIMENTAL CHEMISTRY II",1));
        list.add(new CourseData("MTH102","ELEMENTARY MATHEMATICS II",3));
        list.add(new CourseData("PHY102","GENERAL PHYSICS II",3));
        list.add(new CourseData("PHY108","EXPERIMENTAL PHYSICS II",1));
        list.add(new CourseData("GST102","GAFRICAN CULTURE AND CIVILISATION",2));
        list.add(new CourseData("GST104","ENTREPRENEURIAL SKILLS",2));


        return list;
    }

    private ArrayList<CourseData>  finlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO101","GENERAL BIOLOGY I",3));
        list.add(new CourseData("BIO107","EXPERIMENTAL BIOLOGY I",1));
        list.add(new CourseData("CHM101","GENERAL PHYSICAL CHEMISTRY I",3));
        list.add(new CourseData("CHM103","GENERAL INORGANIC CHEMISTRY I",2));
        list.add(new CourseData("CHM107","EXPERIMENTAL CHEMISTRY I",1));
        list.add(new CourseData("CSC101","INTRODUCTION TO COMPUTER SCIENCE",3));
        list.add(new CourseData("MTH101","ELEMENTARY MATHEMATICS I",3));
        list.add(new CourseData("PHY101","GENERAL PHYSICS",3));
        list.add(new CourseData("PHY107","EXPERIMENTAL PHYSICS I",1));
        list.add(new CourseData("GST101","USE OF ENGLISH",2));
        list.add(new CourseData("GST105","USE OF LIBRARY",2));
        list.add(new CourseData("ENG001","COMMUNICATION IN ENGLISH I",0));


        return list;
    }



}
