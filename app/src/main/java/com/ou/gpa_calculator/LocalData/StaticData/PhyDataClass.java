package com.ou.gpa_calculator.LocalData.StaticData;

import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;

public class PhyDataClass {

    private Hashtable<String, Hashtable<String, ArrayList<CourseData>>> PhyDataDict = new Hashtable<>();


    public Hashtable<String, Hashtable<String,ArrayList<CourseData>>> getPhyDataDict() {
        return PhyDataDict;
    }

    public PhyDataClass() {
        PhyDataDict.put("100", flDict());
        PhyDataDict.put("200",slDict());
        PhyDataDict.put("300",tlDict());
        PhyDataDict.put("400",finlDict());

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
        list.add(new CourseData("CHM 108","EXPERIMENTAL CHEMISTRY II",1));
        list.add(new CourseData("CSC 102","INTRODUCTION TO COMPUTER SCIENCE II",2));
        list.add(new CourseData("MTH 102","ELEMENTARY MATHEMATICS II",3));
        list.add(new CourseData("MTH 112","INTRODUCTION TO VECTOR ANALYSIS ",3));
        list.add(new CourseData("PHY 102","GENERAL PHYSICS II",3));
        list.add(new CourseData("PHY 108","EXPERIMENTAL PHYSICS II",1));
        list.add(new CourseData("STA 112","INTRODUCTION TO PROBABILITY I",3));
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

        list.add(new CourseData("BCH 202","STRUCTURE AND CHEMISTRY OF BIOMOLECULES",3));
        list.add(new CourseData("BIO 202","INTRODUCTORY ECOLOGY",3));
        list.add(new CourseData("BIO 234","BIOSTATISTICS II",2));
        list.add(new CourseData("CHM 204","EXPERIMENTAL CHEMISTRY III",2));
        list.add(new CourseData("CHM 212","INORGANIC CHEMISTRY II",2));
        list.add(new CourseData("MCB 202","GENERAL MICROBIOLOGY II",3));
        list.add(new CourseData("MCB 204","PRINCIPLES OF STERILIZATION AND CHEMOTHERAPY",2));
        list.add(new CourseData("GST 202","LOGIC PHILOSOPHY OF SCIENCE",2));
        list.add(new CourseData("GST 204","HEALTH EDUCATION AND BASIC EPIDEMIOLOGY",2));
        list.add(new CourseData("ENG 002","COMMUNICATION IN ENGLISH II",0));


        return list;
    }

    private ArrayList<CourseData>  slFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("MTH 202","MATHEMATICAL METHOD II",3));
        list.add(new CourseData("MTH 204","NUMERICAL ANALYSIS I ",3));
        list.add(new CourseData("PHY 202","ELECTRICAL CIRCUITS AND BASIC ELECTRONICS",3));
        list.add(new CourseData("PHY 204","ELECTRONIC WORKSHOP PRACTICE I ",2));
        list.add(new CourseData("PHY 206","ELEMENTARY MODERN PHYSICS",3));
        list.add(new CourseData("PHY 208","EXPERIMENTAL PHYSICS IV",1));
        list.add(new CourseData("PHY 212","SOLAR AND ATMOSPHERIC PHYSICS",3));
        list.add(new CourseData("STA 204","STATISTICS FOR PHYSICAL SCIENCES",3));
        list.add(new CourseData("GST 202","LOGIC PHILOSOPHY OF SCIENCE",2));
        list.add(new CourseData("ENG 002","PHYSICS WITH ELECTRONICS",0));
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

        list.add(new CourseData("PHY 301","ANALYTICAL MECHANICS",3));
        list.add(new CourseData("PHY 303","ELCTROMAGNETIC FIELD",3));
        list.add(new CourseData("PHY 305","SOLID STATE PHYSICS",3));
        list.add(new CourseData("PHY 307","EXPERIMENTAL PHYSICS V",1));
        list.add(new CourseData("PHY 309","ENERGY AND ENVIRONMENTS",3));
        list.add(new CourseData("PHY 311","QUANTUM PHYSICS",3));
        list.add(new CourseData("PHY 315","ELECTRONIC DEVICES",2));
        list.add(new CourseData("GST 303","PEACE STUDIES AND CONFLICT RESOLUTION",2));
        list.add(new CourseData("GST 303","INTRODUCTION TO SOCIOLOGY",2));
        list.add(new CourseData("ENG 003","COMMUNICATION IN ENGLISH III",0));


        return list;
    }

    private ArrayList<CourseData>  tlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("PHY 302","ANALYTICAL MECHANICS II",3));
        list.add(new CourseData("PHY 304","ELECTROMAGNETIC WAVES",3));
        list.add(new CourseData("PHY 306","RESEARCH METHODS",2));
        list.add(new CourseData("PHY 308","ELECTRONICS WORKSHOP PRACTICE II",2));
        list.add(new CourseData("PHY 312","STATISTICAL PHYSICS",3));


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

        list.add(new CourseData("PHY 402","QUANTUM MECHANICS II ",3));
        list.add(new CourseData("PHY 404","MATHEMATICAL METHODS IN PHYSICS II",3));
        list.add(new CourseData("PHY 406","ATOMIC AND MOLECULAR SPECTROSCOPY",3));
        list.add(new CourseData("PHY 410","INTRODUCTION TO SPECIAL RELATIVITY",3));
        list.add(new CourseData("PHY 491","INDEPENDENT RESEARCH",6));
        list.add(new CourseData("ENG 004","PHYSICS WITH ELECTRONICS",0));

        return list;
    }

    private ArrayList<CourseData>  finlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("PHY 390","INDUSTRIAL TRAINING",3));
        list.add(new CourseData("PHY 401","QUANTUM MECHANICS I",3));
        list.add(new CourseData("PHY 403","MATHEMATICAL METHODS IN PHYSICS I ",3));
        list.add(new CourseData("PHY 405","ELECTRONICS COMMUNICATION THEORY",3));
        list.add(new CourseData("PHY 407","COMPUTATIONAL PHYSICS",3));
        list.add(new CourseData("PHY 409","SEMINAR IN PHYSICS",3));
        list.add(new CourseData("PHY 411","DIGITAL ELECTRONICS",3));
        list.add(new CourseData("PHY 413","NUCLEAR AND PARTICLE PHYSICS",3));

        return list;
    }

}
