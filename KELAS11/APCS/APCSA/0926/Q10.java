public class Q10 {
    public static void main(String[] args)
    {
        // short-circuit
        // AND (&&) diawali expression false
        // Kesimpulan langsung false

        // OR (||) diawali expression true
        // Kesimpulan langsung true

        // expression selanjutnya ignore walaupun
        // kenyataannya jika dievaluasi mengakibatkan
        // error

        // (0 == 1 && 4 / 0 == 1) => false
        // (4 + 2 == 6 || 4 / 0 == 0) => true
    }

}