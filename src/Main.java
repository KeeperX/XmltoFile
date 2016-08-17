import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Admin on 10.08.2016.
 */
public class Main {
public static String path ="c://1";
public static String file = "c://1.txt";
public static String timeTransaction = "dateTransaction";
public static String unp = "unp";
public static String name = "name";
public static ArrayList<String> list;
public static File[] listdir;

public static JButton jb;
public static int ii;
public static void main (String[] args)
 {
     ii=0;
     File dir = new File (path);
 if (dir.exists()){listdir = dir.listFiles();}
 else {JOptionPane.showMessageDialog(null,"Нет папки "+path);System.exit(0);}


if (listdir.length !=0){
    for (int i=0;i<listdir.length;i++)
    {
    writeFile(i);
    }}
else JOptionPane.showMessageDialog(null,"Нет файлов");
 }
 public static void writeFile(int i)
 {

     String file1 = listdir[i].toString();
     list = new ArrayList<>();
     try {
         BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file1),"UTF-8"));
         String r = bf.readLine();
         list.add(r);
         while (r!=null)
         {
             list.add(r);
             r=bf.readLine();
         }
         bf.close();

     } catch (Exception e){};

   String s="Дата" + getString(timeTransaction);
          s=s+";"+"УНП " +getString(unp);
          s=s+";"+"Назв. " +getString(name);
          s=s+";"+"Всего сумма= " +getStringRoster()[3]+" НДС= " +getStringRoster()[2]+" Всего с НДС=" +getStringRoster()[0];

     File fileWrite = new File(file);
     ArrayList<String> array = new ArrayList<>();
     if (!fileWrite.exists()){
         try {
             fileWrite.createNewFile();
         }catch (Exception e){};
     }
     else {
         try {
             BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
             String r = bf.readLine();
             while (r!=null){
              array.add(r);
                 r = bf.readLine();
             }
             bf.close();
         } catch(Exception e){};
     }
     array.add(s);
     try {
         PrintWriter pw = new PrintWriter(file,"UTF-8");
         for(int j=0;j<array.size();j++){
          pw.println(array.get(j));
         }
         pw.flush();
         //pw.close();
     } catch (Exception e){System.out.print(e);};

File fDel = new File (file1);
     fDel.delete();
 }
 public static String getString(String s)
 { String l="";
     for (int i=0;i<list.size();i++)
     {l=list.get(i);
         if (l.indexOf(s)!=-1){ l.trim();l=l.substring(s.length()+4,l.length()-s.length()-3);return l;}
     }
   return "";
 }
    public static String[] getStringRoster()
    { String l="";
        String[] a= new String[4];
        String s="roster";
        for (int i=0;i<list.size();i++)
        {l=list.get(i);
            if (l.indexOf(s)!=-1){ l.trim();
                l=l.substring(s.length()+3,l.length()-1);
                 a = l.split(" ");
                 for (int j=0;j<a.length;j++)
                 {
                  a[j]=a[j].substring(a[j].indexOf("\"")+1,a[j].length()-1);
                 }

                //l=l.substring(s.length()+4,l.length()-s.length()-3);
                return a;}
        }
     return null;
    }







}
