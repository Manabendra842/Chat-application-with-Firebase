package com.example.flarechat.models

class Post( val text: String="",
            val createdBy: User =User(),
            val createdAt: Long=0L,
            val likedBy: ArrayList<String> =ArrayList()
)



