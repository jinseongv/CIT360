@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="course_id")
	private long courseId;
	...
	@Column(name="course_name")
	private String courseName;
	...
	@ManyToMany
	@JoinTable(name="student_course", //New table name
		joinColumns=@JoinColumn //My column in the join table
		(name="course_id",referencedColumnName="course_id"),
        	inverseJoinColumns=@JoinColumn //Associated column in the join table
		(name="student_id", referencedColumnName="student_id")
	)
	private Set<Student> students = new HashSet<Student>();
	...

	//By default, constructors and getters/setters are not persisted.
   	public Course(int courseId, String courseName, String description){...}
	public long getCourseId() {return courseId;}
	public void setCourseId(int courseId) {this.courseId = courseId;}
	//...like this method
	@Transient
	public String clear() {
		courseId = 0;
		courseName = "";
		description = "";
		return "clear";
	}
}