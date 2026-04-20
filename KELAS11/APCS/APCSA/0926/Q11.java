public class Q11 {
    public static void main(String[] args)
    {
        // ! (!p || q) || !(p || !q)
        // De Morgan Law
        // !(!p || q) || !(p || !q)
        // (p && !q) || (!p && q)

        // P  Q  !P !Q   P  && !Q   !P && Q
        // T  T  F  F       F          F
        // T  F  F  T       T          F
        // F  T  T  F       F          T
        // F  F  T  T       F          F

        //  I || II
        //      F
        //      T
        //      T
        //      F

    }
}