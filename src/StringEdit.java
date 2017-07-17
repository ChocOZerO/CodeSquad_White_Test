import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Taehyeon Jake LEE on 2017-07-17.
 */
public class StringEdit {
    public static void main(String[] args) {
        /*
        다음 조건을 만족하는 프로그램을 작성하시오.

        입력: 주어진 문장을 입력 받는다.

        출력:
        (필수)문장의 단어를 역순으로 출력한다.
        (필수)문장에 포함되어 있는 알파벳의 전체 수를 출력한다.
        (선택)문장에 사용된 알파벳의 숫자를 최상위 빈도로 출력한다.

        예)
        입력:
        Do you know Doctor who?

        출력:
        who Doctor know you Do?
        전체 수 : 18
        o: 6
        w: 2
        ... (생략)

        힌트:
        문제에서 불명확한 부분은 자연스러운 형태로 가정하고 제출할 것.
        String의 split() 메소드를 활용해 공백 문자 기준으로 문자열을 분리할 수 있다.
        String의 length() 메소드를 통해 문자열의 길이를 구할 수 있다.
        */
        System.out.println("입력:");
        Scanner sc = new Scanner(System.in);

        String inSentence = sc.nextLine();
        int sentenceLen = inSentence.length();

        String lastSign = String.valueOf(inSentence.charAt(sentenceLen-1));
        if (!lastSign.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]")) {
            inSentence = inSentence.substring(0, sentenceLen-1);
        } else {
            lastSign = "";
        }

        String[] words = inSentence.split(" ");
        String outSentence = "";
        int totalCount = 0;
        HashMap<Character, Integer> alphabetCountMap = new HashMap<Character, Integer>();
        for (int i = words.length - 1; i >= 0 ; i--) {
            if (i != words.length - 1) {
                outSentence += " ";
            }
            outSentence += words[i];
            for (int j = 0; j < words[i].length(); j++) {
                totalCount += 1;
                char alphabet = words[i].charAt(j);
                if (alphabetCountMap.containsKey(alphabet)) {
                    alphabetCountMap.put(alphabet, alphabetCountMap.get(alphabet)+1);
                } else {
                    alphabetCountMap.put(alphabet, 1);
                }
            }
        }
        System.out.println("\n출력:");
        System.out.println(outSentence+lastSign);
        System.out.println("전체 수 : " + totalCount);

        while (alphabetCountMap.size() != 0) {
            int maxCount = 0;
            char maxAlphabet = '?';
            for (Character alphabetKey : alphabetCountMap.keySet()) {
                int alphabetCount = alphabetCountMap.get(alphabetKey);
                if (maxCount < alphabetCount) {
                    maxCount = alphabetCount;
                    maxAlphabet = alphabetKey;
                }
            }
            System.out.println(String.valueOf(maxAlphabet) + ": " + alphabetCountMap.get(maxAlphabet));
            alphabetCountMap.remove(maxAlphabet);
        }



    }
}
