package com.tistory.povia.tacos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TacosApplication

fun main(args: Array<String>) {
	runApplication<TacosApplication>(*args)
}