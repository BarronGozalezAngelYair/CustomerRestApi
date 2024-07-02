package edu.utvt.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.utvt.attendance.persistence.entities.Student;
import edu.utvt.attendance.persistence.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/all")
	public List<Student> get() {
		return this.studentService.getAll();
	}
	/*
	 * @GetMapping public ResponseEntity<Page<Student>>
	 * getMethodName(@RequestParam(value = "page", defaultValue = "0") Integer
	 * page, @RequestParam(value = "size", defaultValue = "50") Integer size ){
	 * return ResponseEntity.ok(this.studentService.get(page, size)); }
	 */

	@GetMapping
	public Page<Student> getMethodName(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "50") Integer size) {
		return this.studentService.get(page, size);
	}

	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return ResponseEntity.created(null).body(this.studentService.save(student));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") String id, @RequestBody Student student) {
		return ResponseEntity.ok(this.studentService.update(id, student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> delete(@PathVariable("id") String id) {
		return this.studentService.deleteById(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") String id) {
		return ResponseEntity.of(this.studentService.findById(id));
	}

}
