package com.example

import com.example.utils.sparkUtil
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.sql.expressions.Window
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.types.{ StringType, StructField, StructType, IntegerType }
import org.apache.spark.rdd.RDD
import scala.io.Source
import org.apache.spark.{ SparkConf, SparkContext }

object Monday {
    def main(args: Array[String]): Unit = {
    
    
  // Set the price of apples and oranges in pence
val APPLE_PRICE = 60
val ORANGE_PRICE = 25

def checkout(items: List[String]): String = {
  // Initialize total cost to zero
  var totalCost = 0
  
  // Count the number of apples in the list of items
  val Applecount = items.count(_ == "Apple")
  
  //Calculate the cost of apples
  //val appleCost = Applecount * APPLE_PRICE
  
    //Step 2: Offer 1
    //Calculate the cost of apples after the "buy one get one free" offer
    val appleCost = (Applecount / 2 + Applecount % 2) * APPLE_PRICE
    
  // Count the number of oranges in the list of items
  val OrangeCount = items.count(_ == "Orange")
  
  //Calculate the cost of oranges
  //val orangeCost = OrangeCount * ORANGE_PRICE
    
    //Step 2: Offer 2
    // Calculate the cost of oranges after the "3 for the price of 2" offer or "Buy 2 get 1 free" offer
    val orangeCost = (OrangeCount / 3 * 2 + OrangeCount % 3) * ORANGE_PRICE
  
  // Calculate the total cost of all items
  totalCost = appleCost + orangeCost
  
  // Convert the total cost to pounds and pence
  val pounds = totalCost / 100
  val pence = totalCost % 100
  
  // Return the total cost as a string in pounds and pence format
  s"Total cost: $pounds.${pence} pounds"
}
  
  
  // Example for Step1:
  //val items = List("Apple", "Apple" ,"Orange", "Apple", "Apple")
    //println(checkout(items)) //Total cost: 2.65 pounds
    
    //Example for Step2:
val items = List( "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Orange")
    println(checkout(items)) //Total cost: 1.95 pounds
        
    }
}
