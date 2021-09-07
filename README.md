## Dördüncü hafta ödevi son teslim tarihi : 06.08.2021(Gelecek hafta pazartesi) - Saat =>  23:30

![homework](https://user-images.githubusercontent.com/45206582/131386439-6727321a-5a50-4c20-9413-ea4013013434.PNG)


* The general data flow of Course is stated below:

CourseController(CourseDTO) -> CourseMapper(CourseDTO) -> CourseService(Course DTO is converted to Course with CourseMapper) -> CourseRepository(Course) -> CrudRepository -> Course Entity saved to Database

* The general data flow of Student is stated below:

StudentController(StudentDTO) -> StudentMapper(StudentDTO) -> StudentService(Student DTO is converted to Student with StudentMapper) -> StudentRepository(Student) -> CrudRepository -> Student Entity saved to Database

* The general data flow of Instructor(PermanentInstructor or VisitingResearcher) is stated below:

InstructorController(InstructorDTO) -> InstructorMapper(InstructorDTO) -> InstructorService(Instructor DTO is converted to Instructor with InstructorMapper) -> StudentRepository(Student) -> CrudRepository -> Instructor Entity saved to Database

* Logs are added to database using with log4j
    * log4j properties file for automatically saving logs to database can be found at: SchoolManagement/src/main/resources/log4j.properties
    * For StudentServise an example logger:
```java
public static Logger logger = Logger.getLogger(StudentService.class);

```