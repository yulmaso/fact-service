package com.yulmaso.fact.factservice.config

import org.apache.commons.dbcp.BasicDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.io.IOException
import java.lang.IllegalArgumentException
import java.util.*
import javax.annotation.Resource
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories("com.yulmaso.fact.factservice.repository")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.yulmaso.fact.factservice")
class DatabaseConfig {

    @Resource
    private var env: Environment? = null

    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSource()
        em.setPackagesToScan(env?.getRequiredProperty("db.entity.package"))
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()
        em.setJpaProperties(getHibernateProperties())
        return em
    }

    @Bean
    fun transactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory().`object`
        return transactionManager
    }

    private fun getHibernateProperties(): Properties {
        try {
            val properties = Properties()
            val inputStream = this.javaClass.classLoader.getResourceAsStream("hibernate.properties")
            properties.load(inputStream)
            return properties
        } catch (e: IOException) {
            throw IllegalArgumentException("Can't find 'hibernate.properties' in the classpath ", e)
        }
    }

    @Bean
    fun dataSource(): DataSource {
        val ds = BasicDataSource()
        ds.driverClassName = env?.getRequiredProperty("db.driver")
        ds.url = env?.getRequiredProperty("db.url")
        ds.username = env?.getRequiredProperty("db.username")
        ds.password = env?.getRequiredProperty("db.password")

        ds.initialSize = Integer.valueOf(env?.getRequiredProperty("db.initialSize"))
        ds.minIdle = Integer.valueOf(env?.getRequiredProperty("db.minIdle"))
        ds.maxIdle = Integer.valueOf(env?.getRequiredProperty("db.maxIdle"))
        ds.timeBetweenEvictionRunsMillis = env?.getRequiredProperty("db.timeBetweenEvictionRunsMillis")!!.toLong()
        ds.minEvictableIdleTimeMillis = env?.getRequiredProperty("db.minEvictableIdleTimeMillis")!!.toLong()
        ds.testOnBorrow = env?.getRequiredProperty("db.testOnBorrow")!!.toBoolean()
        ds.validationQuery = env?.getRequiredProperty("db.validationQuery")

        return ds
    }
}