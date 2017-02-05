package studentinfo;

import org.junit.Test;
import junit.framework.TestCase;
import studentinfo.Student;

public class StudentTest extends TestCase {

	@Test
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		Student student = new Student(firstStudentName);
		assertEquals(firstStudentName, student.getName());

		final String secondStudentName = "Joe Blow";
		Student student2= new Student(secondStudentName);
		assertEquals(secondStudentName, student2.getName());

		assertEquals(firstStudentName, student.getName());
	}
}
