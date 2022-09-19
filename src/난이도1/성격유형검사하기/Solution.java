package 난이도1.성격유형검사하기;

import java.util.Arrays;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //R,T,C,F,J,M,A,N
        int[] point = {0,0,0,0,0,0,0,0};

        for (int i =0; i<survey.length; i++) {

            switch (survey[i]) {
                case "RT":
                    if (choices[i] == 1) {
                        point[0] = point[0] + 3;
                    } else if (choices[i] == 2) {
                        point[0] = point[0] + 2;
                    } else if (choices[i] == 3) {
                        point[0] = point[0] + 1;
                    } else if (choices[i] == 5) {
                        point[1] = point[1] + 1;
                    } else if (choices[i] == 6) {
                        point[1] = point[1] + 2;
                    } else if (choices[i] == 7) {
                        point[1] = point[1] + 3;
                    }
                    break;

                case "TR":
                    if (choices[i] == 1) {
                        point[1] = point[1] + 3;
                    } else if (choices[i] == 2) {
                        point[1] = point[1] + 2;
                    } else if (choices[i] == 3) {
                        point[1] = point[1] + 1;
                    } else if (choices[i] == 5) {
                        point[0] = point[0] + 1;
                    } else if (choices[i] == 6) {
                        point[0] = point[0] + 2;
                    } else if (choices[i] == 7) {
                        point[0] = point[0] + 3;
                    }
                    break;

                case "CF":
                    if (choices[i] == 1) {
                        point[2] = point[2] + 3;
                    } else if (choices[i] == 2) {
                        point[2] = point[2] + 2;
                    } else if (choices[i] == 3) {
                        point[2] = point[2] + 1;
                    } else if (choices[i] == 5) {
                        point[3] = point[3] + 1;
                    } else if (choices[i] == 6) {
                        point[3] = point[3] + 2;
                    } else if (choices[i] == 7) {
                        point[3] = point[3] + 3;
                    }
                    break;

                case "FC":
                    if (choices[i] == 1) {
                        point[3] = point[3] + 3;
                    } else if (choices[i] == 2) {
                        point[3] = point[3] + 2;
                    } else if (choices[i] == 3) {
                        point[3] = point[3] + 1;
                    } else if (choices[i] == 5) {
                        point[2] = point[2] + 1;
                    } else if (choices[i] == 6) {
                        point[2] = point[2] + 2;
                    } else if (choices[i] == 7) {
                        point[2] = point[2] + 3;
                    }
                    break;

                case "JM":
                    if (choices[i] == 1) {
                        point[4] = point[4] + 3;
                    } else if (choices[i] == 2) {
                        point[4] = point[4] + 2;
                    } else if (choices[i] == 3) {
                        point[4] = point[4] + 1;
                    } else if (choices[i] == 5) {
                        point[5] = point[5] + 1;
                    } else if (choices[i] == 6) {
                        point[5] = point[5] + 2;
                    } else if (choices[i] == 7) {
                        point[5] = point[5] + 3;
                    }
                    break;

                case "MJ":
                    if (choices[i] == 1) {
                        point[5] = point[5] + 3;
                    } else if (choices[i] == 2) {
                        point[5] = point[5] + 2;
                    } else if (choices[i] == 3) {
                        point[5] = point[5] + 1;
                    } else if (choices[i] == 5) {
                        point[4] = point[4] + 1;
                    } else if (choices[i] == 6) {
                        point[4] = point[4] + 2;
                    } else if (choices[i] == 7) {
                        point[4] = point[4] + 3;
                    }
                    break;

                case "AN":
                    if (choices[i] == 1) {
                        point[6] = point[6] + 3;
                    } else if (choices[i] == 2) {
                        point[6] = point[6] + 2;
                    } else if (choices[i] == 3) {
                        point[6] = point[6] + 1;
                    } else if (choices[i] == 5) {
                        point[7] = point[7] + 1;
                    } else if (choices[i] == 6) {
                        point[7] = point[7] + 2;
                    } else if (choices[i] == 7) {
                        point[7] = point[7] + 3;
                    }
                    break;

                case "NA":
                    if (choices[i] == 1) {
                        point[7] = point[7] + 3;
                    } else if (choices[i] == 2) {
                        point[7] = point[7] + 2;
                    } else if (choices[i] == 3) {
                        point[7] = point[7] + 1;
                    } else if (choices[i] == 5) {
                        point[6] = point[6] + 1;
                    } else if (choices[i] == 6) {
                        point[6] = point[6] + 2;
                    } else if (choices[i] == 7) {
                        point[6] = point[6] + 3;
                    }
                    break;
            }
        }

        String[] pointResult = {"", "", "", ""};
        if (point[0] > point[1]) {
            pointResult[0] = "R";
        } else if (point[0] == point[1]) {
            pointResult[0] = "R";
        } else {
            pointResult[0] = "T";
        }

        if (point[2] > point[3]) {
            pointResult[1] = "C";
        } else if (point[2] == point[3]) {
            pointResult[1] = "C";
        } else {
            pointResult[1] = "F";
        }

        if (point[4] > point[5]) {
            pointResult[2] = "J";
        } else if (point[4] == point[5]) {
            pointResult[2] = "J";
        } else {
            pointResult[2] = "M";
        }

        if (point[6] > point[7]) {
            pointResult[3] = "A";
        } else if (point[6] == point[7]) {
            pointResult[3] = "A";
        } else {
            pointResult[3] = "N";
        }

        System.out.println(Arrays.toString(point));
        System.out.println(Arrays.toString(pointResult));

        return pointResult[0]+pointResult[1]+pointResult[2]+pointResult[3];
    }
}