import com.utility.exceltoobjectmapping.ExcelToObjectMapper;
import com.utility.exceltoobjectmapping.exception.InvalidExcelFileException;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Ranjit Kaliraj on 8/15/17.
 */
public class MainClass {
    public static void main(String[] args) {
        String file = "/home/ranjit/students.xlsx";
        try {
            ExcelToObjectMapper mapper = new ExcelToObjectMapper(file);
            List<Student> students = mapper.map(Student.class);
            for (Student student : students) {
                String res = "Name : " + student.getName() + ", Address : " + student.getAddress() + ", Number : "+ student.getNumber();
                System.out.println(res);
            }
        } catch (InvalidExcelFileException e) {
            System.out.println("Invalid Excel file.");
        }  catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Error occured. Unable to execute mapping.");
            e.printStackTrace();
        }
    }
}
