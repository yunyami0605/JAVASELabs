package mylab.publish.control;

import mylab.publish.entity.*;
import java.text.DecimalFormat;
import java.util.*;

public class StatisticsAnalyzer {
	public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        for (String type : avgPrice.keySet()) {
            System.out.printf("   - %s: %s원\n", type, df.format(avgPrice.get(type)));
        }

        System.out.println("2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.printf("   - %s: %.2f%%\n", type, distribution.get(type));
        }

        System.out.println("3. 2007년에 출판된 출판물 비율: " + String.format("%.2f%%", calculatePublicationRatioByYear(publications, "2007")));
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
    	
    	/*
    	 * 출판물 배열을 분석하여 출판물 타입별 평균 가격을 계산합니다.
    	 * HashMap을 활용하여 각 타입별 총 가격과 개수를 기록합니다.
    	 * 각 출판물에 대해 타입을 확인하고(getPublicationType 메서드 사용), 해당 타입의 총 가격과 개수를 누적합니다.
    	 * getOrDefault 메서드를 사용하여 맵에 키가 없는 경우 기본값을 설정합니다.
    	 * 누적된 데이터를 바탕으로 타입별 평균 가격을 계산하여 새로운 맵에 저장하고 반환합니다.
    	 * */
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgMap = new HashMap<>();
        for (String type : sumMap.keySet()) {
            avgMap.put(type, sumMap.get(type) / (double) countMap.get(type));
        }
        return avgMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
    	/*
    	 * 출판물 배열을 분석하여 각 타입별 비율(백분율)을 계산합니다.
    	 * 각 출판물의 타입을 확인하고, 타입별 개수를 HashMap에 기록합니다.
    	 * 전체 출판물 개수(배열 길이)를 기준으로 각 타입의 백분율을 계산합니다.
    	 * 계산된 백분율을 맵에 저장하여 반환합니다.
    	 * */
        Map<String, Integer> countMap = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            distMap.put(type, 100.0 * countMap.get(type) / publications.length);
        }
        return distMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
    	/*
    	 * 입력 받은 연도에 출판된 출판물의 비율을 계산합니다.
    	 * 각 출판물의 출판일자에서 연도 부분(처음 4자리)을 추출하여 지정된 연도와 일치하는지 확인합니다.
    	 * 일치하는 출판물의 개수를 세어 전체 대비 백분율을 계산하고 반환합니다.
    	 * 출판일자 형식은 "yyyy-mm-dd"로 가정합니다.
    	 * */
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return 100.0 * count / publications.length;
    }

    private String getPublicationType(Publication pub) {
    	
    	/*
    	 * 출판물 객체의 실제 타입을 확인하여 해당하는 한글 타입명을 반환합니다.
    	 * instanceof 연산자를 사용하여 객체 타입을 확인합니다: 
    	 * Novel 타입: "소설" 반환
    	 * Magazine 타입: "잡지" 반환
    	 * ReferenceBook 타입: "참고서" 반환
    	 * 그 외: "기타" 반환
    	 * */
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }
}
