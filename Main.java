public class Main {
    public static void main(String[] args)
    {
        Stack<Integer> stack = Math.random() < 0.5 ? new AStack<Integer>() : new RStack<Integer>();
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
        long start, stop;

        System.out.println(stack);
        System.out.println("push");
        start = System.nanoTime();
        for (int i = 0; i < num; ++i)
        {
            stack.push(i);
            System.out.print(i + " => ");
            for (Integer k : stack) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        stop = System.nanoTime();
        System.out.println(stop-start);

        Integer j;
        System.out.println("pop");
        start = System.nanoTime();
        while ((j = stack.pop()) != null)
        {
            System.out.print(j + " => ");
            for (Integer k : stack) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        stop = System.nanoTime();
        System.out.println(stop-start);
    }
}
