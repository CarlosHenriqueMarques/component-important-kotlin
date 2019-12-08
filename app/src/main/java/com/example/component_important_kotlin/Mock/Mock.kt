package com.example.component_important_kotlin.Mock

class Mock private constructor(){
    companion object{
        fun getList(): List<String>{
            return listOf("Gramas","Kg","Toneladas")
        }
    }

}