package Kakao;

/* http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

6. 프렌즈4블록(난이도: 상)
블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 “프렌즈4블록”.
같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.

만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다.
같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.

블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.

만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.

위 초기 배치를 문자로 표시하면 아래와 같다.
 TTTANT
 RRFACC
 RRRFCC
 TRRRAA
 TTMMMF
 TMMTTJ
각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다
입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.

입력 형식
 - 입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
 - 2 ≦ n, m ≦ 30
 - board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.

출력 형식
 - 입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.

입출력 예제
m	n	board	answer
4	5	[“CCBDE”, “AAADE”, “AAABF”, “CCBBF”]	14
6	6	[“TTTANT”, “RRFACC”, “RRRFCC”, “TRRRAA”, “TTMMMF”, “TMMTTJ”]	15

예제에 대한 설명
입출력 예제 1의 경우, 첫 번째에는 A 블록 6개가 지워지고, 두 번째에는 B 블록 4개와 C 블록 4개가 지워져, 모두 14개의 블록이 지워진다.
입출력 예제 2는 본문 설명에 있는 그림을 옮긴 것이다. 11개와 4개의 블록이 차례로 지워지며, 모두 15개의 블록이 지워진다.
*/

import java.util.LinkedList;
import java.util.List;

public class Friends4Block {
    static List<String[]> boardList = new LinkedList<String[]>();

    public static void main(String[] args) {
//        calculator(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        calculator(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
    }

    public static int calculator(int m, int n, String[] board) {
        if(m < 2 || m > 30 || n < 2 || n > 30) throw new RuntimeException("m n Number Error");

        // 이차원 배열 생성
        boardList.clear();
        for (int i = 0; i < m; i++) {
            String[] tmpList = new String[n];
            char[] c = board[i].toCharArray();
            for (int j = 0; j < n; j++) tmpList[j] = String.valueOf(c[j]);
            boardList.add(tmpList);
        }
        int erasureBlockCnt = 0;
        int tmpCount = 0;
        do {
            tmpCount = actionExecute();
            erasureBlockCnt += tmpCount;
        } while (tmpCount > 0);

        System.out.println("총 제거된 블럭 " + erasureBlockCnt);
        return erasureBlockCnt;
    }

    // 액션수행
    public static int actionExecute() {
        int erasureBlockCnt = 0;

        // 2x2 배열 체크
        for (int i = 0; i < boardList.size(); i++) {
            for (int j = 0; j < (boardList.get(i)).length; j++) {
                if(i+1 < boardList.size() && j+1 < (boardList.get(i)).length) {
                    if(!(boardList.get(i))[j].isEmpty()
                            && (boardList.get(i))[j].replace("[del]","").equals((boardList.get(i))[j+1].replace("[del]",""))
                            && (boardList.get(i))[j].replace("[del]","").equals((boardList.get(i+1))[j].replace("[del]",""))
                            && (boardList.get(i))[j].replace("[del]","").equals((boardList.get(i+1))[j+1].replace("[del]",""))
                            ) {
                        (boardList.get(i))[j] = (boardList.get(i))[j]+"[del]";
                        (boardList.get(i))[j+1] = (boardList.get(i))[j]+"[del]";
                        (boardList.get(i+1))[j] = (boardList.get(i))[j]+"[del]";
                        (boardList.get(i+1))[j+1] = (boardList.get(i))[j]+"[del]";

                    }
                }
            }
        }
        // 2x2 배열 제거
        for (int i = 0; i < boardList.size(); i++) {
            for (int j = 0; j < (boardList.get(i)).length; j++) {
                if((boardList.get(i))[j].contains("[del]")) {
                    (boardList.get(i))[j] = "";
                    erasureBlockCnt++;
                }
            }
        }
        // 2x2 빈공간 채움
        for (int i = boardList.size()-1; i > 1; i--) {
            for (int j = 0; j < (boardList.get(i)).length; j++) {
                if((boardList.get(i))[j].isEmpty()) {
                    for (int k = i-2; k >= 0; k--) {
                        if(!(boardList.get(k))[j].isEmpty()) {
                            (boardList.get(i))[j] = (boardList.get(k))[j];
                            (boardList.get(k))[j] = "";
                            break;
                        }
                    }
                }
            }
        }
        return erasureBlockCnt;
    }
}