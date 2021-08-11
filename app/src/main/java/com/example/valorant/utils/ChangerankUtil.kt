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
    // 불멸일 경우, 아닐 경우 함수
    private fun trueImmortal(): String = "https://media.valorant-api.com/competitivetiers/edb72a72-7e6d-6010-9591-7c053bbdbf48/23/largeicon.png"
    private fun falseImmortal(currentTier:Int): String =  "https://media.valorant-api.com/competitivetiers/edb72a72-7e6d-6010-9591-7c053bbdbf48/" + currentTier.toString() + "largeicon.png"

    fun getRank(mmrIndex: Int): String {
        return rankList[mmrIndex]
    }

    fun getRankIcon(mmrIndex:Int):String{
        return if(mmrIndex in 21..23){
            trueImmortal()
        }
        else{
            falseImmortal(mmrIndex)
        }
    }
}