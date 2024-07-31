public class test10 {
    public static void main(String[] args) {
        
        Student model = new Student("1", "dipayan mandal", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        
        controller.updateView();

        System.out.println("\nupdated ");
        controller.setStudentName("Dipayan Mandal");
        controller.setStudentGrade("B");

       
        controller.updateView();
    }
}
