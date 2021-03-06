/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaguchHadamardNoise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class NoiseDOEDefine {
 public static Logger log=Logger.getLogger(NoiseDOEDefine.class.getName());
 public static void Myfscanf(FileInputStream fp)
{
    String s = new String();
    String[] sTemp = null;
    int param = 0;
    int exp = 0;
    try{
//DataInputStream din=new DataInputStream(fp);

BufferedReader din=new BufferedReader(new InputStreamReader(fp));
HadamardNoise.Path=ProcessString(din.readLine());

HadamardNoise.Length=Integer.parseInt(ProcessString(din.readLine()));	
HadamardNoise.STATSMOREDATAFACTOR=Integer.parseInt(ProcessString(din.readLine()));		
HadamardNoise.ROWSDOE=Integer.parseInt(ProcessString(din.readLine()));
HadamardNoise.UseLevelsFromFile=Boolean.parseBoolean(ProcessString(din.readLine()));
HadamardNoise.UseLevelsFromArray=Boolean.parseBoolean(ProcessString(din.readLine()));
HadamardNoise.UseFullFactorial=Boolean.parseBoolean(ProcessString(din.readLine()));
HadamardNoise.ClassicTaguchiAlg=Boolean.parseBoolean(ProcessString(din.readLine()));
HadamardNoise.LEVELS=Integer.parseInt(ProcessString(din.readLine()));

// High Level Variables for Signal Noise Nature
HadamardNoise.HasNoise=Boolean.parseBoolean(ProcessString(din.readLine()));

fp.close();
//log.error("GlblVars.Precision=" + GlblVars.Precision);
} catch(Exception HyperDOEse){ 
                            log.info("Exception: define Myfscanf");
                            System.out.println(HyperDOEse.getStackTrace());
                            System.out.println(HyperDOEse.getMessage());
                            HyperDOEse.printStackTrace();}
}

public static void Myprintf()
{
    try{
System.out.print(System.lineSeparator());
System.out.printf("Hadamard Noise Parameters Begin");
System.out.print(System.lineSeparator());
System.out.printf("Path = %s \n" ,HadamardNoise.Path);
System.out.printf("Length(Columns/Factors)(Overall Permutations =Levels^Length) = %d \n" ,HadamardNoise.Length);

System.out.printf("STATSMOREDATAFACTOR = %d \n" ,HadamardNoise.STATSMOREDATAFACTOR);	
System.out.printf("ROWSDOE(1 + Sigma((i=1 to NV) (Li-1)) : Tip: Use ROWSDOERecommended ) = %d \n" ,HadamardNoise.ROWSDOE);
System.out.printf("UseLevelsFromFile (Remember to Update DOEColumninputLevelSignalNormal in data\\LevelValues Folder )= %s \n",HadamardNoise.UseLevelsFromFile);
System.out.printf("UseLevelsFromArray (Remember to Update Array InitLevels in Code) = %s \n",HadamardNoise.UseLevelsFromArray);
System.out.printf("UseFullFactorial = %s \n" ,HadamardNoise.UseFullFactorial);
System.out.printf("ClassicTaguchiAlg = %s \n" ,HadamardNoise.ClassicTaguchiAlg);
System.out.printf("LEVELS = %d \n" ,HadamardNoise.LEVELS);		
// High Level Variables for Signal Noise Nature
System.out.print("High Level Variables for Signal \n");
System.out.printf("HasNoise = %s \n",HadamardNoise.HasNoise);
System.out.print(System.lineSeparator());
    } catch(Exception HyperDOEse){ 
                            log.info("Exception: define Myfprintf");
                            System.out.println(HyperDOEse.getStackTrace());
                            System.out.println(HyperDOEse.getMessage());
                            HyperDOEse.printStackTrace();}
}
public static String ProcessString(String input){
    String[] TempDataStr=new String[5];
    String[] TempValuesStr=new String[5];
    String[] Temp=new String[5];
    String[] Temp1=new String[5];
    if ((input.contains("Values("))||(input.contains("="))) {
      if(input.contains("Values(")){
        Temp=input.split("[\\(]");  
        TempValuesStr=Temp[1].split(",");
        Temp1=TempValuesStr[TempValuesStr.length-1].split("[\\)]");
        TempValuesStr[TempValuesStr.length-1]=Temp1[0];
        TempDataStr=input.split("=");
        for(int i=0; i < TempValuesStr.length;i++){
            //if Value is in the permissible range
           if((TempValuesStr[i]!= null)
                   &&(!TempValuesStr[i].equalsIgnoreCase(""))
               &&(TempValuesStr[i].equalsIgnoreCase(TempDataStr[1].trim()))
                   )
            return TempDataStr[1].trim();
        }
        //If Value has a spelling mistake or is outside the permissible range
        //accept new string anyways
        //return null:False
        return null;
      }  
      else {
        TempDataStr=input.split("=");
        // Take 1 Equal to(=) as the one seperating Value of Variable if Length==2
        if((TempDataStr.length)==2){
        //log.error("Read String=" + TempDataStr[1].trim());
        return TempDataStr[1].trim();
        }
        // Take last Equal to(=) as the one seperating Value of Variable
        else {
            return TempDataStr[TempDataStr.length-1].trim();
        }
        }
    }
    else if (!(input.trim().isEmpty())) return input.trim();
    else return null;
  }
public static void Myscanf()
{
    try{
//DataInputStream din=new DataInputStream(fp);
BufferedReader din=new BufferedReader(new InputStreamReader(System.in));
System.out.print(System.lineSeparator());
System.out.printf("Hadamard Noise Parameters Begin");
System.out.print(System.lineSeparator());

String Data;
Data=MyPrompt( din, "Path", HadamardNoise.Path );
HadamardNoise.Path=Data;

Data=MyPrompt( din, "Length", ("" +HadamardNoise.Length+"") );
HadamardNoise.Length=Integer.parseInt(Data);

Data=MyPrompt( din, "STATSMOREDATAFACTOR", (""+HadamardNoise.STATSMOREDATAFACTOR+"") );
HadamardNoise.STATSMOREDATAFACTOR=Integer.parseInt(Data);	

Data=MyPrompt( din, "ROWSDOE", (""+HadamardNoise.ROWSDOE+"") );
HadamardNoise.ROWSDOE=Integer.parseInt(Data);

Data = MyPrompt(din, "UseLevelsFromFile", ("" + HadamardNoise.UseLevelsFromFile + ""));
HadamardNoise.UseLevelsFromFile=Boolean.parseBoolean(Data);

Data = MyPrompt(din, "UseLevelsFromArray", ("" + HadamardNoise.UseLevelsFromArray + ""));
HadamardNoise.UseLevelsFromArray=Boolean.parseBoolean(Data);

Data=MyPrompt( din, "UseFullFactorial", ("" + HadamardNoise.UseFullFactorial + "") );
HadamardNoise.UseFullFactorial=Boolean.parseBoolean(Data);

Data=MyPrompt( din, "ClassicTaguchiAlg", ("" + HadamardNoise.ClassicTaguchiAlg + "") );
HadamardNoise.ClassicTaguchiAlg=Boolean.parseBoolean(Data);

Data=MyPrompt( din, "LEVELS", ("" + HadamardNoise.LEVELS + "") );
HadamardNoise.LEVELS=Integer.parseInt(Data);

// High Level Variables for Signal Noise Nature
Data = MyPrompt(din, "HasSignal", ("" + HadamardNoise.HasNoise + ""));
HadamardNoise.HasNoise=Boolean.parseBoolean(Data);

System.out.print(System.lineSeparator());

System.out.print(System.lineSeparator());



} catch(Exception HyperDOEse){ 
                            log.info("Exception: define Myfscanf");
                            System.out.println(HyperDOEse.getStackTrace());
                            System.out.println(HyperDOEse.getMessage());
                            HyperDOEse.printStackTrace();}
}
public static void Myfprintf(String Path)
{
    try{
PrintWriter fpout=null;
if ((fpout = new PrintWriter(Path+"HadamardNoise" )) == null)
	{
		System.out.printf("can't open %s\n", "HadamardNoise");
		System.out.printf("Setup aborted.\n");
		System.exit(1);
	}
fpout.printf("Path = %s \n" ,HadamardNoise.Path);
fpout.printf("Length = %d \n" ,HadamardNoise.Length);
fpout.printf("STATSMOREDATAFACTOR = %d \n" ,HadamardNoise.STATSMOREDATAFACTOR);		
fpout.printf("ROWSDOE = %d \n" ,HadamardNoise.ROWSDOE);
fpout.printf("UseLevelsFromFile = %s \n",HadamardNoise.UseLevelsFromFile);
fpout.printf("UseLevelsFromArray = %s \n",HadamardNoise.UseLevelsFromArray);
fpout.printf("UseFullFactorial = %s \n" ,HadamardNoise.UseFullFactorial);
fpout.printf("ClassicTaguchiAlg = %s \n" ,HadamardNoise.ClassicTaguchiAlg);
fpout.printf("LEVELS = %d \n" ,HadamardNoise.LEVELS);

// High Level Variables for Signal Noise Nature
fpout.printf("HasNoise = %s \n",HadamardNoise.HasNoise);

fpout.close();
} catch(Exception HyperDOEse){ 
                            log.info("Exception: define Myfprintf");
                            System.out.println(HyperDOEse.getStackTrace());
                            System.out.println(HyperDOEse.getMessage());
                            HyperDOEse.printStackTrace();
}
 }

public static String MyPrompt(BufferedReader din, String Param, String magic ){
    String TempStr="";
    try{
    System.out.print(Param + " [" + magic + "] = " );
    TempStr=ProcessString(din.readLine());
    if (TempStr== null ) return magic.trim();
    else return TempStr.trim();
    } catch(Exception HyperDOEse){ 
                            log.info("Exception: define MyPrompt");
                            System.out.println(HyperDOEse.getStackTrace());
                            System.out.println(HyperDOEse.getMessage());
                            HyperDOEse.printStackTrace();
}
    return null;
}
}
