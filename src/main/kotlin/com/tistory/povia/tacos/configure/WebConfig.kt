package com.tistory.povia.tacos.configure

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer{
  override fun addViewControllers(registry: ViewControllerRegistry) {
    super.addViewControllers(registry)
    // "/" 주소의 view 설정
    registry.addViewController("/").setViewName("home")
  }
}