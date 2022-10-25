import br.com.stack.Stack;

public class App {

    public static void main(String[] args) throws Exception {

        Stack<String> stack = new Stack<>();

        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");
        stack.add("5");

        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Head: " + stack.get());
        
        stack.remove();
        System.out.println("Head: " + stack.get());

    }

}
