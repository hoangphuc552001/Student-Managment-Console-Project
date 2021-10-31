import java.io.*;
import java.util.*;
/**
 * PACKAGE_NAME
 * Created by LêHoàngPhúc
 * Date 10/21/2021 - 9:55 PM
 * Description: ...
 */
public class StudentList implements Serializable{
    //Attributes
    private List<Student> listStudent;
    //Methods
    //Constructor

    /**
     * default constructor
     */
    public StudentList() {
        this.listStudent=new ArrayList<>();
    }
    /**
     * Constructor with number of student
     */
    public StudentList(int n) {
        this.listStudent=new ArrayList<Student>(n);
    }
    /**
     * constructor with param
     * @param listStudent
     */
    public StudentList(List<Student> listStudent) {
        this.listStudent=new ArrayList<Student>();
        for (int i=0;i<listStudent.size();i++){
           Student student=new Student(listStudent.get(i));
           this.listStudent.add(student);
        }
    }
    /**
     * get list student
     * @return List of student
     */
    public List<Student> getListStudent() {
        return listStudent;
    }

    /**
     * set list student
     * @param listStudent list of student
     */
    public void setListStudent(List<Student> listStudent) {
        this.listStudent=new ArrayList<Student>();
        for (int i=0;i<listStudent.size();i++){
            Student student=new Student(listStudent.get(i));
            this.listStudent.add(student);
        }
    }

    /**
     * method add student
     */
    public boolean addStudent(Student student){
        if (checkStudent(student.getStudentID())!=null){
            System.out.println("Da ton tai sinh vien. Khong them them!!!");
            return false;
        }else {
            listStudent.add(student);
            System.out.println("Them thanh cong!");
            return true;
        }
    }

    /**
     * overload method add student
     * @return bool
     */
    public boolean addStudent() throws IOException {
        String ten="",mssv="",diachi="",hinhanh="",ghichu="";
        float gpa=-1;
        Student std=new Student();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap ten sinh vien muon them: ");
        ten=scanner.nextLine();
//        System.out.print("Nhap ma so sinh vien muon them: ");
//        mssv=scanner.nextLine();
//        if (checkStudent(mssv.toString())!=null){
//            while(checkStudent(mssv.toString())!=null){
//                System.out.print("Moi nhap lai ma so sinh vien: ");
//                mssv=scanner.nextLine();
//            }
//        }
        System.out.print("Nhap gpa sinh vien muon them: ");
        do{
            try{
                gpa=Float.parseFloat(scanner.nextLine());
                if (gpa<0 || gpa>4) System.out.print("Moi nhap lai gpa: ");}
            catch (NumberFormatException e){
                System.out.print("Nhap sai. Moi nhap lai: ");
            }
        }while(gpa<0 || gpa>4);
        System.out.print("Nhap dia chi sinh vien muon them: ");
        diachi=scanner.nextLine();
        System.out.print("Nhap duong dan hinh anh sinh vien muon them(VD: D:\\phuc.jpg): ");
        while (true){
        hinhanh=scanner.nextLine();
        File file=new File(hinhanh);
        if (file.isFile()&&file.exists()) break;
        else System.out.print("File khong ton tai! Moi nhap lai: ");
        }
        System.out.print("Nhap ghi chu sinh vien muon them: ");
        ghichu=scanner.nextLine();
        InputStream is = new FileInputStream("SoLuong.txt");
        int code;
        String number="";
        while((code = is.read()) != -1) {
            number+=(char)code;
            }
        int num=Integer.parseInt(number);
        number=Integer.toString(num+1);
        is.close();
        OutputStream os = new FileOutputStream("SoLuong.txt");
        os.write(number.getBytes());
        os.flush();
        os.close();
        try{
            std.setStudentID(Integer.toString(num));
            std.setStudentName(ten);
            std.setGpa(gpa);
            std.setAddress(diachi);
            std.setNotes(ghichu);
            std.setImg(hinhanh);
            System.out.println("Them thanh cong!");
            System.out.println("Ma so sinh vien moi la: "+Integer.toString(num));
            System.out.println("Press enter to continue...");
            try {
                String c = new Scanner(System.in).nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.listStudent.add(std);
            return true;
        }catch (NullPointerException e){
            System.out.println("\n"+ e);
            System.out.println("Press enter to continue...");
            try {
                String c = new Scanner(System.in).nextLine();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }

    /**
     * print list of student
     */
    public void printListofStudent(){
        int i=0;
        System.out.printf("%-6s %-20s %-15s %-8s %-13s %-17s %-11s %n","ID","StudentName","StudentID","GPA","Image",
                "Address","Note");
        for (Student x:listStudent){
            i++;
            System.out.printf("%-6s %-20s %-15s %-8s %-13s %-17s %-7s %n",Integer.toString(i),x.getStudentName(),x.getStudentID()
                    ,x.getGpa(),x.getImg(),x.getAddress(),x.getNotes());
        }
        System.out.println("Press enter to continue...");
        try {
            String c = new Scanner(System.in).nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * print list of student in ascending order ID
     */
    public void printListofStudentinAscOrderID(){
       StudentList stl=new StudentList(this.listStudent);
        for (int i = 0; i < stl.listStudent.size()-1; i++) {
            Student temp = null;
            for (int j = i + 1; j < stl.listStudent.size(); j++) {
                if (stl.listStudent.get(i).getStudentID().compareTo(stl.listStudent.get(j).getStudentID())>0) {
                    temp = stl.listStudent.get(i);
                    stl.listStudent.set(i,stl.listStudent.get(j));
                    stl.listStudent.set(j,temp);
                }
            }
        }
        stl.printListofStudent();
    }
    /**
     * print list of student in ascending order gpa
     */
    public void printListofStudentinAscOrderGPA(){
        StudentList stl=new StudentList(this.listStudent);
        for (int i = 0; i < stl.listStudent.size()-1; i++) {
            Student temp = null;
            for (int j = i + 1; j < stl.listStudent.size(); j++) {
                if ((float)stl.listStudent.get(j).getGpa()-(float)stl.listStudent.get(i).getGpa()<0) {
                    temp = stl.listStudent.get(i);
                    stl.listStudent.set(i,stl.listStudent.get(j));
                    stl.listStudent.set(j,temp);
                }
            }
        }
        stl.printListofStudent();
    }

    /**
     * method delete student
     * @param student ID String
     */
    public boolean deleteStudent(String student){
        Student std=checkStudent(student);
        System.out.println("Xoa thanh cong");
        System.out.println("Press enter to continue...");
        try {
            String c = new Scanner(System.in).nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudent.remove(std);

    }

    /**
     * delete student over load
     * @return boolean
     * @throws IOException
     */
    public boolean deleteStudent() throws IOException {
        printListofStudent();
        if (listStudent.size()<=0){
            System.out.println("Du lieu rong khong the xoa!!!");
            return false;
        }
        System.out.print("Nhap ma so sinh vien muon xoa: ");
        Scanner scanner=new Scanner(System.in);
        String st=scanner.nextLine().toString();
        if (checkStudent(st.toString())==null){
            while(checkStudent(st.toString())==null){
                System.out.print("Moi nhap lai ma so sinh vien: ");
                st=scanner.nextLine();
                }
            }
        return deleteStudent(st);
    }
    /**
     * update student information
     * @param student
     */
    public boolean updateStudentInfor(String student){
        Student std=checkStudent(student);
        Scanner scanner=new Scanner(System.in);
        String ten="",diachi="",hinhanh="",ghichu="";
        float gpa=-1;
        if (std!=null) {
            System.out.print("Nhap ten sinh vien muon chinh sua: ");
            ten=scanner.nextLine();
            System.out.print("Nhap gpa sinh vien muon chinh su: ");
            do{
                try{
                    gpa=Float.parseFloat(scanner.nextLine());
                    if (gpa<0 || gpa>4) System.out.print("Moi nhap lai gpa: ");}
                catch (NumberFormatException e){
                    System.out.print("Nhap sai. Moi nhap lai: ");
                }
            }while(gpa<0 || gpa>4);
            System.out.print("Nhap dia chi sinh vien muon chinh sua: ");
            diachi=scanner.nextLine();
            System.out.print("Nhap duong dan hinh anh sinh vien muon them(VD: D:\\phuc.jpg): ");
            while (true){
                hinhanh=scanner.nextLine();
                File file=new File(hinhanh);
                if (file.isFile()&&file.exists()) break;
                else System.out.print("File khong ton tai! Moi nhap lai: ");
            }
            System.out.print("Nhap ghi chu sinh vien muon chinh sua: ");
            ghichu=scanner.nextLine();
            try{std.setStudentID(student);
            std.setStudentName(ten);
            std.setGpa(gpa);
            std.setAddress(diachi);
            std.setNotes(ghichu);
            std.setImg(hinhanh);
            System.out.println("Cap nhat thanh cong!");
                System.out.println("Press enter to continue...");
                try {
                    String c = new Scanner(System.in).nextLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            return true;
            }catch (NullPointerException e){
                System.out.println("\n"+e);
                System.out.println("Press enter to continue...");
                try {
                    String c = new Scanner(System.in).nextLine();
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
                return false;
            }
        }else
        {
            return false;
        }
    }
    /**
     * overload update
     * @return boolean
     */
    public boolean updateStudentInfor() throws IOException {
        printListofStudent();
        System.out.print("Nhap ma so sinh vien muon chinh sua: ");
        Scanner scanner=new Scanner(System.in);
        String st=scanner.nextLine().toString();
        if (checkStudent(st.toString())==null){
            while(checkStudent(st.toString())==null){
                System.out.print("Moi nhap lai ma so sinh vien: ");
                st=scanner.nextLine();
                }
        }
        return updateStudentInfor(st);
    }

    /**
     * check student in list
     * @param student String
     * @return boolean
     */
    public Student checkStudent(String student){
        for (Student x:listStudent){
            if (x.getStudentID().equals(student)){
                return x;
            }
        }
        return null;
    }

    /**
     * write List to file
     * @param txt String file
     * @throws IOException
     */
    public void writeFileTxt(String txt) throws IOException {
        FileOutputStream file=null;
        ObjectOutputStream outputStream=null;
        try {
            file = new FileOutputStream(txt);
            outputStream= new ObjectOutputStream(file);
            outputStream.writeObject(this.listStudent);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
            file.close();
        }
    }

    /**
     * read list from file
     * @param txt String file
     * @throws IOException
     */
    public void readFileTxt(String txt) throws IOException {
        FileInputStream file=null;
        ObjectInputStream inputStream=null;
        try {
            file = new FileInputStream(txt);
            inputStream= new ObjectInputStream(file);
            ArrayList<Student> list= (ArrayList) inputStream.readObject();
            for (Student x:list){
                if (checkStudent(x.getStudentID())==null) this.listStudent.add(x);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            inputStream.close();
            file.close();
        }
    }

    /**
     * export file csv
     * @param file csv
     * @throws IOException
     */
    public void exportFileCSV(String file) throws IOException {
        FileWriter writer = null;
        BufferedWriter bufferedWriter=null;
        try{
            writer=new FileWriter(file);
            bufferedWriter=new BufferedWriter(writer);
            StringBuilder sb = new StringBuilder();
            sb.append("ID");
            sb.append(',');
            sb.append("StudentName");
            sb.append(',');
            sb.append("StudentID");
            sb.append(',');
            sb.append("GPA");
            sb.append(',');
            sb.append("Image");
            sb.append(',');
            sb.append("Address");
            sb.append(',');
            sb.append("Note");
            sb.append('\n');
            int i=0;
            for (Student x:listStudent){
                i++;
                sb.append(i);
                sb.append(',');
                sb.append(x.getStudentName());
                sb.append(',');
                sb.append(x.getStudentID());
                sb.append(',');
                sb.append(x.getGpa());
                sb.append(',');
                sb.append(x.getImg());
                sb.append(',');
                sb.append(x.getAddress());
                sb.append(',');
                sb.append(x.getNotes());
                sb.append('\n');
            }
            bufferedWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedWriter.flush();
            bufferedWriter.close();
            writer.close();
        }
    }

    /**
     * import file CSV
     * @param file String
     * @throws IOException
     */
    public void importFileCSV(String file) throws IOException {
        BufferedReader reader=null;
        String line="";
        try{
            reader=new BufferedReader(new FileReader(file));
            String rm=reader.readLine();
            while ((line=reader.readLine())!=null){
                String[] row=line.split(",");
                try{
                    Student st;
                    if (row.length==7){
                        st=new Student(row[1],
                            row[2],
                            Float.parseFloat(row[3]),
                            row[4],
                            row[5],
                            row[6]);}
                    else {
                        st=new Student(row[1],
                                row[2],
                                Float.parseFloat(row[3]),
                                row[4],
                                row[5],
                                "");}
                    if (checkStudent(st.getStudentID())==null)
                        this.listStudent.add(st);}catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }
    }
}
