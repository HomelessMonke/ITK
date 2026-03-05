package Homeless.monkey.com.tasks.javaCore;

import java.util.Stack;

public class StringBuilderWithSnapshot{

    private final StringBuilder sb;
    private Stack<String> snapshots = new Stack<>();

    public StringBuilderWithSnapshot(){
        sb = new StringBuilder();
    }

    public void append(char ch){
        snapshots.push(sb.toString());
        sb.append(ch);
    }

    public void undo(){
        if(!snapshots.isEmpty()){
            String memento = snapshots.pop();
            sb.replace(0, sb.length(), memento);
        }
    }

    public String toString() {
        return sb.toString();
    }

    public int getLength(){
        return sb.length();
    }
}
