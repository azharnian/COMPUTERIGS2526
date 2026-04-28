import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        MyService service = new MyService();

        for (Method method : MyService.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(MyAnnotation.class)) {

                MyAnnotation ann = method.getAnnotation(MyAnnotation.class);

                // 🔥 LOGGING otomatis
                System.out.println(">> Ditemukan: " + method.getName());
                System.out.println("   Role: " + ann.role());

                // 🔥 VALIDASI / LOGIC TAMBAHAN
                if (!ann.enabled()) {
                    System.out.println("   ❌ Method dinonaktifkan");
                    continue;
                }

                // 🔥 BEHAVIOR TAMBAHAN
                if (ann.role().equals("ADMIN")) {
                    System.out.println("   🔐 Akses admin diberikan");
                }

                method.invoke(service);

                System.out.println("   ✅ Selesai\n");
            }
        }
    }
}