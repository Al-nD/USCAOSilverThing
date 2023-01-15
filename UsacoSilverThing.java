import java.util.*;

public class UsacoSilverThing {
static long totalContribution = 0;
static int numElements;
static void addContribution(int[] heights) {
Stack<Integer> stack = new Stack<>();
for (int i = numElements - 1; i >= 0; i--) {
while (!stack.empty() && heights[stack.peek()] < heights[i]) {
stack.pop();
}
if (!stack.empty()) {
totalContribution += stack.peek() - i + 1;
}
stack.push(i);
}
}

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
numElements = sc.nextInt();
int[] heights = new int[numElements];
for (int i = 0; i < numElements; i++) {
heights[i] = sc.nextInt();
}
addContribution(heights);
int[] reversedHeights = new int[numElements];
for (int i = 0; i < numElements; i++) {
reversedHeights[numElements - 1 - i] = heights[i];
}
addContribution(reversedHeights);
System.out.println(totalContribution);
}
}