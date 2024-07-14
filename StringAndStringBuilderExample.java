public class StringAndStringBuilderExample {
    public static void main(String[] args) {
        // Using String
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + " " + s2;
        System.out.println("Using String:");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        System.out.println("Length of s3: " + s3.length());
        System.out.println("s3 in uppercase: " + s3.toUpperCase());
        System.out.println("s3 contains 'Hello'? " + s3.contains("Hello"));
        System.out.println();

        // Using StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println("Using StringBuilder:");
        System.out.println("StringBuilder: " + sb);
        System.out.println("Length of StringBuilder: " + sb.length());
        sb.reverse();
        System.out.println("Reversed StringBuilder: " + sb);
        sb.insert(5, "Java ");
        System.out.println("StringBuilder after insertion: " + sb);
        System.out.println("StringBuilder capacity: " + sb.capacity());
    }
}
