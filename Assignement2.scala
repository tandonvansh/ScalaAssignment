case class PlayerStats(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int)

object Main2 {
  def main(args: Array[String]): Unit = {
    val playerStats = Array(
      PlayerStats(2021, "Sam", "India", 23, 230, 3),
      PlayerStats(2021, "Ram", "India", 23, 105, 30),
      PlayerStats(2021, "Mano", "India", 23, 280, 13),
      PlayerStats(2021, "Raj", "India", 23, 330, 10),
      PlayerStats(2021, "Rahul", "India", 25, 350, 5),
      PlayerStats(2021, "Ravi", "India", 29, 489, 3),
      PlayerStats(2021, "Abhishek", "India", 43, 502, 56)
    )

    // Player with the highest run scored
    val playerWithHighestRuns = getPlayerWithHighestRuns(playerStats)
    println(s"Player with the highest runs: ${playerWithHighestRuns.playerName}, Runs: ${playerWithHighestRuns.runs}")

    // Top 5 players by run scored
    val topPlayersByRuns = getTopPlayersByRuns(playerStats, 5)
    println("\nTop 5 players by run scored:")
    topPlayersByRuns.foreach(player => println(s"Name: ${player.playerName}, Runs: ${player.runs}"))

    // Top 5 players by wickets taken
    val topPlayersByWickets = getTopPlayersByWickets(playerStats, 5)
    println("\nTop 5 players by wickets taken:")
    topPlayersByWickets.foreach(player => println(s"Name: ${player.playerName}, Wickets: ${player.wickets}"))

    // Rank players with overall performance
    val playersRankedOverall = rankPlayersOverall(playerStats)
    println("\nRanking players with overall performance:")
    playersRankedOverall.foreach(player => println(s"Name: ${player.playerName}, Runs: ${player.runs}, Wickets: ${player.wickets} , Overall Rating: ${calculateRating(player)} "))
  }

  def getPlayerWithHighestRuns(playerStats: Array[PlayerStats]): PlayerStats = {
    playerStats.maxBy(_.runs)
  }

  def getTopPlayersByRuns(playerStats: Array[PlayerStats], n: Int): Array[PlayerStats] = {
    playerStats.sortBy(_.runs)(Ordering[Int].reverse).take(n)
  }

  def getTopPlayersByWickets(playerStats: Array[PlayerStats], n: Int): Array[PlayerStats] = {
    playerStats.sortBy(_.wickets)(Ordering[Int].reverse).take(n)
  }

  def rankPlayersOverall(playerStats: Array[PlayerStats]): Array[PlayerStats] = {
    playerStats.sortBy(player => (player.wickets * 5) + (player.runs * 0.05))(Ordering[Double].reverse)
  }

  def calculateRating(player: PlayerStats): Double = {
    val weightedRuns = 0.05
    val weightedWickets = 5
    (player.runs * weightedRuns) + (player.wickets * weightedWickets)
  }
}
