/*
 * DroidFix Project
 * file Configure.java  is  part of DroidFix
 * The MIT License (MIT)  Copyright (c) 2015 Bunny Blue.
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package io.github.bunnyblue.droidfix.classcomputer.cache;

import java.io.File;

/**
 * Created by BunnyBlue on 11/11/15.
 */
public class Configure {
    static Configure sConfigure = new Configure();
    public static final String KEY_DROID_PATCH_DIR = "DroidPatch";
    public static final String KEY_DROID_PATCH_CLASS_MD5 = "classes.md5.txt";
    public static final String KEY_DROID_PATCH_CLASSES_DIR = "DiffClass";
    public static final String KEY_DROID_PATCH_MAPPING_FILE_NAME = "mapping.txt";
    // build/intermediates/transforms/CLASSES_and_RESOURCES/FULL_PROJECT/proguard/debug
    String buildType;// debug or release
    String buildRootDir;
    private	final  String classSrc = File.separator + "build" + File.separator + "intermediates" + File.separator+"transforms"+ File.separator
            + "CLASSES_and_RESOURCES" + File.separator + "FULL_PROJECT" + File.separator + "proguard" + File.separator;
    private	final  String classJar=File.separator + "build" + File.separator + "intermediates" + File.separator+"transforms"+ File.separator+"proguard"+File.separator;
private  final  String classJar13=File.separator + "build" + File.separator + "intermediates" + File.separator +"classes-proguard"+File.separator;
    private  String proguardJarFolder;
    private  String  proguardClassDir=null;

    public boolean isJar() {
        return isJar;
    }

    boolean isJar=true;
    boolean isJar13=false;

    public String getPatchRootDir() {
        return getBuildRootDir()+File.separator+KEY_DROID_PATCH_DIR;
    }
    public void  init() {
        File dir=new File(getPatchRootDir());
        dir.mkdirs();
        File test=new File(buildRootDir + classSrc+ buildType);
        if (test.isDirectory()){
            isJar=false;
        }
         test=new File(buildRootDir + classJar13+ buildType);
        if (test.isDirectory()){
            isJar13=true;
        }

    }

    public String getPatchClassMD5() {
        return getPatchRootDir()+File.separator+KEY_DROID_PATCH_CLASS_MD5;
    }
    public String getDiffClassesDir() {
        return getPatchRootDir()+ File.separator+KEY_DROID_PATCH_CLASSES_DIR;
    }

    public String getPatchMapping() {
        return getPatchRootDir()+File.separator+KEY_DROID_PATCH_MAPPING_FILE_NAME;
    }
    public String getBuildRootDir() {
        return buildRootDir;
    }

    public void setBuildRootDir(String buildRootDir) {
        this.buildRootDir = buildRootDir;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
      //  transformedClassDir = transformedClassDir ;
    }

    public static Configure getInstance() {
        return sConfigure;
    }

    public String getTransformedClassDir() {
        if (proguardClassDir!=null){
            return proguardClassDir;
        }

        return buildRootDir + classSrc+ buildType;

    }
    public String getProguardJarFolder(){

            if (isJar13){
                return buildRootDir + classJar13+ buildType;
            }
       return buildRootDir + classJar+ buildType+File.separator+"jars";


    }
    public void setProguardJarFolder(String proguardJarFolder){
        this.proguardJarFolder=proguardJarFolder;
    }
    public void setTransformedClassDir(String proguardClassDir){
        this.proguardClassDir=proguardClassDir;
    }
//    public  String getGradleVersion(){
//        return  "1.5.+";
//    }



}