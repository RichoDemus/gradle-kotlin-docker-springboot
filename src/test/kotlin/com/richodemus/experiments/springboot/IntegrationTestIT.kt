package com.richodemus.experiments.springboot

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import java.net.URL

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTestIT {

    @LocalServerPort
    private val port: Int = 0

    private var base: URL? = null

    @Autowired
    private val template: TestRestTemplate? = null

    @Before
    fun setUp() {
        this.base = URL("http://localhost:$port/")
    }

    @Test
    fun getHello() {
        val response = template!!.getForEntity(base!!.toString(),
                String::class.java)
        assertThat(response.body, equalTo("Greetings from Spring Boot!"))
    }
}
