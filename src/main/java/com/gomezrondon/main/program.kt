package com.gomezrondon.main

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File

fun main(searchTerm: String) {
    //chrome webdriver is set in the path of the program
    val driver: WebDriver = ChromeDriver()
    driver.get("https://duckduckgo.com/")

    //1) get the search box
    val search_box = driver.findElement(By.name("q"))
    //2) set the term to search
    search_box.sendKeys(searchTerm)
    //3) submit the search
    search_box.submit()

    println(driver.currentUrl)
    // print all links results
    val elements = driver.findElements(By.xpath("""//*[starts-with(@id,'r1-')]"""))
    var list = mutableListOf<String>()
    elements.forEach {
//        println(it.getAttribute("href"))
//        list.add(it.getAttribute("href").toString() )
//        println(it.text)
//        list.add(it.getAttribute("href"))
        list.add(it.text)
    }

    File("search-results.txt").delete()

    list.forEach {link ->
        File("search-results.txt").appendText(link+"\n")
    }


    // close the browser
    driver.quit()
    println("Search result ended!")
}