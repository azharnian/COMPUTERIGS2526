public class MyService {

    @MyAnnotation(role = "ADMIN", enabled = true)
    public void adminTask() {
        System.out.println("Admin task dijalankan");
    }

    @MyAnnotation(role = "USER", enabled = false)
    public void disabledTask() {
        System.out.println("Ini tidak boleh jalan");
    }

    public void methodBiasa() {
        System.out.println("Method biasa");
    }
}