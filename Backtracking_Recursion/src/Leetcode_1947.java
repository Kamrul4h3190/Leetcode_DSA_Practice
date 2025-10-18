public class Leetcode_1947 {
    public static void main(String[] args) {
        Leetcode_1947 app = new Leetcode_1947();
        int[][] students = {{1,1,0}, {1,0,1}, {0,0,1}}, mentors = {{1,0,0}, {0,0,1}, {1,1,0}};
        System.out.println("max compatibility score sum : "+app.maxCompatibilitySum(students,mentors));
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = mentors.length; n = students[0].length;
        mentorTaken = new boolean[m];
        selectBestMentor(0,0,students,mentors);
        return maxMatchingScore;
    }
    int maxMatchingScore =0;
    int m,n;//m=number of mentors/students , n=number of survey questions
    boolean[] mentorTaken; //for tack/release mentors to explore best match mentor
    public void selectBestMentor(int studentId, int score,int[][] students, int[][] mentors){
        if(studentId >= m){
            maxMatchingScore = Math.max(maxMatchingScore, score);//maximize sum of matching scores after a path explored completely
            return;
        }
        for(int mentorId = 0; mentorId < m ; mentorId++){
            if (mentorTaken[mentorId]) continue; //if this mentor is booked along this path skip, search next mentor

            mentorTaken[mentorId] = true;// book mentor
            selectBestMentor(studentId+1, score+ matchingScore( students[studentId],mentors[mentorId] ) ,students,mentors); //explore further after the current booking
            mentorTaken[mentorId] = false;// release mentor
        }
    }
    public int matchingScore(int[] studentAnswer, int[] mentorAnswer){
        int score = 0;
        for(int i = 0; i < n; i++) if(studentAnswer[i] == mentorAnswer[i]) score++;
        return score;
    }
}

