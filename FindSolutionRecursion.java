public class FindSolutionRecursion {

    public static void main(String[] args) {
        int target = 114;
        System.out.println(find(1, "1", target));
    }

    public static String find(int current, String history, int target) {
        if (current == target) {
            return history;
        } else if (current > target) {
            return null;
        }
        String found = find(current + 5, "(" + history + " + 5)", target);
        if (found == null) {
            return find(current * 3, "(" + history + " * 3)", target);
        } else {
            return found;
        }
    }
}