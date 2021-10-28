import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * PACKAGE_NAME
 * Created by LêHoàngPhúc
 * Date 10/21/2021 - 9:20 PM
 * Description: ...
 */
public class Student implements Serializable {
    //Attributes
    private String studentID;
    private String studentName;
    private float gpa;
    private String img;
    private String address;
    private String notes;
    //Methods
    //Constructors

    /**
     * Default constructor
     */
    public Student() {
        studentID="";
        studentName="";
        gpa=0;
        img="";
        address="";
        notes="";
    }

    /**
     * constructor with param
     * @param st Student
     */
    public Student(Student st){
        this.studentID = st.studentID;
        this.studentName = st.studentName;
        this.gpa = st.gpa;
        this.img = st.img;
        this.address = st.address;
        this.notes = st.notes;
    }

    /**
     * constructor with param
     * @param studentID string
     * @param studentName string
     * @param gpa float
     * @param img string
     * @param address string
     * @param notes string
     */
    public Student(String studentName, String studentID, float gpa, String img, String address, String notes) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.gpa = gpa;
        this.img = img;
        this.address = address;
        this.notes = notes;
    }
    //getter and setter
    /**
     * get Student ID
     * @return String
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * get Student Name
     * @return String
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * get gpa
     * @return float
     */
    public float getGpa() {
        return gpa;
    }

    /**
     * get image
     * @return String
     */
    public String getImg() {
        return img;
    }

    /**
     * get address
     * @return string
     */
    public String getAddress() {
        return address;
    }

    /**
     * get notes
     * @return string
     */
    public String getNotes() {
        return notes;
    }

    /**
     * set student id
     * @param studentID
     */
    public void setStudentID(String studentID) {
        if (studentID.equals("")) throw new NullPointerException("Du lieu rong. Khong the set du lieu!");
        else this.studentID = studentID;
    }

    /**
     * set student name
     * @param studentName
     */
    public void setStudentName(String studentName) {

        if (studentName.equals("")) throw new NullPointerException("Du lieu rong. Khong the set du lieu!");
        else this.studentName = studentName;
    }

    /**
     * set gpa
     * @param gpa
     */
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    /**
     * set image
     * @param img
     */
    public void setImg(String img) {
        if (img.equals("")) throw new NullPointerException("Du lieu rong. Khong the set du lieu!");
        else this.img = img;
    }

    /**
     * set address
     * @param address
     */
    public void setAddress(String address) {
        if (address.equals("")) throw new NullPointerException("Du lieu rong. Khong the set du lieu!");
        else this.address = address;
    }

    /**
     * set notes
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * print student
     */
    public void printStudent(){
        System.out.printf("%-10s %8s %8s %8s %12s %7s %n",this.studentName,this.studentID,
        this.gpa,this.address,this.img,this.notes);
    }

    /**
     * print student
     * @return String
     */
    @Override
    public String toString(){
        String str="Tên sinh viên: "+this.studentName+"\n"+"Mã số sinh viên: "+this.studentID
                +"\n"+"Điểm GPA: "+this.gpa+"\n"+"Địa chỉ: "+this.address+"\n"+"Hình ảnh: "+this.img+"\n"
                +"Ghi chú: "+this.notes+"\n";
        return str;
    }
}
