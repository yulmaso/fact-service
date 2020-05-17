package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.News
import com.yulmaso.fact.factservice.model.enums.Role
import com.yulmaso.fact.factservice.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/news")
class NewsController {
    @Autowired
    private lateinit var service: NewsService

    @GetMapping("/{id}")
    fun getNews(@PathVariable("id") id: Long) = service.getById(id)

    @GetMapping
    fun getAllNews(): List<News> = service.getAll()

    @Secured("ROLE_ADMIN")
    @PostMapping
    fun saveNews(@RequestBody news: News) = service.save(news)

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    fun removeNews(@PathVariable("id") id: Long) = service.remove(id)
}