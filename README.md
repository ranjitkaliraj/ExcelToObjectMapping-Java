# ExcelToObjectMapping-Java
A simple Excel to Object mapper utility using Apache POI.

## Usage Example:

###### Sample excel file (.xlsx):
```
Name    | Address  |  Number
Ranjit     Mars        123
Foo        Earth       322
Bar        Jupiter     433
```

###### Create a sample model class:

** Note: Currently supported data type are: String, Date, int, long, float, double and boolean. If any other data type are provided, value will be not read from excel file. **
```
public class Student {
    private String name;
    private String address;
    private int number;
    
    //getters and setters
}
```
###### Mapping Excel file to Object:
```
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
}  catch (InvalidObjectFieldNameException e) {
    System.out.println("Class field name doesnot match with excel file header name.");
} catch (Exception e) {
    System.out.println("Error occured. Unable to execute mapping.");
    e.printStackTrace();
}
```

