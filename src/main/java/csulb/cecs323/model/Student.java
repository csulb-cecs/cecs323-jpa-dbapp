/*
 * Licensed under the Academic Free License (AFL 3.0).
 *     http://opensource.org/licenses/AFL-3.0
 *
 *  This code is distributed to CSULB students in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, other than educational.
 *
 *  2018 Alvaro Monge <alvaro.monge@csulb.edu>
 *
 */

package csulb.cecs323.model;

import javax.persistence.*;

/**
 * Student class to model basic information about students, just their name and GPA.
 *
 * This is for demonstration and educational purposes only.
 */
@Entity
public class Student {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "first_name", nullable = false)
   private String firstName;
   @Column(nullable = false)
   private String lastName;
   private double gpa;
   private String email;

   @ManyToOne
   private AcademicProgram major;

   // You must follow Java naming convention for accessors/mutators

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public double getGpa() {
      return gpa;
   }

   public void setGpa(double gpa) {
      this.gpa = gpa;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String toString() {
      return String.format("Student[id=%d, %s %s, %s, %.2f]", id, firstName, lastName, email, gpa);
   }

   public AcademicProgram getMajor() {
      return major;
   }

   public void setMajor(AcademicProgram major) {
      this.major = major;
   }
}
