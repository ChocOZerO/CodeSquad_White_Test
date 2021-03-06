import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Taehyeon Jake LEE on 2017-07-17.
 */
public class Baseball {
    public static void main(String[] args) {
        /*
        숫자 야구게임

        <숫자 야구게임 방식>
        기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
        같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼,
        같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,
        그 힌트를 이용해서 먼저 상대방의 수를 맞추면 승리한다.

        [예] 상대방의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크
             456을 제시한 경우 : 1 스트라이크 1볼 789를 제시한 경우 : 낫싱

        <요구사항>

        위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다.
        컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
        게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고,
        컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
        이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.


        <힌트>

        컴퓨터가 3개의 값을 선택할 때 Collections.shuffle()을 이용하면 편하다.
        반복문을 2중(반복문 안의 반복문)으로 사용하면 한번에 고려할 부분이 많다.
        2중 반복문을 1중 반복문 2개로 나누어 처리하는 방법은 없는지 고려해 본다.
        */
        ArrayList<Integer> computer = new ArrayList<Integer>();
        while (computer.size() < 3) {
            int newNum = (int)(Math.random() * 9) + 1;
            if (!computer.contains(newNum)) {
                computer.add(newNum);
            }
        }
        Collections.shuffle(computer);

        System.out.println("숫자야구게임");
        int strikeCount = 0;
        int ballCount;
        Scanner sc = new Scanner(System.in);
        while (strikeCount != 3) {
            System.out.println("1부터 9사이의 숫자로 이루어진 세자리 숫자를 입력해주세요.");
            String strGuessNum = sc.nextLine();
            if (strGuessNum.length() != 3) {
                continue;
            }
            String[] guessNum = strGuessNum.split("");
            strikeCount = 0;
            ballCount = 0;
            for (int i = 0; i < guessNum.length; i++) {
                int num = Integer.parseInt(guessNum[i]);
                if (num == computer.get(i)) {
                    strikeCount += 1;
                } else if (computer.contains(num)) {
                    ballCount += 1;
                }
            }
            String result = "";
            if (strikeCount > 0) {
                result += strikeCount + " 스트라이크 ";
            }
            if (ballCount > 0) {
                result += ballCount + " 볼";
            }
            if (strikeCount == 0 && ballCount == 0) {
                result += "낫싱";
            }
            System.out.println(result);
        }
        System.out.println("성공! 축하드립니다!");
    }
}
