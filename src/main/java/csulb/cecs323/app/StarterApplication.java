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

package csulb.cecs323.app;

import csulb.cecs323.model.Student;
import javax.persistence.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * A simple application to demonstrate how to persist an object in JPA.
 * <p>
 * This is for demonstration and educational purposes only.
 */
public class StarterApplication {
   private final EntityManager entityManager;
   private final Scanner userInput;

   private static final Logger LOGGER = Logger.getLogger(StarterApplication.class.getName());

   public StarterApplication(EntityManager manager) {
      this.entityManager = manager;
      userInput = new Scanner(System.in);
   }

   public static void main(String[] args) {
      LOGGER.fine("Creating EntityManagerFactory and EntityManager");
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("starter_unit");
      EntityManager manager = factory.createEntityManager();
      StarterApplication application = new StarterApplication(manager);


      // Any changes to the database need to be done within a transaction.
      // See: https://en.wikibooks.org/wiki/Java_Persistence/Transactions

      LOGGER.fine("Begin of Transaction");
      EntityTransaction tx = manager.getTransaction();

      tx.begin();

      application.createStudentEntity();

      tx.commit();

      // Starts a different transaction to create programs and set majors for students
      tx.begin();
      application.createPrograms();  // Task 3.1: create academic programs
      application.addMajors();       // Task 3.2: declare major for students
      tx.commit();

      application.showStudents();   // Task 3.3: list students and their majors

      LOGGER.fine("End of Transaction");

   }


   /**
    * Prompts user for information about academic programs to add
    */
   public void createPrograms() {
      // TODO: to be completed
      // NOTE: You can use the Scanner object userInput declared at line 27 to read input from the user
   }

   /**
    * Shows a list of students without a declared major, user selects one, then a list of
    * academic programs is shown for the user to select the one to be the student's declared major.
    */
   public void addMajors() {
      // TODO: to be completed
      // NOTE: You can use the Scanner object userInput declared at line 27 to read input from the user
   }

   /**
    * Shows a list of all students including their major. For students without a declared major,
    * it shows they are undeclared.
    */
   public void showStudents() {
      // TODO: To be completed
   }

   /**
    * Create and persist a Student object to the database.
    */
   public void createStudentEntity() {
      LOGGER.fine("Creating Student object");

      List<Student> students = new ArrayList<>();
      Student student = new Student();
      student.setFirstName("Grace");
      student.setLastName("Hopper");
      student.setGpa(4);

      students.add(student);

      student = new Student();
      student.setFirstName("Steve");
      student.setLastName("Wozniak");
      student.setEmail("woz@apple.com");
      student.setGpa(3.9);

      students.add(student);

      this.entityManager.persist(student);
      LOGGER.info("Persisted to DB: " + student);
      LOGGER.info("Transient object: " + students.get(0));

      // Need to flush changes to DB to update the in-memory object with its auto-generated id
      this.entityManager.flush();
      LOGGER.info("Persisted object after flush (non-null id): " + student);
   }

}
