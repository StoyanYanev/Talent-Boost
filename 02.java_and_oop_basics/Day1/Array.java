package BasicsTasks;

public class Array {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int[] numbers = new int[n];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i;
            }
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i]);
                }
            }
        } catch (NegativeArraySizeException e) {
            System.out.println("The index is negative");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}