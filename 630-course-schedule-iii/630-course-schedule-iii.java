class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(c1,c2)-> c1[1] - c2[1]); //process less deadline courses firstly
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        
        int totalTime = 0;
        for(int[] course: courses){
            totalTime += course[0];
            q.add(course[0]);
            if(totalTime>course[1]){ //if totalTime crossed deadline for this course, then remove the course with more
                totalTime = totalTime - q.poll(); //duration from queue
            }
        }
        return q.size();
    }
}