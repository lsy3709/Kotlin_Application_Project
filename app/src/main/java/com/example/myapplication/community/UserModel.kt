package com.example.myapplication.community

/**
 * 회원가입시에 유저의 데이터 형식을 firebase에 보내는 데이터 클래스
 */
class UserModel (
    var name: String = "",
    var nickname: String = "",
    var phone : String = "",
    var id : String = "",
    var password : String = "",
    val profileuri : String = ""
)