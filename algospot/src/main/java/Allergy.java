import java.util.*;

public class Allergy {
    private static int friendsCnt;
    private static int menuCount;
    private static String[][] canEatArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < testCnt; t++) {
            friendsCnt = sc.nextInt();
            menuCount = sc.nextInt();
            sc.nextLine();
            for (int f = 0; f < friendsCnt; f++) {
                sc.next();
            }
            sc.nextLine();
            canEatArr = new String[50][50];
            for (int m = 0; m < menuCount; m++) {
                int catEatCnt = sc.nextInt();
                for (int ce = 0; ce < catEatCnt; ce++) {
                    canEatArr[m][ce] = sc.next();
                }
                sc.nextLine();
            }
            System.out.println(selectMenu(new Stack<>(), 0));
        }
        sc.close();
    }

    private static int selectMenu(Stack<Integer> selected, int menuIdx) {
        if (menuIdx == menuCount) {
            if(canEverybodyEat(selected)) {
                return selected.size();
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int result = selectMenu(selected, menuIdx + 1);
        selected.push(menuIdx);
        result = Math.min(result, selectMenu(selected, menuIdx + 1));
        selected.pop();
        return result;
    }

    private static boolean canEverybodyEat(Stack<Integer> selected) {
        Set<String> canEatSet = new HashSet<>();
        for (Integer menuIdx : selected) {
            for (String canEat : canEatArr[menuIdx]) {
                if (canEat != null) {
                    canEatSet.add(canEat);
                }
            }
        }
        return canEatSet.size() == friendsCnt;
    }
}