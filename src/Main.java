import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
/**
 * PACKAGE_NAME
 * Created by LêHoàngPhúc
 * Date 10/21/2021 - 10:12 PM
 * Description: ...
 */
public class Main {
    /**
     * main function
     * @param args parameter from terminal
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        boolean exit=false;
        StudentList stl;
        Main _main= new Main();
        while(!exit){
            _main.printHeader();
            _main.printMenu();
            int choice=-1;
            while (choice<0 || choice >3){
                try{
                    System.out.print("\nMoi nhap su lua chon: ");
                    choice=Integer.parseInt(scanner.nextLine());
                    if (choice<0 || choice >3) System.out.println("Nhap sai. Moi nhap lai.");
                }catch (NumberFormatException e){
                    System.out.println("Nhap sai. Moi nhap lai.");
                }
            }
            cls();
            switch (choice){
                case 0:
                    exit=true;
                    System.out.println("Cam on da su dung.");
                    break;
                case 1:
                    stl=new StudentList();
                    boolean exit3=false;
                    while(!exit3){
                        System.out.println("\nSu lua chon");
                        System.out.println("1) Them sinh vien");
                        System.out.println("2) Cap nhat sinh vien");
                        System.out.println("3) Xoa sinh vien");
                        System.out.println("4) Xem danh sach sinh vien");
                        System.out.println("5) Xem danh sach sinh vien theo thu tu tang dan ID");
                        System.out.println("6) Xem danh sach sinh vien theo thu tu tang dan GPA");
                        System.out.println("7) Save danh sach vao file txt");
                        System.out.println("8) Export danh sach vao file csv");
                        System.out.println("0) Quay ve");
                        int choice3=-1;
                        while (choice3<0 || choice3 >8){
                            try{
                                System.out.print("\nMoi nhap su lua chon: ");
                                choice3=Integer.parseInt(scanner.nextLine());
                                if (choice3<0 || choice3>8) System.out.println("Nhap sai. Moi nhap lai.");
                            }catch (NumberFormatException e1){
                                System.out.println("Nhap sai. Moi nhap lai.");
                            }
                        }
                        cls();
                        switch (choice3){
                            case 0:
                                exit3=true;
                                break;
                            case 1:
                                stl.addStudent();
                                break;
                            case 2:
                                stl.updateStudentInfor();
                                break;
                            case 3:
                                stl.deleteStudent();
                                break;
                            case 4:
                                stl.printListofStudent();
                                break;
                            case 5:
                                stl.printListofStudentinAscOrderID();
                                break;
                            case 6:
                                stl.printListofStudentinAscOrderGPA();
                                break;
                            case 7:
                                System.out.print("Nhap ten file txt muon save(VD: clc.txt): ");
                                File ffSave=null;
                                while (true){
                                    String fileS=scanner.nextLine();
                                    ffSave=new File(FileSystems.getDefault().getPath("txtFileFolder").toAbsolutePath()
                                            .toString()+"\\" +fileS);
                                    if (ffSave.isFile()&&ffSave.exists()){
                                        System.out.println("File ton tai!!! Ban muon ghi de hay tao file moi?");
                                        System.out.println("Nhap 1 de ghi de, nhap 2 de tao file moi");
                                        System.out.print("Moi nhap: ");
                                        String optionFile=scanner.nextLine();
                                        if (optionFile.equals("1")) break;
                                        else {
                                            System.out.print("Moi nhap file moi: ");
                                            String fileExpOp=scanner.nextLine();
                                            ffSave=new File(FileSystems.getDefault()
                                                    .getPath("txtFileFolder")
                                                    .toAbsolutePath().toString()+"\\" +fileExpOp);
                                            break;
                                        }
                                    }
                                    else break;
                                }
                                if (ffSave.getPath().toString().endsWith("txt"))
                                {stl.writeFileTxt(ffSave.getPath());
                                    System.out.println("Save thanh cong!");
                                    }
                                else System.out.println("File khong phai dang txt. Save that bai!!!");
                                System.out.println("Press enter to continue...");
                                try {
                                    String c = new Scanner(System.in).nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 8:
                                System.out.print("Nhap ten file csv muon export(VD: clc.csv): ");
                                File ffExport=null;
                                while (true){
                                    String fileExp=scanner.nextLine();
                                    ffExport=new File(FileSystems.getDefault().getPath("csvFileFolder").toAbsolutePath()
                                            .toString()+"\\" +fileExp);
                                    if (ffExport.isFile()&&ffExport.exists()){
                                        {
                                            System.out.println("File ton tai!!! Ban muon ghi de hay tao file moi?");
                                            System.out.println("Nhap 1 de ghi de, nhap 2 de tao file moi");
                                            System.out.print("Moi nhap: ");
                                            String optionFile=scanner.nextLine();
                                            if (optionFile.equals("1")) break;
                                            else {
                                                System.out.print("Moi nhap file moi: ");
                                                String fileExpOp=scanner.nextLine();
                                                ffSave=new File(FileSystems.getDefault()
                                                        .getPath("csvFileFolder")
                                                        .toAbsolutePath().toString()+"\\" +fileExpOp);
                                                break;
                                            }
                                        }
                                    }
                                    else break;
                                }
                                if (ffExport.getPath().toString().endsWith("csv"))
                                {stl.exportFileCSV(ffExport.getPath());
                                    System.out.println("Export thanh cong!");}
                                else System.out.println("File khong phai dang csv. Save that bai!!!");
                                System.out.println("Press enter to continue...");
                                try {
                                    String c = new Scanner(System.in).nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        cls();
                    }
                    break;
                case 2:
                    stl=new StudentList();
                    System.out.println("\nCac file csv ton tai sau:");
                    String[] pathnames1;
                    Path path1 = FileSystems.getDefault().getPath("txtFileFolder").toAbsolutePath();
                    File f1 = new File(path1.toString());
                    pathnames1 = f1.list();
                    for (String pathname : pathnames1) {
                        if (pathname.endsWith(".txt"))
                            System.out.println(pathname);
                    }
                    System.out.print("Moi nhap file txt(Vi du: clc.txt): ");
                    File ff1=null;
                    while (true){
                        String file=scanner.nextLine();
                        ff1=new File(FileSystems.getDefault().getPath("txtFileFolder").toAbsolutePath()
                        +"\\"+file);
                        if (!ff1.exists()){
                            System.out.print("File khong ton tai moi nhap lai: ");
                        }
                        else break;
                    }
                    stl.readFileTxt(ff1.getPath());
                    stl.printListofStudent();
                    cls();
                    boolean exit1=false;
                    while(!exit1){
                        System.out.println("\nSu lua chon");
                        System.out.println("1) Them sinh vien");
                        System.out.println("2) Cap nhat sinh vien");
                        System.out.println("3) Xoa sinh vien");
                        System.out.println("4) Xem danh sach sinh vien");
                        System.out.println("5) Xem danh sach sinh vien theo thu tu tang dan ID");
                        System.out.println("6) Xem danh sach sinh vien theo thu tu tang dan GPA");
                        System.out.println("7) Save danh sach vao file txt");
                        System.out.println("8) Export danh sach vao file csv");
                        System.out.println("0) Quay ve");
                        int choice1=-1;
                        while (choice1<0 || choice1 >8){
                            try{
                                System.out.print("\nMoi nhap su lua chon: ");
                                choice1=Integer.parseInt(scanner.nextLine());
                                if (choice1<0 || choice1>8) System.out.println("Nhap sai. Moi nhap lai.");
                            }catch (NumberFormatException e1){
                                System.out.println("Nhap sai. Moi nhap lai.");
                            }
                        }
                        cls();
                        switch (choice1){
                            case 0:
                                exit1=true;
                                break;
                            case 1:
                                stl.addStudent();
                                break;
                            case 2:
                                stl.updateStudentInfor();
                                break;
                            case 3:
                                stl.deleteStudent();
                                break;
                            case 4:
                                stl.printListofStudent();
                                break;
                            case 5:
                                stl.printListofStudentinAscOrderID();
                                break;
                            case 6:
                                stl.printListofStudentinAscOrderGPA();
                                break;
                            case 7:
                                System.out.print("Nhap ten file txt muon save(VD: clc.txt): ");
                                File ffSave=null;
                                while (true){
                                    String fileS=scanner.nextLine();
                                    ffSave=new File(FileSystems.getDefault().getPath("txtFileFolder").toAbsolutePath()
                                            .toString()+"\\" +fileS);
                                    if (ffSave.isFile()&&ffSave.exists()){
                                        System.out.println("File ton tai!!! Ban muon ghi de hay tao file moi?");
                                        System.out.println("Nhap 1 de ghi de, nhap 2 de tao file moi");
                                        System.out.print("Moi nhap: ");
                                        String optionFile=scanner.nextLine();
                                        if (optionFile.equals("1")) break;
                                        else {
                                            System.out.print("Moi nhap file moi: ");
                                            String fileExpOp=scanner.nextLine();
                                            ffSave=new File(FileSystems.getDefault()
                                                    .getPath("txtFileFolder")
                                                    .toAbsolutePath().toString()+"\\" +fileExpOp);
                                            break;
                                        }
                                    }
                                    else break;
                                }
                                if (ffSave.getPath().toString().endsWith("txt"))
                                {stl.writeFileTxt(ffSave.getPath());
                                System.out.println("Save thanh cong!");
                                  }
                                else System.out.println("File khong phai dang txt. Save that bai!!!");
                                System.out.println("Press enter to continue...");
                                try {
                                    String c = new Scanner(System.in).nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 8:
                                System.out.print("Nhap ten file csv muon export(VD: clc.csv): ");
                                File ffExport=null;
                                while (true){
                                    String fileExp=scanner.nextLine();
                                    ffExport=new File(FileSystems.getDefault().getPath("csvFileFolder")
                                            .toAbsolutePath().toString()+"\\" +fileExp);
                                    if (ffExport.isFile()&&ffExport.exists()){
                                        System.out.println("File ton tai!!! Ban muon ghi de hay tao file moi?");
                                        System.out.println("Nhap 1 de ghi de, nhap 2 de tao file moi");
                                        System.out.print("Moi nhap: ");
                                        String optionFile=scanner.nextLine();
                                        if (optionFile.equals("1")) break;
                                        else {
                                            System.out.print("Moi nhap file moi: ");
                                            String fileExpOp=scanner.nextLine();
                                            ffExport=new File(FileSystems.getDefault()
                                                    .getPath("csvFileFolder")
                                                    .toAbsolutePath().toString()+"\\" +fileExpOp);
                                            break;
                                        }
                                    }
                                    else break;
                                }
                                if (ffExport.getPath().toString().endsWith("csv"))
                                {stl.exportFileCSV(ffExport.getPath());
                                    System.out.println("Export thanh cong!");
                                    }
                                else System.out.println("File khong phai dang csv. Save that bai!!!");
                                System.out.println("Press enter to continue...");
                                try {
                                    String c = new Scanner(System.in).nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        cls();
                    }
                    break;
                case 3:
                    stl=new StudentList();
                    System.out.println("\nCac file csv ton tai sau:");
                    String[] pathnames;
                    Path path = FileSystems.getDefault().getPath("csvFileFolder").toAbsolutePath();
                    File f = new File(path.toString());
                    pathnames = f.list();
                    for (String pathname : pathnames) {
                        if (pathname.endsWith(".csv"))
                            System.out.println(pathname);
                    }
                    System.out.print("Moi chon file csv(Vi du: clc.csv): ");
                    File ff=null;
                    while (true){
                        String file=scanner.nextLine();
                        ff=new File(FileSystems.getDefault().getPath("csvFileFolder").toAbsolutePath()
                                .toString()+"\\" +file);
                        if (!ff.exists()){
                            System.out.print("File khong ton tai moi nhap lai: ");
                        }
                        else break;
                    }
                    stl.importFileCSV(ff.getPath());
                    stl.printListofStudent();
                    cls();
                    boolean exit2=false;
                    while(!exit2){
                        System.out.println("\nSu lua chon");
                        System.out.println("1) Them sinh vien");
                        System.out.println("2) Cap nhat sinh vien");
                        System.out.println("3) Xoa sinh vien");
                        System.out.println("4) Xem danh sach sinh vien");
                        System.out.println("5) Xem danh sach sinh vien theo thu tu tang dan ID");
                        System.out.println("6) Xem danh sach sinh vien theo thu tu tang dan GPA");
                        System.out.println("7) Save danh sach vao file txt");
                        System.out.println("8) Export danh sach vao file csv");
                        System.out.println("0) Quay ve");
                        int choice1=-1;
                        while (choice1<0 || choice1 >8){
                            try{
                                System.out.print("\nMoi nhap su lua chon: ");
                                choice1=Integer.parseInt(scanner.nextLine());
                                if (choice1<0 || choice1>8) System.out.println("Nhap sai. Moi nhap lai.");
                            }catch (NumberFormatException e1){
                                System.out.println("Nhap sai. Moi nhap lai.");
                            }
                        }
                        cls();
                        switch (choice1){
                            case 0:
                                exit2=true;
                                break;
                            case 1:
                                stl.addStudent();
                                break;
                            case 2:
                                stl.updateStudentInfor();
                                break;
                            case 3:
                                stl.deleteStudent();
                                break;
                            case 4:
                                stl.printListofStudent();
                                break;
                            case 5:
                                stl.printListofStudentinAscOrderID();
                                break;
                            case 6:
                                stl.printListofStudentinAscOrderGPA();
                                break;
                            case 7:
                                System.out.print("Nhap ten file txt muon save(VD: clc.txt): ");
                                File ffSave=null;
                                while (true){
                                    String fileS=scanner.nextLine();
                                    ffSave=new File(FileSystems.getDefault().getPath("txtFileFolder").toAbsolutePath()
                                            .toString()+"\\" +fileS);
                                    if (ffSave.isFile()&&ffSave.exists()){
                                        System.out.println("File ton tai!!! Ban muon ghi de hay tao file moi?");
                                        System.out.println("Nhap 1 de ghi de, nhap 2 de tao file moi");
                                        System.out.print("Moi nhap: ");
                                        String optionFile=scanner.nextLine();
                                        if (optionFile.equals("1")) break;
                                        else {
                                            System.out.print("Moi nhap file moi: ");
                                            String fileExpOp=scanner.nextLine();
                                            ffSave=new File(FileSystems.getDefault()
                                                    .getPath("txtFileFolder")
                                                    .toAbsolutePath().toString()+"\\" +fileExpOp);
                                            break;
                                        }
                                    }
                                    else break;
                                }
                                if (ffSave.getPath().toString().endsWith("txt"))
                                {stl.writeFileTxt(ffSave.getPath());
                                    System.out.println("Save thanh cong!");
                                    }
                                else System.out.println("File khong phai dang txt. Save that bai!!!");
                                System.out.println("Press enter to continue...");
                                try {
                                    String c = new Scanner(System.in).nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 8:
                                System.out.print("Nhap ten file csv muon export(VD: clc.csv): ");
                                File ffExport=null;
                                while (true){
                                    String fileExp=scanner.nextLine();
                                    ffExport=new File(FileSystems.getDefault().getPath("csvFileFolder").toAbsolutePath()
                                            .toString()+"\\" +fileExp);
                                    if (ffExport.isFile()&&ffExport.exists()){
                                        System.out.println("File ton tai!!! Ban muon ghi de hay tao file moi?");
                                        System.out.println("Nhap 1 de ghi de, nhap 2 de tao file moi");
                                        System.out.print("Moi nhap: ");
                                        String optionFile=scanner.nextLine();
                                        if (optionFile.equals("1")) break;
                                        else {
                                            System.out.print("Moi nhap file moi: ");
                                            String fileExpOp=scanner.nextLine();
                                            ffExport=new File(FileSystems.getDefault()
                                                    .getPath("csvFileFolder")
                                                    .toAbsolutePath().toString()+"\\" +fileExpOp);
                                            break;
                                        }
                                    }
                                    else break;
                                }
                                if (ffExport.getPath().toString().endsWith("csv"))
                                {stl.exportFileCSV(ffExport.getPath());
                                    System.out.println("Export thanh cong!");
                                 }
                                else System.out.println("File khong phai dang csv. Save that bai!!!");
                                System.out.println("Press enter to continue...");
                                try {
                                    String c = new Scanner(System.in).nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                        cls();
                    }
                     break;
                default:break;
            }        }

    }
    /**
     * xuat header
     */
    private void printHeader(){
        System.out.println("+=============================+");
        System.out.println("|             Menu            |");
        System.out.println("|      Quan ly sinh vien      |");
        System.out.println("+=============================+");
    }

    /**
     * xuat menu
     */
    private void printMenu(){
        System.out.println("Su lua chon");
        System.out.println("1) Bat du tu du lieu rong");
        System.out.println("2) Du lieu duoc load tu file txt");
        System.out.println("3) Du lieu duoc export tu file csv");
        System.out.println("0) Thoat");
    }

    /**
     * code xoá màn hình
     */
    private static void cls()
    {
        try
        {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch(Exception E)
        {
            System.out.println(E);
        }
    }
}
