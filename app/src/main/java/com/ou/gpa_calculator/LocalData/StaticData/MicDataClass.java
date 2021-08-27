package com.ou.gpa_calculator.LocalData.StaticData;

import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;

public class MicDataClass {

    private Hashtable<String, Hashtable<String,ArrayList<CourseData>>> MicDataDict = new Hashtable<>();


    public Hashtable<String, Hashtable<String, ArrayList<CourseData>>> getMicDataDict() {
        return MicDataDict;
    }

    public MicDataClass() {
        MicDataDict.put("100", flDict());
        MicDataDict.put("200",slDict());
        MicDataDict.put("300",tlDict());
        MicDataDict.put("400",finlDict());

    }

    private Hashtable<String,ArrayList<CourseData>> flDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", flFirstSemesterCourse());
        data.put("Second",flSecondSemesterCourse());

        return data;
    }


    private ArrayList<CourseData>  flSecondSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO 102","GENERAL BIOLOGY II",3));
        list.add(new CourseData("BIO 108","EXPERIMENTAL BIOLOGY II",1));
        list.add(new CourseData("CHM 102","GENERAL ORGANIC CHEMISTRY I",3));
        list.add(new CourseData("CHM 108","EXPERIMENTAL CHEMISTRY II",1));
        list.add(new CourseData("MTH 102","ELEMENTARY MATHEMATICS II ",3));
        list.add(new CourseData("PHY 102","GENERAL PHYSICS II",3));
        list.add(new CourseData("PHY 108","EXPERIMENTAL PHYSICS II",1));
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
        list.add(new CourseData("MTH 101","ELEMENTARY MATHEMATICS I",3));
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

        list.add(new CourseData("BIO 332","INTRODUCTION TO PLANT DISEASES",2));
        list.add(new CourseData("BIO 352","BIOLOGY OF TROPICAL PARASITES",3));
        list.add(new CourseData("MCB 306","VIROLOGY",3));
        list.add(new CourseData("MCB 312","AQUATIC MICROBIOLOGY",3));
        list.add(new CourseData("MCB 322","BACTERIOLOGY",2));
        list.add(new CourseData("MCB 324","MYCOLOGY",3));
        list.add(new CourseData("MCB 326","REPORT AND SCIENTIFIC WRITING",2));
        list.add(new CourseData("MCB 328","MICROBIAL BIOREMEDIATION",3));


        return list;
    }

    private ArrayList<CourseData>  tlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("MCB 303","MICROBIAL GENETICS",3));
        list.add(new CourseData("MCB 305","PHARMACEUTICAL MICROBIOLOGY",3));
        list.add(new CourseData("MCB 307","IMMUNOLOGY",2));
        list.add(new CourseData("MCB 309","FOOD MICROBIOLOGY",3));
        list.add(new CourseData("MCB 325","SOIL MICROBIOLOGY",3));
        list.add(new CourseData("GST 303","PEACE STUDIES AND CONFLICT RESOLUTION ",2));
        list.add(new CourseData("GST 305","INTRODUCTION TO SOCIOLOGY",2));
        list.add(new CourseData("ENG 003","COMMUNICATION IN ENGLISH III",0));


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

        list.add(new CourseData("BIO 418","PLANT AND ENVIRONMENTAL MONITORING",3));
        list.add(new CourseData("BIO 452","HOST PATHOGEN RELATION AND PLANT DISEASE MANAGEMENT",3));
        list.add(new CourseData("MCB 408","WASTE AND WASTE MANAGEMENT",3));
        list.add(new CourseData("MCB 410","MICROBIAL ECOLOGY",3));
        list.add(new CourseData("MCB 424","MICROBIAL PHYSIOLOGY  AND METABOLISM",3));
        list.add(new CourseData("MCB 430","MICROBIAL QUALITY ASSURANCE",3));
        list.add(new CourseData("MCB 491","RESEARCH PROJECT",6));
        list.add(new CourseData("ENG 004","MICROBIOLOGY",0));

        return list;
    }

    private ArrayList<CourseData>  finlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("MCB 391","INDUSTRIAL TRAINING",3));
        list.add(new CourseData("MCB 401","SEMINAR IN MICROBIOLOGY",2));
        list.add(new CourseData("MCB 405","PRINCIPLES OF EPIDEMIOLOGY AND PUBLIC HEALTH",3));
        list.add(new CourseData("MCB 407","MEDICAL MICROBIOLOGY",3));
        list.add(new CourseData("MCB 423","INDUSTRIAL MICROBIOLOGY",3));
        list.add(new CourseData("MCB 425","ENVIRONMENTAL MICROBIOLOGY",3));
        list.add(new CourseData("MCB 431","PETROLEUM MICROBIOLOGY",3));

        return list;
    }
}
