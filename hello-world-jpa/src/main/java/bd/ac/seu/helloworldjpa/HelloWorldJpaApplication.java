package bd.ac.seu.helloworldjpa;

import bd.ac.seu.helloworldjpa.model.Student;
import bd.ac.seu.helloworldjpa.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldJpaApplication {
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Create
			//Student student = new Student("32362", "Jane Doe", 3.99);
			//studentRepository.save(student);

			// Read
			//studentRepository.findAll().forEach(System.out::println);
			//System.out.println(studentRepository.findByStudentName("John Doe"));
			studentRepository.findAllByCgpaGreaterThanEqual(3.5).forEach(System.out::println);
		};
	}
}
