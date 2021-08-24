package com.ou.gpa_calculator.LocalData.StaticData;

import com.ou.gpa_calculator.LocalData.Model.CourseData;

import java.util.ArrayList;
import java.util.Hashtable;

public class IcDataClass {
    private Hashtable<String, Hashtable<String, ArrayList<CourseData>>> IchDataDict = new Hashtable<>();


    public Hashtable<String, Hashtable<String,ArrayList<CourseData>>> getIchDataDict() {
        return IchDataDict;
    }

    public IcDataClass() {
        IchDataDict.put("100", flDict());
        IchDataDict.put("200",slDict());
        IchDataDict.put("300",tlDict());
        IchDataDict.put("400",finlDict());

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
        list.add(new CourseData("CHM 204","EXPERIMENTAL CHEMISTRY III",1));
        list.add(new CourseData("CHM 210","PHYSICAL CHEMISTRY II",3));
        list.add(new CourseData("CHM 212","INORGANIC CHEMISTRY II",2));
        list.add(new CourseData("ICH 208","CHEMICAL PROCESS AND RAW MATERIAL I",2));
        list.add(new CourseData("STA 202","STATISTICS FOR CHEMICAL SCIENCES",2));
        list.add(new CourseData("GST202","LOGIC PHILOSOPHY OF SCIENCE",2));
        list.add(new CourseData("GST204","HEALTH EDUCATION AND BASIC EPIDEMIOLOGY",2));
        list.add(new CourseData("ENG 002","COMMUNICATION IN ENGLISH II",0));


        return list;
    }

    private ArrayList<CourseData>  slFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("CHM 211","ORGANIC CHEMISTRY II",3));
        list.add(new CourseData("CHM 213","ANALYTICAL CHEMISTRY I",3));
        list.add(new CourseData("ICH 209","INTRODUCTION TO INDUSTRIAL CHEMISTRY",2));
        list.add(new CourseData("MTH 201","MATHEMATICAL METHODS I",3));
        list.add(new CourseData("PHY 201","INTRODUCTION TO MODERN PHYSICS I",3));
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

        list.add(new CourseData("CHM 302","ORGANIC CHEMISTRY III",3));
        list.add(new CourseData("CHM 306","ORGANOMETALLIC CHEMISTRY I",2));
        list.add(new CourseData("CHM 312","SEPARATING TECH. AND INSTR. METHOD OF ANALYSIS",2));
        list.add(new CourseData("CHM 316","APPLIED SPECTROSCOPY",3));
        list.add(new CourseData("ICH 322","INDUSTRIAL LAW AND MANAGEMENT",2));
        list.add(new CourseData("ICH 324","CHEMICAL PROCESS AND RAW MATERIAL",2));
        list.add(new CourseData("ICH 326","POLYMER CHEMISTRY AND TECHNOLOGY",2));

        return list;
    }

    private ArrayList<CourseData>  tlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("CHM 303","INORGANIC CHEMISTRY III",2));
        list.add(new CourseData("CHM 311","COLOUR CHEMISTRY AND TECHNOLOGY",2));
        list.add(new CourseData("CHM 319","ENVIRONMENTAL CHEMISTRY",2));
        list.add(new CourseData("ICH 321","HEAT TRANSFER",2));
        list.add(new CourseData("ICH 323","EXPERIMENTAL CHEMISTRY IV",1));
        list.add(new CourseData("ICH 325","PETROCHEMISTRY",2));
        list.add(new CourseData("ICH 327","RESEARCH METHODOLOGY ",2));
        list.add(new CourseData("GST 303","PEACE STUDIES AND CONFLICT RESOLUTION",2));
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

        list.add(new CourseData("CHM 424","COORDINATION CHEMISTRY",2));
        list.add(new CourseData("CHM 454","CORROSION CHEMISTRY",2));
        list.add(new CourseData("CHM 454","INTRODUCTION TO MATERIAL SCIENCE",2));
        list.add(new CourseData("ICH 400","SEMINAR ICH",4));
        list.add(new CourseData("ICH 422","NUTRITIONAL CHEMISTRY",2));
        list.add(new CourseData("ICH 424","HOMOGENEOUS HETEROGENEOUS CATALYSIS",2));
        list.add(new CourseData("ICH 426","UNIT OPERATION",2));
        list.add(new CourseData("ICH 428","FIBRE SCIENCE AND TECHNOLOGY ",2));
        list.add(new CourseData("ICH 450","FERTILIZERS AND AGROCHEMICAL",2));
        list.add(new CourseData("ICH 452","CERAMICS AND COMPOSITE MATERIALS",2));
        list.add(new CourseData("ICH 491","RESEARCH PROJECT",6));
        list.add(new CourseData("ENG 004","INDUSTRIAL CHEMISTRY",0));

        return list;
    }

    private ArrayList<CourseData>  finlFirstSemesterCourse(){
        ArrayList<CourseData> list = new ArrayList<>();

        list.add(new CourseData("CHM 407","ELECTROCHEMISTRY",2));
        list.add(new CourseData("CHM 409","PERICYCLICS, HETERCYCLICS AND NATURAL PRODUCTS",3));
        list.add(new CourseData("CHM 419","ORGANIC SYNTHESIS",2));
        list.add(new CourseData("CHM 427","NATURAL PRODUCT CHEMISTRY",2));
        list.add(new CourseData("ICH 400","SEMINAR",3));
        list.add(new CourseData("ICH 401","QUALITY CONTROL AND ASSURANCE",2));
        list.add(new CourseData("ICH 411","DETERGENTS AND COSMETIC CHEMISTRY",2));

        return list;
    }
}
