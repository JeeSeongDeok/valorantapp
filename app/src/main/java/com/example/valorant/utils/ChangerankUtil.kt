package com.example.valorant.utils

object ChangerankUtil {
    private val rankList = mutableListOf<String>(
            "언랭크", "1", "2",
            "아이언 1", "아이언 2", "아이언 3",
            "브론즈 1", "브론즈 2", "브론즈 3",
            "실버 1", "실버 2", "실버 3",
            "골드 1", "골드 2", "골드 3",
            "플래티넘 1", "플래티넘 2", "플래티넘 3",
            "다이아몬드 1", "다이아몬드 2", "다이아몬드 3",
            "불멸", "불멸", "불멸",
            "레디언트"
    )

    fun getRank(mmrIndex: Int): String {
        return rankList[mmrIndex]
    }
}