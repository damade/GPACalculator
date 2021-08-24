package com.ou.gpa_calculator.LocalData.StaticData;

import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;

public class CompDataClass {

    private Hashtable<String, Hashtable<String, ArrayList<CourseData>>> CompDataDict = new Hashtable<>();


    public Hashtable<String, Hashtable<String,ArrayList<CourseData>>> getCompDataDict() {
        return CompDataDict;
    }

    public CompDataClass() {
        CompDataDict.put("100", flDict());
        CompDataDict.put("200",slDict());
        CompDataDict.put("300",tlDict());
        CompDataDict.put("400",finlDict());

    }

    private Hashtable<String,ArrayList<CourseData>> flDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", flFirstSemesterCourse());
        data.put("Second",flSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData>  flSecondSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("CHM 102","GENERAL ORGANIC CHEMISTRY I",3));
        list.add(new CourseData("CSC 102","INTRODUCTION TO COMPUTER SCIENCE II",3));
        list.add(new CourseData("MTH 102","ELEMENTARY MATHEMATICS II",3));
        list.add(new CourseData("MTH 112","INTRODUCTION TO VECTOR ANALYSIS",3));
        list.add(new CourseData("PHY 102","GENERAL PHYSICS II",3));
        list.add(new CourseData("STA 112","INTRODUCTION TO PROBABILITY I",2));
        list.add(new CourseData("GST 102","AFRICAN CULTURE AND CIVILISATION",2));
        list.add(new CourseData("GST 104","ENTREPRENEURIAL SKILLS",2));

        return list;
    }

    private ArrayList<CourseData>  flFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO 101","GENERAL BIOLOGY I",3));
        list.add(new CourseData("BIO 107","EXPERIMENTAL BIOLOGY I",1));
        list.add(new CourseData("CHM 101","GENERAL PHYSICAL CHEMISTRY I",3));
        list.add(new CourseData("CHM 103","GENERAL INORGANIC CHEMISTRY I",2));
        list.add(new CourseData("CHM 107","EXPERIMENTAL CHEMISTRY I",1));
        list.add(new CourseData("CSC 101","INTRODUCTION TO COMPUTER SCIENCE",3));
        list.add(new CourseData("PHY 101","GENERAL PHYSICS",3));
        list.add(new CourseData("PHY 107","EXPERIMENTAL PHYSICS I",1));
        list.add(new CourseData("GST 101","USE OF ENGLISH",2));
        list.add(new CourseData("GST 105","USE OF LIBRARY",2));
        list.add(new CourseData("ENG 001","COMMUNICATION IN ENGLISH I",0));


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

        list.add(new CourseData("CSC 202","INTRODUCTION TO COMPUTER PROGRAMMING II",3));
        list.add(new CourseData("CSC 206","DATA STRUCTURE AND PROCESSING I",3));
        list.add(new CourseData("MTH 202","MATHEMATICAL METHOD II",3));
        list.add(new CourseData("MTH 204","NUMERICAL ANALYSIS I",3));
        list.add(new CourseData("MTH 206","ABSTRACT ALGEBRA",3));
        list.add(new CourseData("MTH 210","COMPLEX ANALYSIS",3));
        list.add(new CourseData("STA 212","INTRODUCTION TO PROBABILITY II",2));
        list.add(new CourseData("GST 202","LOGIC PHILOSOPHY OF SCIENCE",2));
        list.add(new CourseData("ENG 002","COMMUNICATION IN ENGLISH II",0));


        return list;
    }

    private ArrayList<CourseData>  slFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH 201","INTRODUCTION TO PHYSICAL BIOCHEMISTRY",3));
        list.add(new CourseData("BIO 201","INTRODUCTORY GENETICS",3));
        list.add(new CourseData("BIO 233","BIOSTATISTICS I",2));
        list.add(new CourseData("CHM 211","ORGANIC CHEMISTRY II ",2));
        list.add(new CourseData("CHM 213","ANALYTICAL CHEMISTRY I",2));
        list.add(new CourseData("MCB 201","GENERAL MICROBIOLOGY I",3));
        list.add(new CourseData("MCB 203","BASIC TECHNIQUES IN MICROBIOLOGY",2));
        list.add(new CourseData("GST 203","HISTORY AND PHILOSOPHY OF SCIENCE",2));



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

        list.add(new CourseData("CSC 302","OBJECT ORIENTED PROGRAMMING",3));
        list.add(new CourseData("CSC 304","ALGORITHM AND COMPLEXITY ANALYSIS",3));
        list.add(new CourseData("CSC 306","DATA MANAGEMENT I",3));
        list.add(new CourseData("CSC 308","COMPILER CONSTRUCTION",2));
        list.add(new CourseData("CSC 310","COMPUTER ARCHITECTURE AND ORGANIZATION",2));
        list.add(new CourseData("CSC 312","NUMERICAL COMPUTATION II",2));
        list.add(new CourseData("CSC 314","SURVEYS OF PROGRAMMING LANGUAGES",2));

        return list;
    }

    private ArrayList<CourseData>  tlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("CSC 301","STRUCTURED PROGRAMMING",3));
        list.add(new CourseData("CSC 303","OPERATING SYSTEM II",3));
        list.add(new CourseData("CSC 305","SYSTEM ANALYSIS AND DESIGN",2));
        list.add(new CourseData("CSC 307","DATA STRUCTURE",2));
        list.add(new CourseData("CSC 309","OPERATIONS RESEARCH",3));
        list.add(new CourseData("CSC 311","NUMERICAL COMPUTATION I",2));
        list.add(new CourseData("GST 303","PEACE STUDIES AND CONFLICT RESOLUTION ",2));
        list.add(new CourseData("GST 305","INTRODUCTION TO SOCIOLOGY",2));
        list.add(new CourseData("ENG 003","COMMUNICATION IN ENGLISH III",0));
        list.add(new CourseData("CSC 320","INDUSTRIAL TRAINING I",3));


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

        list.add(new CourseData("CSC 402","ARTIFICIAL INTELLIGENCE",3));
        list.add(new CourseData("CSC 404","SOFTWARE MANAGEMENT",2));
        list.add(new CourseData("CSC 406","QUEUING SYSTEM ",2));
        list.add(new CourseData("CSC 408","HUMAN COMPUTER INTERFACE",2));
        list.add(new CourseData("CSC 410","COMPUTER GRAPHICS",2));
        list.add(new CourseData("CSC 412","COMPUTER APPLICATION",2));
        list.add(new CourseData("CSC 414","ELECTED TOPICS IN COMPUTER SCIENCE",3));
        list.add(new CourseData("CSC 416","COMPUTER SECURITY",2));
        list.add(new CourseData("CSC 491","RESEARCH PROJECT",6));
        list.add(new CourseData("ENG 004","COMPUTER SCIENCE",0));

        return list;
    }

    private ArrayList<CourseData>  finlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("CSC 401","DATA MANAGEMENT II",3));
        list.add(new CourseData("CSC 403","ORGANIZATION OF PROGRAMMING LANGUAGES",3));
        list.add(new CourseData("CSC 405","SOFTWARE ENGINEERING",2));
        list.add(new CourseData("CSC 407","COMPUTER NETWORKS AND COMMUNICATION",3));
        list.add(new CourseData("CSC 409","INTERNET TECHNOLOGY",2));
        list.add(new CourseData("CSC 411","SIMULATION METHODS AND MODELING",2));
        list.add(new CourseData("CSC 413","PROJECT MANAGEMENT",2));
        list.add(new CourseData("CSC 415","RESEARCH METHODOLOGY",2));


        return list;
    }
}
