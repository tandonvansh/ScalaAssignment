object Bucketiser {

//  method to bucketise the array of double values
  def bucketise(array: Array[Double]): Array[String] = {
    array.map { num =>
//      multiplying and dividing by 20 to get the lower bound of the bucket (0.05 * 20 = 1)
      val lowerBound = (num * 20).toInt / 20.0
      f"$lowerBound%.3f-${lowerBound + 0.049}%.3f"
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = { 
    val sampleArray = Array(12.05, 12.03, 10.33, 11.45, 13.50 , 23.46)
    val output = Bucketiser.bucketise(sampleArray)
    println("Bucketised Output:")
    output.foreach(println)
  }
}





