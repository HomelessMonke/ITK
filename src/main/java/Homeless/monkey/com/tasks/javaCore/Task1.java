package Homeless.monkey.com.tasks.javaCore;

public class Task1 {
    public static void main(String[] args) {
        StringBuilderWithSnapshot sb = new StringBuilderWithSnapshot();
        sb.append('H');
        sb.append('e');
        sb.append('l');
        sb.append('l');
        sb.append('o');

        var length = sb.getLength();
        for (int i = 0; i < length; i++) {
            System.out.println(sb);
            sb.undo();
        }
    }
}
