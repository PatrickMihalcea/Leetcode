// Hard. Stacks.
// Not the most efficient but passes all tests. Studied solution and now understand how to more efficiently solve.
// June 9 2023.
class Solution {

    List<int[]> rects = new ArrayList<>(); // Rectangles are saved as base, height pairs.
    int maxArea = 0;
    int prevHeight = 0;

    public int largestRectangleArea(int[] heights) {
        int curHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            int baseCounter = 0;
            curHeight = heights[i];
            baseCounter++;
            while ((i < heights.length-1) && (heights[i+1] == curHeight)) {
                baseCounter++;
                i++;
            }
            makeRects(rects, curHeight, baseCounter, heights.length - 1 - i);
        }
        return maxArea;
    }

    public void makeRects(List<int[]> rects, int h, int b, int remainingHeights) {
        if (h == 0) {
            rects.clear();
            prevHeight = 0;
            return;
        }

        int rectHeightTracker = 0;

        for (int i = 0; i < rects.size(); i++) {
            // Get the current rectangle's base and height.
            int[] rectArr = rects.get(i);

            // Remove rectangles with the same height as they must have shorter bases as they come.
            if (rectArr[1] == rectHeightTracker) {
                rects.remove(i);
                i--;
                continue;
            }
            
            // Set the heightTracker.
            rectHeightTracker = rectArr[1];

            if (h < rectArr[1]) {
                rects.get(i)[1] = h;
            }
            rects.get(i)[0] += b;
            maxArea = Math.max(maxArea, rects.get(i)[0] * rects.get(i)[1]);

            // Remove rects that will never surpass maxArea so far.
            if ((rects.get(i)[0] + remainingHeights) * rects.get(i)[1] <= maxArea) {
                rects.remove(i);
                i--;
            }
        }

        // Add the column as its own rectangle if it is taller than the previous.
        if (h > prevHeight) {
            rects.add(new int[] {b, h});
            maxArea = Math.max(maxArea, b*h);
        }

        prevHeight = h;
    }
}
