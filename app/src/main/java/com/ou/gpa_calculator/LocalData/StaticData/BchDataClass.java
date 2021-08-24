package com.ou.gpa_calculator.LocalData.StaticData;

import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;

public class BchDataClass {


    private Hashtable<String, Hashtable<String, ArrayList<CourseData>>> BchDataDict = new Hashtable<>();


    public Hashtable<String, Hashtable<String, ArrayList<CourseData>>> getBchDataDict() {
        return BchDataDict;
    }

    public BchDataClass() {
        BchDataDict.put("100", flDict());
        BchDataDict.put("200", slDict());
        BchDataDict.put("300", tlDict());
        BchDataDict.put("400", finlDict());

    }

    private Hashtable<String, ArrayList<CourseData>> flDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", flFirstSemesterCourse());
        data.put("Second", flSecondSemesterCourse());

        return data;
    }


    private ArrayList<CourseData> flSecondSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO 102", "GENERAL BIOLOGY II", 3));
        list.add(new CourseData("BIO 108", "EXPERIMENTAL BIOLOGY II", 1));
        list.add(new CourseData("CHM 102", "GENERAL ORGANIC CHEMISTRY I", 3));
        list.add(new CourseData("CHM 108", "EXPERIMENTAL CHEMISTRY II", 1));
        list.add(new CourseData("MTH 102", "ELEMENTARY MATHEMATICS II", 3));
        list.add(new CourseData("PHY 102", "GENERAL PHYSICS II", 3));
        list.add(new CourseData("PHY 108", "EXPERIMENTAL PHYSICS II", 1));
        list.add(new CourseData("GST 102", "AFRICAN CULTURE AND CIVILISATION", 2));
        list.add(new CourseData("GST 104", "ENTREPRENEURIAL SKILLS", 2));


        return list;
    }

    private ArrayList<CourseData> flFirstSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BIO 101", "GENERAL BIOLOGY I", 3));
        list.add(new CourseData("BIO 107", "EXPERIMENTAL BIOLOGY I", 1));
        list.add(new CourseData("CHM 101", "GENERAL PHYSICAL CHEMISTRY I", 3));
        list.add(new CourseData("CHM 103", "GENERAL INORGANIC CHEMISTRY I", 2));
        list.add(new CourseData("CHM 107", "EXPERIMENTAL CHEMISTRY I", 1));
        list.add(new CourseData("CSC 101", "INTRODUCTION TO COMPUTER SCIENCE", 3));
        list.add(new CourseData("PHY 101", "GENERAL PHYSICS", 3));
        list.add(new CourseData("PHY 107", "EXPERIMENTAL PHYSICS I", 1));
        list.add(new CourseData("GST 101", "USE OF ENGLISH", 2));
        list.add(new CourseData("GST 105", "USE OF LIBRARY", 2));
        list.add(new CourseData("ENG 001", "COMMUNICATION IN ENGLISH I", 0));


        return list;
    }

    private Hashtable<String, ArrayList<CourseData>> slDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", slFirstSemesterCourse());
        data.put("Second", slSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData> slSecondSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH 202", "STRUCTURE AND CHEMISTRY OF BIOMOLECULES", 3));
        list.add(new CourseData("BCH 204", "GENERAL ASPECTS OF METABOLISM", 3));
        list.add(new CourseData("BCH 206", "INTRODUCTORY PHYSIOLOGY AND PHARMACOLOGY", 3));
        list.add(new CourseData("BCH 214", "GENERAL BIOCHEMISTRY LAB II", 1));
        list.add(new CourseData("CHM 204", "EXPERIMENTAL CHEMISTRY III", 1));
        list.add(new CourseData("CHM 210", "PHYSICAL CHEMISTRY II", 3));
        list.add(new CourseData("CHM 212", "INORGANIC CHEMISTRY II", 2));
        list.add(new CourseData("GST 202", "LOGIC PHILOSOPHY OF SCIENCE", 2));
        list.add(new CourseData("GST 204", "HEALTH EDUCATION AND BASIC EPIDEMIOLOGY", 2));
        list.add(new CourseData("ENG 002", "COMMUNICATION IN ENGLISH II", 0));

        return list;
    }

    private ArrayList<CourseData> slFirstSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH 201", "INTRODUCTION TO PHYSICAL BIOCHEMISTRY", 3));
        list.add(new CourseData("BCH 203", "INTRODUCTION TO CELLULAR BIOCHEMISTRY", 2));
        list.add(new CourseData("BCH 211", "GENERAL BIOCHEMISRY LAB I", 1));
        list.add(new CourseData("BIO 201", "INTRODUCTORY GENETICS", 2));
        list.add(new CourseData("CHM 211", "ORGANIC CHEMISTRY II", 2));
        list.add(new CourseData("MCB 201", "GENERAL MICROBIOLOGY I", 3));
        list.add(new CourseData("STA 201", "STATISTICS FOR AGRICULTURAL AND BIOLOGICAL SCIENCES", 3));
        list.add(new CourseData("GST 203", "HISTORY AND PHILOSOPHY OF SCIENCE", 2));

        return list;
    }

    private Hashtable<String, ArrayList<CourseData>> tlDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", tlFirstSemesterCourse());
        data.put("Second", tlSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData> tlSecondSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH 302", "CHEM AND METABOLISM OF LIPIDS ", 3));
        list.add(new CourseData("BCH 304", "CHEM AND METABOLISM OF NUCLEIC ACID", 3));
        list.add(new CourseData("BCH 306", "METHODS IN BIOCHEMISTRY AND INSTRU", 3));
        list.add(new CourseData("BCH 308", "FOOD AND NUTRITIONAL BIOCHEMISTRY", 2));
        list.add(new CourseData("BCH 310", "BIO ENERGETIC", 3));
        list.add(new CourseData("BCH 312", "PRINCIPLES OF ENDOCRINOLOGY", 3));
        list.add(new CourseData("BCH 314", "GENERAL BIOCHEMISTRY LAB IV", 1));
        list.add(new CourseData("CHM 302", "INORGANIC CHEMISTRY III", 3));
        list.add(new CourseData("ENG 003", "COMMUNICATION IN ENGLISH III", 0));


        return list;
    }

    private ArrayList<CourseData> tlFirstSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("PHY 302", "ANALYTICAL MECHANICS II", 3));
        list.add(new CourseData("PHY 304", "ELECTROMAGNETIC WAVES", 3));
        list.add(new CourseData("PHY 306", "RESEARCH METHODS", 2));
        list.add(new CourseData("PHY 308", "ELECTRONICS WORKSHOP PRACTICE II", 2));
        list.add(new CourseData("PHY 312", "STATISTICAL PHYSICS", 3));


        return list;
    }


    private Hashtable<String, ArrayList<CourseData>> finlDict() {
        Hashtable<String, ArrayList<CourseData>> data = new Hashtable<>();

        data.put("First", finlFirstSemesterCourse());
        data.put("Second", finlSecondSemesterCourse());

        return data;
    }

    private ArrayList<CourseData> finlSecondSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH 402", "TRANSFER OF GENETICS INFORMATION", 3));
        list.add(new CourseData("BCH 404", "BIO INORGANIC CHEMISTRY", 3));
        list.add(new CourseData("BCH 406", "CANCER BIOCHEMISTRY (ONCOLOGY)", 3));
        list.add(new CourseData("BCH 408", "PHARMACEUTICAL BIOCHEMISTRY", 3));
        list.add(new CourseData("BCH 410", "ADVANCED LIPID BIOCHEMISTRY", 3));
        list.add(new CourseData("BCH 414", "CLINICAL AND FORENSIC BIOCHEMISTRY", 3));
        list.add(new CourseData("BCH 491", "PROJECT", 6));
        list.add(new CourseData("ENG 004", "BIOCHEMISTRY", 0));

        return list;
    }

    private ArrayList<CourseData> finlFirstSemesterCourse() {
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("BCH 328", "INDUSTRIAL TRAINING", 3));
        list.add(new CourseData("BCH 401", "ADVANCE ENZYMOLOGY", 3));
        list.add(new CourseData("BCH 403", "TISSUE BIOCHEMISTRY", 3));
        list.add(new CourseData("BCH 405", "GENETIC ENGINEERING AND BIOTECHNOLOGY", 3));
        list.add(new CourseData("BCH 407", "PLANT BIOCHEMISTRY", 1));
        list.add(new CourseData("BCH 409", "SEMINAR", 2));
        list.add(new CourseData("BCH 411", "INDUSTRIAL BIOCHEMISTRY", 1));
        list.add(new CourseData("BCH 413", "BIOCHEMICAL REASONING", 1));
        list.add(new CourseData("BCH 415", "IMMUNOLOGY", 3));
        list.add(new CourseData("BCH 417", "PROTEIN STRUCTURE AND FUNCT", 3));

        return list;
    }

}