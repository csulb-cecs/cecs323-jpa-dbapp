package csulb.cecs323.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AcademicProgram {
   @Id
   private String code;  // BSCS, MSCS, etc.
   private String subject;
   private String degree;
   private int unitsRequired;

   @OneToMany(mappedBy = "major") // "major" is the name of the field in the Student class that also defines the relationship
   private Set<Student> students;


   public AcademicProgram() {
      students = new HashSet<>();
   }

   public AcademicProgram(String code, String subject, String degree, int unitsRequired) {
      this.code = code;
      this.subject = subject;
      this.degree = degree;
      this.unitsRequired = unitsRequired;
      students = new HashSet<>();
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getDegree() {
      return degree;
   }

   public void setDegree(String degree) {
      this.degree = degree;
   }

   public int getUnitsRequired() {
      return unitsRequired;
   }

   public void setUnitsRequired(int unitsRequired) {
      this.unitsRequired = unitsRequired;
   }

   public String toString() {
      return String.format("AcademicProgram[code=%s, %s in %s, units=%d]", code, degree, subject, unitsRequired);
   }

   public Set<Student> getStudents() {
      return students;
   }

   public void addStudent(Student student) {
      this.students.add(student);
   }
}
